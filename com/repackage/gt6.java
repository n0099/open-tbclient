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
import com.repackage.et6;
import com.repackage.ft4;
import com.repackage.ft6;
import com.repackage.jt6;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public mt6 b;
    public jt6 c;
    public int d;
    public et6 e;
    public ft6 f;
    public BdUniqueId g;
    public CustomMessageListener h;
    public NEGFeedBackView.b i;
    public final View.OnClickListener j;
    public ft4.g k;
    public BdListView.p l;
    public jt6.e m;
    public View.OnClickListener n;
    public ft6.f o;
    public et6.b p;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gt6 gt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt6Var, Integer.valueOf(i)};
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
            this.a = gt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.p(customResponsedMessage);
                if (this.a.b != null) {
                    this.a.b.L();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt6 a;

        public b(gt6 gt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt6Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, lo4Var) == null) || arrayList == null || lo4Var == null) {
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
            int i3 = lo4Var.n;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 40) {
                i = 2;
            } else if (i3 == 49) {
                i = 3;
            }
            if (this.a.b != null) {
                this.a.b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", lo4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", lo4Var.c()).param("obj_param1", lo4Var.k).param("obj_source", lo4Var.l).param("obj_id", lo4Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(lo4 lo4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lo4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lo4Var) == null) || lo4Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", lo4Var.c()).param("tid", lo4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", lo4Var.c()).param("tid", lo4Var.f()).param("obj_type", this.a.d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt6 a;

        public c(gt6 gt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b.E()) {
                return;
            }
            this.a.b.Q(true);
            if (this.a.f.i()) {
                this.a.f.e();
                this.a.b.c0();
                SkinManager.setBackgroundResource(this.a.b.x(), R.color.CAM_X0207);
                return;
            }
            this.a.f.n(this.a.b.x());
            this.a.b.d0();
            SkinManager.setBackgroundResource(this.a.b.x(), R.color.CAM_X0201);
            if (this.a.c == null || ListUtils.isEmpty(this.a.c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ft4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt6 a;

        public d(gt6 gt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt6Var;
        }

        @Override // com.repackage.ft4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (ji.z()) {
                    this.a.c.q(this.a.d);
                    this.a.u();
                    this.a.b.X(false);
                    return;
                }
                this.a.b.n0(null);
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f08af);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt6 a;

        public e(gt6 gt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt6Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.f0();
                this.a.c.r(this.a.d);
                this.a.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements jt6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt6 a;

        /* loaded from: classes6.dex */
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

        public f(gt6 gt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt6Var;
        }

        @Override // com.repackage.jt6.e
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.b.A();
                this.a.b.B();
                if (z || z2) {
                    this.a.b.n0(null);
                } else {
                    this.a.b.n0(this.a.q(i));
                }
                if (this.a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.a.c.m()) && !StringUtils.isNull(ys4.k().q("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.a.b.R(this.a.f.i());
                    this.a.b.e0();
                    this.a.f.l(this.a.c.m());
                }
                if (i != 0) {
                    this.a.b.S(this.a.c.l());
                    this.a.b.b0(this.a.n);
                } else if (ListUtils.isEmpty(this.a.b.w())) {
                    this.a.b.i0();
                } else if (z) {
                    this.a.b.j0();
                }
            }
        }

        @Override // com.repackage.jt6.e
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.b.n0(null);
                this.a.b.A();
                this.a.b.B();
                if (ListUtils.isEmpty(this.a.b.w())) {
                    this.a.b.h0(new a(this));
                    return;
                }
                if (z) {
                    this.a.b.b0(this.a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0798);
                } else {
                    this.a.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt6 a;

        public g(gt6 gt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.c == null) {
                return;
            }
            this.a.b.f0();
            this.a.c.r(this.a.d);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ft6.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt6 a;

        public h(gt6 gt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt6Var;
        }

        @Override // com.repackage.ft6.f
        public void a(ht6 ht6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ht6Var) == null) || ht6Var == null) {
                return;
            }
            this.a.d = ht6Var.a;
            this.a.m(ht6Var.a);
            if (this.a.b != null) {
                this.a.b.U(ht6Var.a);
                this.a.b.R(false);
                this.a.b.T(ht6Var.b);
            }
        }

        @Override // com.repackage.ft6.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.R(false);
            this.a.b.H(false);
        }

        @Override // com.repackage.ft6.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.b.H(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements et6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt6 a;

        public i(gt6 gt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt6Var;
        }

        @Override // com.repackage.et6.b
        public void a(ht6 ht6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ht6Var) == null) || ht6Var == null) {
                return;
            }
            this.a.d = ht6Var.a;
            this.a.m(ht6Var.a);
            if (this.a.b != null) {
                this.a.b.U(ht6Var.a);
                this.a.b.R(false);
                this.a.b.T(ht6Var.b);
            }
        }
    }

    public gt6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.b = new mt6(tbPageContext, bdUniqueId, this.i);
        this.c = new jt6(this.a, this.m);
        ft6 ft6Var = new ft6(tbPageContext, this.g);
        this.f = ft6Var;
        ft6Var.m(this.o);
        et6 et6Var = new et6(tbPageContext, this.g);
        this.e = et6Var;
        et6Var.i(this.p);
        this.b.W(this.j);
        int l = ys4.k().l("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.d = l;
        this.b.U(l);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            ft6 ft6Var = this.f;
            if (ft6Var != null) {
                ft6Var.p(i2);
            }
            jt6 jt6Var = this.c;
            if (jt6Var != null) {
                jt6Var.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            mt6 mt6Var = this.b;
            if (mt6Var != null) {
                mt6Var.r();
            }
            ft6 ft6Var = this.f;
            if (ft6Var != null) {
                ft6Var.j();
            }
            et6 et6Var = this.e;
            if (et6Var != null) {
                et6Var.f();
            }
            if (this.f.i()) {
                SkinManager.setBackgroundResource(this.b.x(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.b.x(), R.color.CAM_X0207);
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        et6 et6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            jt6 jt6Var = this.c;
            if (jt6Var == null || ListUtils.isEmpty(jt6Var.m())) {
                return false;
            }
            if ((this.c.o() || this.d == 0) && (et6Var = this.e) != null) {
                et6Var.h(this.c.m());
                this.e.c((ViewGroup) this.b.y());
                ys4.k().D("key_game_video_tab_has_choosed_sub_class_id");
                ys4.k().D("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        jt6 jt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (jt6Var = this.c) == null || ListUtils.isEmpty(jt6Var.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.c.w(optString);
        this.c.v(optString);
        mt6 mt6Var = this.b;
        if (mt6Var != null) {
            mt6Var.P(optString);
        }
    }

    public final ft4.i q(int i2) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 <= 0) {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0796);
            } else {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0797, Integer.valueOf(i2));
            }
            return new ft4.i(string, 1000);
        }
        return (ft4.i) invokeI.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            mt6 mt6Var = this.b;
            if (mt6Var != null) {
                return mt6Var.y();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.u();
            this.b.C();
            this.b.V(this.k);
            this.b.Y(this.l);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            mt6 mt6Var = this.b;
            if (mt6Var != null) {
                mt6Var.s();
                this.b.g0();
            }
            jt6 jt6Var = this.c;
            if (jt6Var != null) {
                jt6Var.q(this.d);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            mt6 mt6Var = this.b;
            if (mt6Var != null) {
                mt6Var.V(null);
                this.b.Y(null);
                this.b.I();
            }
            ft6 ft6Var = this.f;
            if (ft6Var != null) {
                ft6Var.k();
            }
            et6 et6Var = this.e;
            if (et6Var != null) {
                et6Var.g();
            }
            jt6 jt6Var = this.c;
            if (jt6Var != null) {
                jt6Var.t();
            }
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public void w() {
        mt6 mt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (mt6Var = this.b) == null) {
            return;
        }
        mt6Var.J();
        this.b.K();
        this.b.Z(true);
    }

    public void x() {
        mt6 mt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (mt6Var = this.b) == null) {
            return;
        }
        mt6Var.G();
        this.b.l0();
        this.b.X(false);
        this.b.m0();
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.d));
                if (this.f.i()) {
                    return;
                }
                this.b.a0();
                return;
            }
            ft6 ft6Var = this.f;
            if (ft6Var != null) {
                ft6Var.f();
            }
            this.b.K();
        }
    }
}
