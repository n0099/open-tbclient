package com.repackage;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class h implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final d.a b;
    public volatile int c;
    public volatile long d;

    public h(String str, d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = aVar;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d("RtcDownSo", "execute connnection");
            this.d = System.currentTimeMillis();
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (ProtocolException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    httpURLConnection.setConnectTimeout(4000);
                    httpURLConnection.setReadTimeout(4000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Range", "bytes=0-");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        c(httpURLConnection, false);
                    } else if (responseCode == 206) {
                        c(httpURLConnection, true);
                    } else {
                        Log.d("RtcDownSo", "UnSupported response code:" + responseCode);
                        throw new DownloadException(108, "UnSupported response code:" + responseCode);
                    }
                    httpURLConnection.disconnect();
                } catch (ProtocolException e3) {
                    e = e3;
                    e.printStackTrace();
                    throw new DownloadException(108, "Protocol error", e);
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    throw new DownloadException(108, "IO error", e);
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (MalformedURLException e5) {
                throw new DownloadException(108, "Bad url.", e5);
            }
        }
    }

    public final void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.b) {
                        this.c = 106;
                        ((m) this.b).h();
                    }
                    return;
                case 107:
                    synchronized (this.b) {
                        this.c = 107;
                        ((m) this.b).e();
                    }
                    return;
                case 108:
                    synchronized (this.b) {
                        this.c = 108;
                        ((m) this.b).c(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void c(HttpURLConnection httpURLConnection, boolean z) {
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, httpURLConnection, z) == null) {
            Log.d("RtcDownSo", "start parse response");
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            if (!TextUtils.isEmpty(headerField) && !headerField.equals("0") && !headerField.equals("-1")) {
                contentLength = Long.parseLong(headerField);
            } else {
                contentLength = httpURLConnection.getContentLength();
            }
            if (contentLength <= 0) {
                String headerField2 = httpURLConnection.getHeaderField("Ohc-File-Size");
                if (!TextUtils.isEmpty(headerField2) && !headerField2.equals("0") && !headerField2.equals("-1")) {
                    contentLength = Long.parseLong(headerField2);
                } else {
                    contentLength = httpURLConnection.getContentLength();
                }
                if (contentLength <= 0) {
                    throw new DownloadException(108, "length <= 0");
                }
            }
            if (!d()) {
                if (!e()) {
                    this.c = 103;
                    long currentTimeMillis = System.currentTimeMillis() - this.d;
                    m mVar = (m) this.b;
                    if (((h) mVar.i).d()) {
                        mVar.e();
                        return;
                    }
                    mVar.g = 103;
                    g gVar = mVar.b;
                    gVar.b.s(currentTimeMillis);
                    gVar.b.j(z);
                    gVar.b.r(103);
                    gVar.a.a(gVar.b);
                    mVar.h.b(z);
                    mVar.h.c = contentLength;
                    mVar.g = 104;
                    mVar.j.clear();
                    if (z) {
                        ArrayList<k> arrayList = new ArrayList();
                        int a = mVar.e.a();
                        int i = 0;
                        while (i < a) {
                            long j = contentLength / a;
                            long j2 = j * i;
                            arrayList.add(new k(i, mVar.d, mVar.a.c(), j2, i == a + (-1) ? contentLength : (j + j2) - 1, 0L));
                            i++;
                        }
                        int i2 = 0;
                        for (k kVar : arrayList) {
                            i2 = (int) (i2 + kVar.d);
                        }
                        mVar.h.a(i2);
                        for (k kVar2 : arrayList) {
                            mVar.j.add(new j(mVar.h, kVar2, mVar));
                        }
                    } else {
                        mVar.j.add(new l(mVar.h, new k(0, mVar.d, mVar.a.c(), 0L, 0L, 0L), mVar));
                    }
                    for (e eVar : mVar.j) {
                        mVar.c.execute(eVar);
                    }
                    return;
                }
                throw new DownloadException(106, "Connection Paused!");
            }
            throw new DownloadException(107, "Connection Canceled!");
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c == 107 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c == 106 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Process.setThreadPriority(10);
            this.c = 102;
            m mVar = (m) this.b;
            mVar.g = 102;
            g gVar = mVar.b;
            gVar.b.r(102);
            gVar.a.a(gVar.b);
            try {
                a();
            } catch (DownloadException e) {
                b(e);
            }
        }
    }
}
