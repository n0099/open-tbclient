package com.win.opensdk;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes10.dex */
public class l extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f76712a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBDrawVideo f76713b;

    public l(PBDrawVideo pBDrawVideo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBDrawVideo, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76713b = pBDrawVideo;
        this.f76712a = str;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            String str = ((String[]) objArr)[0];
            if (str != null) {
                try {
                    return N.d(str);
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
        Context context;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            byte[] bArr = (byte[]) obj;
            if (bArr == null) {
                PBDrawVideo pBDrawVideo = this.f76713b;
                PBDrawVideoListener pBDrawVideoListener = pBDrawVideo.f76456c;
                if (pBDrawVideoListener != null && !pBDrawVideo.f76458e) {
                    pBDrawVideoListener.onFail(PBError.NO_RESUOURCE);
                    this.f76713b.f76457d = true;
                }
            } else {
                PBDrawVideo pBDrawVideo2 = this.f76713b;
                if (pBDrawVideo2.f76456c != null && !pBDrawVideo2.f76458e) {
                    file = pBDrawVideo2.f76460g;
                    N.a(bArr, file.getPath(), new k(this));
                }
            }
            if (bArr != null) {
                PBDrawVideo pBDrawVideo3 = this.f76713b;
                if (pBDrawVideo3.f76458e) {
                    StringBuilder sb = new StringBuilder();
                    context = this.f76713b.f76454a;
                    sb.append(N.a(context));
                    sb.append(File.separator);
                    sb.append("win");
                    sb.append(File.separator);
                    sb.append(N.c(this.f76712a));
                    sb.append(".mp4");
                    pBDrawVideo3.f76460g = new File(sb.toString());
                    file2 = this.f76713b.f76460g;
                    N.a(bArr, file2.getPath(), (k) null);
                }
            }
        }
    }
}
