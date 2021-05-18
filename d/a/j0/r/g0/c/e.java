package d.a.j0.r.g0.c;

import android.media.MediaPlayer;
import d.a.c.e.q.h;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e extends MediaPlayer implements c {

    /* renamed from: d  reason: collision with root package name */
    public static Object f49804d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static e f49805e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f49806a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49807b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f49808c = -1;

    public static e i() {
        if (f49805e == null) {
            synchronized (f49804d) {
                if (f49805e == null) {
                    f49805e = new e();
                }
            }
        }
        return f49805e;
    }

    @Override // d.a.j0.r.g0.c.c
    public void a() {
        if (this.f49807b) {
            return;
        }
        stop();
        this.f49807b = true;
        this.f49806a = false;
    }

    @Override // d.a.j0.r.g0.c.c
    public boolean b(String str) {
        this.f49808c = -1;
        if (!this.f49806a) {
            this.f49807b = true;
            reset();
            try {
                setDataSource(str);
                j(h.f39247b);
                try {
                    prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.f49808c = 2;
                    return false;
                } catch (IllegalStateException unused) {
                    this.f49808c = 1;
                    return false;
                }
            } catch (IOException unused2) {
                this.f49808c = 2;
                return false;
            } catch (IllegalArgumentException unused3) {
                this.f49808c = 0;
                return false;
            } catch (IllegalStateException unused4) {
                this.f49808c = 1;
                return false;
            }
        }
        this.f49806a = true;
        return true;
    }

    @Override // d.a.j0.r.g0.c.c
    public int c() {
        return this.f49808c;
    }

    @Override // d.a.j0.r.g0.c.c
    public boolean d() {
        return this.f49806a;
    }

    @Override // d.a.j0.r.g0.c.c
    public void e() {
        pause();
    }

    @Override // d.a.j0.r.g0.c.c
    public void f() {
        reset();
        this.f49806a = false;
        this.f49807b = true;
        this.f49808c = -1;
    }

    @Override // d.a.j0.r.g0.c.c
    public int g() {
        return getCurrentPosition();
    }

    @Override // d.a.j0.r.g0.c.c
    public void h() {
        start();
        this.f49807b = false;
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

    @Override // d.a.j0.r.g0.c.c
    public void seek(int i2) {
        k(i2);
    }
}
