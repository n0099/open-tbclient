package d.b.g0.i;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.swan.menu.PopupWindow;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n implements e, d.b.g0.i.r.b, View.OnKeyListener {

    /* renamed from: g  reason: collision with root package name */
    public Context f48858g;

    /* renamed from: h  reason: collision with root package name */
    public int f48859h;
    public p i;
    public List<o> j;
    public e m;
    public d.b.g0.i.r.b n;
    public View.OnKeyListener o;
    public b p;
    public d.b.g0.i.b q;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48856e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f48857f = 0;
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

    public n(Context context, View view, int i, d.b.g0.i.b bVar, @Nullable d.b.g0.i.a aVar) {
        this.j = new ArrayList();
        if (i < 0) {
            return;
        }
        this.f48858g = context;
        this.f48859h = i;
        this.q = bVar;
        List<o> b2 = q.b(i);
        this.j = b2;
        this.q.c(this.f48859h, b2);
        this.q.d(this.f48859h, this.j);
        p pVar = new p(this.f48858g, view, aVar);
        this.i = pVar;
        pVar.G(new a());
    }

    @Override // d.b.g0.i.r.b
    public boolean a(o oVar) {
        if (o(oVar) && !this.f48856e) {
            f(true);
        }
        d.b.g0.i.r.b bVar = this.n;
        if (bVar != null) {
            return bVar.a(oVar);
        }
        return false;
    }

    @Override // d.b.g0.i.e
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

    public void d(int i, int i2) {
        o a2;
        boolean z = false;
        for (o oVar : this.j) {
            if (oVar.c() == i) {
                z = true;
            }
        }
        if (z || (a2 = q.a(i)) == null) {
            return;
        }
        int size = this.j.size();
        if (i2 <= 0) {
            i2 = 0;
        } else if (i2 >= size) {
            i2 = size;
        }
        this.j.add(i2, a2);
    }

    public void e() {
        f(true);
    }

    public void f(boolean z) {
        this.i.Y(z);
        b bVar = this.p;
        if (bVar != null) {
            bVar.a(this, false);
        }
    }

    public o g(int i) {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            o oVar = this.j.get(i2);
            if (oVar.c() == i) {
                oVar.n(0L);
                oVar.p(this);
                return oVar;
            }
        }
        return null;
    }

    public boolean h() {
        p pVar = this.i;
        return pVar != null && pVar.u();
    }

    public void i() {
        p pVar = this.i;
        if (pVar != null) {
            pVar.c0();
        }
    }

    public final void j(int i) {
        o g2 = g(i);
        if (g2 == null || !g2.k()) {
            return;
        }
        this.k.add(g2);
    }

    public void k(int i) {
        if (this.j == null) {
            return;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            if (this.j.get(i3).c() == i) {
                i2 = i3;
            }
        }
        if (i2 > -1) {
            this.j.remove(i2);
        }
    }

    public void l(int i) {
        this.i.d0(i);
    }

    public void m(e eVar) {
        this.m = eVar;
    }

    public void n(int i) {
        this.f48857f = i;
    }

    public final boolean o(o oVar) {
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        View.OnKeyListener onKeyListener = this.o;
        if (onKeyListener != null) {
            return onKeyListener.onKey(view, i, keyEvent);
        }
        return false;
    }

    public void p(boolean z) {
        q(z, 0);
    }

    public void q(boolean z, int i) {
        r(z, i, null, false);
    }

    public void r(boolean z, int i, View view, boolean z2) {
        if (h()) {
            f(true);
            return;
        }
        d.b.g0.i.b bVar = this.q;
        if (bVar != null) {
            bVar.a(this.f48859h, this.j);
        }
        u(z, i);
        s();
        this.i.f0(this.l, view, z2, this.f48857f);
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
            int i = this.f48856e ? 5 : this.r;
            this.l.add(this.k.subList(0, i));
            this.l.add(this.k.subList(i, size));
        } else if (size > 10) {
            int ceil = this.f48856e ? (int) Math.ceil(size / 2.0f) : this.r;
            this.l.add(this.k.subList(0, ceil));
            this.l.add(this.k.subList(ceil, size));
        }
    }

    public final o t(o oVar, int i) {
        if (oVar == null) {
            return null;
        }
        if (i == 2) {
            oVar.q(k.aiapp_menu_text_cancel_favorite);
            oVar.m(h.aiapp_menu_item_cancel_fav_selector);
            return oVar;
        } else if (i == 1) {
            oVar.q(k.aiapp_menu_text_favorite);
            oVar.m(h.aiapp_menu_item_add_fav_selector);
            return oVar;
        } else if (i == 0) {
            return null;
        } else {
            return oVar;
        }
    }

    public final void u(boolean z, int i) {
        if (this.j == null) {
            return;
        }
        this.k.clear();
        j(41);
        o t = t(g(38), i);
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
        if (!this.f48856e) {
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
        int i = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? -1 : 48 : 47 : 46 : 45;
        if (i < 0) {
            return;
        }
        for (o oVar : this.k) {
            if (oVar.c() == i) {
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
        this.i.X();
        i();
    }
}
