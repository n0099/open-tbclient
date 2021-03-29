package d.b.h0.r.g0.c;

import android.media.MediaPlayer;
import d.b.b.e.q.h;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e extends MediaPlayer implements c {

    /* renamed from: d  reason: collision with root package name */
    public static Object f50614d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static e f50615e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50616a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50617b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f50618c = -1;

    public static e i() {
        if (f50615e == null) {
            synchronized (f50614d) {
                if (f50615e == null) {
                    f50615e = new e();
                }
            }
        }
        return f50615e;
    }

    @Override // d.b.h0.r.g0.c.c
    public void a() {
        if (this.f50617b) {
            return;
        }
        stop();
        this.f50617b = true;
        this.f50616a = false;
    }

    @Override // d.b.h0.r.g0.c.c
    public int b() {
        return getCurrentPosition();
    }

    @Override // d.b.h0.r.g0.c.c
    public boolean c(String str) {
        this.f50618c = -1;
        if (!this.f50616a) {
            this.f50617b = true;
            reset();
            try {
                setDataSource(str);
                j(h.f42052b);
                try {
                    prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.f50618c = 2;
                    return false;
                } catch (IllegalStateException unused) {
                    this.f50618c = 1;
                    return false;
                }
            } catch (IOException unused2) {
                this.f50618c = 2;
                return false;
            } catch (IllegalArgumentException unused3) {
                this.f50618c = 0;
                return false;
            } catch (IllegalStateException unused4) {
                this.f50618c = 1;
                return false;
            }
        }
        this.f50616a = true;
        return true;
    }

    @Override // d.b.h0.r.g0.c.c
    public void d() {
        start();
        this.f50617b = false;
    }

    @Override // d.b.h0.r.g0.c.c
    public int e() {
        return this.f50618c;
    }

    @Override // d.b.h0.r.g0.c.c
    public boolean f() {
        return this.f50616a;
    }

    @Override // d.b.h0.r.g0.c.c
    public void g() {
        pause();
    }

    @Override // d.b.h0.r.g0.c.c
    public void h() {
        reset();
        this.f50616a = false;
        this.f50617b = true;
        this.f50618c = -1;
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
