/**
 * Day 5 加练：把协程「用明白」
 *
 * 运行（先 Cmd+S）：
 *   gradle run -Pday=05 -Pmain=Day05PracticeKt
 *
 * 规则：主体自己写；已提供的 suspend 函数不用改。
 */

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

// ===== 已提供：模拟两个「慢请求」，各约 400ms =====
suspend fun loadLyric(songId: Int): String {
    delay(400)
    return "歌词#$songId"
}

suspend fun loadCover(songId: Int): String {
    delay(400)
    return "封面#$songId"
}

suspend fun loadRecommendIds(): List<Int> {
    delay(200)
    return listOf(1, 2, 3)
}

// ---------- 练习 A：顺序 vs 并行（理解为什么要用 async）----------

// TODO A1: 顺序加载 —— 先等歌词，再等封面
// 返回格式："歌词#1 | 封面#1"
suspend fun loadDetailSequential(songId: Int): String {
    TODO("先 loadLyric，再 loadCover，拼字符串返回")
}

// TODO A2: 并行加载 —— 两个请求一起开工
// 必须包在 coroutineScope { } 里，才能在 suspend 函数里用 async
// 返回格式同上
suspend fun loadDetailParallel(songId: Int): String {
    TODO("coroutineScope + 两个 async + await")
}

// ---------- 练习 B：launch = 做完就行，不拿返回值 ----------

// TODO B1: 点击播放后，后台加载歌词并 println，不需要返回给调用方
fun CoroutineScope.onPlayClicked(songId: Int) {
    TODO("launch { ... }")
}

// ---------- 练习 C：Flow = 数据一个一个来 ----------

// TODO C1: 把 ids 转成 Flow，每 emit 一个 id 后 delay(150)
fun recommendFlow(ids: List<Int>): Flow<Int> {
    TODO("flow { for (...) { emit(...); delay(150) } }")
}

// TODO C2: 收集 Flow；每收到 id，loadCover 后打印
suspend fun showRecommends(ids: List<Int>) {
    TODO("recommendFlow(ids).collect { ... }")
}

fun main() = runBlocking {
    println("===== 练习 A：看耗时差异 =====")
    // TODO A3: 用 measureTimeMillis 分别测 A1、A2，打印结果和耗时
    // 预期：顺序大约 800ms+，并行大约 400ms+（并行应明显更快）

    println("===== 练习 B：launch =====")
    // TODO B2: 调用 onPlayClicked(1)
    // 当前 main 在 runBlocking 里，直接 onPlayClicked(1) 即可

    // 给 launch 一点时间跑完再结束（否则程序可能过早退出）
    delay(500)

    println("===== 练习 C：Flow =====")
    // TODO C3: 先 loadRecommendIds()，再 showRecommends(ids)

    println("===== 加练结束 =====")
}
