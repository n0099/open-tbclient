package d.a.q0.s0.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.manito.ManitoHeaderItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.u0.k;
/* loaded from: classes8.dex */
public class a extends k<b, ManitoHeaderItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.u0.k, d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i2, view, viewGroup, (b) obj, (ManitoHeaderItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: t0 */
    public ManitoHeaderItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new ManitoHeaderItemViewHolder(LayoutInflater.from(this.f42341e).inflate(R.layout.manito_item_header, (ViewGroup) null)) : (ManitoHeaderItemViewHolder) invokeL.objValue;
    }

    public View u0(int i2, View view, ViewGroup viewGroup, b bVar, ManitoHeaderItemViewHolder manitoHeaderItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, manitoHeaderItemViewHolder})) == null) {
            super.X(i2, view, viewGroup, bVar, manitoHeaderItemViewHolder);
            if (manitoHeaderItemViewHolder.f15272b != this.r) {
                SkinManager.setBackgroundColor(manitoHeaderItemViewHolder.a(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(manitoHeaderItemViewHolder.f15271a, R.color.CAM_X0105, 1);
            }
            manitoHeaderItemViewHolder.f15271a.setText(String.format(this.f42341e.getResources().getString(R.string.forum_manito_num), Integer.valueOf(bVar.b())));
            manitoHeaderItemViewHolder.f15272b = this.r;
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
