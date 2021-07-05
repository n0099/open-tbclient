package com.kwad.sdk.glide.load.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.StreamEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class t implements com.kwad.sdk.glide.load.a<InputStream> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f37909a;

    public t(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37909a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(@NonNull InputStream inputStream, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inputStream, file, eVar)) == null) {
            byte[] bArr = (byte[]) this.f37909a.a(65536, byte[].class);
            boolean z = false;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            } catch (IOException e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                if (Log.isLoggable(StreamEncoder.TAG, 3)) {
                                    Log.d(StreamEncoder.TAG, "Failed to encode data onto the OutputStream", e);
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                this.f37909a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                                return z;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                this.f37909a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                                throw th;
                            }
                        }
                        fileOutputStream2.close();
                        z = true;
                        fileOutputStream2.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException unused2) {
            }
            this.f37909a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            return z;
        }
        return invokeLLL.booleanValue;
    }
}
