package d.b.i0.s1;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f60164a;

    /* renamed from: b  reason: collision with root package name */
    public long f60165b;

    /* renamed from: c  reason: collision with root package name */
    public long f60166c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60167d;

    public void a() {
        this.f60164a = 0L;
        this.f60165b = 0L;
        this.f60166c = 0L;
    }

    public void b() {
        this.f60166c = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.f60165b = SystemClock.elapsedRealtime();
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        if (this.f60167d) {
            this.f60167d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f60165b - this.f60164a;
            long j2 = elapsedRealtime - this.f60166c;
            long j3 = j2 + j;
            if ((d.b.b.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.Q(j, j2, j3);
            }
        }
    }

    public void e() {
        this.f60167d = true;
        this.f60164a = SystemClock.elapsedRealtime();
    }
}
