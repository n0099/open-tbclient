package d.a.l0.v.i.a.c;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.l0.a.a2.e;
import d.a.l0.a.e2.c.d;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.y0.k.g.a;
import d.a.l0.v.j.a.a;
/* loaded from: classes3.dex */
public class b extends d.a.l0.v.i.a.c.a {
    public int A;
    public d.a.l0.v.j.a.a z;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.l0.v.j.a.a.b
        public void a(int i2, int i3) {
            b.this.C0();
        }
    }

    /* renamed from: d.a.l0.v.i.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1089b implements d.a.l0.a.v2.e1.b<Integer> {
        public C1089b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 2) {
                if (d.a.l0.v.i.a.c.a.x) {
                    Log.d("SwanInlineLiveWidget", b.this.f48522f + "-" + hashCode() + " authorize deny => onError 0");
                }
                a.InterfaceC0920a interfaceC0920a = b.this.f48525i;
                if (interfaceC0920a != null) {
                    interfaceC0920a.onError(0);
                    return;
                }
                return;
            }
            if (d.a.l0.v.i.a.c.a.x) {
                Log.d("SwanInlineLiveWidget", b.this.f48522f + "-" + hashCode() + " real do prepareAsync");
            }
            b.super.I();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f48540e;

        public c(d.a.l0.a.v2.e1.b bVar) {
            this.f48540e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            boolean h2 = d.h(iVar);
            if (d.a.l0.v.i.a.c.a.x) {
                Log.d("SwanInlineLiveWidget", b.this.f48522f + "-" + hashCode() + " authorize: " + h2);
            }
            b.this.A = h2 ? 1 : 2;
            this.f48540e.onCallback(Integer.valueOf(b.this.A));
        }
    }

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.A = 0;
        d.a.l0.v.j.a.a aVar = new d.a.l0.v.j.a.a();
        this.z = aVar;
        aVar.e(this.f48519c);
        this.z.f(new a());
    }

    @Override // d.a.l0.v.i.a.c.a
    public void F0(int i2, int i3, String str) {
    }

    @Override // d.a.l0.v.i.a.c.a
    public void G0() {
    }

    @Override // d.a.l0.v.i.a.c.a, d.a.l0.a.y0.k.g.a
    public boolean I() {
        if (d.a.l0.v.i.a.c.a.x) {
            Log.d("SwanInlineLiveWidget", this.f48522f + "-" + hashCode() + " start prepareAsync");
        }
        P0(this.f48519c, new C1089b());
        return true;
    }

    public final void P0(@NonNull Context context, @NonNull d.a.l0.a.v2.e1.b<Integer> bVar) {
        if (d.a.l0.v.i.a.c.a.x) {
            Log.d("SwanInlineLiveWidget", this.f48522f + "-" + hashCode() + " start authorize");
        }
        e Q = e.Q();
        if (Q == null) {
            if (!d.a.l0.v.i.a.c.a.x) {
                bVar.onCallback(0);
                return;
            }
            throw new RuntimeException("inline live authorize: swan app is null");
        } else if (d.a.l0.a.u1.a.a.r()) {
            this.A = 1;
            if (d.a.l0.v.i.a.c.a.x) {
                Log.d("SwanInlineLiveWidget", this.f48522f + "-" + hashCode() + " authorize debug: true");
            }
            bVar.onCallback(Integer.valueOf(this.A));
        } else {
            Q.T().g(context, "mapp_i_live_player", new c(bVar));
        }
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void Q(ZeusPluginFactory.Invoker invoker) {
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void Y() {
    }

    @Override // d.a.l0.v.i.a.c.a, d.a.l0.a.y0.k.g.a
    public int a() {
        return this.A;
    }

    @Override // d.a.l0.v.i.a.c.a, d.a.l0.a.y0.k.g.a
    public void f0(String str) {
    }

    @Override // d.a.l0.a.y0.k.g.a
    public ZeusPluginFactory.Invoker j0() {
        return null;
    }

    @Override // d.a.l0.v.i.a.c.a, d.a.l0.a.y0.k.g.a
    public void release() {
        super.release();
        d.a.l0.v.j.a.a aVar = this.z;
        if (aVar != null) {
            aVar.g();
            this.z = null;
        }
    }
}
