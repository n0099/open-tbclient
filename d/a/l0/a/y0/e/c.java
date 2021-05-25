package d.a.l0.a.y0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
import d.a.l0.a.y0.d;
import d.a.l0.a.y0.e.e.b;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.y0.d {
    public static final boolean j = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public Context f45785a;

    /* renamed from: b  reason: collision with root package name */
    public String f45786b;

    /* renamed from: c  reason: collision with root package name */
    public String f45787c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.h0.g.f f45788d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f45789e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.y0.e.e.b f45790f;

    /* renamed from: g  reason: collision with root package name */
    public f f45791g;

    /* renamed from: h  reason: collision with root package name */
    public int f45792h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f45793i = new e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45794e;

        public a(int i2) {
            this.f45794e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.H0(this.f45794e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.z0();
        }
    }

    /* renamed from: d.a.l0.a.y0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0908c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45797e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45798f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45799g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f45800h;

        public RunnableC0908c(int i2, int i3, int i4, int i5) {
            this.f45797e = i2;
            this.f45798f = i3;
            this.f45799g = i4;
            this.f45800h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F0(this.f45797e, this.f45798f, this.f45799g, this.f45800h);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E0();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.e {
        public e() {
        }

        @Override // d.a.l0.a.y0.e.e.b.e
        public void a() {
            e("onKeyboardHide", null);
            if (c.this.f45791g != null) {
                c.this.f45791g.a();
            }
        }

        @Override // d.a.l0.a.y0.e.e.b.e
        public void b(int i2) {
            e("onKeyboardShow", "height: " + i2);
            if (c.this.f45791g != null) {
                c.this.f45791g.b(i2);
            }
        }

        @Override // d.a.l0.a.y0.e.e.b.e
        public void c(String str) {
            e("onInput", "inputText: " + str);
            if (c.this.f45791g != null) {
                c.this.f45791g.c(str);
            }
        }

        @Override // d.a.l0.a.y0.e.e.b.e
        public void d() {
            e("onDeletePressed", null);
            if (c.this.f45791g != null) {
                c.this.f45791g.d();
            }
        }

        public final void e(String str, @Nullable String str2) {
            if (c.j) {
                String str3 = ("【" + c.this.n0() + "-" + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f45787c = (String) invoker.get("id");
        }
        this.f45785a = d.a.l0.a.c1.a.b();
        this.f45786b = str;
        this.f45789e = new Handler(this.f45785a.getMainLooper());
        this.f45788d = x0();
    }

    public void A0() {
        this.f45789e.post(new b());
    }

    @Override // d.a.l0.a.y0.d
    public void B(@NonNull d.a aVar) {
        if (d.a.l0.a.a2.e.i() == null) {
            aVar.a(false);
        } else {
            aVar.a(true);
        }
    }

    public void B0() {
        this.f45789e.post(new d());
    }

    public void C0(int i2, int i3, int i4, int i5) {
        this.f45789e.post(new RunnableC0908c(i2, i3, i4, i5));
    }

    public void D0(int i2) {
        this.f45789e.post(new a(i2));
    }

    public final void E0() {
        d.a.l0.a.h0.g.f fVar = this.f45788d;
        if (fVar == null || this.f45792h == 0) {
            return;
        }
        this.f45792h = 0;
        if (fVar.k3().getScrollY() > 0) {
            this.f45788d.k3().setScrollY(0);
        }
    }

    public final void F0(int i2, int i3, int i4, int i5) {
        int i6;
        if (this.f45788d == null) {
            return;
        }
        d.a.l0.a.p.e.c h2 = d.a.l0.a.g1.f.V().h();
        if (this.f45792h == i4 || h2 == null) {
            return;
        }
        this.f45792h = i4;
        int height = ((this.f45788d.k3().getHeight() - i2) - i3) + h2.getWebViewScrollY() + n0.k(this.f45785a);
        if (i5 > height) {
            i5 = height;
        }
        int i7 = height - i4;
        int scrollY = this.f45788d.k3().getScrollY();
        if (i7 < 0) {
            i6 = i5 - i7;
        } else {
            if (i5 > i7) {
                scrollY = i5 - i7;
            }
            i6 = scrollY;
        }
        this.f45788d.k3().setScrollY(i6);
    }

    public void G0(@NonNull f fVar) {
        this.f45791g = fVar;
    }

    public final void H0(int i2) {
        Activity y0 = y0();
        if (y0 == null) {
            return;
        }
        d.a.l0.a.y0.e.e.b bVar = new d.a.l0.a.y0.e.e.b(y0, i2, this.f45793i);
        this.f45790f = bVar;
        bVar.e();
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String b() {
        return this.f45786b;
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String n0() {
        return this.f45787c;
    }

    public void release() {
    }

    @Nullable
    public final d.a.l0.a.h0.g.f x0() {
        g W = d.a.l0.a.g1.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i2 = 0; i2 < k; i2++) {
            d.a.l0.a.h0.g.d j2 = W.j(i2);
            if (j2 instanceof d.a.l0.a.h0.g.f) {
                d.a.l0.a.h0.g.f fVar = (d.a.l0.a.h0.g.f) j2;
                if (TextUtils.equals(fVar.g3(), this.f45786b)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity y0() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null) {
            return null;
        }
        return i2.k();
    }

    public final void z0() {
        d.a.l0.a.y0.e.e.b bVar = this.f45790f;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.f45790f = null;
    }
}
