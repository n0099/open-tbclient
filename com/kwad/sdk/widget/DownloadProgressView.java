package com.kwad.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes2.dex */
public class DownloadProgressView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextProgressBar a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59687b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f59688c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f59689d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f59690e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f59691f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    public int f59692g;

    /* renamed from: h  reason: collision with root package name */
    public int f59693h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f59694i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f59695j;

    /* renamed from: k  reason: collision with root package name */
    public String f59696k;
    public final KsAppDownloadListener l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadProgressView(@NonNull Context context) {
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
    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.l = new com.kwad.sdk.core.download.a.c(this) { // from class: com.kwad.sdk.widget.DownloadProgressView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DownloadProgressView f59697b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f59697b = this;
            }

            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i5) == null) {
                    this.f59697b.f59687b.setVisibility(8);
                    this.f59697b.a.setVisibility(0);
                    this.f59697b.a.a(com.kwad.sdk.core.response.a.a.a(), i5);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    DownloadProgressView downloadProgressView = this.f59697b;
                    downloadProgressView.f59687b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.f59689d));
                    this.f59697b.f59687b.setVisibility(0);
                    this.f59697b.a.setVisibility(8);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f59697b.f59687b.setVisibility(8);
                    this.f59697b.a.setVisibility(0);
                    DownloadProgressView downloadProgressView = this.f59697b;
                    downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(downloadProgressView.f59688c), this.f59697b.a.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    DownloadProgressView downloadProgressView = this.f59697b;
                    downloadProgressView.f59687b.setText(com.kwad.sdk.core.response.a.a.A(downloadProgressView.f59689d));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f59697b.f59687b.setVisibility(8);
                    this.f59697b.a.setVisibility(0);
                    DownloadProgressView downloadProgressView = this.f59697b;
                    downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.m(downloadProgressView.f59689d), this.f59697b.a.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i5) == null) {
                    this.f59697b.f59687b.setVisibility(8);
                    this.f59697b.a.setVisibility(0);
                    DownloadProgressView downloadProgressView = this.f59697b;
                    downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(i5, downloadProgressView.f59696k), i5);
                }
            }
        };
        a(context, attributeSet, i2);
        a(context);
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            FrameLayout.inflate(context, R.layout.ksad_download_progress_layout, this);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
            this.a = textProgressBar;
            textProgressBar.setTextDimen(this.f59693h);
            this.a.a(this.f59691f, this.f59692g);
            this.a.setProgressDrawable(this.f59694i);
            TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
            this.f59687b = textView;
            textView.setTextColor(this.f59690e);
            this.f59687b.setTextSize(0, this.f59693h);
            this.f59687b.setVisibility(0);
            this.f59687b.setBackground(this.f59695j);
            findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.widget.DownloadProgressView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadProgressView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.performClick();
                    }
                }
            });
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet, i2) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
            this.f59690e = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -45056);
            this.f59691f = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
            this.f59692g = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -45056);
            this.f59693h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.a.kwai.a.a(getContext(), 11.0f));
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
            this.f59694i = drawable;
            if (drawable == null) {
                this.f59694i = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
            this.f59695j = drawable2;
            if (drawable2 == null) {
                this.f59695j = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
            }
            String string = obtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
            this.f59696k = string;
            if (string == null) {
                this.f59696k = "下载中  %s%%";
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(AdInfo adInfo, int i2, int i3) {
        TextProgressBar textProgressBar;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, adInfo, i2, i3) == null) {
            if (i2 == 0) {
                this.f59687b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
                return;
            }
            if (i2 != 2) {
                if (i2 != 7) {
                    if (i2 == 8) {
                        this.f59687b.setVisibility(8);
                        this.a.setVisibility(0);
                        textProgressBar = this.a;
                        a = com.kwad.sdk.core.response.a.a.a(this.f59688c);
                        i3 = this.a.getMax();
                    } else if (i2 != 11) {
                        if (i2 != 12) {
                            return;
                        }
                        this.f59687b.setVisibility(8);
                        this.a.setVisibility(0);
                        this.a.a(com.kwad.sdk.core.response.a.a.m(adInfo), this.a.getMax());
                        return;
                    }
                }
                this.f59687b.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
                this.f59687b.setVisibility(0);
                this.a.setVisibility(8);
                return;
            }
            this.f59687b.setVisibility(8);
            this.a.setVisibility(0);
            textProgressBar = this.a;
            a = com.kwad.sdk.core.response.a.a.a(i3, this.f59696k);
            textProgressBar.a(a, i3);
        }
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adTemplate) == null) {
            this.f59688c = adTemplate;
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f59689d = j2;
            this.f59687b.setText(com.kwad.sdk.core.response.a.a.A(j2));
            this.a.setVisibility(8);
            this.f59687b.setVisibility(0);
        }
    }

    public KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (KsAppDownloadListener) invokeV.objValue;
    }
}
