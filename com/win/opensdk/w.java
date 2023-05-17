package com.win.opensdk;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public class w implements l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Bitmap.CompressFormat a;
    public final /* synthetic */ PBSplash b;

    public w(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBSplash, compressFormat};
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
        this.a = compressFormat;
    }

    @Override // com.win.opensdk.l0
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.win.opensdk.l0
    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            PBSplash pBSplash = this.b;
            if (!pBSplash.j) {
                PBSplashListener pBSplashListener = pBSplash.e;
                if (pBSplashListener != null) {
                    pBSplash.c = bitmap;
                    pBSplashListener.onLoaded();
                    PBSplash.d(this.b, true);
                }
            } else if (!pBSplash.l.exists()) {
                File file = this.b.l;
                v vVar = new v(this);
                Bitmap.CompressFormat compressFormat = this.a;
                if (file.isDirectory()) {
                    new k0("the specified path points to a directory, should be a file");
                } else if (file.exists()) {
                    new k0("file already exists, write operation cancelled");
                } else {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists() && !parentFile.mkdirs()) {
                        new k0("could not create parent directory");
                        return;
                    }
                    try {
                        if (!file.createNewFile()) {
                            new k0("could not create file");
                        } else {
                            new j0(file, bitmap, compressFormat, vVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        }
                    } catch (IOException e) {
                        new k0(e);
                    }
                }
            }
        }
    }

    @Override // com.win.opensdk.l0
    public void a(k0 k0Var) {
        PBSplash pBSplash;
        PBSplashListener pBSplashListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k0Var) == null) && (pBSplashListener = (pBSplash = this.b).e) != null && !pBSplash.j) {
            pBSplashListener.onFail(PBError.NO_RESUOURCE);
            PBSplash.d(this.b, true);
        }
    }
}
