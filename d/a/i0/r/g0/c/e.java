package d.a.i0.r.g0.c;

import android.media.MediaPlayer;
import d.a.c.e.q.h;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e extends MediaPlayer implements c {

    /* renamed from: d  reason: collision with root package name */
    public static Object f48974d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static e f48975e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f48976a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48977b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f48978c = -1;

    public static e i() {
        if (f48975e == null) {
            synchronized (f48974d) {
                if (f48975e == null) {
                    f48975e = new e();
                }
            }
        }
        return f48975e;
    }

    @Override // d.a.i0.r.g0.c.c
    public void a() {
        if (this.f48977b) {
            return;
        }
        stop();
        this.f48977b = true;
        this.f48976a = false;
    }

    @Override // d.a.i0.r.g0.c.c
    public boolean b(String str) {
        this.f48978c = -1;
        if (!this.f48976a) {
            this.f48977b = true;
            reset();
            try {
                setDataSource(str);
                j(h.f40002b);
                try {
                    prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.f48978c = 2;
                    return false;
                } catch (IllegalStateException unused) {
                    this.f48978c = 1;
                    return false;
                }
            } catch (IOException unused2) {
                this.f48978c = 2;
                return false;
            } catch (IllegalArgumentException unused3) {
                this.f48978c = 0;
                return false;
            } catch (IllegalStateException unused4) {
                this.f48978c = 1;
                return false;
            }
        }
        this.f48976a = true;
        return true;
    }

    @Override // d.a.i0.r.g0.c.c
    public int c() {
        return this.f48978c;
    }

    @Override // d.a.i0.r.g0.c.c
    public boolean d() {
        return this.f48976a;
    }

    @Override // d.a.i0.r.g0.c.c
    public void e() {
        pause();
    }

    @Override // d.a.i0.r.g0.c.c
    public void f() {
        reset();
        this.f48976a = false;
        this.f48977b = true;
        this.f48978c = -1;
    }

    @Override // d.a.i0.r.g0.c.c
    public int g() {
        return getCurrentPosition();
    }

    @Override // d.a.i0.r.g0.c.c
    public void h() {
        start();
        this.f48977b = false;
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

    @Override // d.a.i0.r.g0.c.c
    public void seek(int i2) {
        k(i2);
    }
}
