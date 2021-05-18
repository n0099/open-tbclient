package d.a.i0.v.i.a.c;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.i0.a.a2.e;
import d.a.i0.a.e2.c.d;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.y0.k.g.a;
import d.a.i0.v.j.a.a;
/* loaded from: classes3.dex */
public class b extends d.a.i0.v.i.a.c.a {
    public int A;
    public d.a.i0.v.j.a.a z;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.i0.v.j.a.a.b
        public void a(int i2, int i3) {
            b.this.C0();
        }
    }

    /* renamed from: d.a.i0.v.i.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1078b implements d.a.i0.a.v2.e1.b<Integer> {
        public C1078b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 2) {
                if (d.a.i0.v.i.a.c.a.x) {
                    Log.d("SwanInlineLiveWidget", b.this.f48346f + "-" + hashCode() + " authorize deny => onError 0");
                }
                a.InterfaceC0909a interfaceC0909a = b.this.f48349i;
                if (interfaceC0909a != null) {
                    interfaceC0909a.onError(0);
                    return;
                }
                return;
            }
            if (d.a.i0.v.i.a.c.a.x) {
                Log.d("SwanInlineLiveWidget", b.this.f48346f + "-" + hashCode() + " real do prepareAsync");
            }
            b.super.I();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f48364e;

        public c(d.a.i0.a.v2.e1.b bVar) {
            this.f48364e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            boolean h2 = d.h(iVar);
            if (d.a.i0.v.i.a.c.a.x) {
                Log.d("SwanInlineLiveWidget", b.this.f48346f + "-" + hashCode() + " authorize: " + h2);
            }
            b.this.A = h2 ? 1 : 2;
            this.f48364e.onCallback(Integer.valueOf(b.this.A));
        }
    }

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.A = 0;
        d.a.i0.v.j.a.a aVar = new d.a.i0.v.j.a.a();
        this.z = aVar;
        aVar.e(this.f48343c);
        this.z.f(new a());
    }

    @Override // d.a.i0.v.i.a.c.a
    public void F0(int i2, int i3, String str) {
    }

    @Override // d.a.i0.v.i.a.c.a
    public void G0() {
    }

    @Override // d.a.i0.v.i.a.c.a, d.a.i0.a.y0.k.g.a
    public boolean I() {
        if (d.a.i0.v.i.a.c.a.x) {
            Log.d("SwanInlineLiveWidget", this.f48346f + "-" + hashCode() + " start prepareAsync");
        }
        P0(this.f48343c, new C1078b());
        return true;
    }

    public final void P0(@NonNull Context context, @NonNull d.a.i0.a.v2.e1.b<Integer> bVar) {
        if (d.a.i0.v.i.a.c.a.x) {
            Log.d("SwanInlineLiveWidget", this.f48346f + "-" + hashCode() + " start authorize");
        }
        e Q = e.Q();
        if (Q == null) {
            if (!d.a.i0.v.i.a.c.a.x) {
                bVar.onCallback(0);
                return;
            }
            throw new RuntimeException("inline live authorize: swan app is null");
        } else if (d.a.i0.a.u1.a.a.r()) {
            this.A = 1;
            if (d.a.i0.v.i.a.c.a.x) {
                Log.d("SwanInlineLiveWidget", this.f48346f + "-" + hashCode() + " authorize debug: true");
            }
            bVar.onCallback(Integer.valueOf(this.A));
        } else {
            Q.T().g(context, "mapp_i_live_player", new c(bVar));
        }
    }

    @Override // d.a.i0.a.y0.k.g.a
    public void Q(ZeusPluginFactory.Invoker invoker) {
    }

    @Override // d.a.i0.a.y0.k.g.a
    public void Y() {
    }

    @Override // d.a.i0.v.i.a.c.a, d.a.i0.a.y0.k.g.a
    public int a() {
        return this.A;
    }

    @Override // d.a.i0.v.i.a.c.a, d.a.i0.a.y0.k.g.a
    public void f0(String str) {
    }

    @Override // d.a.i0.a.y0.k.g.a
    public ZeusPluginFactory.Invoker j0() {
        return null;
    }

    @Override // d.a.i0.v.i.a.c.a, d.a.i0.a.y0.k.g.a
    public void release() {
        super.release();
        d.a.i0.v.j.a.a aVar = this.z;
        if (aVar != null) {
            aVar.g();
            this.z = null;
        }
    }
}
