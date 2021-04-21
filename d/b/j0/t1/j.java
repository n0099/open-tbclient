package d.b.j0.t1;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f63000a;

    /* renamed from: b  reason: collision with root package name */
    public long f63001b;

    /* renamed from: c  reason: collision with root package name */
    public long f63002c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63003d;

    public void a() {
        this.f63000a = 0L;
        this.f63001b = 0L;
        this.f63002c = 0L;
    }

    public void b() {
        this.f63002c = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.f63001b = SystemClock.elapsedRealtime();
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        if (this.f63003d) {
            this.f63003d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f63001b - this.f63000a;
            long j2 = elapsedRealtime - this.f63002c;
            long j3 = j2 + j;
            if ((d.b.c.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.Q(j, j2, j3);
            }
        }
    }

    public void e() {
        this.f63003d = true;
        this.f63000a = SystemClock.elapsedRealtime();
    }
}
