package d.a.p0.h2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbVideoDetailBrowseModeEmotionHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class s0 extends o<d.a.p0.h2.h.q, PbVideoDetailBrowseModeEmotionHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(d.a.p0.h2.o.b bVar, BdUniqueId bdUniqueId) {
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
                super((d.a.p0.h2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbVideoDetailBrowseModeEmotionHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View view = LayoutInflater.from(this.f41837e).inflate(R.layout.video_detail_pb_browse_mode_emotion, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(view, "view");
            return new PbVideoDetailBrowseModeEmotionHolder(view);
        }
        return (PbVideoDetailBrowseModeEmotionHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public void Y(int i2, ViewGroup viewGroup, PbVideoDetailBrowseModeEmotionHolder pbVideoDetailBrowseModeEmotionHolder, d.a.p0.h2.h.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), viewGroup, pbVideoDetailBrowseModeEmotionHolder, qVar}) == null) {
            super.Y(i2, viewGroup, pbVideoDetailBrowseModeEmotionHolder, qVar);
            if (pbVideoDetailBrowseModeEmotionHolder != null) {
                pbVideoDetailBrowseModeEmotionHolder.b();
                pbVideoDetailBrowseModeEmotionHolder.c(this.s);
            }
        }
    }

    public final void j0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
