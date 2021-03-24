package d.b.h0.r.g0.c;

import android.media.MediaPlayer;
import d.b.b.e.q.h;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e extends MediaPlayer implements c {

    /* renamed from: d  reason: collision with root package name */
    public static Object f50613d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static e f50614e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50615a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50616b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f50617c = -1;

    public static e i() {
        if (f50614e == null) {
            synchronized (f50613d) {
                if (f50614e == null) {
                    f50614e = new e();
                }
            }
        }
        return f50614e;
    }

    @Override // d.b.h0.r.g0.c.c
    public void a() {
        if (this.f50616b) {
            return;
        }
        stop();
        this.f50616b = true;
        this.f50615a = false;
    }

    @Override // d.b.h0.r.g0.c.c
    public int b() {
        return getCurrentPosition();
    }

    @Override // d.b.h0.r.g0.c.c
    public boolean c(String str) {
        this.f50617c = -1;
        if (!this.f50615a) {
            this.f50616b = true;
            reset();
            try {
                setDataSource(str);
                j(h.f42051b);
                try {
                    prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.f50617c = 2;
                    return false;
                } catch (IllegalStateException unused) {
                    this.f50617c = 1;
                    return false;
                }
            } catch (IOException unused2) {
                this.f50617c = 2;
                return false;
            } catch (IllegalArgumentException unused3) {
                this.f50617c = 0;
                return false;
            } catch (IllegalStateException unused4) {
                this.f50617c = 1;
                return false;
            }
        }
        this.f50615a = true;
        return true;
    }

    @Override // d.b.h0.r.g0.c.c
    public void d() {
        start();
        this.f50616b = false;
    }

    @Override // d.b.h0.r.g0.c.c
    public int e() {
        return this.f50617c;
    }

    @Override // d.b.h0.r.g0.c.c
    public boolean f() {
        return this.f50615a;
    }

    @Override // d.b.h0.r.g0.c.c
    public void g() {
        pause();
    }

    @Override // d.b.h0.r.g0.c.c
    public void h() {
        reset();
        this.f50615a = false;
        this.f50616b = true;
        this.f50617c = -1;
    }

    public void j(int i) {
        setAudioStreamType(i);
    }

    public void k(int i) {
        try {
            seekTo(i);
        } catch (Exception unused) {
        }
    }

    @Override // d.b.h0.r.g0.c.c
    public void seek(int i) {
        k(i);
    }
}
