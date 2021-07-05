package d.a.s0.p0.z.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionEmptyViewHolder;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d extends d.a.c.k.e.a<d.a.s0.p0.z.b.a, ForumEmotionEmptyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public a n;
    public d.a.s0.p0.z.b.b o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext, d.a.s0.p0.z.b.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, bdUniqueId};
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
        this.o = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: f0 */
    public ForumEmotionEmptyViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ForumEmotionEmptyView forumEmotionEmptyView = new ForumEmotionEmptyView(this.m);
            forumEmotionEmptyView.b(TbadkCoreApplication.getInst().getSkinType());
            return new ForumEmotionEmptyViewHolder(this.m, forumEmotionEmptyView);
        }
        return (ForumEmotionEmptyViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.p0.z.b.a aVar, ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, forumEmotionEmptyViewHolder})) == null) {
            forumEmotionEmptyViewHolder.c(aVar, i2, this.o, this.n);
            return forumEmotionEmptyViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void h0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.n = aVar;
        }
    }
}
