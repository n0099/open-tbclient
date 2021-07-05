package com.bytedance.sdk.openadsdk.r;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.l.a.b;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(@NonNull com.bytedance.sdk.openadsdk.l.a.d dVar);

        void b();
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.l.b bVar, int i2, a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, bVar, Integer.valueOf(i2), aVar, Boolean.valueOf(z)}) == null) {
            com.bytedance.sdk.component.utils.j.f("splashLoadAd", " getImageBytes url " + bVar);
            com.bytedance.sdk.openadsdk.l.e.b().e().a(bVar, new b.InterfaceC0354b(aVar) { // from class: com.bytedance.sdk.openadsdk.r.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f32213a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32213a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
                public void a(b.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
                public void a(String str, com.bytedance.sdk.openadsdk.l.a.d dVar) {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, dVar) == null) {
                        if (dVar.c() && (aVar2 = this.f32213a) != null) {
                            aVar2.a(dVar);
                            return;
                        }
                        a aVar3 = this.f32213a;
                        if (aVar3 != null) {
                            aVar3.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
                public void b(b.c cVar) {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048580, this, cVar) == null) || (aVar2 = this.f32213a) == null) {
                        return;
                    }
                    aVar2.a();
                }

                @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
                public void b() {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || (aVar2 = this.f32213a) == null) {
                        return;
                    }
                    aVar2.b();
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
