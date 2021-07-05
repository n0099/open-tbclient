package d.a.j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RecommendInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendInfoLayout l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int g2 = d.a.c.e.p.l.g(context, R.dimen.M_H_X003);
        int g3 = d.a.c.e.p.l.g(context, d.a.r0.b.g.b.c(R.dimen.tbds21, R.dimen.tbds0));
        r(g2);
        q(g3);
        this.l = new RecommendInfoLayout(context);
    }

    @Override // d.a.j.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.l.c();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (d.a.r0.b.d.V()) {
                int g2 = d.a.c.e.p.l.g(this.f45735f, R.dimen.M_H_X003);
                int g3 = d.a.c.e.p.l.g(this.f45735f, d.a.r0.b.g.b.c(R.dimen.tbds21, R.dimen.tbds0));
                r(g2);
                q(g3);
                return;
            }
            int g4 = d.a.c.e.p.l.g(this.f45735f, R.dimen.tbds10);
            r(g4);
            q(0);
            u(this.l, g4, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: t */
    public void a(d.a.r0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.l.setData(aVar);
        }
    }

    public void u(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048581, this, view, i2, i3) == null) && view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin == i2 && marginLayoutParams.bottomMargin == i3) {
                return;
            }
            marginLayoutParams.topMargin = i2;
            marginLayoutParams.bottomMargin = i3;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
