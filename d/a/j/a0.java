package d.a.j;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiLinkCardView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(Context context) {
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
        this.l = new MultiLinkCardView(context);
        r(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
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
            this.l.b();
        }
    }

    public final boolean s(d.a.r0.r.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || !aVar.getThreadData().q2() || aVar.getThreadData().l1() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean t(d.a.r0.r.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().D0() == null || aVar.getThreadData().D0().getOptions() == null || aVar.getThreadData().D0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: u */
    public void a(d.a.r0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (!t(aVar) && !s(aVar) && aVar != null && aVar.getThreadData() != null && ((!ListUtils.isEmpty(aVar.getThreadData().v0()) || ListUtils.getCount(aVar.getThreadData().Z()) > 1) && ((!ListUtils.isEmpty(aVar.getThreadData().Z()) || ListUtils.getCount(aVar.getThreadData().v0()) > 1) && ListUtils.getCount(aVar.getThreadData().v0()) + ListUtils.getCount(aVar.getThreadData().Z()) > 1))) {
                this.l.a(aVar.getThreadData().v0(), aVar.getThreadData().Z());
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
        }
    }
}
