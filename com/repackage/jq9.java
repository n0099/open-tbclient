package com.repackage;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import java.io.File;
/* loaded from: classes6.dex */
public class jq9 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;
    public final /* synthetic */ em9 b;

    public jq9(em9 em9Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {em9Var, str};
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
                    return sl9.F(str);
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
                em9 em9Var = this.b;
                fm9 fm9Var = em9Var.e;
                if (fm9Var != null && !em9Var.j) {
                    fm9Var.onFail(PBError.NO_RESUOURCE);
                    this.b.i = true;
                }
            } else {
                em9 em9Var2 = this.b;
                fm9 fm9Var2 = em9Var2.e;
                if (fm9Var2 != null && !em9Var2.j) {
                    em9Var2.m = bArr;
                    fm9Var2.onLoaded();
                    this.b.i = true;
                }
            }
            if (bArr != null) {
                em9 em9Var3 = this.b;
                if (em9Var3.j) {
                    StringBuilder sb = new StringBuilder();
                    context = this.b.a;
                    sb.append(sl9.e(context));
                    sb.append(File.separator);
                    sb.append("win");
                    sb.append(File.separator);
                    sb.append(sl9.D(this.a));
                    sb.append(".gif");
                    em9Var3.p = new File(sb.toString());
                    new Thread(new zk9(bArr, this.b.p.getPath())).start();
                }
            }
        }
    }
}
