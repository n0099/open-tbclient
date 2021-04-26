package d.a.j0.t1;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f61206a;

    /* renamed from: b  reason: collision with root package name */
    public long f61207b;

    /* renamed from: c  reason: collision with root package name */
    public long f61208c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61209d;

    public void a() {
        this.f61206a = 0L;
        this.f61207b = 0L;
        this.f61208c = 0L;
    }

    public void b() {
        this.f61208c = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.f61207b = SystemClock.elapsedRealtime();
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        if (this.f61209d) {
            this.f61209d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f61207b - this.f61206a;
            long j2 = elapsedRealtime - this.f61208c;
            long j3 = j2 + j;
            if ((d.a.c.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.O(j, j2, j3);
            }
        }
    }

    public void e() {
        this.f61209d = true;
        this.f61206a = SystemClock.elapsedRealtime();
    }
}
