package com.tencent.open.a;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimer;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static g a;
    public transient /* synthetic */ FieldHolder $fh;
    public Random b;
    public List<Serializable> c;
    public List<Serializable> d;
    public HandlerThread e;
    public Handler f;
    public Executor g;
    public Executor h;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.b = new Random();
        this.d = Collections.synchronizedList(new ArrayList());
        this.c = Collections.synchronizedList(new ArrayList());
        this.g = j.b();
        this.h = j.b();
        if (this.e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e = handlerThread;
            handlerThread.start();
        }
        if (this.e.isAlive() && this.e.getLooper() != null) {
            this.f = new Handler(this, this.e.getLooper()) { // from class: com.tencent.open.a.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = objArr;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((Looper) newInitContext2.callArgs[0]);
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        int i3 = message.what;
                        if (i3 != 1000) {
                            if (i3 == 1001) {
                                this.a.e();
                            }
                        } else {
                            this.a.b();
                        }
                        super.handleMessage(message);
                    }
                }
            };
        }
    }

    public static synchronized g a() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g();
                }
                gVar = a;
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h.execute(new Runnable(this) { // from class: com.tencent.open.a.g.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /*  JADX ERROR: IF instruction can be used only in fallback mode
                    jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
                    	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:686)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:544)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:302)
                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    */
                @Override // java.lang.Runnable
                public void run() {
                    /*
                        r14 = this;
                        com.baidu.titan.sdk.runtime.Interceptable r0 = com.tencent.open.a.g.AnonymousClass4.$ic
                        if (r0 != 0) goto Lc3
                    L4:
                        java.lang.String r0 = "report_cgi"
                        java.lang.String r1 = "https://wspeed.qq.com/w.cgi"
                        java.lang.String r2 = "-->doReportCgi, doupload exception"
                        java.lang.String r3 = "openSDK_LOG.ReportManager"
                        com.tencent.open.a.g r4 = r14.a     // Catch: java.lang.Exception -> Lbc
                        android.os.Bundle r4 = r4.c()     // Catch: java.lang.Exception -> Lbc
                        if (r4 != 0) goto L15
                        return
                    L15:
                        android.content.Context r5 = com.tencent.open.utils.f.a()     // Catch: java.lang.Exception -> Lbc
                        r6 = 0
                        com.tencent.open.utils.g r5 = com.tencent.open.utils.g.a(r5, r6)     // Catch: java.lang.Exception -> Lbc
                        java.lang.String r7 = "Common_HttpRetryCount"
                        int r5 = r5.a(r7)     // Catch: java.lang.Exception -> Lbc
                        if (r5 != 0) goto L27
                        r5 = 3
                    L27:
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbc
                        r7.<init>()     // Catch: java.lang.Exception -> Lbc
                        java.lang.String r8 = "-->doReportCgi, retryCount: "
                        r7.append(r8)     // Catch: java.lang.Exception -> Lbc
                        r7.append(r5)     // Catch: java.lang.Exception -> Lbc
                        java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> Lbc
                        com.tencent.open.log.SLog.d(r3, r7)     // Catch: java.lang.Exception -> Lbc
                        r7 = 0
                        r8 = 0
                    L3d:
                        r9 = 1
                        int r8 = r8 + r9
                        android.content.Context r10 = com.tencent.open.utils.f.a()     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        org.apache.http.client.HttpClient r10 = com.tencent.open.utils.HttpUtils.getHttpClient(r10, r6, r1)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        org.apache.http.client.methods.HttpPost r11 = new org.apache.http.client.methods.HttpPost     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        r11.<init>(r1)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        java.lang.String r12 = "Accept-Encoding"
                        java.lang.String r13 = "gzip"
                        r11.addHeader(r12, r13)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        java.lang.String r12 = "Content-Type"
                        java.lang.String r13 = "application/x-www-form-urlencoded"
                        r11.setHeader(r12, r13)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        java.lang.String r12 = com.tencent.open.utils.HttpUtils.encodeUrl(r4)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        byte[] r12 = com.tencent.open.utils.l.i(r12)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        org.apache.http.entity.ByteArrayEntity r13 = new org.apache.http.entity.ByteArrayEntity     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        r13.<init>(r12)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        r11.setEntity(r13)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        org.apache.http.HttpResponse r10 = r10.execute(r11)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        org.apache.http.StatusLine r10 = r10.getStatusLine()     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        int r10 = r10.getStatusCode()     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        r11.<init>()     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        java.lang.String r12 = "-->doReportCgi, statusCode: "
                        r11.append(r12)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        r11.append(r10)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        com.tencent.open.log.SLog.d(r3, r11)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        r11 = 200(0xc8, float:2.8E-43)
                        if (r10 != r11) goto La7
                        com.tencent.open.a.f r10 = com.tencent.open.a.f.a()     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        r10.b(r0)     // Catch: java.lang.Exception -> L97 java.net.SocketTimeoutException -> L9c org.apache.http.conn.ConnectTimeoutException -> La1
                        r7 = 1
                        goto La7
                    L97:
                        r1 = move-exception
                        com.tencent.open.log.SLog.e(r3, r2, r1)     // Catch: java.lang.Exception -> Lbc
                        goto La7
                    L9c:
                        r9 = move-exception
                        com.tencent.open.log.SLog.e(r3, r2, r9)     // Catch: java.lang.Exception -> Lbc
                        goto La5
                    La1:
                        r9 = move-exception
                        com.tencent.open.log.SLog.e(r3, r2, r9)     // Catch: java.lang.Exception -> Lbc
                    La5:
                        if (r8 < r5) goto L3d
                    La7:
                        if (r7 != 0) goto Lb4
                        com.tencent.open.a.f r1 = com.tencent.open.a.f.a()     // Catch: java.lang.Exception -> Lbc
                        com.tencent.open.a.g r2 = r14.a     // Catch: java.lang.Exception -> Lbc
                        java.util.List<java.io.Serializable> r2 = r2.c     // Catch: java.lang.Exception -> Lbc
                        r1.a(r0, r2)     // Catch: java.lang.Exception -> Lbc
                    Lb4:
                        com.tencent.open.a.g r0 = r14.a     // Catch: java.lang.Exception -> Lbc
                        java.util.List<java.io.Serializable> r0 = r0.c     // Catch: java.lang.Exception -> Lbc
                        r0.clear()     // Catch: java.lang.Exception -> Lbc
                        goto Lc2
                    Lbc:
                        r0 = move-exception
                        java.lang.String r1 = "-->doReportCgi, doupload exception out."
                        com.tencent.open.log.SLog.e(r3, r1, r0)
                    Lc2:
                        return
                    Lc3:
                        r12 = r0
                        r13 = 1048576(0x100000, float:1.469368E-39)
                        com.baidu.titan.sdk.runtime.InterceptResult r0 = r12.invokeV(r13, r14)
                        if (r0 == 0) goto L4
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.AnonymousClass4.run():void");
                }
            });
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g.execute(new Runnable(this) { // from class: com.tencent.open.a.g.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[Catch: Exception -> 0x00f6, TRY_ENTER, TryCatch #7 {Exception -> 0x00f6, blocks: (B:5:0x0008, B:8:0x0011, B:35:0x00b5, B:38:0x00c7, B:40:0x00da, B:39:0x00cf, B:23:0x0070, B:28:0x008a, B:32:0x009f, B:33:0x00a9, B:11:0x003c, B:12:0x004e, B:16:0x0058, B:19:0x0063), top: B:53:0x0008, inners: #10, #8, #7 }] */
                /* JADX WARN: Removed duplicated region for block: B:39:0x00cf A[Catch: Exception -> 0x00f6, TryCatch #7 {Exception -> 0x00f6, blocks: (B:5:0x0008, B:8:0x0011, B:35:0x00b5, B:38:0x00c7, B:40:0x00da, B:39:0x00cf, B:23:0x0070, B:28:0x008a, B:32:0x009f, B:33:0x00a9, B:11:0x003c, B:12:0x004e, B:16:0x0058, B:19:0x0063), top: B:53:0x0008, inners: #10, #8, #7 }] */
                /* JADX WARN: Removed duplicated region for block: B:56:0x00b5 A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    int i;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Bundle d = this.a.d();
                            if (d == null) {
                                return;
                            }
                            SLog.v("openSDK_LOG.ReportManager", "-->doReportVia, params: " + d.toString());
                            int a2 = e.a();
                            int i2 = 0;
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            boolean z = false;
                            int i3 = 0;
                            long j = 0;
                            long j2 = 0;
                            do {
                                int i4 = i2 + 1;
                                try {
                                    try {
                                        try {
                                            l.a openUrl2 = HttpUtils.openUrl2(com.tencent.open.utils.f.a(), "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", d);
                                            try {
                                                i = l.d(openUrl2.a).getInt(Constants.KEYS.RET);
                                            } catch (JSONException unused) {
                                                i = -4;
                                            }
                                            if (i == 0 || !TextUtils.isEmpty(openUrl2.a)) {
                                                i4 = a2;
                                                z = true;
                                            }
                                            j = openUrl2.b;
                                            j2 = openUrl2.c;
                                            i2 = i4;
                                            continue;
                                        } catch (JSONException unused2) {
                                            i2 = i4;
                                            i3 = -4;
                                            j = 0;
                                            j2 = 0;
                                            continue;
                                            if (i2 >= a2) {
                                                int i5 = i3;
                                                this.a.a("mapp_apptrace_sdk", elapsedRealtime, j, j2, i5, null, false);
                                                if (!z) {
                                                }
                                                this.a.d.clear();
                                                SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
                                            }
                                        }
                                    } catch (HttpUtils.NetworkUnavailableException unused3) {
                                        this.a.d.clear();
                                        SLog.d("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                                        return;
                                    } catch (IOException e) {
                                        i3 = HttpUtils.getErrorCodeFromException(e);
                                        i2 = i4;
                                        j = 0;
                                        j2 = 0;
                                        continue;
                                        if (i2 >= a2) {
                                        }
                                    }
                                } catch (HttpUtils.HttpStatusException e2) {
                                    try {
                                        i3 = Integer.parseInt(e2.getMessage().replace(HttpUtils.HttpStatusException.ERROR_INFO, ""));
                                    } catch (Exception unused4) {
                                    }
                                } catch (SocketTimeoutException unused5) {
                                    elapsedRealtime = SystemClock.elapsedRealtime();
                                    i2 = i4;
                                    i3 = -8;
                                    j = 0;
                                    j2 = 0;
                                    continue;
                                    if (i2 >= a2) {
                                    }
                                } catch (ConnectTimeoutException unused6) {
                                    elapsedRealtime = SystemClock.elapsedRealtime();
                                    i2 = i4;
                                    i3 = -7;
                                    j = 0;
                                    j2 = 0;
                                    continue;
                                    if (i2 >= a2) {
                                    }
                                } catch (Exception unused7) {
                                    i2 = a2;
                                    i3 = -6;
                                    j = 0;
                                    j2 = 0;
                                    continue;
                                    if (i2 >= a2) {
                                    }
                                }
                            } while (i2 >= a2);
                            int i52 = i3;
                            this.a.a("mapp_apptrace_sdk", elapsedRealtime, j, j2, i52, null, false);
                            if (!z) {
                                f.a().b("report_via");
                            } else {
                                f.a().a("report_via", this.a.d);
                            }
                            this.a.d.clear();
                            SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
                        } catch (Exception e3) {
                            SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e3);
                        }
                    }
                }
            });
        }
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == 0) {
                int a2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencySuccess");
                if (a2 == 0) {
                    return 10;
                }
                return a2;
            }
            int a3 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencyFailed");
            if (a3 == 0) {
                return 100;
            }
            return a3;
        }
        return invokeI.intValue;
    }

    public void a(Bundle bundle, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, str, z) != null) || bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (!a("report_via", str) && !z) {
            return;
        }
        this.g.execute(new Runnable(this, bundle, z) { // from class: com.tencent.open.a.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bundle a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ g c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bundle, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = this;
                this.a = bundle;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        String k = l.k(c.b(com.tencent.open.utils.f.a()));
                        String k2 = l.k(c.c(com.tencent.open.utils.f.a()));
                        String k3 = l.k(c.a());
                        String k4 = l.k(c.d(com.tencent.open.utils.f.a()));
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", com.tencent.connect.common.Constants.DEFAULT_UIN);
                        bundle2.putString("imei", k);
                        bundle2.putString(BaseStatisContent.IMSI, k2);
                        bundle2.putString(HttpRequest.ANDROID_ID, k4);
                        bundle2.putString("mac", k3);
                        bundle2.putString(com.tencent.connect.common.Constants.PARAM_PLATFORM, "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString(CriusAttrConstants.POSITION, "");
                        bundle2.putString("network", a.a(com.tencent.open.utils.f.a()));
                        bundle2.putString("language", c.b());
                        bundle2.putString("resolution", c.a(com.tencent.open.utils.f.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.f.a()));
                        bundle2.putString("model_name", Build.MODEL);
                        bundle2.putString(BaseStatisContent.TIMEZONE, TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", com.tencent.connect.common.Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", l.d(com.tencent.open.utils.f.a(), com.tencent.connect.common.Constants.PACKAGE_QZONE));
                        bundle2.putString("qq_ver", l.c(com.tencent.open.utils.f.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", l.e(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.f.b());
                        bundle2.putString("app_ver", l.d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        if (this.a != null) {
                            bundle2.putAll(this.a);
                        }
                        this.c.d.add(new b(bundle2));
                        int size = this.c.d.size();
                        int a2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a2 == 0) {
                            a2 = 10000;
                        }
                        if (!this.c.a("report_via", size) && !this.b) {
                            if (!this.c.f.hasMessages(1001)) {
                                Message obtain = Message.obtain();
                                obtain.what = 1001;
                                this.c.f.sendMessageDelayed(obtain, a2);
                                return;
                            }
                            return;
                        }
                        this.c.e();
                        this.c.f.removeMessages(1001);
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                    }
                }
            }
        });
    }

    public void a(String str, long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            a(str, j, j2, j3, i, "", false);
        }
    }

    public void a(String str, long j, long j2, long j3, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
            if (!a("report_cgi", "" + i) && !z) {
                return;
            }
            this.h.execute(new Runnable(this, j, str, str2, i, j2, j3, z) { // from class: com.tencent.open.a.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ String b;
                public final /* synthetic */ String c;
                public final /* synthetic */ int d;
                public final /* synthetic */ long e;
                public final /* synthetic */ long f;
                public final /* synthetic */ boolean g;
                public final /* synthetic */ g h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, Long.valueOf(j), str, str2, Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.h = this;
                    this.a = j;
                    this.b = str;
                    this.c = str2;
                    this.d = i;
                    this.e = j2;
                    this.f = j3;
                    this.g = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            long elapsedRealtime = SystemClock.elapsedRealtime() - this.a;
                            Bundle bundle = new Bundle();
                            String a2 = a.a(com.tencent.open.utils.f.a());
                            bundle.putString("apn", a2);
                            bundle.putString("appid", "1000067");
                            bundle.putString("commandid", this.b);
                            bundle.putString("detail", this.c);
                            StringBuilder sb = new StringBuilder();
                            sb.append("network=");
                            sb.append(a2);
                            sb.append('&');
                            sb.append("sdcard=");
                            int i3 = 1;
                            if (Environment.getExternalStorageState().equals("mounted")) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            sb.append(i2);
                            sb.append('&');
                            sb.append("wifi=");
                            sb.append(a.e(com.tencent.open.utils.f.a()));
                            bundle.putString(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, sb.toString());
                            int a3 = 100 / this.h.a(this.d);
                            if (a3 > 0) {
                                if (a3 > 100) {
                                    i3 = 100;
                                } else {
                                    i3 = a3;
                                }
                            }
                            bundle.putString(FetchTimer.FREQUENCY, i3 + "");
                            bundle.putString("reqSize", this.e + "");
                            bundle.putString("resultCode", this.d + "");
                            bundle.putString("rspSize", this.f + "");
                            bundle.putString("timeCost", elapsedRealtime + "");
                            bundle.putString("uin", com.tencent.connect.common.Constants.DEFAULT_UIN);
                            this.h.c.add(new b(bundle));
                            int size = this.h.c.size();
                            int a4 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                            if (a4 == 0) {
                                a4 = 10000;
                            }
                            if (!this.h.a("report_cgi", size) && !this.g) {
                                if (!this.h.f.hasMessages(1000)) {
                                    Message obtain = Message.obtain();
                                    obtain.what = 1000;
                                    this.h.f.sendMessageDelayed(obtain, a4);
                                }
                            }
                            this.h.b();
                            this.h.f.removeMessages(1000);
                        } catch (Exception e) {
                            SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
                        }
                    }
                }
            });
        }
    }

    public void a(String str, String str2, Bundle bundle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, bundle, Boolean.valueOf(z)}) == null) {
            j.a(new Runnable(this, bundle, str, z, str2) { // from class: com.tencent.open.a.g.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bundle a;
                public final /* synthetic */ String b;
                public final /* synthetic */ boolean c;
                public final /* synthetic */ String d;
                public final /* synthetic */ g e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bundle, str, Boolean.valueOf(z), str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = bundle;
                    this.b = str;
                    this.c = z;
                    this.d = str2;
                }

                /* JADX WARN: Removed duplicated region for block: B:109:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:128:0x0139 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:87:0x013b A[Catch: Exception -> 0x015e, TRY_ENTER, TryCatch #10 {Exception -> 0x015e, blocks: (B:5:0x0008, B:7:0x000c, B:9:0x0012, B:12:0x0019, B:14:0x0042, B:15:0x0046, B:17:0x0054, B:21:0x008a, B:87:0x013b, B:88:0x0141, B:37:0x00da, B:73:0x011e, B:97:0x0157, B:96:0x0154, B:18:0x0068, B:20:0x0076, B:98:0x0158, B:91:0x0149, B:93:0x014f), top: B:111:0x0008, inners: #8 }] */
                /* JADX WARN: Removed duplicated region for block: B:88:0x0141 A[Catch: Exception -> 0x015e, TRY_LEAVE, TryCatch #10 {Exception -> 0x015e, blocks: (B:5:0x0008, B:7:0x000c, B:9:0x0012, B:12:0x0019, B:14:0x0042, B:15:0x0046, B:17:0x0054, B:21:0x008a, B:87:0x013b, B:88:0x0141, B:37:0x00da, B:73:0x011e, B:97:0x0157, B:96:0x0154, B:18:0x0068, B:20:0x0076, B:98:0x0158, B:91:0x0149, B:93:0x014f), top: B:111:0x0008, inners: #8 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    HttpUriRequest httpUriRequest;
                    HttpResponse httpResponse;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.a == null) {
                                SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, params is null!");
                                return;
                            }
                            int a2 = e.a();
                            if (a2 == 0) {
                                a2 = 3;
                            }
                            SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + a2);
                            HttpResponse httpResponse2 = null;
                            HttpClient httpClient = HttpUtils.getHttpClient(com.tencent.open.utils.f.a(), null, this.b);
                            String encodeUrl = HttpUtils.encodeUrl(this.a);
                            if (this.c) {
                                encodeUrl = URLEncoder.encode(encodeUrl);
                            }
                            if (this.d.toUpperCase().equals("GET")) {
                                StringBuffer stringBuffer = new StringBuffer(this.b);
                                stringBuffer.append(encodeUrl);
                                httpUriRequest = new HttpGet(stringBuffer.toString());
                            } else if (this.d.toUpperCase().equals("POST")) {
                                HttpPost httpPost = new HttpPost(this.b);
                                httpPost.setEntity(new ByteArrayEntity(l.i(encodeUrl)));
                                httpUriRequest = httpPost;
                            } else {
                                SLog.e("openSDK_LOG.ReportManager", "-->httpRequest unkonw request method return.");
                                return;
                            }
                            httpUriRequest.addHeader("Accept-Encoding", "gzip");
                            httpUriRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
                            int i = 0;
                            boolean z2 = false;
                            do {
                                i++;
                                try {
                                    try {
                                        httpResponse = httpClient.execute(httpUriRequest);
                                        try {
                                            int statusCode = httpResponse.getStatusLine().getStatusCode();
                                            SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + statusCode);
                                            if (statusCode != 200) {
                                                SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest : HttpStatuscode != 200");
                                            } else {
                                                try {
                                                    SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread success");
                                                    z2 = true;
                                                } catch (SocketTimeoutException e) {
                                                    e = e;
                                                    z2 = true;
                                                    try {
                                                        SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e);
                                                        if (httpResponse != null) {
                                                            try {
                                                                HttpEntity entity = httpResponse.getEntity();
                                                                if (entity != null) {
                                                                    entity.consumeContent();
                                                                    continue;
                                                                } else {
                                                                    continue;
                                                                }
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                                                continue;
                                                                if (i >= a2) {
                                                                }
                                                            }
                                                        } else {
                                                            continue;
                                                        }
                                                        if (i >= a2) {
                                                        }
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        httpResponse2 = httpResponse;
                                                        if (httpResponse2 != null) {
                                                            try {
                                                                HttpEntity entity2 = httpResponse2.getEntity();
                                                                if (entity2 != null) {
                                                                    entity2.consumeContent();
                                                                }
                                                            } catch (Exception e3) {
                                                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e3);
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                } catch (ConnectTimeoutException e4) {
                                                    e = e4;
                                                    z2 = true;
                                                    SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest ConnectTimeoutException:", e);
                                                    if (httpResponse != null) {
                                                        try {
                                                            HttpEntity entity3 = httpResponse.getEntity();
                                                            if (entity3 != null) {
                                                                entity3.consumeContent();
                                                                continue;
                                                            } else {
                                                                continue;
                                                            }
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                                            continue;
                                                            if (i >= a2) {
                                                                if (!z2) {
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        continue;
                                                    }
                                                    if (i >= a2) {
                                                    }
                                                } catch (Exception e6) {
                                                    e = e6;
                                                    httpResponse2 = httpResponse;
                                                    z2 = true;
                                                    SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e);
                                                    if (httpResponse2 != null) {
                                                        try {
                                                            HttpEntity entity4 = httpResponse2.getEntity();
                                                            if (entity4 != null) {
                                                                entity4.consumeContent();
                                                            }
                                                        } catch (Exception e7) {
                                                            e = e7;
                                                            SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                                            if (!z2) {
                                                            }
                                                        }
                                                    }
                                                    if (!z2) {
                                                    }
                                                }
                                            }
                                            if (httpResponse != null) {
                                                try {
                                                    HttpEntity entity5 = httpResponse.getEntity();
                                                    if (entity5 != null) {
                                                        entity5.consumeContent();
                                                    }
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                                    if (!z2) {
                                                    }
                                                }
                                            }
                                        } catch (SocketTimeoutException e9) {
                                            e = e9;
                                        } catch (ConnectTimeoutException e10) {
                                            e = e10;
                                        } catch (Exception e11) {
                                            e = e11;
                                            httpResponse2 = httpResponse;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (httpResponse2 != null) {
                                        }
                                        throw th;
                                    }
                                } catch (SocketTimeoutException e12) {
                                    e = e12;
                                    httpResponse = null;
                                } catch (ConnectTimeoutException e13) {
                                    e = e13;
                                    httpResponse = null;
                                } catch (Exception e14) {
                                    e = e14;
                                }
                                if (!z2) {
                                    SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
                                    return;
                                } else {
                                    SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
                                    return;
                                }
                            } while (i >= a2);
                            if (!z2) {
                            }
                        } catch (Exception e15) {
                            SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e15);
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r0 == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (r0 == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i) {
        InterceptResult invokeLI;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            int i2 = 5;
            if (str.equals("report_cgi")) {
                a2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportMaxcount");
            } else {
                if (str.equals("report_via")) {
                    a2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportBatchCount");
                } else {
                    i2 = 0;
                }
                SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
                if (i < i2) {
                    return false;
                }
                return true;
            }
        } else {
            return invokeLI.booleanValue;
        }
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int i = 100;
            if (str.equals("report_cgi")) {
                try {
                    a2 = a(Integer.parseInt(str2));
                    if (this.b.nextInt(100) < a2) {
                        z = true;
                    }
                } catch (Exception unused) {
                    return false;
                }
            } else {
                if (str.equals("report_via")) {
                    a2 = e.a(str2);
                    if (this.b.nextInt(100) < a2) {
                        i = a2;
                        z = true;
                    }
                }
                SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
                return z;
            }
            i = a2;
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
            return z;
        }
        return invokeLL.booleanValue;
    }

    public Bundle c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.c.size() == 0) {
                return null;
            }
            b bVar = (b) this.c.get(0);
            if (bVar == null) {
                SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
                return null;
            }
            String str = bVar.a.get("appid");
            List<Serializable> a2 = f.a().a("report_cgi");
            if (a2 != null) {
                this.c.addAll(a2);
            }
            SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
            if (this.c.size() == 0) {
                return null;
            }
            Bundle bundle = new Bundle();
            try {
                bundle.putString("appid", str);
                bundle.putString("releaseversion", com.tencent.connect.common.Constants.SDK_VERSION_REPORT);
                bundle.putString("device", Build.DEVICE);
                bundle.putString("qua", com.tencent.connect.common.Constants.SDK_QUA);
                bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
                for (int i = 0; i < this.c.size(); i++) {
                    b bVar2 = (b) this.c.get(i);
                    bundle.putString(i + SkinManager.nightSufix, bVar2.a.get("apn"));
                    bundle.putString(i + SkinManager.darkSuffix, bVar2.a.get(FetchTimer.FREQUENCY));
                    bundle.putString(i + "_3", bVar2.a.get("commandid"));
                    bundle.putString(i + "_4", bVar2.a.get("resultCode"));
                    bundle.putString(i + "_5", bVar2.a.get("timeCost"));
                    bundle.putString(i + "_6", bVar2.a.get("reqSize"));
                    bundle.putString(i + "_7", bVar2.a.get("rspSize"));
                    bundle.putString(i + "_8", bVar2.a.get("detail"));
                    bundle.putString(i + "_9", bVar2.a.get("uin"));
                    bundle.putString(i + "_10", c.e(com.tencent.open.utils.f.a()) + "&" + bVar2.a.get(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO));
                }
                SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
                return bundle;
            } catch (Exception e) {
                SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
                return null;
            }
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<Serializable> a2 = f.a().a("report_via");
            if (a2 != null) {
                this.d.addAll(a2);
            }
            SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
            if (this.d.size() == 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<Serializable> it = this.d.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                b bVar = (b) it.next();
                for (String str : bVar.a.keySet()) {
                    try {
                        String str2 = bVar.a.get(str);
                        if (str2 == null) {
                            str2 = "";
                        }
                        jSONObject.put(str, str2);
                    } catch (JSONException e) {
                        SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                    }
                }
                jSONArray.put(jSONObject);
            }
            SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
            Bundle bundle = new Bundle();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("data", jSONArray);
                bundle.putString("data", jSONObject2.toString());
                return bundle;
            } catch (JSONException e2) {
                SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                return null;
            }
        }
        return (Bundle) invokeV.objValue;
    }
}
