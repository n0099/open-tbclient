package d.a.n0.r0.e2;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.r0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public l f62173a;

    /* renamed from: b  reason: collision with root package name */
    public a2 f62174b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f62175c = new c(2921547);

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f62176d = new d(2921324);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f62177e = new C1550e(2016488);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f62178f = new f(2016553);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f62179g = new h(2016331);

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f62180a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62181b;

        public a(View view, String str) {
            this.f62180a = view;
            this.f62181b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (e.this.f62173a == null || e.this.f62173a.B0() == null || e.this.f62173a.B0().Z() == null || e.this.f62173a.B0().U() == null) {
                return;
            }
            e.this.f62173a.B0().Z().removeView(this.f62180a);
            e.this.j(this.f62181b);
            e.this.f62173a.B0().U().notifyDataSetChanged();
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
        public final /* synthetic */ String f62183a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62184b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f62185c;

        public b(String str, String str2, View view) {
            this.f62183a = str;
            this.f62184b = str2;
            this.f62185c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            e.this.k(this.f62183a, this.f62184b);
            this.f62185c.setVisibility(8);
            if (e.this.f62173a.B0() == null || e.this.f62173a.B0().U() == null) {
                return;
            }
            e.this.f62173a.B0().U().notifyDataSetChanged();
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
        public String f62187a;

        /* renamed from: b  reason: collision with root package name */
        public String f62188b;

        /* renamed from: c  reason: collision with root package name */
        public String f62189c;

        /* renamed from: d  reason: collision with root package name */
        public String f62190d;

        /* renamed from: e  reason: collision with root package name */
        public String f62191e;

        public c(int i2) {
            super(i2);
            this.f62187a = "";
            this.f62188b = "";
            this.f62189c = "";
            this.f62190d = "";
            this.f62191e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                this.f62187a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                this.f62188b = jSONObject.optString("tid", "");
                this.f62189c = jSONObject.optString("fid", "");
                this.f62190d = jSONObject.optString("liveId", "");
                this.f62191e = jSONObject.optString("sid", "");
            } else if ((this.f62187a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f62187a)) && ((this.f62190d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f62190d)) && (this.f62191e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f62191e)))) {
            } else {
                try {
                    jSONObject.put("tid", this.f62188b);
                    jSONObject.put("fid", this.f62189c);
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

    /* renamed from: d.a.n0.r0.e2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1550e extends CustomMessageListener {
        public C1550e(int i2) {
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
            e.this.f62173a.B0().U().notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends Animation {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f62196e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f62197f;

        public g(e eVar, int i2, View view) {
            this.f62196e = i2;
            this.f62197f = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2 = this.f62196e;
            this.f62197f.getLayoutParams().height = i2 - ((int) (i2 * f2));
            this.f62197f.requestLayout();
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
            if (customResponsedMessage == null || e.this.f62173a == null || e.this.f62173a.e0() == null || e.this.f62173a.e0().d0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            e.this.m(str, e.this.f62173a.e0().d0().getForum().getBannerListData().getAllAdvertList());
            e eVar = e.this;
            eVar.l(str, eVar.f62173a.B0().Z().getData());
            e eVar2 = e.this;
            eVar2.l(str, eVar2.f62173a.q0().f().z());
            e.this.f62173a.e0().I(str);
            if (e.this.f62173a.B0() == null || e.this.f62173a.B0().U() == null) {
                return;
            }
            e.this.f62173a.B0().U().notifyDataSetChanged();
        }
    }

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.f62173a = lVar;
        this.f62177e.setTag(bdUniqueId);
        this.f62179g.setTag(bdUniqueId);
        this.f62176d.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62176d);
        MessageManager.getInstance().registerListener(this.f62177e);
        MessageManager.getInstance().registerListener(this.f62179g);
        this.f62178f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62178f);
        this.f62175c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62175c);
    }

    public final void i() {
        a2 a2Var = this.f62174b;
        if (a2Var == null || !a2Var.R1) {
            return;
        }
        TbPageTag tbPageTag = null;
        l lVar = this.f62173a;
        if (lVar != null && lVar.B0() != null) {
            tbPageTag = d.a.m0.j0.c.k(this.f62173a.B0().T());
        }
        d.a.n0.r0.j2.a.i(this.f62174b, tbPageTag);
    }

    public final void j(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        ArrayList<d.a.c.k.e.n> threadList = this.f62173a.e0().d0().getThreadList();
        p(str, threadList);
        p(str, this.f62173a.B0().Z().getData());
        p(str, this.f62173a.q0().e());
        this.f62173a.e0().K(str);
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f62173a.loadMore();
    }

    public final void k(String str, String str2) {
        ArrayList<d.a.c.k.e.n> threadList = this.f62173a.e0().d0().getThreadList();
        q(str, str2, threadList);
        q(str, str2, this.f62173a.B0().Z().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.f62173a.e0().J(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.f62173a.e0().K(str2);
        }
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f62173a.loadMore();
    }

    public final void l(String str, List<d.a.c.k.e.n> list) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = list.iterator();
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
            if (next instanceof d.a.n0.e.c) {
                Object b2 = ((d.a.n0.e.c) next).b();
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
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (lVar = this.f62173a) == null || lVar.e0() == null || this.f62173a.e0().d0() == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("type");
        if (StringUtils.isNull(optString)) {
            return;
        }
        String optString2 = jSONObject.optString("tid");
        if (this.f62173a.B0() == null || this.f62173a.B0().U() == null) {
            return;
        }
        View childAt = this.f62173a.B0().Z().getChildAt(s(optString, optString2, this.f62173a.B0().Z()));
        if (childAt != null) {
            o(childAt, new b(optString, optString2, childAt));
            return;
        }
        k(optString, optString2);
        this.f62173a.B0().U().notifyDataSetChanged();
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
                if (nVar instanceof d.a.n0.e3.h) {
                    arrayList.add((d.a.n0.e3.h) nVar);
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
                    this.f62174b = a2Var;
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
                if (bdTypeRecyclerView.B(i3) instanceof d.a.n0.e3.h) {
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
        l lVar = this.f62173a;
        if (lVar == null || lVar.e0() == null || this.f62173a.e0().d0() == null) {
            return;
        }
        String u = u(customResponsedMessage);
        if (StringUtils.isNull(u) || this.f62173a.B0() == null || this.f62173a.B0().U() == null) {
            return;
        }
        View childAt = this.f62173a.B0().Z().getChildAt(r(u, this.f62173a.B0().Z()));
        if (childAt != null) {
            o(childAt, new a(childAt, u));
        } else {
            j(u);
            this.f62173a.B0().U().notifyDataSetChanged();
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
