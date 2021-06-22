package d.a.n0.r.g0.c;

import android.media.MediaPlayer;
import d.a.c.e.q.h;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e extends MediaPlayer implements c {

    /* renamed from: d  reason: collision with root package name */
    public static Object f53630d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static e f53631e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53632a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53633b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f53634c = -1;

    public static e i() {
        if (f53631e == null) {
            synchronized (f53630d) {
                if (f53631e == null) {
                    f53631e = new e();
                }
            }
        }
        return f53631e;
    }

    @Override // d.a.n0.r.g0.c.c
    public void a() {
        if (this.f53633b) {
            return;
        }
        stop();
        this.f53633b = true;
        this.f53632a = false;
    }

    @Override // d.a.n0.r.g0.c.c
    public boolean b(String str) {
        this.f53634c = -1;
        if (!this.f53632a) {
            this.f53633b = true;
            reset();
            try {
                setDataSource(str);
                j(h.f42667b);
                try {
                    prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.f53634c = 2;
                    return false;
                } catch (IllegalStateException unused) {
                    this.f53634c = 1;
                    return false;
                }
            } catch (IOException unused2) {
                this.f53634c = 2;
                return false;
            } catch (IllegalArgumentException unused3) {
                this.f53634c = 0;
                return false;
            } catch (IllegalStateException unused4) {
                this.f53634c = 1;
                return false;
            }
        }
        this.f53632a = true;
        return true;
    }

    @Override // d.a.n0.r.g0.c.c
    public int c() {
        return this.f53634c;
    }

    @Override // d.a.n0.r.g0.c.c
    public boolean d() {
        return this.f53632a;
    }

    @Override // d.a.n0.r.g0.c.c
    public void e() {
        pause();
    }

    @Override // d.a.n0.r.g0.c.c
    public void f() {
        reset();
        this.f53632a = false;
        this.f53633b = true;
        this.f53634c = -1;
    }

    @Override // d.a.n0.r.g0.c.c
    public int g() {
        return getCurrentPosition();
    }

    @Override // d.a.n0.r.g0.c.c
    public void h() {
        start();
        this.f53633b = false;
    }

    public void j(int i2) {
        setAudioStreamType(i2);
    }

    public void k(int i2) {
        try {
            seekTo(i2);
        } catch (Exception unused) {
        }
    }

    @Override // d.a.n0.r.g0.c.c
    public void seek(int i2) {
        k(i2);
    }
}
