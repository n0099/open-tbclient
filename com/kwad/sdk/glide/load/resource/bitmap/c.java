package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.kwad.sdk.glide.load.EncodeStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.glide.load.g<Bitmap> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Integer> f38208a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Bitmap.CompressFormat> f38209b;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f38210c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-32649541, "Lcom/kwad/sdk/glide/load/resource/bitmap/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-32649541, "Lcom/kwad/sdk/glide/load/resource/bitmap/c;");
                return;
            }
        }
        f38208a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        f38209b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    @Deprecated
    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38210c = null;
    }

    public c(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38210c = bVar;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, bitmap, eVar)) == null) {
            Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) eVar.a(f38209b);
            return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        return (Bitmap.CompressFormat) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.g
    @NonNull
    public EncodeStrategy a(@NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? EncodeStrategy.TRANSFORMED : (EncodeStrategy) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (r6 != null) goto L16;
     */
    @Override // com.kwad.sdk.glide.load.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NonNull com.kwad.sdk.glide.load.engine.s<Bitmap> sVar, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar, file, eVar)) != null) {
            return invokeLLL.booleanValue;
        }
        Bitmap e2 = sVar.e();
        Bitmap.CompressFormat a2 = a(e2, eVar);
        com.kwad.sdk.glide.g.a.b.a("encode: [%dx%d] %s", Integer.valueOf(e2.getWidth()), Integer.valueOf(e2.getHeight()), a2);
        try {
            long a3 = com.kwad.sdk.glide.g.f.a();
            int intValue = ((Integer) eVar.a(f38208a)).intValue();
            boolean z = false;
            com.kwad.sdk.glide.load.a.c cVar = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e3) {
                e = e3;
            }
            try {
                cVar = this.f38210c != null ? new com.kwad.sdk.glide.load.a.c(fileOutputStream, this.f38210c) : fileOutputStream;
                e2.compress(a2, intValue, cVar);
                cVar.close();
                z = true;
            } catch (IOException e4) {
                e = e4;
                cVar = fileOutputStream;
                if (Log.isLoggable(BitmapEncoder.TAG, 3)) {
                    Log.d(BitmapEncoder.TAG, "Failed to encode Bitmap", e);
                }
            } catch (Throwable th2) {
                th = th2;
                cVar = fileOutputStream;
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            try {
                cVar.close();
            } catch (IOException unused2) {
                if (Log.isLoggable(BitmapEncoder.TAG, 2)) {
                    Log.v(BitmapEncoder.TAG, "Compressed with type: " + a2 + " of size " + com.kwad.sdk.glide.g.k.a(e2) + " in " + com.kwad.sdk.glide.g.f.a(a3) + ", options format: " + eVar.a(f38209b) + ", hasAlpha: " + e2.hasAlpha());
                }
                return z;
            }
        } finally {
            com.kwad.sdk.glide.g.a.b.a();
        }
    }
}
