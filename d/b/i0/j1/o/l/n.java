package d.b.i0.j1.o.l;

import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.a.f f57435a;

    /* renamed from: b  reason: collision with root package name */
    public int f57436b;

    /* renamed from: d  reason: collision with root package name */
    public ListView f57438d;

    /* renamed from: h  reason: collision with root package name */
    public View f57442h;
    public d.b.i0.j2.e j;
    public d.b.i0.j2.l k;

    /* renamed from: c  reason: collision with root package name */
    public int f57437c = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f57439e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f57440f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Integer> f57441g = new HashMap();
    public boolean i = false;
    public boolean l = true;
    public d.b.i0.j2.a m = new d.b.i0.j2.a();
    public final CustomMessageListener n = new a(2000994);
    public b o = new b(this);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                n.this.s();
                if (n.this.l && n.this.l) {
                    n nVar = n.this;
                    nVar.k(nVar.k.a(), n.this.k.b(), n.this.k.d(), n.this.k.c());
                }
            }
        }
    }

    public n(d.b.c.a.f fVar, ListView listView) {
        this.f57436b = 0;
        this.f57435a = fVar;
        this.f57436b = d.b.c.e.p.l.i(fVar.getPageActivity());
        this.f57438d = listView;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.k = new d.b.i0.j2.l();
        fVar.registerListener(this.n);
    }

    public void c() {
        d.b.c.e.m.e.a().removeCallbacks(this.m);
        d.b.c.e.m.e.a().removeCallbacks(this.o);
        d();
    }

    public void d() {
        for (int i = 0; i < this.f57438d.getChildCount(); i++) {
            View childAt = this.f57438d.getChildAt(i);
            if (childAt.getTag() instanceof d.b.i0.j2.e) {
                ((d.b.i0.j2.e) childAt.getTag()).stopPlay();
            }
        }
    }

    public String e() {
        return this.f57439e;
    }

    public int f() {
        return this.f57440f;
    }

    public int g(String str) {
        if (this.f57441g.containsKey(str)) {
            return this.f57441g.get(str).intValue();
        }
        return 0;
    }

    public void h(View view) {
        if (view == null || i(view) || !(view.getTag() instanceof d.b.i0.j2.e)) {
            return;
        }
        d.b.i0.j2.e eVar = (d.b.i0.j2.e) view.getTag();
        if (!TextUtils.isEmpty(eVar.getPlayUrl()) && eVar.getCurrentPosition() > 0) {
            q(eVar.getPlayUrl(), eVar.getCurrentPosition());
        }
        eVar.stopPlay();
    }

    public boolean i(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view == null) {
            return false;
        }
        view.getLocationOnScreen(iArr);
        return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.f57437c && measuredHeight < this.f57436b;
    }

    public void j(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        this.k.e(i, i2, z);
        ListView listView = this.f57438d;
        if (listView == null || listView.getChildCount() == 0) {
            return;
        }
        ListView listView2 = this.f57438d;
        ListAdapter wrappedAdapter = listView2 instanceof BdListView ? ((BdListView) listView2).getWrappedAdapter() : listView2.getAdapter();
        if (wrappedAdapter == null || wrappedAdapter.getCount() == 0) {
            return;
        }
        d.b.i0.j2.e eVar = this.j;
        if (eVar != null && !i(eVar.getVideoContainer())) {
            this.j.stopPlay();
        }
        int count = wrappedAdapter.getCount() + this.f57438d.getHeaderViewsCount() + this.f57438d.getFooterViewsCount();
        int i4 = 0;
        if (i == 0) {
            z2 = true;
        } else {
            int i5 = count - 1;
            z2 = false;
        }
        if (i == 0 || i2 == count - 1) {
            z3 = false;
            for (int i6 = 0; i6 < this.f57438d.getChildCount(); i6++) {
                View childAt = this.f57438d.getChildAt(z2 ? i6 : (this.f57438d.getChildCount() - 1) - i6);
                if (childAt.getTag() instanceof d.b.i0.j2.e) {
                    d.b.i0.j2.e eVar2 = (d.b.i0.j2.e) childAt.getTag();
                    if (!z3 && i(eVar2.getVideoContainer())) {
                        r(i3, childAt);
                        z3 = true;
                    } else {
                        if (!TextUtils.isEmpty(eVar2.getPlayUrl()) && eVar2.getCurrentPosition() > 0) {
                            q(eVar2.getPlayUrl(), eVar2.getCurrentPosition());
                        }
                        u(i3, childAt);
                    }
                }
            }
        } else {
            z3 = false;
        }
        if (z3) {
            return;
        }
        int i7 = -1;
        int i8 = 0;
        while (true) {
            if (i8 >= this.f57438d.getChildCount()) {
                break;
            }
            View childAt2 = this.f57438d.getChildAt(i8);
            if (childAt2.getTag() instanceof d.b.i0.j2.e) {
                d.b.i0.j2.e eVar3 = (d.b.i0.j2.e) childAt2.getTag();
                if (eVar3.isPlayStarted() && i(eVar3.getVideoContainer())) {
                    i7 = i8;
                    break;
                }
            }
            i8++;
        }
        if (i7 >= 0) {
            while (i4 < this.f57438d.getChildCount()) {
                View childAt3 = this.f57438d.getChildAt(i4);
                if (i4 == i7) {
                    r(i3, childAt3);
                } else {
                    if (childAt3.getTag() instanceof d.b.i0.j2.e) {
                        d.b.i0.j2.e eVar4 = (d.b.i0.j2.e) childAt3.getTag();
                        if (!TextUtils.isEmpty(eVar4.getPlayUrl()) && eVar4.getCurrentPosition() > 0) {
                            q(eVar4.getPlayUrl(), eVar4.getCurrentPosition());
                        }
                    }
                    u(i3, childAt3);
                }
                i4++;
            }
            return;
        }
        boolean z4 = false;
        while (i4 < this.f57438d.getChildCount()) {
            View childAt4 = this.f57438d.getChildAt(z ? (this.f57438d.getChildCount() - 1) - i4 : i4);
            if (childAt4.getTag() instanceof d.b.i0.j2.e) {
                d.b.i0.j2.e eVar5 = (d.b.i0.j2.e) childAt4.getTag();
                if (!z4 && i(eVar5.getVideoContainer())) {
                    r(i3, childAt4);
                    z4 = true;
                } else {
                    if (!TextUtils.isEmpty(eVar5.getPlayUrl()) && eVar5.getCurrentPosition() > 0) {
                        q(eVar5.getPlayUrl(), eVar5.getCurrentPosition());
                    }
                    u(i3, childAt4);
                }
            }
            i4++;
        }
    }

    public void k(int i, int i2, boolean z, boolean z2) {
        d.b.c.e.m.e.a().removeCallbacks(this.o);
        this.o.a(i);
        this.o.c(i2);
        this.o.b(z);
        this.o.d(z2);
        this.k.f(z2);
        d.b.c.e.m.e.a().post(this.o);
    }

    public void l(String str) {
        if (this.f57441g.containsKey(str)) {
            this.f57441g.put(str, 0);
        }
    }

    public void m() {
        if (this.l) {
            View view = this.f57442h;
            if (view != null && (view.getTag() instanceof d.b.i0.j2.e)) {
                d.b.i0.j2.e eVar = (d.b.i0.j2.e) this.f57442h.getTag();
                if (this.i) {
                    eVar.startPlay();
                }
                if (this.f57442h.getTag() instanceof d.b.i0.j2.d) {
                    ((d.b.i0.j2.d) this.f57442h.getTag()).d();
                }
            }
            this.f57442h = null;
        }
    }

    public void n(boolean z) {
        this.l = z;
    }

    public void o(String str) {
        this.f57439e = str;
    }

    public void p(int i) {
        this.f57440f = i;
    }

    public void q(String str, int i) {
        if (this.f57441g.containsKey(str)) {
            if (this.f57441g.get(str).intValue() == 0) {
                return;
            }
            this.f57441g.put(str, Integer.valueOf(i));
            return;
        }
        this.f57441g.put(str, Integer.valueOf(i));
    }

    public final void r(int i, View view) {
        if (view == null) {
            return;
        }
        this.f57442h = view;
        if (i == 1 && (view.getTag() instanceof d.b.i0.j2.e)) {
            d.b.i0.j2.e eVar = (d.b.i0.j2.e) view.getTag();
            if (!this.l || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i == 2 && (view.getTag() instanceof d.b.i0.j2.d)) {
            ((d.b.i0.j2.d) view.getTag()).b();
        }
    }

    public void s() {
        d.b.c.e.m.e.a().removeCallbacks(this.m);
        d.b.c.e.m.e.a().removeCallbacks(this.o);
        for (int i = 0; i < this.f57438d.getChildCount(); i++) {
            View childAt = this.f57438d.getChildAt(i);
            if (childAt.getTag() instanceof d.b.i0.j2.e) {
                d.b.i0.j2.e eVar = (d.b.i0.j2.e) childAt.getTag();
                if (eVar.isPlayStarted()) {
                    eVar.stopPlay();
                    return;
                }
            }
        }
    }

    public void t() {
        for (int i = 0; i < this.f57438d.getChildCount(); i++) {
            View childAt = this.f57438d.getChildAt(i);
            if (childAt.getTag() instanceof d.b.i0.j2.e) {
                d.b.i0.j2.e eVar = (d.b.i0.j2.e) childAt.getTag();
                if (eVar.isPlayStarted()) {
                    p(eVar.getCurrentPosition());
                    o(eVar.getPlayUrl());
                    this.f57442h = childAt;
                    this.i = eVar.isPlaying();
                    eVar.stopPlay();
                    return;
                }
            }
        }
    }

    public final void u(int i, View view) {
        if (i == 1 && (view.getTag() instanceof d.b.i0.j2.e)) {
            ((d.b.i0.j2.e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof d.b.i0.j2.d)) {
            ((d.b.i0.j2.d) view.getTag()).i();
        }
    }
}
