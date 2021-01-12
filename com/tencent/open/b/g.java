package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import com.kwai.video.player.KsMediaMeta;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
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
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected static g f13395a;
    protected HandlerThread e;
    protected Handler f;

    /* renamed from: b  reason: collision with root package name */
    protected Random f13396b = new Random();
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());
    protected Executor g = i.b();
    protected Executor h = i.b();

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f13395a == null) {
                f13395a = new g();
            }
            gVar = f13395a;
        }
        return gVar;
    }

    private g() {
        this.e = null;
        if (this.e == null) {
            this.e = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e.start();
        }
        if (this.e.isAlive() && this.e.getLooper() != null) {
            this.f = new Handler(this.e.getLooper()) { // from class: com.tencent.open.b.g.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1000:
                            g.this.b();
                            break;
                        case 1001:
                            g.this.e();
                            break;
                    }
                    super.handleMessage(message);
                }
            };
        }
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle != null) {
            com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
            if (a("report_via", str) || z) {
                this.g.execute(new Runnable() { // from class: com.tencent.open.b.g.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("uin", "1000");
                            bundle2.putString("imei", c.b(com.tencent.open.utils.e.a()));
                            bundle2.putString("imsi", c.c(com.tencent.open.utils.e.a()));
                            bundle2.putString("android_id", c.d(com.tencent.open.utils.e.a()));
                            bundle2.putString("mac", c.a());
                            bundle2.putString("platform", "1");
                            bundle2.putString("os_ver", Build.VERSION.RELEASE);
                            bundle2.putString("position", j.c(com.tencent.open.utils.e.a()));
                            bundle2.putString("network", a.a(com.tencent.open.utils.e.a()));
                            bundle2.putString(KsMediaMeta.KSM_KEY_LANGUAGE, c.b());
                            bundle2.putString("resolution", c.a(com.tencent.open.utils.e.a()));
                            bundle2.putString("apn", a.b(com.tencent.open.utils.e.a()));
                            bundle2.putString("model_name", Build.MODEL);
                            bundle2.putString("timezone", TimeZone.getDefault().getID());
                            bundle2.putString("sdk_ver", Constants.SDK_VERSION);
                            bundle2.putString("qz_ver", j.d(com.tencent.open.utils.e.a(), Constants.PACKAGE_QZONE));
                            bundle2.putString("qq_ver", j.c(com.tencent.open.utils.e.a(), "com.tencent.mobileqq"));
                            bundle2.putString("qua", j.e(com.tencent.open.utils.e.a(), com.tencent.open.utils.e.b()));
                            bundle2.putString("packagename", com.tencent.open.utils.e.b());
                            bundle2.putString(IXAdRequestInfo.APP_VERSION_NAME, j.d(com.tencent.open.utils.e.a(), com.tencent.open.utils.e.b()));
                            if (bundle != null) {
                                bundle2.putAll(bundle);
                            }
                            g.this.d.add(new b(bundle2));
                            int size = g.this.d.size();
                            int a2 = com.tencent.open.utils.f.a(com.tencent.open.utils.e.a(), (String) null).a("Agent_ReportTimeInterval");
                            if (a2 == 0) {
                                a2 = 10000;
                            }
                            if (!g.this.a("report_via", size) && !z) {
                                if (!g.this.f.hasMessages(1001)) {
                                    Message obtain = Message.obtain();
                                    obtain.what = 1001;
                                    g.this.f.sendMessageDelayed(obtain, a2);
                                    return;
                                }
                                return;
                            }
                            g.this.e();
                            g.this.f.removeMessages(1001);
                        } catch (Exception e) {
                            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                        }
                    }
                });
            }
        }
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(final String str, final long j, final long j2, final long j3, final int i, final String str2, final boolean z) {
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (a("report_cgi", "" + i) || z) {
            this.h.execute(new Runnable() { // from class: com.tencent.open.b.g.3
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 1;
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
                        Bundle bundle = new Bundle();
                        String a2 = a.a(com.tencent.open.utils.e.a());
                        bundle.putString("apn", a2);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString("detail", str2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("network=").append(a2).append('&');
                        sb.append("sdcard=").append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0).append('&');
                        sb.append("wifi=").append(a.e(com.tencent.open.utils.e.a()));
                        bundle.putString("deviceInfo", sb.toString());
                        int a3 = 100 / g.this.a(i);
                        if (a3 > 0) {
                            i2 = a3 > 100 ? 100 : a3;
                        }
                        bundle.putString("frequency", i2 + "");
                        bundle.putString("reqSize", j2 + "");
                        bundle.putString("resultCode", i + "");
                        bundle.putString("rspSize", j3 + "");
                        bundle.putString("timeCost", elapsedRealtime + "");
                        bundle.putString("uin", "1000");
                        g.this.c.add(new b(bundle));
                        int size = g.this.c.size();
                        int a4 = com.tencent.open.utils.f.a(com.tencent.open.utils.e.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a4 == 0) {
                            a4 = 10000;
                        }
                        if (g.this.a("report_cgi", size) || z) {
                            g.this.b();
                            g.this.f.removeMessages(1000);
                        } else if (!g.this.f.hasMessages(1000)) {
                            Message obtain = Message.obtain();
                            obtain.what = 1000;
                            g.this.f.sendMessageDelayed(obtain, a4);
                        }
                    } catch (Exception e) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    protected void b() {
        this.h.execute(new Runnable() { // from class: com.tencent.open.b.g.4
            /*  JADX ERROR: IF instruction can be used only in fallback mode
                jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
                	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:664)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:522)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:280)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
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
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    r8 = this;
                    r1 = 0
                    com.tencent.open.b.g r0 = com.tencent.open.b.g.this     // Catch: java.lang.Exception -> Lbf
                    android.os.Bundle r4 = r0.c()     // Catch: java.lang.Exception -> Lbf
                    if (r4 != 0) goto La
                L9:
                    return
                La:
                    android.content.Context r0 = com.tencent.open.utils.e.a()     // Catch: java.lang.Exception -> Lbf
                    r2 = 0
                    com.tencent.open.utils.f r0 = com.tencent.open.utils.f.a(r0, r2)     // Catch: java.lang.Exception -> Lbf
                    java.lang.String r2 = "Common_HttpRetryCount"
                    int r0 = r0.a(r2)     // Catch: java.lang.Exception -> Lbf
                    if (r0 != 0) goto Lcb
                    r0 = 3
                    r3 = r0
                L1e:
                    java.lang.String r0 = "openSDK_LOG.ReportManager"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbf
                    r2.<init>()     // Catch: java.lang.Exception -> Lbf
                    java.lang.String r5 = "-->doReportCgi, retryCount: "
                    java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Exception -> Lbf
                    java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> Lbf
                    java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lbf
                    com.tencent.open.a.f.b(r0, r2)     // Catch: java.lang.Exception -> Lbf
                    r0 = r1
                L39:
                    int r0 = r0 + 1
                    android.content.Context r2 = com.tencent.open.utils.e.a()     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    r5 = 0
                    java.lang.String r6 = "https://wspeed.qq.com/w.cgi"
                    org.apache.http.client.HttpClient r2 = com.tencent.open.utils.HttpUtils.getHttpClient(r2, r5, r6)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    org.apache.http.client.methods.HttpPost r5 = new org.apache.http.client.methods.HttpPost     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    java.lang.String r6 = "https://wspeed.qq.com/w.cgi"
                    r5.<init>(r6)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    java.lang.String r6 = "Accept-Encoding"
                    java.lang.String r7 = "gzip"
                    r5.addHeader(r6, r7)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    java.lang.String r6 = "Content-Type"
                    java.lang.String r7 = "application/x-www-form-urlencoded"
                    r5.setHeader(r6, r7)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    java.lang.String r6 = com.tencent.open.utils.HttpUtils.encodeUrl(r4)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    byte[] r6 = com.tencent.open.utils.j.i(r6)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    org.apache.http.entity.ByteArrayEntity r7 = new org.apache.http.entity.ByteArrayEntity     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    r7.<init>(r6)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    r5.setEntity(r7)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    org.apache.http.HttpResponse r2 = r2.execute(r5)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    org.apache.http.StatusLine r2 = r2.getStatusLine()     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    int r2 = r2.getStatusCode()     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    java.lang.String r5 = "openSDK_LOG.ReportManager"
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    r6.<init>()     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    java.lang.String r7 = "-->doReportCgi, statusCode: "
                    java.lang.StringBuilder r6 = r6.append(r7)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    java.lang.StringBuilder r6 = r6.append(r2)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    java.lang.String r6 = r6.toString()     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    com.tencent.open.a.f.b(r5, r6)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    r5 = 200(0xc8, float:2.8E-43)
                    if (r2 != r5) goto La6
                    com.tencent.open.b.f r2 = com.tencent.open.b.f.a()     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    java.lang.String r5 = "report_cgi"
                    r2.b(r5)     // Catch: org.apache.http.conn.ConnectTimeoutException -> Lce java.net.SocketTimeoutException -> Ldb java.lang.Exception -> Le6
                    r1 = 1
                La6:
                    if (r1 != 0) goto Lb6
                    com.tencent.open.b.f r0 = com.tencent.open.b.f.a()     // Catch: java.lang.Exception -> Lbf
                    java.lang.String r1 = "report_cgi"
                    com.tencent.open.b.g r2 = com.tencent.open.b.g.this     // Catch: java.lang.Exception -> Lbf
                    java.util.List<java.io.Serializable> r2 = r2.c     // Catch: java.lang.Exception -> Lbf
                    r0.a(r1, r2)     // Catch: java.lang.Exception -> Lbf
                Lb6:
                    com.tencent.open.b.g r0 = com.tencent.open.b.g.this     // Catch: java.lang.Exception -> Lbf
                    java.util.List<java.io.Serializable> r0 = r0.c     // Catch: java.lang.Exception -> Lbf
                    r0.clear()     // Catch: java.lang.Exception -> Lbf
                    goto L9
                Lbf:
                    r0 = move-exception
                    java.lang.String r1 = "openSDK_LOG.ReportManager"
                    java.lang.String r2 = "-->doReportCgi, doupload exception out."
                    com.tencent.open.a.f.b(r1, r2, r0)
                    goto L9
                Lcb:
                    r3 = r0
                    goto L1e
                Lce:
                    r2 = move-exception
                    java.lang.String r5 = "openSDK_LOG.ReportManager"
                    java.lang.String r6 = "-->doReportCgi, doupload exception"
                    com.tencent.open.a.f.b(r5, r6, r2)     // Catch: java.lang.Exception -> Lbf
                Ld8:
                    if (r0 < r3) goto L39
                    goto La6
                Ldb:
                    r2 = move-exception
                    java.lang.String r5 = "openSDK_LOG.ReportManager"
                    java.lang.String r6 = "-->doReportCgi, doupload exception"
                    com.tencent.open.a.f.b(r5, r6, r2)     // Catch: java.lang.Exception -> Lbf
                    goto Ld8
                Le6:
                    r0 = move-exception
                    java.lang.String r2 = "openSDK_LOG.ReportManager"
                    java.lang.String r3 = "-->doReportCgi, doupload exception"
                    com.tencent.open.a.f.b(r2, r3, r0)     // Catch: java.lang.Exception -> Lbf
                    goto La6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass4.run():void");
            }
        });
    }

    protected boolean a(String str, String str2) {
        int a2;
        boolean z = true;
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("report_cgi")) {
            try {
                a2 = a(Integer.parseInt(str2));
                if (this.f13396b.nextInt(100) >= a2) {
                    z = false;
                }
            } catch (Exception e) {
                return false;
            }
        } else if (str.equals("report_via")) {
            a2 = e.a(str2);
            if (this.f13396b.nextInt(100) >= a2) {
                z = false;
            }
        } else {
            a2 = 100;
            z = false;
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + a2);
        return z;
    }

    protected boolean a(String str, int i) {
        int i2 = 5;
        if (str.equals("report_cgi")) {
            int a2 = com.tencent.open.utils.f.a(com.tencent.open.utils.e.a(), (String) null).a("Common_CGIReportMaxcount");
            if (a2 != 0) {
                i2 = a2;
            }
        } else if (str.equals("report_via")) {
            int a3 = com.tencent.open.utils.f.a(com.tencent.open.utils.e.a(), (String) null).a("Agent_ReportBatchCount");
            if (a3 != 0) {
                i2 = a3;
            }
        } else {
            i2 = 0;
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
        return i >= i2;
    }

    protected int a(int i) {
        if (i == 0) {
            int a2 = com.tencent.open.utils.f.a(com.tencent.open.utils.e.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a2 == 0) {
                return 10;
            }
            return a2;
        }
        int a3 = com.tencent.open.utils.f.a(com.tencent.open.utils.e.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a3 == 0) {
            return 100;
        }
        return a3;
    }

    protected Bundle c() {
        if (this.c.size() == 0) {
            return null;
        }
        b bVar = (b) this.c.get(0);
        if (bVar == null) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = bVar.f13389a.get("appid");
        List<Serializable> a2 = f.a().a("report_cgi");
        if (a2 != null) {
            this.c.addAll(a2);
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
        if (this.c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
            bundle.putString(Config.DEVICE_PART, Build.DEVICE);
            bundle.putString("qua", Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.c.size(); i++) {
                b bVar2 = (b) this.c.get(i);
                bundle.putString(i + "_1", bVar2.f13389a.get("apn"));
                bundle.putString(i + "_2", bVar2.f13389a.get("frequency"));
                bundle.putString(i + "_3", bVar2.f13389a.get("commandid"));
                bundle.putString(i + "_4", bVar2.f13389a.get("resultCode"));
                bundle.putString(i + "_5", bVar2.f13389a.get("timeCost"));
                bundle.putString(i + "_6", bVar2.f13389a.get("reqSize"));
                bundle.putString(i + "_7", bVar2.f13389a.get("rspSize"));
                bundle.putString(i + "_8", bVar2.f13389a.get("detail"));
                bundle.putString(i + "_9", bVar2.f13389a.get("uin"));
                bundle.putString(i + "_10", c.e(com.tencent.open.utils.e.a()) + ETAG.ITEM_SEPARATOR + bVar2.f13389a.get("deviceInfo"));
            }
            com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Exception e) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    protected Bundle d() {
        List<Serializable> a2 = f.a().a("report_via");
        if (a2 != null) {
            this.d.addAll(a2);
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Serializable> it = this.d.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) it.next();
            for (String str : bVar.f13389a.keySet()) {
                try {
                    String str2 = bVar.f13389a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (JSONException e2) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected void e() {
        this.g.execute(new Runnable() { // from class: com.tencent.open.b.g.5
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [697=4] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x0131 A[LOOP:0: B:7:0x0038->B:60:0x0131, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:71:0x0068 A[EDGE_INSN: B:71:0x0068->B:17:0x0068 ?: BREAK  , SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i;
                long j;
                int i2;
                boolean z;
                j.a openUrl2;
                int i3;
                try {
                    Bundle d = g.this.d();
                    if (d == null) {
                        return;
                    }
                    com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->doReportVia, params: " + d.toString());
                    int a2 = e.a();
                    int i4 = 0;
                    boolean z2 = false;
                    long j2 = 0;
                    int i5 = 0;
                    long j3 = 0;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    while (true) {
                        int i6 = i4 + 1;
                        try {
                            try {
                                try {
                                    openUrl2 = HttpUtils.openUrl2(com.tencent.open.utils.e.a(), "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", d);
                                    try {
                                        i3 = j.d(openUrl2.f13446a).getInt(Constants.KEYS.RET);
                                    } catch (JSONException e) {
                                        i3 = -4;
                                    }
                                    if (i3 == 0 || !TextUtils.isEmpty(openUrl2.f13446a)) {
                                        z2 = true;
                                        i = a2;
                                    } else {
                                        i = i6;
                                    }
                                } catch (JSONException e2) {
                                    i = i6;
                                }
                            } catch (HttpUtils.HttpStatusException e3) {
                                try {
                                    i5 = Integer.parseInt(e3.getMessage().replace(HttpUtils.HttpStatusException.ERROR_INFO, ""));
                                } catch (Exception e4) {
                                }
                                i2 = i5;
                                j = elapsedRealtime;
                                z = z2;
                            } catch (HttpUtils.NetworkUnavailableException e5) {
                                g.this.d.clear();
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                                return;
                            } catch (Exception e6) {
                                j2 = 0;
                                j3 = 0;
                                i5 = -6;
                                j = elapsedRealtime;
                                i = a2;
                            }
                        } catch (SocketTimeoutException e7) {
                            i = i6;
                        } catch (ConnectTimeoutException e8) {
                            i = i6;
                        } catch (IOException e9) {
                            e = e9;
                            i = i6;
                        }
                        try {
                            j2 = openUrl2.f13447b;
                            j3 = openUrl2.c;
                            j = elapsedRealtime;
                        } catch (SocketTimeoutException e10) {
                            j2 = 0;
                            j3 = 0;
                            i5 = -8;
                            j = SystemClock.elapsedRealtime();
                            if (i >= a2) {
                            }
                        } catch (ConnectTimeoutException e11) {
                            j2 = 0;
                            j3 = 0;
                            i5 = -7;
                            j = SystemClock.elapsedRealtime();
                            if (i >= a2) {
                            }
                        } catch (IOException e12) {
                            e = e12;
                            j2 = 0;
                            j3 = 0;
                            i5 = HttpUtils.getErrorCodeFromException(e);
                            j = elapsedRealtime;
                            if (i >= a2) {
                            }
                        } catch (JSONException e13) {
                            j2 = 0;
                            j3 = 0;
                            i5 = -4;
                            j = elapsedRealtime;
                            if (i >= a2) {
                            }
                        }
                        if (i >= a2) {
                            break;
                        }
                        elapsedRealtime = j;
                        i4 = i;
                    }
                    i2 = i5;
                    z = z2;
                    g.this.a("mapp_apptrace_sdk", j, j2, j3, i2, null, false);
                    if (z) {
                        f.a().b("report_via");
                    } else {
                        f.a().a("report_via", g.this.d);
                    }
                    g.this.d.clear();
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
                } catch (Exception e14) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e14);
                }
            }
        });
    }

    public void a(final String str, final String str2, final Bundle bundle, final boolean z) {
        i.a(new Runnable() { // from class: com.tencent.open.b.g.6
            /* JADX WARN: Removed duplicated region for block: B:23:0x00ba A[Catch: Exception -> 0x00c5, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x0010, B:10:0x0018, B:12:0x0047, B:13:0x004c, B:15:0x005b, B:16:0x006f, B:23:0x00ba, B:43:0x0134, B:42:0x012a, B:40:0x011f, B:36:0x0110, B:28:0x00d4, B:30:0x00e3, B:31:0x00f9), top: B:52:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x011b A[LOOP:0: B:18:0x0083->B:38:0x011b, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x0134 A[Catch: Exception -> 0x00c5, TRY_LEAVE, TryCatch #5 {Exception -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x0010, B:10:0x0018, B:12:0x0047, B:13:0x004c, B:15:0x005b, B:16:0x006f, B:23:0x00ba, B:43:0x0134, B:42:0x012a, B:40:0x011f, B:36:0x0110, B:28:0x00d4, B:30:0x00e3, B:31:0x00f9), top: B:52:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x00b8 A[EDGE_INSN: B:59:0x00b8->B:22:0x00b8 ?: BREAK  , SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                HttpGet httpGet;
                try {
                    if (bundle == null) {
                        com.tencent.open.a.f.e("openSDK_LOG.ReportManager", "-->httpRequest, params is null!");
                        return;
                    }
                    int a2 = e.a();
                    int i = a2 == 0 ? 3 : a2;
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + i);
                    HttpClient httpClient = HttpUtils.getHttpClient(com.tencent.open.utils.e.a(), null, str);
                    String encodeUrl = HttpUtils.encodeUrl(bundle);
                    String encode = z ? URLEncoder.encode(encodeUrl) : encodeUrl;
                    if (str2.toUpperCase().equals("GET")) {
                        StringBuffer stringBuffer = new StringBuffer(str);
                        stringBuffer.append(encode);
                        httpGet = new HttpGet(stringBuffer.toString());
                    } else if (str2.toUpperCase().equals("POST")) {
                        HttpPost httpPost = new HttpPost(str);
                        httpPost.setEntity(new ByteArrayEntity(j.i(encode)));
                        httpGet = httpPost;
                    } else {
                        com.tencent.open.a.f.e("openSDK_LOG.ReportManager", "-->httpRequest unkonw request method return.");
                        return;
                    }
                    httpGet.addHeader(Headers.ACCEPT_ENCODING, "gzip");
                    httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    boolean z2 = false;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        try {
                            int statusCode = httpClient.execute(httpGet).getStatusLine().getStatusCode();
                            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + statusCode);
                            if (statusCode != 200) {
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest : HttpStatuscode != 200");
                                break;
                            }
                            try {
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread success");
                                z2 = true;
                                break;
                            } catch (SocketTimeoutException e) {
                                z2 = true;
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException");
                                if (i3 >= i) {
                                    i2 = i3;
                                } else if (z2) {
                                }
                            } catch (ConnectTimeoutException e2) {
                                z2 = true;
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest ConnectTimeoutException");
                                if (i3 >= i) {
                                }
                            } catch (Exception e3) {
                                z2 = true;
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception");
                                if (z2) {
                                }
                            }
                        } catch (SocketTimeoutException e4) {
                        } catch (ConnectTimeoutException e5) {
                        } catch (Exception e6) {
                        }
                        i2 = i3;
                    }
                    if (z2) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
                    } else {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
                    }
                } catch (Exception e7) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor.");
                }
            }
        });
    }
}
