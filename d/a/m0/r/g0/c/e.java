package d.a.m0.r.g0.c;

import android.media.MediaPlayer;
import d.a.c.e.q.h;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e extends MediaPlayer implements c {

    /* renamed from: d  reason: collision with root package name */
    public static Object f49848d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static e f49849e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f49850a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49851b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f49852c = -1;

    public static e i() {
        if (f49849e == null) {
            synchronized (f49848d) {
                if (f49849e == null) {
                    f49849e = new e();
                }
            }
        }
        return f49849e;
    }

    @Override // d.a.m0.r.g0.c.c
    public void a() {
        if (this.f49851b) {
            return;
        }
        stop();
        this.f49851b = true;
        this.f49850a = false;
    }

    @Override // d.a.m0.r.g0.c.c
    public boolean b(String str) {
        this.f49852c = -1;
        if (!this.f49850a) {
            this.f49851b = true;
            reset();
            try {
                setDataSource(str);
                j(h.f38911b);
                try {
                    prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.f49852c = 2;
                    return false;
                } catch (IllegalStateException unused) {
                    this.f49852c = 1;
                    return false;
                }
            } catch (IOException unused2) {
                this.f49852c = 2;
                return false;
            } catch (IllegalArgumentException unused3) {
                this.f49852c = 0;
                return false;
            } catch (IllegalStateException unused4) {
                this.f49852c = 1;
                return false;
            }
        }
        this.f49850a = true;
        return true;
    }

    @Override // d.a.m0.r.g0.c.c
    public int c() {
        return this.f49852c;
    }

    @Override // d.a.m0.r.g0.c.c
    public boolean d() {
        return this.f49850a;
    }

    @Override // d.a.m0.r.g0.c.c
    public void e() {
        pause();
    }

    @Override // d.a.m0.r.g0.c.c
    public void f() {
        reset();
        this.f49850a = false;
        this.f49851b = true;
        this.f49852c = -1;
    }

    @Override // d.a.m0.r.g0.c.c
    public int g() {
        return getCurrentPosition();
    }

    @Override // d.a.m0.r.g0.c.c
    public void h() {
        start();
        this.f49851b = false;
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
