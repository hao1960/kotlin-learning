/**
 * Day 1 练习：val/var、类型、函数、class
 *
 * 规则：主体代码自己写，卡住再问我。
 * 先把下面 TODO 补全，写完告诉我，我帮你看。
 */

// ---------- 1. 数据模型 ----------
// TODO: 定义 data class Song(id, name, singer)
data class Song(
    val id: Int,
    val name: String,
    val singer: String
)

// ---------- 2. 工具函数 ----------
// TODO: 写一个函数 printSongs(songs)，遍历打印每首歌
// 提示：for (song in songs) { ... }


fun printSongs(songs: List<Song>){
    for(song in songs){
        println(song)
    }
}
// TODO: 写一个函数 findByName(songs, keyword)，返回名字包含 keyword 的歌曲列表
// 提示：可用 mutableListOf + if，或后面 Day2 再用 filter
fun findByName(songs: List<Song>, keyword: String): List<Song>{
    val result=mutableListOf<Song>()//创建一个可变的空列表，val表示不能把result再指向另一个列表，但列表内容仍然可以修改
    for(song in songs){
        if(song.name.contains(keyword)){
            result.add(song)
        }
    }
    return result
}

// ---------- 3. 入口 ----------
fun main() {
    // TODO: 用 val 创建至少 3 首歌的列表
    // TODO: 调用 printSongs
    // TODO: 搜索某关键词并打印结果
    val songs=listOf(
    Song(1, "Song1", "Singer1"),
    Song(2,"Song2","Singer2"),
    Song(3,"Song3","Singer3")
    )
    printSongs(songs)

    val result=findByName(songs,"1")
    for(song in result){
        println(song)
    }
}
