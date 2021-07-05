package com.kwad.sdk.contentalliance.tube.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.CustomActionBarBehavior;
/* loaded from: classes7.dex */
public class TubeProfileTitleBarBehavior extends CustomActionBarBehavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mLeftBackNormal;
    public ImageView mLeftBackShadow;
    public TextView mTitleTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TubeProfileTitleBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.lib.desigin.CustomActionBarBehavior
    public void initView(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, relativeLayout) == null) {
            if (this.mLeftBackNormal == null) {
                this.mLeftBackNormal = (ImageView) relativeLayout.findViewById(R.id.ksad_tube_detail_back_button);
            }
            if (this.mLeftBackShadow == null) {
                this.mLeftBackShadow = (ImageView) relativeLayout.findViewById(R.id.ksad_tube_detail_back_button_shadow);
            }
            if (this.mTitleTv == null) {
                this.mTitleTv = (TextView) relativeLayout.findViewById(R.id.ksad_tube_title);
            }
        }
    }

    @Override // com.kwad.sdk.lib.desigin.CustomActionBarBehavior
    @Keep
    public void onActionBarHeightChanged(RelativeLayout relativeLayout, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, relativeLayout, f2) == null) {
            super.onActionBarHeightChanged(relativeLayout, f2);
            float transRatio = transRatio(0.13f, 1.0f, f2);
            this.mLeftBackShadow.setAlpha(1.0f - transRatio);
            this.mLeftBackNormal.setAlpha(transRatio);
            this.mTitleTv.setAlpha(transRatio(0.58f, 1.0f, f2));
        }
    }
}
