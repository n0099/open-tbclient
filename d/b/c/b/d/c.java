package d.b.c.b.d;

import android.os.SystemClock;
import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.f.b;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes5.dex */
public class c implements d.b.c.b.f.c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f65015c = q.f65089b;

    /* renamed from: a  reason: collision with root package name */
    public final d.b.c.b.f.a f65016a;

    /* renamed from: b  reason: collision with root package name */
    public final d f65017b;

    public c(d.b.c.b.f.a aVar) {
        this(aVar, new d(4096));
    }

    public static List<a> b(List<a> list, b.a aVar) {
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (list != null && !list.isEmpty()) {
            for (a aVar2 : list) {
                treeSet.add(aVar2.a());
                arrayList.add(aVar2);
            }
        }
        if (aVar != null) {
            List<a> list2 = aVar.f65112i;
            if (list2 != null) {
                if (!list2.isEmpty()) {
                    for (a aVar3 : aVar.f65112i) {
                        if (!treeSet.contains(aVar3.a())) {
                            arrayList.add(aVar3);
                        }
                    }
                }
            } else if (!aVar.f65111h.isEmpty()) {
                for (Map.Entry<String, String> entry : aVar.f65111h.entrySet()) {
                    if (!treeSet.contains(entry.getKey())) {
                        arrayList.add(new a(entry.getKey(), entry.getValue()));
                    }
                }
            }
        }
        return arrayList;
    }

    public static void e(String str, Request<?> request, VAdError vAdError) throws VAdError {
        d.b.c.b.f.e retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.a(vAdError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VAdError e2) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c2, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0150, code lost:
        throw new com.bytedance.sdk.adnet.err.f(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0179 A[SYNTHETIC] */
    @Override // d.b.c.b.f.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k a(Request<?> request) throws VAdError {
        List<a> list;
        byte[] bArr;
        Throwable th;
        byte[] f2;
        c cVar;
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<a> emptyList = Collections.emptyList();
            b bVar = null;
            try {
                b a2 = this.f65016a.a(request, c(request.getCacheEntry()));
                try {
                    try {
                        int d2 = a2.d();
                        List<a> c2 = a2.c();
                        if (d2 == 304) {
                            try {
                                b.a cacheEntry = request.getCacheEntry();
                                if (cacheEntry == null) {
                                    k kVar = new k(304, (byte[]) null, true, SystemClock.elapsedRealtime() - elapsedRealtime, c2);
                                    if (a2 != null) {
                                        try {
                                            if (a2.a() != null) {
                                                a2.a().close();
                                            }
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    return kVar;
                                }
                                k kVar2 = new k(304, cacheEntry.f65105b, true, SystemClock.elapsedRealtime() - elapsedRealtime, b(c2, cacheEntry));
                                if (a2 != null) {
                                    try {
                                        if (a2.a() != null) {
                                            a2.a().close();
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                }
                                return kVar2;
                            } catch (IOException e2) {
                                e = e2;
                                bArr = null;
                                bVar = a2;
                                list = c2;
                            }
                        } else {
                            try {
                                f2 = f(request, a2);
                                try {
                                    cVar = this;
                                    cVar.d(SystemClock.elapsedRealtime() - elapsedRealtime, request, f2, d2);
                                } catch (IOException e3) {
                                    e = e3;
                                    cVar = c2;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                emptyList = c2;
                                list = emptyList;
                                bArr = null;
                                bVar = a2;
                                if (bVar != null) {
                                }
                            }
                            try {
                                if (d2 < 200 || d2 > 299) {
                                    break;
                                }
                                k kVar3 = new k(d2, f2, false, SystemClock.elapsedRealtime() - elapsedRealtime, c2);
                                if (a2 != null) {
                                    try {
                                        if (a2.a() != null) {
                                            a2.a().close();
                                        }
                                    } catch (Throwable unused3) {
                                    }
                                }
                                return kVar3;
                            } catch (IOException e5) {
                                e = e5;
                                list = cVar;
                                bVar = a2;
                                bArr = f2;
                                if (bVar != null) {
                                }
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                    }
                } catch (MalformedURLException e7) {
                    e = e7;
                    throw new RuntimeException("Bad URL " + request.getUrl(), e);
                } catch (SocketTimeoutException unused4) {
                    bVar = a2;
                    e("socket", request, new com.bytedance.sdk.adnet.err.g(602));
                    if (bVar != null && bVar.a() != null) {
                        bVar.a().close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = a2;
                    if (bVar != null) {
                    }
                    throw th;
                }
            } catch (MalformedURLException e8) {
                e = e8;
            } catch (SocketTimeoutException unused5) {
            } catch (IOException e9) {
                e = e9;
                list = emptyList;
                bArr = null;
            }
            if (bVar != null) {
                try {
                    int d3 = bVar.d();
                    q.d("Unexpected response code %d for %s", Integer.valueOf(d3), request.getUrl());
                    if (bArr != null) {
                        k kVar4 = new k(d3, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, list);
                        if (d3 != 401 && d3 != 403) {
                            if (d3 >= 400 && d3 <= 499) {
                                throw new com.bytedance.sdk.adnet.err.b(kVar4);
                            }
                            if (d3 < 500 || d3 > 599) {
                                break;
                            } else if (request.shouldRetryServerErrors()) {
                                e("server", request, new com.bytedance.sdk.adnet.err.f(kVar4));
                            } else {
                                throw new com.bytedance.sdk.adnet.err.f(kVar4);
                            }
                        }
                        e("auth", request, new com.bytedance.sdk.adnet.err.a(kVar4));
                    } else {
                        e("network", request, new com.bytedance.sdk.adnet.err.c(603));
                    }
                    if (bVar != null) {
                        try {
                            if (bVar.a() != null) {
                                bVar.a().close();
                            }
                        } catch (Throwable unused6) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bVar != null) {
                        try {
                            if (bVar.a() != null) {
                                bVar.a().close();
                            }
                        } catch (Throwable unused7) {
                        }
                    }
                    throw th;
                }
            } else {
                throw new com.bytedance.sdk.adnet.err.d(e, 601);
            }
        }
    }

    public final Map<String, String> c(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.f65106c;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = aVar.f65108e;
        if (j > 0) {
            hashMap.put("If-Modified-Since", d.b.c.b.e.c.c(j));
        }
        return hashMap;
    }

    public final void d(long j, Request<?> request, byte[] bArr, int i2) {
        if (f65015c || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : StringUtil.NULL_STRING;
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().b());
            q.c("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    public byte[] f(Request<?> request, b bVar) throws IOException, com.bytedance.sdk.adnet.err.f {
        if (request instanceof d.b.c.b.b.c) {
            return ((d.b.c.b.b.c) request).g(bVar);
        }
        InputStream a2 = bVar.a();
        return a2 != null ? g(a2, bVar.b()) : new byte[0];
    }

    public final byte[] g(InputStream inputStream, int i2) throws IOException, com.bytedance.sdk.adnet.err.f {
        e eVar = new e(this.f65017b, i2);
        try {
            if (inputStream != null) {
                byte[] c2 = this.f65017b.c(1024);
                while (true) {
                    int read = inputStream.read(c2);
                    if (read == -1) {
                        break;
                    }
                    eVar.write(c2, 0, read);
                }
                byte[] byteArray = eVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        q.a("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f65017b.b(c2);
                eVar.close();
                return byteArray;
            }
            throw new com.bytedance.sdk.adnet.err.f(606);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    q.a("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f65017b.b(null);
            eVar.close();
            throw th;
        }
    }

    public c(d.b.c.b.f.a aVar, d dVar) {
        this.f65016a = aVar;
        this.f65017b = dVar;
    }
}
