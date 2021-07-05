package d.a.s0.w2.a0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.PbAppEmptyHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.h0.o;
import d.a.s0.w2.s;
/* loaded from: classes9.dex */
public class e extends d.a.c.k.e.a<o, PbAppEmptyHolder> implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: f0 */
    public PbAppEmptyHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View view = new View(this.m.getPageContext().getPageActivity());
            view.setVisibility(8);
            return new PbAppEmptyHolder(view);
        }
        return (PbAppEmptyHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, o oVar, PbAppEmptyHolder pbAppEmptyHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, pbAppEmptyHolder})) == null) {
            AdvertAppInfo advertAppInfo = oVar.getAdvertAppInfo();
            if (advertAppInfo != null) {
                d.a.r0.r.q.e.g(advertAppInfo.U3, oVar.getPosition(), advertAppInfo.N3 == -1001);
            }
            return pbAppEmptyHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.s0.w2.s
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }
}
