package d.b.i0.c2.k.e.c1;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.VoteCountDownView;
import d.b.b.e.p.l;
import d.b.i0.c2.d;
import d.b.i0.c2.h.e;
import d.b.i0.c2.h.k;
import d.b.i0.c3.n0.f;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52632a;

    /* renamed from: b  reason: collision with root package name */
    public View f52633b;

    /* renamed from: c  reason: collision with root package name */
    public e f52634c;

    /* renamed from: d  reason: collision with root package name */
    public k f52635d;

    /* renamed from: e  reason: collision with root package name */
    public int f52636e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f52637f;

    /* renamed from: g  reason: collision with root package name */
    public View f52638g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52639h;
    public TBSpecificationBtn i;
    public TextView j;
    public View k;
    public TextView l;
    public VoteCountDownView m;
    public View n;
    public TextView o;
    public SelectRuleView p;
    public TextView q;
    public VoteCountDownView.b r = new C1152a();
    public View.OnClickListener s = new b();
    public HttpMessageListener t = new c(CmdConfigHttp.CMD_BAR_VOTE);

    /* renamed from: d.b.i0.c2.k.e.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1152a implements VoteCountDownView.b {
        public C1152a() {
        }

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void a() {
            if (a.this.f52633b == null) {
                return;
            }
            if (a.this.f52634c == null || a.this.f52634c.f52427h == null) {
                a.this.f52633b.setVisibility(8);
                return;
            }
            a.this.f52634c.f52427h.k(3);
            a aVar = a.this;
            aVar.j(aVar.f52634c);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.f52634c == null || a.this.f52632a == null || !ViewHelper.checkUpIsLogin(a.this.f52632a.getPageActivity())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.f52632a.getPageActivity()).createNormalConfig(d.b.b.e.m.b.f(a.this.f52634c.m(), 0L), 3)));
            } else if (view.getId() != R.id.pb_vote_button || !ViewHelper.checkUpIsLogin(a.this.f52632a.getPageActivity()) || a.this.f52634c == null || a.this.f52635d == null || a.this.f52634c.L() == null) {
            } else {
                if (a.this.f52635d.a()) {
                    new StatisticItem("c13444").param("forum_id", a.this.f52634c.m()).eventStat();
                    d dVar = new d();
                    dVar.i(d.b.b.e.m.b.f(a.this.f52634c.N(), 0L));
                    dVar.g(d.b.b.e.m.b.f(a.this.f52634c.m(), 0L));
                    a aVar = a.this;
                    PostData f2 = aVar.f(aVar.f52634c);
                    dVar.f(d.b.b.e.m.b.f((f2 == null || f2.s() == null) ? "" : f2.s().getUserId(), 0L));
                    dVar.h(2);
                    dVar.j(a.this.f52632a.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.K(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof CommitVoteResMsg) || a.this.f52634c == null || a.this.f52634c.f52427h == null || a.this.f52632a == null || httpResponsedMessage.getOrginalMessage().getTag() != a.this.f52632a.getUniqueId()) {
                return;
            }
            if (error == 0) {
                l.K(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                a.this.f52634c.f52427h.l(a.this.f52634c.f52427h.h() + 1);
                a.this.f52634c.f52427h.j(false);
                a aVar = a.this;
                aVar.j(aVar.f52634c);
            } else if (error == 3250023) {
                f.b(error, "", null);
            } else if (error == 3250021) {
                f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
            } else if (error != 3250002 && error != 3250004) {
                l.L(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = d.b.b.e.p.k.isEmpty(httpResponsedMessage.getErrorString()) ? a.this.f52632a.getResources().getString(R.string.block_user_tip) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = a.this.f52632a.getResources().getString(R.string.block_user_feed);
                blockPopInfoData.ok_info = a.this.f52632a.getResources().getString(R.string.know);
                blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(a.this.f52632a.getPageActivity(), blockPopInfoData);
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f52632a = tbPageContext;
    }

    public View a(e eVar) {
        TbPageContext tbPageContext = this.f52632a;
        if (tbPageContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.f52633b = inflate;
        this.f52637f = (TextView) inflate.findViewById(R.id.pb_bar_manager_select_warn);
        this.f52638g = this.f52633b.findViewById(R.id.pb_vote_button_container);
        this.l = (TextView) this.f52633b.findViewById(R.id.pb_count_down_title);
        this.i = (TBSpecificationBtn) this.f52633b.findViewById(R.id.pb_vote_button);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        aVar.e(GradientDrawable.Orientation.TL_BR);
        this.i.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.i.setTextSize(R.dimen.tbfontsize44);
        this.i.setConfig(aVar);
        this.f52639h = (TextView) this.f52633b.findViewById(R.id.pb_vote_num);
        this.j = (TextView) this.f52633b.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.k = this.f52633b.findViewById(R.id.pb_count_down_container);
        this.m = (VoteCountDownView) this.f52633b.findViewById(R.id.pb_vote_count_down_view);
        this.n = this.f52633b.findViewById(R.id.pb_vote_rule);
        this.o = (TextView) this.f52633b.findViewById(R.id.pb_vote_rule_title);
        this.p = (SelectRuleView) this.f52633b.findViewById(R.id.pb_vote_rule_content);
        this.q = (TextView) this.f52633b.findViewById(R.id.pb_jump_to_vote_page);
        if (this.t != null) {
            if (this.f52632a.getPageActivity() instanceof BaseActivity) {
                this.t.setTag(((BaseActivity) this.f52632a.getPageActivity()).getUniqueId());
            } else if (this.f52632a.getPageActivity() instanceof BaseFragmentActivity) {
                this.t.setTag(((BaseFragmentActivity) this.f52632a.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.t);
        }
        j(eVar);
        return this.f52633b;
    }

    public PostData f(e eVar) {
        PostData postData = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.S() != null) {
            return eVar.S();
        }
        if (!ListUtils.isEmpty(eVar.D())) {
            Iterator<PostData> it = eVar.D().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next != null && next.z() == 1) {
                    postData = next;
                    break;
                }
            }
        }
        if (postData == null) {
            postData = eVar.j();
        }
        if (postData == null) {
            postData = g(eVar);
        }
        if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
            postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
        }
        return postData;
    }

    public final PostData g(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.L() == null || eVar.L().T() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData T = eVar.L().T();
        String userId = T.getUserId();
        HashMap<String, MetaData> E1 = eVar.L().E1();
        if (E1 != null && (metaData = E1.get(userId)) != null && metaData.getUserId() != null) {
            T = metaData;
        }
        postData.g0(1);
        postData.j0(eVar.L().f0());
        postData.v0(eVar.L().x1());
        postData.u0(eVar.L().Z());
        postData.e0(T);
        return postData;
    }

    public View h() {
        return this.f52633b;
    }

    public void i(int i) {
        SkinManager.setViewTextColor(this.f52639h, R.color.CAM_X0304, 1, i);
        SkinManager.setViewTextColor(this.f52637f, R.color.CAM_X0109, 1, i);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0304, 1, i);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i);
        TBSpecificationBtn tBSpecificationBtn = this.i;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0206, i);
        VoteCountDownView voteCountDownView = this.m;
        if (voteCountDownView != null) {
            voteCountDownView.e(i);
        }
        SelectRuleView selectRuleView = this.p;
        if (selectRuleView != null) {
            selectRuleView.d(i);
        }
    }

    public void j(e eVar) {
        k kVar;
        if (this.f52633b == null) {
            return;
        }
        if (eVar != null && (kVar = eVar.f52427h) != null) {
            this.f52634c = eVar;
            this.f52635d = kVar;
            if (kVar.d() != 0) {
                int d2 = this.f52635d.d();
                this.f52636e = d2;
                if (d2 == 2) {
                    this.f52638g.setVisibility(8);
                    this.k.setVisibility(0);
                    this.m.setOnCountDownFinished(this.r);
                    this.m.setData(this.f52635d.c() * 1000);
                    this.q.setVisibility(8);
                } else if (d2 == 3) {
                    this.f52638g.setVisibility(0);
                    this.i.setOnClickListener(this.s);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView = this.f52639h;
                    textView.setText(this.f52635d.h() + "票");
                } else if (d2 == 4 || d2 == 5) {
                    this.f52638g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView2 = this.f52639h;
                    textView2.setText(this.f52635d.h() + "票");
                } else if (d2 == 6) {
                    this.f52638g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    TextView textView3 = this.f52639h;
                    textView3.setText(this.f52635d.h() + "票");
                    this.q.setVisibility(8);
                } else {
                    this.f52633b.setVisibility(8);
                    return;
                }
                if (!ListUtils.isEmpty(this.f52635d.g()) || !ListUtils.isEmpty(this.f52635d.f())) {
                    this.p.setColumn(2);
                    this.p.setData(this.f52635d.g(), this.f52635d.f());
                }
                i(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        this.f52633b.setVisibility(8);
    }
}
