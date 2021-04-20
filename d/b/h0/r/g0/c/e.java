package d.b.h0.r.g0.c;

import android.media.MediaPlayer;
import d.b.c.e.q.h;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e extends MediaPlayer implements c {

    /* renamed from: d  reason: collision with root package name */
    public static Object f51021d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static e f51022e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51023a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51024b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f51025c = -1;

    public static e i() {
        if (f51022e == null) {
            synchronized (f51021d) {
                if (f51022e == null) {
                    f51022e = new e();
                }
            }
        }
        return f51022e;
    }

    @Override // d.b.h0.r.g0.c.c
    public void a() {
        if (this.f51024b) {
            return;
        }
        stop();
        this.f51024b = true;
        this.f51023a = false;
    }

    @Override // d.b.h0.r.g0.c.c
    public int b() {
        return getCurrentPosition();
    }

    @Override // d.b.h0.r.g0.c.c
    public boolean c(String str) {
        this.f51025c = -1;
        if (!this.f51023a) {
            this.f51024b = true;
            reset();
            try {
                setDataSource(str);
                j(h.f42549b);
                try {
                    prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.f51025c = 2;
                    return false;
                } catch (IllegalStateException unused) {
                    this.f51025c = 1;
                    return false;
                }
            } catch (IOException unused2) {
                this.f51025c = 2;
                return false;
            } catch (IllegalArgumentException unused3) {
                this.f51025c = 0;
                return false;
            } catch (IllegalStateException unused4) {
                this.f51025c = 1;
                return false;
            }
        }
        this.f51023a = true;
        return true;
    }

    @Override // d.b.h0.r.g0.c.c
    public void d() {
        start();
        this.f51024b = false;
    }

    @Override // d.b.h0.r.g0.c.c
    public int e() {
        return this.f51025c;
    }

    @Override // d.b.h0.r.g0.c.c
    public boolean f() {
        return this.f51023a;
    }

    @Override // d.b.h0.r.g0.c.c
    public void g() {
        pause();
    }

    @Override // d.b.h0.r.g0.c.c
    public void h() {
        reset();
        this.f51023a = false;
        this.f51024b = true;
        this.f51025c = -1;
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
