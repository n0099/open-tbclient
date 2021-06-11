package d.a.n0.u1;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f65050a;

    /* renamed from: b  reason: collision with root package name */
    public long f65051b;

    /* renamed from: c  reason: collision with root package name */
    public long f65052c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65053d;

    public void a() {
        this.f65050a = 0L;
        this.f65051b = 0L;
        this.f65052c = 0L;
    }

    public void b() {
        this.f65052c = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.f65051b = SystemClock.elapsedRealtime();
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        if (this.f65053d) {
            this.f65053d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f65051b - this.f65050a;
            long j2 = elapsedRealtime - this.f65052c;
            long j3 = j2 + j;
            if ((d.a.c.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.O(j, j2, j3);
            }
        }
    }

    public void e() {
        this.f65053d = true;
        this.f65050a = SystemClock.elapsedRealtime();
    }
}
