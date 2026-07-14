/**
 * Day 3 练习：interface / abstract class / extension function
 *
 * 目标：理解业务里为什么大量用接口。
 */

data class Song(
    val id: Int,
    val name: String,
    val singer: String
)

// ---------- 1. interface：只定义“能做什么”，不关心怎么做 ----------
interface Player {
    fun play(song: Song)
    fun stop()
}

// TODO 1: 实现 Player
// class LocalPlayer : Player { ... }
// play 时打印：正在本地播放：歌名 - 歌手
// stop 时打印：停止播放
class LocalPlayer : Player{
    override fun play(song: Song){
        println("正在本地播放：${song.name} - ${song.singer}")
    }
    override fun stop(){
        println("停止播放")
    }
}

// TODO 2: 再实现一个 Player
// class OnlinePlayer : Player { ... }
// play 时打印：正在在线播放：歌名 - 歌手
// stop 时打印：停止在线播放
class OnlinePlayer : Player{
    override fun play(song: Song){
        println("正在在线播放：${song.name} - ${song.singer}")
    }
    override fun stop(){
        println("停止在线播放")
    }
}

// ---------- 2. abstract class：可以有一部分已经写好的逻辑 ----------
abstract class BasePlayer : Player {
    protected var current: Song? = null

    // 子类共用的逻辑
    fun currentSongName(): String {
        return current?.name ?: "没有正在播放的歌曲"
    }

    // play/stop 仍由子类实现
}

// TODO 3: 写一个继承 BasePlayer 的类
// class RadioPlayer : BasePlayer() {
//   override fun play...
//   override fun stop...
// }
// 要求：play 时把 song 存进 current；stop 时清空 current 并打印
class RadioPlayer : BasePlayer(){
    override fun play(song: Song){
        current=song
    }
    override fun stop(){
        current=null
        println("停止播放")
    }
}

// ---------- 3. extension function：给已有类型“追加”方法 ----------
// TODO 4: 给 Song 写扩展函数
// fun Song.displayName(): String
// 返回格式："《晴天》 - 周杰伦"
fun Song.displayName(): String{
    return "《$name》 - $singer"
}

// ---------- 4. 入口：体会“面向接口编程” ----------
fun startPlay(player: Player, song: Song) {
    // 这里不关心传入的是 Local / Online / Radio
    player.play(song)
}

fun main() {
    val song = Song(1, "晴天", "周杰伦")

    // TODO 5: 分别创建 LocalPlayer、OnlinePlayer
    // 用 startPlay(player, song) 各调用一次
    // 再各自 stop()
    val localPlayer=LocalPlayer()
    val onlinePlayer=OnlinePlayer()
    startPlay(localPlayer, song)
    startPlay(onlinePlayer,song)
    localPlayer.stop()
    onlinePlayer.stop()
    // TODO 6: 创建 RadioPlayer，play 后打印 currentSongName()，再 stop，再打印 currentSongName()
    val radioPlayer=RadioPlayer()
    startPlay(radioPlayer,song)
    println(radioPlayer.currentSongName())
    radioPlayer.stop()
    println(radioPlayer.currentSongName())
    // TODO 7: println(song.displayName())
    println(song.displayName())
}
