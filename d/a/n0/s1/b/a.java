package d.a.n0.s1.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.BubbleView;
import com.baidu.tieba.memberCenter.bubble.SetBubbleResultData;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.m0.w.y.a;
import d.a.n0.s1.a.c;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d.a.m0.w.y.a {
    public BubbleListModel q;
    public BubbleListData r;
    public Context s;
    public String u;
    public int t = 0;
    public BubbleListModel.c v = new b();
    public BubbleListModel.d w = new c();
    public CustomMessageListener x = new d(2010040);
    public View.OnClickListener y = new e();
    public c.e z = new f();
    public c.e A = new g();

    /* renamed from: d.a.n0.s1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1591a implements a.InterfaceC1170a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f60408a;

        public C1591a(Context context) {
            this.f60408a = context;
        }

        @Override // d.a.m0.w.y.a.InterfaceC1170a
        public View getView(int i2, View view, ViewGroup viewGroup) {
            BubbleView bubbleView;
            BubbleView bubbleView2;
            if (view == null) {
                bubbleView2 = new BubbleView(this.f60408a);
                bubbleView = bubbleView2;
            } else {
                bubbleView = view;
                bubbleView2 = (BubbleView) view;
            }
            BubbleListData.BubbleData P = a.this.P(i2);
            if (P != null) {
                bubbleView2.setData(P, BubbleListModel.u(a.this.r.getB_info()));
                bubbleView2.setGravity(17);
                bubbleView2.setTag(Integer.valueOf(i2));
                bubbleView2.setOnClickListener(a.this.y);
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            TbPageContext tbPageContext = (TbPageContext) j.a(a.this.s);
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().j(bubbleView);
            return bubbleView;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BubbleListModel.c {
        public b() {
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void a(BubbleListData bubbleListData) {
            a.this.r = null;
            if (bubbleListData == null) {
                UtilHelper.showToast(a.this.s, R.string.neterror);
            } else if (bubbleListData.getError_code().equals("0")) {
                UtilHelper.showToast(a.this.s, R.string.neterror);
            } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                UtilHelper.showToast(a.this.s, bubbleListData.getError_msg());
            } else {
                UtilHelper.showToast(a.this.s, R.string.neterror);
            }
            if (a.this.k() != null) {
                a.this.k().onLoadFail();
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            if (bubbleListData == null) {
                a.this.k().onLoadFail();
                return;
            }
            a.this.r = bubbleListData.m26clone();
            if (a.this.q.w() > 0) {
                List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
                if (b_info == null || b_info.size() == 0) {
                    return;
                }
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null && bubbleData.getBcode() == a.this.q.w()) {
                        if (!bubbleData.canUse() && !bubbleData.isFree()) {
                            break;
                        }
                        a.this.q.C(a.this.q.w());
                        a.this.q.B(a.this.q.w(), l.k(a.this.s), l.i(a.this.s));
                    }
                }
                a.this.q.D(-1);
            }
            a.this.Q();
            a.this.k().b(a.this);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BubbleListModel.d {
        public c() {
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void a(SetBubbleResultData setBubbleResultData) {
            if (setBubbleResultData != null && setBubbleResultData.getB_info() != null) {
                a.this.u = setBubbleResultData.getB_info().getB_url();
                TbadkCoreApplication.getInst().setDefaultBubble(a.this.u);
                int v = a.this.q.v();
                if (v == 0) {
                    TbadkCoreApplication.getInst().setDefaultBubble("");
                    for (BubbleListData.BubbleData bubbleData : a.this.r.getB_info()) {
                        if (bubbleData.getBcode() != 0) {
                            if (bubbleData.isDef()) {
                                bubbleData.setIs_def(0);
                            }
                        } else {
                            bubbleData.setIs_def(1);
                        }
                    }
                } else if (setBubbleResultData.getB_info().canUser()) {
                    for (BubbleListData.BubbleData bubbleData2 : a.this.r.getB_info()) {
                        if (bubbleData2.getBcode() == v) {
                            bubbleData2.setIs_def(1);
                        } else if (bubbleData2.isDef()) {
                            bubbleData2.setIs_def(0);
                        }
                        if (bubbleData2.getBcode() == v) {
                            bubbleData2.setCan_use(1);
                        }
                    }
                } else {
                    UtilHelper.showToast(a.this.s, R.string.setdefualt_error);
                    if (a.this.r != null && a.this.r.getB_info() != null && a.this.r.getB_info().size() > 0) {
                        if (a.this.r.getB_info().get(0).getBcode() == 0) {
                            a.this.t = 0;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= a.this.r.getB_info().size()) {
                                    break;
                                } else if (a.this.r.getB_info().get(i2).isDef()) {
                                    a.this.t = i2;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            a.this.r.getB_info().get(a.this.t).setIs_def(0);
                            a.this.r.getB_info().get(0).setIs_def(1);
                        } else {
                            BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                            bubbleData3.setBcode(0);
                            a.this.r.getB_info().add(0, bubbleData3);
                        }
                    }
                }
                a.this.Q();
                a.this.k().b(a.this);
                return;
            }
            a.this.k().onLoadFail();
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void b(SetBubbleResultData setBubbleResultData) {
            if (setBubbleResultData != null) {
                if (setBubbleResultData.getError_code().equals("0")) {
                    UtilHelper.showToast(a.this.s, R.string.neterror);
                } else if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                    UtilHelper.showToast(a.this.s, setBubbleResultData.getError_msg());
                } else {
                    UtilHelper.showToast(a.this.s, R.string.neterror);
                }
            } else {
                UtilHelper.showToast(a.this.s, R.string.neterror);
            }
            if (a.this.k() != null) {
                a.this.k().onLoadFail();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.q.A(0, 50, 0, 0);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.r != null && (view instanceof BubbleView)) {
                BubbleListData.BubbleData bubbleData = (BubbleListData.BubbleData) ListUtils.getItem(a.this.r.getB_info(), ((Integer) view.getTag()).intValue());
                TbadkSettings inst = TbadkSettings.getInst();
                boolean loadBoolean = inst.loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
                if (bubbleData == null || bubbleData.isDef()) {
                    return;
                }
                if (bubbleData.getBcode() == 0 || bubbleData.canUse() || loadBoolean) {
                    a.this.R(bubbleData.getBcode());
                } else if (bubbleData.isFree()) {
                    if (a.this.s instanceof TbPageContextSupport) {
                        d.a.n0.s1.a.c.a(((TbPageContextSupport) a.this.s).getPageContext(), bubbleData, a.this.z);
                    }
                } else if (a.this.s instanceof TbPageContextSupport) {
                    d.a.n0.s1.a.c.b(((TbPageContextSupport) a.this.s).getPageContext(), bubbleData, a.this.A);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements c.e {
        public f() {
        }

        @Override // d.a.n0.s1.a.c.e
        public void a(int i2) {
            a.this.R(i2);
        }

        @Override // d.a.n0.s1.a.c.e
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements c.e {
        public g() {
        }

        @Override // d.a.n0.s1.a.c.e
        public void a(int i2) {
            a.this.q.D(i2);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(a.this.s, true, 23004, "pop_unable");
            memberPayActivityConfig.setSceneId("4002001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }

        @Override // d.a.n0.s1.a.c.e
        public void b() {
        }
    }

    public final BubbleListData.BubbleData P(int i2) {
        BubbleListData bubbleListData;
        if (i2 < 0 || i2 >= f() || (bubbleListData = this.r) == null) {
            return null;
        }
        return bubbleListData.getB_info().get(i2);
    }

    public final void Q() {
        BubbleListData bubbleListData = this.r;
        boolean z = false;
        if (bubbleListData != null && bubbleListData.getB_info() != null && this.r.getB_info().size() > 0) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.r.getB_info().get(0).getBcode() != 0) {
                this.r.getB_info().add(0, bubbleData);
            }
            this.t = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= this.r.getB_info().size()) {
                    break;
                } else if (this.r.getB_info().get(i2).isDef()) {
                    this.t = i2;
                    this.u = this.r.getB_info().get(i2).getBg_url();
                    TbadkCoreApplication.getInst().setDefaultBubble(this.u);
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (this.t != 0 && !TextUtils.isEmpty(this.u)) {
            d(new d.a.m0.w.a(2, 12, " "));
            z = true;
        } else {
            d(new d.a.m0.w.a(2, 12, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.valueOf(z)));
        d(new d.a.m0.w.a(25, -1, this.u));
    }

    public final void R(int i2) {
        this.q.B(i2, l.k(this.s), l.i(this.s));
        this.q.C(i2);
        if (k() != null) {
            k().a();
        }
    }

    @Override // d.a.m0.w.y.a
    public void a() {
        BubbleListModel bubbleListModel = this.q;
        if (bubbleListModel != null) {
            bubbleListModel.unRegisterListener();
            this.q.G(this.x);
            this.q = null;
        }
    }

    @Override // d.a.m0.w.y.a
    public int f() {
        BubbleListData bubbleListData = this.r;
        if (bubbleListData == null || bubbleListData.getB_info() == null) {
            return 0;
        }
        return this.r.getB_info().size();
    }

    @Override // d.a.m0.w.b
    public void onAction(d.a.m0.w.a aVar) {
        if (this.q == null) {
            Context context = this.s;
            if (context instanceof TbPageContext) {
                this.q = new BubbleListModel((TbPageContext) context);
            } else {
                this.q = new BubbleListModel(null);
            }
        }
        if (k() != null) {
            k().a();
        }
        this.q.A(0, 50, l.k(this.s), l.i(this.s));
    }

    @Override // d.a.m0.w.y.a
    public void q(Context context) {
        this.s = context;
        a.b bVar = new a.b();
        bVar.f50936a = R.drawable.icon_bubble;
        bVar.f50937b = 0;
        z(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26));
        t(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30));
        u(bVar);
        r(2);
        y(2);
        A(new C1591a(context));
        this.u = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.q == null) {
            Context context2 = this.s;
            if (context2 instanceof TbPageContext) {
                this.q = new BubbleListModel((TbPageContext) context2);
            } else {
                this.q = new BubbleListModel(null);
            }
        }
        this.q.E(this.v);
        this.q.F(this.w);
        this.q.z(this.x);
        this.q.x();
        this.q.y();
        if (k() != null) {
            k().a();
        }
        this.q.A(0, 50, l.k(this.s), l.i(this.s));
    }
}
