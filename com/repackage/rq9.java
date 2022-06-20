package com.repackage;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class rq9 implements xo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Bitmap.CompressFormat a;
    public final /* synthetic */ em9 b;

    public rq9(em9 em9Var, Bitmap.CompressFormat compressFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {em9Var, compressFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = em9Var;
        this.a = compressFormat;
    }

    @Override // com.repackage.xo9
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.repackage.xo9
    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            em9 em9Var = this.b;
            if (!em9Var.j) {
                fm9 fm9Var = em9Var.e;
                if (fm9Var != null) {
                    em9Var.c = bitmap;
                    fm9Var.onLoaded();
                    em9.i(this.b, true);
                }
            } else if (em9Var.l.exists()) {
            } else {
                File file = this.b.l;
                nq9 nq9Var = new nq9(this);
                Bitmap.CompressFormat compressFormat = this.a;
                if (file.isDirectory()) {
                    new com.win.opensdk.k0("the specified path points to a directory, should be a file");
                } else if (file.exists()) {
                    new com.win.opensdk.k0("file already exists, write operation cancelled");
                } else {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists() && !parentFile.mkdirs()) {
                        new com.win.opensdk.k0("could not create parent directory");
                        return;
                    }
                    try {
                        if (file.createNewFile()) {
                            new qo9(file, bitmap, compressFormat, nq9Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        } else {
                            new com.win.opensdk.k0("could not create file");
                        }
                    } catch (IOException e) {
                        new com.win.opensdk.k0(e);
                    }
                }
            }
        }
    }

    @Override // com.repackage.xo9
    public void a(com.win.opensdk.k0 k0Var) {
        em9 em9Var;
        fm9 fm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k0Var) == null) || (fm9Var = (em9Var = this.b).e) == null || em9Var.j) {
            return;
        }
        fm9Var.onFail(PBError.NO_RESUOURCE);
        em9.i(this.b, true);
    }
}
