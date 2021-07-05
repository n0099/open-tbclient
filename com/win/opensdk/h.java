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
/* loaded from: classes7.dex */
public class h extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f42569a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f42570b;

    public h(PBSplash pBSplash, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBSplash, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42570b = pBSplash;
        this.f42569a = str;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            String str = ((String[]) objArr)[0];
            if (str != null) {
                try {
                    return z.d(str);
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
                PBSplash pBSplash = this.f42570b;
                PBSplashListener pBSplashListener = pBSplash.f42432e;
                if (pBSplashListener != null && !pBSplash.j) {
                    pBSplashListener.onFail(PBError.NO_RESUOURCE);
                    this.f42570b.f42436i = true;
                }
            } else {
                PBSplash pBSplash2 = this.f42570b;
                PBSplashListener pBSplashListener2 = pBSplash2.f42432e;
                if (pBSplashListener2 != null && !pBSplash2.j) {
                    pBSplash2.m = bArr;
                    pBSplashListener2.onLoaded();
                    this.f42570b.f42436i = true;
                }
            }
            if (bArr != null) {
                PBSplash pBSplash3 = this.f42570b;
                if (pBSplash3.j) {
                    StringBuilder sb = new StringBuilder();
                    context = this.f42570b.f42428a;
                    sb.append(z.a(context));
                    sb.append(File.separator);
                    sb.append("win");
                    sb.append(File.separator);
                    sb.append(z.c(this.f42569a));
                    sb.append(".gif");
                    pBSplash3.p = new File(sb.toString());
                    new Thread(new Z0(bArr, this.f42570b.p.getPath())).start();
                }
            }
        }
    }
}
