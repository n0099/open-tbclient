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
/* loaded from: classes10.dex */
public final class k0 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l0 f77430a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f77431b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f77432c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f77433d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ w f77434e;

    public k0(File file, Bitmap bitmap, Bitmap.CompressFormat compressFormat, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, bitmap, compressFormat, wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77431b = file;
        this.f77432c = bitmap;
        this.f77433d = compressFormat;
        this.f77434e = wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doInBackground(Object[] objArr) {
        InterceptResult invokeL;
        IOException e2;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            Void[] voidArr = (Void[]) objArr;
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(this.f77431b);
                    try {
                        try {
                            this.f77432c.compress(this.f77433d, 100, fileOutputStream);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e2 = e3;
                            this.f77430a = new l0(e2);
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
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            } catch (IOException e6) {
                e2 = e6;
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
            this.f77434e.a();
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            Void r5 = (Void) obj;
            this.f77434e.b();
        }
    }
}
