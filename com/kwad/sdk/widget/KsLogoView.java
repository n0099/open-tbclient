package com.kwad.sdk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes2.dex */
public class KsLogoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f66766a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f66767b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66768c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsLogoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsLogoView(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (z) {
            setBackgroundResource(R.drawable.ksad_splash_logo_bg);
        }
        a(context);
    }

    private void a(Context context) {
        TextView textView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            LinearLayout.inflate(context, R.layout.ksad_logo_layout, this);
            this.f66766a = (TextView) findViewById(R.id.ksad_logo_text);
            this.f66767b = (ImageView) findViewById(R.id.ksad_logo_icon);
            boolean z = getBackground() == null;
            this.f66768c = z;
            if (z) {
                this.f66767b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_gray));
                textView = this.f66766a;
                i2 = -6513508;
            } else {
                this.f66767b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_white));
                textView = this.f66766a;
                i2 = -1711276033;
            }
            textView.setTextColor(i2);
        }
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            View findViewById = findViewById(R.id.ksad_logo_container);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            if (TextUtils.isEmpty(i2.adBaseInfo.adSourceDescription)) {
                this.f66766a.setVisibility(8);
                this.f66766a.setText("");
            } else {
                this.f66766a.setText(com.kwad.sdk.core.response.b.a.t(i2));
                this.f66766a.setVisibility(0);
            }
            String str = this.f66768c ? i2.adBaseInfo.adGrayMarkIcon : i2.adBaseInfo.adMarkIcon;
            if (TextUtils.isEmpty(str)) {
                this.f66767b.setVisibility(8);
                this.f66767b.setImageDrawable(null);
            } else {
                KSImageLoader.loadFeeImage(this.f66767b, str, adTemplate);
                this.f66767b.setVisibility(0);
            }
            findViewById.setVisibility(0);
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(i2.adBaseInfo.adSourceDescription)) {
                this.f66766a.setVisibility(0);
                this.f66766a.setText(com.kwad.sdk.core.response.b.a.t(i2));
                this.f66767b.setVisibility(0);
                this.f66767b.setImageDrawable(getContext().getResources().getDrawable(this.f66768c ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
            }
        }
    }

    public ImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66767b : (ImageView) invokeV.objValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66766a : (TextView) invokeV.objValue;
    }
}
