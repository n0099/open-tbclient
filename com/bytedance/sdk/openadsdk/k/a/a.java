package com.bytedance.sdk.openadsdk.k.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.ILoaderListener;
import com.bytedance.sdk.component.image.ImageResponse;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bytedance.sdk.openadsdk.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1916a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1916a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.k.a.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.k.a.a.b
        public void a(int i2, String str, @Nullable Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, th) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.k.a.a.b
        public void a(String str, com.bytedance.sdk.openadsdk.k.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a();

        void a(int i2, String str, @Nullable Throwable th);

        void a(String str, com.bytedance.sdk.openadsdk.k.a.b bVar);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static C1916a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C1916a() : (C1916a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void a(com.bytedance.sdk.openadsdk.k.a aVar, b bVar, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{aVar, bVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            a(aVar, bVar, i2, i3, ImageView.ScaleType.CENTER_INSIDE, z);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.k.a aVar, b bVar, int i2, int i3, ImageView.ScaleType scaleType, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{aVar, bVar, Integer.valueOf(i2), Integer.valueOf(i3), scaleType, Boolean.valueOf(z)}) == null) {
            ImageLoaderWrapper.from(aVar.f67582a).key(aVar.f67583b).width(i2).height(i3).config(Bitmap.Config.RGB_565).scaleType(scaleType).requestTime(z).to(new ILoaderListener(this, bVar) { // from class: com.bytedance.sdk.openadsdk.k.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f67584a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f67585b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67585b = this;
                    this.f67584a = bVar;
                }

                @Override // com.bytedance.sdk.component.image.ILoaderListener
                public void onFailed(int i4, String str, @Nullable Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i4, str, th) == null) {
                        this.f67585b.a(i4, str, th, this.f67584a);
                    }
                }

                @Override // com.bytedance.sdk.component.image.ILoaderListener
                public void onSuccess(ImageResponse imageResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageResponse) == null) {
                        this.f67585b.a(imageResponse, this.f67584a);
                    }
                }
            });
            a();
        }
    }

    public void a(ImageResponse imageResponse, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageResponse, bVar) == null) {
            if (bVar != null) {
                Object result = imageResponse.getResult();
                if (result instanceof byte[]) {
                    bVar.a(imageResponse.getUrl(), new com.bytedance.sdk.openadsdk.k.a.b((byte[]) result));
                } else if (result instanceof Bitmap) {
                    bVar.a(imageResponse.getUrl(), new com.bytedance.sdk.openadsdk.k.a.b((Bitmap) result));
                } else {
                    bVar.a(0, "not bitmap or gif result!", null);
                }
            }
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void a(int i2, String str, @Nullable Throwable th, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, th, bVar}) == null) || bVar == null) {
            return;
        }
        bVar.a(i2, str, th);
    }
}
