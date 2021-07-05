package d.a.s0.h2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class x extends o<y, PbImageAlaRecommendVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId s;
    public d.a.s0.h2.h.e t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(d.a.s0.h2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, y.u);
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
        this.s = bdUniqueId;
    }

    @Override // d.a.s0.h2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (y) obj, (PbImageAlaRecommendVH) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbImageAlaRecommendVH Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbImageAlaRecommendVH(LayoutInflater.from(this.f44821e).inflate(R.layout.pb_image_ala_recomment_layout, viewGroup, false), this.m.getPageContext(), this.s) : (PbImageAlaRecommendVH) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, y yVar, PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, yVar, pbImageAlaRecommendVH})) == null) {
            super.X(i2, view, viewGroup, yVar, pbImageAlaRecommendVH);
            if (pbImageAlaRecommendVH != null) {
                pbImageAlaRecommendVH.d(yVar);
                pbImageAlaRecommendVH.i(this.t);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.t = eVar;
        }
    }
}
