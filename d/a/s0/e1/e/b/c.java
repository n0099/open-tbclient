package d.a.s0.e1.e.b;

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
import d.a.c.e.p.j;
import d.a.r0.r.f0.f;
import d.a.r0.r.q.w0;
import d.a.s0.e1.e.b.a;
import d.a.s0.e1.e.b.b;
import d.a.s0.e1.e.d.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58550a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.e1.e.f.b f58551b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.e1.e.d.b f58552c;

    /* renamed from: d  reason: collision with root package name */
    public int f58553d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.e1.e.b.a f58554e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.e1.e.b.b f58555f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f58556g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f58557h;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f58558i;
    public final View.OnClickListener j;
    public f.g k;
    public BdListView.p l;
    public b.e m;
    public View.OnClickListener n;
    public b.f o;
    public a.b p;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f58559a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f58559a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f58559a.p(customResponsedMessage);
                if (this.f58559a.f58551b != null) {
                    this.f58559a.f58551b.L();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f58560a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58560a = cVar;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(w0 w0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, w0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, w0 w0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, w0Var) == null) || arrayList == null || w0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                sb.append(arrayList.get(i3));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i4 = w0Var.m;
            if (i4 == 0) {
                i2 = 1;
            } else if (i4 == 40) {
                i2 = 2;
            } else if (i4 == 49) {
                i2 = 3;
            }
            if (this.f58560a.f58551b != null) {
                this.f58560a.f58551b.N();
            }
            TiebaStatic.log(new StatisticItem("c13500").param("tid", w0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", w0Var.c()).param("obj_param1", w0Var.j).param("obj_source", w0Var.k).param("obj_id", w0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(w0 w0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0Var) == null) || w0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", w0Var.c()).param("tid", w0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", w0Var.c()).param("tid", w0Var.e()).param("obj_type", this.f58560a.f58553d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* renamed from: d.a.s0.e1.e.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1380c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f58561e;

        public View$OnClickListenerC1380c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58561e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58561e.f58551b.E()) {
                return;
            }
            this.f58561e.f58551b.Q(true);
            if (this.f58561e.f58555f.i()) {
                this.f58561e.f58555f.e();
                this.f58561e.f58551b.c0();
                SkinManager.setBackgroundResource(this.f58561e.f58551b.x(), R.color.CAM_X0207);
                return;
            }
            this.f58561e.f58555f.n(this.f58561e.f58551b.x());
            this.f58561e.f58551b.d0();
            SkinManager.setBackgroundResource(this.f58561e.f58551b.x(), R.color.CAM_X0201);
            if (this.f58561e.f58552c == null || ListUtils.isEmpty(this.f58561e.f58552c.m())) {
                return;
            }
            TiebaStatic.log("c13490");
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f58562e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58562e = cVar;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f58562e.f58552c.q(this.f58562e.f58553d);
                    this.f58562e.u();
                    this.f58562e.f58551b.X(false);
                    return;
                }
                this.f58562e.f58551b.n0(null);
                this.f58562e.f58550a.showToast(R.string.im_error_default);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f58563e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58563e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58563e.f58551b.f0();
                this.f58563e.f58552c.r(this.f58563e.f58553d);
                this.f58563e.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f58564a;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f58565e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58565e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f58565e.f58564a.t();
                }
            }
        }

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58564a = cVar;
        }

        @Override // d.a.s0.e1.e.d.b.e
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f58564a.f58551b.A();
                this.f58564a.f58551b.B();
                if (z || z2) {
                    this.f58564a.f58551b.n0(null);
                } else {
                    this.f58564a.f58551b.n0(this.f58564a.q(i2));
                }
                if (this.f58564a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.f58564a.f58552c.m()) && !StringUtils.isNull(d.a.r0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.f58564a.f58551b.R(this.f58564a.f58555f.i());
                    this.f58564a.f58551b.e0();
                    this.f58564a.f58555f.l(this.f58564a.f58552c.m());
                }
                if (i2 != 0) {
                    this.f58564a.f58551b.S(this.f58564a.f58552c.l());
                    this.f58564a.f58551b.b0(this.f58564a.n);
                } else if (ListUtils.isEmpty(this.f58564a.f58551b.w())) {
                    this.f58564a.f58551b.i0();
                } else if (z) {
                    this.f58564a.f58551b.j0();
                }
            }
        }

        @Override // d.a.s0.e1.e.d.b.e
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f58564a.f58551b.n0(null);
                this.f58564a.f58551b.A();
                this.f58564a.f58551b.B();
                if (ListUtils.isEmpty(this.f58564a.f58551b.w())) {
                    this.f58564a.f58551b.h0(new a(this));
                    return;
                }
                if (z) {
                    this.f58564a.f58551b.b0(this.f58564a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.f58564a.f58550a.showToast(R.string.game_video_recommend_load_more_fail);
                } else {
                    this.f58564a.f58550a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f58566e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58566e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58566e.f58551b == null || this.f58566e.f58552c == null) {
                return;
            }
            this.f58566e.f58551b.f0();
            this.f58566e.f58552c.r(this.f58566e.f58553d);
        }
    }

    /* loaded from: classes9.dex */
    public class h implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f58567a;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58567a = cVar;
        }

        @Override // d.a.s0.e1.e.b.b.f
        public void a(d.a.s0.e1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f58567a.f58553d = aVar.f58569a;
            this.f58567a.m(aVar.f58569a);
            if (this.f58567a.f58551b != null) {
                this.f58567a.f58551b.U(aVar.f58569a);
                this.f58567a.f58551b.R(false);
                this.f58567a.f58551b.T(aVar.f58570b);
            }
        }

        @Override // d.a.s0.e1.e.b.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f58567a.f58551b == null) {
                return;
            }
            this.f58567a.f58551b.R(false);
            this.f58567a.f58551b.H(false);
        }

        @Override // d.a.s0.e1.e.b.b.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f58567a.f58551b.H(true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f58568a;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58568a = cVar;
        }

        @Override // d.a.s0.e1.e.b.a.b
        public void a(d.a.s0.e1.e.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f58568a.f58553d = aVar.f58569a;
            this.f58568a.m(aVar.f58569a);
            if (this.f58568a.f58551b != null) {
                this.f58568a.f58551b.U(aVar.f58569a);
                this.f58568a.f58551b.R(false);
                this.f58568a.f58551b.T(aVar.f58570b);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f58557h = new a(this, 2016488);
        this.f58558i = new b(this);
        this.j = new View$OnClickListenerC1380c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.f58550a = tbPageContext;
        this.f58556g = bdUniqueId;
        this.f58551b = new d.a.s0.e1.e.f.b(tbPageContext, bdUniqueId, this.f58558i);
        this.f58552c = new d.a.s0.e1.e.d.b(this.f58550a, this.m);
        d.a.s0.e1.e.b.b bVar = new d.a.s0.e1.e.b.b(tbPageContext, this.f58556g);
        this.f58555f = bVar;
        bVar.m(this.o);
        d.a.s0.e1.e.b.a aVar = new d.a.s0.e1.e.b.a(tbPageContext, this.f58556g);
        this.f58554e = aVar;
        aVar.i(this.p);
        this.f58551b.W(this.j);
        int k = d.a.r0.r.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.f58553d = k;
        this.f58551b.U(k);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            d.a.s0.e1.e.b.b bVar = this.f58555f;
            if (bVar != null) {
                bVar.p(i2);
            }
            d.a.s0.e1.e.d.b bVar2 = this.f58552c;
            if (bVar2 != null) {
                bVar2.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.s0.e1.e.f.b bVar = this.f58551b;
            if (bVar != null) {
                bVar.r();
            }
            d.a.s0.e1.e.b.b bVar2 = this.f58555f;
            if (bVar2 != null) {
                bVar2.j();
            }
            d.a.s0.e1.e.b.a aVar = this.f58554e;
            if (aVar != null) {
                aVar.f();
            }
            if (this.f58555f.i()) {
                SkinManager.setBackgroundResource(this.f58551b.x(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.f58551b.x(), R.color.CAM_X0207);
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        d.a.s0.e1.e.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.s0.e1.e.d.b bVar = this.f58552c;
            if (bVar == null || ListUtils.isEmpty(bVar.m())) {
                return false;
            }
            if ((this.f58552c.o() || this.f58553d == 0) && (aVar = this.f58554e) != null) {
                aVar.h(this.f58552c.m());
                this.f58554e.c((ViewGroup) this.f58551b.y());
                d.a.r0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_id");
                d.a.r0.r.d0.b.j().C("key_game_video_tab_has_choosed_sub_class_name");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.s0.e1.e.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f58552c) == null || ListUtils.isEmpty(bVar.l())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f58552c.w(optString);
        this.f58552c.v(optString);
        d.a.s0.e1.e.f.b bVar2 = this.f58551b;
        if (bVar2 != null) {
            bVar2.P(optString);
        }
    }

    public final f.i q(int i2) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 <= 0) {
                string = this.f58550a.getResources().getString(R.string.game_video_no_more);
            } else {
                string = this.f58550a.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i2));
            }
            return new f.i(string, 1000);
        }
        return (f.i) invokeI.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.s0.e1.e.f.b bVar = this.f58551b;
            if (bVar != null) {
                return bVar.y();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f58552c.u();
            this.f58551b.C();
            this.f58551b.V(this.k);
            this.f58551b.Y(this.l);
            MessageManager.getInstance().registerListener(this.f58557h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.s0.e1.e.f.b bVar = this.f58551b;
            if (bVar != null) {
                bVar.s();
                this.f58551b.g0();
            }
            d.a.s0.e1.e.d.b bVar2 = this.f58552c;
            if (bVar2 != null) {
                bVar2.q(this.f58553d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.f58553d));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.s0.e1.e.f.b bVar = this.f58551b;
            if (bVar != null) {
                bVar.V(null);
                this.f58551b.Y(null);
                this.f58551b.I();
            }
            d.a.s0.e1.e.b.b bVar2 = this.f58555f;
            if (bVar2 != null) {
                bVar2.k();
            }
            d.a.s0.e1.e.b.a aVar = this.f58554e;
            if (aVar != null) {
                aVar.g();
            }
            d.a.s0.e1.e.d.b bVar3 = this.f58552c;
            if (bVar3 != null) {
                bVar3.t();
            }
            MessageManager.getInstance().unRegisterListener(this.f58557h);
        }
    }

    public void w() {
        d.a.s0.e1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f58551b) == null) {
            return;
        }
        bVar.J();
        this.f58551b.K();
        this.f58551b.Z(true);
    }

    public void x() {
        d.a.s0.e1.e.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f58551b) == null) {
            return;
        }
        bVar.G();
        this.f58551b.l0();
        this.f58551b.X(false);
        this.f58551b.m0();
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.f58553d));
                if (this.f58555f.i()) {
                    return;
                }
                this.f58551b.a0();
                return;
            }
            d.a.s0.e1.e.b.b bVar = this.f58555f;
            if (bVar != null) {
                bVar.f();
            }
            this.f58551b.K();
        }
    }
}
