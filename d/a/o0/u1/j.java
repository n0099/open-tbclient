package d.a.o0.u1;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f65175a;

    /* renamed from: b  reason: collision with root package name */
    public long f65176b;

    /* renamed from: c  reason: collision with root package name */
    public long f65177c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65178d;

    public void a() {
        this.f65175a = 0L;
        this.f65176b = 0L;
        this.f65177c = 0L;
    }

    public void b() {
        this.f65177c = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.f65176b = SystemClock.elapsedRealtime();
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        if (this.f65178d) {
            this.f65178d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f65176b - this.f65175a;
            long j2 = elapsedRealtime - this.f65177c;
            long j3 = j2 + j;
            if ((d.a.c.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.O(j, j2, j3);
            }
        }
    }

    public void e() {
        this.f65178d = true;
        this.f65175a = SystemClock.elapsedRealtime();
    }
}
