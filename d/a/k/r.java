package d.a.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.InterviewLiveLayout;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
/* loaded from: classes7.dex */
public class r extends t0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int F;
    public transient /* synthetic */ FieldHolder $fh;
    public InterviewLiveLayout C;
    public int D;
    public TextView E;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-153541774, "Ld/a/k/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-153541774, "Ld/a/k/r;");
                return;
            }
        }
        F = d.a.d.e.p.l.k(TbadkCoreApplication.getInst()) - ((d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context) {
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
        this.D = 3;
        A();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f43131f).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
            this.j = inflate;
            this.k = (TextView) inflate.findViewById(R.id.video_seg_title);
            this.E = (TextView) this.j.findViewById(R.id.video_seg_abstract);
            this.m = (RoundCornerFrameLayout) this.j.findViewById(R.id.frame_video);
            this.C = (InterviewLiveLayout) this.j.findViewById(R.id.frame_interview_no_video);
            d.a.q0.n2.q.a q = q();
            this.n = q;
            q.E().setBackgroundResource(R.color.transparent);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.C.setFromCDN(z);
        }
    }

    @Override // d.a.k.t0, d.a.k.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    @Override // d.a.k.a
    public void l(d.a.q0.a0.b0<d.a.p0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            this.C.setSubClickListener(b0Var);
        }
    }

    @Override // d.a.k.t0, d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            if (this.D != i2) {
                SkinManager.setBackgroundResource(this.C, R.drawable.addresslist_item_bg);
                this.C.l(this.D);
            }
            this.D = i2;
        }
    }

    @Override // d.a.k.t0
    public d.a.q0.n2.q.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.q0.n2.q.b bVar = new d.a.q0.n2.q.b(this.f43131f, this.m);
            bVar.setStageType("2003");
            return bVar;
        }
        return (d.a.q0.n2.q.a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.t0, d.a.k.p
    /* renamed from: r */
    public void a(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.l = aVar;
            if (aVar == null || aVar.getThreadData() == null) {
                return;
            }
            b2 threadData = aVar.getThreadData();
            if (threadData.m1() != null) {
                this.C.setVisibility(8);
                this.m.setVisibility(0);
                this.E.setVisibility(8);
                super.a(aVar);
                return;
            }
            this.m.setVisibility(8);
            this.C.setVisibility(0);
            this.E.setVisibility(0);
            this.C.a(aVar);
            ThreadCardUtils.setTitle(this.k, threadData);
            ThreadCardUtils.setAbstract(this.E, this.k, threadData, F);
        }
    }
}
