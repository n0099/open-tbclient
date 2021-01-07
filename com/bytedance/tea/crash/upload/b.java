package com.bytedance.tea.crash.upload;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.AbstractBceClient;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7973a = false;
    private static c pqu;

    public static f a(long j, String str, byte[] bArr, a aVar, String str2, boolean z) throws IOException {
        byte[] bArr2;
        String str3;
        String str4;
        if (str == null) {
            return new f(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str5 = null;
        if (a.GZIP == aVar && length > 128) {
            str5 = "gzip";
            bArr2 = b(bArr);
        } else if (a.DEFLATER != aVar || length <= 128) {
            bArr2 = bArr;
        } else {
            str5 = "deflate";
            bArr2 = a(bArr);
        }
        if (bArr2 == null) {
            return new f(202);
        }
        if (z) {
            byte[] a2 = TTEncryptUtils.a(bArr2, bArr2.length);
            if (a2 != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    if (!str.endsWith("?")) {
                        str = str + "?";
                    }
                } else if (!str.endsWith(ETAG.ITEM_SEPARATOR)) {
                    str = str + ETAG.ITEM_SEPARATOR;
                }
                str4 = str + "tt_data=a";
                str3 = "application/octet-stream;tt-data=a";
                bArr2 = a2;
            } else {
                str3 = str2;
                str4 = str;
            }
            return a(str4, bArr2, str3, str5, "POST", true, true);
        }
        return a(str, bArr2, str2, str5, "POST", true, false);
    }

    private static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] b(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                j.b(th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [216=5, 218=4, 222=4] */
    private static com.bytedance.tea.crash.upload.f a(java.lang.String r7, byte[] r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, boolean r12, boolean r13) {
        /*
            r3 = 0
            com.bytedance.tea.crash.upload.c r0 = com.bytedance.tea.crash.upload.b.pqu     // Catch: java.lang.Throwable -> L63
            if (r0 == 0) goto Lb
            com.bytedance.tea.crash.upload.c r0 = com.bytedance.tea.crash.upload.b.pqu     // Catch: java.lang.Throwable -> L63
            java.lang.String r7 = r0.a(r7, r8)     // Catch: java.lang.Throwable -> L63
        Lb:
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch: java.lang.Throwable -> L63
            r1.<init>()     // Catch: java.lang.Throwable -> L63
            if (r13 == 0) goto L5d
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L63
            java.lang.String r2 = com.bytedance.tea.a.a.a.a.a(r7, r1)     // Catch: java.lang.Throwable -> L63
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L63
        L1b:
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> L63
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> L63
            if (r13 == 0) goto L68
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L68
            java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> L47
        L2d:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L68
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Throwable -> L47
            android.util.Pair r1 = (android.util.Pair) r1     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L2d
            java.lang.Object r2 = r1.first     // Catch: java.lang.Throwable -> L47
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L47
            java.lang.Object r1 = r1.second     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L47
            r0.setRequestProperty(r2, r1)     // Catch: java.lang.Throwable -> L47
            goto L2d
        L47:
            r1 = move-exception
            r2 = r3
            r5 = r0
        L4a:
            com.bytedance.tea.crash.g.j.b(r1)     // Catch: java.lang.Throwable -> L140
            com.bytedance.tea.crash.upload.f r0 = new com.bytedance.tea.crash.upload.f     // Catch: java.lang.Throwable -> L140
            r3 = 207(0xcf, float:2.9E-43)
            r0.<init>(r3, r1)     // Catch: java.lang.Throwable -> L140
            if (r5 == 0) goto L59
            r5.disconnect()     // Catch: java.lang.Exception -> L130
        L59:
            com.bytedance.tea.crash.g.f.a(r2)
        L5c:
            return r0
        L5d:
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L63
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L63
            goto L1b
        L63:
            r0 = move-exception
            r1 = r0
            r2 = r3
            r5 = r3
            goto L4a
        L68:
            if (r12 == 0) goto L9e
            r1 = 1
            r0.setDoOutput(r1)     // Catch: java.lang.Throwable -> L47
        L6e:
            if (r9 == 0) goto L76
            java.lang.String r1 = "Content-Type"
            r0.setRequestProperty(r1, r9)     // Catch: java.lang.Throwable -> L47
        L76:
            if (r10 == 0) goto L7e
            java.lang.String r1 = "Content-Encoding"
            r0.setRequestProperty(r1, r10)     // Catch: java.lang.Throwable -> L47
        L7e:
            java.lang.String r1 = "Accept-Encoding"
            java.lang.String r2 = "gzip"
            r0.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L47
            if (r11 != 0) goto La3
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L47
            java.lang.String r2 = "request method is not null"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L47
            throw r1     // Catch: java.lang.Throwable -> L47
        L92:
            r1 = move-exception
            r4 = r3
            r5 = r0
        L95:
            if (r5 == 0) goto L9a
            r5.disconnect()     // Catch: java.lang.Exception -> L133
        L9a:
            com.bytedance.tea.crash.g.f.a(r4)
            throw r1
        L9e:
            r1 = 0
            r0.setDoOutput(r1)     // Catch: java.lang.Throwable -> L47
            goto L6e
        La3:
            r0.setRequestMethod(r11)     // Catch: java.lang.Throwable -> L47
            if (r8 == 0) goto Lbd
            int r1 = r8.length     // Catch: java.lang.Throwable -> L47
            if (r1 <= 0) goto Lbd
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> Lf1
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch: java.lang.Throwable -> Lf1
            r2.<init>(r1)     // Catch: java.lang.Throwable -> Lf1
            r2.write(r8)     // Catch: java.lang.Throwable -> L148
            r2.flush()     // Catch: java.lang.Throwable -> L148
            com.bytedance.tea.crash.g.f.a(r2)     // Catch: java.lang.Throwable -> L47
        Lbd:
            int r2 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L47
            r1 = 200(0xc8, float:2.8E-43)
            if (r2 != r1) goto L106
            java.io.InputStream r4 = r0.getInputStream()     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = r0.getContentEncoding()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r2 = "gzip"
            boolean r1 = r2.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> Lfc
            if (r1 == 0) goto L101
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> Lf7
            r2.<init>(r4)     // Catch: java.lang.Throwable -> Lf7
            byte[] r1 = a(r2)     // Catch: java.lang.Throwable -> L145
            com.bytedance.tea.crash.g.f.a(r2)     // Catch: java.lang.Throwable -> Lfc
        Le2:
            com.bytedance.tea.crash.upload.f r1 = al(r1)     // Catch: java.lang.Throwable -> Lfc
            if (r0 == 0) goto Leb
            r0.disconnect()     // Catch: java.lang.Exception -> L12c
        Leb:
            com.bytedance.tea.crash.g.f.a(r4)
            r0 = r1
            goto L5c
        Lf1:
            r1 = move-exception
            r2 = r3
        Lf3:
            com.bytedance.tea.crash.g.f.a(r2)     // Catch: java.lang.Throwable -> L47
            throw r1     // Catch: java.lang.Throwable -> L47
        Lf7:
            r1 = move-exception
        Lf8:
            com.bytedance.tea.crash.g.f.a(r3)     // Catch: java.lang.Throwable -> Lfc
            throw r1     // Catch: java.lang.Throwable -> Lfc
        Lfc:
            r1 = move-exception
            r2 = r4
            r5 = r0
            goto L4a
        L101:
            byte[] r1 = a(r4)     // Catch: java.lang.Throwable -> Lfc
            goto Le2
        L106:
            com.bytedance.tea.crash.upload.f r1 = new com.bytedance.tea.crash.upload.f     // Catch: java.lang.Throwable -> L47
            r4 = 206(0xce, float:2.89E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r5.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r6 = "http response code "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L47
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch: java.lang.Throwable -> L47
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L47
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L126
            r0.disconnect()     // Catch: java.lang.Exception -> L12e
        L126:
            com.bytedance.tea.crash.g.f.a(r3)
            r0 = r1
            goto L5c
        L12c:
            r0 = move-exception
            goto Leb
        L12e:
            r0 = move-exception
            goto L126
        L130:
            r1 = move-exception
            goto L59
        L133:
            r0 = move-exception
            goto L9a
        L136:
            r0 = move-exception
            r1 = r0
            r4 = r3
            r5 = r3
            goto L95
        L13c:
            r1 = move-exception
            r5 = r0
            goto L95
        L140:
            r0 = move-exception
            r1 = r0
            r4 = r2
            goto L95
        L145:
            r1 = move-exception
            r3 = r2
            goto Lf8
        L148:
            r1 = move-exception
            goto Lf3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.upload.b.a(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.bytedance.tea.crash.upload.f");
    }

    private static f al(byte[] bArr) {
        f fVar;
        if (bArr == null || bArr.length == 0) {
            return new f(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                fVar = new f(0, jSONObject);
            } else {
                fVar = new f(204, str);
            }
            return fVar;
        } catch (JSONException e) {
            return new f(204, str);
        }
    }

    public static f hi(String str, String str2) {
        return L(str, str2, b());
    }

    public static f hj(String str, String str2) {
        return L(str, str2, a());
    }

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return true;
    }

    public static f aV(String str, String str2, String str3) {
        f fVar;
        try {
            e eVar = new e(str, "UTF-8", true);
            eVar.a("json", str2);
            eVar.a("file", new File(str3));
            String a2 = eVar.a();
            try {
                JSONObject jSONObject = new JSONObject(a2);
                if ("succ".equals(jSONObject.optString("succ_kind"))) {
                    fVar = new f(0, jSONObject);
                } else {
                    fVar = new f(204, a2);
                }
                return fVar;
            } catch (JSONException e) {
                return new f(205, e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new f(207);
        }
    }

    public static String a(Map map) {
        return h.esI().a();
    }

    public static f L(String str, String str2, boolean z) {
        f fVar;
        try {
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                fVar = new f(201);
            } else {
                fVar = a(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), a.GZIP, AbstractBceClient.DEFAULT_CONTENT_TYPE, z);
            }
            return fVar;
        } catch (Throwable th) {
            j.b(th);
            return new f(207, th);
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    com.bytedance.tea.crash.g.f.a(byteArrayOutputStream);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);
        
        final int d;

        a(int i) {
            this.d = i;
        }
    }

    /* renamed from: com.bytedance.tea.crash.upload.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public enum EnumC1047b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);
        
        final int g;

        EnumC1047b(int i) {
            this.g = i;
        }
    }
}
