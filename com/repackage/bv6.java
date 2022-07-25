package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.av6;
import com.repackage.ev6;
import com.repackage.gu4;
import com.repackage.zu6;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public hv6 b;
    public ev6 c;
    public int d;
    public zu6 e;
    public av6 f;
    public BdUniqueId g;
    public CustomMessageListener h;
    public NEGFeedBackView.b i;
    public final View.OnClickListener j;
    public gu4.g k;
    public BdListView.p l;
    public ev6.e m;
    public View.OnClickListener n;
    public av6.f o;
    public zu6.b p;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bv6 bv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv6Var, Integer.valueOf(i)};
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
            this.a = bv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.p(customResponsedMessage);
                if (this.a.b != null) {
                    this.a.b.N();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv6 a;

        public b(bv6 bv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv6Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, lp4Var) == null) || arrayList == null || lp4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(arrayList.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i3 = lp4Var.n;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 40) {
                i = 2;
            } else if (i3 == 49) {
                i = 3;
            }
            if (this.a.b != null) {
                this.a.b.P();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", lp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", lp4Var.c()).param("obj_param1", lp4Var.k).param("obj_source", lp4Var.l).param("obj_id", lp4Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(lp4 lp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lp4Var) == null) || lp4Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", lp4Var.c()).param("tid", lp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", lp4Var.c()).param("tid", lp4Var.f()).param("obj_type", this.a.d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv6 a;

        public c(bv6 bv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b.F()) {
                return;
            }
            this.a.b.S(true);
            if (this.a.f.i()) {
                this.a.f.e();
                this.a.b.e0();
                SkinManager.setBackgroundResource(this.a.b.y(), R.color.CAM_X0207);
                return;
            }
            this.a.f.n(this.a.b.y());
            this.a.b.f0();
            SkinManager.setBackgroundResource(this.a.b.y(), R.color.CAM_X0201);
            if (this.a.c == null || ListUtils.isEmpty(this.a.c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes5.dex */
    public class d implements gu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv6 a;

        public d(bv6 bv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv6Var;
        }

        @Override // com.repackage.gu4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (ni.z()) {
                    this.a.c.q(this.a.d);
                    this.a.u();
                    this.a.b.Z(false);
                    return;
                }
                this.a.b.p0(null);
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f08a6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv6 a;

        public e(bv6 bv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv6Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.h0();
                this.a.c.r(this.a.d);
                this.a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ev6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv6 a;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.t();
                }
            }
        }

        public f(bv6 bv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv6Var;
        }

        @Override // com.repackage.ev6.e
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.b.B();
                this.a.b.C();
                if (z || z2) {
                    this.a.b.p0(null);
                } else {
                    this.a.b.p0(this.a.q(i));
                }
                if (this.a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.a.c.m()) && !StringUtils.isNull(yt4.k().q("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.a.b.T(this.a.f.i());
                    this.a.b.g0();
                    this.a.f.l(this.a.c.m());
                }
                if (i != 0) {
                    this.a.b.U(this.a.c.l());
                    this.a.b.d0(this.a.n);
                } else if (ListUtils.isEmpty(this.a.b.x())) {
                    this.a.b.k0();
                } else if (z) {
                    this.a.b.l0();
                }
            }
        }

        @Override // com.repackage.ev6.e
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.b.p0(null);
                this.a.b.B();
                this.a.b.C();
                if (ListUtils.isEmpty(this.a.b.x())) {
                    this.a.b.j0(new a(this));
                    return;
                }
                if (z) {
                    this.a.b.d0(this.a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f079b);
                } else {
                    this.a.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv6 a;

        public g(bv6 bv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.c == null) {
                return;
            }
            this.a.b.h0();
            this.a.c.r(this.a.d);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements av6.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv6 a;

        public h(bv6 bv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv6Var;
        }

        @Override // com.repackage.av6.f
        public void a(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cv6Var) == null) || cv6Var == null) {
                return;
            }
            this.a.d = cv6Var.a;
            this.a.m(cv6Var.a);
            if (this.a.b != null) {
                this.a.b.W(cv6Var.a);
                this.a.b.T(false);
                this.a.b.V(cv6Var.b);
            }
        }

        @Override // com.repackage.av6.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.T(false);
            this.a.b.J(false);
        }

        @Override // com.repackage.av6.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.b.J(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements zu6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv6 a;

        public i(bv6 bv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv6Var;
        }

        @Override // com.repackage.zu6.b
        public void a(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cv6Var) == null) || cv6Var == null) {
                return;
            }
            this.a.d = cv6Var.a;
            this.a.m(cv6Var.a);
            if (this.a.b != null) {
                this.a.b.W(cv6Var.a);
                this.a.b.T(false);
                this.a.b.V(cv6Var.b);
            }
        }
    }

    public bv6(BaseFragment baseFragment, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, 2016488);
        this.i = new b(this);
        this.j = new c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.a = tbPageContext;
        this.g = bdUniqueId;
        this.b = new hv6(baseFragment, tbPageContext, bdUniqueId, this.i);
        this.c = new ev6(this.a, this.m);
        av6 av6Var = new av6(tbPageContext, this.g);
        this.f = av6Var;
        av6Var.m(this.o);
        zu6 zu6Var = new zu6(tbPageContext, this.g);
        this.e = zu6Var;
        zu6Var.i(this.p);
        this.b.Y(this.j);
        int l = yt4.k().l("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.d = l;
        this.b.W(l);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            av6 av6Var = this.f;
            if (av6Var != null) {
                av6Var.p(i2);
            }
            ev6 ev6Var = this.c;
            if (ev6Var != null) {
                ev6Var.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            hv6 hv6Var = this.b;
            if (hv6Var != null) {
                hv6Var.s();
            }
            av6 av6Var = this.f;
            if (av6Var != null) {
                av6Var.j();
            }
            zu6 zu6Var = this.e;
            if (zu6Var != null) {
                zu6Var.f();
            }
            if (this.f.i()) {
                SkinManager.setBackgroundResource(this.b.y(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.b.y(), R.color.CAM_X0207);
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        zu6 zu6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ev6 ev6Var = this.c;
            if (ev6Var == null || ListUtils.isEmpty(ev6Var.m())) {
                return false;
            }
            if ((this.c.o() || this.d == 0) && (zu6Var = this.e) != null) {
                zu6Var.h(this.c.m());
                this.e.c((ViewGroup) this.b.z());
                yt4.k().D("key_game_video_tab_has_choosed_sub_class_id");
                yt4.k().D("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        ev6 ev6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (ev6Var = this.c) == null || ListUtils.isEmpty(ev6Var.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.c.w(optString);
        this.c.v(optString);
        hv6 hv6Var = this.b;
        if (hv6Var != null) {
            hv6Var.R(optString);
        }
    }

    public final gu4.i q(int i2) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 <= 0) {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0799);
            } else {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f079a, Integer.valueOf(i2));
            }
            return new gu4.i(string, 1000);
        }
        return (gu4.i) invokeI.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            hv6 hv6Var = this.b;
            if (hv6Var != null) {
                return hv6Var.z();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.u();
            this.b.D();
            this.b.X(this.k);
            this.b.a0(this.l);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hv6 hv6Var = this.b;
            if (hv6Var != null) {
                hv6Var.t();
                this.b.i0();
            }
            ev6 ev6Var = this.c;
            if (ev6Var != null) {
                ev6Var.q(this.d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.d));
        }
    }

    public void v() {
        hv6 hv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (hv6Var = this.b) == null) {
            return;
        }
        hv6Var.I();
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            hv6 hv6Var = this.b;
            if (hv6Var != null) {
                hv6Var.X(null);
                this.b.a0(null);
                this.b.K();
            }
            av6 av6Var = this.f;
            if (av6Var != null) {
                av6Var.k();
            }
            zu6 zu6Var = this.e;
            if (zu6Var != null) {
                zu6Var.g();
            }
            ev6 ev6Var = this.c;
            if (ev6Var != null) {
                ev6Var.t();
            }
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public void x() {
        hv6 hv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hv6Var = this.b) == null) {
            return;
        }
        hv6Var.L();
        this.b.M();
        this.b.b0(true);
    }

    public void y() {
        hv6 hv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hv6Var = this.b) == null) {
            return;
        }
        hv6Var.H();
        this.b.n0();
        this.b.Z(false);
        this.b.o0();
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.d));
                if (this.f.i()) {
                    return;
                }
                this.b.c0();
                return;
            }
            av6 av6Var = this.f;
            if (av6Var != null) {
                av6Var.f();
            }
            this.b.M();
        }
    }
}
