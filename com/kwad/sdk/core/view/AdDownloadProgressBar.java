package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class AdDownloadProgressBar extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36728a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36729b;

    /* renamed from: c  reason: collision with root package name */
    public View f36730c;

    /* renamed from: d  reason: collision with root package name */
    public a f36731d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.view.a f36732e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f36733f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f36734g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f36735h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f36736i;
    public int j;

    /* renamed from: com.kwad.sdk.core.view.AdDownloadProgressBar$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdDownloadProgressBar f36737a;

        /* renamed from: b  reason: collision with root package name */
        public float f36738b;

        /* renamed from: c  reason: collision with root package name */
        public String f36739c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f36740d;

        public a(AdDownloadProgressBar adDownloadProgressBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adDownloadProgressBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36737a = adDownloadProgressBar;
            this.f36738b = -1.0f;
            this.f36740d = false;
        }

        public /* synthetic */ a(AdDownloadProgressBar adDownloadProgressBar, AnonymousClass1 anonymousClass1) {
            this(adDownloadProgressBar);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f36740d || this.f36738b < 0.0f) {
                    this.f36737a.f36729b.setText(this.f36739c);
                    return;
                }
                this.f36737a.f36729b.setText(this.f36739c);
                if (this.f36737a.f36732e != null) {
                    this.f36737a.f36728a.setImageDrawable(this.f36737a.f36732e);
                    this.f36737a.f36732e.a(this.f36738b);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdDownloadProgressBar(@NonNull Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f36731d = new a(this, null);
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            b();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.ksad_download_progress_bar, (ViewGroup) this, true);
            this.f36729b = (TextView) findViewById(R.id.ksad_status_tv);
            this.f36730c = findViewById(R.id.ksad_click_mask);
            this.f36728a = (ImageView) findViewById(R.id.ksad_progress_bg);
            setRadius(ao.a(getContext(), 2.0f));
            this.f36730c.setBackgroundResource(R.drawable.ksad_download_progress_mask_bg);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f36729b.setCompoundDrawablePadding(0);
            this.f36729b.setCompoundDrawables(null, null, null, null);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            setDrawableBounds(this.f36733f);
            setDrawableBounds(this.f36734g);
            setDrawableBounds(this.f36735h);
            setDrawableBounds(this.f36736i);
            this.f36729b.setCompoundDrawablePadding(this.j);
            this.f36729b.setCompoundDrawables(this.f36733f, this.f36734g, this.f36735h, this.f36736i);
        }
    }

    private void setDrawableBounds(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, drawable) == null) || drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    public void a(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{drawable, drawable2, drawable3, drawable4, Integer.valueOf(i2)}) == null) {
            this.f36733f = drawable;
            this.f36734g = drawable2;
            this.f36735h = drawable3;
            this.f36736i = drawable4;
            this.j = i2;
            d();
        }
    }

    public void a(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f2) == null) {
            this.f36731d.f36740d = true;
            this.f36731d.f36739c = str;
            this.f36731d.f36738b = f2;
            this.f36731d.a();
            c();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            View view = this.f36730c;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
    }

    public void setProgressDrawable(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f36728a.setBackgroundColor(i2);
            super.setBackground(null);
            super.setForeground(null);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f36731d.f36740d = false;
            this.f36731d.f36739c = str;
            this.f36731d.a();
            d();
        }
    }

    public void setTextColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f36729b.setTextColor(i2);
        }
    }

    public void setTextIncludeFontPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f36729b.setIncludeFontPadding(z);
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.f36729b.setTextSize(f2);
        }
    }

    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, typeface) == null) {
            this.f36729b.getPaint().setTypeface(typeface);
        }
    }
}
