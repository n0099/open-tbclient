package d.a.q0.v.d.c.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.u0.s;
/* loaded from: classes8.dex */
public class a extends d.a.d.k.e.a<s, FrsNoListItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), s.f64447f);
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
        this.m = (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, s sVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        f0(i2, view, viewGroup, sVar, frsNoListItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: e0 */
    public FrsNoListItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f42341e).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
            ViewGroup.LayoutParams u = u(viewGroup);
            u.width = -1;
            u.height = this.m;
            inflate.setLayoutParams(u);
            return new FrsNoListItemViewHolder(inflate, viewGroup);
        }
        return (FrsNoListItemViewHolder) invokeL.objValue;
    }

    public View f0(int i2, View view, ViewGroup viewGroup, s sVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, sVar, frsNoListItemViewHolder})) == null) {
            frsNoListItemViewHolder.f15443d.setText(R.string.no_data_common_txt);
            SkinManager.setViewTextColor(frsNoListItemViewHolder.f15443d, R.color.CAM_X0107, 1);
            SkinManager.setImageResource(frsNoListItemViewHolder.f15444e, R.drawable.new_pic_emotion_06);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
