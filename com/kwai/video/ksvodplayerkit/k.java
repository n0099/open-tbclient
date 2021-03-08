package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwai.video.ksvodplayerkit.d;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.util.Map;
/* loaded from: classes3.dex */
public class k implements d {

    /* renamed from: a  reason: collision with root package name */
    private g f7308a;
    private Context b;
    private Surface c;
    private SurfaceHolder d;
    private l h;
    private d.InterfaceC1184d i;
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
        this.b = context;
    }

    public int a() {
        if (this.f7308a != null) {
            return this.f7308a.a();
        }
        return -1;
    }

    public void a(float f) {
        this.p = f;
        if (this.f7308a != null) {
            this.f7308a.a(this.p);
        }
    }

    public void a(float f, float f2) {
        this.f = f;
        this.g = f2;
        if (this.f7308a != null) {
            this.f7308a.a(f, f2);
        }
    }

    public void a(long j) {
        if (this.f7308a != null) {
            this.f7308a.a(j);
        }
    }

    public void a(Surface surface) {
        this.c = surface;
        if (this.f7308a != null) {
            this.f7308a.a(surface);
        }
    }

    public void a(b bVar) {
        this.l = bVar;
        if (this.f7308a != null) {
            this.f7308a.a(bVar);
        }
    }

    public void a(d.a aVar) {
        this.n = aVar;
        if (this.f7308a != null) {
            this.f7308a.a(aVar);
        }
    }

    public void a(d.b bVar) {
        this.j = bVar;
        if (this.f7308a != null) {
            this.f7308a.a(bVar);
        }
    }

    public void a(d.c cVar) {
        this.k = cVar;
        if (this.f7308a != null) {
            this.f7308a.a(cVar);
        }
    }

    public void a(d.InterfaceC1184d interfaceC1184d) {
        this.i = interfaceC1184d;
        if (this.f7308a != null) {
            this.f7308a.a(interfaceC1184d);
        }
    }

    public void a(d.e eVar) {
        this.m = eVar;
        if (this.f7308a != null) {
            this.f7308a.a(eVar);
        }
    }

    public void a(d.f fVar) {
        if (this.f7308a != null) {
            this.f7308a.a(fVar);
        }
        this.f7308a = null;
    }

    public void a(l lVar) {
        this.h = lVar;
        if (this.f7308a != null) {
            this.f7308a.a(lVar);
        }
    }

    public void a(String str, Map<String, String> map) {
        KSVodPlayerBuilder kSVodPlayerBuilder = new KSVodPlayerBuilder(this.b);
        kSVodPlayerBuilder.a(map);
        kSVodPlayerBuilder.a(false);
        kSVodPlayerBuilder.a(str);
        this.f7308a = kSVodPlayerBuilder.b();
        this.f7308a.b(true);
        if (this.c != null) {
            this.f7308a.a(this.c);
        }
        if (this.d != null) {
            this.f7308a.a(this.d);
        }
        if (this.f != -1.0f && this.g != -1.0f) {
            this.f7308a.a(this.f, this.g);
        }
        this.f7308a.a(this.e);
        if (this.h != null) {
            this.f7308a.a(this.h);
        }
        if (this.p != -1.0f) {
            this.f7308a.a(this.p);
        }
        this.f7308a.a(this.i);
        this.f7308a.a(this.k);
        this.f7308a.a(this.j);
        this.f7308a.a(this.m);
        this.f7308a.a(this.l);
        this.f7308a.a(this.n);
        if (this.o != null) {
            this.f7308a.a(this.o);
        }
    }

    public void a(boolean z) {
        this.e = z;
        if (this.f7308a != null) {
            this.f7308a.a(z);
        }
    }

    public boolean b() {
        if (this.f7308a != null) {
            return this.f7308a.b();
        }
        return false;
    }

    public long c() {
        if (this.f7308a != null) {
            return this.f7308a.c();
        }
        return 0L;
    }

    public long d() {
        if (this.f7308a != null) {
            return this.f7308a.d();
        }
        return 0L;
    }

    public void e() {
        if (this.f7308a != null) {
            this.f7308a.e();
        }
    }

    public IKwaiMediaPlayer f() {
        if (this.f7308a != null) {
            return this.f7308a.h();
        }
        return null;
    }

    public void g() {
        if (this.f7308a != null) {
            this.f7308a.f();
        }
    }
}
