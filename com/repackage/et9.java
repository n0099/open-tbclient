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
/* loaded from: classes6.dex */
public class et9 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ gq9 c;

    public et9(gq9 gq9Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gq9Var, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = gq9Var;
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
        File file;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            byte[] bArr = (byte[]) obj;
            if (bArr == null) {
                gq9 gq9Var = this.c;
                hq9 hq9Var = gq9Var.c;
                if (hq9Var != null && !gq9Var.e) {
                    hq9Var.onFail(PBError.NO_RESUOURCE);
                    this.c.d = true;
                }
            } else {
                gq9 gq9Var2 = this.c;
                if (gq9Var2.c != null && !gq9Var2.e) {
                    file = gq9Var2.g;
                    wp9.t(bArr, file.getPath(), new at9(this));
                }
            }
            if (bArr != null) {
                gq9 gq9Var3 = this.c;
                if (gq9Var3.e) {
                    gq9Var3.g = new File(wp9.e(this.c.a) + File.separator + "win" + File.separator + wp9.D(this.b) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                    file2 = this.c.g;
                    wp9.t(bArr, file2.getPath(), null);
                }
            }
        }
    }
}
