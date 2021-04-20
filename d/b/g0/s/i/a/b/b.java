package d.b.g0.s.i.a.b;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.g0.a.r1.e;
import d.b.g0.a.s0.k.g.a;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import d.b.g0.s.j.a.a;
/* loaded from: classes3.dex */
public class b extends d.b.g0.s.i.a.b.a {
    public d.b.g0.s.j.a.a x;
    public int y;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.g0.s.j.a.a.b
        public void a(int i, int i2) {
            b.this.o0();
        }
    }

    /* renamed from: d.b.g0.s.i.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1045b implements d.b.g0.a.i2.u0.b<Integer> {
        public C1045b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 2) {
                if (d.b.g0.s.i.a.b.a.v) {
                    Log.d("SwanInlineLiveWidget", b.this.f49756f + "-" + hashCode() + " authorize deny => onError 0");
                }
                a.InterfaceC0805a interfaceC0805a = b.this.i;
                if (interfaceC0805a != null) {
                    interfaceC0805a.onError(0);
                    return;
                }
                return;
            }
            if (d.b.g0.s.i.a.b.a.v) {
                Log.d("SwanInlineLiveWidget", b.this.f49756f + "-" + hashCode() + " real do prepareAsync");
            }
            b.super.prepareAsync();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f49771e;

        public c(d.b.g0.a.i2.u0.b bVar) {
            this.f49771e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            boolean h2 = d.b.g0.a.v1.c.c.h(hVar);
            if (d.b.g0.s.i.a.b.a.v) {
                Log.d("SwanInlineLiveWidget", b.this.f49756f + "-" + hashCode() + " authorize: " + h2);
            }
            b.this.y = h2 ? 1 : 2;
            this.f49771e.onCallback(Integer.valueOf(b.this.y));
        }
    }

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.y = 0;
        d.b.g0.s.j.a.a aVar = new d.b.g0.s.j.a.a();
        this.x = aVar;
        aVar.e(this.f49753c);
        this.x.f(new a());
    }

    public final void A0(@NonNull Context context, @NonNull d.b.g0.a.i2.u0.b<Integer> bVar) {
        if (d.b.g0.s.i.a.b.a.v) {
            Log.d("SwanInlineLiveWidget", this.f49756f + "-" + hashCode() + " start authorize");
        }
        e O = e.O();
        if (O == null) {
            if (!d.b.g0.s.i.a.b.a.v) {
                bVar.onCallback(0);
                return;
            }
            throw new RuntimeException("inline live authorize: swan app is null");
        } else if (d.b.g0.a.m1.a.a.p()) {
            this.y = 1;
            if (d.b.g0.s.i.a.b.a.v) {
                Log.d("SwanInlineLiveWidget", this.f49756f + "-" + hashCode() + " authorize debug: true");
            }
            bVar.onCallback(Integer.valueOf(this.y));
        } else {
            O.R().g(context, "mapp_i_live_player", new c(bVar));
        }
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void O(String str) {
    }

    @Override // d.b.g0.s.i.a.b.a, d.b.g0.a.s0.k.g.a
    public int a() {
        return this.y;
    }

    @Override // d.b.g0.s.i.a.b.a, d.b.g0.a.s0.k.g.a
    public boolean prepareAsync() {
        if (d.b.g0.s.i.a.b.a.v) {
            Log.d("SwanInlineLiveWidget", this.f49756f + "-" + hashCode() + " start prepareAsync");
        }
        A0(this.f49753c, new C1045b());
        return true;
    }

    @Override // d.b.g0.s.i.a.b.a
    public void r0(int i, int i2, String str) {
    }

    @Override // d.b.g0.s.i.a.b.a, d.b.g0.a.s0.k.g.a
    public void release() {
        super.release();
        d.b.g0.s.j.a.a aVar = this.x;
        if (aVar != null) {
            aVar.g();
            this.x = null;
        }
    }

    @Override // d.b.g0.s.i.a.b.a
    public void s0() {
    }
}
