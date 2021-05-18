package d.a.i0.a.y0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.k;
import d.a.i0.a.v2.n0;
import d.a.i0.a.y0.d;
import d.a.i0.a.y0.e.e.b;
/* loaded from: classes.dex */
public class c implements d.a.i0.a.y0.d {
    public static final boolean j = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public Context f45609a;

    /* renamed from: b  reason: collision with root package name */
    public String f45610b;

    /* renamed from: c  reason: collision with root package name */
    public String f45611c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.h0.g.f f45612d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f45613e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.a.y0.e.e.b f45614f;

    /* renamed from: g  reason: collision with root package name */
    public f f45615g;

    /* renamed from: h  reason: collision with root package name */
    public int f45616h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f45617i = new e();

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45618e;

        public a(int i2) {
            this.f45618e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.H0(this.f45618e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.z0();
        }
    }

    /* renamed from: d.a.i0.a.y0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0897c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45621e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45622f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45623g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f45624h;

        public RunnableC0897c(int i2, int i3, int i4, int i5) {
            this.f45621e = i2;
            this.f45622f = i3;
            this.f45623g = i4;
            this.f45624h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F0(this.f45621e, this.f45622f, this.f45623g, this.f45624h);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E0();
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.e {
        public e() {
        }

        @Override // d.a.i0.a.y0.e.e.b.e
        public void a() {
            e("onKeyboardHide", null);
            if (c.this.f45615g != null) {
                c.this.f45615g.a();
            }
        }

        @Override // d.a.i0.a.y0.e.e.b.e
        public void b(int i2) {
            e("onKeyboardShow", "height: " + i2);
            if (c.this.f45615g != null) {
                c.this.f45615g.b(i2);
            }
        }

        @Override // d.a.i0.a.y0.e.e.b.e
        public void c(String str) {
            e("onInput", "inputText: " + str);
            if (c.this.f45615g != null) {
                c.this.f45615g.c(str);
            }
        }

        @Override // d.a.i0.a.y0.e.e.b.e
        public void d() {
            e("onDeletePressed", null);
            if (c.this.f45615g != null) {
                c.this.f45615g.d();
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

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f45611c = (String) invoker.get("id");
        }
        this.f45609a = d.a.i0.a.c1.a.b();
        this.f45610b = str;
        this.f45613e = new Handler(this.f45609a.getMainLooper());
        this.f45612d = x0();
    }

    public void A0() {
        this.f45613e.post(new b());
    }

    @Override // d.a.i0.a.y0.d
    public void B(@NonNull d.a aVar) {
        if (d.a.i0.a.a2.e.i() == null) {
            aVar.a(false);
        } else {
            aVar.a(true);
        }
    }

    public void B0() {
        this.f45613e.post(new d());
    }

    public void C0(int i2, int i3, int i4, int i5) {
        this.f45613e.post(new RunnableC0897c(i2, i3, i4, i5));
    }

    public void D0(int i2) {
        this.f45613e.post(new a(i2));
    }

    public final void E0() {
        d.a.i0.a.h0.g.f fVar = this.f45612d;
        if (fVar == null || this.f45616h == 0) {
            return;
        }
        this.f45616h = 0;
        if (fVar.k3().getScrollY() > 0) {
            this.f45612d.k3().setScrollY(0);
        }
    }

    public final void F0(int i2, int i3, int i4, int i5) {
        int i6;
        if (this.f45612d == null) {
            return;
        }
        d.a.i0.a.p.e.c h2 = d.a.i0.a.g1.f.V().h();
        if (this.f45616h == i4 || h2 == null) {
            return;
        }
        this.f45616h = i4;
        int height = ((this.f45612d.k3().getHeight() - i2) - i3) + h2.getWebViewScrollY() + n0.k(this.f45609a);
        if (i5 > height) {
            i5 = height;
        }
        int i7 = height - i4;
        int scrollY = this.f45612d.k3().getScrollY();
        if (i7 < 0) {
            i6 = i5 - i7;
        } else {
            if (i5 > i7) {
                scrollY = i5 - i7;
            }
            i6 = scrollY;
        }
        this.f45612d.k3().setScrollY(i6);
    }

    public void G0(@NonNull f fVar) {
        this.f45615g = fVar;
    }

    public final void H0(int i2) {
        Activity y0 = y0();
        if (y0 == null) {
            return;
        }
        d.a.i0.a.y0.e.e.b bVar = new d.a.i0.a.y0.e.e.b(y0, i2, this.f45617i);
        this.f45614f = bVar;
        bVar.e();
    }

    @Override // d.a.i0.a.y0.d
    @Nullable
    public String b() {
        return this.f45610b;
    }

    @Override // d.a.i0.a.y0.d
    @Nullable
    public String n0() {
        return this.f45611c;
    }

    public void release() {
    }

    @Nullable
    public final d.a.i0.a.h0.g.f x0() {
        g W = d.a.i0.a.g1.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i2 = 0; i2 < k; i2++) {
            d.a.i0.a.h0.g.d j2 = W.j(i2);
            if (j2 instanceof d.a.i0.a.h0.g.f) {
                d.a.i0.a.h0.g.f fVar = (d.a.i0.a.h0.g.f) j2;
                if (TextUtils.equals(fVar.g3(), this.f45610b)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity y0() {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 == null) {
            return null;
        }
        return i2.k();
    }

    public final void z0() {
        d.a.i0.a.y0.e.e.b bVar = this.f45614f;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.f45614f = null;
    }
}
