package com.kwad.components.core.widget;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class KsLogoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public boolean c;
    public SimpleImageLoadingListener d;
    public a e;

    /* loaded from: classes5.dex */
    public interface a {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new SimpleImageLoadingListener(this) { // from class: com.kwad.components.core.widget.KsLogoView.1
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view2, decodedResult) == null) || this.a.e == null) {
                    return;
                }
                a unused = this.a.e;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, failReason) == null) {
                    this.a.a();
                    if (this.a.e != null) {
                        a unused = this.a.e;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new SimpleImageLoadingListener(this) { // from class: com.kwad.components.core.widget.KsLogoView.1
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view2, decodedResult) == null) || this.a.e == null) {
                    return;
                }
                a unused = this.a.e;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, failReason) == null) {
                    this.a.a();
                    if (this.a.e != null) {
                        a unused = this.a.e;
                    }
                }
            }
        };
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.d = new SimpleImageLoadingListener(this) { // from class: com.kwad.components.core.widget.KsLogoView.1
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
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view2, decodedResult) == null) || this.a.e == null) {
                    return;
                }
                a unused = this.a.e;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, failReason) == null) {
                    this.a.a();
                    if (this.a.e != null) {
                        a unused = this.a.e;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.d = new SimpleImageLoadingListener(this) { // from class: com.kwad.components.core.widget.KsLogoView.1
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
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, view2, decodedResult) == null) || this.a.e == null) {
                    return;
                }
                a unused = this.a.e;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, failReason) == null) {
                    this.a.a();
                    if (this.a.e != null) {
                        a unused = this.a.e;
                    }
                }
            }
        };
        if (z) {
            setBackgroundResource(R.drawable.obfuscated_res_0x7f080c3e);
        }
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.b.setImageDrawable(getContext().getResources().getDrawable(this.c ? R.drawable.obfuscated_res_0x7f080bf5 : R.drawable.obfuscated_res_0x7f080bf6));
        }
    }

    private void a(Context context) {
        TextView textView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0438, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091092);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f091091);
            boolean z = getBackground() == null;
            this.c = z;
            if (z) {
                this.b.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bf5));
                textView = this.a;
                i = -6513508;
            } else {
                this.b.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bf6));
                textView = this.a;
                i = -1711276033;
            }
            textView.setTextColor(i);
        }
    }

    public final void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091090);
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            String str = this.c ? i.adBaseInfo.adGrayMarkIcon : i.adBaseInfo.adMarkIcon;
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(i.adBaseInfo.adSourceDescription)) {
                this.a.setVisibility(0);
                this.a.setText(com.kwad.sdk.core.response.a.a.G(i));
                this.b.setVisibility(0);
                a();
                a aVar = this.e;
            } else {
                if (TextUtils.isEmpty(i.adBaseInfo.adSourceDescription)) {
                    this.a.setVisibility(8);
                    this.a.setText("");
                } else {
                    this.a.setText(com.kwad.sdk.core.response.a.a.G(i));
                    this.a.setVisibility(0);
                }
                if (TextUtils.isEmpty(str)) {
                    this.b.setVisibility(8);
                    this.b.setImageDrawable(null);
                } else {
                    KSImageLoader.loadFeeImage(this.b, str, adTemplate, this.d);
                    this.b.setVisibility(0);
                }
            }
            findViewById.setVisibility(0);
        }
    }

    public ImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (ImageView) invokeV.objValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    public void setLogoLoadFinishListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.e = aVar;
        }
    }
}
