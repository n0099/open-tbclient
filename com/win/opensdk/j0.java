package com.win.opensdk;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class j0 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k0 a;
    public final /* synthetic */ File b;
    public final /* synthetic */ Bitmap c;
    public final /* synthetic */ Bitmap.CompressFormat d;
    public final /* synthetic */ v e;

    public j0(File file, Bitmap bitmap, Bitmap.CompressFormat compressFormat, v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, bitmap, compressFormat, vVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = file;
        this.c = bitmap;
        this.d = compressFormat;
        this.e = vVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doInBackground(Object[] objArr) {
        InterceptResult invokeL;
        IOException e;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            Void[] voidArr = (Void[]) objArr;
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(this.b);
                    try {
                        try {
                            this.c.compress(this.d, 100, fileOutputStream);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            this.a = new k0(e);
                            cancel(true);
                            if (fileOutputStream != null) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = fileOutputStream;
                        th = th;
                        fileOutputStream2 = fileOutputStream3;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (IOException e5) {
                e = e5;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.a();
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            Void r5 = (Void) obj;
            this.e.b();
        }
    }
}
