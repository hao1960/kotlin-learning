/**
 * Day 4 练习：Lambda（函数作为参数）
 *
 * 目标：看懂业务里常见的 { } 回调写法。
 */

data class Song(
    val id: Int,
    val name: String,
    val singer: String
)

// ---------- 1. 函数类型：参数是另一个函数 ----------
// onClick 的类型：(Song) -> Unit
// 意思：接收一个 Song，不返回有用值（Unit ≈ void）
fun bindPlayButton(song: Song, onClick: (Song) -> Unit) {
    println("按钮已绑定：${song.name}")
    // 模拟用户点击
    onClick(song)
}

// ---------- 2. 高阶函数：自己接收 Lambda ----------
// TODO 1: 实现 forEachSong
// 遍历 songs，对每一首调用 action
fun forEachSong(songs: List<Song>, action: (Song) -> Unit) {
    //TODO("自己写 for 循环，循环里调用 action(song)")
    for(song in songs){
        action(song)
    }
}

// TODO 2: 实现 filterSongs（不要用自带的 filter，手写体会 Lambda）
fun filterSongs(songs: List<Song>, predicate: (Song) -> Boolean): List<Song> {
    //TODO("自己写：符合 predicate(song)==true 的放进结果列表")
    val result=mutableListOf<Song>()
    for(song in songs){
        if(predicate(song)){
            result.add(song)
        }
    }
    return result
}

// TODO 3: 实现 transformNames
// 把每首歌通过 transform 转成 String，返回 List<String>
fun transformNames(songs: List<Song>, transform: (Song) -> String): List<String> {
    //TODO("自己写")
    val result=mutableListOf<String>()
    for(song in songs){
        result.add(transform(song))
    }
    return result
}

fun main() {
    val songs = listOf(
        Song(1, "晴天", "周杰伦"),
        Song(2, "海阔天空", "Beyond"),
        Song(3, "七里香", "周杰伦")
    )

    // ----- 示例：三种等价写法（先读懂，不用改）-----
    // 写法 A：完整
    bindPlayButton(songs[0], { song ->
        println("点击播放：${song.name}")
    })

    // 写法 B：Lambda 在最后，可放到括号外（业务里最常见）
    bindPlayButton(songs[1]) { song ->
        println("点击播放：${song.name}")
    }

    // 写法 C：只有一个参数时可用 it
    bindPlayButton(songs[2]) {
        println("点击播放：${it.name}")
    }

    // TODO 4: 用 forEachSong 打印每首歌名
    // forEachSong(songs) { ... }
    forEachSong(songs){songs->
        println(songs.name)
    }
    // TODO 5: 用 filterSongs 找出周杰伦的歌并打印
    val jay = filterSongs(songs) {song->
        song.singer=="周杰伦"
    }
    println(jay)

    // TODO 6: 用 transformNames 得到 "《歌名》-歌手" 列表并打印
    val names = transformNames(songs) {songs->
        "《${songs.name}》- ${songs.singer}"
    }
    println(names)
}
