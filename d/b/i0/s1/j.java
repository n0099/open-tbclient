package d.b.i0.s1;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f60165a;

    /* renamed from: b  reason: collision with root package name */
    public long f60166b;

    /* renamed from: c  reason: collision with root package name */
    public long f60167c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60168d;

    public void a() {
        this.f60165a = 0L;
        this.f60166b = 0L;
        this.f60167c = 0L;
    }

    public void b() {
        this.f60167c = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.f60166b = SystemClock.elapsedRealtime();
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        if (this.f60168d) {
            this.f60168d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f60166b - this.f60165a;
            long j2 = elapsedRealtime - this.f60167c;
            long j3 = j2 + j;
            if ((d.b.b.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.Q(j, j2, j3);
            }
        }
    }

    public void e() {
        this.f60168d = true;
        this.f60165a = SystemClock.elapsedRealtime();
    }
}
