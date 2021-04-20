package d.b.i0.t1;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f62579a;

    /* renamed from: b  reason: collision with root package name */
    public long f62580b;

    /* renamed from: c  reason: collision with root package name */
    public long f62581c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62582d;

    public void a() {
        this.f62579a = 0L;
        this.f62580b = 0L;
        this.f62581c = 0L;
    }

    public void b() {
        this.f62581c = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.f62580b = SystemClock.elapsedRealtime();
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        if (this.f62582d) {
            this.f62582d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f62580b - this.f62579a;
            long j2 = elapsedRealtime - this.f62581c;
            long j3 = j2 + j;
            if ((d.b.c.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.Q(j, j2, j3);
            }
        }
    }

    public void e() {
        this.f62582d = true;
        this.f62579a = SystemClock.elapsedRealtime();
    }
}
