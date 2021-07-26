package d.a.k;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleLinkCardView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(Context context) {
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
        this.l = new SingleLinkCardView(context);
        r(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // d.a.k.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.l.b();
        }
    }

    public final boolean s(d.a.p0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || !aVar.getThreadData().s2() || aVar.getThreadData().m1() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean t(d.a.p0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().E0() == null || aVar.getThreadData().E0().getOptions() == null || aVar.getThreadData().E0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: u */
    public void a(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (!t(aVar) && aVar != null && aVar.getThreadData() != null && !s(aVar) && ((!ListUtils.isEmpty(aVar.getThreadData().w0()) || ListUtils.getCount(aVar.getThreadData().a0()) == 1) && ((!ListUtils.isEmpty(aVar.getThreadData().a0()) || ListUtils.getCount(aVar.getThreadData().w0()) == 1) && ListUtils.getCount(aVar.getThreadData().w0()) + ListUtils.getCount(aVar.getThreadData().a0()) == 1))) {
                if (aVar.getThreadData().w0().size() >= 1) {
                    this.l.a((d.a.q0.a0.e0.c) ListUtils.getItem(aVar.getThreadData().w0(), 0));
                } else if (aVar.getThreadData().a0().size() >= 1) {
                    this.l.a((d.a.q0.a0.e0.c) ListUtils.getItem(aVar.getThreadData().a0(), 0));
                }
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
        }
    }
}
