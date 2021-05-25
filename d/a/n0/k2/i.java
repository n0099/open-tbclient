package d.a.n0.k2;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.util.BdListViewHelper;
import d.a.c.j.e.p;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.a.f f56861b;

    /* renamed from: c  reason: collision with root package name */
    public int f56862c;

    /* renamed from: e  reason: collision with root package name */
    public p f56864e;

    /* renamed from: f  reason: collision with root package name */
    public View f56865f;

    /* renamed from: h  reason: collision with root package name */
    public e f56867h;

    /* renamed from: i  reason: collision with root package name */
    public l f56868i;

    /* renamed from: a  reason: collision with root package name */
    public int f56860a = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f56863d = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56866g = false;
    public boolean j = true;
    public d.a.n0.k2.a k = new d.a.n0.k2.a();
    public final CustomMessageListener l = new a(2000994);
    public final CustomMessageListener m = new b(2921387);
    public d.a.n0.k2.b n = new d.a.n0.k2.b(this);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.w();
                if (i.this.j && i.this.j) {
                    i iVar = i.this;
                    iVar.n(iVar.f56868i.a(), i.this.f56868i.b(), i.this.f56868i.d(), i.this.f56868i.c());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.a.c.e.p.k.isEmpty(str)) {
                    return;
                }
                d.a.c.e.m.e.a().removeCallbacks(i.this.k);
                d.a.c.e.m.e.a().removeCallbacks(i.this.n);
                if (i.this.f56865f != null && (i.this.f56865f.getTag() instanceof e)) {
                    if (str.equals(((e) i.this.f56865f.getTag()).getPlayUrl())) {
                        return;
                    }
                    ((e) i.this.f56865f.getTag()).stopPlay();
                }
                for (int i2 = 0; i2 < i.this.f56864e.getListView().getChildCount(); i2++) {
                    View childAt = i.this.f56864e.getListView().getChildAt(i2);
                    if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                        i.this.f56865f = childAt;
                        return;
                    }
                }
            }
        }
    }

    public i(d.a.c.a.f fVar, p pVar) {
        this.f56862c = 0;
        this.f56861b = fVar;
        this.f56862c = d.a.c.e.p.l.i(fVar.getPageActivity());
        this.f56864e = pVar;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.f56868i = new l();
        fVar.registerListener(this.l);
    }

    public void h() {
        d.a.c.e.m.e.a().removeCallbacks(this.k);
        d.a.c.e.m.e.a().removeCallbacks(this.n);
        i();
    }

    public void i() {
        for (int i2 = 0; i2 < this.f56864e.getListView().getChildCount(); i2++) {
            View childAt = this.f56864e.getListView().getChildAt(i2);
            if (childAt.getTag() instanceof e) {
                ((e) childAt.getTag()).stopPlay();
            }
        }
    }

    public View j() {
        return this.f56865f;
    }

    public void k(View view) {
        if (view == null || l(view) || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) view.getTag()).stopPlay();
    }

    public boolean l(View view) {
        int i2;
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.f56860a == 1) {
            int i3 = d.a.c.e.p.l.i(this.f56861b.getPageActivity()) / 2;
            int i4 = rect.top;
            return i4 >= 0 && i4 <= i3 && rect.bottom - i4 >= view.getMeasuredHeight();
        }
        int i5 = rect.top;
        return i5 >= 0 && (i2 = rect.bottom) <= this.f56862c - this.f56863d && i2 - i5 >= view.getMeasuredHeight();
    }

    public void m(int i2, int i3, boolean z, int i4) {
        boolean z2;
        boolean z3;
        View view;
        this.f56868i.e(i2, i3, z);
        p pVar = this.f56864e;
        if (pVar == null || pVar.getListView().getChildCount() == 0 || this.f56864e.getContentViewsCount() == 0) {
            return;
        }
        e eVar = this.f56867h;
        if (eVar != null && !l(eVar.getVideoContainer())) {
            this.f56867h.stopPlay();
        }
        View view2 = this.f56865f;
        int i5 = 0;
        if (view2 != null && (view2.getTag() instanceof e) && this.f56866g) {
            if (l(((e) this.f56865f.getTag()).getVideoContainer())) {
                v(i4, this.f56865f);
                this.f56866g = false;
                return;
            }
            this.f56865f = null;
        }
        int contentViewsCount = this.f56864e.getContentViewsCount() + this.f56864e.getHeaderViewsCount() + this.f56864e.getFooterViewsCount();
        if (i2 == 0) {
            z2 = true;
        } else {
            int i6 = contentViewsCount - 1;
            z2 = false;
        }
        int childCount = this.f56864e.getListView().getChildCount();
        if (i2 == 0 || i3 == contentViewsCount - 1) {
            z3 = false;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = this.f56864e.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                if (childAt.getTag() instanceof e) {
                    e eVar2 = (e) childAt.getTag();
                    if (!z3 && l(eVar2.getVideoContainer())) {
                        v(i4, childAt);
                        z3 = true;
                    } else {
                        y(i4, childAt);
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
            if (i9 >= childCount) {
                break;
            }
            View childAt2 = this.f56864e.getListView().getChildAt(i9);
            if (childAt2.getTag() instanceof e) {
                e eVar3 = (e) childAt2.getTag();
                if (eVar3.isPlayStarted() && l(eVar3.getVideoContainer())) {
                    i8 = i9;
                    break;
                }
            }
            i9++;
        }
        if (i8 >= 0) {
            while (i5 < childCount) {
                View childAt3 = this.f56864e.getListView().getChildAt(i5);
                if (i5 != i8) {
                    y(i4, childAt3);
                } else {
                    v(i4, childAt3);
                }
                i5++;
            }
            return;
        }
        boolean z4 = false;
        while (i5 < childCount) {
            View childAt4 = this.f56864e.getListView().getChildAt(z ? (childCount - 1) - i5 : i5);
            if (childAt4.getTag() instanceof e) {
                e eVar4 = (e) childAt4.getTag();
                if (!z4 && (eVar4.C() || l(eVar4.getVideoContainer()))) {
                    v(i4, childAt4);
                    z4 = true;
                } else {
                    y(i4, childAt4);
                }
            }
            i5++;
        }
        if (z4 || (view = this.f56865f) == null || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) this.f56865f.getTag()).stopPlay();
    }

    public void n(int i2, int i3, boolean z, boolean z2) {
        d.a.c.e.m.e.a().removeCallbacks(this.n);
        this.n.a(i2);
        this.n.c(i3);
        this.n.b(z);
        this.n.d(z2);
        this.f56868i.f(z2);
        d.a.c.e.m.e.a().postDelayed(this.n, 500L);
    }

    public void o() {
        if (this.j) {
            View view = this.f56865f;
            if (view != null && (view.getTag() instanceof e)) {
                e eVar = (e) this.f56865f.getTag();
                if (this.f56866g) {
                    eVar.startPlay();
                    this.f56866g = false;
                }
                if (this.f56865f.getTag() instanceof d) {
                    ((d) this.f56865f.getTag()).c();
                }
            }
            this.f56865f = null;
        }
    }

    public void p(int i2) {
        this.f56860a = i2;
    }

    public void q(boolean z) {
        this.j = z;
    }

    public void r(String str) {
    }

    public void s(int i2) {
    }

    public void t(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.l;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.m;
        if (customMessageListener2 != null) {
            customMessageListener2.setSelfListener(true);
            this.m.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.l);
        MessageManager.getInstance().registerListener(this.m);
    }

    public void u(int i2) {
        this.f56863d = i2;
    }

    public final void v(int i2, View view) {
        if (view == null) {
            return;
        }
        View view2 = this.f56865f;
        if (view2 != null && view2 != view && (view2.getTag() instanceof e)) {
            ((e) this.f56865f.getTag()).stopPlay();
        }
        this.f56865f = view;
        if (i2 == 1 && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (!this.j || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i2 == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).b();
        }
    }

    public void w() {
        d.a.c.e.m.e.a().removeCallbacks(this.k);
        d.a.c.e.m.e.a().removeCallbacks(this.n);
        for (int i2 = 0; i2 < this.f56864e.getListView().getChildCount(); i2++) {
            View childAt = this.f56864e.getListView().getChildAt(i2);
            if (childAt.getTag() instanceof e) {
                e eVar = (e) childAt.getTag();
                if (eVar.isPlayStarted()) {
                    eVar.stopPlay();
                    return;
                }
            }
        }
    }

    public void x() {
        for (int i2 = 0; i2 < this.f56864e.getListView().getChildCount(); i2++) {
            View childAt = this.f56864e.getListView().getChildAt(i2);
            if (childAt.getTag() instanceof e) {
                e eVar = (e) childAt.getTag();
                if (eVar.isPlayStarted()) {
                    s(eVar.getCurrentPosition());
                    r(eVar.getPlayUrl());
                    this.f56865f = childAt;
                    this.f56866g = eVar.isPlaying();
                    eVar.stopPlay();
                    return;
                }
            }
        }
    }

    public final void y(int i2, View view) {
        if (i2 == 1 && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.isPlaying()) {
                eVar.stopPlay();
            }
        } else if (i2 == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).d();
        }
    }
}
