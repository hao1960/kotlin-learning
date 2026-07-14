/**
 * Day 2 练习：集合 map / filter / find / sortedBy
 *
 * 规则：主体自己写。可复用 Day1 的 Song，或在本文件再定义一次。
 */

data class Song(
    val id: Int,
    val name: String,
    val singer: String,
    val genre: String // 新增：分类用，如 "流行" / "摇滚"
)

// TODO 1: 用 filter 实现搜索（歌名包含 keyword）
fun searchSongs(songs: List<Song>, keyword: String): List<Song> {
    //TODO("用 filter 写")
    return songs.filter{it.name.contains(keyword)}
}

// TODO 2: 用 filter 按歌手筛选
fun songsBySinger(songs: List<Song>, singer: String): List<Song> {
    //TODO("用 filter 写")
    return songs.filter{it.singer==singer}
}

// TODO 3: 用 map 只取出所有歌名，返回 List<String>
fun songNames(songs: List<Song>): List<String> {
    //TODO("用 map 写")
    return songs.map{it.name}
}

// TODO 4: 用 find 找第一首匹配歌名的歌（找不到返回 null）
fun findSong(songs: List<Song>, name: String): Song? {
    //TODO("用 find 写")
    return songs.find{it.name==name}
}

// TODO 5: 用 sortedBy 按 id 升序排序
fun sortById(songs: List<Song>): List<Song> {
    //TODO("用 sortedBy 写")
    return songs.sortedBy{it.id}
}

fun main() {
    val songs = listOf(
        Song(3, "晴天", "周杰伦", "流行"),
        Song(1, "海阔天空", "Beyond", "摇滚"),
        Song(2, "七里香", "周杰伦", "流行"),
        Song(4, "光辉岁月", "Beyond", "摇滚")
    )

    // TODO: 依次调用上面函数并 println 结果，自己验证对不对
    // 建议验证：
    // 1. searchSongs(songs, "天")
    // 2. songsBySinger(songs, "周杰伦")
    // 3. songNames(songs)
    // 4. findSong(songs, "七里香") 和 findSong(songs, "不存在")
    // 5. sortById(songs)
    println(searchSongs(songs, "天"))
    println(songsBySinger(songs, "周杰伦"))
    println(songNames(songs))
    println(findSong(songs, "七里香"))
    println(findSong(songs, "不存在"))
    println(sortById(songs))
}
