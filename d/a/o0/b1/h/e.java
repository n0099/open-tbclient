package d.a.o0.b1.h;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.view.HomePageBrowseModelTipView;
import com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.view.BdTopToast;
import com.squareup.wire.Wire;
import d.a.i.v0.a;
import d.a.n0.r.f0.f;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.j1;
import d.a.n0.r.q.l1;
import d.a.n0.r.q.n0;
import d.a.o0.g0.a;
import d.a.o0.r0.d1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Anti;
import tbclient.App;
import tbclient.BannerList;
import tbclient.BlockPopInfo;
import tbclient.DiscoverHotForum;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes4.dex */
public class e {
    public boolean B;
    public int C;
    public d.a.n0.z0.a0 E;
    public View.OnTouchListener F;
    public d.a.o0.b1.h.j.h G;
    public BdUniqueId I;
    public SmartBubbleAnimatedView J;
    public HomePageYoungsterTopView K;
    public HomePageBrowseModelTipView L;
    public int M;

    /* renamed from: a  reason: collision with root package name */
    public final long f55469a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.o0.b1.h.b f55470b;
    public Runnable d0;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f55473e;
    public final TbPageContext<?> j;
    public final BdTypeRecyclerView k;
    public final BigdaySwipeRefreshLayout l;
    public final d.a.o0.b1.h.h.c0 m;
    public d1 o;
    public final d.a.o0.b1.h.k.a p;
    public d.a.o0.e3.h0.f q;
    public ScrollFragmentTabHost s;
    public d.a.o0.g0.a t;
    public d.a.o0.k2.i v;

    /* renamed from: c  reason: collision with root package name */
    public l0 f55471c = null;

