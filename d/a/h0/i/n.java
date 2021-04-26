package d.a.h0.i;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.swan.menu.PopupWindow;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n implements e, d.a.h0.i.r.b, View.OnKeyListener {

    /* renamed from: g  reason: collision with root package name */
    public Context f47084g;

    /* renamed from: h  reason: collision with root package name */
    public int f47085h;

    /* renamed from: i  reason: collision with root package name */
    public p f47086i;
    public List<o> j;
    public e m;
    public d.a.h0.i.r.b n;
    public View.OnKeyListener o;
    public b p;
    public d.a.h0.i.b q;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47082e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f47083f = 0;
    public List<o> k = new ArrayList();
    public List<List<o>> l = new ArrayList();
    public int r = -1;

    /* loaded from: classes3.dex */
    public class a implements PopupWindow.b {
        public a() {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            if (n.this.p != null) {
                n.this.p.a(n.this, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(n nVar, boolean z);
    }

    public n(Context context, View view, int i2, d.a.h0.i.b bVar, @Nullable d.a.h0.i.a aVar) {
        this.j = new ArrayList();
        if (i2 < 0) {
            return;
        }
        this.f47084g = context;
        this.f47085h = i2;
        this.q = bVar;
        List<o> b2 = q.b(i2);
        this.j = b2;
        this.q.b(this.f47085h, b2);
        this.q.c(this.f47085h, this.j);
        p pVar = new p(this.f47084g, view, aVar);
        this.f47086i = pVar;
        pVar.G(new a());
    }

    @Override // d.a.h0.i.r.b
    public boolean a(o oVar) {
        if (o(oVar) && !this.f47082e) {
            f(true);
        }
        d.a.h0.i.r.b bVar = this.n;
        if (bVar != null) {
            return bVar.a(oVar);
        }
        return false;
    }

    @Override // d.a.h0.i.e
    public boolean b(View view, o oVar) {
        if (oVar.j()) {
            if (o(oVar)) {
                f(true);
            }
            e eVar = this.m;
            if (eVar != null) {
                return eVar.b(view, oVar);
            }
            return false;
        }
        return true;
    }

    public void d(int i2, int i3) {
        o a2;
        boolean z = false;
        for (o oVar : this.j) {
            if (oVar.c() == i2) {
                z = true;
            }
        }
        if (z || (a2 = q.a(i2)) == null) {
            return;
        }
        int size = this.j.size();
        if (i3 <= 0) {
            i3 = 0;
        } else if (i3 >= size) {
            i3 = size;
        }
        this.j.add(i3, a2);
    }

    public void e() {
        f(true);
    }

    public void f(boolean z) {
        this.f47086i.X(z);
        b bVar = this.p;
        if (bVar != null) {
            bVar.a(this, false);
        }
    }

    public o g(int i2) {
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            o oVar = this.j.get(i3);
            if (oVar.c() == i2) {
                oVar.n(0L);
                oVar.p(this);
                return oVar;
            }
        }
        return null;
    }

    public boolean h() {
        p pVar = this.f47086i;
        return pVar != null && pVar.t();
    }

    public void i() {
        p pVar = this.f47086i;
        if (pVar != null) {
            pVar.Z();
        }
    }

    public final void j(int i2) {
        o g2 = g(i2);
        if (g2 == null || !g2.k()) {
            return;
        }
        this.k.add(g2);
    }

    public void k(int i2) {
        if (this.j == null) {
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i4 < this.j.size(); i4++) {
            if (this.j.get(i4).c() == i2) {
                i3 = i4;
            }
        }
        if (i3 > -1) {
            this.j.remove(i3);
        }
    }

    public void l(int i2) {
        this.f47086i.a0(i2);
    }

    public void m(e eVar) {
        this.m = eVar;
    }

    public void n(int i2) {
        this.f47083f = i2;
    }

    public final boolean o(o oVar) {
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        View.OnKeyListener onKeyListener = this.o;
        if (onKeyListener != null) {
            return onKeyListener.onKey(view, i2, keyEvent);
        }
        return false;
    }

    public void p(boolean z) {
        q(z, 0);
    }

    public void q(boolean z, int i2) {
        r(z, i2, null, false);
    }

    public void r(boolean z, int i2, View view, boolean z2) {
        if (h()) {
            f(true);
            return;
        }
        d.a.h0.i.b bVar = this.q;
        if (bVar != null) {
            bVar.a(this.f47085h, this.j);
        }
        u(z, i2);
        s();
        this.f47086i.b0(this.l, view, z2, this.f47083f);
        b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.a(this, true);
        }
    }

    public final void s() {
        this.l.clear();
        int size = this.k.size();
        if (size > 0 && size <= 5) {
            this.l.add(this.k);
        } else if (size > 5 && size <= 10) {
            int i2 = this.f47082e ? 5 : this.r;
            this.l.add(this.k.subList(0, i2));
            this.l.add(this.k.subList(i2, size));
        } else if (size > 10) {
            int ceil = this.f47082e ? (int) Math.ceil(size / 2.0f) : this.r;
            this.l.add(this.k.subList(0, ceil));
            this.l.add(this.k.subList(ceil, size));
        }
    }

    public final o t(o oVar, int i2) {
        if (oVar == null) {
            return null;
        }
        if (i2 == 2) {
            oVar.q(k.aiapp_menu_text_cancel_favorite);
            oVar.m(h.aiapp_menu_item_cancel_fav_selector);
            return oVar;
        } else if (i2 == 1) {
            oVar.q(k.aiapp_menu_text_favorite);
            oVar.m(h.aiapp_menu_item_add_fav_selector);
            return oVar;
        } else if (i2 == 0) {
            return null;
        } else {
            return oVar;
        }
    }

    public final void u(boolean z, int i2) {
        if (this.j == null) {
            return;
        }
        this.k.clear();
        j(41);
        o t = t(g(38), i2);
        if (t != null && t.k()) {
            this.k.add(t);
        }
        j(48);
        j(45);
        j(4);
        j(101);
        o g2 = g(35);
        if (g2 != null && g2.k()) {
            this.k.add(g2);
        }
        j(39);
        j(42);
        j(9);
        if (!this.f47082e) {
            this.r = this.k.size() - 1;
        }
        j(37);
        j(100);
        j(43);
        o w = w(g(5), z);
        if (w != null && w.k()) {
            this.k.add(w);
        }
        j(46);
        j(47);
        j(49);
        j(50);
    }

    public void v(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("pa_type");
        Long valueOf = Long.valueOf(jSONObject.optLong("pa_unread_sums"));
        int i2 = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? -1 : 48 : 47 : 46 : 45;
        if (i2 < 0) {
            return;
        }
        for (o oVar : this.k) {
            if (oVar.c() == i2) {
                valueOf = Long.valueOf(valueOf.longValue() + oVar.e());
                oVar.o(valueOf.longValue() > 0 ? 1 : 0);
                oVar.n(valueOf.longValue());
            }
        }
    }

    public final o w(o oVar, boolean z) {
        if (oVar == null) {
            return null;
        }
        oVar.q(z ? k.aiapp_menu_text_day_mode : k.aiapp_menu_text_night_mode);
        oVar.m(z ? h.aiapp_menu_item_daymode : h.aiapp_menu_item_nightmode);
        return oVar;
    }

    public void x(boolean z) {
        w(g(5), z);
        s();
        this.f47086i.W();
        i();
    }
}
