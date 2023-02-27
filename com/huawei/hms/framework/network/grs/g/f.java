package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes8.dex */
public class f extends a implements Callable<d> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String i = "f";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, int i2, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo) {
        super(str, i2, cVar, context, str2, grsBaseInfo, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), cVar, context, str2, grsBaseInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (c) objArr2[2], (Context) objArr2[3], (String) objArr2[4], (GrsBaseInfo) objArr2[5], (com.huawei.hms.framework.network.grs.e.c) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x011a: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:64:0x011a */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010d  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d call() {
        InterceptResult invokeV;
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
        long j;
        long currentTimeMillis;
        long elapsedRealtime;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (d) invokeV.objValue;
        }
        Logger.i(i, "Get call execute");
        long j2 = 0;
        HttpsURLConnection httpsURLConnection3 = null;
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            try {
                try {
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        j2 = System.currentTimeMillis();
                        httpsURLConnection2 = com.huawei.hms.framework.network.grs.h.f.a.a(c(), a(), e());
                    } catch (IOException e) {
                        e = e;
                        httpsURLConnection2 = null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    httpsURLConnection2 = null;
                    j = 0;
                }
                try {
                } catch (IOException e3) {
                    e = e3;
                    long j3 = j2;
                    j2 = elapsedRealtime;
                    j = j3;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    currentTimeMillis = System.currentTimeMillis();
                    Logger.w(i, "RequestCallable run task catch IOException", e);
                    this.a = new d(e, elapsedRealtime2 - j2);
                    if (httpsURLConnection2 != null) {
                        try {
                            httpsURLConnection2.disconnect();
                        } catch (RuntimeException unused) {
                            j2 = j;
                            Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch RuntimeException");
                            this.a.b(c());
                            this.a.a(d());
                            this.a.b(j2);
                            this.a.a(currentTimeMillis);
                            if (b() != null) {
                            }
                            return this.a;
                        } catch (Throwable unused2) {
                            j2 = j;
                            Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch Throwable");
                            this.a.b(c());
                            this.a.a(d());
                            this.a.b(j2);
                            this.a.a(currentTimeMillis);
                            if (b() != null) {
                            }
                            return this.a;
                        }
                    }
                    j2 = j;
                    this.a.b(c());
                    this.a.a(d());
                    this.a.b(j2);
                    this.a.a(currentTimeMillis);
                    if (b() != null) {
                    }
                    return this.a;
                }
                if (httpsURLConnection2 == null) {
                    Logger.w(i, "create HttpsURLConnection instance by url return null.");
                    if (httpsURLConnection2 != null) {
                        try {
                            httpsURLConnection2.disconnect();
                        } catch (RuntimeException unused3) {
                            Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch RuntimeException");
                        } catch (Throwable unused4) {
                            Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch Throwable");
                        }
                    }
                    return null;
                }
                httpsURLConnection2.setRequestMethod("GET");
                String a = b() != null ? b().a() : "";
                if (TextUtils.isEmpty(a)) {
                    a = "&";
                }
                httpsURLConnection2.setRequestProperty("If-None-Match", a);
                httpsURLConnection2.connect();
                int responseCode = httpsURLConnection2.getResponseCode();
                if (responseCode == 200) {
                    try {
                        inputStream = httpsURLConnection2.getInputStream();
                        byte[] byteArray = IoUtils.toByteArray(inputStream);
                        IoUtils.closeSecure(inputStream);
                        bArr = byteArray;
                    } catch (Throwable th) {
                        IoUtils.closeSecure(inputStream);
                        throw th;
                    }
                }
                Map headerFields = httpsURLConnection2.getHeaderFields();
                httpsURLConnection2.disconnect();
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                currentTimeMillis = System.currentTimeMillis();
                this.a = new d(responseCode, headerFields, bArr == null ? new byte[0] : bArr, elapsedRealtime3 - elapsedRealtime);
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (RuntimeException unused5) {
                        Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch RuntimeException");
                        this.a.b(c());
                        this.a.a(d());
                        this.a.b(j2);
                        this.a.a(currentTimeMillis);
                        if (b() != null) {
                        }
                        return this.a;
                    } catch (Throwable unused6) {
                        Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch Throwable");
                        this.a.b(c());
                        this.a.a(d());
                        this.a.b(j2);
                        this.a.a(currentTimeMillis);
                        if (b() != null) {
                        }
                        return this.a;
                    }
                }
                this.a.b(c());
                this.a.a(d());
                this.a.b(j2);
                this.a.a(currentTimeMillis);
                if (b() != null) {
                    b().a(this.a);
                }
                return this.a;
            } catch (Throwable th2) {
                th = th2;
                if (httpsURLConnection3 != null) {
                    try {
                        httpsURLConnection3.disconnect();
                    } catch (RuntimeException unused7) {
                        Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch RuntimeException");
                    } catch (Throwable unused8) {
                        Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch Throwable");
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection3 = httpsURLConnection;
        }
    }
}