    /* renamed from: d  reason: collision with root package name */
    public final List<d.a.c.k.e.n> f55472d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public int f55474f = 1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55475g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55476h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f55477i = 0;
    public int n = 2000;
    public d.a.n0.m0.c r = null;
    public boolean u = false;
    public int w = 0;
    public int x = 0;
    public boolean y = false;
    public boolean z = true;
    public boolean A = false;
    public boolean D = false;
    public boolean H = true;
    public BdUniqueId N = BdUniqueId.gen();
    public a.C0602a O = new a.C0602a(2);
    public ThreadInfo P = null;
    public RecyclerView.OnScrollListener Q = new v();
    public View.OnTouchListener R = new f0();
    public a.b S = new g0();
    public final CustomMessageListener T = new h0(2001399);
    public final CustomMessageListener U = new i0(2921461);
    public final CustomMessageListener V = new j0(2921486);
    public final CustomMessageListener W = new k0(2921562);
    public CustomMessageListener X = new i(2004004);
    public CustomMessageListener Y = new j(2921026);
    public CustomMessageListener Z = new l(2001115);
    public CustomMessageListener a0 = new m(0);
    public String b0 = "lastReadReadPositionKey";
    public int c0 = 0;
    public d.a.o0.b1.h.d e0 = new q();
    public CustomMessageListener f0 = new t(2016569);
    public CustomMessageListener g0 = new u(2016488);
    public CustomMessageListener h0 = new w(2016553);
    public CustomMessageListener i0 = new x(2921547);
    public CustomMessageListener j0 = new y(2016331);
    public CustomMessageListener k0 = new z(2921381);
    public d.a.c.c.g.a l0 = new a0(CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
    public CustomMessageListener m0 = new b0(2921414);
    public CustomMessageListener n0 = new c0(2921453);
    public final d.a.c.c.g.a o0 = new d0(CmdConfigHttp.CMD_GET_MY_POST, 303111);
    public CustomMessageListener p0 = new e0(2921482);

    /* loaded from: classes4.dex */
    public class a implements CustomMessageTask.CustomRunnable<Boolean> {
        public a() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            ThreadCardViewHolder d0 = e.this.d0();
            if (d0 != null && d0.b() != null) {
                return new CustomResponsedMessage<>(2016323, Boolean.valueOf(d0.b().o(new a.C0602a(6))));
            }
            return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends d.a.c.c.g.a {
        public a0(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            d.a.o0.b1.k.b.c.b bVar;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof BlessHttpResponseMessage) {
                BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                j = blessHttpResponseMessage.userPkId;
                j2 = blessHttpResponseMessage.pkID;
            } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                j = blessSocketResponseMessage.userPkId;
                j2 = blessSocketResponseMessage.pkID;
            } else {
                j = 0;
                j2 = 0;
            }
            if (j2 == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                j2 = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
            }
            if (j2 == 0) {
                return;
            }
            for (d.a.c.k.e.n nVar : e.this.f55472d) {
                if ((nVar instanceof d.a.o0.b1.k.b.c.a) && (bVar = ((d.a.o0.b1.k.b.c.a) nVar).Z) != null && j2 == bVar.f55799b) {
                    bVar.f55800c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MessageQueue.IdleHandler {
        public b() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            e.this.t0();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.m.m();
                if (e.this.y || !e.this.z) {
                    return;
                }
                e.this.v.n(e.this.w, e.this.x, e.this.u, true);
            }
        }

        public b0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a2 a2Var;
            List<d.a.c.k.e.n> h2 = e.this.m.h();
            if (!ListUtils.isEmpty(h2)) {
                for (d.a.c.k.e.n nVar : h2) {
                    if (nVar instanceof d.a.o0.z.e0.k) {
                        d.a.o0.z.e0.k kVar = (d.a.o0.z.e0.k) nVar;
                        if (kVar.o != 0 && (a2Var = kVar.f67302e) != null) {
                            int[] p0 = a2Var.p0();
                            kVar.o = p0[0];
                            kVar.p = p0[1];
                        }
                    }
                }
            }
            d.a.c.e.m.e.a().postDelayed(new a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.n0.z0.f0<DataRes> {
        public c(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            byte[] bArr;
            d.a.c.e.d.l<byte[]> e2 = d.a.n0.r.r.a.f().e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
    public class c0 extends CustomMessageListener {
        public c0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof j1)) {
                return;
            }
            j1 j1Var = (j1) customResponsedMessage.getData();
            if (j1Var.f53841a != 1) {
                return;
            }
            int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
            int i2 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(e.this.N);
            requestGetMyPostNetMessage.setParams(d.a.c.e.m.b.f(j1Var.f53843c, 0L), 0L, 0L, k, i2, f2, i3);
            requestGetMyPostNetMessage.setBFrom("push");
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.n0.z0.n<DataRes> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            e.this.w0(dataRes);
        }
    }

    /* loaded from: classes4.dex */
    public class d0 extends d.a.c.c.g.a {
        public d0(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl responseData;
            tbclient.GetMyPost.DataRes dataRes;
            ThreadInfo threadInfo;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                responseData = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else {
                responseData = responsedMessage instanceof GetMyPostSocketResponseMessage ? ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData() : null;
            }
            if (responseData == null || (dataRes = responseData.data) == null || (threadInfo = dataRes.thread_info) == null) {
                return;
            }
            e.this.P = threadInfo;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        }
    }

    /* renamed from: d.a.o0.b1.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1264e extends d.a.n0.z0.f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f55486a;

        public C1264e(DataRes.Builder builder) {
            this.f55486a = builder;
        }

        @Override // d.a.n0.z0.f0
        public Object doInBackground() {
            DataRes.Builder builder = new DataRes.Builder(this.f55486a.build(true));
            e.this.f55470b.g(builder.thread_list);
            try {
                d.a.n0.r.r.a.f().e("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 extends CustomMessageListener {
        public e0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.a.n0.s.h.a.e(TbadkCoreApplication.getInst(), 1)) {
                d.a.n0.s.h.a.g(e.this.j, 7, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.a.n0.z0.f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f55489a;

        public f(DataRes.Builder builder) {
            this.f55489a = builder;
        }

        @Override // d.a.n0.z0.f0
        public Object doInBackground() {
            DataRes.Builder builder = new DataRes.Builder(this.f55489a.build(true));
            e.this.f55470b.g(builder.thread_list);
            try {
                d.a.n0.r.r.a.f().e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements View.OnTouchListener {
        public f0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.F != null) {
                e.this.F.onTouch(view, motionEvent);
            }
            if (e.this.t != null) {
                e.this.t.c(motionEvent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(e.this.j, null);
        }
    }

    /* loaded from: classes4.dex */
    public class g0 implements a.b {
        public g0() {
        }

        @Override // d.a.o0.g0.a.b
        public void a(int i2, int i3) {
            e.this.u = false;
        }

        @Override // d.a.o0.g0.a.b
        public void b(int i2, int i3) {
            e.this.u = true;
        }

        @Override // d.a.o0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.o0.g0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class h implements HomePageYoungsterTopView.b {
        public h() {
        }

        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.b
        public void onDelete() {
            BdTopToast bdTopToast = new BdTopToast(e.this.j.getPageActivity(), 2000);
            bdTopToast.i(true);
            bdTopToast.h(e.this.j.getPageActivity().getString(R.string.youngster_frs_top_toast));
            bdTopToast.j((ViewGroup) e.this.j.getPageActivity().findViewById(R.id.maintabContainer));
            e.this.Y0(false);
            d.a.n0.r.d0.b.j().t("key_youngster_homgpage_top_view_closed", true);
        }
    }

    /* loaded from: classes4.dex */
    public class h0 extends CustomMessageListener {
        public h0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.k != null) {
                e.this.v.w();
                e.this.z = false;
                e.this.l.setRefreshing(true);
            }
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
            a2 a2Var;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a2) || e.this.f55473e == null || ListUtils.getCount(e.this.f55473e.thread_list) == 0 || (a2Var = (a2) customResponsedMessage.getData()) == null || a2Var.R0() == null || a2Var.o0() == null || ListUtils.getCount(e.this.f55473e.thread_list) == 0) {
                return;
            }
            for (int i2 = 0; i2 < e.this.f55473e.thread_list.size(); i2++) {
                ThreadInfo threadInfo = e.this.f55473e.thread_list.get(i2);
                if (threadInfo != null && threadInfo.id.longValue() == d.a.c.e.m.b.f(a2Var.o0(), -1L)) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    Zan.Builder builder2 = new Zan.Builder(builder.zan);
                    builder2.num = Integer.valueOf((int) a2Var.R0().getNum());
                    builder.zan = builder2.build(true);
                    e.this.f55473e.thread_list.set(i2, builder.build(true));
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 extends CustomMessageListener {
        public i0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.k != null) {
                e.this.a0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a2 a2Var;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (ListUtils.isEmpty(e.this.f55472d) || ListUtils.isEmpty(ids) || ListUtils.isEmpty(originData)) {
                    return;
                }
                for (int i2 = 0; i2 < originData.size(); i2++) {
                    if ((originData.get(i2) instanceof a2) && (a2Var = (a2) originData.get(i2)) != null && a2Var.s1() != null && ids.contains(Long.valueOf(a2Var.s1().live_id))) {
                        e.this.f55472d.remove(a2Var);
                    }
                }
                if (e.this.m != null) {
                    e.this.m.z(new ArrayList(e.this.f55472d));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 extends CustomMessageListener {
        public j0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            int intValue = data instanceof Integer ? ((Integer) data).intValue() : 0;
            if (intValue == 2) {
                BdTopToast bdTopToast = new BdTopToast(e.this.j.getPageActivity(), 2000);
                bdTopToast.i(true);
                bdTopToast.h(e.this.j.getPageActivity().getString(R.string.youngster_open_title));
                bdTopToast.j((ViewGroup) e.this.j.getPageActivity().findViewById(R.id.maintabContainer));
                e.this.Y0(true);
            } else if (intValue == 3) {
                BdTopToast bdTopToast2 = new BdTopToast(e.this.j.getPageActivity(), 2000);
                bdTopToast2.i(true);
                bdTopToast2.h(e.this.j.getPageActivity().getString(R.string.youngster_close_title));
                bdTopToast2.j((ViewGroup) e.this.j.getPageActivity().findViewById(R.id.maintabContainer));
                e.this.Y0(false);
            } else if (intValue != 5) {
                if (d.a.n0.c1.b.e.d()) {
                    e.this.Y0(true);
                }
            } else {
                BdTopToast bdTopToast3 = new BdTopToast(e.this.j.getPageActivity(), 2000);
                bdTopToast3.i(true);
                bdTopToast3.h(e.this.j.getPageActivity().getString(R.string.youngster_reset_title));
                bdTopToast3.j((ViewGroup) e.this.j.getPageActivity().findViewById(R.id.maintabContainer));
                e.this.Y0(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ScrollFragmentTabHost.t {
        public k() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.t
        public void a(int i2) {
            if (e.this.s.A(i2) == 1 || e.this.o == null) {
                return;
            }
            e.this.o.d();
        }
    }

    /* loaded from: classes4.dex */
    public class k0 extends CustomMessageListener {
        public k0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Boolean bool = Boolean.FALSE;
            if (customResponsedMessage.getData() instanceof Boolean) {
                bool = (Boolean) customResponsedMessage.getData();
            }
            if (bool.booleanValue()) {
                e.this.V0(true);
            } else {
                e.this.V0(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            User user;
            int intValue;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || e.this.f55473e == null || ListUtils.isEmpty(e.this.f55473e.thread_list)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12720c)) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= e.this.f55473e.thread_list.size()) {
                    break;
                }
                ThreadInfo threadInfo = e.this.f55473e.thread_list.get(i2);
                if (threadInfo == null || (user = threadInfo.author) == null || user.id.longValue() != d.a.c.e.m.b.f(updateAttentionMessage.getData().f12720c, -1L)) {
                    i2++;
                } else {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    User.Builder builder2 = new User.Builder(builder.author);
                    builder2.is_like = Integer.valueOf(updateAttentionMessage.getData().f12721d ? 1 : 0);
                    builder2.has_concerned = Integer.valueOf(updateAttentionMessage.getData().f12721d ? 1 : 0);
                    GodInfo.Builder builder3 = new GodInfo.Builder(builder2.god_data);
                    if (updateAttentionMessage.getData().f12721d) {
                        intValue = builder2.fans_num.intValue() + 1;
                        builder3.followed = 1;
                    } else {
                        builder3.followed = 0;
                        intValue = builder2.fans_num.intValue() - 1;
                    }
                    builder2.fans_num = Integer.valueOf(intValue);
                    builder2.god_data = builder3.build(true);
                    builder.author = builder2.build(true);
                    e.this.f55473e.thread_list.set(i2, builder.build(true));
                }
            }
            e.this.c1(updateAttentionMessage);
        }
    }

    /* loaded from: classes4.dex */
    public interface l0 {
        void a(int i2, d.a.n0.z0.c cVar, int i3);

        void b();

        void c(int i2, int i3, d.a.n0.z0.c cVar, int i4);

        void d(boolean z);

        void onError(int i2, String str);
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public m(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || e.this.f55473e == null || e.this.f55473e.hot_recomforum == null || ListUtils.isEmpty(e.this.f55473e.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.f55473e.hot_recomforum);
            if (d.a.o0.b1.c.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                e.this.f55473e.hot_recomforum = builder.build(true);
                e.this.F0(new DataRes.Builder(e.this.f55473e.build(true)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends d.a.n0.z0.f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55504a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f55505b;

        public n(String str, boolean z) {
            this.f55504a = str;
            this.f55505b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.n0.z0.f0
        public Boolean doInBackground() {
            int intValue;
            try {
                d.a.c.e.d.l<byte[]> e2 = d.a.n0.r.r.a.f().e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (e2 == null) {
                    return Boolean.FALSE;
                }
                byte[] bArr = e2.get("0");
                if (bArr != null && bArr.length != 0) {
                    DataRes.Builder builder = new DataRes.Builder((DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class));
                    if (builder.thread_list != null && builder.thread_list.size() > 0) {
                        for (int i2 = 0; i2 < builder.thread_list.size(); i2++) {
                            ThreadInfo threadInfo = builder.thread_list.get(i2);
                            if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == d.a.c.e.m.b.f(this.f55504a, -1L)) {
                                ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                                User.Builder builder3 = new User.Builder(builder2.author);
                                builder3.is_like = Integer.valueOf(this.f55505b ? 1 : 0);
                                builder3.has_concerned = Integer.valueOf(this.f55505b ? 1 : 0);
                                GodInfo.Builder builder4 = new GodInfo.Builder(builder3.god_data);
                                if (this.f55505b) {
                                    intValue = builder3.fans_num.intValue() + 1;
                                    builder4.followed = 1;
                                } else {
                                    intValue = builder3.fans_num.intValue() - 1;
                                    builder4.followed = 0;
                                }
                                builder3.fans_num = Integer.valueOf(intValue);
                                builder3.god_data = builder4.build(true);
                                builder2.author = builder3.build(true);
                                builder.thread_list.set(i2, builder2.build(true));
                            }
                        }
                        DataRes.Builder builder5 = new DataRes.Builder(builder.build(true));
                        e.this.f55470b.g(builder5.thread_list);
                        e2.g("0", builder5.build(true).toByteArray());
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }
                return Boolean.FALSE;
            } catch (Exception e3) {
                BdLog.e(e3);
                return Boolean.FALSE;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements d.a.n0.z0.n<Boolean> {
        public o(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
        }
    }

    /* loaded from: classes4.dex */
    public class p extends d.a.n0.z0.f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55507a;

        public p(int i2) {
            this.f55507a = i2;
        }

        @Override // d.a.n0.z0.f0
        public Object doInBackground() {
            d.a.c.e.d.l<String> h2 = d.a.n0.r.r.a.f().h(e.this.b0, TbadkCoreApplication.getCurrentAccount());
            if (h2 != null) {
                h2.e(e.this.b0, Integer.toString(this.f55507a), 43200000L);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements d.a.o0.b1.h.d {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f55510e;

            public a(int i2) {
                this.f55510e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.k.getHandler() == null) {
                    return;
                }
                e.this.k.requestFocusFromTouch();
                if (this.f55510e > e.this.k.getCount() - 1) {
                    return;
                }
                e.this.k.setSelection(this.f55510e);
            }
        }

        public q() {
        }

        @Override // d.a.o0.b1.h.d
        public void a(int i2) {
            if (e.this.d0 == null) {
                e.this.d0 = new a(i2);
            }
            e.this.k.removeCallbacks(e.this.d0);
            e.this.k.post(e.this.d0);
        }
    }

    /* loaded from: classes4.dex */
    public class r extends d.a.n0.z0.f0<String> {
        public r() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.f0
        /* renamed from: a */
        public String doInBackground() {
            d.a.c.e.d.l<String> h2 = d.a.n0.r.r.a.f().h(e.this.b0, TbadkCoreApplication.getCurrentAccount());
            if (h2 != null) {
                return h2.get(e.this.b0);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class s implements d.a.n0.z0.n<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.b1.h.d f55513a;

        public s(e eVar, d.a.o0.b1.h.d dVar) {
            this.f55513a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            d.a.o0.b1.h.d dVar = this.f55513a;
            if (dVar != null) {
                dVar.a(d.a.c.e.m.b.d(str, 0));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public t(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || e.this.G == null) {
                return;
            }
            TbSingleton.getInstance().isAddBanner = false;
            e.this.f55472d.remove(e.this.G);
            e.this.m.z(new ArrayList(e.this.f55472d));
            d.a.n0.r.d0.b.j().w("key_maintab_banner_close_time", System.currentTimeMillis());
        }
    }

    /* loaded from: classes4.dex */
    public class u extends CustomMessageListener {
        public u(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.b0(customResponsedMessage);
            if (e.this.v == null || !e.this.z) {
                return;
            }
            e.this.v.n(e.this.w, e.this.x, e.this.u, true);
        }
    }

    /* loaded from: classes4.dex */
    public class v extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f55516a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f55517b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55518c = false;

        public v() {
        }

        public void a(int i2, int i3) {
            if (this.f55517b > i2) {
                this.f55518c = true;
            }
            if (e.this.E != null && !e.this.y) {
                e.this.E.a(this.f55517b, i2);
            }
            this.f55517b = i2;
            int i4 = (i3 + i2) - 1;
            if (!this.f55518c && this.f55516a != i4) {
                this.f55516a = i4;
                e.this.A0(i4);
            }
            if (this.f55518c && this.f55516a != i2) {
                this.f55516a = i2;
                e.this.A0(i2);
            }
            e.this.c0 = i2;
            e.this.w = i2;
            e.this.x = i4;
            ThreadCardViewHolder d0 = e.this.d0();
            if (d0 == null || d0.b() == null) {
                return;
            }
            d0.b().o(e.this.O);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (e.this.r == null) {
                e.this.r = new d.a.n0.m0.c();
                e.this.r.a(1005);
                e.this.r.f53309e = 1;
            }
            if (e.this.E != null && !e.this.y) {
                e.this.E.b(recyclerView, i2);
            }
            if (i2 == 0) {
                d.a.o0.b1.h.c.b(e.this.k);
                e.this.r.e();
                d.a.o0.z.t.b().d(true);
                d.a.o0.o.d.c().h("page_recommend", "show_");
                d.a.o0.d3.c.g().h(e.this.I, false);
                this.f55518c = false;
                if (e.this.v == null || !e.this.z || e.this.y) {
                    return;
                }
                e.this.v.m(e.this.w, e.this.x, e.this.u, 1);
                return;
            }
            e.this.r.d();
            if (i2 == 1) {
                if (e.this.o != null) {
                    e.this.o.d();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
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
    public class w extends CustomMessageListener {
        public w(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.b0(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class x extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public String f55521a;

        /* renamed from: b  reason: collision with root package name */
        public String f55522b;

        /* renamed from: c  reason: collision with root package name */
        public String f55523c;

        /* renamed from: d  reason: collision with root package name */
        public String f55524d;

        /* renamed from: e  reason: collision with root package name */
        public String f55525e;

        public x(int i2) {
            super(i2);
            this.f55521a = "";
            this.f55522b = "";
            this.f55523c = "";
            this.f55524d = "";
            this.f55525e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                this.f55521a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                this.f55522b = jSONObject.optString("tid", "");
                this.f55523c = jSONObject.optString("fid", "");
                this.f55524d = jSONObject.optString("liveId", "");
                this.f55525e = jSONObject.optString("sid", "");
            } else if ((this.f55521a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f55521a)) && ((this.f55524d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f55524d)) && (this.f55525e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f55525e)))) {
            } else {
                try {
                    jSONObject.put("tid", this.f55522b);
                    jSONObject.put("fid", this.f55523c);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                e.this.b0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y extends CustomMessageListener {
        public y(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || e.this.f55473e == null || ListUtils.getCount(e.this.f55473e.thread_list) == 0) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            e eVar = e.this;
            eVar.Y(str, eVar.f55472d);
            e.this.a1(str);
            if (e.this.m != null) {
                e.this.m.z(new ArrayList(e.this.f55472d));
            }
            if (e.this.v == null || !e.this.z) {
                return;
            }
            e.this.v.n(e.this.w, e.this.x, e.this.u, true);
        }
    }

    /* loaded from: classes4.dex */
    public class z extends CustomMessageListener {
        public z(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder d0;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof KeyEvent)) {
                return;
            }
            KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (d0 = e.this.d0()) == null || d0.b() == null) {
                return;
            }
            d0.b().o(new a.C0602a(3));
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, d.a.o0.b1.h.h.c0 c0Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.M = 0;
        this.j = tbPageContext;
        this.M = d.a.n0.r.d0.b.j().k("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.R);
        if (d.a.n0.c1.b.e.d()) {
            Y0(true);
        }
        d.a.o0.g0.a aVar = new d.a.o0.g0.a();
        this.t = aVar;
        aVar.d(this.S);
        this.m = c0Var;
        this.p = new d.a.o0.b1.h.k.a();
        this.f55469a = d.a.n0.r.d0.b.j().l("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.Q);
        this.o = new d1();
        j0();
        d.a.o0.k2.i iVar = new d.a.o0.k2.i(this.j, this.k);
        this.v = iVar;
        iVar.p(1);
        this.v.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f55470b = new d.a.o0.b1.h.b(this.f55472d, this.m);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.J = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, d.a.c.e.p.l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        J0();
        this.m0.setTag(this.j.getUniqueId());
        MessageManager.getInstance().registerListener(this.m0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.o0.setTag(this.N);
        if (this.o0.getHttpMessageListener() != null) {
            this.o0.getHttpMessageListener().setSelfListener(true);
        }
        if (this.o0.getSocketMessageListener() != null) {
            this.o0.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.o0);
        MessageManager.getInstance().registerListener(this.n0);
        MessageManager.getInstance().registerListener(this.p0);
    }

    public void A0(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        d.a.o0.e3.h0.f fVar = this.q;
        if ((fVar != null ? fVar.b(i2) : -1) >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
            this.q.c(i2);
        }
    }

    public void B0() {
        d.a.o0.b1.h.c.b(this.k);
        T(this.c0);
        d.a.n0.m0.c cVar = this.r;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void C0(boolean z2) {
        if (z2) {
            this.m.m();
        }
    }

    public final void D0() {
        if (ListUtils.getCount(this.f55472d) < this.p.e() - 40) {
            return;
        }
        List<d.a.c.k.e.n> list = null;
        d.a.o0.b1.h.k.c c2 = this.p.c(true, this.f55473e, null, 1);
        int i2 = 0;
        if (c2 != null) {
            list = c2.f55643a;
            int i3 = c2.f55645c;
            c2.f55645c = 0;
            i2 = i3;
        }
        if (list != null) {
            this.f55472d.clear();
            this.f55472d.addAll(list);
            this.m.A(new LinkedList(this.f55472d), i2);
        }
    }

    public final boolean E0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        List<d.a.c.k.e.n> list;
        int i2;
        BlockPopInfo blockPopInfo;
        boolean z5 = false;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.M == 1) {
            if (z3 && (dataRes.thread_list.size() >= 6 || k0())) {
                L0();
                this.f55473e = null;
            }
        } else if (z3 && k0()) {
            this.f55473e = null;
        }
        int size = z3 ? 0 : this.f55472d.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.f55472d.clear();
        d.a.o0.b1.h.k.c c2 = this.p.c(z2, this.f55473e, builder, !z3 ? 1 : 0);
        if (c2 != null) {
            list = c2.f55643a;
            this.f55477i = c2.f55644b;
            i2 = c2.f55645c;
            c2.f55645c = 0;
        } else {
            list = null;
            i2 = 0;
        }
        if (list != null) {
            this.f55472d.addAll(list);
            R(list, size);
            K0(!z3 ? 1 : 0, list, size);
            if (this.D) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.f55473e == null) {
            this.f55473e = builder;
            this.f55470b.j(builder.thread_list);
        }
        if (this.f55472d.size() != 0) {
            if (z3) {
                if (dataRes.live_answer != null) {
                    d.a.o0.b1.h.j.h hVar = new d.a.o0.b1.h.j.h();
                    this.G = hVar;
                    hVar.c(dataRes.live_answer);
                    this.f55473e.live_answer = dataRes.live_answer;
                } else if (z2) {
                    this.G = null;
                    this.f55473e.live_answer = null;
                }
                this.f55473e.float_info = dataRes.float_info;
            }
            long l2 = d.a.n0.r.d0.b.j().l("key_maintab_banner_close_time", 0L);
            if (this.G != null && !StringHelper.isTaday(l2)) {
                TbSingleton.getInstance().isAddBanner = true;
                this.f55472d.add(0, this.G);
            }
            LinkedList linkedList = new LinkedList(this.f55472d);
            d.a.o0.b1.h.h.c0 c0Var = this.m;
            Integer num = dataRes.is_new_url;
            if (num != null && num.intValue() == 1) {
                z5 = true;
            }
            c0Var.t(z5);
            this.m.A(linkedList, i2);
            d.a.o0.k2.i iVar = this.v;
            if (iVar != null && this.z) {
                iVar.n(this.w, this.x, this.u, true);
            }
            z5 = true;
        }
        d.a.o0.b1.d.a.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
        long e2 = d.a.o0.b1.d.a.d().e(1);
        int i3 = (e2 > 0L ? 1 : (e2 == 0L ? 0 : -1));
        if (i3 > 0) {
            d.a.o0.b1.d.a.d().k(System.currentTimeMillis() - e2, 1);
            d.a.o0.b1.d.a.d().j(0L, 1);
        }
        Anti anti = dataRes.anti;
        if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
            d.a.o0.m3.d.g(blockPopInfo);
        }
        l1 l1Var = new l1();
        l1Var.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, l1Var));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
        if (!z2 && i3 > 0) {
            d.a.n0.m0.l.b().H(System.currentTimeMillis() - e2);
        }
        return z5;
    }

    public final void F0(DataRes.Builder builder) {
        d.a.n0.z0.h0.b(new f(builder), null);
    }

    public void G0(int i2, int i3) {
        a2 a2Var;
        if (ListUtils.isEmpty(this.f55472d) || this.f55472d.size() <= i2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (i2 < this.f55472d.size() && i2 <= i3) {
            if (this.f55472d.get(i2).getType().getId() == a2.k3.getId() && (a2Var = (a2) this.f55472d.get(i2)) != null && a2Var.s1() != null) {
                arrayList.add(Long.valueOf(a2Var.s1().live_id));
                arrayList2.add(a2Var);
            }
            i2++;
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
    }

    public void H0() {
        d.a.o0.k2.i iVar = this.v;
        if (iVar != null && !this.y && this.z) {
            iVar.n(this.w, this.x, this.u, true);
        }
        if (this.A) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
            if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.u()) {
                boolean z2 = this.B;
                if (z2) {
                    d.a.o0.d3.c.g().h(this.I, false);
                    if (l0(false)) {
                        X0(3, this.f55477i);
                    } else if (this.C > 0) {
                        X0(2, this.f55477i);
                    }
                } else if (!z2 && this.f55477i == 0) {
                    X0(2, 0);
                }
            }
            this.A = false;
            this.B = false;
            this.C = 0;
            if (this.D) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.D = false;
        }
    }

    public void I0(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.I = bdUniqueId;
        CustomMessageListener customMessageListener = this.X;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
        }
        CustomMessageListener customMessageListener2 = this.T;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.T);
        }
        this.U.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.U);
        this.Z.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Z);
        this.a0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.a0);
        MessageManager.getInstance().registerListener(2001336, this.a0);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Y);
        this.g0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g0);
        this.h0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.h0);
        this.i0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i0);
        this.j0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j0);
        d.a.o0.k2.i iVar = this.v;
        if (iVar != null) {
            iVar.t(bdUniqueId);
        }
        this.f55470b.i(bdUniqueId);
        this.f0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f0);
        this.k0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k0);
        this.l0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l0);
        this.V.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.V);
        this.W.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.W);
    }

