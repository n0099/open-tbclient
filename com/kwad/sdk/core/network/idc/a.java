package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class a {
    public static final int auy;
    public volatile boolean auA;
    public final Map<String, String> aut;
    public final com.kwad.sdk.core.network.idc.a.b auu;
    public final Random auv;
    public final Map<String, AtomicBoolean> auw;
    public final Map<String, com.kwad.sdk.core.network.idc.a.a> aux;
    public volatile int auz;
    public Context mContext;

    /* renamed from: com.kwad.sdk.core.network.idc.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0710a {
        public static final a auD = new a((byte) 0);
    }

    static {
        int i;
        if (com.kwad.framework.a.a.mc.booleanValue()) {
            i = 0;
        } else {
            i = 60000;
        }
        auy = i;
    }

    public static a CJ() {
        return C0710a.auD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void CK() {
        com.kwad.sdk.core.network.idc.a.b ba = b.ba(this.mContext);
        if (ba.isEmpty()) {
            ba = b.aZ(this.mContext);
        }
        this.auu.a(ba);
    }

    public final boolean CL() {
        if (!this.aux.isEmpty()) {
            return true;
        }
        return false;
    }

    public a() {
        this.aut = new ConcurrentHashMap(8);
        this.auu = new com.kwad.sdk.core.network.idc.a.b();
        this.auv = new Random(System.currentTimeMillis());
        this.auw = new HashMap();
        this.aux = new ConcurrentHashMap(4);
        this.auz = 0;
        this.auA = false;
        this.auw.put("api", new AtomicBoolean(false));
        this.auw.put("ulog", new AtomicBoolean(false));
        this.auw.put("zt", new AtomicBoolean(false));
        this.auw.put("cdn", new AtomicBoolean(false));
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    private void dq(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        c.d("IdcManager", "save switched host, type = " + str);
        this.aux.put(str, new com.kwad.sdk.core.network.idc.a.a(elapsedRealtime, false));
    }

    private String dt(String str) {
        return this.aut.get(str);
    }

    public final String du(String str) {
        return W(str, "cdn");
    }

    public final void init(final Context context) {
        this.mContext = context.getApplicationContext();
        this.auA = true;
        g.execute(new ay() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.aut.putAll(b.bb(context));
                a.this.CK();
                if (!a.this.auu.isEmpty()) {
                    for (String str : a.this.auu.CQ()) {
                        a.this.ds(str);
                    }
                }
                c.d("IdcManager", "idc prepare done.");
                a.a(a.this, false);
            }
        });
    }

    @WorkerThread
    private void T(@NonNull String str, String str2) {
        String host;
        boolean z;
        boolean z2;
        StringBuilder sb;
        List<String> dv = this.auu.dv(str2);
        if (!dv.isEmpty() && (host = Uri.parse(str).getHost()) != null && !host.isEmpty()) {
            c.d("IdcManager", ">>> switchHost start, try get lock, type = " + str2 + ", old host = " + host);
            AtomicBoolean atomicBoolean = this.auw.get(str2);
            if (atomicBoolean.compareAndSet(false, true)) {
                try {
                    String dt = dt(str2);
                    if (!TextUtils.isEmpty(dt) && !host.equals(dt)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int size = dv.size();
                        int indexOf = dv.indexOf(host);
                        if (indexOf >= 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            size--;
                        }
                        if (size <= 0) {
                            atomicBoolean.set(false);
                            sb = new StringBuilder("<<< switchHost end, type = ");
                        } else {
                            int nextInt = this.auv.nextInt(size) + 1;
                            if (z2) {
                                nextInt += indexOf;
                            }
                            int size2 = nextInt % dv.size();
                            String str3 = dv.get(size2);
                            c.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + dv + ", key = " + size2);
                            V(str2, str3);
                            if (q(str2, size2)) {
                                dq(str2);
                            }
                            atomicBoolean.set(false);
                            sb = new StringBuilder("<<< switchHost end, type = ");
                        }
                    }
                    sb.append(str2);
                    sb.append(", old host = ");
                    sb.append(host);
                    c.d("IdcManager", sb.toString());
                } catch (Throwable th) {
                    atomicBoolean.set(false);
                    c.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                    throw th;
                }
            }
        }
    }

    private void V(String str, String str2) {
        c.d("IdcManager", "updateCurrentIdc: hostType = " + str + ",new host = " + str2);
        this.aut.put(str, str2);
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.mContext, a.this.aut);
            }
        });
    }

    private boolean q(String str, int i) {
        if ("api".equals(str) && i > 0 && !this.aux.containsKey(str) && this.auz > 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String U(String str, String str2) {
        String str3 = this.aut.get(str);
        if (TextUtils.isEmpty(str3)) {
            return str2;
        }
        return str3;
    }

    public final void g(String str, Throwable th) {
        a(str, "cdn", new DomainException(th));
    }

    public static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.auA = false;
        return false;
    }

    @WorkerThread
    public static boolean c(final String str, Context context) {
        boolean isNetworkConnected = ag.isNetworkConnected(context);
        c.d("IdcManager", "connect host = " + str + ",isNetworkConnected = " + isNetworkConnected);
        if (isNetworkConnected && str != null) {
            AdHttpProxy xI = f.xI();
            d dVar = new d() { // from class: com.kwad.sdk.core.network.idc.a.4
                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseBody() {
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseHeader() {
                }

                @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return com.kwad.sdk.g.bN("https://" + str);
                }
            };
            com.kwad.sdk.core.network.c doGet = xI.doGet(dVar.getUrl(), Collections.emptyMap());
            c.d("IdcManager", "perform connect host:" + dVar.getUrl());
            if (doGet != null) {
                c.d("IdcManager", "connect host response, rawCode = " + doGet.atk + ",body = " + doGet.atm);
                if (doGet.atk == 200) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String W(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String dt = dt(str2);
        if (dt != null && !dt.isEmpty()) {
            Uri parse = Uri.parse(str);
            if (TextUtils.isEmpty(parse.getPath())) {
                return str;
            }
            if (dt.equals(parse.getHost())) {
                return str;
            }
            Uri.Builder builder = new Uri.Builder();
            builder.authority(dt);
            if (TextUtils.isEmpty(parse.getScheme())) {
                builder.scheme("https");
            } else {
                builder.scheme(parse.getScheme());
            }
            builder.path(parse.getPath());
            if (!TextUtils.isEmpty(parse.getQuery())) {
                builder.query(parse.getQuery());
            }
            return URLDecoder.decode(builder.build().toString());
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public boolean ds(String str) {
        boolean fV;
        String str2;
        String dt = dt(str);
        List<String> dv = this.auu.dv(str);
        if (dv.isEmpty()) {
            return false;
        }
        String str3 = dv.get(0);
        if (TextUtils.equals(str3, dt)) {
            return true;
        }
        if ("api".equals(str)) {
            if (com.kwad.framework.a.a.mc.booleanValue()) {
                str2 = "beta2-ad-open-api.test.gifshow.com";
            } else {
                str2 = str3;
            }
            fV = c(str2, this.mContext);
        } else {
            fV = ag.fV(str3);
        }
        c.d("IdcManager", "perform ping action for " + str + ",mainHost = " + str3 + ",isSuccess = " + fV);
        if (fV) {
            V(str, str3);
        }
        return fV;
    }

    public final void a(com.kwad.sdk.core.network.idc.a.b bVar, int i) {
        this.auz = i * 1000;
        c.d("IdcManager", "updateIdcData,rollback interval = " + i);
        if (i == 0) {
            this.aux.clear();
        }
        this.auu.a(bVar);
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.mContext, a.this.auu);
            }
        });
    }

    public final void a(String str, int i, Throwable th) {
        a(str, "ulog", new DomainException(i, th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            T(str, str2);
        }
    }

    public final void dr(String str) {
        boolean z;
        int i = this.auz;
        if (!this.auA && i > 0) {
            com.kwad.sdk.core.network.idc.a.a aVar = this.aux.get(str);
            if (aVar != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - aVar.CO();
                if (elapsedRealtime > Math.max(i, auy)) {
                    z = true;
                } else {
                    z = false;
                }
                c.d("IdcManager", "handleHostRollback: isAvailable = " + z + ",interval = " + elapsedRealtime + ",rollbackInterval = " + i + ",hostType = hostType");
                if (z) {
                    AtomicBoolean atomicBoolean = this.auw.get(str);
                    try {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            boolean CN = aVar.CN();
                            c.d("IdcManager", "handleHostRollback: isInRollback = " + CN);
                            if (!CN) {
                                aVar.bm(true);
                                if (ds(str)) {
                                    this.aux.remove(str);
                                    c.d("IdcManager", "handleHostRollback success,remove switched host, type = " + str);
                                } else {
                                    c.d("IdcManager", "rollbackToMainHost failed, reset attempt time.");
                                    dq(str);
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        c.e("IdcManager", "handleHostRollback failed by " + e.getMessage());
                        return;
                    } finally {
                        atomicBoolean.set(false);
                        c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                    }
                }
                return;
            }
            return;
        }
        c.d("IdcManager", "performHostRollback is invalid, by in prepare = " + this.auA + ",rollbackInterval = " + i);
    }
}
