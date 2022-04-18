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
public class vu9 implements bt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Bitmap.CompressFormat a;
    public final /* synthetic */ iq9 b;

    public vu9(iq9 iq9Var, Bitmap.CompressFormat compressFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iq9Var, compressFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = iq9Var;
        this.a = compressFormat;
    }

    @Override // com.repackage.bt9
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.repackage.bt9
    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            iq9 iq9Var = this.b;
            if (!iq9Var.j) {
                jq9 jq9Var = iq9Var.e;
                if (jq9Var != null) {
                    iq9Var.c = bitmap;
                    jq9Var.onLoaded();
                    iq9.i(this.b, true);
                }
            } else if (iq9Var.l.exists()) {
            } else {
                File file = this.b.l;
                ru9 ru9Var = new ru9(this);
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
                            new us9(file, bitmap, compressFormat, ru9Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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

    @Override // com.repackage.bt9
    public void a(com.win.opensdk.k0 k0Var) {
        iq9 iq9Var;
        jq9 jq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k0Var) == null) || (jq9Var = (iq9Var = this.b).e) == null || iq9Var.j) {
            return;
        }
        jq9Var.onFail(PBError.NO_RESUOURCE);
        iq9.i(this.b, true);
    }
}
