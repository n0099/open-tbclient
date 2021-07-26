package d.a.q0.h2.k.e.h1;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.h2.d;
import d.a.q0.h2.h.e;
import d.a.q0.h2.h.k;
import d.a.q0.h3.n0.f;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57883a;

    /* renamed from: b  reason: collision with root package name */
    public View f57884b;

    /* renamed from: c  reason: collision with root package name */
    public e f57885c;

    /* renamed from: d  reason: collision with root package name */
    public k f57886d;

    /* renamed from: e  reason: collision with root package name */
    public int f57887e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57888f;

    /* renamed from: g  reason: collision with root package name */
    public View f57889g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57890h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f57891i;
    public TextView j;
    public View k;
    public TextView l;
    public VoteCountDownView m;
    public View n;
    public TextView o;
    public SelectRuleView p;
    public TextView q;
    public VoteCountDownView.b r;
    public View.OnClickListener s;
    public HttpMessageListener t;

    /* renamed from: d.a.q0.h2.k.e.h1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1433a implements VoteCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57892a;

        public C1433a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57892a = aVar;
        }

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57892a.f57884b == null) {
                return;
            }
            if (this.f57892a.f57885c == null || this.f57892a.f57885c.f57444h == null) {
                this.f57892a.f57884b.setVisibility(8);
                return;
            }
            this.f57892a.f57885c.f57444h.k(3);
            a aVar = this.f57892a;
            aVar.j(aVar.f57885c);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57893e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57893e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.pb_jump_to_vote_page) {
                    if (this.f57893e.f57885c == null || this.f57893e.f57883a == null || !ViewHelper.checkUpIsLogin(this.f57893e.f57883a.getPageActivity())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.f57893e.f57883a.getPageActivity()).createNormalConfig(d.a.d.e.m.b.f(this.f57893e.f57885c.n(), 0L), 3)));
                } else if (view.getId() != R.id.pb_vote_button || !ViewHelper.checkUpIsLogin(this.f57893e.f57883a.getPageActivity()) || this.f57893e.f57885c == null || this.f57893e.f57886d == null || this.f57893e.f57885c.N() == null) {
                } else {
                    if (this.f57893e.f57886d.a()) {
                        new StatisticItem("c13444").param("forum_id", this.f57893e.f57885c.n()).eventStat();
                        d dVar = new d();
                        dVar.i(d.a.d.e.m.b.f(this.f57893e.f57885c.P(), 0L));
                        dVar.g(d.a.d.e.m.b.f(this.f57893e.f57885c.n(), 0L));
                        a aVar = this.f57893e;
                        PostData f2 = aVar.f(aVar.f57885c);
                        dVar.f(d.a.d.e.m.b.f((f2 == null || f2.t() == null) ? "" : f2.t().getUserId(), 0L));
                        dVar.h(2);
                        dVar.j(this.f57893e.f57883a.getUniqueId());
                        CustomMessage customMessage = new CustomMessage(2921411);
                        customMessage.setData(dVar);
                        MessageManager.getInstance().sendMessage(customMessage);
                        return;
                    }
                    l.L(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57894a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57894a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof CommitVoteResMsg) || this.f57894a.f57885c == null || this.f57894a.f57885c.f57444h == null || this.f57894a.f57883a == null || httpResponsedMessage.getOrginalMessage().getTag() != this.f57894a.f57883a.getUniqueId()) {
                return;
            }
            if (error == 0) {
                l.L(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                this.f57894a.f57885c.f57444h.l(this.f57894a.f57885c.f57444h.h() + 1);
                this.f57894a.f57885c.f57444h.j(false);
                a aVar = this.f57894a;
                aVar.j(aVar.f57885c);
            } else if (error == 3250023) {
                f.b(error, "", null);
            } else if (error == 3250021) {
                f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
            } else if (error != 3250002 && error != 3250004) {
                l.M(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = d.a.d.e.p.k.isEmpty(httpResponsedMessage.getErrorString()) ? this.f57894a.f57883a.getResources().getString(R.string.block_user_tip) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = this.f57894a.f57883a.getResources().getString(R.string.block_user_feed);
                blockPopInfoData.ok_info = this.f57894a.f57883a.getResources().getString(R.string.know);
                blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(this.f57894a.f57883a.getPageActivity(), blockPopInfoData);
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new C1433a(this);
        this.s = new b(this);
        this.t = new c(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.f57883a = tbPageContext;
    }

    public View a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            TbPageContext tbPageContext = this.f57883a;
            if (tbPageContext == null) {
                return null;
            }
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.bar_manager_select_view, (ViewGroup) null);
            this.f57884b = inflate;
            this.f57888f = (TextView) inflate.findViewById(R.id.pb_bar_manager_select_warn);
            this.f57889g = this.f57884b.findViewById(R.id.pb_vote_button_container);
            this.l = (TextView) this.f57884b.findViewById(R.id.pb_count_down_title);
            this.f57891i = (TBSpecificationBtn) this.f57884b.findViewById(R.id.pb_vote_button);
            d.a.p0.s.f0.n.a aVar = new d.a.p0.s.f0.n.a();
            aVar.e(GradientDrawable.Orientation.TL_BR);
            this.f57891i.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
            this.f57891i.setTextSize(R.dimen.tbfontsize44);
            this.f57891i.setConfig(aVar);
            this.f57890h = (TextView) this.f57884b.findViewById(R.id.pb_vote_num);
            this.j = (TextView) this.f57884b.findViewById(R.id.pb_bar_manager_ueg_tip);
            this.k = this.f57884b.findViewById(R.id.pb_count_down_container);
            this.m = (VoteCountDownView) this.f57884b.findViewById(R.id.pb_vote_count_down_view);
            this.n = this.f57884b.findViewById(R.id.pb_vote_rule);
            this.o = (TextView) this.f57884b.findViewById(R.id.pb_vote_rule_title);
            this.p = (SelectRuleView) this.f57884b.findViewById(R.id.pb_vote_rule_content);
            this.q = (TextView) this.f57884b.findViewById(R.id.pb_jump_to_vote_page);
            if (this.t != null) {
                if (this.f57883a.getPageActivity() instanceof BaseActivity) {
                    this.t.setTag(((BaseActivity) this.f57883a.getPageActivity()).getUniqueId());
                } else if (this.f57883a.getPageActivity() instanceof BaseFragmentActivity) {
                    this.t.setTag(((BaseFragmentActivity) this.f57883a.getPageActivity()).getUniqueId());
                }
                MessageManager.getInstance().registerListener(this.t);
            }
            j(eVar);
            return this.f57884b;
        }
        return (View) invokeL.objValue;
    }

    public PostData f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
            PostData postData = null;
            if (eVar == null) {
                return null;
            }
            if (eVar.V() != null) {
                return eVar.V();
            }
            if (!ListUtils.isEmpty(eVar.E())) {
                Iterator<PostData> it = eVar.E().iterator();
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
        return (PostData) invokeL.objValue;
    }

    public final PostData g(e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null || eVar.N().H() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData H = eVar.N().H();
            String userId = H.getUserId();
            HashMap<String, MetaData> v1 = eVar.N().v1();
            if (v1 != null && (metaData = v1.get(userId)) != null && metaData.getUserId() != null) {
                H = metaData;
            }
            postData.i0(1);
            postData.l0(eVar.N().U());
            postData.x0(eVar.N().getTitle());
            postData.w0(eVar.N().N());
            postData.g0(H);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57884b : (View) invokeV.objValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f57890h, R.color.CAM_X0304, 1, i2);
            SkinManager.setViewTextColor(this.f57888f, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0304, 1, i2);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i2);
            TBSpecificationBtn tBSpecificationBtn = this.f57891i;
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
    }

    public void j(e eVar) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || this.f57884b == null) {
            return;
        }
        if (eVar != null && (kVar = eVar.f57444h) != null) {
            this.f57885c = eVar;
            this.f57886d = kVar;
            if (kVar.d() != 0) {
                int d2 = this.f57886d.d();
                this.f57887e = d2;
                if (d2 == 2) {
                    this.f57889g.setVisibility(8);
                    this.k.setVisibility(0);
                    this.m.setOnCountDownFinished(this.r);
                    this.m.setData(this.f57886d.c() * 1000);
                    this.q.setVisibility(8);
                } else if (d2 == 3) {
                    this.f57889g.setVisibility(0);
                    this.f57891i.setOnClickListener(this.s);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView = this.f57890h;
                    textView.setText(this.f57886d.h() + "票");
                } else if (d2 == 4 || d2 == 5) {
                    this.f57889g.setVisibility(0);
                    this.f57891i.setEnabled(false);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView2 = this.f57890h;
                    textView2.setText(this.f57886d.h() + "票");
                } else if (d2 == 6) {
                    this.f57889g.setVisibility(0);
                    this.f57891i.setEnabled(false);
                    this.k.setVisibility(8);
                    TextView textView3 = this.f57890h;
                    textView3.setText(this.f57886d.h() + "票");
                    this.q.setVisibility(8);
                } else {
                    this.f57884b.setVisibility(8);
                    return;
                }
                if (!ListUtils.isEmpty(this.f57886d.g()) || !ListUtils.isEmpty(this.f57886d.f())) {
                    this.p.setColumn(2);
                    this.p.setData(this.f57886d.g(), this.f57886d.f());
                }
                i(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        this.f57884b.setVisibility(8);
    }
}
