package com.win.opensdk;

import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
/* loaded from: classes10.dex */
public class l extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PBDrawVideo c;

    public l(PBDrawVideo pBDrawVideo, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBDrawVideo, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = pBDrawVideo;
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
                    return M.d(str);
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
                PBDrawVideo pBDrawVideo = this.c;
                PBDrawVideoListener pBDrawVideoListener = pBDrawVideo.d;
                if (pBDrawVideoListener != null && !pBDrawVideo.f) {
                    pBDrawVideoListener.onFail(PBError.NO_RESUOURCE);
                    this.c.e = true;
                }
            } else {
                PBDrawVideo pBDrawVideo2 = this.c;
                if (pBDrawVideo2.d != null && !pBDrawVideo2.f) {
                    file = pBDrawVideo2.h;
                    M.a(bArr, file.getPath(), new k(this));
                }
            }
            if (bArr != null) {
                PBDrawVideo pBDrawVideo3 = this.c;
                if (pBDrawVideo3.f) {
                    pBDrawVideo3.h = new File(M.a(this.c.a) + File.separator + "win" + File.separator + M.c(this.b) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                    file2 = this.c.h;
                    M.a(bArr, file2.getPath(), (k) null);
                }
            }
        }
    }
}
