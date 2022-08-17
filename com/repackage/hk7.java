package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gk7;
import com.repackage.u45;
import java.util.List;
/* loaded from: classes6.dex */
public class hk7 extends u45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleListModel m;
    public BubbleListData n;
    public Context o;
    public int p;
    public String q;
    public BubbleListModel.c r;
    public BubbleListModel.d s;
    public CustomMessageListener t;
    public View.OnClickListener u;
    public gk7.e v;
    public gk7.e w;

    /* loaded from: classes6.dex */
    public class a implements u45.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ hk7 b;

        public a(hk7 hk7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hk7Var;
            this.a = context;
        }

        @Override // com.repackage.u45.a
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            BubbleView bubbleView;
            BubbleView bubbleView2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    bubbleView2 = new BubbleView(this.a);
                    bubbleView = bubbleView2;
                } else {
                    bubbleView = view2;
                    bubbleView2 = (BubbleView) view2;
                }
                BubbleListData.BubbleData O = this.b.O(i);
                if (O != null) {
                    bubbleView2.setData(O, BubbleListModel.B(this.b.n.getB_info()));
                    bubbleView2.setGravity(17);
                    bubbleView2.setTag(Integer.valueOf(i));
                    bubbleView2.setOnClickListener(this.b.u);
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                TbPageContext tbPageContext = (TbPageContext) h9.a(this.b.o);
                tbPageContext.getLayoutMode().l(skinType == 1);
                tbPageContext.getLayoutMode().k(bubbleView);
                return bubbleView;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BubbleListModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk7 a;

        public b(hk7 hk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk7Var;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void a(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bubbleListData) == null) {
                this.a.n = null;
                if (bubbleListData == null) {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c3d);
                } else if (bubbleListData.getError_code().equals("0")) {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c3d);
                } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                    UtilHelper.showToast(this.a.o, bubbleListData.getError_msg());
                } else {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c3d);
                }
                if (this.a.h() != null) {
                    this.a.h().onLoadFail();
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bubbleListData) == null) {
                if (bubbleListData == null) {
                    this.a.h().onLoadFail();
                    return;
                }
                this.a.n = bubbleListData.m51clone();
                if (this.a.m.D() > 0) {
                    List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
                    if (b_info == null || b_info.size() == 0) {
                        return;
                    }
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == this.a.m.D()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            this.a.m.J(this.a.m.D());
                            this.a.m.I(this.a.m.D(), qi.k(this.a.o), qi.i(this.a.o));
                        }
                    }
                    this.a.m.K(-1);
                }
                this.a.P();
                this.a.h().b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements BubbleListModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk7 a;

        public c(hk7 hk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk7Var;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void a(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, setBubbleResultData) == null) {
                if (setBubbleResultData != null && setBubbleResultData.getB_info() != null) {
                    this.a.q = setBubbleResultData.getB_info().getB_url();
                    TbadkCoreApplication.getInst().setDefaultBubble(this.a.q);
                    int C = this.a.m.C();
                    if (C == 0) {
                        TbadkCoreApplication.getInst().setDefaultBubble("");
                        for (BubbleListData.BubbleData bubbleData : this.a.n.getB_info()) {
                            if (bubbleData.getBcode() != 0) {
                                if (bubbleData.isDef()) {
                                    bubbleData.setIs_def(0);
                                }
                            } else {
                                bubbleData.setIs_def(1);
                            }
                        }
                    } else if (setBubbleResultData.getB_info().canUser()) {
                        for (BubbleListData.BubbleData bubbleData2 : this.a.n.getB_info()) {
                            if (bubbleData2.getBcode() == C) {
                                bubbleData2.setIs_def(1);
                            } else if (bubbleData2.isDef()) {
                                bubbleData2.setIs_def(0);
                            }
                            if (bubbleData2.getBcode() == C) {
                                bubbleData2.setCan_use(1);
                            }
                        }
                    } else {
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f111d);
                        if (this.a.n != null && this.a.n.getB_info() != null && this.a.n.getB_info().size() > 0) {
                            if (this.a.n.getB_info().get(0).getBcode() == 0) {
                                this.a.p = 0;
                                int i = 0;
                                while (true) {
                                    if (i >= this.a.n.getB_info().size()) {
                                        break;
                                    } else if (this.a.n.getB_info().get(i).isDef()) {
                                        this.a.p = i;
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                this.a.n.getB_info().get(this.a.p).setIs_def(0);
                                this.a.n.getB_info().get(0).setIs_def(1);
                            } else {
                                BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                                bubbleData3.setBcode(0);
                                this.a.n.getB_info().add(0, bubbleData3);
                            }
                        }
                    }
                    this.a.P();
                    this.a.h().b(this.a);
                    return;
                }
                this.a.h().onLoadFail();
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void b(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, setBubbleResultData) == null) {
                if (setBubbleResultData != null) {
                    if (setBubbleResultData.getError_code().equals("0")) {
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c3d);
                    } else if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                        UtilHelper.showToast(this.a.o, setBubbleResultData.getError_msg());
                    } else {
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c3d);
                    }
                } else {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c3d);
                }
                if (this.a.h() != null) {
                    this.a.h().onLoadFail();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(hk7 hk7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk7Var, Integer.valueOf(i)};
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
            this.a = hk7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m.H(0, 50, 0, 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk7 a;

        public e(hk7 hk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n != null && (view2 instanceof BubbleView)) {
                BubbleListData.BubbleData bubbleData = (BubbleListData.BubbleData) ListUtils.getItem(this.a.n.getB_info(), ((Integer) view2.getTag()).intValue());
                TbadkSettings inst = TbadkSettings.getInst();
                boolean loadBoolean = inst.loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
                if (bubbleData == null || bubbleData.isDef()) {
                    return;
                }
                if (bubbleData.getBcode() == 0 || bubbleData.canUse() || loadBoolean) {
                    this.a.Q(bubbleData.getBcode());
                } else if (bubbleData.isFree()) {
                    if (this.a.o instanceof TbPageContextSupport) {
                        gk7.a(((TbPageContextSupport) this.a.o).getPageContext(), bubbleData, this.a.v);
                    }
                } else if (this.a.o instanceof TbPageContextSupport) {
                    gk7.b(((TbPageContextSupport) this.a.o).getPageContext(), bubbleData, this.a.w);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements gk7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk7 a;

        public f(hk7 hk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk7Var;
        }

        @Override // com.repackage.gk7.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.Q(i);
            }
        }

        @Override // com.repackage.gk7.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements gk7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk7 a;

        public g(hk7 hk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk7Var;
        }

        @Override // com.repackage.gk7.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.m.K(i);
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.o, true, 23004, "pop_unable");
                memberPayActivityConfig.setSceneId("4002001000");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }

        @Override // com.repackage.gk7.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    public hk7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 0;
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this, 2010040);
        this.u = new e(this);
        this.v = new f(this);
        this.w = new g(this);
    }

    @Override // com.repackage.i25
    public void A(h25 h25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h25Var) == null) {
            if (this.m == null) {
                Context context = this.o;
                if (context instanceof TbPageContext) {
                    this.m = new BubbleListModel((TbPageContext) context);
                } else {
                    this.m = new BubbleListModel(null);
                }
            }
            if (h() != null) {
                h().a();
            }
            this.m.H(0, 50, qi.k(this.o), qi.i(this.o));
        }
    }

    public final BubbleListData.BubbleData O(int i) {
        InterceptResult invokeI;
        BubbleListData bubbleListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0 || i >= c() || (bubbleListData = this.n) == null) {
                return null;
            }
            return bubbleListData.getB_info().get(i);
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BubbleListData bubbleListData = this.n;
            boolean z = false;
            if (bubbleListData != null && bubbleListData.getB_info() != null && this.n.getB_info().size() > 0) {
                BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
                bubbleData.setBcode(0);
                if (this.n.getB_info().get(0).getBcode() != 0) {
                    this.n.getB_info().add(0, bubbleData);
                }
                this.p = 0;
                int i = 0;
                while (true) {
                    if (i >= this.n.getB_info().size()) {
                        break;
                    } else if (this.n.getB_info().get(i).isDef()) {
                        this.p = i;
                        this.q = this.n.getB_info().get(i).getBg_url();
                        TbadkCoreApplication.getInst().setDefaultBubble(this.q);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (this.p != 0 && !TextUtils.isEmpty(this.q)) {
                J(new h25(2, 12, " "));
                z = true;
            } else {
                J(new h25(2, 12, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.valueOf(z)));
            J(new h25(25, -1, this.q));
        }
    }

    public final void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.m.I(i, qi.k(this.o), qi.i(this.o));
            this.m.J(i);
            if (h() != null) {
                h().a();
            }
        }
    }

    @Override // com.repackage.u45
    public void a() {
        BubbleListModel bubbleListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bubbleListModel = this.m) == null) {
            return;
        }
        bubbleListModel.unRegisterListener();
        this.m.N(this.t);
        this.m = null;
    }

    @Override // com.repackage.u45
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BubbleListData bubbleListData = this.n;
            if (bubbleListData == null || bubbleListData.getB_info() == null) {
                return 0;
            }
            return this.n.getB_info().size();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.u45
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.o = context;
            u45.b bVar = new u45.b();
            bVar.a = R.drawable.icon_bubble;
            bVar.b = 0;
            w(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f0));
            q(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201));
            r(bVar);
            o(2);
            v(2);
            x(new a(this, context));
            this.q = TbadkCoreApplication.getInst().getDefaultBubble();
            if (this.m == null) {
                Context context2 = this.o;
                if (context2 instanceof TbPageContext) {
                    this.m = new BubbleListModel((TbPageContext) context2);
                } else {
                    this.m = new BubbleListModel(null);
                }
            }
            this.m.L(this.r);
            this.m.M(this.s);
            this.m.G(this.t);
            this.m.E();
            this.m.F();
            if (h() != null) {
                h().a();
            }
            this.m.H(0, 50, qi.k(this.o), qi.i(this.o));
        }
    }
}
