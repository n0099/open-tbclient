package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwai.video.ksvodplayerkit.d;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.util.Map;
/* loaded from: classes5.dex */
public class k implements d {

    /* renamed from: a  reason: collision with root package name */
    private g f11400a;

    /* renamed from: b  reason: collision with root package name */
    private Context f11401b;
    private Surface c;
    private SurfaceHolder d;
    private l h;
    private d.InterfaceC1178d i;
    private d.b j;
    private d.c k;
    private b l;
    private d.e m;
    private d.a n;
    private KwaiPlayerDebugInfoView o;
    private boolean e = true;
    private float f = -1.0f;
    private float g = -1.0f;
    private float p = -1.0f;

    public k(Context context) {
        this.f11401b = context;
    }

    public int a() {
        if (this.f11400a != null) {
            return this.f11400a.a();
        }
        return -1;
    }

    public void a(float f) {
        this.p = f;
        if (this.f11400a != null) {
            this.f11400a.a(this.p);
        }
    }

    public void a(float f, float f2) {
        this.f = f;
        this.g = f2;
        if (this.f11400a != null) {
            this.f11400a.a(f, f2);
        }
    }

    public void a(long j) {
        if (this.f11400a != null) {
            this.f11400a.a(j);
        }
    }

    public void a(Surface surface) {
        this.c = surface;
        if (this.f11400a != null) {
            this.f11400a.a(surface);
        }
    }

    public void a(b bVar) {
        this.l = bVar;
        if (this.f11400a != null) {
            this.f11400a.a(bVar);
        }
    }

    public void a(d.a aVar) {
        this.n = aVar;
        if (this.f11400a != null) {
            this.f11400a.a(aVar);
        }
    }

    public void a(d.b bVar) {
        this.j = bVar;
        if (this.f11400a != null) {
            this.f11400a.a(bVar);
        }
    }

    public void a(d.c cVar) {
        this.k = cVar;
        if (this.f11400a != null) {
            this.f11400a.a(cVar);
        }
    }

    public void a(d.InterfaceC1178d interfaceC1178d) {
        this.i = interfaceC1178d;
        if (this.f11400a != null) {
            this.f11400a.a(interfaceC1178d);
        }
    }

    public void a(d.e eVar) {
        this.m = eVar;
        if (this.f11400a != null) {
            this.f11400a.a(eVar);
        }
    }

    public void a(d.f fVar) {
        if (this.f11400a != null) {
            this.f11400a.a(fVar);
        }
        this.f11400a = null;
    }

    public void a(l lVar) {
        this.h = lVar;
        if (this.f11400a != null) {
            this.f11400a.a(lVar);
        }
    }

    public void a(String str, Map<String, String> map) {
        KSVodPlayerBuilder kSVodPlayerBuilder = new KSVodPlayerBuilder(this.f11401b);
        kSVodPlayerBuilder.a(map);
        kSVodPlayerBuilder.a(false);
        kSVodPlayerBuilder.a(str);
        this.f11400a = kSVodPlayerBuilder.b();
        this.f11400a.b(true);
        if (this.c != null) {
            this.f11400a.a(this.c);
        }
        if (this.d != null) {
            this.f11400a.a(this.d);
        }
        if (this.f != -1.0f && this.g != -1.0f) {
            this.f11400a.a(this.f, this.g);
        }
        this.f11400a.a(this.e);
        if (this.h != null) {
            this.f11400a.a(this.h);
        }
        if (this.p != -1.0f) {
            this.f11400a.a(this.p);
        }
        this.f11400a.a(this.i);
        this.f11400a.a(this.k);
        this.f11400a.a(this.j);
        this.f11400a.a(this.m);
        this.f11400a.a(this.l);
        this.f11400a.a(this.n);
        if (this.o != null) {
            this.f11400a.a(this.o);
        }
    }

    public void a(boolean z) {
        this.e = z;
        if (this.f11400a != null) {
            this.f11400a.a(z);
        }
    }

    public boolean b() {
        if (this.f11400a != null) {
            return this.f11400a.b();
        }
        return false;
    }

    public long c() {
        if (this.f11400a != null) {
            return this.f11400a.c();
        }
        return 0L;
    }

    public long d() {
        if (this.f11400a != null) {
            return this.f11400a.d();
        }
        return 0L;
    }

    public void e() {
        if (this.f11400a != null) {
            this.f11400a.e();
        }
    }

    public IKwaiMediaPlayer f() {
        if (this.f11400a != null) {
            return this.f11400a.h();
        }
        return null;
    }

    public void g() {
        if (this.f11400a != null) {
            this.f11400a.f();
        }
    }
}
