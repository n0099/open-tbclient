package d.a.q0.v.d.c.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.v.d.c.e.k;
import d.a.q0.v.d.c.f.d.i;
/* loaded from: classes8.dex */
public class c extends d.a.d.k.e.a<k, LiveTabConcernItemViewLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public d.a.q0.v.d.c.f.d.d n;
    public i o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.f64963h);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: e0 */
    public LiveTabConcernItemViewLineHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            d.a.q0.v.d.c.f.d.d dVar = new d.a.q0.v.d.c.f.d.d(this.m, viewGroup);
            this.n = dVar;
            i iVar = this.o;
            if (iVar != null) {
                dVar.s(iVar);
            }
            return new LiveTabConcernItemViewLineHolder(this.n);
        }
        return (LiveTabConcernItemViewLineHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public View X(int i2, View view, ViewGroup viewGroup, k kVar, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        InterceptResult invokeCommon;
        d.a.q0.v.d.c.f.d.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, liveTabConcernItemViewLineHolder})) == null) {
            if (liveTabConcernItemViewLineHolder == null || (dVar = liveTabConcernItemViewLineHolder.f14078a) == null) {
                return null;
            }
            dVar.l(kVar);
            return liveTabConcernItemViewLineHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void g0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.o = iVar;
            d.a.q0.v.d.c.f.d.d dVar = this.n;
            if (dVar != null) {
                dVar.s(iVar);
            }
        }
    }
}
