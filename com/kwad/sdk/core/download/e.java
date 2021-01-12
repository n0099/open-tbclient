package com.kwad.sdk.core.download;

import android.content.Context;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ad;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9120a = ad.a(KsAdSDKImpl.get().getContext()) + "/downloadFileSync/.temp";

    /* loaded from: classes4.dex */
    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        final OutputStream f9121a;

        public a(File file, boolean z) {
            this.f9121a = new FileOutputStream(file, z);
        }

        @Override // com.kwad.sdk.core.download.e.c
        public void a(int i, Map<String, List<String>> map) {
        }

        @Override // com.kwad.sdk.core.download.e.c
        public void a(long j) {
        }

        @Override // com.kwad.sdk.core.download.e.c
        public void a(byte[] bArr, int i, int i2) {
            this.f9121a.write(bArr, i, i2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f9121a.close();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(int i, int i2, Object obj);
    }

    /* loaded from: classes4.dex */
    public interface c extends Closeable {
        void a(int i, Map<String, List<String>> map);

        void a(long j);

        void a(byte[] bArr, int i, int i2);
    }

    public static URLConnection a(String str, int i, int i2, boolean z, boolean z2) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setRequestProperty("Accept-Language", "zh-CN");
            if (i > 0) {
                openConnection.setConnectTimeout(i);
            }
            if (i2 > 0) {
                openConnection.setReadTimeout(i2);
            }
            openConnection.setUseCaches(z);
            openConnection.setDoInput(true);
            openConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            openConnection.setRequestProperty("Charset", "UTF-8");
            return openConnection;
        } catch (MalformedURLException e) {
            com.kwad.sdk.core.d.a.a(e);
            return null;
        }
    }

    public static void a(Context context, AdInfo adInfo) {
        AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
        if (proxyForDownload != null) {
            DownloadParams transfrom = DownloadParams.transfrom(adInfo);
            proxyForDownload.startDownload(context, transfrom.mDownloadid, transfrom);
        }
    }

    public static void a(Context context, String str) {
        AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
        if (proxyForDownload != null) {
            proxyForDownload.pauseDownload(context, str, null);
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean a(String str, File file, b bVar, int i) {
        a aVar;
        try {
            aVar = new a(file, false);
        } catch (Throwable th) {
            th = th;
            aVar = null;
        }
        try {
            boolean a2 = a(str, (String) null, aVar, bVar, i);
            a(aVar);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            a(aVar);
            throw th;
        }
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i) {
        return a(str, str2, cVar, bVar, i, -1L, -1L, false);
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i, long j, long j2, boolean z) {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) a(str, 10000, i > 0 ? i : BdStatisticsManager.UPLOAD_TIMER_INTERVAL, false, true);
            try {
                if (httpURLConnection == null) {
                    throw new IOException("Fail to createUrlConnection");
                }
                boolean a2 = a(httpURLConnection, str2, cVar, bVar, i, j, j2, z);
                a(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a2;
            } catch (Throwable th) {
                th = th;
                a(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static boolean a(java.net.HttpURLConnection r17, java.lang.String r18, com.kwad.sdk.core.download.e.c r19, com.kwad.sdk.core.download.e.b r20, int r21, long r22, long r24, boolean r26) {
        /*
            r8 = 0
            r7 = 0
            r5 = 0
            r10 = 0
            int r4 = (r22 > r10 ? 1 : (r22 == r10 ? 0 : -1))
            if (r4 > 0) goto Lf
            r10 = 0
            int r4 = (r24 > r10 ? 1 : (r24 == r10 ? 0 : -1))
            if (r4 <= 0) goto L35
        Lf:
            java.lang.String r6 = "Range"
            java.lang.String r9 = "bytes=%s-%s"
            r4 = 2
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L1e4
            r4 = 0
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch: java.lang.Throwable -> L1e4
            r10[r4] = r11     // Catch: java.lang.Throwable -> L1e4
            r11 = 1
            r12 = 0
            int r4 = (r24 > r12 ? 1 : (r24 == r12 ? 0 : -1))
            if (r4 <= 0) goto L7b
            java.lang.Long r4 = java.lang.Long.valueOf(r24)     // Catch: java.lang.Throwable -> L1e4
        L2a:
            r10[r11] = r4     // Catch: java.lang.Throwable -> L1e4
            java.lang.String r4 = java.lang.String.format(r9, r10)     // Catch: java.lang.Throwable -> L1e4
            r0 = r17
            r0.setRequestProperty(r6, r4)     // Catch: java.lang.Throwable -> L1e4
        L35:
            boolean r4 = android.text.TextUtils.isEmpty(r18)     // Catch: java.lang.Throwable -> L1e4
            if (r4 != 0) goto L7f
            java.lang.String r4 = "Host"
            r0 = r17
            r1 = r18
            r0.setRequestProperty(r4, r1)     // Catch: java.lang.Throwable -> L1e4
            r4 = 0
            r0 = r17
            r0.setInstanceFollowRedirects(r4)     // Catch: java.lang.Throwable -> L1e4
            int r4 = r17.getResponseCode()     // Catch: java.lang.Throwable -> L1e4
            r6 = 302(0x12e, float:4.23E-43)
            if (r4 != r6) goto L7f
            java.lang.String r4 = "Location"
            r0 = r17
            java.lang.String r4 = r0.getHeaderField(r4)     // Catch: java.lang.Throwable -> L1e4
            r6 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            boolean r4 = a(r4, r6, r0, r1, r2)     // Catch: java.lang.Throwable -> L1e4
            a(r19)
            a(r8)
            if (r17 == 0) goto L72
            r17.disconnect()
        L72:
            a(r5)
            if (r7 == 0) goto L7a
            r7.delete()
        L7a:
            return r4
        L7b:
            java.lang.String r4 = ""
            goto L2a
        L7f:
            java.lang.String r4 = "User-Agent"
            java.lang.String r6 = com.kwad.sdk.core.network.k.a()     // Catch: java.lang.Throwable -> L1e4
            r0 = r17
            r0.setRequestProperty(r4, r6)     // Catch: java.lang.Throwable -> L1e4
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L1e4
            java.io.InputStream r4 = r17.getInputStream()     // Catch: java.lang.Throwable -> L1e4
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L1e4
            int r4 = r17.getContentLength()     // Catch: java.lang.Throwable -> L1e9
            java.util.Map r6 = r17.getHeaderFields()     // Catch: java.lang.Throwable -> L1e9
            if (r6 != 0) goto L10e
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L1e9
            r6.<init>()     // Catch: java.lang.Throwable -> L1e9
            r12 = r6
        La4:
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L1e9
            java.io.InputStream r6 = r17.getInputStream()     // Catch: java.lang.Throwable -> L1e9
            r10.<init>(r6)     // Catch: java.lang.Throwable -> L1e9
            if (r4 > 0) goto L1fc
            java.util.Random r4 = new java.util.Random     // Catch: java.lang.Throwable -> L1ed
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1ed
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L1ed
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> L1ed
            java.lang.String r6 = com.kwad.sdk.core.download.e.f9120a     // Catch: java.lang.Throwable -> L1ed
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1ed
            r9.<init>()     // Catch: java.lang.Throwable -> L1ed
            int r4 = r4.nextInt()     // Catch: java.lang.Throwable -> L1ed
            java.lang.StringBuilder r4 = r9.append(r4)     // Catch: java.lang.Throwable -> L1ed
            java.lang.String r9 = ".tmp"
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch: java.lang.Throwable -> L1ed
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L1ed
            r8.<init>(r6, r4)     // Catch: java.lang.Throwable -> L1ed
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1f2
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L1f2
            r4 = 10240(0x2800, float:1.4349E-41)
            byte[] r5 = new byte[r4]     // Catch: java.lang.Throwable -> Lee
            r4 = 0
        Le1:
            int r7 = r10.read(r5)     // Catch: java.lang.Throwable -> Lee
            r9 = -1
            if (r7 == r9) goto L119
            int r4 = r4 + r7
            r9 = 0
            r6.write(r5, r9, r7)     // Catch: java.lang.Throwable -> Lee
            goto Le1
        Lee:
            r4 = move-exception
            r7 = r8
            r9 = r10
        Lf1:
            boolean r5 = r4 instanceof java.io.IOException     // Catch: java.lang.Throwable -> Lf8
            if (r5 == 0) goto L19d
            java.io.IOException r4 = (java.io.IOException) r4     // Catch: java.lang.Throwable -> Lf8
        Lf7:
            throw r4     // Catch: java.lang.Throwable -> Lf8
        Lf8:
            r4 = move-exception
            r5 = r6
        Lfa:
            a(r19)
            a(r9)
            if (r17 == 0) goto L105
            r17.disconnect()
        L105:
            a(r5)
            if (r7 == 0) goto L10d
            r7.delete()
        L10d:
            throw r4
        L10e:
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L1e9
            java.util.Map r8 = r17.getHeaderFields()     // Catch: java.lang.Throwable -> L1e9
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L1e9
            r12 = r6
            goto La4
        L119:
            a(r10)     // Catch: java.lang.Throwable -> Lee
            a(r6)     // Catch: java.lang.Throwable -> Lee
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> Lee
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lee
            r5.<init>(r8)     // Catch: java.lang.Throwable -> Lee
            r9.<init>(r5)     // Catch: java.lang.Throwable -> Lee
            java.lang.String r5 = "Content-Length"
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L1f8
            java.util.List r7 = java.util.Collections.singletonList(r7)     // Catch: java.lang.Throwable -> L1f8
            r12.put(r5, r7)     // Catch: java.lang.Throwable -> L1f8
            r11 = r4
            r5 = r6
            r7 = r8
        L13a:
            r14 = 0
            int r4 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r4 <= 0) goto L17d
            if (r26 == 0) goto L17d
            r0 = r22
            int r4 = (int) r0
        L145:
            int r6 = r11 + r4
            long r10 = (long) r6
            r0 = r19
            r0.a(r10)     // Catch: java.lang.Throwable -> L179
            int r8 = r17.getResponseCode()     // Catch: java.lang.Throwable -> L179
            r0 = r19
            r0.a(r8, r12)     // Catch: java.lang.Throwable -> L179
            if (r20 == 0) goto L15e
            r8 = 0
            r0 = r20
            r0.a(r4, r6, r8)     // Catch: java.lang.Throwable -> L179
        L15e:
            r8 = 10240(0x2800, float:1.4349E-41)
            byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> L179
        L162:
            int r10 = r9.read(r8)     // Catch: java.lang.Throwable -> L179
            r11 = -1
            if (r10 == r11) goto L17f
            int r4 = r4 + r10
            r11 = 0
            r0 = r19
            r0.a(r8, r11, r10)     // Catch: java.lang.Throwable -> L179
            if (r20 == 0) goto L162
            r10 = 0
            r0 = r20
            r0.a(r4, r6, r10)     // Catch: java.lang.Throwable -> L179
            goto L162
        L179:
            r4 = move-exception
            r6 = r5
            goto Lf1
        L17d:
            r4 = 0
            goto L145
        L17f:
            if (r20 == 0) goto L187
            r4 = 0
            r0 = r20
            r0.a(r6, r6, r4)     // Catch: java.lang.Throwable -> L179
        L187:
            r4 = 1
            a(r19)
            a(r9)
            if (r17 == 0) goto L193
            r17.disconnect()
        L193:
            a(r5)
            if (r7 == 0) goto L7a
            r7.delete()
            goto L7a
        L19d:
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> Lf8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf8
            r8.<init>()     // Catch: java.lang.Throwable -> Lf8
            java.lang.Class r10 = r4.getClass()     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r10 = r10.getName()     // Catch: java.lang.Throwable -> Lf8
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r10 = ":"
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r10 = r4.getMessage()     // Catch: java.lang.Throwable -> Lf8
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Lf8
            r5.<init>(r8, r4)     // Catch: java.lang.Throwable -> Lf8
            r4 = r5
            goto Lf7
        L1c9:
            r4 = move-exception
            r9 = r8
            goto Lfa
        L1cd:
            r4 = move-exception
            goto Lfa
        L1d0:
            r4 = move-exception
            r9 = r10
            goto Lfa
        L1d4:
            r4 = move-exception
            r7 = r8
            r9 = r10
            goto Lfa
        L1d9:
            r4 = move-exception
            r5 = r6
            r7 = r8
            r9 = r10
            goto Lfa
        L1df:
            r4 = move-exception
            r5 = r6
            r7 = r8
            goto Lfa
        L1e4:
            r4 = move-exception
            r6 = r5
            r9 = r8
            goto Lf1
        L1e9:
            r4 = move-exception
            r6 = r5
            goto Lf1
        L1ed:
            r4 = move-exception
            r6 = r5
            r9 = r10
            goto Lf1
        L1f2:
            r4 = move-exception
            r6 = r5
            r7 = r8
            r9 = r10
            goto Lf1
        L1f8:
            r4 = move-exception
            r7 = r8
            goto Lf1
        L1fc:
            r11 = r4
            r9 = r10
            goto L13a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.e.a(java.net.HttpURLConnection, java.lang.String, com.kwad.sdk.core.download.e$c, com.kwad.sdk.core.download.e$b, int, long, long, boolean):boolean");
    }
}
