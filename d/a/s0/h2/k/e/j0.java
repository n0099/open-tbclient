package d.a.s0.h2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class j0 extends o<d.a.s0.h2.h.l, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(d.a.s0.h2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.s0.h2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.s0.h2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (d.a.s0.h2.h.l) obj, (PbNoDataItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbNoDataItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbNoDataItemViewHolder(LayoutInflater.from(this.f44821e).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.f44821e) : (PbNoDataItemViewHolder) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.s0.h2.h.l lVar, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, pbNoDataItemViewHolder})) == null) {
            super.X(i2, view, viewGroup, lVar, pbNoDataItemViewHolder);
            this.p = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.f19117a.setText(lVar.D0);
            int i3 = lVar.C0;
            if (i3 != 0) {
                SkinManager.setImageResource(pbNoDataItemViewHolder.f19118b, i3);
            } else {
                SkinManager.setImageResource(pbNoDataItemViewHolder.f19118b, R.drawable.new_pic_emotion_06);
            }
            SkinManager.setViewTextColor(pbNoDataItemViewHolder.f19117a, R.color.CAM_X0109);
            if (lVar.E0 != 0 && view.getLayoutParams() != null) {
                view.getLayoutParams().height = lVar.E0;
            }
            if (lVar.F0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.f19118b.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, lVar.F0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (lVar.G0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.f19117a.getLayoutParams();
                int i4 = marginLayoutParams2.leftMargin;
                marginLayoutParams2.setMargins(i4, i4, marginLayoutParams2.rightMargin, lVar.G0);
            }
            pbNoDataItemViewHolder.f19118b.setVisibility(lVar.H0);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
