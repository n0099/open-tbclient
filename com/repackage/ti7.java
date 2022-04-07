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
import com.repackage.si7;
import com.repackage.u25;
import java.util.List;
/* loaded from: classes7.dex */
public class ti7 extends u25 {
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
    public si7.e v;
    public si7.e w;

    /* loaded from: classes7.dex */
    public class a implements u25.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ti7 b;

        public a(ti7 ti7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ti7Var;
            this.a = context;
        }

        @Override // com.repackage.u25.a
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
                BubbleListData.BubbleData P = this.b.P(i);
                if (P != null) {
                    bubbleView2.setData(P, BubbleListModel.A(this.b.n.getB_info()));
                    bubbleView2.setGravity(17);
                    bubbleView2.setTag(Integer.valueOf(i));
                    bubbleView2.setOnClickListener(this.b.u);
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                TbPageContext tbPageContext = (TbPageContext) f9.a(this.b.o);
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(bubbleView);
                return bubbleView;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BubbleListModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti7 a;

        public b(ti7 ti7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti7Var;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void a(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bubbleListData) == null) {
                this.a.n = null;
                if (bubbleListData == null) {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c18);
                } else if (bubbleListData.getError_code().equals("0")) {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c18);
                } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                    UtilHelper.showToast(this.a.o, bubbleListData.getError_msg());
                } else {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c18);
                }
                if (this.a.k() != null) {
                    this.a.k().onLoadFail();
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bubbleListData) == null) {
                if (bubbleListData == null) {
                    this.a.k().onLoadFail();
                    return;
                }
                this.a.n = bubbleListData.m53clone();
                if (this.a.m.C() > 0) {
                    List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
                    if (b_info == null || b_info.size() == 0) {
                        return;
                    }
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == this.a.m.C()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            this.a.m.I(this.a.m.C());
                            this.a.m.H(this.a.m.C(), oi.k(this.a.o), oi.i(this.a.o));
                        }
                    }
                    this.a.m.J(-1);
                }
                this.a.Q();
                this.a.k().b(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BubbleListModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti7 a;

        public c(ti7 ti7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti7Var;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void a(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, setBubbleResultData) == null) {
                if (setBubbleResultData != null && setBubbleResultData.getB_info() != null) {
                    this.a.q = setBubbleResultData.getB_info().getB_url();
                    TbadkCoreApplication.getInst().setDefaultBubble(this.a.q);
                    int B = this.a.m.B();
                    if (B == 0) {
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
                            if (bubbleData2.getBcode() == B) {
                                bubbleData2.setIs_def(1);
                            } else if (bubbleData2.isDef()) {
                                bubbleData2.setIs_def(0);
                            }
                            if (bubbleData2.getBcode() == B) {
                                bubbleData2.setCan_use(1);
                            }
                        }
                    } else {
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f10f9);
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
                    this.a.Q();
                    this.a.k().b(this.a);
                    return;
                }
                this.a.k().onLoadFail();
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void b(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, setBubbleResultData) == null) {
                if (setBubbleResultData != null) {
                    if (setBubbleResultData.getError_code().equals("0")) {
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c18);
                    } else if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                        UtilHelper.showToast(this.a.o, setBubbleResultData.getError_msg());
                    } else {
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c18);
                    }
                } else {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0c18);
                }
                if (this.a.k() != null) {
                    this.a.k().onLoadFail();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ti7 ti7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti7Var, Integer.valueOf(i)};
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
            this.a = ti7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m.G(0, 50, 0, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti7 a;

        public e(ti7 ti7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti7Var;
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
                    this.a.R(bubbleData.getBcode());
                } else if (bubbleData.isFree()) {
                    if (this.a.o instanceof TbPageContextSupport) {
                        si7.a(((TbPageContextSupport) this.a.o).getPageContext(), bubbleData, this.a.v);
                    }
                } else if (this.a.o instanceof TbPageContextSupport) {
                    si7.b(((TbPageContextSupport) this.a.o).getPageContext(), bubbleData, this.a.w);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements si7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti7 a;

        public f(ti7 ti7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti7Var;
        }

        @Override // com.repackage.si7.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.R(i);
            }
        }

        @Override // com.repackage.si7.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements si7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti7 a;

        public g(ti7 ti7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti7Var;
        }

        @Override // com.repackage.si7.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.m.J(i);
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.o, true, 23004, "pop_unable");
                memberPayActivityConfig.setSceneId("4002001000");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }

        @Override // com.repackage.si7.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    public ti7() {
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

    public final BubbleListData.BubbleData P(int i) {
        InterceptResult invokeI;
        BubbleListData bubbleListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < 0 || i >= f() || (bubbleListData = this.n) == null) {
                return null;
            }
            return bubbleListData.getB_info().get(i);
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
                d(new i05(2, 12, " "));
                z = true;
            } else {
                d(new i05(2, 12, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.valueOf(z)));
            d(new i05(25, -1, this.q));
        }
    }

    public final void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.m.H(i, oi.k(this.o), oi.i(this.o));
            this.m.I(i);
            if (k() != null) {
                k().a();
            }
        }
    }

    @Override // com.repackage.u25
    public void a() {
        BubbleListModel bubbleListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bubbleListModel = this.m) == null) {
            return;
        }
        bubbleListModel.unRegisterListener();
        this.m.M(this.t);
        this.m = null;
    }

    @Override // com.repackage.u25
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BubbleListData bubbleListData = this.n;
            if (bubbleListData == null || bubbleListData.getB_info() == null) {
                return 0;
            }
            return this.n.getB_info().size();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.j05
    public void onAction(i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, i05Var) == null) {
            if (this.m == null) {
                Context context = this.o;
                if (context instanceof TbPageContext) {
                    this.m = new BubbleListModel((TbPageContext) context);
                } else {
                    this.m = new BubbleListModel(null);
                }
            }
            if (k() != null) {
                k().a();
            }
            this.m.G(0, 50, oi.k(this.o), oi.i(this.o));
        }
    }

    @Override // com.repackage.u25
    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.o = context;
            u25.b bVar = new u25.b();
            bVar.a = R.drawable.icon_bubble;
            bVar.b = 0;
            z(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f0));
            t(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201));
            u(bVar);
            r(2);
            y(2);
            A(new a(this, context));
            this.q = TbadkCoreApplication.getInst().getDefaultBubble();
            if (this.m == null) {
                Context context2 = this.o;
                if (context2 instanceof TbPageContext) {
                    this.m = new BubbleListModel((TbPageContext) context2);
                } else {
                    this.m = new BubbleListModel(null);
                }
            }
            this.m.K(this.r);
            this.m.L(this.s);
            this.m.F(this.t);
            this.m.D();
            this.m.E();
            if (k() != null) {
                k().a();
            }
            this.m.G(0, 50, oi.k(this.o), oi.i(this.o));
        }
    }
}
