package d.a.j0.j1.o.l;

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
    public d.a.c.a.f f55825a;

    /* renamed from: b  reason: collision with root package name */
    public int f55826b;

    /* renamed from: d  reason: collision with root package name */
    public ListView f55828d;

    /* renamed from: h  reason: collision with root package name */
    public View f55832h;
    public d.a.j0.j2.e j;
    public d.a.j0.j2.l k;

    /* renamed from: c  reason: collision with root package name */
    public int f55827c = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f55829e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f55830f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Integer> f55831g = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public boolean f55833i = false;
    public boolean l = true;
    public d.a.j0.j2.a m = new d.a.j0.j2.a();
    public final CustomMessageListener n = new a(2000994);
    public b o = new b(this);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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

    public n(d.a.c.a.f fVar, ListView listView) {
        this.f55826b = 0;
        this.f55825a = fVar;
        this.f55826b = d.a.c.e.p.l.i(fVar.getPageActivity());
        this.f55828d = listView;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.k = new d.a.j0.j2.l();
        fVar.registerListener(this.n);
    }

    public void c() {
        d.a.c.e.m.e.a().removeCallbacks(this.m);
        d.a.c.e.m.e.a().removeCallbacks(this.o);
        d();
    }

    public void d() {
        for (int i2 = 0; i2 < this.f55828d.getChildCount(); i2++) {
            View childAt = this.f55828d.getChildAt(i2);
            if (childAt.getTag() instanceof d.a.j0.j2.e) {
                ((d.a.j0.j2.e) childAt.getTag()).stopPlay();
            }
        }
    }

    public String e() {
        return this.f55829e;
    }

    public int f() {
        return this.f55830f;
    }

    public int g(String str) {
        if (this.f55831g.containsKey(str)) {
            return this.f55831g.get(str).intValue();
        }
        return 0;
    }

    public void h(View view) {
        if (view == null || i(view) || !(view.getTag() instanceof d.a.j0.j2.e)) {
            return;
        }
        d.a.j0.j2.e eVar = (d.a.j0.j2.e) view.getTag();
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
        return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.f55827c && measuredHeight < this.f55826b;
    }

    public void j(int i2, int i3, boolean z, int i4) {
        boolean z2;
        boolean z3;
        this.k.e(i2, i3, z);
        ListView listView = this.f55828d;
        if (listView == null || listView.getChildCount() == 0) {
            return;
        }
        ListView listView2 = this.f55828d;
        ListAdapter wrappedAdapter = listView2 instanceof BdListView ? ((BdListView) listView2).getWrappedAdapter() : listView2.getAdapter();
        if (wrappedAdapter == null || wrappedAdapter.getCount() == 0) {
            return;
        }
        d.a.j0.j2.e eVar = this.j;
        if (eVar != null && !i(eVar.getVideoContainer())) {
            this.j.stopPlay();
        }
        int count = wrappedAdapter.getCount() + this.f55828d.getHeaderViewsCount() + this.f55828d.getFooterViewsCount();
        int i5 = 0;
        if (i2 == 0) {
            z2 = true;
        } else {
            int i6 = count - 1;
            z2 = false;
        }
        if (i2 == 0 || i3 == count - 1) {
            z3 = false;
            for (int i7 = 0; i7 < this.f55828d.getChildCount(); i7++) {
                View childAt = this.f55828d.getChildAt(z2 ? i7 : (this.f55828d.getChildCount() - 1) - i7);
                if (childAt.getTag() instanceof d.a.j0.j2.e) {
                    d.a.j0.j2.e eVar2 = (d.a.j0.j2.e) childAt.getTag();
                    if (!z3 && i(eVar2.getVideoContainer())) {
                        r(i4, childAt);
                        z3 = true;
                    } else {
                        if (!TextUtils.isEmpty(eVar2.getPlayUrl()) && eVar2.getCurrentPosition() > 0) {
                            q(eVar2.getPlayUrl(), eVar2.getCurrentPosition());
                        }
                        u(i4, childAt);
                    }
                }
            }
        } else {
            z3 = false;
        }
        if (z3) {
            return;
        }
        int i8 = -1;
        int i9 = 0;
        while (true) {
            if (i9 >= this.f55828d.getChildCount()) {
                break;
            }
            View childAt2 = this.f55828d.getChildAt(i9);
            if (childAt2.getTag() instanceof d.a.j0.j2.e) {
                d.a.j0.j2.e eVar3 = (d.a.j0.j2.e) childAt2.getTag();
                if (eVar3.isPlayStarted() && i(eVar3.getVideoContainer())) {
                    i8 = i9;
                    break;
                }
            }
            i9++;
        }
        if (i8 >= 0) {
            while (i5 < this.f55828d.getChildCount()) {
                View childAt3 = this.f55828d.getChildAt(i5);
                if (i5 == i8) {
                    r(i4, childAt3);
                } else {
                    if (childAt3.getTag() instanceof d.a.j0.j2.e) {
                        d.a.j0.j2.e eVar4 = (d.a.j0.j2.e) childAt3.getTag();
                        if (!TextUtils.isEmpty(eVar4.getPlayUrl()) && eVar4.getCurrentPosition() > 0) {
                            q(eVar4.getPlayUrl(), eVar4.getCurrentPosition());
                        }
                    }
                    u(i4, childAt3);
                }
                i5++;
            }
            return;
        }
        boolean z4 = false;
        while (i5 < this.f55828d.getChildCount()) {
            View childAt4 = this.f55828d.getChildAt(z ? (this.f55828d.getChildCount() - 1) - i5 : i5);
            if (childAt4.getTag() instanceof d.a.j0.j2.e) {
                d.a.j0.j2.e eVar5 = (d.a.j0.j2.e) childAt4.getTag();
                if (!z4 && i(eVar5.getVideoContainer())) {
                    r(i4, childAt4);
                    z4 = true;
                } else {
                    if (!TextUtils.isEmpty(eVar5.getPlayUrl()) && eVar5.getCurrentPosition() > 0) {
                        q(eVar5.getPlayUrl(), eVar5.getCurrentPosition());
                    }
                    u(i4, childAt4);
                }
            }
            i5++;
        }
    }

    public void k(int i2, int i3, boolean z, boolean z2) {
        d.a.c.e.m.e.a().removeCallbacks(this.o);
        this.o.a(i2);
        this.o.c(i3);
        this.o.b(z);
        this.o.d(z2);
        this.k.f(z2);
        d.a.c.e.m.e.a().post(this.o);
    }

    public void l(String str) {
        if (this.f55831g.containsKey(str)) {
            this.f55831g.put(str, 0);
        }
    }

    public void m() {
        if (this.l) {
            View view = this.f55832h;
            if (view != null && (view.getTag() instanceof d.a.j0.j2.e)) {
                d.a.j0.j2.e eVar = (d.a.j0.j2.e) this.f55832h.getTag();
                if (this.f55833i) {
                    eVar.startPlay();
                }
                if (this.f55832h.getTag() instanceof d.a.j0.j2.d) {
                    ((d.a.j0.j2.d) this.f55832h.getTag()).c();
                }
            }
            this.f55832h = null;
        }
    }

    public void n(boolean z) {
        this.l = z;
    }

    public void o(String str) {
        this.f55829e = str;
    }

    public void p(int i2) {
        this.f55830f = i2;
    }

    public void q(String str, int i2) {
        if (this.f55831g.containsKey(str)) {
            if (this.f55831g.get(str).intValue() == 0) {
                return;
            }
            this.f55831g.put(str, Integer.valueOf(i2));
            return;
        }
        this.f55831g.put(str, Integer.valueOf(i2));
    }

    public final void r(int i2, View view) {
        if (view == null) {
            return;
        }
        this.f55832h = view;
        if (i2 == 1 && (view.getTag() instanceof d.a.j0.j2.e)) {
            d.a.j0.j2.e eVar = (d.a.j0.j2.e) view.getTag();
            if (!this.l || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i2 == 2 && (view.getTag() instanceof d.a.j0.j2.d)) {
            ((d.a.j0.j2.d) view.getTag()).b();
        }
    }

    public void s() {
        d.a.c.e.m.e.a().removeCallbacks(this.m);
        d.a.c.e.m.e.a().removeCallbacks(this.o);
        for (int i2 = 0; i2 < this.f55828d.getChildCount(); i2++) {
            View childAt = this.f55828d.getChildAt(i2);
            if (childAt.getTag() instanceof d.a.j0.j2.e) {
                d.a.j0.j2.e eVar = (d.a.j0.j2.e) childAt.getTag();
                if (eVar.isPlayStarted()) {
                    eVar.stopPlay();
                    return;
                }
            }
        }
    }

    public void t() {
        for (int i2 = 0; i2 < this.f55828d.getChildCount(); i2++) {
            View childAt = this.f55828d.getChildAt(i2);
            if (childAt.getTag() instanceof d.a.j0.j2.e) {
                d.a.j0.j2.e eVar = (d.a.j0.j2.e) childAt.getTag();
                if (eVar.isPlayStarted()) {
                    p(eVar.getCurrentPosition());
                    o(eVar.getPlayUrl());
                    this.f55832h = childAt;
                    this.f55833i = eVar.isPlaying();
                    eVar.stopPlay();
                    return;
                }
            }
        }
    }

    public final void u(int i2, View view) {
        if (i2 == 1 && (view.getTag() instanceof d.a.j0.j2.e)) {
            ((d.a.j0.j2.e) view.getTag()).stopPlay();
        } else if (i2 == 2 && (view.getTag() instanceof d.a.j0.j2.d)) {
            ((d.a.j0.j2.d) view.getTag()).d();
        }
    }
}
