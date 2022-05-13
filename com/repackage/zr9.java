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
public class zr9 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ bp9 c;

    public zr9(bp9 bp9Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp9Var, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = bp9Var;
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
                    return ro9.F(str);
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
                bp9 bp9Var = this.c;
                cp9 cp9Var = bp9Var.c;
                if (cp9Var != null && !bp9Var.e) {
                    cp9Var.onFail(PBError.NO_RESUOURCE);
                    this.c.d = true;
                }
            } else {
                bp9 bp9Var2 = this.c;
                if (bp9Var2.c != null && !bp9Var2.e) {
                    file = bp9Var2.g;
                    ro9.t(bArr, file.getPath(), new vr9(this));
                }
            }
            if (bArr != null) {
                bp9 bp9Var3 = this.c;
                if (bp9Var3.e) {
                    bp9Var3.g = new File(ro9.e(this.c.a) + File.separator + "win" + File.separator + ro9.D(this.b) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                    file2 = this.c.g;
                    ro9.t(bArr, file2.getPath(), null);
                }
            }
        }
    }
}
