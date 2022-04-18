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
public class nu9 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;
    public final /* synthetic */ iq9 b;

    public nu9(iq9 iq9Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iq9Var, str};
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
                    return wp9.F(str);
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
                iq9 iq9Var = this.b;
                jq9 jq9Var = iq9Var.e;
                if (jq9Var != null && !iq9Var.j) {
                    jq9Var.onFail(PBError.NO_RESUOURCE);
                    this.b.i = true;
                }
            } else {
                iq9 iq9Var2 = this.b;
                jq9 jq9Var2 = iq9Var2.e;
                if (jq9Var2 != null && !iq9Var2.j) {
                    iq9Var2.m = bArr;
                    jq9Var2.onLoaded();
                    this.b.i = true;
                }
            }
            if (bArr != null) {
                iq9 iq9Var3 = this.b;
                if (iq9Var3.j) {
                    StringBuilder sb = new StringBuilder();
                    context = this.b.a;
                    sb.append(wp9.e(context));
                    sb.append(File.separator);
                    sb.append("win");
                    sb.append(File.separator);
                    sb.append(wp9.D(this.a));
                    sb.append(".gif");
                    iq9Var3.p = new File(sb.toString());
                    new Thread(new dp9(bArr, this.b.p.getPath())).start();
                }
            }
        }
    }
}
