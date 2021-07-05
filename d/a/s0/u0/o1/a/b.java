package d.a.s0.u0.o1.a;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.extra.adapter.FrsU9ViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.e0;
import d.a.s0.u0.k;
/* loaded from: classes9.dex */
public class b extends k<e0, FrsU9ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public FrsU9ViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            Log.e("Adapter", "Frs U9 Context:" + this.f44821e + "   Resource:" + this.f44821e.getResources() + "  Asset:" + this.f44821e.getResources().getAssets());
            return new FrsU9ViewHolder(this.o, LayoutInflater.from(this.f44821e).inflate(R.layout.u9_info_layout, (ViewGroup) null, true), this.f44825i);
        }
        return (FrsU9ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.u0.k, d.a.c.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, e0 e0Var, FrsU9ViewHolder frsU9ViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, e0Var, frsU9ViewHolder})) == null) {
            super.X(i2, view, viewGroup, e0Var, frsU9ViewHolder);
            if (e0Var == null || frsU9ViewHolder == null) {
                return null;
            }
            frsU9ViewHolder.g(e0Var);
            frsU9ViewHolder.h(TbadkCoreApplication.getInst().getSkinType());
            return frsU9ViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
