package d.a.s0.v.d.c.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.SdkDoubleLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.v.d.c.e.e;
/* loaded from: classes9.dex */
public class d extends d.a.c.k.e.a<e, SdkDoubleLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public d.a.s0.v.d.c.h.e n;
    public int o;
    public boolean p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, int i2, boolean z) {
        super(tbPageContext.getPageActivity(), z ? e.f67522h : e.f67521g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        this.o = i2;
        this.p = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: f0 */
    public SdkDoubleLiveViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.n = new d.a.s0.v.d.c.h.e(this.m, viewGroup, this.o, this.p);
            return new SdkDoubleLiveViewHolder(this.n);
        }
        return (SdkDoubleLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, e eVar, SdkDoubleLiveViewHolder sdkDoubleLiveViewHolder) {
        InterceptResult invokeCommon;
        d.a.s0.v.d.c.h.e eVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, sdkDoubleLiveViewHolder})) == null) {
            if (sdkDoubleLiveViewHolder == null || (eVar2 = sdkDoubleLiveViewHolder.f14003a) == null) {
                return null;
            }
            eVar2.m(eVar);
            sdkDoubleLiveViewHolder.f14003a.n(this.m, TbadkCoreApplication.getInst().getSkinType());
            return sdkDoubleLiveViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
