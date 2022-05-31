package com.repackage;

import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.win.opensdk.PBError;
import java.io.File;
/* loaded from: classes7.dex */
public class to9 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ vl9 c;

    public to9(vl9 vl9Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vl9Var, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = vl9Var;
        this.a = j;
        this.b = str;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            String str = ((String[]) objArr)[0];
            if (str != null) {
                try {
                    return ll9.F(str);
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
        File file;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            byte[] bArr = (byte[]) obj;
            if (bArr == null) {
                vl9 vl9Var = this.c;
                wl9 wl9Var = vl9Var.c;
                if (wl9Var != null && !vl9Var.e) {
                    wl9Var.onFail(PBError.NO_RESUOURCE);
                    this.c.d = true;
                }
            } else {
                vl9 vl9Var2 = this.c;
                if (vl9Var2.c != null && !vl9Var2.e) {
                    file = vl9Var2.g;
                    ll9.t(bArr, file.getPath(), new po9(this));
                }
            }
            if (bArr != null) {
                vl9 vl9Var3 = this.c;
                if (vl9Var3.e) {
                    vl9Var3.g = new File(ll9.e(this.c.a) + File.separator + "win" + File.separator + ll9.D(this.b) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                    file2 = this.c.g;
                    ll9.t(bArr, file2.getPath(), null);
                }
            }
        }
    }
}
