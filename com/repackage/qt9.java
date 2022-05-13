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
public class qt9 implements wr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Bitmap.CompressFormat a;
    public final /* synthetic */ dp9 b;

    public qt9(dp9 dp9Var, Bitmap.CompressFormat compressFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dp9Var, compressFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = dp9Var;
        this.a = compressFormat;
    }

    @Override // com.repackage.wr9
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.repackage.wr9
    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            dp9 dp9Var = this.b;
            if (!dp9Var.j) {
                ep9 ep9Var = dp9Var.e;
                if (ep9Var != null) {
                    dp9Var.c = bitmap;
                    ep9Var.onLoaded();
                    dp9.i(this.b, true);
                }
            } else if (dp9Var.l.exists()) {
            } else {
                File file = this.b.l;
                mt9 mt9Var = new mt9(this);
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
                            new pr9(file, bitmap, compressFormat, mt9Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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

    @Override // com.repackage.wr9
    public void a(com.win.opensdk.k0 k0Var) {
        dp9 dp9Var;
        ep9 ep9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k0Var) == null) || (ep9Var = (dp9Var = this.b).e) == null || dp9Var.j) {
            return;
        }
        ep9Var.onFail(PBError.NO_RESUOURCE);
        dp9.i(this.b, true);
    }
}
