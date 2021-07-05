package com.kwad.sdk.contentalliance.tube.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
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
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class EpisodePhotoView extends com.kwad.sdk.widget.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f35806a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35807b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f35808c;

    /* renamed from: d  reason: collision with root package name */
    public PhotoInfo f35809d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f35810e;

    /* renamed from: f  reason: collision with root package name */
    public int f35811f;

    /* renamed from: g  reason: collision with root package name */
    public long f35812g;

    /* renamed from: h  reason: collision with root package name */
    public float f35813h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f35814i;
    public Path j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EpisodePhotoView(@NonNull Context context) {
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
        setLayerType(1, null);
        this.f35813h = ao.a(context, 4.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EpisodePhotoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        setLayerType(1, null);
        this.f35813h = ao.a(context, 4.0f);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            String g2 = d.g(this.f35809d);
            if (TextUtils.isEmpty(g2)) {
                g2 = d.d(this.f35809d);
            }
            KSImageLoader.loadImage(this.f35806a, g2, this.f35808c, KSImageLoader.IMGOPTION_TUBE);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f35810e.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.widget.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            e.a(this.f35808c);
        }
    }

    public void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f35811f = i2;
            this.f35812g = j;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f35806a = (ImageView) findViewById(R.id.ksad_tube_trend_episode_cover);
            this.f35810e = (FrameLayout) findViewById(R.id.ksad_tube_trend_episode_more);
            this.f35807b = (TextView) findViewById(R.id.ksad_tube_trend_episode_name);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            int save = canvas.save();
            RectF rectF = this.f35814i;
            if (rectF == null) {
                this.j = new Path();
                this.f35814i = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            } else {
                rectF.right = canvas.getWidth();
                this.f35814i.bottom = canvas.getHeight();
                this.j.reset();
            }
            float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            float f2 = this.f35813h;
            fArr[0] = f2;
            fArr[1] = f2;
            fArr[2] = f2;
            fArr[3] = f2;
            fArr[4] = f2;
            fArr[5] = f2;
            fArr[6] = f2;
            fArr[7] = f2;
            this.j.addRoundRect(this.f35814i, fArr, Path.Direction.CW);
            canvas.clipPath(this.j);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35811f : invokeV.intValue;
    }

    public AdTemplate getTemplateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35808c : (AdTemplate) invokeV.objValue;
    }

    public long getTubeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35812g : invokeV.longValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishInflate();
            b();
        }
    }

    public void setLookMoreVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.f35810e.setVisibility(0);
                this.f35807b.setVisibility(8);
                return;
            }
            this.f35810e.setVisibility(8);
            this.f35807b.setVisibility(0);
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f35813h = f2;
            invalidate();
        }
    }

    public void setTemplateData(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adTemplate) == null) {
            this.f35808c = adTemplate;
            PhotoInfo k = c.k(adTemplate);
            this.f35809d = k;
            if (k == null) {
                return;
            }
            d();
            c();
            this.f35807b.setText(d.B(this.f35809d));
            this.f35807b.setVisibility(0);
        }
    }
}
