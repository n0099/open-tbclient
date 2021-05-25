package d.a.n0.u1;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f61337a;

    /* renamed from: b  reason: collision with root package name */
    public long f61338b;

    /* renamed from: c  reason: collision with root package name */
    public long f61339c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61340d;

    public void a() {
        this.f61337a = 0L;
        this.f61338b = 0L;
        this.f61339c = 0L;
    }

    public void b() {
        this.f61339c = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.f61338b = SystemClock.elapsedRealtime();
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        if (this.f61340d) {
            this.f61340d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f61338b - this.f61337a;
            long j2 = elapsedRealtime - this.f61339c;
            long j3 = j2 + j;
            if ((d.a.c.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.O(j, j2, j3);
            }
        }
    }

    public void e() {
        this.f61340d = true;
        this.f61337a = SystemClock.elapsedRealtime();
    }
}
