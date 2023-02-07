package com.kwad.components.ad.widget;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public class DownloadProgressView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView Cl;
    @ColorInt
    public int Cm;
    @ColorInt
    public int Cn;
    @ColorInt
    public int Co;
    public int Cp;
    public Drawable Cq;
    public Drawable Cr;
    public String Cs;
    public TextProgressBar bZ;
    public final KsAppDownloadListener br;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.br = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadProgressView Ct;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Ct = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DownloadProgressView downloadProgressView = this.Ct;
                    downloadProgressView.Cl.setText(com.kwad.sdk.core.response.a.a.al(downloadProgressView.mAdInfo));
                    this.Ct.Cl.setVisibility(0);
                    this.Ct.bZ.setVisibility(8);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.Ct.Cl.setVisibility(8);
                    this.Ct.bZ.setVisibility(0);
                    DownloadProgressView downloadProgressView = this.Ct;
                    downloadProgressView.bZ.f(com.kwad.sdk.core.response.a.a.aJ(downloadProgressView.mAdTemplate), this.Ct.bZ.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    DownloadProgressView downloadProgressView = this.Ct;
                    downloadProgressView.Cl.setText(com.kwad.sdk.core.response.a.a.al(downloadProgressView.mAdInfo));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.Ct.Cl.setVisibility(8);
                    this.Ct.bZ.setVisibility(0);
                    DownloadProgressView downloadProgressView = this.Ct;
                    downloadProgressView.bZ.f(com.kwad.sdk.core.response.a.a.P(downloadProgressView.mAdInfo), this.Ct.bZ.getMax());
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) {
                    this.Ct.Cl.setVisibility(8);
                    this.Ct.bZ.setVisibility(0);
                    this.Ct.bZ.f(com.kwad.sdk.core.response.a.a.uU(), i4);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    this.Ct.Cl.setVisibility(8);
                    this.Ct.bZ.setVisibility(0);
                    DownloadProgressView downloadProgressView = this.Ct;
                    downloadProgressView.bZ.f(com.kwad.sdk.core.response.a.a.h(i4, downloadProgressView.Cs), i4);
                }
            }
        };
        a(context, attributeSet);
        E(context);
    }

    private void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0430, this);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09121d);
            this.bZ = textProgressBar;
            textProgressBar.setTextDimen(this.Cp);
            this.bZ.setTextColor(this.Cn, this.Co);
            this.bZ.setProgressDrawable(this.Cq);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0911ed);
            this.Cl = textView;
            textView.setTextColor(this.Cm);
            this.Cl.setTextSize(0, this.Cp);
            this.Cl.setVisibility(0);
            this.Cl.setBackground(this.Cr);
            findViewById(R.id.obfuscated_res_0x7f091199).setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadProgressView Ct;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Ct = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.Ct.performClick();
                    }
                }
            });
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.kwad.sdk.R.styleable.ksad_DownloadProgressView);
            this.Cm = obtainStyledAttributes.getColor(3, -117146);
            this.Cn = obtainStyledAttributes.getColor(1, -1);
            this.Co = obtainStyledAttributes.getColor(2, -117146);
            this.Cp = obtainStyledAttributes.getDimensionPixelSize(4, com.kwad.sdk.b.kwai.a.a(getContext(), 11.0f));
            Drawable drawable = obtainStyledAttributes.getDrawable(6);
            this.Cq = drawable;
            if (drawable == null) {
                this.Cq = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c6c);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
            this.Cr = drawable2;
            if (drawable2 == null) {
                this.Cr = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c6b);
            }
            String string = obtainStyledAttributes.getString(5);
            this.Cs = string;
            if (string == null) {
                this.Cs = "下载中  %s%%";
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void F(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            this.mAdTemplate = adTemplate;
            AdInfo bQ = d.bQ(adTemplate);
            this.mAdInfo = bQ;
            this.Cl.setText(com.kwad.sdk.core.response.a.a.al(bQ));
            this.bZ.setVisibility(8);
            this.Cl.setVisibility(0);
        }
    }

    public final void a(AdInfo adInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo, i, i2) == null) {
            if (i == 0) {
                this.Cl.setText(com.kwad.sdk.core.response.a.a.al(adInfo));
            } else if (i == 2) {
                this.Cl.setVisibility(8);
                this.bZ.setVisibility(0);
                this.bZ.f(com.kwad.sdk.core.response.a.a.h(i2, this.Cs), i2);
            } else {
                if (i != 7) {
                    if (i == 8) {
                        this.Cl.setVisibility(8);
                        this.bZ.setVisibility(0);
                        this.bZ.f(com.kwad.sdk.core.response.a.a.aJ(this.mAdTemplate), this.bZ.getMax());
                        return;
                    } else if (i != 11) {
                        if (i != 12) {
                            return;
                        }
                        this.Cl.setVisibility(8);
                        this.bZ.setVisibility(0);
                        this.bZ.f(com.kwad.sdk.core.response.a.a.P(adInfo), this.bZ.getMax());
                        return;
                    }
                }
                this.Cl.setText(com.kwad.sdk.core.response.a.a.al(adInfo));
                this.Cl.setVisibility(0);
                this.bZ.setVisibility(8);
            }
        }
    }

    public KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.br : (KsAppDownloadListener) invokeV.objValue;
    }
}
