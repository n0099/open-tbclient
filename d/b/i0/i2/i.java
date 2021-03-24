package d.b.i0.i2;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.util.BdListViewHelper;
import d.b.b.j.e.p;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.a.f f56128b;

    /* renamed from: c  reason: collision with root package name */
    public int f56129c;

    /* renamed from: e  reason: collision with root package name */
    public p f56131e;

    /* renamed from: f  reason: collision with root package name */
    public View f56132f;

    /* renamed from: h  reason: collision with root package name */
    public e f56134h;
    public l i;

    /* renamed from: a  reason: collision with root package name */
    public int f56127a = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f56130d = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56133g = false;
    public boolean j = true;
    public d.b.i0.i2.a k = new d.b.i0.i2.a();
    public final CustomMessageListener l = new a(2000994);
    public final CustomMessageListener m = new b(2921387);
    public d.b.i0.i2.b n = new d.b.i0.i2.b(this);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.w();
                if (i.this.j && i.this.j) {
                    i iVar = i.this;
                    iVar.n(iVar.i.a(), i.this.i.b(), i.this.i.d(), i.this.i.c());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.b.b.e.p.k.isEmpty(str)) {
                    return;
                }
                d.b.b.e.m.e.a().removeCallbacks(i.this.k);
                d.b.b.e.m.e.a().removeCallbacks(i.this.n);
                if (i.this.f56132f != null && (i.this.f56132f.getTag() instanceof e)) {
                    if (str.equals(((e) i.this.f56132f.getTag()).getPlayUrl())) {
                        return;
                    }
                    ((e) i.this.f56132f.getTag()).stopPlay();
                }
                for (int i = 0; i < i.this.f56131e.getListView().getChildCount(); i++) {
                    View childAt = i.this.f56131e.getListView().getChildAt(i);
                    if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                        i.this.f56132f = childAt;
                        return;
                    }
                }
            }
        }
    }

    public i(d.b.b.a.f fVar, p pVar) {
        this.f56129c = 0;
        this.f56128b = fVar;
        this.f56129c = d.b.b.e.p.l.i(fVar.getPageActivity());
        this.f56131e = pVar;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.i = new l();
        fVar.registerListener(this.l);
    }

    public void h() {
        d.b.b.e.m.e.a().removeCallbacks(this.k);
        d.b.b.e.m.e.a().removeCallbacks(this.n);
        i();
    }

    public void i() {
        for (int i = 0; i < this.f56131e.getListView().getChildCount(); i++) {
            View childAt = this.f56131e.getListView().getChildAt(i);
            if (childAt.getTag() instanceof e) {
                ((e) childAt.getTag()).stopPlay();
            }
        }
    }

    public View j() {
        return this.f56132f;
    }

    public void k(View view) {
        if (view == null || l(view) || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) view.getTag()).stopPlay();
    }

    public boolean l(View view) {
        int i;
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.f56127a == 1) {
            int i2 = d.b.b.e.p.l.i(this.f56128b.getPageActivity()) / 2;
            int i3 = rect.top;
            return i3 >= 0 && i3 <= i2 && rect.bottom - i3 >= view.getMeasuredHeight();
        }
        int i4 = rect.top;
        return i4 >= 0 && (i = rect.bottom) <= this.f56129c - this.f56130d && i - i4 >= view.getMeasuredHeight();
    }

    public void m(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        View view;
        this.i.e(i, i2, z);
        p pVar = this.f56131e;
        if (pVar == null || pVar.getListView().getChildCount() == 0 || this.f56131e.getContentViewsCount() == 0) {
            return;
        }
        e eVar = this.f56134h;
        if (eVar != null && !l(eVar.getVideoContainer())) {
            this.f56134h.stopPlay();
        }
        View view2 = this.f56132f;
        int i4 = 0;
        if (view2 != null && (view2.getTag() instanceof e) && this.f56133g) {
            if (l(((e) this.f56132f.getTag()).getVideoContainer())) {
                v(i3, this.f56132f);
                this.f56133g = false;
                return;
            }
            this.f56132f = null;
        }
        int contentViewsCount = this.f56131e.getContentViewsCount() + this.f56131e.getHeaderViewsCount() + this.f56131e.getFooterViewsCount();
        if (i == 0) {
            z2 = true;
        } else {
            int i5 = contentViewsCount - 1;
            z2 = false;
        }
        int childCount = this.f56131e.getListView().getChildCount();
        if (i == 0 || i2 == contentViewsCount - 1) {
            z3 = false;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = this.f56131e.getListView().getChildAt(z2 ? i6 : (childCount - 1) - i6);
                if (childAt.getTag() instanceof e) {
                    e eVar2 = (e) childAt.getTag();
                    if (!z3 && l(eVar2.getVideoContainer())) {
                        v(i3, childAt);
                        z3 = true;
                    } else {
                        y(i3, childAt);
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
            if (i8 >= childCount) {
                break;
            }
            View childAt2 = this.f56131e.getListView().getChildAt(i8);
            if (childAt2.getTag() instanceof e) {
                e eVar3 = (e) childAt2.getTag();
                if (eVar3.isPlayStarted() && l(eVar3.getVideoContainer())) {
                    i7 = i8;
                    break;
                }
            }
            i8++;
        }
        if (i7 >= 0) {
            while (i4 < childCount) {
                View childAt3 = this.f56131e.getListView().getChildAt(i4);
                if (i4 != i7) {
                    y(i3, childAt3);
                } else {
                    v(i3, childAt3);
                }
                i4++;
            }
            return;
        }
        boolean z4 = false;
        while (i4 < childCount) {
            View childAt4 = this.f56131e.getListView().getChildAt(z ? (childCount - 1) - i4 : i4);
            if (childAt4.getTag() instanceof e) {
                e eVar4 = (e) childAt4.getTag();
                if (!z4 && (eVar4.D() || l(eVar4.getVideoContainer()))) {
                    v(i3, childAt4);
                    z4 = true;
                } else {
                    y(i3, childAt4);
                }
            }
            i4++;
        }
        if (z4 || (view = this.f56132f) == null || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) this.f56132f.getTag()).stopPlay();
    }

    public void n(int i, int i2, boolean z, boolean z2) {
        d.b.b.e.m.e.a().removeCallbacks(this.n);
        this.n.a(i);
        this.n.c(i2);
        this.n.b(z);
        this.n.d(z2);
        this.i.f(z2);
        d.b.b.e.m.e.a().postDelayed(this.n, 500L);
    }

    public void o() {
        if (this.j) {
            View view = this.f56132f;
            if (view != null && (view.getTag() instanceof e)) {
                e eVar = (e) this.f56132f.getTag();
                if (this.f56133g) {
                    eVar.startPlay();
                    this.f56133g = false;
                }
                if (this.f56132f.getTag() instanceof d) {
                    ((d) this.f56132f.getTag()).d();
                }
            }
            this.f56132f = null;
        }
    }

    public void p(int i) {
        this.f56127a = i;
    }

    public void q(boolean z) {
        this.j = z;
    }

    public void r(String str) {
    }

    public void s(int i) {
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

    public void u(int i) {
        this.f56130d = i;
    }

    public final void v(int i, View view) {
        if (view == null) {
            return;
        }
        View view2 = this.f56132f;
        if (view2 != null && view2 != view && (view2.getTag() instanceof e)) {
            ((e) this.f56132f.getTag()).stopPlay();
        }
        this.f56132f = view;
        if (i == 1 && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (!this.j || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).b();
        }
    }

    public void w() {
        d.b.b.e.m.e.a().removeCallbacks(this.k);
        d.b.b.e.m.e.a().removeCallbacks(this.n);
        for (int i = 0; i < this.f56131e.getListView().getChildCount(); i++) {
            View childAt = this.f56131e.getListView().getChildAt(i);
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
        for (int i = 0; i < this.f56131e.getListView().getChildCount(); i++) {
            View childAt = this.f56131e.getListView().getChildAt(i);
            if (childAt.getTag() instanceof e) {
                e eVar = (e) childAt.getTag();
                if (eVar.isPlayStarted()) {
                    s(eVar.getCurrentPosition());
                    r(eVar.getPlayUrl());
                    this.f56132f = childAt;
                    this.f56133g = eVar.isPlaying();
                    eVar.stopPlay();
                    return;
                }
            }
        }
    }

    public final void y(int i, View view) {
        if (i == 1 && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.isPlaying()) {
                eVar.stopPlay();
            }
        } else if (i == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).i();
        }
    }
}
