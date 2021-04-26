package d.a.j0.q1.p;
/* loaded from: classes3.dex */
public class e extends f {
    public e(String str) {
        super(null, str);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        int i2 = this.mVideoTask.position;
        if (i2 > 0) {
            seekTo(i2);
        }
    }

    @Override // d.a.j0.q1.p.f, d.a.j0.q1.p.d, com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void release() {
        super.release();
        saveProgressToDb();
    }

    @Override // d.a.j0.q1.p.f, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void saveProgressToDb() {
    }

    @Override // d.a.j0.q1.p.d, com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        super.stop();
        saveProgressToDb();
    }
}
