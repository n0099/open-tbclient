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
public class x implements m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f77218a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f77219b;

    public x(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBSplash, compressFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77219b = pBSplash;
        this.f77218a = compressFormat;
    }

    @Override // com.win.opensdk.m0
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // com.win.opensdk.m0
    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            PBSplash pBSplash = this.f77219b;
            if (!pBSplash.f76862j) {
                PBSplashListener pBSplashListener = pBSplash.f76857e;
                if (pBSplashListener != null) {
                    pBSplash.f76855c = bitmap;
                    pBSplashListener.onLoaded();
                    PBSplash.d(this.f77219b, true);
                }
            } else if (pBSplash.l.exists()) {
            } else {
                File file = this.f77219b.l;
                w wVar = new w(this);
                Bitmap.CompressFormat compressFormat = this.f77218a;
                if (file.isDirectory()) {
                    new l0("the specified path points to a directory, should be a file");
                } else if (file.exists()) {
                    new l0("file already exists, write operation cancelled");
                } else {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists() && !parentFile.mkdirs()) {
                        new l0("could not create parent directory");
                        return;
                    }
                    try {
                        if (file.createNewFile()) {
                            new k0(file, bitmap, compressFormat, wVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        } else {
                            new l0("could not create file");
                        }
                    } catch (IOException e2) {
                        new l0(e2);
                    }
                }
            }
        }
    }

    @Override // com.win.opensdk.m0
    public void a(l0 l0Var) {
        PBSplash pBSplash;
        PBSplashListener pBSplashListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l0Var) == null) || (pBSplashListener = (pBSplash = this.f77219b).f76857e) == null || pBSplash.f76862j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f77219b, true);
    }
}
