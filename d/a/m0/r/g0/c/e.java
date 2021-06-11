package d.a.m0.r.g0.c;

import android.media.MediaPlayer;
import d.a.c.e.q.h;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e extends MediaPlayer implements c {

    /* renamed from: d  reason: collision with root package name */
    public static Object f53523d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static e f53524e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53525a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53526b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f53527c = -1;

    public static e i() {
        if (f53524e == null) {
            synchronized (f53523d) {
                if (f53524e == null) {
                    f53524e = new e();
                }
            }
        }
        return f53524e;
    }

    @Override // d.a.m0.r.g0.c.c
    public void a() {
        if (this.f53526b) {
            return;
        }
        stop();
        this.f53526b = true;
        this.f53525a = false;
    }

    @Override // d.a.m0.r.g0.c.c
    public boolean b(String str) {
        this.f53527c = -1;
        if (!this.f53525a) {
            this.f53526b = true;
            reset();
            try {
                setDataSource(str);
                j(h.f42564b);
                try {
                    prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.f53527c = 2;
                    return false;
                } catch (IllegalStateException unused) {
                    this.f53527c = 1;
                    return false;
                }
            } catch (IOException unused2) {
                this.f53527c = 2;
                return false;
            } catch (IllegalArgumentException unused3) {
                this.f53527c = 0;
                return false;
            } catch (IllegalStateException unused4) {
                this.f53527c = 1;
                return false;
            }
        }
        this.f53525a = true;
        return true;
    }

    @Override // d.a.m0.r.g0.c.c
    public int c() {
        return this.f53527c;
    }

    @Override // d.a.m0.r.g0.c.c
    public boolean d() {
        return this.f53525a;
    }

    @Override // d.a.m0.r.g0.c.c
    public void e() {
        pause();
    }

    @Override // d.a.m0.r.g0.c.c
    public void f() {
        reset();
        this.f53525a = false;
        this.f53526b = true;
        this.f53527c = -1;
    }

    @Override // d.a.m0.r.g0.c.c
    public int g() {
        return getCurrentPosition();
    }

    @Override // d.a.m0.r.g0.c.c
    public void h() {
        start();
        this.f53526b = false;
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

    @Override // d.a.m0.r.g0.c.c
    public void seek(int i2) {
        k(i2);
    }
}
