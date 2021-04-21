package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwai.video.ksvodplayerkit.d;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements d {

    /* renamed from: a  reason: collision with root package name */
    public g f37751a;

    /* renamed from: b  reason: collision with root package name */
    public Context f37752b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f37753c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceHolder f37754d;

    /* renamed from: h  reason: collision with root package name */
    public l f37758h;
    public d.InterfaceC0469d i;
    public d.b j;
    public d.c k;
    public b l;
    public d.e m;
    public d.a n;
    public KwaiPlayerDebugInfoView o;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37755e = true;

    /* renamed from: f  reason: collision with root package name */
    public float f37756f = -1.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f37757g = -1.0f;
    public float p = -1.0f;

    public k(Context context) {
        this.f37752b = context;
    }

    public int a() {
        g gVar = this.f37751a;
        if (gVar != null) {
            return gVar.a();
        }
        return -1;
    }

    public void a(float f2) {
        this.p = f2;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(f2);
        }
    }

    public void a(float f2, float f3) {
        this.f37756f = f2;
        this.f37757g = f3;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(f2, f3);
        }
    }

    public void a(long j) {
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(j);
        }
    }

    public void a(Surface surface) {
        this.f37753c = surface;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(surface);
        }
    }

    public void a(b bVar) {
        this.l = bVar;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(bVar);
        }
    }

    public void a(d.a aVar) {
        this.n = aVar;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(aVar);
        }
    }

    public void a(d.b bVar) {
        this.j = bVar;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(bVar);
        }
    }

    public void a(d.c cVar) {
        this.k = cVar;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(cVar);
        }
    }

    public void a(d.InterfaceC0469d interfaceC0469d) {
        this.i = interfaceC0469d;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(interfaceC0469d);
        }
    }

    public void a(d.e eVar) {
        this.m = eVar;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(eVar);
        }
    }

    public void a(d.f fVar) {
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(fVar);
        }
        this.f37751a = null;
    }

    public void a(l lVar) {
        this.f37758h = lVar;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(lVar);
        }
    }

    public void a(String str, Map<String, String> map) {
        KSVodPlayerBuilder kSVodPlayerBuilder = new KSVodPlayerBuilder(this.f37752b);
        kSVodPlayerBuilder.a(map);
        kSVodPlayerBuilder.a(false);
        kSVodPlayerBuilder.a(str);
        g b2 = kSVodPlayerBuilder.b();
        this.f37751a = b2;
        b2.b(true);
        Surface surface = this.f37753c;
        if (surface != null) {
            this.f37751a.a(surface);
        }
        SurfaceHolder surfaceHolder = this.f37754d;
        if (surfaceHolder != null) {
            this.f37751a.a(surfaceHolder);
        }
        float f2 = this.f37756f;
        if (f2 != -1.0f) {
            float f3 = this.f37757g;
            if (f3 != -1.0f) {
                this.f37751a.a(f2, f3);
            }
        }
        this.f37751a.a(this.f37755e);
        l lVar = this.f37758h;
        if (lVar != null) {
            this.f37751a.a(lVar);
        }
        float f4 = this.p;
        if (f4 != -1.0f) {
            this.f37751a.a(f4);
        }
        this.f37751a.a(this.i);
        this.f37751a.a(this.k);
        this.f37751a.a(this.j);
        this.f37751a.a(this.m);
        this.f37751a.a(this.l);
        this.f37751a.a(this.n);
        KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView = this.o;
        if (kwaiPlayerDebugInfoView != null) {
            this.f37751a.a(kwaiPlayerDebugInfoView);
        }
    }

    public void a(boolean z) {
        this.f37755e = z;
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public boolean b() {
        g gVar = this.f37751a;
        if (gVar != null) {
            return gVar.b();
        }
        return false;
    }

    public long c() {
        g gVar = this.f37751a;
        if (gVar != null) {
            return gVar.c();
        }
        return 0L;
    }

    public long d() {
        g gVar = this.f37751a;
        if (gVar != null) {
            return gVar.d();
        }
        return 0L;
    }

    public void e() {
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.e();
        }
    }

    public IKwaiMediaPlayer f() {
        g gVar = this.f37751a;
        if (gVar != null) {
            return gVar.h();
        }
        return null;
    }

    public void g() {
        g gVar = this.f37751a;
        if (gVar != null) {
            gVar.f();
        }
    }
}
