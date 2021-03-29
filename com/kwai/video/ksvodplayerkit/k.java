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
    public g f37367a;

    /* renamed from: b  reason: collision with root package name */
    public Context f37368b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f37369c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceHolder f37370d;

    /* renamed from: h  reason: collision with root package name */
    public l f37374h;
    public d.InterfaceC0452d i;
    public d.b j;
    public d.c k;
    public b l;
    public d.e m;
    public d.a n;
    public KwaiPlayerDebugInfoView o;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37371e = true;

    /* renamed from: f  reason: collision with root package name */
    public float f37372f = -1.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f37373g = -1.0f;
    public float p = -1.0f;

    public k(Context context) {
        this.f37368b = context;
    }

    public int a() {
        g gVar = this.f37367a;
        if (gVar != null) {
            return gVar.a();
        }
        return -1;
    }

    public void a(float f2) {
        this.p = f2;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(f2);
        }
    }

    public void a(float f2, float f3) {
        this.f37372f = f2;
        this.f37373g = f3;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(f2, f3);
        }
    }

    public void a(long j) {
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(j);
        }
    }

    public void a(Surface surface) {
        this.f37369c = surface;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(surface);
        }
    }

    public void a(b bVar) {
        this.l = bVar;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(bVar);
        }
    }

    public void a(d.a aVar) {
        this.n = aVar;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(aVar);
        }
    }

    public void a(d.b bVar) {
        this.j = bVar;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(bVar);
        }
    }

    public void a(d.c cVar) {
        this.k = cVar;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(cVar);
        }
    }

    public void a(d.InterfaceC0452d interfaceC0452d) {
        this.i = interfaceC0452d;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(interfaceC0452d);
        }
    }

    public void a(d.e eVar) {
        this.m = eVar;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(eVar);
        }
    }

    public void a(d.f fVar) {
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(fVar);
        }
        this.f37367a = null;
    }

    public void a(l lVar) {
        this.f37374h = lVar;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(lVar);
        }
    }

    public void a(String str, Map<String, String> map) {
        KSVodPlayerBuilder kSVodPlayerBuilder = new KSVodPlayerBuilder(this.f37368b);
        kSVodPlayerBuilder.a(map);
        kSVodPlayerBuilder.a(false);
        kSVodPlayerBuilder.a(str);
        g b2 = kSVodPlayerBuilder.b();
        this.f37367a = b2;
        b2.b(true);
        Surface surface = this.f37369c;
        if (surface != null) {
            this.f37367a.a(surface);
        }
        SurfaceHolder surfaceHolder = this.f37370d;
        if (surfaceHolder != null) {
            this.f37367a.a(surfaceHolder);
        }
        float f2 = this.f37372f;
        if (f2 != -1.0f) {
            float f3 = this.f37373g;
            if (f3 != -1.0f) {
                this.f37367a.a(f2, f3);
            }
        }
        this.f37367a.a(this.f37371e);
        l lVar = this.f37374h;
        if (lVar != null) {
            this.f37367a.a(lVar);
        }
        float f4 = this.p;
        if (f4 != -1.0f) {
            this.f37367a.a(f4);
        }
        this.f37367a.a(this.i);
        this.f37367a.a(this.k);
        this.f37367a.a(this.j);
        this.f37367a.a(this.m);
        this.f37367a.a(this.l);
        this.f37367a.a(this.n);
        KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView = this.o;
        if (kwaiPlayerDebugInfoView != null) {
            this.f37367a.a(kwaiPlayerDebugInfoView);
        }
    }

    public void a(boolean z) {
        this.f37371e = z;
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public boolean b() {
        g gVar = this.f37367a;
        if (gVar != null) {
            return gVar.b();
        }
        return false;
    }

    public long c() {
        g gVar = this.f37367a;
        if (gVar != null) {
            return gVar.c();
        }
        return 0L;
    }

    public long d() {
        g gVar = this.f37367a;
        if (gVar != null) {
            return gVar.d();
        }
        return 0L;
    }

    public void e() {
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.e();
        }
    }

    public IKwaiMediaPlayer f() {
        g gVar = this.f37367a;
        if (gVar != null) {
            return gVar.h();
        }
        return null;
    }

    public void g() {
        g gVar = this.f37367a;
        if (gVar != null) {
            gVar.f();
        }
    }
}
