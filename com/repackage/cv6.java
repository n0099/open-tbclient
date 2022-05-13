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
import com.repackage.av6;
import com.repackage.bv6;
import com.repackage.fv6;
import com.repackage.pu4;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public iv6 b;
    public fv6 c;
    public int d;
    public av6 e;
    public bv6 f;
    public BdUniqueId g;
    public CustomMessageListener h;
    public NEGFeedBackView.b i;
    public final View.OnClickListener j;
    public pu4.g k;
    public BdListView.p l;
    public fv6.e m;
    public View.OnClickListener n;
    public bv6.f o;
    public av6.b p;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cv6 cv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var, Integer.valueOf(i)};
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
            this.a = cv6Var;
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

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv6 a;

        public b(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv6Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, wp4 wp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, wp4Var) == null) || arrayList == null || wp4Var == null) {
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
            int i3 = wp4Var.n;
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
            TiebaStatic.log(new StatisticItem("c13500").param("tid", wp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", wp4Var.c()).param("obj_param1", wp4Var.k).param("obj_source", wp4Var.l).param("obj_id", wp4Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(wp4 wp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(wp4 wp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wp4Var) == null) || wp4Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", wp4Var.c()).param("tid", wp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", wp4Var.c()).param("tid", wp4Var.f()).param("obj_type", this.a.d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv6 a;

        public c(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv6Var;
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

    /* loaded from: classes5.dex */
    public class d implements pu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv6 a;

        public d(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv6Var;
        }

        @Override // com.repackage.pu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (ki.z()) {
                    this.a.c.q(this.a.d);
                    this.a.u();
                    this.a.b.X(false);
                    return;
                }
                this.a.b.n0(null);
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f08a9);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv6 a;

        public e(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv6Var;
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

    /* loaded from: classes5.dex */
    public class f implements fv6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv6 a;

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

        public f(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv6Var;
        }

        @Override // com.repackage.fv6.e
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
                if (!ListUtils.isEmpty(this.a.c.m()) && !StringUtils.isNull(iu4.k().q("key_game_video_tab_has_choosed_sub_class_name", ""))) {
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

        @Override // com.repackage.fv6.e
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
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0792);
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
        public final /* synthetic */ cv6 a;

        public g(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv6Var;
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

    /* loaded from: classes5.dex */
    public class h implements bv6.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv6 a;

        public h(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv6Var;
        }

        @Override // com.repackage.bv6.f
        public void a(dv6 dv6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dv6Var) == null) || dv6Var == null) {
                return;
            }
            this.a.d = dv6Var.a;
            this.a.m(dv6Var.a);
            if (this.a.b != null) {
                this.a.b.U(dv6Var.a);
                this.a.b.R(false);
                this.a.b.T(dv6Var.b);
            }
        }

        @Override // com.repackage.bv6.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.R(false);
            this.a.b.H(false);
        }

        @Override // com.repackage.bv6.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.b.H(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements av6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv6 a;

        public i(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv6Var;
        }

        @Override // com.repackage.av6.b
        public void a(dv6 dv6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dv6Var) == null) || dv6Var == null) {
                return;
            }
            this.a.d = dv6Var.a;
            this.a.m(dv6Var.a);
            if (this.a.b != null) {
                this.a.b.U(dv6Var.a);
                this.a.b.R(false);
                this.a.b.T(dv6Var.b);
            }
        }
    }

    public cv6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.b = new iv6(tbPageContext, bdUniqueId, this.i);
        this.c = new fv6(this.a, this.m);
        bv6 bv6Var = new bv6(tbPageContext, this.g);
        this.f = bv6Var;
        bv6Var.m(this.o);
        av6 av6Var = new av6(tbPageContext, this.g);
        this.e = av6Var;
        av6Var.i(this.p);
        this.b.W(this.j);
        int l = iu4.k().l("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.d = l;
        this.b.U(l);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            bv6 bv6Var = this.f;
            if (bv6Var != null) {
                bv6Var.p(i2);
            }
            fv6 fv6Var = this.c;
            if (fv6Var != null) {
                fv6Var.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            iv6 iv6Var = this.b;
            if (iv6Var != null) {
                iv6Var.r();
            }
            bv6 bv6Var = this.f;
            if (bv6Var != null) {
                bv6Var.j();
            }
            av6 av6Var = this.e;
            if (av6Var != null) {
                av6Var.f();
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
        av6 av6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            fv6 fv6Var = this.c;
            if (fv6Var == null || ListUtils.isEmpty(fv6Var.m())) {
                return false;
            }
            if ((this.c.o() || this.d == 0) && (av6Var = this.e) != null) {
                av6Var.h(this.c.m());
                this.e.c((ViewGroup) this.b.y());
                iu4.k().D("key_game_video_tab_has_choosed_sub_class_id");
                iu4.k().D("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        fv6 fv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (fv6Var = this.c) == null || ListUtils.isEmpty(fv6Var.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.c.w(optString);
        this.c.v(optString);
        iv6 iv6Var = this.b;
        if (iv6Var != null) {
            iv6Var.P(optString);
        }
    }

    public final pu4.i q(int i2) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 <= 0) {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0790);
            } else {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0791, Integer.valueOf(i2));
            }
            return new pu4.i(string, 1000);
        }
        return (pu4.i) invokeI.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            iv6 iv6Var = this.b;
            if (iv6Var != null) {
                return iv6Var.y();
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
            iv6 iv6Var = this.b;
            if (iv6Var != null) {
                iv6Var.s();
                this.b.g0();
            }
            fv6 fv6Var = this.c;
            if (fv6Var != null) {
                fv6Var.q(this.d);
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
            iv6 iv6Var = this.b;
            if (iv6Var != null) {
                iv6Var.V(null);
                this.b.Y(null);
                this.b.I();
            }
            bv6 bv6Var = this.f;
            if (bv6Var != null) {
                bv6Var.k();
            }
            av6 av6Var = this.e;
            if (av6Var != null) {
                av6Var.g();
            }
            fv6 fv6Var = this.c;
            if (fv6Var != null) {
                fv6Var.t();
            }
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public void w() {
        iv6 iv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (iv6Var = this.b) == null) {
            return;
        }
        iv6Var.J();
        this.b.K();
        this.b.Z(true);
    }

    public void x() {
        iv6 iv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (iv6Var = this.b) == null) {
            return;
        }
        iv6Var.G();
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
            bv6 bv6Var = this.f;
            if (bv6Var != null) {
                bv6Var.f();
            }
            this.b.K();
        }
    }
}
