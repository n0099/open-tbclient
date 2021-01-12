package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwai.video.ksvodplayerkit.d;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.util.Map;
/* loaded from: classes4.dex */
public class k implements d {

    /* renamed from: a  reason: collision with root package name */
    private g f11100a;

    /* renamed from: b  reason: collision with root package name */
    private Context f11101b;
    private Surface c;
    private SurfaceHolder d;
    private l h;
    private d.InterfaceC1161d i;
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
        this.f11101b = context;
    }

    public int a() {
        if (this.f11100a != null) {
            return this.f11100a.a();
        }
        return -1;
    }

    public void a(float f) {
        this.p = f;
        if (this.f11100a != null) {
            this.f11100a.a(this.p);
        }
    }

    public void a(float f, float f2) {
        this.f = f;
        this.g = f2;
        if (this.f11100a != null) {
            this.f11100a.a(f, f2);
        }
    }

    public void a(long j) {
        if (this.f11100a != null) {
            this.f11100a.a(j);
        }
    }

    public void a(Surface surface) {
        this.c = surface;
        if (this.f11100a != null) {
            this.f11100a.a(surface);
        }
    }

    public void a(b bVar) {
        this.l = bVar;
        if (this.f11100a != null) {
            this.f11100a.a(bVar);
        }
    }

    public void a(d.a aVar) {
        this.n = aVar;
        if (this.f11100a != null) {
            this.f11100a.a(aVar);
        }
    }

    public void a(d.b bVar) {
        this.j = bVar;
        if (this.f11100a != null) {
            this.f11100a.a(bVar);
        }
    }

    public void a(d.c cVar) {
        this.k = cVar;
        if (this.f11100a != null) {
            this.f11100a.a(cVar);
        }
    }

    public void a(d.InterfaceC1161d interfaceC1161d) {
        this.i = interfaceC1161d;
        if (this.f11100a != null) {
            this.f11100a.a(interfaceC1161d);
        }
    }

    public void a(d.e eVar) {
        this.m = eVar;
        if (this.f11100a != null) {
            this.f11100a.a(eVar);
        }
    }

    public void a(d.f fVar) {
        if (this.f11100a != null) {
            this.f11100a.a(fVar);
        }
        this.f11100a = null;
    }

    public void a(l lVar) {
        this.h = lVar;
        if (this.f11100a != null) {
            this.f11100a.a(lVar);
        }
    }

    public void a(String str, Map<String, String> map) {
        KSVodPlayerBuilder kSVodPlayerBuilder = new KSVodPlayerBuilder(this.f11101b);
        kSVodPlayerBuilder.a(map);
        kSVodPlayerBuilder.a(false);
        kSVodPlayerBuilder.a(str);
        this.f11100a = kSVodPlayerBuilder.b();
        this.f11100a.b(true);
        if (this.c != null) {
            this.f11100a.a(this.c);
        }
        if (this.d != null) {
            this.f11100a.a(this.d);
        }
        if (this.f != -1.0f && this.g != -1.0f) {
            this.f11100a.a(this.f, this.g);
        }
        this.f11100a.a(this.e);
        if (this.h != null) {
            this.f11100a.a(this.h);
        }
        if (this.p != -1.0f) {
            this.f11100a.a(this.p);
        }
        this.f11100a.a(this.i);
        this.f11100a.a(this.k);
        this.f11100a.a(this.j);
        this.f11100a.a(this.m);
        this.f11100a.a(this.l);
        this.f11100a.a(this.n);
        if (this.o != null) {
            this.f11100a.a(this.o);
        }
    }

    public void a(boolean z) {
        this.e = z;
        if (this.f11100a != null) {
            this.f11100a.a(z);
        }
    }

    public boolean b() {
        if (this.f11100a != null) {
            return this.f11100a.b();
        }
        return false;
    }

    public long c() {
        if (this.f11100a != null) {
            return this.f11100a.c();
        }
        return 0L;
    }

    public long d() {
        if (this.f11100a != null) {
            return this.f11100a.d();
        }
        return 0L;
    }

    public void e() {
        if (this.f11100a != null) {
            this.f11100a.e();
        }
    }

    public IKwaiMediaPlayer f() {
        if (this.f11100a != null) {
            return this.f11100a.h();
        }
        return null;
    }

    public void g() {
        if (this.f11100a != null) {
            this.f11100a.f();
        }
    }
}
