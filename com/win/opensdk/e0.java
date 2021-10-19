package com.win.opensdk;

import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class e0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f77370a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f77371b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f77372c;

    public e0(byte[] bArr, String str, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, str, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77370a = bArr;
        this.f77371b = str;
        this.f77372c = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            byte[] bArr = this.f77370a;
            String str = this.f77371b;
            k kVar = this.f77372c;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            File file = new File(str);
            String substring = str.substring(0, str.lastIndexOf("/"));
            if (!file.exists()) {
                new File(substring).mkdir();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = byteArrayInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr2, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (kVar != null && (handler = kVar.f77429a.f77448b.k) != null) {
                    handler.post(new j(kVar));
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (kVar != null) {
                    return;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            if (kVar != null || (handler2 = kVar.f77429a.f77448b.k) == null) {
                return;
            }
            handler2.post(new i(kVar));
        }
    }
}
