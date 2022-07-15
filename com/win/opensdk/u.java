package com.win.opensdk;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class u extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;
    public final /* synthetic */ PBSplash b;

    public u(PBSplash pBSplash, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBSplash, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = pBSplash;
        this.a = str;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            String str = ((String[]) objArr)[0];
            if (str != null) {
                try {
                    return M.d(str);
                } catch (OutOfMemoryError unused) {
                    return null;
                }
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            byte[] bArr = (byte[]) obj;
            if (bArr == null) {
                PBSplash pBSplash = this.b;
                PBSplashListener pBSplashListener = pBSplash.e;
                if (pBSplashListener != null && !pBSplash.j) {
                    pBSplashListener.onFail(PBError.NO_RESUOURCE);
                    this.b.i = true;
                }
            } else {
                PBSplash pBSplash2 = this.b;
                PBSplashListener pBSplashListener2 = pBSplash2.e;
                if (pBSplashListener2 != null && !pBSplash2.j) {
                    pBSplash2.m = bArr;
                    pBSplashListener2.onLoaded();
                    this.b.i = true;
                }
            }
            if (bArr != null) {
                PBSplash pBSplash3 = this.b;
                if (pBSplash3.j) {
                    StringBuilder sb = new StringBuilder();
                    context = this.b.a;
                    sb.append(M.a(context));
                    sb.append(File.separator);
                    sb.append("win");
                    sb.append(File.separator);
                    sb.append(M.c(this.a));
                    sb.append(".gif");
                    pBSplash3.p = new File(sb.toString());
                    new Thread(new G1(bArr, this.b.p.getPath())).start();
                }
            }
        }
    }
}
