package d.b.i0.a1.b;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.squareup.wire.Wire;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.m0;
import d.b.h0.z0.a0;
import d.b.h0.z0.b0;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.i0.x.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.DiscoverHotForum;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public DataRes.Builder f52317c;

    /* renamed from: d  reason: collision with root package name */
    public DataRes.Builder f52318d;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f52319e;

    /* renamed from: f  reason: collision with root package name */
    public String f52320f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52321g;
    public final BdTypeRecyclerView k;
    public final d.b.i0.a1.b.a l;
    public d.b.i0.f0.a m;
    public a0 o;
    public View.OnTouchListener p;
    public final d.b.i0.a1.b.g.a q;
    public int r;
    public BigdaySwipeRefreshLayout s;

    /* renamed from: a  reason: collision with root package name */
    public n f52315a = null;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<d.b.c.j.e.n> f52316b = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f52322h = false;
    public boolean i = false;
    public boolean j = false;
    public boolean n = false;
    public int t = 0;
    public List<m0> u = new ArrayList();
    public CustomMessageListener v = new e(2001115);
    public CustomMessageListener w = new f(0);
    public RecyclerView.OnScrollListener x = new g();
    public CustomMessageListener y = new h(2016331);
    public View.OnTouchListener z = new i();
    public CustomMessageListener A = new b(2016488);
    public CustomMessageListener B = new c(2016553);
    public CustomMessageListener C = new C1134d(2921425);

    /* loaded from: classes4.dex */
    public class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f52323a;

        public a(DataRes.Builder builder) {
            this.f52323a = builder;
        }

        @Override // d.b.h0.z0.f0
        public Object doInBackground() {
            DataRes build;
            DataRes.Builder builder = new DataRes.Builder(this.f52323a.build(true));
            d.b.c.e.d.l<byte[]> e2 = d.b.h0.r.r.a.f().e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
            try {
                build = builder.build(true);
            } catch (Exception e3) {
                BdLog.e(e3);
            }
            if (build != null && !ListUtils.isEmpty(build.thread_info)) {
                e2.g("0", build.toByteArray());
                d.V(d.this.f52320f);
                d.W(System.currentTimeMillis());
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.v(customResponsedMessage);
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
            d.this.v(customResponsedMessage);
        }
    }

    /* renamed from: d.b.i0.a1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1134d extends CustomMessageListener {
        public C1134d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.u();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.k != null) {
                    return;
                }
                if (!data.f13354a) {
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().f13355b, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                } else if (data.f13357d) {
                } else {
                    Iterator it = d.this.f52316b.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof d.b.i0.x.e0.b) && ThreadCardUtils.isTargetUser(((d.b.i0.x.e0.b) next).n(), data.f13356c)) {
                            it.remove();
                        }
                    }
                    d.b.i0.s2.a.c(d.this.f52316b);
                    d.this.u.clear();
                    if (d.this.f52316b.size() < 9) {
                        d.this.G();
                    } else {
                        d dVar = d.this;
                        dVar.Y(dVar.f52316b);
                        d.this.l.d();
                        if (d.this.f52315a != null) {
                            d.this.f52315a.c(false, false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.n)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || d.this.f52317c == null || d.this.f52317c.hot_recomforum == null || ListUtils.isEmpty(d.this.f52317c.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(d.this.f52317c.hot_recomforum);
            if (d.b.i0.a1.b.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                d.this.f52317c.hot_recomforum = builder.build(true);
                d.this.Q(new DataRes.Builder(d.this.f52317c.build(true)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f52330a = 0;

        public g() {
        }

        public void a(int i, int i2) {
            if (d.this.o != null && !d.this.n) {
                d.this.o.a(this.f52330a, i);
            }
            this.f52330a = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.n)));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.o != null && !d.this.n) {
                d.this.o.b(recyclerView, i);
            }
            if (i == 0) {
                t.b().c();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.n)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4 = 0;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
            } else {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                i4 = bdRecyclerView.getFirstVisiblePosition();
                i3 = bdRecyclerView.getLastVisiblePosition();
            }
            a(i4, (i3 - i4) + 1);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || d.this.f52317c == null || d.b.i0.j1.o.k.a.e(d.this.f52316b)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.b.i0.s2.a.d(str, d.this.f52316b);
            d.b.i0.s2.a.d(str, d.this.f52317c.app_list);
            d.b.i0.s2.a.d(str, d.this.u);
            d.b.i0.s2.a.s(d.this.f52316b);
            if (d.this.l != null) {
                d.this.l.j(new ArrayList(d.this.f52316b));
            }
            d dVar = d.this;
            dVar.t(dVar.f52316b);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(d.this.n)));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnTouchListener {
        public i() {
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
    public class j extends f0<DataRes> {
        public j(d dVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            d.b.h0.r.r.a.f().a("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class k implements d.b.h0.z0.n<DataRes> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            d.this.L(null);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends f0<DataRes> {
        public l(d dVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            byte[] bArr;
            d.b.c.e.d.l<byte[]> e2 = d.b.h0.r.r.a.f().e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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
    public class m implements d.b.h0.z0.n<DataRes> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            d.this.L(dataRes);
        }
    }

    /* loaded from: classes4.dex */
    public interface n {
        void a(d.b.h0.z0.c cVar);

        void b();

        void c(boolean z, boolean z2);

        void d(String str, d.b.h0.z0.c cVar);

        void onError(int i, String str);
    }

    public d(d.b.c.a.f<?> fVar, BdTypeRecyclerView bdTypeRecyclerView, d.b.i0.a1.b.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.z);
        this.m = new d.b.i0.f0.a();
        this.q = new d.b.i0.a1.b.g.a();
        this.l = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.x);
        this.s = bigdaySwipeRefreshLayout;
        T(false);
    }

    public static boolean C() {
        return d.b.h0.r.d0.b.j().g(d.b.h0.r.d0.b.n("key_home_concern_all_status_cache_loaded"), false);
    }

    public static boolean J() {
        return d.b.h0.b.d.h() && d.b.h0.r.d0.b.j().k("key_home_concern_all_status", 0) == 0;
    }

    public static void T(boolean z) {
        d.b.h0.r.d0.b.j().t(d.b.h0.r.d0.b.n("key_home_concern_all_status_cache_loaded"), z);
    }

    public static void U(String str) {
        d.b.h0.r.d0.b.j().x(d.b.h0.r.d0.b.n("key_home_concern_all_status_cache_nextpage_key"), str);
    }

    public static void V(String str) {
        d.b.h0.r.d0.b.j().x(d.b.h0.r.d0.b.n("key_home_concern_all_status_cache_nextpage_update_key"), str);
    }

    public static void W(long j2) {
        d.b.h0.r.d0.b.j().w(d.b.h0.r.d0.b.n("key_home_concern_all_status_cache_time"), j2);
    }

    public static String w() {
        return d.b.h0.r.d0.b.j().p(d.b.h0.r.d0.b.n("key_home_concern_all_status_cache_nextpage_key"), "");
    }

    public static String x() {
        return d.b.h0.r.d0.b.j().p(d.b.h0.r.d0.b.n("key_home_concern_all_status_cache_nextpage_update_key"), "");
    }

    public static long y() {
        return d.b.h0.r.d0.b.j().l(d.b.h0.r.d0.b.n("key_home_concern_all_status_cache_time"), 0L);
    }

    public boolean A() {
        return this.f52321g;
    }

    public void B(a2 a2Var) {
        a2Var.z3(true);
        d.b.h0.b.f.a.e(a2Var);
        List<d.b.c.j.e.n> e2 = this.q.e(a2Var, -1, null);
        DataRes.Builder builder = this.f52317c;
        if ((builder == null || ListUtils.getCount(builder.thread_info) <= 0) && ListUtils.getCount(this.f52316b) <= 1) {
            this.f52316b.clear();
        }
        this.f52316b.addAll(0, e2);
        this.l.j(this.f52316b);
    }

    public final boolean D() {
        return this.f52322h;
    }

    public boolean E() {
        return this.j;
    }

    public final void F() {
        long currentTimeMillis = System.currentTimeMillis();
        long y = y();
        long j2 = currentTimeMillis - y;
        if (y != 0 && j2 <= 86400000) {
            h0.b(new l(this), new m());
        } else {
            h0.b(new j(this), new k());
        }
    }

    public final void G() {
        d.b.h0.z0.c s = s(true);
        n nVar = this.f52315a;
        if (nVar != null) {
            nVar.a(s);
        }
    }

    public void H() {
        if (D() || !this.f52321g) {
            return;
        }
        d.b.h0.z0.c s = s(false);
        if (this.f52315a != null) {
            X(true);
            this.f52315a.d(this.f52320f, s);
        }
    }

    public final List<d.b.c.j.e.n> I(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.f52317c == null) {
            this.f52317c = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        d.b.i0.a1.g.k.c b2 = this.q.b(z, this.f52317c, builder, !z2 ? 1 : 0);
        if (b2 != null) {
            return b2.f52830a;
        }
        return null;
    }

    public void K(boolean z) {
        this.n = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
    }

    public final void L(DataRes dataRes) {
        this.i = true;
        T(true);
        if (dataRes != null) {
            if (P(false, true, dataRes)) {
                n nVar = this.f52315a;
                if (nVar != null) {
                    nVar.c(false, true);
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
        n nVar;
        X(false);
        if (i2 == 0 && dataRes != null && P(true, z, dataRes)) {
            n nVar2 = this.f52315a;
            if (nVar2 != null) {
                nVar2.c(z, false);
            }
            if (z) {
                e0();
            }
        } else if (i2 == 0 && ListUtils.getCount(this.f52316b) == 0 && (nVar = this.f52315a) != null) {
            nVar.b();
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.s;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setRefreshing(false);
                return;
            }
            return;
        } else if (this.f52316b.size() > 0) {
            n nVar3 = this.f52315a;
            if (nVar3 != null) {
                nVar3.onError(1, str);
            }
        } else {
            n nVar4 = this.f52315a;
            if (nVar4 != null) {
                nVar4.onError(2, str);
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
        int k2 = i3 == 1 ? 0 : d.b.i0.j1.o.k.a.k(this.f52316b);
        this.f52320f = dataRes.page_tag;
        this.f52319e = new DataRes.Builder(dataRes);
        if (J()) {
            U(this.f52320f);
        }
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.r = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            d.b.h0.r.d0.b.j().w(d.b.h0.r.d0.b.n("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        List<d.b.c.j.e.n> I = I(z, builder, z2);
        z(I, builder, k2);
        this.j = false;
        if (I != null && TbadkCoreApplication.isLogin()) {
            if (ListUtils.isEmpty(I) || (ListUtils.getCount(I) == 1 && (ListUtils.getItem(I, 0) instanceof d.b.i0.a1.b.f.a))) {
                int i4 = this.r;
                if (3 == i4) {
                    d.b.i0.a1.b.f.b bVar = new d.b.i0.a1.b.f.b();
                    bVar.i = d.b.i0.a1.b.f.b.j;
                    bVar.f52409e = 3;
                    I.add(bVar);
                    this.j = true;
                } else if (2 == i4) {
                    d.b.i0.a1.b.f.b bVar2 = new d.b.i0.a1.b.f.b();
                    bVar2.i = d.b.i0.a1.b.f.b.j;
                    bVar2.f52409e = 2;
                    I.add(bVar2);
                    this.j = true;
                }
            }
            linkedList.addAll(I);
        }
        if (!d.b.c.e.p.k.isEmpty(builder.user_tips) && 2 == this.r) {
            d.b.i0.a1.b.f.b bVar3 = new d.b.i0.a1.b.f.b();
            bVar3.f52409e = builder.user_tips_type.intValue();
            bVar3.f52410f = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                bVar3.f52411g = true;
            } else {
                bVar3.f52412h = true;
            }
            if (J() && ((i2 = bVar3.f52409e) == 2 || i2 == 3)) {
                if (linkedList.size() > 0) {
                    bVar3.f52409e = 0;
                    z3 = false;
                    if (z3) {
                        linkedList.add(bVar3);
                    }
                } else {
                    bVar3.f52410f = TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title);
                }
            }
            z3 = true;
            if (z3) {
            }
        }
        this.f52321g = builder.has_more.intValue() == 1;
        if (ListUtils.isEmpty(linkedList)) {
            if (!this.f52316b.isEmpty()) {
                Iterator<d.b.c.j.e.n> it = this.f52316b.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                this.l.j(this.f52316b);
            }
            return false;
        }
        this.f52316b.clear();
        this.f52316b.addAll(linkedList);
        if (z2) {
            DataRes.Builder builder2 = this.f52317c;
            builder2.page_tag = dataRes.page_tag;
            builder2.has_more = dataRes.has_more;
            builder2.user_list = dataRes.user_list;
            builder2.user_tips_type = dataRes.user_tips_type;
            builder2.user_tips = dataRes.user_tips;
            builder2.last_tips = dataRes.last_tips;
        }
        DataRes.Builder builder3 = this.f52317c;
        builder3.banner_user_story = dataRes.banner_user_story;
        builder3.banner_follow_live = dataRes.banner_follow_live;
        builder3.hot_recomforum = dataRes.hot_recomforum;
        builder3.top_tips = dataRes.top_tips;
        builder3.top_user_info = dataRes.top_user_info;
        int i5 = this.r;
        if (i5 == 2 || i5 == 3) {
            DataRes.Builder builder4 = this.f52317c;
            builder4.user_tips_type = dataRes.user_tips_type;
            builder4.user_tips = dataRes.user_tips;
        }
        this.l.j(this.f52316b);
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
        this.f52317c = new DataRes.Builder(this.f52318d.build(true));
    }

    public final void X(boolean z) {
        this.f52322h = z;
    }

    public final void Y(List<d.b.c.j.e.n> list) {
        this.l.j(list);
    }

    public void Z(n nVar) {
        this.f52315a = nVar;
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
        this.A.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.A);
        this.B.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.B);
        this.C.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.C);
        this.v.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.v);
        this.w.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.w);
        MessageManager.getInstance().registerListener(2001336, this.w);
        this.y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.y);
    }

    public void d0() {
        if (J() && !this.i) {
            F();
        } else {
            G();
        }
    }

    public final void e0() {
        DataRes.Builder builder = this.f52319e;
        if (builder == null) {
            return;
        }
        Q(builder);
    }

    public final List<m0> f0(List<m0> list) {
        ArrayList arrayList = new ArrayList();
        for (m0 m0Var : list) {
            if (m0Var instanceof AdvertAppInfo) {
                arrayList.add(new d.b.i0.x.e0.d((AdvertAppInfo) m0Var));
            } else if (m0Var instanceof d.b.i0.x.e0.d) {
                arrayList.add((d.b.i0.x.e0.d) m0Var);
            }
        }
        return arrayList;
    }

    public void r() {
        this.f52318d = new DataRes.Builder(this.f52317c.build(true));
    }

    public final d.b.h0.z0.c s(boolean z) {
        String e2 = d.b.i0.s2.a.e(this.f52316b, z);
        d.b.h0.z0.c cVar = new d.b.h0.z0.c();
        cVar.f52076b = e2;
        return cVar;
    }

    public final void t(List<d.b.c.j.e.n> list) {
        d.b.i0.s2.f0.b.f().i("CONCERN", d.b.i0.s2.a.b(list));
    }

    public final void u() {
        DataRes.Builder builder = this.f52317c;
        if (builder == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f52316b) == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f52316b.size()) {
                break;
            } else if (this.f52316b.get(i2) instanceof d.b.i0.a1.b.f.a) {
                this.f52316b.remove(i2);
                d.b.i0.a1.b.a aVar = this.l;
                if (aVar != null) {
                    aVar.j(this.f52316b);
                }
            } else {
                i2++;
            }
        }
        for (int i3 = 0; i3 < this.f52317c.thread_info.size(); i3++) {
            if (d.b.i0.a1.b.f.a.C(this.f52317c.thread_info.get(i3))) {
                this.f52317c.thread_info.remove(i3);
                e0();
                return;
            }
        }
    }

    public final void v(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        ThreadInfo threadInfo;
        Long l2;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f52317c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f52316b) == 0) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString)) {
            return;
        }
        Iterator<d.b.c.j.e.n> it = this.f52316b.iterator();
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.b.c.j.e.n next = it.next();
            if (next instanceof d.b.i0.x.e0.b) {
                d.b.i0.x.e0.b bVar = (d.b.i0.x.e0.b) next;
                if (bVar.n() != null && bVar.n().w1() != null) {
                    if (bVar.n().w1().equals(optString)) {
                        it.remove();
                        z = true;
                    } else if (z) {
                        d.b.i0.a1.b.a aVar = this.l;
                        if (aVar != null) {
                            aVar.j(this.f52316b);
                        }
                    }
                }
            }
        }
        long f2 = d.b.c.e.m.b.f(optString, 0L);
        for (int i2 = 0; i2 < this.f52317c.thread_info.size(); i2++) {
            ConcernData concernData = this.f52317c.thread_info.get(i2);
            if (concernData != null && (threadInfo = concernData.thread_list) != null && (l2 = threadInfo.tid) != null && l2.longValue() == f2) {
                this.f52317c.thread_info.remove(i2);
                e0();
                return;
            }
        }
    }

    public final void z(List<d.b.c.j.e.n> list, DataRes.Builder builder, int i2) {
        List<m0> f0 = f0(d.b.i0.s2.a.g(builder.app_list, "CONCERN"));
        if (this.f52317c == null) {
            this.f52317c = new DataRes.Builder();
        }
        if (d.b.i0.j1.o.k.a.e(this.f52317c.app_list)) {
            this.f52317c.app_list = new ArrayList();
        }
        this.f52317c.app_list.addAll(builder.app_list);
        if (this.t == 1 || i2 == 0) {
            this.u.clear();
        }
        f0.addAll(this.u);
        if (!d.b.i0.j1.o.k.a.e(f0)) {
            this.u = d.b.i0.s2.a.j(f0, list, i2);
        }
        d.b.i0.s2.a.s(list);
        d.b.i0.s2.a.a(list, this.t, "CONCERN");
        t(list);
    }
}
