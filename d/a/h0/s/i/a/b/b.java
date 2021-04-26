package d.a.h0.s.i.a.b;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.h0.a.r1.e;
import d.a.h0.a.s0.k.g.a;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import d.a.h0.s.j.a.a;
/* loaded from: classes3.dex */
public class b extends d.a.h0.s.i.a.b.a {
    public d.a.h0.s.j.a.a x;
    public int y;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.h0.s.j.a.a.b
        public void a(int i2, int i3) {
            b.this.p0();
        }
    }

    /* renamed from: d.a.h0.s.i.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1004b implements d.a.h0.a.i2.u0.b<Integer> {
        public C1004b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 2) {
                if (d.a.h0.s.i.a.b.a.v) {
                    Log.d("SwanInlineLiveWidget", b.this.f47617f + "-" + hashCode() + " authorize deny => onError 0");
                }
                a.InterfaceC0764a interfaceC0764a = b.this.f47620i;
                if (interfaceC0764a != null) {
                    interfaceC0764a.onError(0);
                    return;
                }
                return;
            }
            if (d.a.h0.s.i.a.b.a.v) {
                Log.d("SwanInlineLiveWidget", b.this.f47617f + "-" + hashCode() + " real do prepareAsync");
            }
            b.super.E();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f47633e;

        public c(d.a.h0.a.i2.u0.b bVar) {
            this.f47633e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            boolean h2 = d.a.h0.a.v1.c.c.h(hVar);
            if (d.a.h0.s.i.a.b.a.v) {
                Log.d("SwanInlineLiveWidget", b.this.f47617f + "-" + hashCode() + " authorize: " + h2);
            }
            b.this.y = h2 ? 1 : 2;
            this.f47633e.onCallback(Integer.valueOf(b.this.y));
        }
    }

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.y = 0;
        d.a.h0.s.j.a.a aVar = new d.a.h0.s.j.a.a();
        this.x = aVar;
        aVar.e(this.f47614c);
        this.x.f(new a());
    }

    public final void B0(@NonNull Context context, @NonNull d.a.h0.a.i2.u0.b<Integer> bVar) {
        if (d.a.h0.s.i.a.b.a.v) {
            Log.d("SwanInlineLiveWidget", this.f47617f + "-" + hashCode() + " start authorize");
        }
        e O = e.O();
        if (O == null) {
            if (!d.a.h0.s.i.a.b.a.v) {
                bVar.onCallback(0);
                return;
            }
            throw new RuntimeException("inline live authorize: swan app is null");
        } else if (d.a.h0.a.m1.a.a.p()) {
            this.y = 1;
            if (d.a.h0.s.i.a.b.a.v) {
                Log.d("SwanInlineLiveWidget", this.f47617f + "-" + hashCode() + " authorize debug: true");
            }
            bVar.onCallback(Integer.valueOf(this.y));
        } else {
            O.R().g(context, "mapp_i_live_player", new c(bVar));
        }
    }

    @Override // d.a.h0.s.i.a.b.a, d.a.h0.a.s0.k.g.a
    public boolean E() {
        if (d.a.h0.s.i.a.b.a.v) {
            Log.d("SwanInlineLiveWidget", this.f47617f + "-" + hashCode() + " start prepareAsync");
        }
        B0(this.f47614c, new C1004b());
        return true;
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void X(String str) {
    }

    @Override // d.a.h0.s.i.a.b.a, d.a.h0.a.s0.k.g.a
    public int c() {
        return this.y;
    }

    @Override // d.a.h0.s.i.a.b.a, d.a.h0.a.s0.k.g.a
    public void release() {
        super.release();
        d.a.h0.s.j.a.a aVar = this.x;
        if (aVar != null) {
            aVar.g();
            this.x = null;
        }
    }

    @Override // d.a.h0.s.i.a.b.a
    public void s0(int i2, int i3, String str) {
    }

    @Override // d.a.h0.s.i.a.b.a
    public void t0() {
    }
}
