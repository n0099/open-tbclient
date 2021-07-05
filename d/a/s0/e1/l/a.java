package d.a.s0.e1.l;

import android.view.View;
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
import com.baidu.tbadk.core.util.ListUtils;
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
import d.a.s0.e1.l.c.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.s0.e1.l.c.b f59080a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.e1.l.e.a f59081b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f59082c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f59083d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f59084e;

    /* renamed from: f  reason: collision with root package name */
    public f.g f59085f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f59086g;

    /* renamed from: h  reason: collision with root package name */
    public b.f f59087h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f59088i;

    /* renamed from: d.a.s0.e1.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1400a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59089a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1400a(a aVar, int i2) {
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
            this.f59089a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f59089a.h(customResponsedMessage);
                if (this.f59089a.f59081b != null) {
                    this.f59089a.f59081b.E();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59090a;

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
            this.f59090a = aVar;
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
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(arrayList.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i3 = w0Var.m;
            if (i3 != 0 && i3 == 40) {
            }
            if (this.f59090a.f59081b != null) {
                this.f59090a.f59081b.G();
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(w0 w0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0Var) != null) || w0Var == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59091e;

        public c(a aVar) {
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
            this.f59091e = aVar;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f59091e.f59081b.L(false);
                    this.f59091e.f59080a.j();
                    TiebaStatic.log(new StatisticItem("c13582"));
                    return;
                }
                this.f59091e.f59081b.X(null);
                this.f59091e.f59082c.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59092e;

        public d(a aVar) {
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
            this.f59092e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59092e.f59081b.Q();
                this.f59092e.f59080a.l();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59093a;

        /* renamed from: d.a.s0.e1.l.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1401a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f59094e;

            public View$OnClickListenerC1401a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59094e = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f59094e.f59093a.l();
                }
            }
        }

        public e(a aVar) {
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
            this.f59093a = aVar;
        }

        @Override // d.a.s0.e1.l.c.b.f
        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f59093a.f59081b.t();
                this.f59093a.f59081b.u();
                if (z || z2) {
                    this.f59093a.f59081b.X(null);
                } else {
                    this.f59093a.f59081b.X(this.f59093a.i(i2));
                }
                if (i2 != 0) {
                    this.f59093a.f59081b.J(this.f59093a.f59080a.h());
                    this.f59093a.f59081b.P(this.f59093a.f59088i);
                } else if (ListUtils.isEmpty(this.f59093a.f59081b.q())) {
                    this.f59093a.f59081b.T();
                } else if (z) {
                    this.f59093a.f59081b.U();
                }
            }
        }

        @Override // d.a.s0.e1.l.c.b.f
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f59093a.f59081b.X(null);
                this.f59093a.f59081b.t();
                this.f59093a.f59081b.u();
                if (ListUtils.isEmpty(this.f59093a.f59081b.q())) {
                    this.f59093a.f59081b.S(new View$OnClickListenerC1401a(this));
                    return;
                }
                if (z) {
                    this.f59093a.f59081b.P(this.f59093a.f59088i);
                }
                if (StringUtils.isNull(str)) {
                    this.f59093a.f59082c.showToast(R.string.video_tab_load_more_fail);
                } else {
                    this.f59093a.f59082c.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59095e;

        public f(a aVar) {
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
            this.f59095e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59095e.f59081b == null || this.f59095e.f59080a == null) {
                return;
            }
            this.f59095e.f59081b.Q();
            this.f59095e.f59080a.l();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f59083d = new C1400a(this, 2016488);
        this.f59084e = new b(this);
        this.f59085f = new c(this);
        this.f59086g = new d(this);
        this.f59087h = new e(this);
        this.f59088i = new f(this);
        this.f59082c = tbPageContext;
        this.f59081b = new d.a.s0.e1.l.e.a(tbPageContext, bdUniqueId, this.f59084e);
        this.f59080a = new d.a.s0.e1.l.c.b(this.f59082c, this.f59087h);
    }

    public void g() {
        d.a.s0.e1.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f59081b) == null) {
            return;
        }
        aVar.m();
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.s0.e1.l.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (bVar = this.f59080a) == null || ListUtils.isEmpty(bVar.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.f59080a.r(optString);
        this.f59080a.q(optString);
        d.a.s0.e1.l.e.a aVar = this.f59081b;
        if (aVar != null) {
            aVar.I(optString);
        }
    }

    public final f.i i(int i2) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 <= 0) {
                string = this.f59082c.getResources().getString(R.string.video_tab_no_more);
            } else {
                string = this.f59082c.getResources().getString(R.string.video_tab_count, Integer.valueOf(i2));
            }
            return new f.i(string, 1000);
        }
        return (f.i) invokeI.objValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.s0.e1.l.e.a aVar = this.f59081b;
            if (aVar != null) {
                return aVar.r();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59080a.p();
            this.f59081b.v();
            this.f59081b.K(this.f59085f);
            this.f59081b.M(this.f59086g);
            MessageManager.getInstance().registerListener(this.f59083d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.s0.e1.l.e.a aVar = this.f59081b;
            if (aVar != null) {
                aVar.n();
                this.f59081b.R();
            }
            d.a.s0.e1.l.c.b bVar = this.f59080a;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.s0.e1.l.e.a aVar = this.f59081b;
            if (aVar != null) {
                aVar.K(null);
                this.f59081b.M(null);
                this.f59081b.A();
            }
            d.a.s0.e1.l.c.b bVar = this.f59080a;
            if (bVar != null) {
                bVar.o();
            }
            MessageManager.getInstance().unRegisterListener(this.f59083d);
        }
    }

    public void n() {
        d.a.s0.e1.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f59081b) == null) {
            return;
        }
        aVar.B();
        this.f59081b.C();
        this.f59081b.O(true);
    }

    public void o() {
        d.a.s0.e1.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f59081b) == null) {
            return;
        }
        aVar.L(false);
        this.f59081b.W();
        this.f59081b.y();
        this.f59081b.V();
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.f59081b.D();
            } else {
                this.f59081b.C();
            }
        }
    }
}
