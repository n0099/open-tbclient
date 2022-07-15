package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.g;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class a {
    public final Map<String, String> a;
    public final com.kwad.sdk.core.network.idc.kwai.a b;
    public Context c;
    public final Random d;
    public final Map<String, AtomicBoolean> e;

    /* renamed from: com.kwad.sdk.core.network.idc.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0543a {
        public static final a a = new a((byte) 0);
    }

    public a() {
        this.a = new ConcurrentHashMap(8);
        this.b = new com.kwad.sdk.core.network.idc.kwai.a();
        this.d = new Random(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        this.e = hashMap;
        hashMap.put("api", new AtomicBoolean(false));
        this.e.put(INet.HostType.ULOG, new AtomicBoolean(false));
        this.e.put(INet.HostType.ZT, new AtomicBoolean(false));
        this.e.put(INet.HostType.CDN, new AtomicBoolean(false));
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0543a.a;
    }

    public static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void b() {
        com.kwad.sdk.core.network.idc.kwai.a b = b.b(this.c);
        if (b.a()) {
            b = b.a(this.c);
        }
        this.b.a(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void b(String str) {
        String c = c(str);
        List<String> a = this.b.a(str);
        if (a.isEmpty()) {
            return;
        }
        String str2 = a.get(0);
        if (!TextUtils.equals(str2, c) && ac.a(str2)) {
            d(str, str2);
        }
    }

    private String c(String str) {
        return this.a.get(str);
    }

    @WorkerThread
    private void c(@NonNull String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> a = this.b.a(str2);
        if (a.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.b.a("IdcManager", ">>> switchHost start, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.e.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String c = c(str2);
                if ((TextUtils.isEmpty(c) || host.equals(c)) ? false : true) {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                } else {
                    int size = a.size();
                    int indexOf = a.indexOf(host);
                    boolean z = indexOf >= 0;
                    if (z) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int nextInt = this.d.nextInt(size) + 1;
                        if (z) {
                            nextInt += indexOf;
                        }
                        int size2 = nextInt % a.size();
                        String str3 = a.get(size2);
                        com.kwad.sdk.core.d.b.a("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + a + ", key = " + size2);
                        d(str2, str3);
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                }
                sb.append(str2);
                sb.append(", old host = ");
                sb.append(host);
                com.kwad.sdk.core.d.b.a("IdcManager", sb.toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                com.kwad.sdk.core.d.b.a("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    private void d(String str, String str2) {
        this.a.put(str, str2);
        g.a(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.c, a.this.a);
            }
        });
    }

    public final String a(String str) {
        return b(str, INet.HostType.CDN);
    }

    @Nullable
    public final String a(String str, String str2) {
        String str3 = this.a.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final void a(Context context) {
        this.c = context.getApplicationContext();
        this.a.putAll(b.c(context));
        g.a(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b();
                if (a.this.b.a()) {
                    return;
                }
                for (String str : a.this.b.b()) {
                    a.this.b(str);
                }
            }
        });
    }

    public final void a(com.kwad.sdk.core.network.idc.kwai.a aVar) {
        this.b.a(aVar);
        g.a(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.c, a.this.b);
            }
        });
    }

    public final void a(String str, int i, Throwable th) {
        a(str, INet.HostType.ULOG, new DomainException(i, th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            c(str, str2);
        }
    }

    public final void a(String str, Throwable th) {
        a(str, INet.HostType.CDN, new DomainException(th));
    }

    public final String b(String str, String str2) {
        if (str == null) {
            return "";
        }
        String c = c(str2);
        if (c == null || c.isEmpty()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getPath()) || c.equals(parse.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(c);
        builder.scheme(TextUtils.isEmpty(parse.getScheme()) ? "https" : parse.getScheme());
        builder.path(parse.getPath());
        if (!TextUtils.isEmpty(parse.getQuery())) {
            builder.query(parse.getQuery());
        }
        return URLDecoder.decode(builder.build().toString());
    }
}
