package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.g;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class a {
    public final Map<String, String> Za;
    public final com.kwad.sdk.core.network.idc.kwai.a Zb;
    public final Random Zc;
    public final Map<String, AtomicBoolean> Zd;
    public Context mContext;

    /* renamed from: com.kwad.sdk.core.network.idc.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0630a {
        public static final a Zf = new a((byte) 0);
    }

    public a() {
        this.Za = new ConcurrentHashMap(8);
        this.Zb = new com.kwad.sdk.core.network.idc.kwai.a();
        this.Zc = new Random(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        this.Zd = hashMap;
        hashMap.put("api", new AtomicBoolean(false));
        this.Zd.put(INet.HostType.ULOG, new AtomicBoolean(false));
        this.Zd.put(INet.HostType.ZT, new AtomicBoolean(false));
        this.Zd.put(INet.HostType.CDN, new AtomicBoolean(false));
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    @WorkerThread
    private void E(@NonNull String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> ca = this.Zb.ca(str2);
        if (ca.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.e.b.d("IdcManager", ">>> switchHost start, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.Zd.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String bY = bY(str2);
                if ((TextUtils.isEmpty(bY) || host.equals(bY)) ? false : true) {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                } else {
                    int size = ca.size();
                    int indexOf = ca.indexOf(host);
                    boolean z = indexOf >= 0;
                    if (z) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int nextInt = this.Zc.nextInt(size) + 1;
                        if (z) {
                            nextInt += indexOf;
                        }
                        int size2 = nextInt % ca.size();
                        String str3 = ca.get(size2);
                        com.kwad.sdk.core.e.b.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + ca + ", key = " + size2);
                        G(str2, str3);
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                }
                sb.append(str2);
                sb.append(", old host = ");
                sb.append(host);
                com.kwad.sdk.core.e.b.d("IdcManager", sb.toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                com.kwad.sdk.core.e.b.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    private void G(String str, String str2) {
        this.Za.put(str, str2);
        g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.mContext, a.this.Za);
            }
        });
    }

    public static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void bX(String str) {
        String bY = bY(str);
        List<String> ca = this.Zb.ca(str);
        if (ca.isEmpty()) {
            return;
        }
        String str2 = ca.get(0);
        if (!TextUtils.equals(str2, bY) && ae.dN(str2)) {
            G(str, str2);
        }
    }

    private String bY(String str) {
        return this.Za.get(str);
    }

    public static a tH() {
        return C0630a.Zf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void tI() {
        com.kwad.sdk.core.network.idc.kwai.a bt = b.bt(this.mContext);
        if (bt.isEmpty()) {
            bt = b.bs(this.mContext);
        }
        this.Zb.b(bt);
    }

    @Nullable
    public final String F(String str, String str2) {
        String str3 = this.Za.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final String H(String str, String str2) {
        if (str == null) {
            return "";
        }
        String bY = bY(str2);
        if (bY == null || bY.isEmpty()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getPath()) || bY.equals(parse.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(bY);
        builder.scheme(TextUtils.isEmpty(parse.getScheme()) ? "https" : parse.getScheme());
        builder.path(parse.getPath());
        if (!TextUtils.isEmpty(parse.getQuery())) {
            builder.query(parse.getQuery());
        }
        return URLDecoder.decode(builder.build().toString());
    }

    public final void a(com.kwad.sdk.core.network.idc.kwai.a aVar) {
        this.Zb.b(aVar);
        g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.mContext, a.this.Zb);
            }
        });
    }

    public final void a(String str, int i, Throwable th) {
        a(str, INet.HostType.ULOG, new DomainException(i, th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            E(str, str2);
        }
    }

    public final String bZ(String str) {
        return H(str, INet.HostType.CDN);
    }

    public final void d(String str, Throwable th) {
        a(str, INet.HostType.CDN, new DomainException(th));
    }

    public final void init(Context context) {
        this.mContext = context.getApplicationContext();
        this.Za.putAll(b.bu(context));
        g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.tI();
                    if (a.this.Zb.isEmpty()) {
                        return;
                    }
                    for (String str : a.this.Zb.tL()) {
                        a.this.bX(str);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTrace(th);
                }
            }
        });
    }
}
