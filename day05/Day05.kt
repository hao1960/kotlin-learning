/**
 * Day 5 练习：协程 suspend / launch / async / Flow
 *
 * 目标：理解移动端“异步取数据 → 再更新 UI”的基本流程。
 * 运行：gradle run -Pday=05
 */

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

data class Song(
    val id: Int,
    val name: String,
    val singer: String
)

// ---------- 1. suspend：可挂起的函数（模拟网络请求）----------
// delay 只能在协程或另一个 suspend 里调用
suspend fun fetchSong(id: Int): Song {
    delay(500) // 模拟耗时 500ms，不阻塞整颗 CPU 线程的那种“死等”
    return Song(id, "晴天", "周杰伦")
}

suspend fun fetchSongName(id: Int): String {
    delay(300)
    return "歌曲#$id"
}

// ---------- 2. launch：开火就忘，不关心返回值 ----------
// TODO 1: 在 runBlocking 里 launch 一个协程
// 调用 fetchSong(1)，打印 "launch 拿到：..."
// 提示：
//   runBlocking {
//       launch {
//           val song = fetchSong(1)
//           println(...)
//       }
//   }


// ---------- 3. async：需要结果时用，await 取值 ----------
// TODO 2: 用 async 同时启动两个 fetchSongName(1) 和 fetchSongName(2)
// 分别 await 后打印两个名字
// 提示：
//   val a = async { fetchSongName(1) }
//   val b = async { fetchSongName(2) }
//   println(a.await())
//   println(b.await())

// ---------- 4. Flow：多个异步值的流 ----------
fun songIdFlow(): Flow<Int> = flow {
    emit(1)
    delay(200)
    emit(2)
    delay(200)
    emit(3)
}

// TODO 3: 收集 songIdFlow
// 每收到一个 id，调用 fetchSongName(id) 并打印
// 提示：
//   songIdFlow().collect { id ->
//       val name = fetchSongName(id)
//       println(name)
//   }

fun main() = runBlocking {
    println("=== Day5 开始 ===")

    // TODO 1: launch
    // TODO 2: async
    // TODO 3: Flow collect
    launch{
        val song = fetchSong(1)
        println("launch 拿到：$song")
    }

    val a=async{fetchSongName(1)}
    val b=async{fetchSongName(2)}
    println(a.await())
    println(b.await())

    songIdFlow().collect{id->
        val name=fetchSongName(id)
        println(name)
    }
    println("=== Day5 结束 ===")
}
