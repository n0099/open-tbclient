package d.a.k0.a1.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.squareup.wire.Wire;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.m0;
import d.a.j0.z0.a0;
import d.a.j0.z0.b0;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.k0.x.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DiscoverHotForum;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public DataRes.Builder f51122c;

    /* renamed from: d  reason: collision with root package name */
    public DataRes.Builder f51123d;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f51124e;

    /* renamed from: f  reason: collision with root package name */
    public String f51125f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51126g;
    public final BdTypeRecyclerView k;
    public final d.a.k0.a1.b.a l;
    public d.a.k0.f0.a m;
    public a0 o;
    public View.OnTouchListener p;
    public final d.a.k0.a1.b.g.a q;
    public int r;
    public BigdaySwipeRefreshLayout s;

    /* renamed from: a  reason: collision with root package name */
    public o f51120a = null;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<d.a.c.j.e.n> f51121b = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f51127h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51128i = false;
    public boolean j = false;
    public boolean n = false;
    public int t = 0;
    public List<m0> u = new ArrayList();
    public CustomMessageListener v = new f(2001115);
    public CustomMessageListener w = new g(0);
    public RecyclerView.OnScrollListener x = new h();
    public CustomMessageListener y = new i(2016331);
    public View.OnTouchListener z = new j();
    public CustomMessageListener A = new b(2921547);
    public CustomMessageListener B = new c(2016488);
    public CustomMessageListener C = new C1168d(2016553);
    public CustomMessageListener D = new e(2921425);

    /* loaded from: classes4.dex */
    public class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f51129a;

        public a(DataRes.Builder builder) {
            this.f51129a = builder;
        }

        @Override // d.a.j0.z0.f0
        public Object doInBackground() {
            DataRes build;
            DataRes.Builder builder = new DataRes.Builder(this.f51129a.build(true));
            d.a.c.e.d.l<byte[]> e2 = d.a.j0.r.r.a.f().e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
            try {
                build = builder.build(true);
            } catch (Exception e3) {
                BdLog.e(e3);
            }
            if (build != null && !ListUtils.isEmpty(build.thread_info)) {
                e2.g("0", build.toByteArray());
                d.V(d.this.f51125f);
                d.W(System.currentTimeMillis());
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public String f51131a;

        /* renamed from: b  reason: collision with root package name */
        public String f51132b;

        /* renamed from: c  reason: collision with root package name */
        public String f51133c;

        /* renamed from: d  reason: collision with root package name */
        public String f51134d;

        /* renamed from: e  reason: collision with root package name */
        public String f51135e;

        public b(int i2) {
            super(i2);
            this.f51131a = "";
            this.f51132b = "";
            this.f51133c = "";
            this.f51134d = "";
            this.f51135e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                this.f51131a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                this.f51132b = jSONObject.optString("tid", "");
                this.f51133c = jSONObject.optString("fid", "");
                this.f51134d = jSONObject.optString("liveId", "");
                this.f51135e = jSONObject.optString("sid", "");
            } else if ((this.f51131a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f51131a)) && ((this.f51134d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f51134d)) && (this.f51135e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f51135e)))) {
            } else {
                try {
                    jSONObject.put("tid", this.f51132b);
                    jSONObject.put("fid", this.f51133c);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                d.this.v(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.v(customResponsedMessage);
        }
    }

    /* renamed from: d.a.k0.a1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1168d extends CustomMessageListener {
        public C1168d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.v(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.u();
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
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.l != null) {
                    return;
                }
                if (!data.f12666a) {
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().f12667b, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                } else if (data.f12669d) {
                } else {
                    Iterator it = d.this.f51121b.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof d.a.k0.x.e0.b) && ThreadCardUtils.isTargetUser(((d.a.k0.x.e0.b) next).m(), data.f12668c)) {
                            it.remove();
                        }
                    }
                    d.a.k0.s2.a.c(d.this.f51121b);
                    d.this.u.clear();
                    if (d.this.f51121b.size() < 9) {
                        d.this.G();
                    } else {
                        d dVar = d.this;
                        dVar.Y(dVar.f51121b);
                        d.this.l.d();
                        if (d.this.f51120a != null) {
                            d.this.f51120a.c(false, false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.n)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || d.this.f51122c == null || d.this.f51122c.hot_recomforum == null || ListUtils.isEmpty(d.this.f51122c.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.f51122c.hot_recomforum);
            if (d.a.k0.a1.b.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                d.this.f51122c.hot_recomforum = builder.build(true);
                d.this.Q(new DataRes.Builder(d.this.f51122c.build(true)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f51142a = 0;

        public h() {
        }

        public void a(int i2, int i3) {
            if (d.this.o != null && !d.this.n) {
                d.this.o.a(this.f51142a, i2);
            }
            this.f51142a = i2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.n)));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (d.this.o != null && !d.this.n) {
                d.this.o.b(recyclerView, i2);
            }
            if (i2 == 0) {
                t.b().c();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.n)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            int i5 = 0;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i4 = 0;
            } else {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                i5 = bdRecyclerView.getFirstVisiblePosition();
                i4 = bdRecyclerView.getLastVisiblePosition();
            }
            a(i5, (i4 - i5) + 1);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || d.this.f51122c == null || d.a.k0.j1.o.k.a.e(d.this.f51121b)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.k0.s2.a.d(str, d.this.f51121b);
            d.a.k0.s2.a.d(str, d.this.f51122c.app_list);
            d.a.k0.s2.a.d(str, d.this.u);
            d.a.k0.s2.a.s(d.this.f51121b);
            if (d.this.l != null) {
                d.this.l.j(new ArrayList(d.this.f51121b));
            }
            d dVar = d.this;
            dVar.t(dVar.f51121b);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.n)));
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnTouchListener {
        public j() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.p != null) {
                d.this.p.onTouch(view, motionEvent);
            }
            if (d.this.m != null) {
                d.this.m.c(motionEvent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends f0<DataRes> {
        public k(d dVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            d.a.j0.r.r.a.f().a("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements d.a.j0.z0.n<DataRes> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            d.this.L(null);
        }
    }

    /* loaded from: classes4.dex */
    public class m extends f0<DataRes> {
        public m(d dVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            byte[] bArr;
            d.a.c.e.d.l<byte[]> e2 = d.a.j0.r.r.a.f().e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
            if (e2 != null && (bArr = e2.get("0")) != null && bArr.length != 0) {
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e3) {
                    BdLog.e(e3);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class n implements d.a.j0.z0.n<DataRes> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            d.this.L(dataRes);
        }
    }

    /* loaded from: classes4.dex */
    public interface o {
        void a(d.a.j0.z0.c cVar);

        void b();

        void c(boolean z, boolean z2);

        void d(String str, d.a.j0.z0.c cVar);

        void onError(int i2, String str);
    }

    public d(d.a.c.a.f<?> fVar, BdTypeRecyclerView bdTypeRecyclerView, d.a.k0.a1.b.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.z);
        this.m = new d.a.k0.f0.a();
        this.q = new d.a.k0.a1.b.g.a();
        this.l = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.x);
        this.s = bigdaySwipeRefreshLayout;
        T(false);
    }

    public static boolean C() {
        return d.a.j0.r.d0.b.j().g(d.a.j0.r.d0.b.n("key_home_concern_all_status_cache_loaded"), false);
    }

    public static boolean J() {
        return d.a.j0.b.d.h() && d.a.j0.r.d0.b.j().k("key_home_concern_all_status", 0) == 0;
    }

    public static void T(boolean z) {
        d.a.j0.r.d0.b.j().t(d.a.j0.r.d0.b.n("key_home_concern_all_status_cache_loaded"), z);
    }

    public static void U(String str) {
        d.a.j0.r.d0.b.j().x(d.a.j0.r.d0.b.n("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static void V(String str) {
        d.a.j0.r.d0.b.j().x(d.a.j0.r.d0.b.n("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static void W(long j2) {
        d.a.j0.r.d0.b.j().w(d.a.j0.r.d0.b.n("key_home_concern_all_status_cache_time"), j2);
    }

    public static String w() {
        return d.a.j0.r.d0.b.j().p(d.a.j0.r.d0.b.n("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static String x() {
        return d.a.j0.r.d0.b.j().p(d.a.j0.r.d0.b.n("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static long y() {
        return d.a.j0.r.d0.b.j().l(d.a.j0.r.d0.b.n("key_home_concern_all_status_cache_time"), 0L);
    }

    public boolean A() {
        return this.f51126g;
    }

    public void B(a2 a2Var) {
        a2Var.B3(true);
        d.a.j0.b.f.a.e(a2Var);
        List<d.a.c.j.e.n> e2 = this.q.e(a2Var, -1, null);
        DataRes.Builder builder = this.f51122c;
        if ((builder == null || ListUtils.getCount(builder.thread_info) <= 0) && ListUtils.getCount(this.f51121b) <= 1) {
            this.f51121b.clear();
        }
        this.f51121b.addAll(0, e2);
        this.l.j(this.f51121b);
    }

    public final boolean D() {
        return this.f51127h;
    }

    public boolean E() {
        return this.j;
    }

    public final void F() {
        long currentTimeMillis = System.currentTimeMillis();
        long y = y();
        long j2 = currentTimeMillis - y;
        if (y != 0 && j2 <= 86400000) {
            h0.b(new m(this), new n());
        } else {
            h0.b(new k(this), new l());
        }
    }

    public final void G() {
        d.a.j0.z0.c s = s(true);
        o oVar = this.f51120a;
        if (oVar != null) {
            oVar.a(s);
        }
    }

    public void H() {
        if (D() || !this.f51126g) {
            return;
        }
        d.a.j0.z0.c s = s(false);
        if (this.f51120a != null) {
            X(true);
            this.f51120a.d(this.f51125f, s);
        }
    }

    public final List<d.a.c.j.e.n> I(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.f51122c == null) {
            this.f51122c = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        d.a.k0.a1.g.k.c b2 = this.q.b(z, this.f51122c, builder, !z2 ? 1 : 0);
        if (b2 != null) {
            return b2.f51668a;
        }
        return null;
    }

    public void K(boolean z) {
        this.n = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
    }

    public final void L(DataRes dataRes) {
        this.f51128i = true;
        T(true);
        if (dataRes != null) {
            if (P(false, true, dataRes)) {
                o oVar = this.f51120a;
                if (oVar != null) {
                    oVar.c(false, true);
                    return;
                }
                return;
            }
            G();
            return;
        }
        G();
    }

    public void M() {
        this.l.f();
    }

    public void N(boolean z, DataRes dataRes, int i2, String str) {
        o oVar;
        X(false);
        if (i2 == 0 && dataRes != null && P(true, z, dataRes)) {
            o oVar2 = this.f51120a;
            if (oVar2 != null) {
                oVar2.c(z, false);
            }
            if (z) {
                e0();
            }
        } else if (i2 == 0 && ListUtils.getCount(this.f51121b) == 0 && (oVar = this.f51120a) != null) {
            oVar.b();
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.s;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setRefreshing(false);
                return;
            }
            return;
        } else if (this.f51121b.size() > 0) {
            o oVar3 = this.f51120a;
            if (oVar3 != null) {
                oVar3.onError(1, str);
            }
        } else {
            o oVar4 = this.f51120a;
            if (oVar4 != null) {
                oVar4.onError(2, str);
            }
        }
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.s;
        if (bigdaySwipeRefreshLayout2 != null) {
            bigdaySwipeRefreshLayout2.setRefreshing(false);
        }
    }

    public void O(boolean z) {
        if (z) {
            this.l.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean P(boolean z, boolean z2, DataRes dataRes) {
        boolean z3;
        int i2;
        if (dataRes == null) {
            return false;
        }
        int i3 = z2 ? 1 : this.t + 1;
        this.t = i3;
        int k2 = i3 == 1 ? 0 : d.a.k0.j1.o.k.a.k(this.f51121b);
        this.f51125f = dataRes.page_tag;
        this.f51124e = new DataRes.Builder(dataRes);
        if (J()) {
            U(this.f51125f);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.r = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            d.a.j0.r.d0.b.j().w(d.a.j0.r.d0.b.n("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        List<d.a.c.j.e.n> I = I(z, builder, z2);
        z(I, builder, k2);
        this.j = false;
        if (I != null && TbadkCoreApplication.isLogin()) {
            if (ListUtils.isEmpty(I) || (ListUtils.getCount(I) == 1 && (ListUtils.getItem(I, 0) instanceof d.a.k0.a1.b.f.a))) {
                int i4 = this.r;
                if (3 == i4) {
                    d.a.k0.a1.b.f.b bVar = new d.a.k0.a1.b.f.b();
                    bVar.f51225i = d.a.k0.a1.b.f.b.j;
                    bVar.f51221e = 3;
                    I.add(bVar);
                    this.j = true;
                } else if (2 == i4) {
                    d.a.k0.a1.b.f.b bVar2 = new d.a.k0.a1.b.f.b();
                    bVar2.f51225i = d.a.k0.a1.b.f.b.j;
                    bVar2.f51221e = 2;
                    I.add(bVar2);
                    this.j = true;
                }
            }
            linkedList.addAll(I);
        }
        if (!d.a.c.e.p.k.isEmpty(builder.user_tips) && 2 == this.r) {
            d.a.k0.a1.b.f.b bVar3 = new d.a.k0.a1.b.f.b();
            bVar3.f51221e = builder.user_tips_type.intValue();
            bVar3.f51222f = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                bVar3.f51223g = true;
            } else {
                bVar3.f51224h = true;
            }
            if (J() && ((i2 = bVar3.f51221e) == 2 || i2 == 3)) {
                if (linkedList.size() > 0) {
                    bVar3.f51221e = 0;
                    z3 = false;
                    if (z3) {
                        linkedList.add(bVar3);
                    }
                } else {
                    bVar3.f51222f = TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title);
                }
            }
            z3 = true;
            if (z3) {
            }
        }
        this.f51126g = builder.has_more.intValue() == 1;
        if (ListUtils.isEmpty(linkedList)) {
            if (!this.f51121b.isEmpty()) {
                Iterator<d.a.c.j.e.n> it = this.f51121b.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                this.l.j(this.f51121b);
            }
            return false;
        }
        this.f51121b.clear();
        this.f51121b.addAll(linkedList);
        if (z2) {
            DataRes.Builder builder2 = this.f51122c;
            builder2.page_tag = dataRes.page_tag;
            builder2.has_more = dataRes.has_more;
            builder2.user_list = dataRes.user_list;
            builder2.user_tips_type = dataRes.user_tips_type;
            builder2.user_tips = dataRes.user_tips;
            builder2.last_tips = dataRes.last_tips;
        }
        DataRes.Builder builder3 = this.f51122c;
        builder3.banner_user_story = dataRes.banner_user_story;
        builder3.banner_follow_live = dataRes.banner_follow_live;
        builder3.hot_recomforum = dataRes.hot_recomforum;
        builder3.top_tips = dataRes.top_tips;
        builder3.top_user_info = dataRes.top_user_info;
        int i5 = this.r;
        if (i5 == 2 || i5 == 3) {
            DataRes.Builder builder4 = this.f51122c;
            builder4.user_tips_type = dataRes.user_tips_type;
            builder4.user_tips = dataRes.user_tips;
        }
        this.l.j(this.f51121b);
        return true;
    }

    public final void Q(DataRes.Builder builder) {
        if (J()) {
            h0.b(new a(builder), null);
        }
    }

    public void R() {
        G();
    }

    public void S() {
        this.f51122c = new DataRes.Builder(this.f51123d.build(true));
    }

    public final void X(boolean z) {
        this.f51127h = z;
    }

    public final void Y(List<d.a.c.j.e.n> list) {
        this.l.j(list);
    }

    public void Z(o oVar) {
        this.f51120a = oVar;
    }

    public void a0(b0 b0Var) {
        if (b0Var != null) {
            this.o = b0Var.a();
            this.p = b0Var.b();
        }
    }

    public void b0(boolean z) {
        this.n = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
    }

    public void c0(BdUniqueId bdUniqueId) {
        this.B.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.B);
        this.C.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.C);
        this.D.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.D);
        this.v.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.v);
        this.A.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.A);
        this.w.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.w);
        MessageManager.getInstance().registerListener(2001336, this.w);
        this.y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.y);
    }

    public void d0() {
        if (J() && !this.f51128i) {
            F();
        } else {
            G();
        }
    }

    public final void e0() {
        DataRes.Builder builder = this.f51124e;
        if (builder == null) {
            return;
        }
        Q(builder);
    }

    public final List<m0> f0(List<m0> list) {
        ArrayList arrayList = new ArrayList();
        for (m0 m0Var : list) {
            if (m0Var instanceof AdvertAppInfo) {
                arrayList.add(new d.a.k0.x.e0.d((AdvertAppInfo) m0Var));
            } else if (m0Var instanceof d.a.k0.x.e0.d) {
                arrayList.add((d.a.k0.x.e0.d) m0Var);
            }
        }
        return arrayList;
    }

    public void r() {
        this.f51123d = new DataRes.Builder(this.f51122c.build(true));
    }

    public final d.a.j0.z0.c s(boolean z) {
        String e2 = d.a.k0.s2.a.e(this.f51121b, z);
        d.a.j0.z0.c cVar = new d.a.j0.z0.c();
        cVar.f50908b = e2;
        return cVar;
    }

    public final void t(List<d.a.c.j.e.n> list) {
        d.a.k0.s2.i0.b.f().i("CONCERN", d.a.k0.s2.a.b(list));
    }

    public final void u() {
        DataRes.Builder builder = this.f51122c;
        if (builder == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f51121b) == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f51121b.size()) {
                break;
            } else if (this.f51121b.get(i2) instanceof d.a.k0.a1.b.f.a) {
                this.f51121b.remove(i2);
                d.a.k0.a1.b.a aVar = this.l;
                if (aVar != null) {
                    aVar.j(this.f51121b);
                }
            } else {
                i2++;
            }
        }
        for (int i3 = 0; i3 < this.f51122c.thread_info.size(); i3++) {
            if (d.a.k0.a1.b.f.a.C(this.f51122c.thread_info.get(i3))) {
                this.f51122c.thread_info.remove(i3);
                e0();
                return;
            }
        }
    }

    public final void v(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        ThreadInfo threadInfo;
        Long l2;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f51122c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f51121b) == 0) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString)) {
            return;
        }
        Iterator<d.a.c.j.e.n> it = this.f51121b.iterator();
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.c.j.e.n next = it.next();
            if (next instanceof d.a.k0.x.e0.b) {
                d.a.k0.x.e0.b bVar = (d.a.k0.x.e0.b) next;
                if (bVar.m() != null && bVar.m().x1() != null) {
                    if (bVar.m().x1().equals(optString)) {
                        it.remove();
                        z = true;
                    } else if (z) {
                        d.a.k0.a1.b.a aVar = this.l;
                        if (aVar != null) {
                            aVar.j(this.f51121b);
                        }
                    }
                }
            }
        }
        long f2 = d.a.c.e.m.b.f(optString, 0L);
        for (int i2 = 0; i2 < this.f51122c.thread_info.size(); i2++) {
            ConcernData concernData = this.f51122c.thread_info.get(i2);
            if (concernData != null && (threadInfo = concernData.thread_list) != null && (l2 = threadInfo.tid) != null && l2.longValue() == f2) {
                this.f51122c.thread_info.remove(i2);
                e0();
                return;
            }
        }
    }

    public final void z(List<d.a.c.j.e.n> list, DataRes.Builder builder, int i2) {
        List<m0> f0 = f0(d.a.k0.s2.a.g(builder.app_list, "CONCERN"));
        if (this.f51122c == null) {
            this.f51122c = new DataRes.Builder();
        }
        if (d.a.k0.j1.o.k.a.e(this.f51122c.app_list)) {
            this.f51122c.app_list = new ArrayList();
        }
        this.f51122c.app_list.addAll(builder.app_list);
        if (this.t == 1 || i2 == 0) {
            this.u.clear();
        }
        f0.addAll(this.u);
        if (!d.a.k0.j1.o.k.a.e(f0)) {
            this.u = d.a.k0.s2.a.j(f0, list, i2);
        }
        d.a.k0.s2.a.s(list);
        d.a.k0.s2.a.a(list, this.t, "CONCERN");
        t(list);
    }
}
