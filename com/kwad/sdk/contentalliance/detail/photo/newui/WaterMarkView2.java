package com.kwad.sdk.contentalliance.detail.photo.newui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.g.a.a;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class WaterMarkView2 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f34838a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WaterMarkView2(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaterMarkView2(Context context, AttributeSet attributeSet) {
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.ksad_video_water_mark_2, (ViewGroup) this, true);
            this.f34838a = (TextView) findViewById(R.id.ksad_video_water_mark_text);
        }
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, drawable) == null) || drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, ao.a(getContext(), 40.0f), ao.a(getContext(), 16.0f));
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.g.a.a
    public void setAlignment(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f34838a.getLayoutParams();
            layoutParams.gravity = i2 == 1 ? 5 : 3;
            this.f34838a.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.g.a.a
    public void setAuthorId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            TextView textView = this.f34838a;
            if (i2 == 0) {
                textView.setVisibility(4);
            } else {
                textView.setVisibility(0);
            }
            this.f34838a.setText(String.format("＠%d", Long.valueOf(j)));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.ksad_water_logo);
            setDrawableBounds(drawable);
            this.f34838a.setCompoundDrawablePadding(ao.a(getContext(), 2.0f));
            this.f34838a.setCompoundDrawables(drawable, null, null, null);
        }
    }
}
