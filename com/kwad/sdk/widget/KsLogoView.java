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
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes2.dex */
public class KsLogoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59750b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59751c;

    /* renamed from: d  reason: collision with root package name */
    public SimpleImageLoadingListener f59752d;

    /* renamed from: e  reason: collision with root package name */
    public a f59753e;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

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
        this.f59752d = new SimpleImageLoadingListener(this) { // from class: com.kwad.sdk.widget.KsLogoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsLogoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view, decodedResult) == null) || this.a.f59753e == null) {
                    return;
                }
                this.a.f59753e.a();
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, failReason) == null) {
                    this.a.a();
                    if (this.a.f59753e != null) {
                        this.a.f59753e.a();
                    }
                }
            }
        };
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
        this.f59752d = new SimpleImageLoadingListener(this) { // from class: com.kwad.sdk.widget.KsLogoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsLogoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
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

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view, decodedResult) == null) || this.a.f59753e == null) {
                    return;
                }
                this.a.f59753e.a();
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, failReason) == null) {
                    this.a.a();
                    if (this.a.f59753e != null) {
                        this.a.f59753e.a();
                    }
                }
            }
        };
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
        this.f59752d = new SimpleImageLoadingListener(this) { // from class: com.kwad.sdk.widget.KsLogoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsLogoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view, decodedResult) == null) || this.a.f59753e == null) {
                    return;
                }
                this.a.f59753e.a();
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, failReason) == null) {
                    this.a.a();
                    if (this.a.f59753e != null) {
                        this.a.f59753e.a();
                    }
                }
            }
        };
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
        this.f59752d = new SimpleImageLoadingListener(this) { // from class: com.kwad.sdk.widget.KsLogoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsLogoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view, decodedResult) == null) || this.a.f59753e == null) {
                    return;
                }
                this.a.f59753e.a();
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, failReason) == null) {
                    this.a.a();
                    if (this.a.f59753e != null) {
                        this.a.f59753e.a();
                    }
                }
            }
        };
        if (z) {
            setBackgroundResource(R.drawable.ksad_splash_logo_bg);
        }
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f59750b.setImageDrawable(getContext().getResources().getDrawable(this.f59751c ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
        }
    }

    private void a(Context context) {
        TextView textView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            LinearLayout.inflate(context, R.layout.ksad_logo_layout, this);
            this.a = (TextView) findViewById(R.id.ksad_logo_text);
            this.f59750b = (ImageView) findViewById(R.id.ksad_logo_icon);
            boolean z = getBackground() == null;
            this.f59751c = z;
            if (z) {
                this.f59750b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_gray));
                textView = this.a;
                i2 = -6513508;
            } else {
                this.f59750b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_white));
                textView = this.a;
                i2 = -1711276033;
            }
            textView.setTextColor(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r7 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
        r7.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
        if (r7 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(AdTemplate adTemplate) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, adTemplate) != null) {
            return;
        }
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        String str = this.f59751c ? j2.adBaseInfo.adGrayMarkIcon : j2.adBaseInfo.adMarkIcon;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(j2.adBaseInfo.adSourceDescription)) {
            if (TextUtils.isEmpty(j2.adBaseInfo.adSourceDescription)) {
                this.a.setVisibility(8);
                this.a.setText("");
            } else {
                this.a.setText(com.kwad.sdk.core.response.a.a.z(j2));
                this.a.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.f59750b.setVisibility(8);
                this.f59750b.setImageDrawable(null);
                aVar = this.f59753e;
            } else {
                KSImageLoader.loadFeeImage(this.f59750b, str, adTemplate, this.f59752d);
                this.f59750b.setVisibility(0);
            }
            findViewById.setVisibility(0);
            return;
        }
        this.a.setVisibility(0);
        this.a.setText(com.kwad.sdk.core.response.a.a.z(j2));
        this.f59750b.setVisibility(0);
        a();
        aVar = this.f59753e;
    }

    public ImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59750b : (ImageView) invokeV.objValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    public void setLogoLoadFinishListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f59753e = aVar;
        }
    }
}
