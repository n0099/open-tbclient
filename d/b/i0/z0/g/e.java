package d.b.i0.z0.g;

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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.view.BdTopToast;
import com.squareup.wire.Wire;
import d.b.h0.r.f0.f;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.j1;
import d.b.h0.r.q.l1;
import d.b.h0.r.q.n0;
import d.b.i.u0.a;
import d.b.i0.f0.a;
import d.b.i0.p0.d1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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
    public d.b.h0.z0.a0 E;
    public View.OnTouchListener F;
    public d.b.i0.z0.g.j.h G;
    public BdUniqueId I;
    public SmartBubbleAnimatedView J;
    public HomePageYoungsterTopView K;
    public int L;

    /* renamed from: a  reason: collision with root package name */
    public final long f63051a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.i0.z0.g.b f63052b;
    public Runnable b0;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f63055e;
    public final TbPageContext<?> j;
    public final BdTypeRecyclerView k;
    public final BigdaySwipeRefreshLayout l;
    public final d.b.i0.z0.g.h.b0 m;
    public d1 o;
    public final d.b.i0.z0.g.k.a p;
    public d.b.i0.c3.h0.f q;
    public ScrollFragmentTabHost s;
    public d.b.i0.f0.a t;
    public d.b.i0.i2.i v;

    /* renamed from: c  reason: collision with root package name */
    public i0 f63053c = null;

    /* renamed from: d  reason: collision with root package name */
    public final List<d.b.b.j.e.n> f63054d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public int f63056f = 1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63057g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63058h = false;
    public int i = 0;
    public int n = 2000;
    public d.b.h0.m0.c r = null;
    public boolean u = false;
    public int w = 0;
    public int x = 0;
    public boolean y = false;
    public boolean z = true;
    public boolean A = false;
    public boolean D = false;
    public boolean H = true;
    public BdUniqueId M = BdUniqueId.gen();
    public a.C1117a N = new a.C1117a(2);
    public ThreadInfo O = null;
    public RecyclerView.OnScrollListener P = new v();
    public View.OnTouchListener Q = new c0();
    public a.b R = new d0();
    public final CustomMessageListener S = new e0(2001399);
    public final CustomMessageListener T = new f0(2921461);
    public final CustomMessageListener U = new g0(2921486);
    public CustomMessageListener V = new g(2004004);
    public CustomMessageListener W = new h(2921026);
    public CustomMessageListener X = new i(2001115);
    public CustomMessageListener Y = new j(0);
    public String Z = "lastReadReadPositionKey";
    public int a0 = 0;
    public d.b.i0.z0.g.d c0 = new o();
    public CustomMessageListener d0 = new r(2016569);
    public CustomMessageListener e0 = new s(2016488);
    public CustomMessageListener f0 = new t(2016553);
    public CustomMessageListener g0 = new u(2016331);
    public CustomMessageListener h0 = new w(2921381);
    public d.b.b.c.g.a i0 = new x(CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
    public CustomMessageListener j0 = new y(2921414);
    public CustomMessageListener k0 = new z(2921453);
    public final d.b.b.c.g.a l0 = new a0(CmdConfigHttp.CMD_GET_MY_POST, 303111);
    public CustomMessageListener m0 = new b0(2921482);

    /* loaded from: classes4.dex */
    public class a implements MessageQueue.IdleHandler {
        public a() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            e.this.s0();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends d.b.b.c.g.a {
        public a0(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
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
            e.this.O = threadInfo;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.h0.z0.f0<DataRes> {
        public b(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            byte[] bArr;
            d.b.b.e.d.l<byte[]> e2 = d.b.h0.r.r.a.f().e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
    public class b0 extends CustomMessageListener {
        public b0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.b.h0.s.h.a.e(TbadkCoreApplication.getInst(), 1)) {
                d.b.h0.s.h.a.g(e.this.j, 7, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.h0.z0.n<DataRes> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            e.this.v0(dataRes);
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements View.OnTouchListener {
        public c0() {
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
    public class d extends d.b.h0.z0.f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f63064a;

        public d(DataRes.Builder builder) {
            this.f63064a = builder;
        }

        @Override // d.b.h0.z0.f0
        public Object doInBackground() {
            DataRes.Builder builder = new DataRes.Builder(this.f63064a.build(true));
            e.this.f63052b.g(builder.thread_list);
            try {
                d.b.h0.r.r.a.f().e("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements a.b {
        public d0() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            e.this.u = false;
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            e.this.u = true;
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    /* renamed from: d.b.i0.z0.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1700e extends d.b.h0.z0.f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f63067a;

        public C1700e(DataRes.Builder builder) {
            this.f63067a = builder;
        }

        @Override // d.b.h0.z0.f0
        public Object doInBackground() {
            DataRes.Builder builder = new DataRes.Builder(this.f63067a.build(true));
            e.this.f63052b.g(builder.thread_list);
            try {
                d.b.h0.r.r.a.f().e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 extends CustomMessageListener {
        public e0(int i) {
            super(i);
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
    public class f implements HomePageYoungsterTopView.b {
        public f() {
        }

        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.b
        public void a() {
            BdTopToast bdTopToast = new BdTopToast(e.this.j.getPageActivity(), 2000);
            bdTopToast.i(true);
            bdTopToast.h(e.this.j.getPageActivity().getString(R.string.youngster_frs_top_toast));
            bdTopToast.j((ViewGroup) e.this.j.getPageActivity().findViewById(R.id.maintabContainer));
            e.this.W0(false);
            d.b.h0.r.d0.b.i().s("key_youngster_homgpage_top_view_closed", true);
        }
    }

    /* loaded from: classes4.dex */
    public class f0 extends CustomMessageListener {
        public f0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.k != null) {
                e.this.Z();
            }
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
            a2 a2Var;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a2) || e.this.f63055e == null || ListUtils.getCount(e.this.f63055e.thread_list) == 0 || (a2Var = (a2) customResponsedMessage.getData()) == null || a2Var.P0() == null || a2Var.o0() == null || ListUtils.getCount(e.this.f63055e.thread_list) == 0) {
                return;
            }
            for (int i = 0; i < e.this.f63055e.thread_list.size(); i++) {
                ThreadInfo threadInfo = e.this.f63055e.thread_list.get(i);
                if (threadInfo != null && threadInfo.id.longValue() == d.b.b.e.m.b.f(a2Var.o0(), -1L)) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    Zan.Builder builder2 = new Zan.Builder(builder.zan);
                    builder2.num = Integer.valueOf((int) a2Var.P0().getNum());
                    builder.zan = builder2.build(true);
                    e.this.f63055e.thread_list.set(i, builder.build(true));
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g0 extends CustomMessageListener {
        public g0(int i) {
            super(i);
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
                e.this.W0(true);
            } else if (intValue == 3) {
                BdTopToast bdTopToast2 = new BdTopToast(e.this.j.getPageActivity(), 2000);
                bdTopToast2.i(true);
                bdTopToast2.h(e.this.j.getPageActivity().getString(R.string.youngster_close_title));
                bdTopToast2.j((ViewGroup) e.this.j.getPageActivity().findViewById(R.id.maintabContainer));
                e.this.W0(false);
            } else if (intValue != 5) {
                if (d.b.h0.c1.b.c.d()) {
                    e.this.W0(true);
                }
            } else {
                BdTopToast bdTopToast3 = new BdTopToast(e.this.j.getPageActivity(), 2000);
                bdTopToast3.i(true);
                bdTopToast3.h(e.this.j.getPageActivity().getString(R.string.youngster_reset_title));
                bdTopToast3.j((ViewGroup) e.this.j.getPageActivity().findViewById(R.id.maintabContainer));
                e.this.W0(true);
            }
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
            a2 a2Var;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (ListUtils.isEmpty(e.this.f63054d) || ListUtils.isEmpty(ids) || ListUtils.isEmpty(originData)) {
                    return;
                }
                for (int i = 0; i < originData.size(); i++) {
                    if ((originData.get(i) instanceof a2) && (a2Var = (a2) originData.get(i)) != null && a2Var.q1() != null && ids.contains(Long.valueOf(a2Var.q1().live_id))) {
                        e.this.f63054d.remove(a2Var);
                    }
                }
                if (e.this.m != null) {
                    e.this.m.z(new ArrayList(e.this.f63054d));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements CustomMessageTask.CustomRunnable<Boolean> {
        public h0() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            ThreadCardViewHolder c0 = e.this.c0();
            if (c0 != null && c0.b() != null) {
                return new CustomResponsedMessage<>(2016323, Boolean.valueOf(c0.b().o(new a.C1117a(6))));
            }
            return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            User user;
            int intValue;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || e.this.f63055e == null || ListUtils.isEmpty(e.this.f63055e.thread_list)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f13694c)) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= e.this.f63055e.thread_list.size()) {
                    break;
                }
                ThreadInfo threadInfo = e.this.f63055e.thread_list.get(i);
                if (threadInfo == null || (user = threadInfo.author) == null || user.id.longValue() != d.b.b.e.m.b.f(updateAttentionMessage.getData().f13694c, -1L)) {
                    i++;
                } else {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    User.Builder builder2 = new User.Builder(builder.author);
                    builder2.is_like = Integer.valueOf(updateAttentionMessage.getData().f13695d ? 1 : 0);
                    builder2.has_concerned = Integer.valueOf(updateAttentionMessage.getData().f13695d ? 1 : 0);
                    GodInfo.Builder builder3 = new GodInfo.Builder(builder2.god_data);
                    if (updateAttentionMessage.getData().f13695d) {
                        intValue = builder2.fans_num.intValue() + 1;
                        builder3.followed = 1;
                    } else {
                        builder3.followed = 0;
                        intValue = builder2.fans_num.intValue() - 1;
                    }
                    builder2.fans_num = Integer.valueOf(intValue);
                    builder2.god_data = builder3.build(true);
                    builder.author = builder2.build(true);
                    e.this.f63055e.thread_list.set(i, builder.build(true));
                }
            }
            e.this.a1(updateAttentionMessage);
        }
    }

    /* loaded from: classes4.dex */
    public interface i0 {
        void a(int i, d.b.h0.z0.c cVar, int i2);

        void b(int i, int i2, d.b.h0.z0.c cVar, int i3);

        void c();

        void d(boolean z);

        void onError(int i, String str);
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || e.this.f63055e == null || e.this.f63055e.hot_recomforum == null || ListUtils.isEmpty(e.this.f63055e.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(e.this.f63055e.hot_recomforum);
            if (d.b.i0.z0.b.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                e.this.f63055e.hot_recomforum = builder.build(true);
                e.this.E0(new DataRes.Builder(e.this.f63055e.build(true)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ScrollFragmentTabHost.r {
        public k() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.r
        public void a(int i) {
            if (e.this.s.w(i) == 1 || e.this.o == null) {
                return;
            }
            e.this.o.d();
        }
    }

    /* loaded from: classes4.dex */
    public class l extends d.b.h0.z0.f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f63079a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f63080b;

        public l(String str, boolean z) {
            this.f63079a = str;
            this.f63080b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Boolean doInBackground() {
            int intValue;
            try {
                d.b.b.e.d.l<byte[]> e2 = d.b.h0.r.r.a.f().e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (e2 == null) {
                    return Boolean.FALSE;
                }
                byte[] bArr = e2.get("0");
                if (bArr != null && bArr.length != 0) {
                    DataRes.Builder builder = new DataRes.Builder((DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class));
                    if (builder.thread_list != null && builder.thread_list.size() > 0) {
                        for (int i = 0; i < builder.thread_list.size(); i++) {
                            ThreadInfo threadInfo = builder.thread_list.get(i);
                            if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == d.b.b.e.m.b.f(this.f63079a, -1L)) {
                                ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                                User.Builder builder3 = new User.Builder(builder2.author);
                                builder3.is_like = Integer.valueOf(this.f63080b ? 1 : 0);
                                builder3.has_concerned = Integer.valueOf(this.f63080b ? 1 : 0);
                                GodInfo.Builder builder4 = new GodInfo.Builder(builder3.god_data);
                                if (this.f63080b) {
                                    intValue = builder3.fans_num.intValue() + 1;
                                    builder4.followed = 1;
                                } else {
                                    intValue = builder3.fans_num.intValue() - 1;
                                    builder4.followed = 0;
                                }
                                builder3.fans_num = Integer.valueOf(intValue);
                                builder3.god_data = builder4.build(true);
                                builder2.author = builder3.build(true);
                                builder.thread_list.set(i, builder2.build(true));
                            }
                        }
                        DataRes.Builder builder5 = new DataRes.Builder(builder.build(true));
                        e.this.f63052b.g(builder5.thread_list);
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
    public class m implements d.b.h0.z0.n<Boolean> {
        public m(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
        }
    }

    /* loaded from: classes4.dex */
    public class n extends d.b.h0.z0.f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f63082a;

        public n(int i) {
            this.f63082a = i;
        }

        @Override // d.b.h0.z0.f0
        public Object doInBackground() {
            d.b.b.e.d.l<String> h2 = d.b.h0.r.r.a.f().h(e.this.Z, TbadkCoreApplication.getCurrentAccount());
            if (h2 != null) {
                h2.e(e.this.Z, Integer.toString(this.f63082a), 43200000L);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements d.b.i0.z0.g.d {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f63085e;

            public a(int i) {
                this.f63085e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.k.getHandler() == null) {
                    return;
                }
                e.this.k.requestFocusFromTouch();
                if (this.f63085e > e.this.k.getCount() - 1) {
                    return;
                }
                e.this.k.setSelection(this.f63085e);
            }
        }

        public o() {
        }

        @Override // d.b.i0.z0.g.d
        public void a(int i) {
            if (e.this.b0 == null) {
                e.this.b0 = new a(i);
            }
            e.this.k.removeCallbacks(e.this.b0);
            e.this.k.post(e.this.b0);
        }
    }

    /* loaded from: classes4.dex */
    public class p extends d.b.h0.z0.f0<String> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public String doInBackground() {
            d.b.b.e.d.l<String> h2 = d.b.h0.r.r.a.f().h(e.this.Z, TbadkCoreApplication.getCurrentAccount());
            if (h2 != null) {
                return h2.get(e.this.Z);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements d.b.h0.z0.n<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.z0.g.d f63088a;

        public q(e eVar, d.b.i0.z0.g.d dVar) {
            this.f63088a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            d.b.i0.z0.g.d dVar = this.f63088a;
            if (dVar != null) {
                dVar.a(d.b.b.e.m.b.d(str, 0));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends CustomMessageListener {
        public r(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || e.this.G == null) {
                return;
            }
            TbSingleton.getInstance().isAddBanner = false;
            e.this.f63054d.remove(e.this.G);
            e.this.m.z(new ArrayList(e.this.f63054d));
            d.b.h0.r.d0.b.i().v("key_maintab_banner_close_time", System.currentTimeMillis());
        }
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public s(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.a0(customResponsedMessage);
            if (e.this.v == null || !e.this.z) {
                return;
            }
            e.this.v.n(e.this.w, e.this.x, e.this.u, true);
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public t(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.a0(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class u extends CustomMessageListener {
        public u(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || e.this.f63055e == null || ListUtils.getCount(e.this.f63055e.thread_list) == 0) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            e eVar = e.this;
            eVar.X(str, eVar.f63054d);
            e.this.Y0(str);
            if (e.this.m != null) {
                e.this.m.z(new ArrayList(e.this.f63054d));
            }
            if (e.this.v == null || !e.this.z) {
                return;
            }
            e.this.v.n(e.this.w, e.this.x, e.this.u, true);
        }
    }

    /* loaded from: classes4.dex */
    public class v extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f63093a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f63094b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f63095c = false;

        public v() {
        }

        public void a(int i, int i2) {
            if (this.f63094b > i) {
                this.f63095c = true;
            }
            if (e.this.E != null && !e.this.y) {
                e.this.E.a(this.f63094b, i);
                throw null;
            }
            this.f63094b = i;
            int i3 = (i2 + i) - 1;
            if (!this.f63095c && this.f63093a != i3) {
                this.f63093a = i3;
                e.this.z0(i3);
            }
            if (this.f63095c && this.f63093a != i) {
                this.f63093a = i;
                e.this.z0(i);
            }
            e.this.a0 = i;
            e.this.w = i;
            e.this.x = i3;
            ThreadCardViewHolder c0 = e.this.c0();
            if (c0 == null || c0.b() == null) {
                return;
            }
            c0.b().o(e.this.N);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.r == null) {
                e.this.r = new d.b.h0.m0.c();
                e.this.r.a(1005);
                e.this.r.f50310e = 1;
            }
            if (e.this.E != null && !e.this.y) {
                e.this.E.b(recyclerView, i);
                throw null;
            } else if (i == 0) {
                d.b.i0.z0.g.c.b(e.this.k);
                e.this.r.e();
                d.b.i0.x.t.b().d(true);
                d.b.i0.m.d.c().h("page_recommend", "show_");
                d.b.i0.b3.c.g().h(e.this.I, false);
                this.f63095c = false;
                if (e.this.v == null || !e.this.z || e.this.y) {
                    return;
                }
                e.this.v.m(e.this.w, e.this.x, e.this.u, 1);
            } else {
                e.this.r.d();
                if (i == 1) {
                    if (e.this.o != null) {
                        e.this.o.d();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
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
    public class w extends CustomMessageListener {
        public w(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder c0;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof KeyEvent)) {
                return;
            }
            KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (c0 = e.this.c0()) == null || c0.b() == null) {
                return;
            }
            c0.b().o(new a.C1117a(3));
        }
    }

    /* loaded from: classes4.dex */
    public class x extends d.b.b.c.g.a {
        public x(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            d.b.i0.z0.j.b.c.b bVar;
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
            for (d.b.b.j.e.n nVar : e.this.f63054d) {
                if ((nVar instanceof d.b.i0.z0.j.b.c.a) && (bVar = ((d.b.i0.z0.j.b.c.a) nVar).Y) != null && j2 == bVar.f63353b) {
                    bVar.f63354c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y extends CustomMessageListener {

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

        public y(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a2 a2Var;
            List<d.b.b.j.e.n> h2 = e.this.m.h();
            if (!ListUtils.isEmpty(h2)) {
                for (d.b.b.j.e.n nVar : h2) {
                    if (nVar instanceof d.b.i0.x.e0.k) {
                        d.b.i0.x.e0.k kVar = (d.b.i0.x.e0.k) nVar;
                        if (kVar.o != 0 && (a2Var = kVar.f62196e) != null) {
                            int[] p0 = a2Var.p0();
                            kVar.o = p0[0];
                            kVar.p = p0[1];
                        }
                    }
                }
            }
            d.b.b.e.m.e.a().postDelayed(new a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class z extends CustomMessageListener {
        public z(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof j1)) {
                return;
            }
            j1 j1Var = (j1) customResponsedMessage.getData();
            if (j1Var.f50822a != 1) {
                return;
            }
            int k = d.b.b.e.p.l.k(TbadkCoreApplication.getInst());
            int i = d.b.b.e.p.l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(e.this.M);
            requestGetMyPostNetMessage.setParams(d.b.b.e.m.b.f(j1Var.f50824c, 0L), 0L, 0L, k, i, f2, i2);
            requestGetMyPostNetMessage.setBFrom("push");
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, d.b.i0.z0.g.h.b0 b0Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.L = 0;
        this.j = tbPageContext;
        this.L = d.b.h0.r.d0.b.i().j("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.Q);
        if (d.b.h0.c1.b.c.d()) {
            W0(true);
        }
        d.b.i0.f0.a aVar = new d.b.i0.f0.a();
        this.t = aVar;
        aVar.d(this.R);
        this.m = b0Var;
        this.p = new d.b.i0.z0.g.k.a();
        this.f63051a = d.b.h0.r.d0.b.i().k("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.P);
        this.o = new d1();
        i0();
        d.b.i0.i2.i iVar = new d.b.i0.i2.i(this.j, this.k);
        this.v = iVar;
        iVar.p(1);
        this.v.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f63052b = new d.b.i0.z0.g.b(this.f63054d, this.m);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.J = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, d.b.b.e.p.l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        I0();
        this.j0.setTag(this.j.getUniqueId());
        MessageManager.getInstance().registerListener(this.j0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.l0.setTag(this.M);
        if (this.l0.getHttpMessageListener() != null) {
            this.l0.getHttpMessageListener().setSelfListener(true);
        }
        if (this.l0.getSocketMessageListener() != null) {
            this.l0.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.l0);
        MessageManager.getInstance().registerListener(this.k0);
        MessageManager.getInstance().registerListener(this.m0);
    }

    public void A0() {
        d.b.i0.z0.g.c.b(this.k);
        S(this.a0);
        d.b.h0.m0.c cVar = this.r;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void B0(boolean z2) {
        if (z2) {
            this.m.m();
        }
    }

    public final void C0() {
        if (ListUtils.getCount(this.f63054d) < this.p.e() - 40) {
            return;
        }
        List<d.b.b.j.e.n> list = null;
        d.b.i0.z0.g.k.c c2 = this.p.c(true, this.f63055e, null, 1);
        int i2 = 0;
        if (c2 != null) {
            list = c2.f63210a;
            int i3 = c2.f63212c;
            c2.f63212c = 0;
            i2 = i3;
        }
        if (list != null) {
            this.f63054d.clear();
            this.f63054d.addAll(list);
            this.m.A(new LinkedList(this.f63054d), i2);
        }
    }

    public final boolean D0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        List<d.b.b.j.e.n> list;
        int i2;
        BlockPopInfo blockPopInfo;
        boolean z5 = false;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.L == 1) {
            if (z3 && (dataRes.thread_list.size() >= 6 || j0())) {
                K0();
                this.f63055e = null;
            }
        } else if (z3 && j0()) {
            this.f63055e = null;
        }
        int size = z3 ? 0 : this.f63054d.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.f63054d.clear();
        d.b.i0.z0.g.k.c c2 = this.p.c(z2, this.f63055e, builder, !z3 ? 1 : 0);
        if (c2 != null) {
            list = c2.f63210a;
            this.i = c2.f63211b;
            i2 = c2.f63212c;
            c2.f63212c = 0;
        } else {
            list = null;
            i2 = 0;
        }
        if (list != null) {
            this.f63054d.addAll(list);
            Q(list, size);
            J0(!z3 ? 1 : 0, list, size);
            if (this.D) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.f63055e == null) {
            this.f63055e = builder;
            this.f63052b.j(builder.thread_list);
        }
        if (this.f63054d.size() != 0) {
            if (z3) {
                if (dataRes.live_answer != null) {
                    d.b.i0.z0.g.j.h hVar = new d.b.i0.z0.g.j.h();
                    this.G = hVar;
                    hVar.g(dataRes.live_answer);
                    this.f63055e.live_answer = dataRes.live_answer;
                } else if (z2) {
                    this.G = null;
                    this.f63055e.live_answer = null;
                }
                this.f63055e.float_info = dataRes.float_info;
            }
            long k2 = d.b.h0.r.d0.b.i().k("key_maintab_banner_close_time", 0L);
            if (this.G != null && !StringHelper.isTaday(k2)) {
                TbSingleton.getInstance().isAddBanner = true;
                this.f63054d.add(0, this.G);
            }
            LinkedList linkedList = new LinkedList(this.f63054d);
            d.b.i0.z0.g.h.b0 b0Var = this.m;
            Integer num = dataRes.is_new_url;
            if (num != null && num.intValue() == 1) {
                z5 = true;
            }
            b0Var.t(z5);
            this.m.A(linkedList, i2);
            d.b.i0.i2.i iVar = this.v;
            if (iVar != null && this.z) {
                iVar.n(this.w, this.x, this.u, true);
            }
            z5 = true;
        }
        d.b.i0.z0.c.a.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
        long e2 = d.b.i0.z0.c.a.d().e(1);
        if (e2 > 0) {
            d.b.i0.z0.c.a.d().k(System.currentTimeMillis() - e2, 1);
            d.b.i0.z0.c.a.d().j(0L, 1);
        }
        Anti anti = dataRes.anti;
        if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
            d.b.i0.k3.d.g(blockPopInfo);
        }
        l1 l1Var = new l1();
        l1Var.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, l1Var));
        if (!z2 && e2 > 0) {
            d.b.h0.m0.l.b().H(System.currentTimeMillis() - e2);
        }
        return z5;
    }

    public final void E0(DataRes.Builder builder) {
        d.b.h0.z0.h0.b(new C1700e(builder), null);
    }

    public void F0(int i2, int i3) {
        a2 a2Var;
        if (ListUtils.isEmpty(this.f63054d) || this.f63054d.size() <= i2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (i2 < this.f63054d.size() && i2 <= i3) {
            if (this.f63054d.get(i2).getType().getId() == a2.f3.getId() && (a2Var = (a2) this.f63054d.get(i2)) != null && a2Var.q1() != null) {
                arrayList.add(Long.valueOf(a2Var.q1().live_id));
                arrayList2.add(a2Var);
            }
            i2++;
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
    }

    public void G0() {
        d.b.i0.i2.i iVar = this.v;
        if (iVar != null && !this.y && this.z) {
            iVar.n(this.w, this.x, this.u, true);
        }
        if (this.A) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
            if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.u()) {
                boolean z2 = this.B;
                if (z2) {
                    d.b.i0.b3.c.g().h(this.I, false);
                    if (k0(false)) {
                        V0(3, this.i);
                    } else if (this.C > 0) {
                        V0(2, this.i);
                    }
                } else if (!z2 && this.i == 0) {
                    V0(2, 0);
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

    public void H0(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.I = bdUniqueId;
        CustomMessageListener customMessageListener = this.V;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
        }
        CustomMessageListener customMessageListener2 = this.S;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.S);
        }
        this.T.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.T);
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.Y);
        MessageManager.getInstance().registerListener(2001336, this.Y);
        this.W.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.W);
        this.e0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.e0);
        this.f0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f0);
        this.g0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g0);
        d.b.i0.i2.i iVar = this.v;
        if (iVar != null) {
            iVar.t(bdUniqueId);
        }
        this.f63052b.i(bdUniqueId);
        this.d0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.d0);
        this.h0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.h0);
        this.i0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i0);
        this.U.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.U);
    }

    public final void I0() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new h0());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void J0(int i2, List<d.b.b.j.e.n> list, int i3) {
        int i4;
        d.b.i0.c3.h0.f fVar = this.q;
        if (fVar == null) {
            return;
        }
        if (i2 == 0) {
            fVar.d();
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        int[] iArr = d.b.i0.c3.h0.f.f53379e;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
            if ((list.get(i7) instanceof d.b.i0.x.e0.b) && (i6 = i6 + 1) == i4 - 1) {
                int i8 = i7 + 1;
                if (i3 < i8) {
                    this.q.a(i4, i8);
                }
                i5++;
            }
        }
    }

    public final void K0() {
        DataRes.Builder builder = this.f63055e;
        if (builder == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 50) {
            builder2.thread_list = builder2.thread_list.subList(0, 50);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        U(builder2, list2 != null ? list2.size() : 0);
        d.b.h0.z0.h0.b(new d(builder2), null);
    }

    public void L0() {
        d.b.i0.z0.g.c.c(this.k);
    }

    public void M0(boolean z2) {
        this.H = z2;
        d1 d1Var = this.o;
        if (d1Var == null || z2) {
            return;
        }
        d1Var.d();
    }

    public final void N0(boolean z2) {
        this.f63057g = z2;
    }

    public void O0(i0 i0Var) {
        this.f63053c = i0Var;
    }

    public void P0(boolean z2) {
        this.z = z2;
    }

    public final void Q(List<d.b.b.j.e.n> list, int i2) {
        Set<d.b.b.j.e.n> a2 = d.b.i0.r2.a.a(list, this.f63056f, "NEWINDEX");
        if (a2.size() > 0) {
            d.b.i0.b3.c.g().c(this.I, d.b.i0.b3.a.h("a002", "common_fill", true, a2.size()));
        }
    }

    public void Q0(d.b.h0.z0.b0 b0Var) {
        if (b0Var == null) {
            return;
        }
        b0Var.a();
        throw null;
    }

    public final d.b.h0.z0.c R(boolean z2) {
        String e2 = d.b.i0.r2.a.e(this.f63054d, z2);
        int T = T(z2);
        d.b.h0.z0.c cVar = new d.b.h0.z0.c();
        cVar.f51657b = e2;
        cVar.f51656a = T;
        return cVar;
    }

    public void R0(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.s = scrollFragmentTabHost;
        if (scrollFragmentTabHost == null) {
            return;
        }
        scrollFragmentTabHost.setOnTabSelectedListener(new k());
    }

    public void S(int i2) {
        d.b.h0.z0.h0.b(new n(i2), null);
    }

    public void S0(boolean z2) {
        this.y = z2;
    }

    public int T(boolean z2) {
        int i2;
        int i3;
        List<d.b.b.j.e.n> list = this.f63054d;
        int i4 = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i5 = -1;
        if (z2) {
            int i6 = 0;
            while (i4 < this.f63054d.size()) {
                d.b.b.j.e.n nVar = this.f63054d.get(i4);
                if ((nVar instanceof d.b.i0.x.e0.b) && (i3 = ((d.b.i0.x.e0.b) nVar).position) != i5) {
                    i6++;
                    i5 = i3;
                }
                if ((nVar instanceof d.b.i0.z0.g.j.a) && nVar.getType() != AdvertAppInfo.j4) {
                    return i6;
                }
                i4++;
            }
        } else {
            for (int size = this.f63054d.size() - 1; size >= 0; size--) {
                d.b.b.j.e.n nVar2 = this.f63054d.get(size);
                if ((nVar2 instanceof d.b.i0.x.e0.b) && (i2 = ((d.b.i0.x.e0.b) nVar2).position) != i5) {
                    i4++;
                    i5 = i2;
                }
                if ((nVar2 instanceof d.b.i0.z0.g.j.a) && nVar2.getType() != AdvertAppInfo.j4) {
                    return i4;
                }
            }
        }
        return this.f63054d.size();
    }

    public void T0() {
        d.b.h0.s.c.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (!activityPrizeData.g() || StringUtils.isNull(activityPrizeData.b())) {
            return;
        }
        String currentDay = UtilHelper.getCurrentDay();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        String str = "";
        String o2 = d.b.h0.r.d0.b.i().o("activity_prize_feed_text_time", "");
        boolean z2 = true;
        if (!StringUtils.isNull(o2)) {
            String[] split = o2.split("@");
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
            V0(4, 0);
            d.b.h0.r.d0.b.i().w("activity_prize_feed_text_time", str);
        }
    }

    public final void U(DataRes.Builder builder, int i2) {
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
                int d2 = d.b.b.e.m.b.d(next.pos_name, -1);
                if (d2 < 0) {
                    it.remove();
                } else if (d2 < i2 + i3 + 1) {
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

    public void U0() {
        d.b.h0.z0.a0 a0Var = this.E;
        if (a0Var == null) {
            return;
        }
        a0Var.c(true);
        throw null;
    }

    public final void V(DataRes.Builder builder) {
        builder.user_follow_live = null;
    }

    public final void V0(int i2, int i3) {
        if (n0()) {
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
            if (TextUtils.isEmpty(str) || !d.b.b.e.p.j.z()) {
                return;
            }
            if (i2 == 4) {
                this.n = 3000;
            } else {
                this.n = 2000;
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.J;
            smartBubbleAnimatedView.f16109e = str;
            smartBubbleAnimatedView.f16110f = this.n;
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

    public final void W(DataRes.Builder builder) {
        builder.active_center = null;
    }

    public final void W0(boolean z2) {
        boolean g2 = d.b.h0.r.d0.b.i().g("key_youngster_homgpage_top_view_closed", false);
        if (this.k == null || g2) {
            return;
        }
        if (z2) {
            if (this.K == null) {
                HomePageYoungsterTopView homePageYoungsterTopView = new HomePageYoungsterTopView(this.j);
                this.K = homePageYoungsterTopView;
                homePageYoungsterTopView.setOnDeleteClick(new f());
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

    public final void X(String str, List<d.b.b.j.e.n> list) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<d.b.b.j.e.n> it = list.iterator();
        while (true) {
            AdvertAppInfo advertAppInfo = null;
            while (it.hasNext()) {
                d.b.b.j.e.n next = it.next();
                if (next instanceof d.b.i0.z0.g.j.a) {
                    advertAppInfo = ((d.b.i0.z0.g.j.a) next).g();
                } else if (next instanceof n0) {
                    n0 n0Var = (n0) next;
                    if (n0Var.g() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) n0Var.g()).getAdvertAppInfo();
                    }
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.E3)) {
                }
            }
            return;
            it.remove();
        }
    }

    public void X0() {
        d.b.i0.z0.c.a.d().j(System.currentTimeMillis(), 1);
        this.f63056f = 1;
        this.D = true;
        if (this.f63054d.size() == 0 && !l0()) {
            if (this.f63058h) {
                return;
            }
            p0();
            return;
        }
        q0();
    }

    public void Y(Long l2) {
        List<ThreadInfo> list;
        DataRes.Builder builder = this.f63055e;
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
                Z0();
                D0(false, true, false, this.f63055e.build(true));
                return;
            }
        }
    }

    public final void Y0(String str) {
        DataRes.Builder builder;
        BannerList bannerList;
        List<App> list;
        if (TextUtils.isEmpty(str) || (builder = this.f63055e) == null || (bannerList = builder.banner_list) == null || (list = bannerList.app) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (App app : this.f63055e.banner_list.app) {
            if (app != null && str.equals(app.id)) {
                arrayList.add(app);
            }
        }
        BannerList.Builder builder2 = new BannerList.Builder(this.f63055e.banner_list);
        List<App> list2 = builder2.app;
        if (list2 != null) {
            list2.removeAll(arrayList);
        }
        this.f63055e.banner_list = builder2.build(false);
        DataRes.Builder builder3 = new DataRes.Builder(this.f63055e.build(true));
        builder3.banner_list = builder2.build(true);
        E0(builder3);
    }

    public final void Z() {
        Iterator<d.b.b.j.e.n> it = this.f63054d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() instanceof d.b.i0.z0.g.j.g) {
                it.remove();
                break;
            }
        }
        DataRes.Builder builder = this.f63055e;
        if (builder == null) {
            return;
        }
        builder.active_center = null;
        Z0();
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            List<Integer> e02 = e0(bdTypeRecyclerView);
            int intValue = e02.get(0).intValue();
            int intValue2 = e02.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.k.E(intValue, intValue2);
        }
    }

    public final void Z0() {
        DataRes.Builder builder = this.f63055e;
        if (builder == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 30) {
            builder2.thread_list = builder2.thread_list.subList(0, 30);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        U(builder2, list2 != null ? list2.size() : 0);
        V(builder2);
        W(builder2);
        E0(builder2);
    }

    public final void a0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f63055e) == null || ListUtils.getCount(builder.thread_list) == 0 || ListUtils.getCount(this.f63054d) == 0) {
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
                d.b.b.j.e.n B = this.k.B(i2);
                if (B instanceof d.b.i0.x.e0.j) {
                    d.b.i0.x.e0.j jVar = (d.b.i0.x.e0.j) B;
                    if (jVar.n() != null && jVar.n().q1() != null && optString2.equals(String.valueOf(jVar.n().q1().live_id))) {
                        optString = jVar.n().w1();
                        break;
                    }
                }
                i2++;
            }
            if (StringUtils.isNull(optString)) {
                return;
            }
        }
        Iterator<d.b.b.j.e.n> it = this.f63054d.iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.b.b.j.e.n next = it.next();
            if (next instanceof d.b.i0.x.e0.b) {
                d.b.i0.x.e0.b bVar = (d.b.i0.x.e0.b) next;
                if (bVar.n() != null && bVar.n().w1() != null) {
                    if (bVar.n().w1().equals(optString)) {
                        it.remove();
                        z2 = true;
                    } else if (z2) {
                        d.b.i0.z0.g.k.b.b(this.f63054d);
                        break;
                    }
                }
            }
        }
        DataRes.Builder builder2 = this.f63055e;
        if (builder2 == null || builder2.thread_list == null) {
            return;
        }
        long f2 = d.b.b.e.m.b.f(optString, 0L);
        int i3 = 0;
        while (true) {
            if (i3 < this.f63055e.thread_list.size()) {
                ThreadInfo threadInfo = this.f63055e.thread_list.get(i3);
                if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == f2) {
                    d.b.i0.z0.g.l.c.d(threadInfo.tid.longValue(), i3, this.f63055e.thread_list, this.f63054d);
                    this.f63055e.thread_list.remove(i3);
                    Z0();
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            List<Integer> h02 = h0(optString, bdTypeRecyclerView);
            int intValue = h02.get(0).intValue();
            int intValue2 = h02.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.k.E(intValue, intValue2);
        }
    }

    public final void a1(UpdateAttentionMessage updateAttentionMessage) {
        if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f13694c)) {
            return;
        }
        d.b.h0.z0.h0.b(new l(updateAttentionMessage.getData().f13694c, updateAttentionMessage.getData().f13695d), new m(this));
    }

    public void b0(d.b.i0.z0.g.d dVar) {
        d.b.h0.z0.h0.b(new p(), new q(this, dVar));
    }

    public final ThreadCardViewHolder c0() {
        d.b.i0.i2.i iVar = this.v;
        if (iVar == null || iVar.j() == null || !(this.v.j().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.v.j().getTag();
    }

    public final String d0() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public final List<Integer> e0(BdTypeRecyclerView bdTypeRecyclerView) {
        ArrayList arrayList = new ArrayList(2);
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
            d.b.b.j.e.n B = bdTypeRecyclerView.B(i4);
            if (B instanceof d.b.i0.z0.g.j.g) {
                d.b.i0.z0.g.j.g gVar = (d.b.i0.z0.g.j.g) B;
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
    public final f.i f0() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        String b2;
        if (!this.A || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.u() || n0()) {
            return null;
        }
        int i2 = this.i;
        boolean z2 = this.B;
        if (z2) {
            d.b.i0.b3.c.g().h(this.I, false);
            if (k0(false)) {
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
                if (TextUtils.isEmpty(b2) || !d.b.b.e.p.j.z()) {
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

    public d.b.i0.i2.i g0() {
        return this.v;
    }

    public final List<Integer> h0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        ArrayList arrayList = new ArrayList(2);
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
            d.b.b.j.e.n B = bdTypeRecyclerView.B(i4);
            if (B instanceof d.b.i0.x.e0.b) {
                d.b.i0.x.e0.b bVar = (d.b.i0.x.e0.b) B;
                if (bVar.n() != null && bVar.n().w1().equals(str)) {
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

    public void i0() {
        d.b.i0.c3.h0.f fVar = new d.b.i0.c3.h0.f("new_index", null);
        this.q = fVar;
        fVar.d();
    }

    public final boolean j0() {
        return k0(true);
    }

    public final boolean k0(boolean z2) {
        d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
        long k2 = i2.k("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
        return k2 == 0 ? z2 : Math.abs(System.currentTimeMillis() - k2) > this.f63051a;
    }

    public final boolean l0() {
        return d.b.h0.r.d0.b.i().g(d0(), true);
    }

    public final boolean m0() {
        return this.f63057g;
    }

    public final boolean n0() {
        HomePageYoungsterTopView homePageYoungsterTopView = this.K;
        return homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0;
    }

    public void o0() {
        b0(this.c0);
    }

    public final void p0() {
        this.f63058h = true;
        d.b.h0.z0.h0.b(new b(this), new c());
    }

    public final void q0() {
        if (this.f63053c != null) {
            DataRes.Builder builder = this.f63055e;
            this.f63053c.a((builder == null || builder.thread_list == null || j0()) ? 0 : this.f63055e.thread_list.size(), R(true), 0);
        }
    }

    public void r0() {
        List<ThreadInfo> list;
        if (m0()) {
            d.b.i0.z0.c.a.d().j(0L, 1);
        } else if (this.f63053c != null) {
            C0();
            this.f63056f++;
            N0(true);
            DataRes.Builder builder = this.f63055e;
            this.f63053c.b(this.f63056f, (builder == null || (list = builder.thread_list) == null) ? 0 : list.size(), R(false), 0);
        }
    }

    public void s0() {
        d.b.h0.m0.l.b().q(System.currentTimeMillis() - d.b.h0.m0.l.b().c());
    }

    public final void t0() {
        d.b.h0.r.d0.b.i().s(d0(), false);
    }

    public void u0(boolean z2) {
        this.y = z2;
        ScrollFragmentTabHost scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.H(z2);
        }
        d.b.i0.i2.i iVar = this.v;
        if (iVar == null) {
            return;
        }
        iVar.q(!z2);
        ThreadCardViewHolder c02 = c0();
        boolean z3 = false;
        if (c02 != null && c02.b() != null) {
            z3 = c02.b().o(new a.C1117a(8, Boolean.valueOf(z2)));
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

    public final void v0(DataRes dataRes) {
        this.f63058h = true;
        if (dataRes != null) {
            if (D0(false, true, true, dataRes) && !j0()) {
                i0 i0Var = this.f63053c;
                if (i0Var != null) {
                    i0Var.d(true);
                    Looper.myQueue().addIdleHandler(new a());
                }
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    q0();
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                    return;
                }
                return;
            }
            q0();
            return;
        }
        q0();
    }

    public void w0(int i2) {
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.J;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i2);
        }
        HomePageYoungsterTopView homePageYoungsterTopView = this.K;
        if (homePageYoungsterTopView != null) {
            homePageYoungsterTopView.c();
        }
    }

    public void x0() {
        d.b.i0.i2.i iVar = this.v;
        if (iVar != null) {
            iVar.h();
        }
        d1 d1Var = this.o;
        if (d1Var != null) {
            d1Var.e();
        }
        d.b.i0.z0.g.b bVar = this.f63052b;
        if (bVar != null) {
            bVar.h();
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeCallbacks(this.b0);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.j0);
        MessageManager.getInstance().unRegisterListener(this.k0);
        MessageManager.getInstance().unRegisterListener(this.l0);
        MessageManager.getInstance().unRegisterListener(this.m0);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        int size;
        Long l2;
        List<ThreadInfo> list;
        DataRes dataRes2 = dataRes;
        if (z2) {
            d.b.i0.z0.g.g.a();
        }
        d.b.i0.z0.g.k.a aVar = this.p;
        if (aVar != null && aVar.h() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
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
                DataRes.Builder builder2 = this.f63055e;
                size = (builder2 != null || (list = builder2.thread_list) == null) ? 0 : list.size();
                if (z2 && i2 == 0 && dataRes2 != null && ListUtils.isEmpty(dataRes2.thread_list)) {
                    i0 i0Var = this.f63053c;
                    if (i0Var != null) {
                        i0Var.c();
                    }
                    N0(false);
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                    if (bigdaySwipeRefreshLayout != null) {
                        bigdaySwipeRefreshLayout.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.O != null) {
                    DataRes.Builder builder3 = new DataRes.Builder(dataRes2);
                    builder3.thread_list.add(0, this.O);
                    dataRes2 = builder3.build(false);
                    DataRes.Builder builder4 = this.f63055e;
                    if (builder4 != null && !ListUtils.isEmpty(builder4.thread_list)) {
                        Iterator<ThreadInfo> it = this.f63055e.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && (l2 = next.tid) != null && this.O.tid != null && l2.longValue() == this.O.tid.longValue()) {
                                this.f63055e.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.O = null;
                }
                if ((!z4 || i2 == 0) && dataRes2 != null && D0(true, z2, z3, dataRes2)) {
                    t0();
                    if (this.f63053c != null) {
                        d.b.h0.r.d0.b i3 = d.b.h0.r.d0.b.i();
                        i3.v("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.f63053c.d(false);
                    }
                    this.A = true;
                    this.B = z2;
                    this.C = size;
                    Z0();
                } else {
                    this.A = false;
                    if (this.f63054d.size() > 0) {
                        i0 i0Var2 = this.f63053c;
                        if (i0Var2 != null) {
                            i0Var2.onError(1, str);
                        }
                    } else {
                        i0 i0Var3 = this.f63053c;
                        if (i0Var3 != null) {
                            i0Var3.onError(2, str);
                        }
                    }
                }
                N0(false);
                if (this.l == null) {
                    f.i f02 = f0();
                    if (this.l.u() && f02 != null) {
                        this.l.z(f02);
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
        DataRes.Builder builder22 = this.f63055e;
        if (builder22 != null) {
        }
        if (z2) {
        }
        if (this.O != null) {
        }
        if (!z4) {
        }
        t0();
        if (this.f63053c != null) {
        }
        this.A = true;
        this.B = z2;
        this.C = size;
        Z0();
        N0(false);
        if (this.l == null) {
        }
    }

    public void z0(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        d.b.i0.c3.h0.f fVar = this.q;
        if ((fVar != null ? fVar.b(i2) : -1) >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
            this.q.c(i2);
        }
    }
}
