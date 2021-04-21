package d.b.i0.r.g0.c;

import android.media.MediaPlayer;
import d.b.c.e.q.h;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e extends MediaPlayer implements c {

    /* renamed from: d  reason: collision with root package name */
    public static Object f51357d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static e f51358e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51359a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51360b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f51361c = -1;

    public static e i() {
        if (f51358e == null) {
            synchronized (f51357d) {
                if (f51358e == null) {
                    f51358e = new e();
                }
            }
        }
        return f51358e;
    }

    @Override // d.b.i0.r.g0.c.c
    public void a() {
        if (this.f51360b) {
            return;
        }
        stop();
        this.f51360b = true;
        this.f51359a = false;
    }

    @Override // d.b.i0.r.g0.c.c
    public int b() {
        return getCurrentPosition();
    }

    @Override // d.b.i0.r.g0.c.c
    public boolean c(String str) {
        this.f51361c = -1;
        if (!this.f51359a) {
            this.f51360b = true;
            reset();
            try {
                setDataSource(str);
                j(h.f42789b);
                try {
                    prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.f51361c = 2;
                    return false;
                } catch (IllegalStateException unused) {
                    this.f51361c = 1;
                    return false;
                }
            } catch (IOException unused2) {
                this.f51361c = 2;
                return false;
            } catch (IllegalArgumentException unused3) {
                this.f51361c = 0;
                return false;
            } catch (IllegalStateException unused4) {
                this.f51361c = 1;
                return false;
            }
        }
        this.f51359a = true;
        return true;
    }

    @Override // d.b.i0.r.g0.c.c
    public void d() {
        start();
        this.f51360b = false;
    }

    @Override // d.b.i0.r.g0.c.c
    public int e() {
        return this.f51361c;
    }

    @Override // d.b.i0.r.g0.c.c
    public boolean f() {
        return this.f51359a;
    }

    @Override // d.b.i0.r.g0.c.c
    public void g() {
        pause();
    }

    @Override // d.b.i0.r.g0.c.c
    public void h() {
        reset();
        this.f51359a = false;
        this.f51360b = true;
        this.f51361c = -1;
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

    @Override // d.b.i0.r.g0.c.c
    public void seek(int i) {
        k(i);
    }
}
