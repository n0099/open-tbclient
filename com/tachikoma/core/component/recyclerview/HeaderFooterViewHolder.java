package com.tachikoma.core.component.recyclerview;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaUnit;
import com.kwad.yoga.YogaValue;
import com.tachikoma.core.yoga.layout.YogaLayout;
/* loaded from: classes8.dex */
public class HeaderFooterViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public YogaValue mOriginHeight;
    public YogaValue mOriginWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderFooterViewHolder(@NonNull View view2, YogaValue yogaValue, YogaValue yogaValue2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, yogaValue, yogaValue2};
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
        this.mOriginWidth = yogaValue;
        this.mOriginHeight = yogaValue2;
    }

    public void maybeReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View view2 = this.itemView;
            if (view2 instanceof YogaLayout) {
                if (this.mOriginWidth.unit == YogaUnit.AUTO) {
                    ((YogaLayout) view2).getYogaNode().setWidthAuto();
                }
                if (this.mOriginHeight.unit == YogaUnit.AUTO) {
                    ((YogaLayout) this.itemView).getYogaNode().setHeightAuto();
                }
            }
        }
    }
}
