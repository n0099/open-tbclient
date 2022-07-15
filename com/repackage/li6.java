package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class li6 extends cd6<zy5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;

    /* loaded from: classes6.dex */
    public class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wx5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(li6 li6Var, wx5 wx5Var) {
            super(wx5Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li6Var, wx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wx5Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public li6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: l0 */
    public a M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            wx5 wx5Var = new wx5(this.k);
            wx5Var.u(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
            return new a(this, wx5Var);
        }
        return (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: m0 */
    public View S(int i, View view2, ViewGroup viewGroup, zy5 zy5Var, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zy5Var, aVar})) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
            if (zy5Var != null) {
                zy5Var.f = i + 1;
                aVar.a.v(pi.d(this.k.getPageActivity(), 7.0f));
                aVar.a.x(this.t);
                aVar.a.j(this.k, TbadkCoreApplication.getInst().getSkinType());
            }
            aVar.a.i(zy5Var);
            return aVar.b();
        }
        return (View) invokeCommon.objValue;
    }
}
