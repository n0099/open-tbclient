package com.repackage;

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
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ix7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public jr7 c;
    public sr7 d;
    public int e;
    public TextView f;
    public View g;
    public TextView h;
    public TBSpecificationBtn i;
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

    /* loaded from: classes6.dex */
    public class a implements VoteCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        public a(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            if (this.a.c == null || this.a.c.h == null) {
                this.a.b.setVisibility(8);
                return;
            }
            this.a.c.h.k(3);
            ix7 ix7Var = this.a;
            ix7Var.j(ix7Var.c);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        public b(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091757) {
                    if (this.a.c == null || this.a.a == null || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.a.getPageActivity()).createNormalConfig(ng.g(this.a.c.m(), 0L), 3)));
                } else if (view2.getId() != R.id.obfuscated_res_0x7f0917c9 || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) || this.a.c == null || this.a.d == null || this.a.c.O() == null) {
                } else {
                    if (this.a.d.a()) {
                        new StatisticItem("c13444").param("forum_id", this.a.c.m()).eventStat();
                        mq7 mq7Var = new mq7();
                        mq7Var.i(ng.g(this.a.c.Q(), 0L));
                        mq7Var.g(ng.g(this.a.c.m(), 0L));
                        ix7 ix7Var = this.a;
                        PostData f = ix7Var.f(ix7Var.c);
                        mq7Var.f(ng.g((f == null || f.s() == null) ? "" : f.s().getUserId(), 0L));
                        mq7Var.h(2);
                        mq7Var.j(this.a.a.getUniqueId());
                        CustomMessage customMessage = new CustomMessage(2921411);
                        customMessage.setData(mq7Var);
                        MessageManager.getInstance().sendMessage(customMessage);
                        return;
                    }
                    pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f081f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ix7 ix7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof CommitVoteResMsg) || this.a.c == null || this.a.c.h == null || this.a.a == null || httpResponsedMessage.getOrginalMessage().getTag() != this.a.a.getUniqueId()) {
                return;
            }
            if (error == 0) {
                pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f02e7);
                this.a.c.h.l(this.a.c.h.h() + 1);
                this.a.c.h.j(false);
                ix7 ix7Var = this.a;
                ix7Var.j(ix7Var.c);
            } else if (error == 3250023) {
                tj8.b(error, "", null);
            } else if (error == 3250021) {
                tj8.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
            } else if (error != 3250002 && error != 3250004) {
                pi.O(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = oi.isEmpty(httpResponsedMessage.getErrorString()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f031e) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f031c);
                blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f099e);
                blockPopInfoData.ahead_url = "https://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
            }
        }
    }

    public ix7(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.a = tbPageContext;
    }

    public View a(jr7 jr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jr7Var)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext == null) {
                return null;
            }
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0137, (ViewGroup) null);
            this.b = inflate;
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916ff);
            this.g = this.b.findViewById(R.id.obfuscated_res_0x7f0917ca);
            this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09170d);
            this.i = (TBSpecificationBtn) this.b.findViewById(R.id.obfuscated_res_0x7f0917c9);
            tu4 tu4Var = new tu4();
            tu4Var.e(GradientDrawable.Orientation.TL_BR);
            this.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dee));
            this.i.setTextSize(R.dimen.tbfontsize44);
            this.i.setConfig(tu4Var);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0917cc);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091700);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f09170c);
            this.m = (VoteCountDownView) this.b.findViewById(R.id.obfuscated_res_0x7f0917cb);
            this.n = this.b.findViewById(R.id.obfuscated_res_0x7f0917cd);
            this.o = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0917cf);
            this.p = (SelectRuleView) this.b.findViewById(R.id.obfuscated_res_0x7f0917ce);
            this.q = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091757);
            if (this.t != null) {
                if (this.a.getPageActivity() instanceof BaseActivity) {
                    this.t.setTag(((BaseActivity) this.a.getPageActivity()).getUniqueId());
                } else if (this.a.getPageActivity() instanceof BaseFragmentActivity) {
                    this.t.setTag(((BaseFragmentActivity) this.a.getPageActivity()).getUniqueId());
                }
                MessageManager.getInstance().registerListener(this.t);
            }
            j(jr7Var);
            return this.b;
        }
        return (View) invokeL.objValue;
    }

    public PostData f(jr7 jr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jr7Var)) == null) {
            PostData postData = null;
            if (jr7Var == null) {
                return null;
            }
            if (jr7Var.W() != null) {
                return jr7Var.W();
            }
            if (!ListUtils.isEmpty(jr7Var.F())) {
                Iterator<PostData> it = jr7Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.B() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = jr7Var.j();
            }
            if (postData == null) {
                postData = g(jr7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final PostData g(jr7 jr7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jr7Var)) == null) {
            if (jr7Var == null || jr7Var.O() == null || jr7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = jr7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = jr7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.s0(1);
            postData.x0(jr7Var.O().getFirstPostId());
            postData.J0(jr7Var.O().getTitle());
            postData.I0(jr7Var.O().getCreateTime());
            postData.q0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0304, 1, i);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0109, 1, i);
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
    }

    public void j(jr7 jr7Var) {
        sr7 sr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jr7Var) == null) || this.b == null) {
            return;
        }
        if (jr7Var != null && (sr7Var = jr7Var.h) != null) {
            this.c = jr7Var;
            this.d = sr7Var;
            if (sr7Var.d() != 0) {
                int d = this.d.d();
                this.e = d;
                if (d == 2) {
                    this.g.setVisibility(8);
                    this.k.setVisibility(0);
                    this.m.setOnCountDownFinished(this.r);
                    this.m.setData(this.d.c() * 1000);
                    this.q.setVisibility(8);
                } else if (d == 3) {
                    this.g.setVisibility(0);
                    this.i.setOnClickListener(this.s);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView = this.h;
                    textView.setText(this.d.h() + "票");
                } else if (d == 4 || d == 5) {
                    this.g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView2 = this.h;
                    textView2.setText(this.d.h() + "票");
                } else if (d == 6) {
                    this.g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    TextView textView3 = this.h;
                    textView3.setText(this.d.h() + "票");
                    this.q.setVisibility(8);
                } else {
                    this.b.setVisibility(8);
                    return;
                }
                if (!ListUtils.isEmpty(this.d.g()) || !ListUtils.isEmpty(this.d.f())) {
                    this.p.setColumn(2);
                    this.p.setData(this.d.g(), this.d.f());
                }
                i(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        this.b.setVisibility(8);
    }
}
