package com.repackage;

import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class sq9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ String b;
    public final /* synthetic */ vr9 c;

    public sq9(byte[] bArr, String str, vr9 vr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, str, vr9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bArr;
        this.b = str;
        this.c = vr9Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            byte[] bArr = this.a;
            String str = this.b;
            vr9 vr9Var = this.c;
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
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
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
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (vr9Var != null && (handler = vr9Var.a.c.k) != null) {
                    handler.post(new sr9(vr9Var));
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (vr9Var != null) {
                    return;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
            if (vr9Var != null || (handler2 = vr9Var.a.c.k) == null) {
                return;
            }
            handler2.post(new or9(vr9Var));
        }
    }
}
