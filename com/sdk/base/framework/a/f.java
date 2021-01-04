package com.sdk.base.framework.a;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidubce.http.Headers;
import com.sdk.base.module.manager.SDKManager;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.net.HttpURLConnection;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class f<T> extends com.sdk.base.framework.a.c.c<Object, Object, Void> implements com.sdk.base.framework.a.b.c {

    /* renamed from: b  reason: collision with root package name */
    private static d f13095b = new d();
    private com.sdk.base.framework.b.b<T> d;
    private String e;
    private String f;
    private int h;
    private long j;
    private j<T> p;
    private long q;
    private long c = d.a();
    private g g = g.f13096a;
    private boolean i = true;
    private String k = null;
    private boolean l = false;
    private Boolean m = false;
    private Boolean n = false;
    private Boolean o = false;

    public f(h<T> hVar) {
        this.p = hVar.b();
        if (this.p != null) {
            this.e = this.p.a();
            this.f = this.p.e();
            this.h = this.p.g();
            this.d = this.p.h();
        }
    }

    private k<T> a(h<T> hVar, HttpURLConnection httpURLConnection) {
        String a2;
        k<T> kVar = null;
        try {
        } catch (Throwable th) {
            com.sdk.base.framework.f.g.a.b(th.toString());
            com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", "网络访问异常：" + th.toString(), this.f13078a);
            if (this.h > 0) {
                this.h--;
                kVar = a(hVar, httpURLConnection);
            }
        }
        if (!d.b(this.e) || (a2 = f13095b.a(this.f)) == null) {
            if (this.m.booleanValue() && this.l) {
                File file = new File(this.k);
                long length = (file.isFile() && file.exists()) ? file.length() : 0L;
                if (length > 0) {
                    httpURLConnection.setRequestProperty("RANGE", "bytes=" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            if (!b()) {
                this.q = System.currentTimeMillis();
                kVar = b(hVar, hVar.a(httpURLConnection));
            }
            return kVar == null ? new k<>(1, "网络访问异常", false) : kVar;
        }
        return new k<>(0, a2, true);
    }

    private k<T> b(h<T> hVar, HttpURLConnection httpURLConnection) {
        Object obj = null;
        if (b()) {
            return new k<>(1, "网络访问已取消", false);
        }
        int i = -1;
        try {
            com.sdk.base.framework.f.g.a.a(httpURLConnection.getURL().toString(), System.currentTimeMillis() - this.q);
            if (httpURLConnection != null) {
                i = httpURLConnection.getResponseCode();
                String str = "net请求host：" + httpURLConnection.getURL().getHost() + "\n net请求path：" + httpURLConnection.getURL().getPath() + "\n  net请求码：" + i;
                Boolean bool = this.f13078a;
                if (str == null) {
                    str = "";
                }
                if (bool.booleanValue()) {
                    Log.d("PriorityAsyncTask", str);
                }
            }
            if (this.f13078a.booleanValue()) {
                com.sdk.base.framework.a.a.c.a("PriorityAsyncTask", "响应返回：code=" + i + ";耗时=" + (System.currentTimeMillis() - this.q), this.f13078a);
            }
            if (i < 300) {
                if (httpURLConnection != null) {
                    this.i = false;
                    if (this.l) {
                        this.m = Boolean.valueOf(this.m.booleanValue() && com.sdk.base.framework.f.e.a.a(httpURLConnection));
                        String b2 = this.n.booleanValue() ? com.sdk.base.framework.f.e.a.b(httpURLConnection) : null;
                        new com.sdk.base.framework.a.b.b();
                        com.sdk.base.framework.a.b.b.a(httpURLConnection, this, this.k, this.m.booleanValue(), b2);
                    }
                    if (this.o.booleanValue()) {
                        new com.sdk.base.framework.a.b.a();
                        obj = com.sdk.base.framework.a.b.a.a(httpURLConnection);
                    } else {
                        new com.sdk.base.framework.a.b.d();
                        obj = com.sdk.base.framework.a.b.d.a(httpURLConnection, this, "UTF-8");
                        if (d.b(this.e)) {
                            f13095b.a(this.f, (String) obj, this.c);
                        }
                    }
                }
                return new k<>(0, obj, false);
            }
            if (i == 301 || i == 302) {
                String headerField = httpURLConnection.getHeaderField(Headers.LOCATION);
                String headerField2 = httpURLConnection.getHeaderField(SM.SET_COOKIE);
                String path = httpURLConnection.getURL().getPath();
                if (com.sdk.base.framework.a.a.c.b(headerField).booleanValue() && hVar != null) {
                    hVar.b().b(headerField);
                    HttpURLConnection a2 = hVar.a(headerField);
                    if (com.sdk.base.framework.a.a.c.b(headerField2).booleanValue()) {
                        if ("/ctcnet/gctcmc.do".equals(path)) {
                            com.sdk.base.framework.f.b.a.b(SDKManager.getContext(), "ctc", headerField2);
                            com.sdk.base.framework.a.a.c.a("PriorityAsyncTask", "mdb Cookie cache", this.f13078a);
                        }
                        a2.setRequestProperty(SM.COOKIE, headerField2);
                    } else {
                        a2.setRequestProperty(SM.COOKIE, com.sdk.base.framework.f.b.a.b(SDKManager.getContext(), "ctc"));
                    }
                    if (a2 == null) {
                        return new k<>(0, c(), false);
                    }
                    if (a2 != null) {
                        hVar.c();
                        return a(hVar, a2);
                    }
                }
            }
            com.sdk.base.framework.f.g.a.b("服务异常 ResponseCode = " + i);
            com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", "服务异常 ResponseCode = " + i, this.f13078a);
            return new k<>(0, "服务端数据格式出错", false);
        } catch (Exception e) {
            com.sdk.base.framework.f.g.a.b(e.toString());
            com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", e.toString(), this.f13078a);
            return new k<>(1, "网络访问异常", false);
        }
    }

    private static String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("status", 102001);
            jSONObject.put("msg", "选择流量通道失败");
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0039 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007e -> B:31:0x0010). Please submit an issue!!! */
    @Override // com.sdk.base.framework.a.c.c
    /* renamed from: e */
    public Void b(Object... objArr) {
        ?? r1 = 1;
        r1 = 1;
        r1 = 1;
        r1 = 1;
        r1 = 1;
        ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        if (this.g != g.e && objArr != null && objArr.length != 0) {
            if (objArr.length == 4) {
                this.k = String.valueOf(objArr[1]);
                this.l = this.k != null;
                this.m = (Boolean) objArr[2];
                this.n = (Boolean) objArr[3];
            }
            if (objArr.length == 2) {
                this.o = (Boolean) objArr[1];
            }
            try {
                this.j = SystemClock.uptimeMillis();
                d(1);
                h<T> hVar = (h) objArr[0];
                this.f = hVar.a();
                HttpURLConnection a2 = hVar.a(this.f);
                if (a2 == null) {
                    d(4, new k(0, c(), false));
                } else {
                    k<T> a3 = a(hVar, a2);
                    if (a3 != null) {
                        if (a3.a() == 0) {
                            d(4, a3);
                        } else {
                            d(3, Integer.valueOf(a3.a()), a3.b());
                        }
                    }
                }
            } catch (Exception e) {
                com.sdk.base.framework.f.g.a.b(e.toString());
                com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", "网络访问异常：\n" + e.toString(), this.f13078a);
                Object[] objArr2 = new Object[3];
                objArr2[r2] = 3;
                Integer valueOf = Integer.valueOf((int) CmdConfigSocket.CMD_SUBPB_FLOOR);
                objArr2[r1] = valueOf;
                objArr2[2] = "网络访问异常";
                d(objArr2);
                r1 = "网络访问异常";
                r2 = valueOf;
            }
        }
        return null;
    }

    @Override // com.sdk.base.framework.a.c.c
    public final void a() {
        this.g = g.e;
        if (b()) {
            return;
        }
        try {
            a(true);
        } catch (Throwable th) {
            com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", th.getMessage(), this.f13078a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sdk.base.framework.a.c.c
    public final void a(Object... objArr) {
        if (this.g == g.e || objArr == null || objArr.length == 0 || this.d == null) {
            return;
        }
        switch (((Integer) objArr[0]).intValue()) {
            case 1:
                this.g = g.f13097b;
                return;
            case 2:
                if (objArr.length == 3) {
                    this.g = g.c;
                    Long.parseLong(String.valueOf(objArr[1]));
                    Long.parseLong(String.valueOf(objArr[2]));
                    return;
                }
                return;
            case 3:
                if (objArr.length == 3) {
                    this.g = g.d;
                    this.d.a(((Integer) objArr[1]).intValue(), (String) objArr[2]);
                    return;
                }
                return;
            case 4:
                if (objArr.length == 2) {
                    this.g = g.f;
                    this.p.e();
                    this.d.a((k) objArr[1]);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.sdk.base.framework.a.b.c
    public final boolean a(long j, long j2, boolean z) {
        if (this.d != null && this.g != g.e) {
            if (z) {
                d(2, Long.valueOf(j), Long.valueOf(j2));
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - this.j >= this.d.a()) {
                    this.j = uptimeMillis;
                    d(2, Long.valueOf(j), Long.valueOf(j2));
                }
            }
        }
        return this.g != g.e;
    }
}
