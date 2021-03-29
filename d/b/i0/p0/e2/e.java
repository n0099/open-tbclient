package d.b.i0.p0.e2;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i0.p0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public l f57431a;

    /* renamed from: b  reason: collision with root package name */
    public a2 f57432b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f57433c = new c(2921324);

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f57434d = new d(2016488);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f57435e = new C1383e(2016553);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f57436f = new g(2016331);

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f57437a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f57438b;

        public a(View view, String str) {
            this.f57437a = view;
            this.f57438b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (e.this.f57431a == null || e.this.f57431a.x0() == null || e.this.f57431a.x0().Z() == null || e.this.f57431a.x0().U() == null) {
                return;
            }
            e.this.f57431a.x0().Z().removeView(this.f57437a);
            e.this.j(this.f57438b);
            e.this.f57431a.x0().U().notifyDataSetChanged();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f57440a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f57441b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f57442c;

        public b(String str, String str2, View view) {
            this.f57440a = str;
            this.f57441b = str2;
            this.f57442c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            e.this.k(this.f57440a, this.f57441b);
            this.f57442c.setVisibility(8);
            if (e.this.f57431a.x0() == null || e.this.f57431a.x0().U() == null) {
                return;
            }
            e.this.f57431a.x0().U().notifyDataSetChanged();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.n(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.t(customResponsedMessage);
        }
    }

    /* renamed from: d.b.i0.p0.e2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1383e extends CustomMessageListener {
        public C1383e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.j(e.this.u(customResponsedMessage));
            e.this.f57431a.x0().U().notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends Animation {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57447e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f57448f;

        public f(e eVar, int i, View view) {
            this.f57447e = i;
            this.f57448f = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i = this.f57447e;
            this.f57448f.getLayoutParams().height = i - ((int) (i * f2));
            this.f57448f.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || e.this.f57431a == null || e.this.f57431a.M() == null || e.this.f57431a.M().Z() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            e.this.m(str, e.this.f57431a.M().Z().getForum().getBannerListData().getAllAdvertList());
            e eVar = e.this;
            eVar.l(str, eVar.f57431a.x0().Z().getData());
            e eVar2 = e.this;
            eVar2.l(str, eVar2.f57431a.d0().f().v());
            e.this.f57431a.M().E(str);
            if (e.this.f57431a.x0() == null || e.this.f57431a.x0().U() == null) {
                return;
            }
            e.this.f57431a.x0().U().notifyDataSetChanged();
        }
    }

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.f57431a = lVar;
        this.f57434d.setTag(bdUniqueId);
        this.f57436f.setTag(bdUniqueId);
        this.f57433c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f57433c);
        MessageManager.getInstance().registerListener(this.f57434d);
        MessageManager.getInstance().registerListener(this.f57436f);
        this.f57435e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f57435e);
    }

    public final void i() {
        a2 a2Var = this.f57432b;
        if (a2Var == null || !a2Var.P1) {
            return;
        }
        TbPageTag tbPageTag = null;
        l lVar = this.f57431a;
        if (lVar != null && lVar.x0() != null) {
            tbPageTag = d.b.h0.j0.c.k(this.f57431a.x0().T());
        }
        d.b.i0.p0.j2.a.h(this.f57432b, tbPageTag);
    }

    public final void j(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        ArrayList<d.b.b.j.e.n> threadList = this.f57431a.M().Z().getThreadList();
        p(str, threadList);
        p(str, this.f57431a.x0().Z().getData());
        p(str, this.f57431a.d0().e());
        this.f57431a.M().G(str);
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f57431a.loadMore();
    }

    public final void k(String str, String str2) {
        ArrayList<d.b.b.j.e.n> threadList = this.f57431a.M().Z().getThreadList();
        q(str, str2, threadList);
        q(str, str2, this.f57431a.x0().Z().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.f57431a.M().F(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.f57431a.M().G(str2);
        }
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f57431a.loadMore();
    }

    public final void l(String str, List<d.b.b.j.e.n> list) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<d.b.b.j.e.n> it = list.iterator();
        while (it.hasNext()) {
            d.b.b.j.e.n next = it.next();
            if (next instanceof d.b.i0.e.c) {
                Object a2 = ((d.b.i0.e.c) next).a();
                if ((a2 instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) a2).E3)) {
                    it.remove();
                }
            }
        }
    }

    public final void m(String str, List<AdvertAppInfo> list) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            if (next != null && str.equals(next.E3)) {
                it.remove();
            }
        }
    }

    public final void n(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (lVar = this.f57431a) == null || lVar.M() == null || this.f57431a.M().Z() == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("type");
        if (StringUtils.isNull(optString)) {
            return;
        }
        String optString2 = jSONObject.optString("tid");
        if (this.f57431a.x0() == null || this.f57431a.x0().U() == null) {
            return;
        }
        View childAt = this.f57431a.x0().Z().getChildAt(s(optString, optString2, this.f57431a.x0().Z()));
        if (childAt != null) {
            o(childAt, new b(optString, optString2, childAt));
            return;
        }
        k(optString, optString2);
        this.f57431a.x0().U().notifyDataSetChanged();
    }

    public final void o(View view, Animation.AnimationListener animationListener) {
        f fVar = new f(this, view.getMeasuredHeight(), view);
        fVar.setAnimationListener(animationListener);
        fVar.setDuration(300L);
        view.startAnimation(fVar);
    }

    public final void p(String str, List<d.b.b.j.e.n> list) {
        if (ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.b.b.j.e.n nVar : list) {
            if (nVar instanceof z1) {
                a2 a2Var = ((z1) nVar).w;
                if (a2Var.w1() != null && a2Var.w1().equals(str)) {
                    arrayList.add(nVar);
                }
            }
        }
        list.removeAll(arrayList);
        d.b.b.j.e.n nVar2 = (d.b.b.j.e.n) ListUtils.getItem(list, 0);
        if (nVar2 instanceof v) {
            list.remove(nVar2);
        }
    }

    public final void q(String str, String str2, List<d.b.b.j.e.n> list) {
        if (ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.b.b.j.e.n nVar : list) {
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                if (nVar instanceof d.b.i0.c3.h) {
                    arrayList.add((d.b.i0.c3.h) nVar);
                }
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (nVar instanceof z1)) {
                a2 a2Var = ((z1) nVar).w;
                if (a2Var.w1() != null && a2Var.w1().equals(str2)) {
                    arrayList.add(a2Var);
                }
            }
        }
        list.removeAll(arrayList);
        d.b.b.j.e.n nVar2 = (d.b.b.j.e.n) ListUtils.getItem(list, 0);
        if (nVar2 instanceof v) {
            list.remove(nVar2);
        }
    }

    public final int r(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeRecyclerView.getAdapter().getItemCount(); i2++) {
            d.b.b.j.e.n B = bdTypeRecyclerView.B(i2);
            if (B instanceof z1) {
                a2 a2Var = ((z1) B).w;
                if (a2Var.w1() != null && a2Var.w1().equals(str)) {
                    this.f57432b = a2Var;
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    public final int s(String str, String str2, BdTypeRecyclerView bdTypeRecyclerView) {
        int i;
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        int i2 = 0;
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            i = 0;
            while (i2 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                if (bdTypeRecyclerView.B(i2) instanceof d.b.i0.c3.h) {
                    i = i2;
                }
                i2++;
            }
        } else {
            if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                i = 0;
                while (i2 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                    d.b.b.j.e.n B = bdTypeRecyclerView.B(i2);
                    if (B instanceof z1) {
                        a2 a2Var = ((z1) B).w;
                        if (a2Var.w1() != null && a2Var.w1().equals(str2)) {
                            i = i2;
                        }
                    }
                    i2++;
                }
            }
            return (i2 + headerViewsCount) - firstVisiblePosition;
        }
        i2 = i;
        return (i2 + headerViewsCount) - firstVisiblePosition;
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar = this.f57431a;
        if (lVar == null || lVar.M() == null || this.f57431a.M().Z() == null) {
            return;
        }
        String u = u(customResponsedMessage);
        if (StringUtils.isNull(u) || this.f57431a.x0() == null || this.f57431a.x0().U() == null) {
            return;
        }
        View childAt = this.f57431a.x0().Z().getChildAt(r(u, this.f57431a.x0().Z()));
        if (childAt != null) {
            o(childAt, new a(childAt, u));
        } else {
            j(u);
            this.f57431a.x0().U().notifyDataSetChanged();
        }
        i();
    }

    public final String u(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return null;
        }
        return ((JSONObject) customResponsedMessage.getData()).optString("tid");
    }
}
