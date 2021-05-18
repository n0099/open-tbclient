package d.a.k0.t1;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f61930a;

    /* renamed from: b  reason: collision with root package name */
    public long f61931b;

    /* renamed from: c  reason: collision with root package name */
    public long f61932c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61933d;

    public void a() {
        this.f61930a = 0L;
        this.f61931b = 0L;
        this.f61932c = 0L;
    }

    public void b() {
        this.f61932c = SystemClock.elapsedRealtime();
    }

    public void c() {
        this.f61931b = SystemClock.elapsedRealtime();
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        if (this.f61933d) {
            this.f61933d = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f61931b - this.f61930a;
            long j2 = elapsedRealtime - this.f61932c;
            long j3 = j2 + j;
            if ((d.a.c.e.p.j.I() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.O(j, j2, j3);
            }
        }
    }

    public void e() {
        this.f61933d = true;
        this.f61930a = SystemClock.elapsedRealtime();
    }
}
