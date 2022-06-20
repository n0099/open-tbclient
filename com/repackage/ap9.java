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
/* loaded from: classes5.dex */
public class ap9 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ cm9 c;

    public ap9(cm9 cm9Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cm9Var, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = cm9Var;
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
        File file;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            byte[] bArr = (byte[]) obj;
            if (bArr == null) {
                cm9 cm9Var = this.c;
                dm9 dm9Var = cm9Var.c;
                if (dm9Var != null && !cm9Var.e) {
                    dm9Var.onFail(PBError.NO_RESUOURCE);
                    this.c.d = true;
                }
            } else {
                cm9 cm9Var2 = this.c;
                if (cm9Var2.c != null && !cm9Var2.e) {
                    file = cm9Var2.g;
                    sl9.t(bArr, file.getPath(), new wo9(this));
                }
            }
            if (bArr != null) {
                cm9 cm9Var3 = this.c;
                if (cm9Var3.e) {
                    cm9Var3.g = new File(sl9.e(this.c.a) + File.separator + "win" + File.separator + sl9.D(this.b) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                    file2 = this.c.g;
                    sl9.t(bArr, file2.getPath(), null);
                }
            }
        }
    }
}
