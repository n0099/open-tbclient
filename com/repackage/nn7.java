package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newlist.view.HotTopicListInfoItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nn7 extends wm<pn7, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kl4<pn7> i;

    /* loaded from: classes6.dex */
    public class a implements kl4<pn7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(nn7 nn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.kl4
        /* renamed from: b */
        public void c(View view2, pn7 pn7Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, pn7Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.kl4
        /* renamed from: d */
        public void a(View view2, pn7 pn7Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, pn7Var, Integer.valueOf(i), Long.valueOf(j)}) == null) || pn7Var == null) {
                return;
            }
            kn7.a("c13737", pn7Var, i);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HotTopicListInfoItem a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HotTopicListInfoItem hotTopicListInfoItem) {
            super(hotTopicListInfoItem);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListInfoItem};
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
            this.a = hotTopicListInfoItem;
        }

        public void c(pn7 pn7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pn7Var) == null) || pn7Var == null) {
                return;
            }
            this.a.a(pn7Var);
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.d(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nn7(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), on7.a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: Z */
    public b M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            HotTopicListInfoItem hotTopicListInfoItem = new HotTopicListInfoItem(viewGroup.getContext());
            hotTopicListInfoItem.setOnItemCoverListener(this.i);
            hotTopicListInfoItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            b bVar = new b(hotTopicListInfoItem);
            bVar.d(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, pn7 pn7Var, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pn7Var, bVar})) == null) {
            if (pn7Var == null || bVar == null) {
                return null;
            }
            bVar.c(pn7Var);
            bVar.d(TbadkCoreApplication.getInst().getSkinType());
            return bVar.b();
        }
        return (View) invokeCommon.objValue;
    }
}
