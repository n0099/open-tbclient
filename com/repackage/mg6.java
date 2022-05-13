package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes6.dex */
public class mg6 extends eo<br4, ThreadCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public BdTypeRecyclerView k;

    /* loaded from: classes6.dex */
    public class a implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry a;
        public final /* synthetic */ mg6 b;

        public a(mg6 mg6Var, ry ryVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg6Var, ryVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mg6Var;
            this.a = ryVar;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = roVar instanceof br4;
                if (z) {
                    br4 br4Var = (br4) roVar;
                    if (br4Var.s.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                        BdToast.i(this.b.j.getContext(), this.b.j.getString(R.string.obfuscated_res_0x7f0f1503), R.drawable.obfuscated_res_0x7f0809be, true).q();
                        return;
                    }
                    ThreadData threadData = br4Var.s;
                    if (threadData != null && br4Var.n && threadData.getItem() != null) {
                        int a = hv4.a(br4Var.s.getItem().button_link_type.intValue(), br4Var.s.getItem().apk_detail != null ? br4Var.s.getItem().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(br4Var.s.getItem());
                        ItemCardHelper.q(this.a.u(), br4Var.s.getItem().item_id.longValue(), this.a.t(itemData), br4Var.s.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(br4Var.s.getItem().forum_name, String.valueOf(br4Var.s.getItem().item_id), 10, 10);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadData threadData2 = ((br4) roVar).s;
                    threadData2.objType = 1;
                    ThreadCardUtils.jumpToPB((zn4) threadData2, view2.getContext(), 2, false);
                    ((ThreadCardViewHolder) view2.getTag()).c().o(new vz.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mg6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
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
        this.j = tbPageContext;
        this.i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: a0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity(), false);
            ry ryVar = new ry(this.j.getPageActivity());
            ryVar.w(true);
            ryVar.z(6);
            ryVar.s();
            bVar.h(ryVar);
            kz k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.k);
            k.r(2);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new a(this, ryVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, br4 br4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, br4Var, threadCardViewHolder})) == null) {
            if (br4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || (threadData = br4Var.s) == null) {
                return null;
            }
            threadData.statFloor = C(i) + 1;
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.g(br4Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) {
            this.k = bdTypeRecyclerView;
        }
    }
}
