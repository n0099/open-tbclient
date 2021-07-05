package d.a.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.v0.a;
/* loaded from: classes8.dex */
public class q0 extends d.a.j.a<d.a.r0.r.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public View j;
    public TextView k;
    public TextView l;
    public OriginalThreadCardView m;
    public d.a.r0.r.q.a n;
    public boolean o;
    public OriginalThreadCardView.b p;

    /* loaded from: classes8.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f45794a;

        public a(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45794a = q0Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || this.f45794a.n == null || this.f45794a.n.getThreadData() == null) {
                return;
            }
            if (this.f45794a.d() != null) {
                this.f45794a.d().a(this.f45794a.m, this.f45794a.n);
            }
            String c0 = this.f45794a.n.getThreadData().c0();
            d.a.s0.a0.m.a(c0);
            this.f45794a.s(c0);
            this.f45794a.f45734e.o(new a.C0645a(1));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-465752462, "Ld/a/j/q0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-465752462, "Ld/a/j/q0;");
                return;
            }
        }
        q = d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - ((d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = false;
        this.p = new a(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.j = inflate;
        this.k = (TextView) inflate.findViewById(R.id.thread_card_title);
        this.l = (TextView) this.j.findViewById(R.id.thread_card_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) this.j.findViewById(R.id.original_thread_view);
        this.m = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.p);
    }

    @Override // d.a.j.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    @Override // d.a.j.a
    public void l(d.a.s0.a0.b0<d.a.r0.r.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b0Var) == null) {
            super.l(b0Var);
        }
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            this.m.n();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: r */
    public void a(d.a.r0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        this.n = aVar;
        ThreadCardUtils.setTitle(this.k, aVar.getThreadData(), this.o);
        ThreadCardUtils.setAbstract(this.l, this.k, aVar.getThreadData(), q, this.o);
        this.m.f(aVar.getThreadData().u1);
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            d.a.s0.a0.m.l(this.k, str, R.color.CAM_X0105, R.color.CAM_X0109);
            d.a.s0.a0.m.l(this.l, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.m.setReadState(d.a.s0.a0.m.k(str));
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.o = z;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.m.q = i2;
        }
    }
}
