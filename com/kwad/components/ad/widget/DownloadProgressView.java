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
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes5.dex */
public class DownloadProgressView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextProgressBar a;
    public TextView b;
    public AdTemplate c;
    public AdInfo d;
    @ColorInt
    public int e;
    @ColorInt
    public int f;
    @ColorInt
    public int g;
    public int h;
    public Drawable i;
    public Drawable j;
    public String k;
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
        this.l = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadProgressView a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.a.b.setVisibility(8);
                    this.a.a.setVisibility(0);
                    this.a.a.a(com.kwad.sdk.core.response.a.a.a(), i4);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    DownloadProgressView downloadProgressView = this.a;
                    downloadProgressView.b.setText(com.kwad.sdk.core.response.a.a.H(downloadProgressView.d));
                    this.a.b.setVisibility(0);
                    this.a.a.setVisibility(8);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.b.setVisibility(8);
                    this.a.a.setVisibility(0);
                    DownloadProgressView downloadProgressView = this.a;
                    downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(downloadProgressView.c), this.a.a.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    DownloadProgressView downloadProgressView = this.a;
                    downloadProgressView.b.setText(com.kwad.sdk.core.response.a.a.H(downloadProgressView.d));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.a.b.setVisibility(8);
                    this.a.a.setVisibility(0);
                    DownloadProgressView downloadProgressView = this.a;
                    downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.n(downloadProgressView.d), this.a.a.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    this.a.b.setVisibility(8);
                    this.a.a.setVisibility(0);
                    DownloadProgressView downloadProgressView = this.a;
                    downloadProgressView.a.a(com.kwad.sdk.core.response.a.a.a(i4, downloadProgressView.k), i4);
                }
            }
        };
        a(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0411, this);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f0910d0);
            this.a = textProgressBar;
            textProgressBar.setTextDimen(this.h);
            this.a.a(this.f, this.g);
            this.a.setProgressDrawable(this.i);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09109d);
            this.b = textView;
            textView.setTextColor(this.e);
            this.b.setTextSize(0, this.h);
            this.b.setVisibility(0);
            this.b.setBackground(this.j);
            findViewById(R.id.obfuscated_res_0x7f091049).setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.performClick();
                    }
                }
            });
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040347, R.attr.obfuscated_res_0x7f040362, R.attr.obfuscated_res_0x7f040363, R.attr.obfuscated_res_0x7f040364, R.attr.obfuscated_res_0x7f040365, R.attr.obfuscated_res_0x7f040366, R.attr.obfuscated_res_0x7f040375});
            this.e = obtainStyledAttributes.getColor(3, -117146);
            this.f = obtainStyledAttributes.getColor(1, -1);
            this.g = obtainStyledAttributes.getColor(2, -117146);
            this.h = obtainStyledAttributes.getDimensionPixelSize(4, com.kwad.sdk.b.kwai.a.a(getContext(), 11.0f));
            Drawable drawable = obtainStyledAttributes.getDrawable(6);
            this.i = drawable;
            if (drawable == null) {
                this.i = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bcb);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
            this.j = drawable2;
            if (drawable2 == null) {
                this.j = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bca);
            }
            String string = obtainStyledAttributes.getString(5);
            this.k = string;
            if (string == null) {
                this.k = "下载中  %s%%";
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void a(AdInfo adInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, adInfo, i, i2) == null) {
            if (i == 0) {
                this.b.setText(com.kwad.sdk.core.response.a.a.H(adInfo));
            } else if (i == 2) {
                this.b.setVisibility(8);
                this.a.setVisibility(0);
                this.a.a(com.kwad.sdk.core.response.a.a.a(i2, this.k), i2);
            } else {
                if (i != 7) {
                    if (i == 8) {
                        this.b.setVisibility(8);
                        this.a.setVisibility(0);
                        this.a.a(com.kwad.sdk.core.response.a.a.a(this.c), this.a.getMax());
                        return;
                    } else if (i != 11) {
                        if (i != 12) {
                            return;
                        }
                        this.b.setVisibility(8);
                        this.a.setVisibility(0);
                        this.a.a(com.kwad.sdk.core.response.a.a.n(adInfo), this.a.getMax());
                        return;
                    }
                }
                this.b.setText(com.kwad.sdk.core.response.a.a.H(adInfo));
                this.b.setVisibility(0);
                this.a.setVisibility(8);
            }
        }
    }

    public final void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.c = adTemplate;
            AdInfo i = d.i(adTemplate);
            this.d = i;
            this.b.setText(com.kwad.sdk.core.response.a.a.H(i));
            this.a.setVisibility(8);
            this.b.setVisibility(0);
        }
    }

    public KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (KsAppDownloadListener) invokeV.objValue;
    }
}
