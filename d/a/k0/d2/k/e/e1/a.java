package d.a.k0.d2.k.e.e1;

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
import d.a.c.e.p.l;
import d.a.k0.d2.d;
import d.a.k0.d2.h.e;
import d.a.k0.d2.h.k;
import d.a.k0.d3.n0.f;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53040a;

    /* renamed from: b  reason: collision with root package name */
    public View f53041b;

    /* renamed from: c  reason: collision with root package name */
    public e f53042c;

    /* renamed from: d  reason: collision with root package name */
    public k f53043d;

    /* renamed from: e  reason: collision with root package name */
    public int f53044e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53045f;

    /* renamed from: g  reason: collision with root package name */
    public View f53046g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53047h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f53048i;
    public TextView j;
    public View k;
    public TextView l;
    public VoteCountDownView m;
    public View n;
    public TextView o;
    public SelectRuleView p;
    public TextView q;
    public VoteCountDownView.b r = new C1249a();
    public View.OnClickListener s = new b();
    public HttpMessageListener t = new c(CmdConfigHttp.CMD_BAR_VOTE);

    /* renamed from: d.a.k0.d2.k.e.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1249a implements VoteCountDownView.b {
        public C1249a() {
        }

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void a() {
            if (a.this.f53041b == null) {
                return;
            }
            if (a.this.f53042c == null || a.this.f53042c.f52721h == null) {
                a.this.f53041b.setVisibility(8);
                return;
            }
            a.this.f53042c.f52721h.k(3);
            a aVar = a.this;
            aVar.j(aVar.f53042c);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pb_jump_to_vote_page) {
                if (a.this.f53042c == null || a.this.f53040a == null || !ViewHelper.checkUpIsLogin(a.this.f53040a.getPageActivity())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(a.this.f53040a.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(a.this.f53042c.m(), 0L), 3)));
            } else if (view.getId() != R.id.pb_vote_button || !ViewHelper.checkUpIsLogin(a.this.f53040a.getPageActivity()) || a.this.f53042c == null || a.this.f53043d == null || a.this.f53042c.L() == null) {
            } else {
                if (a.this.f53043d.a()) {
                    new StatisticItem("c13444").param("forum_id", a.this.f53042c.m()).eventStat();
                    d dVar = new d();
                    dVar.i(d.a.c.e.m.b.f(a.this.f53042c.N(), 0L));
                    dVar.g(d.a.c.e.m.b.f(a.this.f53042c.m(), 0L));
                    a aVar = a.this;
                    PostData f2 = aVar.f(aVar.f53042c);
                    dVar.f(d.a.c.e.m.b.f((f2 == null || f2.t() == null) ? "" : f2.t().getUserId(), 0L));
                    dVar.h(2);
                    dVar.j(a.this.f53040a.getUniqueId());
                    CustomMessage customMessage = new CustomMessage(2921411);
                    customMessage.setData(dVar);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                l.L(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof CommitVoteResMsg) || a.this.f53042c == null || a.this.f53042c.f52721h == null || a.this.f53040a == null || httpResponsedMessage.getOrginalMessage().getTag() != a.this.f53040a.getUniqueId()) {
                return;
            }
            if (error == 0) {
                l.L(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                a.this.f53042c.f52721h.l(a.this.f53042c.f52721h.h() + 1);
                a.this.f53042c.f52721h.j(false);
                a aVar = a.this;
                aVar.j(aVar.f53042c);
            } else if (error == 3250023) {
                f.b(error, "", null);
            } else if (error == 3250021) {
                f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
            } else if (error != 3250002 && error != 3250004) {
                l.M(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = d.a.c.e.p.k.isEmpty(httpResponsedMessage.getErrorString()) ? a.this.f53040a.getResources().getString(R.string.block_user_tip) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = a.this.f53040a.getResources().getString(R.string.block_user_feed);
                blockPopInfoData.ok_info = a.this.f53040a.getResources().getString(R.string.know);
                blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(a.this.f53040a.getPageActivity(), blockPopInfoData);
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f53040a = tbPageContext;
    }

    public View a(e eVar) {
        TbPageContext tbPageContext = this.f53040a;
        if (tbPageContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
        this.f53041b = inflate;
        this.f53045f = (TextView) inflate.findViewById(R.id.pb_bar_manager_select_warn);
        this.f53046g = this.f53041b.findViewById(R.id.pb_vote_button_container);
        this.l = (TextView) this.f53041b.findViewById(R.id.pb_count_down_title);
        this.f53048i = (TBSpecificationBtn) this.f53041b.findViewById(R.id.pb_vote_button);
        d.a.j0.r.f0.m.a aVar = new d.a.j0.r.f0.m.a();
        aVar.e(GradientDrawable.Orientation.TL_BR);
        this.f53048i.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
        this.f53048i.setTextSize(R.dimen.tbfontsize44);
        this.f53048i.setConfig(aVar);
        this.f53047h = (TextView) this.f53041b.findViewById(R.id.pb_vote_num);
        this.j = (TextView) this.f53041b.findViewById(R.id.pb_bar_manager_ueg_tip);
        this.k = this.f53041b.findViewById(R.id.pb_count_down_container);
        this.m = (VoteCountDownView) this.f53041b.findViewById(R.id.pb_vote_count_down_view);
        this.n = this.f53041b.findViewById(R.id.pb_vote_rule);
        this.o = (TextView) this.f53041b.findViewById(R.id.pb_vote_rule_title);
        this.p = (SelectRuleView) this.f53041b.findViewById(R.id.pb_vote_rule_content);
        this.q = (TextView) this.f53041b.findViewById(R.id.pb_jump_to_vote_page);
        if (this.t != null) {
            if (this.f53040a.getPageActivity() instanceof BaseActivity) {
                this.t.setTag(((BaseActivity) this.f53040a.getPageActivity()).getUniqueId());
            } else if (this.f53040a.getPageActivity() instanceof BaseFragmentActivity) {
                this.t.setTag(((BaseFragmentActivity) this.f53040a.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.t);
        }
        j(eVar);
        return this.f53041b;
    }

    public PostData f(e eVar) {
        PostData postData = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.T() != null) {
            return eVar.T();
        }
        if (!ListUtils.isEmpty(eVar.D())) {
            Iterator<PostData> it = eVar.D().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next != null && next.A() == 1) {
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
        if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
            postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
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
        HashMap<String, MetaData> F1 = eVar.L().F1();
        if (F1 != null && (metaData = F1.get(userId)) != null && metaData.getUserId() != null) {
            T = metaData;
        }
        postData.i0(1);
        postData.l0(eVar.L().f0());
        postData.x0(eVar.L().y1());
        postData.w0(eVar.L().Z());
        postData.g0(T);
        return postData;
    }

    public View h() {
        return this.f53041b;
    }

    public void i(int i2) {
        SkinManager.setViewTextColor(this.f53047h, R.color.CAM_X0304, 1, i2);
        SkinManager.setViewTextColor(this.f53045f, R.color.CAM_X0109, 1, i2);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i2);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0304, 1, i2);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i2);
        TBSpecificationBtn tBSpecificationBtn = this.f53048i;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0206, i2);
        VoteCountDownView voteCountDownView = this.m;
        if (voteCountDownView != null) {
            voteCountDownView.e(i2);
        }
        SelectRuleView selectRuleView = this.p;
        if (selectRuleView != null) {
            selectRuleView.d(i2);
        }
    }

    public void j(e eVar) {
        k kVar;
        if (this.f53041b == null) {
            return;
        }
        if (eVar != null && (kVar = eVar.f52721h) != null) {
            this.f53042c = eVar;
            this.f53043d = kVar;
            if (kVar.d() != 0) {
                int d2 = this.f53043d.d();
                this.f53044e = d2;
                if (d2 == 2) {
                    this.f53046g.setVisibility(8);
                    this.k.setVisibility(0);
                    this.m.setOnCountDownFinished(this.r);
                    this.m.setData(this.f53043d.c() * 1000);
                    this.q.setVisibility(8);
                } else if (d2 == 3) {
                    this.f53046g.setVisibility(0);
                    this.f53048i.setOnClickListener(this.s);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView = this.f53047h;
                    textView.setText(this.f53043d.h() + "票");
                } else if (d2 == 4 || d2 == 5) {
                    this.f53046g.setVisibility(0);
                    this.f53048i.setEnabled(false);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView2 = this.f53047h;
                    textView2.setText(this.f53043d.h() + "票");
                } else if (d2 == 6) {
                    this.f53046g.setVisibility(0);
                    this.f53048i.setEnabled(false);
                    this.k.setVisibility(8);
                    TextView textView3 = this.f53047h;
                    textView3.setText(this.f53043d.h() + "票");
                    this.q.setVisibility(8);
                } else {
                    this.f53041b.setVisibility(8);
                    return;
                }
                if (!ListUtils.isEmpty(this.f53043d.g()) || !ListUtils.isEmpty(this.f53043d.f())) {
                    this.p.setColumn(2);
                    this.p.setData(this.f53043d.g(), this.f53043d.f());
                }
                i(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        this.f53041b.setVisibility(8);
    }
}
