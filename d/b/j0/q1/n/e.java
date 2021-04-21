package d.b.j0.q1.n;
/* loaded from: classes3.dex */
public class e extends f {
    public e(String str) {
        super(null, str);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        int i = this.mVideoTask.position;
        if (i > 0) {
            seekTo(i);
        }
    }

    @Override // d.b.j0.q1.n.f, d.b.j0.q1.n.d, com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void release() {
        super.release();
        saveProgressToDb();
    }

    @Override // d.b.j0.q1.n.f, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void saveProgressToDb() {
    }

    @Override // d.b.j0.q1.n.d, com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        super.stop();
        saveProgressToDb();
    }
}
