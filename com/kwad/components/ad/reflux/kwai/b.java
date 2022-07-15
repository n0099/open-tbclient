package com.kwad.components.ad.reflux.kwai;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context) {
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
    }

    @Override // com.kwad.components.ad.reflux.kwai.a
    public final void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0447, this);
            ((a) this).a = (TextView) findViewById(R.id.obfuscated_res_0x7f0910dd);
            ((a) this).e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910db);
            ((a) this).f = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0910dc);
            ((a) this).d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910d6);
            ((a) this).b = (TextView) findViewById(R.id.obfuscated_res_0x7f0910d7);
            ((a) this).c = (TextView) findViewById(R.id.obfuscated_res_0x7f0910d4);
            ((a) this).g = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0910de);
            ((a) this).h = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f0910d5);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910d9);
        }
    }

    @Override // com.kwad.components.ad.reflux.kwai.a
    public final void a(com.kwad.components.ad.reflux.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            super.a(aVar);
            if (aVar == null || aVar.c() == null || this.i == null) {
                return;
            }
            ImageLoaderProxy.INSTANCE.load(getContext(), aVar.h(), this.i, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener(this) { // from class: com.kwad.components.ad.reflux.kwai.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str, inputStream, decodedResult)) == null) {
                        decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                        return true;
                    }
                    return invokeLLL.booleanValue;
                }
            });
        }
    }
}
