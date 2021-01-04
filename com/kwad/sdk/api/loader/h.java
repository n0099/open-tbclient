package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8503a = a(Loader.get().getContext()) + "/apkfileD/dynamic";

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(File file);
    }

    /* loaded from: classes5.dex */
    public static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        final OutputStream f8506a;

        public b(File file, boolean z) {
            this.f8506a = new FileOutputStream(file, z);
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(int i, Map<String, List<String>> map) {
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(long j) {
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(byte[] bArr, int i, int i2) {
            this.f8506a.write(bArr, i, i2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f8506a.close();
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        boolean a(int i, int i2, Object obj);
    }

    /* loaded from: classes5.dex */
    public interface d extends Closeable {
        void a(int i, Map<String, List<String>> map);

        void a(long j);

        void a(byte[] bArr, int i, int i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context) {
        String str;
        File file;
        String path;
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError e) {
            str = "";
        } catch (NullPointerException e2) {
            str = "";
        }
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            try {
                file = context.getExternalFilesDir(null);
            } catch (Exception e3) {
                file = null;
            }
            if (file != null) {
                path = file.getPath();
                if (TextUtils.isEmpty(path)) {
                    path = context.getFilesDir().getPath();
                }
                return path + File.separator + "ksadsdk";
            }
        }
        path = null;
        if (TextUtils.isEmpty(path)) {
        }
        return path + File.separator + "ksadsdk";
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
            return null;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final String str, String str2, final a aVar) {
        final File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        i.a(new Runnable() { // from class: com.kwad.sdk.api.loader.h.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean a2 = h.a(str, file, null, 0);
                    if (aVar != null) {
                        if (a2) {
                            aVar.a(file);
                        } else {
                            aVar.a();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            }
        });
    }

    public static boolean a(String str, File file, c cVar, int i) {
        b bVar;
        try {
            bVar = new b(file, false);
        } catch (Throwable th) {
            th = th;
            bVar = null;
        }
        try {
            boolean a2 = a(str, (String) null, bVar, cVar, i);
            a(bVar);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            a(bVar);
            throw th;
        }
    }

    public static boolean a(String str, String str2, d dVar, c cVar, int i) {
        return a(str, str2, dVar, cVar, i, -1L, -1L, false);
    }

    public static boolean a(String str, String str2, d dVar, c cVar, int i, long j, long j2, boolean z) {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) a(str, 10000, i > 0 ? i : BdStatisticsManager.UPLOAD_TIMER_INTERVAL, false, true);
            try {
                if (httpURLConnection == null) {
                    throw new IOException("Fail to createUrlConnection");
                }
                boolean a2 = a(httpURLConnection, str2, dVar, cVar, i, j, j2, z);
                a(dVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a2;
            } catch (Throwable th) {
                th = th;
                a(dVar);
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
    public static boolean a(java.net.HttpURLConnection r17, java.lang.String r18, com.kwad.sdk.api.loader.h.d r19, com.kwad.sdk.api.loader.h.c r20, int r21, long r22, long r24, boolean r26) {
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
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L1f7
            r4 = 0
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch: java.lang.Throwable -> L1f7
            r10[r4] = r11     // Catch: java.lang.Throwable -> L1f7
            r11 = 1
            r12 = 0
            int r4 = (r24 > r12 ? 1 : (r24 == r12 ? 0 : -1))
            if (r4 <= 0) goto L7b
            java.lang.Long r4 = java.lang.Long.valueOf(r24)     // Catch: java.lang.Throwable -> L1f7
        L2a:
            r10[r11] = r4     // Catch: java.lang.Throwable -> L1f7
            java.lang.String r4 = java.lang.String.format(r9, r10)     // Catch: java.lang.Throwable -> L1f7
            r0 = r17
            r0.setRequestProperty(r6, r4)     // Catch: java.lang.Throwable -> L1f7
        L35:
            boolean r4 = android.text.TextUtils.isEmpty(r18)     // Catch: java.lang.Throwable -> L1f7
            if (r4 != 0) goto L7f
            java.lang.String r4 = "Host"
            r0 = r17
            r1 = r18
            r0.setRequestProperty(r4, r1)     // Catch: java.lang.Throwable -> L1f7
            r4 = 0
            r0 = r17
            r0.setInstanceFollowRedirects(r4)     // Catch: java.lang.Throwable -> L1f7
            int r4 = r17.getResponseCode()     // Catch: java.lang.Throwable -> L1f7
            r6 = 302(0x12e, float:4.23E-43)
            if (r4 != r6) goto L7f
            java.lang.String r4 = "Location"
            r0 = r17
            java.lang.String r4 = r0.getHeaderField(r4)     // Catch: java.lang.Throwable -> L1f7
            r6 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            boolean r4 = a(r4, r6, r0, r1, r2)     // Catch: java.lang.Throwable -> L1f7
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
            java.lang.String r6 = com.kwad.sdk.api.core.RequestParamsUtils.getUserAgent()     // Catch: java.lang.Throwable -> L1f7
            r0 = r17
            r0.setRequestProperty(r4, r6)     // Catch: java.lang.Throwable -> L1f7
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L1f7
            java.io.InputStream r4 = r17.getInputStream()     // Catch: java.lang.Throwable -> L1f7
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L1f7
            int r4 = r17.getContentLength()     // Catch: java.lang.Throwable -> L1fc
            java.util.Map r6 = r17.getHeaderFields()     // Catch: java.lang.Throwable -> L1fc
            if (r6 != 0) goto L10e
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L1fc
            r6.<init>()     // Catch: java.lang.Throwable -> L1fc
            r12 = r6
        La4:
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L1fc
            java.io.InputStream r6 = r17.getInputStream()     // Catch: java.lang.Throwable -> L1fc
            r10.<init>(r6)     // Catch: java.lang.Throwable -> L1fc
            if (r4 > 0) goto L216
            java.util.Random r4 = new java.util.Random     // Catch: java.lang.Throwable -> L200
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L200
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L200
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> L200
            java.lang.String r6 = com.kwad.sdk.api.loader.h.f8503a     // Catch: java.lang.Throwable -> L200
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L200
            r9.<init>()     // Catch: java.lang.Throwable -> L200
            int r4 = r4.nextInt()     // Catch: java.lang.Throwable -> L200
            java.lang.StringBuilder r4 = r9.append(r4)     // Catch: java.lang.Throwable -> L200
            java.lang.String r9 = ".tmp"
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch: java.lang.Throwable -> L200
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L200
            r8.<init>(r6, r4)     // Catch: java.lang.Throwable -> L200
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L205
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L205
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
            if (r5 == 0) goto L1ac
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
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L1fc
            java.util.Map r8 = r17.getHeaderFields()     // Catch: java.lang.Throwable -> L1fc
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L1fc
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
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L20b
            java.util.List r7 = java.util.Collections.singletonList(r7)     // Catch: java.lang.Throwable -> L20b
            r12.put(r5, r7)     // Catch: java.lang.Throwable -> L20b
            r11 = r4
            r5 = r6
            r7 = r8
        L13a:
            r14 = 0
            int r4 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r4 <= 0) goto L18c
            if (r26 == 0) goto L18c
            r0 = r22
            int r4 = (int) r0
        L145:
            int r6 = r11 + r4
            long r10 = (long) r6
            r0 = r19
            r0.a(r10)     // Catch: java.lang.Throwable -> L20f
            int r8 = r17.getResponseCode()     // Catch: java.lang.Throwable -> L20f
            r0 = r19
            r0.a(r8, r12)     // Catch: java.lang.Throwable -> L20f
            if (r20 == 0) goto L15e
            r8 = 0
            r0 = r20
            r0.a(r4, r6, r8)     // Catch: java.lang.Throwable -> L20f
        L15e:
            r8 = 10240(0x2800, float:1.4349E-41)
            byte[] r10 = new byte[r8]     // Catch: java.lang.Throwable -> L20f
            com.kwad.sdk.api.core.SpeedLimitApi r8 = com.kwad.sdk.api.core.SpeedLimitApiHolder.getInstance()     // Catch: java.lang.Throwable -> L20f
            if (r8 == 0) goto L213
            com.kwad.sdk.api.core.SpeedLimitApi r8 = com.kwad.sdk.api.core.SpeedLimitApiHolder.getInstance()     // Catch: java.lang.Throwable -> L20f
            java.io.InputStream r8 = r8.wrapInputStream(r9)     // Catch: java.lang.Throwable -> L20f
        L170:
            int r9 = r8.read(r10)     // Catch: java.lang.Throwable -> L187
            r11 = -1
            if (r9 == r11) goto L18e
            int r4 = r4 + r9
            r11 = 0
            r0 = r19
            r0.a(r10, r11, r9)     // Catch: java.lang.Throwable -> L187
            if (r20 == 0) goto L170
            r9 = 0
            r0 = r20
            r0.a(r4, r6, r9)     // Catch: java.lang.Throwable -> L187
            goto L170
        L187:
            r4 = move-exception
            r6 = r5
            r9 = r8
            goto Lf1
        L18c:
            r4 = 0
            goto L145
        L18e:
            if (r20 == 0) goto L196
            r4 = 0
            r0 = r20
            r0.a(r6, r6, r4)     // Catch: java.lang.Throwable -> L187
        L196:
            r4 = 1
            a(r19)
            a(r8)
            if (r17 == 0) goto L1a2
            r17.disconnect()
        L1a2:
            a(r5)
            if (r7 == 0) goto L7a
            r7.delete()
            goto L7a
        L1ac:
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
        L1d8:
            r4 = move-exception
            r9 = r8
            goto Lfa
        L1dc:
            r4 = move-exception
            goto Lfa
        L1df:
            r4 = move-exception
            r9 = r10
            goto Lfa
        L1e3:
            r4 = move-exception
            r7 = r8
            r9 = r10
            goto Lfa
        L1e8:
            r4 = move-exception
            r5 = r6
            r7 = r8
            r9 = r10
            goto Lfa
        L1ee:
            r4 = move-exception
            r5 = r6
            r7 = r8
            goto Lfa
        L1f3:
            r4 = move-exception
            r9 = r8
            goto Lfa
        L1f7:
            r4 = move-exception
            r6 = r5
            r9 = r8
            goto Lf1
        L1fc:
            r4 = move-exception
            r6 = r5
            goto Lf1
        L200:
            r4 = move-exception
            r6 = r5
            r9 = r10
            goto Lf1
        L205:
            r4 = move-exception
            r6 = r5
            r7 = r8
            r9 = r10
            goto Lf1
        L20b:
            r4 = move-exception
            r7 = r8
            goto Lf1
        L20f:
            r4 = move-exception
            r6 = r5
            goto Lf1
        L213:
            r8 = r9
            goto L170
        L216:
            r11 = r4
            r9 = r10
            goto L13a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.h.a(java.net.HttpURLConnection, java.lang.String, com.kwad.sdk.api.loader.h$d, com.kwad.sdk.api.loader.h$c, int, long, long, boolean):boolean");
    }
}
