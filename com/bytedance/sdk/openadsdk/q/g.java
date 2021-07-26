package com.bytedance.sdk.openadsdk.q;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.k.a.a;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(@NonNull com.bytedance.sdk.openadsdk.k.a.b bVar);

        void b();
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.k.a aVar, int i2, a aVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, aVar, Integer.valueOf(i2), aVar2, Boolean.valueOf(z)}) == null) {
            com.bytedance.sdk.component.utils.k.f("splashLoadAd", " getImageBytes url " + aVar);
            com.bytedance.sdk.openadsdk.k.d.b().d().a(aVar, new a.b(aVar2) { // from class: com.bytedance.sdk.openadsdk.q.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f32509a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32509a = aVar2;
                }

                @Override // com.bytedance.sdk.openadsdk.k.a.a.b
                public void a(String str, com.bytedance.sdk.openadsdk.k.a.b bVar) {
                    a aVar3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
                        if (bVar.c() && (aVar3 = this.f32509a) != null) {
                            aVar3.a(bVar);
                            return;
                        }
                        a aVar4 = this.f32509a;
                        if (aVar4 != null) {
                            aVar4.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.k.a.a.b
                public void a(int i3, String str, @Nullable Throwable th) {
                    a aVar3;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, str, th) == null) || (aVar3 = this.f32509a) == null) {
                        return;
                    }
                    aVar3.a();
                }

                @Override // com.bytedance.sdk.openadsdk.k.a.a.b
                public void a() {
                    a aVar3;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar3 = this.f32509a) == null) {
                        return;
                    }
                    aVar3.b();
                }
            }, i2, i2, z);
        }
    }

    public static Drawable a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, bArr, i2)) == null) {
            if (bArr != null && bArr.length > 0) {
                try {
                    return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                } catch (Throwable unused) {
                    return new ColorDrawable(0);
                }
            }
            return new ColorDrawable(0);
        }
        return (Drawable) invokeLI.objValue;
    }
}
