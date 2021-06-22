package d.a.o0.r0.e2;

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
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import d.a.o0.r0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public l f62298a;

    /* renamed from: b  reason: collision with root package name */
    public a2 f62299b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f62300c = new c(2921547);

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f62301d = new d(2921324);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f62302e = new C1554e(2016488);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f62303f = new f(2016553);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f62304g = new h(2016331);

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f62305a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62306b;

        public a(View view, String str) {
            this.f62305a = view;
            this.f62306b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (e.this.f62298a == null || e.this.f62298a.B0() == null || e.this.f62298a.B0().Z() == null || e.this.f62298a.B0().U() == null) {
                return;
            }
            e.this.f62298a.B0().Z().removeView(this.f62305a);
            e.this.j(this.f62306b);
            e.this.f62298a.B0().U().notifyDataSetChanged();
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
        public final /* synthetic */ String f62308a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62309b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f62310c;

        public b(String str, String str2, View view) {
            this.f62308a = str;
            this.f62309b = str2;
            this.f62310c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            e.this.k(this.f62308a, this.f62309b);
            this.f62310c.setVisibility(8);
            if (e.this.f62298a.B0() == null || e.this.f62298a.B0().U() == null) {
                return;
            }
            e.this.f62298a.B0().U().notifyDataSetChanged();
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

        /* renamed from: a  reason: collision with root package name */
        public String f62312a;

        /* renamed from: b  reason: collision with root package name */
        public String f62313b;

        /* renamed from: c  reason: collision with root package name */
        public String f62314c;

        /* renamed from: d  reason: collision with root package name */
        public String f62315d;

        /* renamed from: e  reason: collision with root package name */
        public String f62316e;

        public c(int i2) {
            super(i2);
            this.f62312a = "";
            this.f62313b = "";
            this.f62314c = "";
            this.f62315d = "";
            this.f62316e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                this.f62312a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                this.f62313b = jSONObject.optString("tid", "");
                this.f62314c = jSONObject.optString("fid", "");
                this.f62315d = jSONObject.optString("liveId", "");
                this.f62316e = jSONObject.optString("sid", "");
            } else if ((this.f62312a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f62312a)) && ((this.f62315d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f62315d)) && (this.f62316e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f62316e)))) {
            } else {
                try {
                    jSONObject.put("tid", this.f62313b);
                    jSONObject.put("fid", this.f62314c);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                e.this.t(customResponsedMessage, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.n(customResponsedMessage);
        }
    }

    /* renamed from: d.a.o0.r0.e2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1554e extends CustomMessageListener {
        public C1554e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.t(customResponsedMessage, true);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.j(e.this.u(customResponsedMessage));
            e.this.f62298a.B0().U().notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends Animation {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f62321e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f62322f;

        public g(e eVar, int i2, View view) {
            this.f62321e = i2;
            this.f62322f = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2 = this.f62321e;
            this.f62322f.getLayoutParams().height = i2 - ((int) (i2 * f2));
            this.f62322f.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || e.this.f62298a == null || e.this.f62298a.e0() == null || e.this.f62298a.e0().d0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            e.this.m(str, e.this.f62298a.e0().d0().getForum().getBannerListData().getAllAdvertList());
            e eVar = e.this;
            eVar.l(str, eVar.f62298a.B0().Z().getData());
            e eVar2 = e.this;
            eVar2.l(str, eVar2.f62298a.q0().f().z());
            e.this.f62298a.e0().I(str);
            if (e.this.f62298a.B0() == null || e.this.f62298a.B0().U() == null) {
                return;
            }
            e.this.f62298a.B0().U().notifyDataSetChanged();
        }
    }

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.f62298a = lVar;
        this.f62302e.setTag(bdUniqueId);
        this.f62304g.setTag(bdUniqueId);
        this.f62301d.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62301d);
        MessageManager.getInstance().registerListener(this.f62302e);
        MessageManager.getInstance().registerListener(this.f62304g);
        this.f62303f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62303f);
        this.f62300c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62300c);
    }

    public final void i() {
        a2 a2Var = this.f62299b;
        if (a2Var == null || !a2Var.R1) {
            return;
        }
        TbPageTag tbPageTag = null;
        l lVar = this.f62298a;
        if (lVar != null && lVar.B0() != null) {
            tbPageTag = d.a.n0.j0.c.k(this.f62298a.B0().T());
        }
        d.a.o0.r0.j2.a.i(this.f62299b, tbPageTag);
    }

    public final void j(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        ArrayList<d.a.c.k.e.n> threadList = this.f62298a.e0().d0().getThreadList();
        p(str, threadList);
        p(str, this.f62298a.B0().Z().getData());
        p(str, this.f62298a.q0().e());
        this.f62298a.e0().K(str);
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f62298a.loadMore();
    }

    public final void k(String str, String str2) {
        ArrayList<d.a.c.k.e.n> threadList = this.f62298a.e0().d0().getThreadList();
        q(str, str2, threadList);
        q(str, str2, this.f62298a.B0().Z().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.f62298a.e0().J(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.f62298a.e0().K(str2);
        }
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f62298a.loadMore();
    }

    public final void l(String str, List<d.a.c.k.e.n> list) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = list.iterator();
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
            if (next instanceof d.a.o0.e.c) {
                Object b2 = ((d.a.o0.e.c) next).b();
                if ((b2 instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) b2).J3)) {
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
            if (next != null && str.equals(next.J3)) {
                it.remove();
            }
        }
    }

    public final void n(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (lVar = this.f62298a) == null || lVar.e0() == null || this.f62298a.e0().d0() == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("type");
        if (StringUtils.isNull(optString)) {
            return;
        }
        String optString2 = jSONObject.optString("tid");
        if (this.f62298a.B0() == null || this.f62298a.B0().U() == null) {
            return;
        }
        View childAt = this.f62298a.B0().Z().getChildAt(s(optString, optString2, this.f62298a.B0().Z()));
        if (childAt != null) {
            o(childAt, new b(optString, optString2, childAt));
            return;
        }
        k(optString, optString2);
        this.f62298a.B0().U().notifyDataSetChanged();
    }

    public final void o(View view, Animation.AnimationListener animationListener) {
        g gVar = new g(this, view.getMeasuredHeight(), view);
        gVar.setAnimationListener(animationListener);
        gVar.setDuration(300L);
        view.startAnimation(gVar);
    }

    public final void p(String str, List<d.a.c.k.e.n> list) {
        if (ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.c.k.e.n nVar : list) {
            if (nVar instanceof z1) {
                a2 a2Var = ((z1) nVar).w;
                if (a2Var.z1() != null && a2Var.z1().equals(str)) {
                    arrayList.add(nVar);
                }
            }
        }
        list.removeAll(arrayList);
        d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(list, 0);
        if (nVar2 instanceof v) {
            list.remove(nVar2);
        }
    }

    public final void q(String str, String str2, List<d.a.c.k.e.n> list) {
        if (ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.c.k.e.n nVar : list) {
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                if (nVar instanceof d.a.o0.e3.h) {
                    arrayList.add((d.a.o0.e3.h) nVar);
                }
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (nVar instanceof z1)) {
                a2 a2Var = ((z1) nVar).w;
                if (a2Var.z1() != null && a2Var.z1().equals(str2)) {
                    arrayList.add(a2Var);
                }
            }
        }
        list.removeAll(arrayList);
        d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(list, 0);
        if (nVar2 instanceof v) {
            list.remove(nVar2);
        }
    }

    public final int r(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        int i2 = 0;
        for (int i3 = 0; i3 < bdTypeRecyclerView.getAdapter().getItemCount(); i3++) {
            d.a.c.k.e.n B = bdTypeRecyclerView.B(i3);
            if (B instanceof z1) {
                a2 a2Var = ((z1) B).w;
                if (a2Var.z1() != null && a2Var.z1().equals(str)) {
                    this.f62299b = a2Var;
                    i2 = i3;
                }
            }
        }
        return (i2 + headerViewsCount) - firstVisiblePosition;
    }

    public final int s(String str, String str2, BdTypeRecyclerView bdTypeRecyclerView) {
        int i2;
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        int i3 = 0;
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            i2 = 0;
            while (i3 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                if (bdTypeRecyclerView.B(i3) instanceof d.a.o0.e3.h) {
                    i2 = i3;
                }
                i3++;
            }
        } else {
            if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                i2 = 0;
                while (i3 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                    d.a.c.k.e.n B = bdTypeRecyclerView.B(i3);
                    if (B instanceof z1) {
                        a2 a2Var = ((z1) B).w;
                        if (a2Var.z1() != null && a2Var.z1().equals(str2)) {
                            i2 = i3;
                        }
                    }
                    i3++;
                }
            }
            return (i3 + headerViewsCount) - firstVisiblePosition;
        }
        i3 = i2;
        return (i3 + headerViewsCount) - firstVisiblePosition;
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage, boolean z) {
        l lVar = this.f62298a;
        if (lVar == null || lVar.e0() == null || this.f62298a.e0().d0() == null) {
            return;
        }
        String u = u(customResponsedMessage);
        if (StringUtils.isNull(u) || this.f62298a.B0() == null || this.f62298a.B0().U() == null) {
            return;
        }
        View childAt = this.f62298a.B0().Z().getChildAt(r(u, this.f62298a.B0().Z()));
        if (childAt != null) {
            o(childAt, new a(childAt, u));
        } else {
            j(u);
            this.f62298a.B0().U().notifyDataSetChanged();
        }
        if (z) {
            i();
        }
    }

    public final String u(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return null;
        }
        return ((JSONObject) customResponsedMessage.getData()).optString("tid");
    }
}