    public final void J0() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void K0(int i2, List<d.a.c.k.e.n> list, int i3) {
        int i4;
        d.a.o0.e3.h0.f fVar = this.q;
        if (fVar == null) {
            return;
        }
        if (i2 == 0) {
            fVar.d();
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        int[] iArr = d.a.o0.e3.h0.f.f57814e;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
            if ((list.get(i7) instanceof d.a.o0.z.e0.b) && (i6 = i6 + 1) == i4 - 1) {
                int i8 = i7 + 1;
                if (i3 < i8) {
                    this.q.a(i4, i8);
                }
                i5++;
            }
        }
    }

    public final void L0() {
        DataRes.Builder builder = this.f55473e;
        if (builder == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 50) {
            builder2.thread_list = builder2.thread_list.subList(0, 50);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        V(builder2, list2 != null ? list2.size() : 0);
        d.a.n0.z0.h0.b(new C1264e(builder2), null);
    }

    public void M0() {
        d.a.o0.b1.h.c.c(this.k);
    }

    public void N0(boolean z2) {
        this.H = z2;
        d1 d1Var = this.o;
        if (d1Var == null || z2) {
            return;
        }
        d1Var.d();
    }

    public final void O0(boolean z2) {
        this.f55475g = z2;
    }

    public void P0(l0 l0Var) {
        this.f55471c = l0Var;
    }

    public void Q0(boolean z2) {
        this.z = z2;
    }

    public final void R(List<d.a.c.k.e.n> list, int i2) {
        Set<d.a.c.k.e.n> a2 = d.a.o0.t2.a.a(list, this.f55474f, "NEWINDEX");
        if (a2.size() > 0) {
            d.a.o0.d3.c.g().c(this.I, d.a.o0.d3.a.h("a002", "common_fill", true, a2.size()));
        }
    }

    public void R0(d.a.n0.z0.b0 b0Var) {
        if (b0Var != null) {
            this.E = b0Var.a();
            this.F = b0Var.b();
        }
    }

    public final d.a.n0.z0.c S(boolean z2) {
        String e2 = d.a.o0.t2.a.e(this.f55472d, z2);
        int U = U(z2);
        d.a.n0.z0.c cVar = new d.a.n0.z0.c();
        cVar.f54765b = e2;
        cVar.f54764a = U;
        return cVar;
    }

    public void S0(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.s = scrollFragmentTabHost;
        if (scrollFragmentTabHost == null) {
            return;
        }
        scrollFragmentTabHost.setOnTabSelectedListener(new k());
    }

    public void T(int i2) {
        d.a.n0.z0.h0.b(new p(i2), null);
    }

    public void T0(boolean z2) {
        this.y = z2;
    }

    public int U(boolean z2) {
        int i2;
        int i3;
        List<d.a.c.k.e.n> list = this.f55472d;
        int i4 = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i5 = -1;
        if (z2) {
            int i6 = 0;
            while (i4 < this.f55472d.size()) {
                d.a.c.k.e.n nVar = this.f55472d.get(i4);
                if ((nVar instanceof d.a.o0.z.e0.b) && (i3 = ((d.a.o0.z.e0.b) nVar).position) != i5) {
                    i6++;
                    i5 = i3;
                }
                if ((nVar instanceof d.a.o0.b1.h.j.a) && nVar.getType() != AdvertAppInfo.f4) {
                    return i6;
                }
                i4++;
            }
        } else {
            for (int size = this.f55472d.size() - 1; size >= 0; size--) {
                d.a.c.k.e.n nVar2 = this.f55472d.get(size);
                if ((nVar2 instanceof d.a.o0.z.e0.b) && (i2 = ((d.a.o0.z.e0.b) nVar2).position) != i5) {
                    i4++;
                    i5 = i2;
                }
                if ((nVar2 instanceof d.a.o0.b1.h.j.a) && nVar2.getType() != AdvertAppInfo.f4) {
                    return i4;
                }
            }
        }
        return this.f55472d.size();
    }

    public void U0() {
        d.a.n0.s.c.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (!activityPrizeData.g() || StringUtils.isNull(activityPrizeData.b())) {
            return;
        }
        String currentDay = UtilHelper.getCurrentDay();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        String str = "";
        String p2 = d.a.n0.r.d0.b.j().p("activity_prize_feed_text_time", "");
        boolean z2 = true;
        if (!StringUtils.isNull(p2)) {
            String[] split = p2.split("@");
            if (split != null && split.length == 2) {
                String str2 = split[0];
                String[] split2 = split[1].split(",");
                if (!StringUtils.isNull(str2) && split2.length != 0) {
                    if (str2.equals(currentDay)) {
                        List<String> asList = Arrays.asList(split2);
                        if (asList.contains(currentAccount)) {
                            z2 = false;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(currentDay);
                            sb.append("@");
                            for (String str3 : asList) {
                                sb.append(str3);
                                sb.append(",");
                            }
                            sb.append(currentAccount);
                            str = sb.toString();
                        }
                    } else {
                        str = currentDay + "@" + currentAccount;
                    }
                } else {
                    str = currentDay + "@" + currentAccount;
                }
            } else {
                str = currentDay + "@" + currentAccount;
            }
        } else {
            str = currentDay + "@" + currentAccount;
        }
        if (z2) {
            X0(4, 0);
            d.a.n0.r.d0.b.j().x("activity_prize_feed_text_time", str);
        }
    }

    public final void V(DataRes.Builder builder, int i2) {
        BannerList bannerList;
        BannerList.Builder builder2;
        List<App> list;
        if (builder == null || (bannerList = builder.banner_list) == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        Iterator<App> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = d.a.o0.t2.c.b(next);
                if (b2 < 0) {
                    it.remove();
                } else if (b2 < i2 + i3 + 1) {
                    i3++;
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
        builder.banner_list = builder2.build(false);
    }

    public final void V0(boolean z2) {
        if (z2) {
            if (this.L == null) {
                HomePageBrowseModelTipView homePageBrowseModelTipView = new HomePageBrowseModelTipView(this.j.getPageActivity());
                this.L = homePageBrowseModelTipView;
                homePageBrowseModelTipView.setListener(new g());
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setHeaderView(this.L, false);
                this.L.setVisibility(0);
                this.k.scrollToPosition(0);
                return;
            }
            return;
        }
        HomePageBrowseModelTipView homePageBrowseModelTipView2 = this.L;
        if (homePageBrowseModelTipView2 != null) {
            this.k.removeHeaderView(homePageBrowseModelTipView2);
            this.L.setVisibility(8);
            this.L = null;
        }
    }

    public final void W(DataRes.Builder builder) {
        builder.user_follow_live = null;
    }

    public void W0() {
        d.a.n0.z0.a0 a0Var = this.E;
        if (a0Var != null) {
            a0Var.c(true);
        }
    }

    public final void X(DataRes.Builder builder) {
        builder.active_center = null;
    }

    public final void X0(int i2, int i3) {
        if (o0()) {
            return;
        }
        if (this.s != null) {
            this.o.f();
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost != null && scrollFragmentTabHost.getCurrentTabType() != 1) {
            this.o.d();
        } else if (!this.H) {
            this.o.d();
        } else {
            String str = null;
            if (i2 == 2) {
                if (i3 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i3));
                } else {
                    str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                }
            } else if (i2 == 3) {
                str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
            } else if (i2 == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().b();
            }
            if (TextUtils.isEmpty(str) || !d.a.c.e.p.j.z()) {
                return;
            }
            if (i2 == 4) {
                this.n = 3000;
            } else {
                this.n = 2000;
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.J;
            smartBubbleAnimatedView.f15318e = str;
            smartBubbleAnimatedView.f15319f = this.n;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            ScrollFragmentTabHost scrollFragmentTabHost2 = this.s;
            if (scrollFragmentTabHost2 != null) {
                FrameLayout frameLayout = scrollFragmentTabHost2.getFrameLayout();
                frameLayout.removeView(this.J);
                frameLayout.addView(this.J, layoutParams);
                this.J.g();
            }
        }
    }

    public final void Y(String str, List<d.a.c.k.e.n> list) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = list.iterator();
        while (true) {
            AdvertAppInfo advertAppInfo = null;
            while (it.hasNext()) {
                d.a.c.k.e.n next = it.next();
                if (next instanceof d.a.o0.b1.h.j.a) {
                    advertAppInfo = ((d.a.o0.b1.h.j.a) next).c();
                } else if (next instanceof n0) {
                    n0 n0Var = (n0) next;
                    if (n0Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) n0Var.c()).getAdvertAppInfo();
                    }
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.J3)) {
                }
            }
            return;
            it.remove();
        }
    }

    public final void Y0(boolean z2) {
        boolean g2 = d.a.n0.r.d0.b.j().g("key_youngster_homgpage_top_view_closed", false);
        if (this.k == null || g2) {
            return;
        }
        if (z2) {
            if (this.K == null) {
                HomePageYoungsterTopView homePageYoungsterTopView = new HomePageYoungsterTopView(this.j);
                this.K = homePageYoungsterTopView;
                homePageYoungsterTopView.setOnDeleteClick(new h());
            }
            this.k.setHeaderView(this.K, false);
            this.K.setVisibility(0);
            this.k.scrollToPosition(0);
            return;
        }
        HomePageYoungsterTopView homePageYoungsterTopView2 = this.K;
        if (homePageYoungsterTopView2 != null) {
            homePageYoungsterTopView2.setVisibility(8);
            this.k.removeHeaderView(this.K);
            this.K = null;
        }
    }

    public void Z(Long l2) {
        List<ThreadInfo> list;
        DataRes.Builder builder = this.f55473e;
        if (builder == null || (list = builder.thread_list) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo.tid.equals(l2) && threadInfo.top_agree_post != null) {
                ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                builder2.top_agree_post = null;
                list.set(i2, builder2.build(true));
                b1();
                E0(false, true, false, this.f55473e.build(true));
                return;
            }
        }
    }

    public void Z0() {
        d.a.o0.b1.d.a.d().j(System.currentTimeMillis(), 1);
        this.f55474f = 1;
        this.D = true;
        if (this.f55472d.size() == 0 && !m0()) {
            if (this.f55476h) {
                return;
            }
            q0();
            return;
        }
        r0();
    }

    public final void a0() {
        Iterator<d.a.c.k.e.n> it = this.f55472d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof d.a.o0.b1.h.j.g) {
                it.remove();
                break;
            }
        }
        DataRes.Builder builder = this.f55473e;
        if (builder == null) {
            return;
        }
        builder.active_center = null;
        b1();
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            List<Integer> f02 = f0(bdTypeRecyclerView);
            int intValue = f02.get(0).intValue();
            int intValue2 = f02.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.k.E(intValue, intValue2);
        }
    }

    public final void a1(String str) {
        DataRes.Builder builder;
        BannerList bannerList;
        List<App> list;
        if (TextUtils.isEmpty(str) || (builder = this.f55473e) == null || (bannerList = builder.banner_list) == null || (list = bannerList.app) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (App app : this.f55473e.banner_list.app) {
            if (app != null && str.equals(d.a.o0.t2.c.a(app))) {
                arrayList.add(app);
            }
        }
        BannerList.Builder builder2 = new BannerList.Builder(this.f55473e.banner_list);
        List<App> list2 = builder2.app;
        if (list2 != null) {
            list2.removeAll(arrayList);
        }
        this.f55473e.banner_list = builder2.build(false);
        DataRes.Builder builder3 = new DataRes.Builder(this.f55473e.build(true));
        builder3.banner_list = builder2.build(true);
        F0(builder3);
    }

    public final void b0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f55473e) == null || ListUtils.getCount(builder.thread_list) == 0 || ListUtils.getCount(this.f55472d) == 0) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("tid");
        if (StringUtils.isNull(optString)) {
            String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            if (this.k == null || TextUtils.isEmpty(optString2)) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.k.getCount()) {
                    break;
                }
                d.a.c.k.e.n B = this.k.B(i2);
                if (B instanceof d.a.o0.z.e0.j) {
                    d.a.o0.z.e0.j jVar = (d.a.o0.z.e0.j) B;
                    if (jVar.i() != null && jVar.i().s1() != null && optString2.equals(String.valueOf(jVar.i().s1().live_id))) {
                        optString = jVar.i().z1();
                        break;
                    }
                }
                i2++;
            }
            if (StringUtils.isNull(optString)) {
                return;
            }
        }
        Iterator<d.a.c.k.e.n> it = this.f55472d.iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.c.k.e.n next = it.next();
            if (next instanceof d.a.o0.z.e0.b) {
                d.a.o0.z.e0.b bVar = (d.a.o0.z.e0.b) next;
                if (bVar.i() != null && bVar.i().z1() != null) {
                    if (bVar.i().z1().equals(optString)) {
                        it.remove();
                        z2 = true;
                    } else if (z2) {
                        d.a.o0.b1.h.k.b.b(this.f55472d);
                        break;
                    }
                }
            }
        }
        DataRes.Builder builder2 = this.f55473e;
        if (builder2 == null || builder2.thread_list == null) {
            return;
        }
        long f2 = d.a.c.e.m.b.f(optString, 0L);
        int i3 = 0;
        while (true) {
            if (i3 < this.f55473e.thread_list.size()) {
                ThreadInfo threadInfo = this.f55473e.thread_list.get(i3);
                if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == f2) {
                    d.a.o0.b1.h.l.c.d(threadInfo.tid.longValue(), i3, this.f55473e.thread_list, this.f55472d);
                    this.f55473e.thread_list.remove(i3);
                    b1();
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            List<Integer> i02 = i0(optString, bdTypeRecyclerView);
            int intValue = i02.get(0).intValue();
            int intValue2 = i02.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.k.E(intValue, intValue2);
        }
    }

    public final void b1() {
        DataRes.Builder builder = this.f55473e;
        if (builder == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 30) {
            builder2.thread_list = builder2.thread_list.subList(0, 30);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        V(builder2, list2 != null ? list2.size() : 0);
        W(builder2);
        X(builder2);
        F0(builder2);
    }

    public void c0(d.a.o0.b1.h.d dVar) {
        d.a.n0.z0.h0.b(new r(), new s(this, dVar));
    }

    public final void c1(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12720c)) {
            return;
        }
        d.a.n0.z0.h0.b(new n(updateAttentionMessage.getData().f12720c, updateAttentionMessage.getData().f12721d), new o(this));
    }

    public final ThreadCardViewHolder d0() {
        d.a.o0.k2.i iVar = this.v;
        if (iVar == null || iVar.j() == null || !(this.v.j().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.v.j().getTag();
    }

    public final String e0() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public final List<Integer> f0(BdTypeRecyclerView bdTypeRecyclerView) {
        ArrayList arrayList = new ArrayList(2);
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
            d.a.c.k.e.n B = bdTypeRecyclerView.B(i4);
            if (B instanceof d.a.o0.b1.h.j.g) {
                d.a.o0.b1.h.j.g gVar = (d.a.o0.b1.h.j.g) B;
                if (!z2) {
                    i2 = i4;
                }
                z2 = true;
                i3 = i4;
            }
        }
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i3));
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f.i g0() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        String b2;
        if (!this.A || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.u() || o0()) {
            return null;
        }
        int i2 = this.f55477i;
        boolean z2 = this.B;
        if (z2) {
            d.a.o0.d3.c.g().h(this.I, false);
            if (l0(false)) {
                c2 = 3;
            } else if (this.C <= 0) {
                c2 = 0;
            }
            if (this.s != null) {
                this.o.f();
            }
            scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost == null && scrollFragmentTabHost.getCurrentTabType() != 1) {
                this.o.d();
                return null;
            } else if (this.H) {
                this.o.d();
                return null;
            } else {
                if (c2 == 2) {
                    if (i2 > 0) {
                        b2 = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        b2 = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                    }
                } else if (c2 == 3) {
                    b2 = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
                } else {
                    b2 = c2 == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().b() : null;
                }
                if (TextUtils.isEmpty(b2) || !d.a.c.e.p.j.z()) {
                    return null;
                }
                if (c2 == 4) {
                    this.n = 1000;
                } else {
                    this.n = 0;
                }
                return new f.i(b2, this.n);
            }
        } else if (z2 || i2 != 0) {
            return null;
        } else {
            i2 = 0;
        }
        c2 = 2;
        if (this.s != null) {
        }
        scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost == null) {
        }
        if (this.H) {
        }
    }

    public d.a.o0.k2.i h0() {
        return this.v;
    }

    public final List<Integer> i0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        ArrayList arrayList = new ArrayList(2);
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
            d.a.c.k.e.n B = bdTypeRecyclerView.B(i4);
            if (B instanceof d.a.o0.z.e0.b) {
                d.a.o0.z.e0.b bVar = (d.a.o0.z.e0.b) B;
                if (bVar.i() != null && bVar.i().z1().equals(str)) {
                    if (!z2) {
                        i2 = i4;
                    }
                    z2 = true;
                    i3 = i4;
                }
            }
        }
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i3));
        return arrayList;
    }

    public void j0() {
        d.a.o0.e3.h0.f fVar = new d.a.o0.e3.h0.f("new_index", null);
        this.q = fVar;
        fVar.d();
    }

    public final boolean k0() {
        return l0(true);
    }

    public final boolean l0(boolean z2) {
        d.a.n0.r.d0.b j2 = d.a.n0.r.d0.b.j();
        long l2 = j2.l("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
        return l2 == 0 ? z2 : Math.abs(System.currentTimeMillis() - l2) > this.f55469a;
    }

    public final boolean m0() {
        return d.a.n0.r.d0.b.j().g(e0(), true);
    }

    public final boolean n0() {
        return this.f55475g;
    }

    public final boolean o0() {
        HomePageYoungsterTopView homePageYoungsterTopView = this.K;
        return homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0;
    }

    public void p0() {
        c0(this.e0);
    }

    public final void q0() {
        this.f55476h = true;
        d.a.n0.z0.h0.b(new c(this), new d());
    }

    public final void r0() {
        if (this.f55471c != null) {
            DataRes.Builder builder = this.f55473e;
            this.f55471c.a((builder == null || builder.thread_list == null || k0()) ? 0 : this.f55473e.thread_list.size(), S(true), 0);
        }
    }

    public void s0() {
        List<ThreadInfo> list;
        if (n0()) {
            d.a.o0.b1.d.a.d().j(0L, 1);
        } else if (this.f55471c != null) {
            D0();
            this.f55474f++;
            O0(true);
            DataRes.Builder builder = this.f55473e;
            this.f55471c.c(this.f55474f, (builder == null || (list = builder.thread_list) == null) ? 0 : list.size(), S(false), 0);
        }
    }

    public void t0() {
        d.a.n0.m0.l.b().q(System.currentTimeMillis() - d.a.n0.m0.l.b().c());
    }

    public final void u0() {
        d.a.n0.r.d0.b.j().t(e0(), false);
    }

    public void v0(boolean z2) {
        this.y = z2;
        ScrollFragmentTabHost scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.L(z2);
        }
        d.a.o0.k2.i iVar = this.v;
        if (iVar == null) {
            return;
        }
        iVar.q(!z2);
        ThreadCardViewHolder d02 = d0();
        boolean z3 = false;
        if (d02 != null && d02.b() != null) {
            z3 = d02.b().o(new a.C0602a(8, Boolean.valueOf(z2)));
        }
        if (z3) {
            return;
        }
        if (z2) {
            this.v.w();
        } else if (this.z) {
            this.v.n(this.w, this.x, this.u, true);
        }
    }

    public final void w0(DataRes dataRes) {
        this.f55476h = true;
        if (dataRes != null) {
            if (E0(false, true, true, dataRes) && !k0()) {
                l0 l0Var = this.f55471c;
                if (l0Var != null) {
                    l0Var.d(true);
                    Looper.myQueue().addIdleHandler(new b());
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    r0();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            r0();
            return;
        }
        r0();
    }

    public void x0(int i2) {
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.J;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i2);
        }
        HomePageYoungsterTopView homePageYoungsterTopView = this.K;
        if (homePageYoungsterTopView != null) {
            homePageYoungsterTopView.c();
        }
        HomePageBrowseModelTipView homePageBrowseModelTipView = this.L;
        if (homePageBrowseModelTipView != null) {
            homePageBrowseModelTipView.a();
        }
    }

    public void y0() {
        d.a.o0.k2.i iVar = this.v;
        if (iVar != null) {
            iVar.h();
        }
        d1 d1Var = this.o;
        if (d1Var != null) {
            d1Var.e();
        }
        d.a.o0.b1.h.b bVar = this.f55470b;
        if (bVar != null) {
            bVar.h();
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeCallbacks(this.d0);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.m0);
        MessageManager.getInstance().unRegisterListener(this.n0);
        MessageManager.getInstance().unRegisterListener(this.o0);
        MessageManager.getInstance().unRegisterListener(this.p0);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        int size;
        Long l2;
        List<ThreadInfo> list;
        DataRes dataRes2 = dataRes;
        if (z2) {
            d.a.o0.b1.h.g.a();
        }
        d.a.o0.b1.h.k.a aVar = this.p;
        if (aVar != null && aVar.i() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
            if (dataRes2 == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes2 = builder.build(false);
            }
            if (dataRes2.thread_list != null) {
                List<ThreadInfo> d2 = this.p.d();
                dataRes2.thread_list.addAll(d2);
                if (d2 != null) {
                    d2.clear();
                }
                z4 = true;
                DataRes.Builder builder2 = this.f55473e;
                size = (builder2 != null || (list = builder2.thread_list) == null) ? 0 : list.size();
                if (z2 && i2 == 0 && dataRes2 != null && ListUtils.isEmpty(dataRes2.thread_list)) {
                    l0 l0Var = this.f55471c;
                    if (l0Var != null) {
                        l0Var.b();
                    }
                    O0(false);
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                    if (bigdaySwipeRefreshLayout != null) {
                        bigdaySwipeRefreshLayout.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.P != null) {
                    DataRes.Builder builder3 = new DataRes.Builder(dataRes2);
                    builder3.thread_list.add(0, this.P);
                    dataRes2 = builder3.build(false);
                    DataRes.Builder builder4 = this.f55473e;
                    if (builder4 != null && !ListUtils.isEmpty(builder4.thread_list)) {
                        Iterator<ThreadInfo> it = this.f55473e.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && (l2 = next.tid) != null && this.P.tid != null && l2.longValue() == this.P.tid.longValue()) {
                                this.f55473e.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.P = null;
                }
                if ((!z4 || i2 == 0) && dataRes2 != null && E0(true, z2, z3, dataRes2)) {
                    u0();
                    if (this.f55471c != null) {
                        d.a.n0.r.d0.b j2 = d.a.n0.r.d0.b.j();
                        j2.w("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.f55471c.d(false);
                    }
                    this.A = true;
                    this.B = z2;
                    this.C = size;
                    b1();
                } else {
                    this.A = false;
                    if (this.f55472d.size() > 0) {
                        l0 l0Var2 = this.f55471c;
                        if (l0Var2 != null) {
                            l0Var2.onError(1, str);
                        }
                    } else {
                        l0 l0Var3 = this.f55471c;
                        if (l0Var3 != null) {
                            l0Var3.onError(2, str);
                        }
                    }
                }
                O0(false);
                if (this.l == null) {
                    f.i g02 = g0();
                    if (this.l.u() && g02 != null && !TbSingleton.getInstance().isBrowseMode()) {
                        this.l.z(g02);
                        return;
                    } else {
                        this.l.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z4 = false;
        DataRes.Builder builder22 = this.f55473e;
        if (builder22 != null) {
        }
        if (z2) {
        }
        if (this.P != null) {
        }
        if (!z4) {
        }
        u0();
        if (this.f55471c != null) {
        }
        this.A = true;
        this.B = z2;
        this.C = size;
        b1();
        O0(false);
        if (this.l == null) {
        }
    }
}
