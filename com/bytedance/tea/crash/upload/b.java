package com.bytedance.tea.crash.upload;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidubce.AbstractBceClient;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import d.b.d.b.l;
import d.b.d.b.m;
import d.b.d.b.n.d;
import d.b.d.b.n.e;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30370a = false;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.d.b.n.b f30371b;

    /* loaded from: classes6.dex */
    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);
        

        /* renamed from: d  reason: collision with root package name */
        public final int f30376d;

        a(int i2) {
            this.f30376d = i2;
        }
    }

    /* renamed from: com.bytedance.tea.crash.upload.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public enum EnumC0323b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);
        

        /* renamed from: g  reason: collision with root package name */
        public final int f30384g;

        EnumC0323b(int i2) {
            this.f30384g = i2;
        }
    }

    public static e a(long j, String str, byte[] bArr, a aVar, String str2, boolean z) throws IOException {
        if (str == null) {
            return new e(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str3 = null;
        if (a.GZIP == aVar && length > 128) {
            bArr = l(bArr);
            str3 = AsyncHttpClient.ENCODING_GZIP;
        } else if (a.DEFLATER == aVar && length > 128) {
            bArr = i(bArr);
            str3 = "deflate";
        }
        String str4 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new e(202);
        }
        if (z) {
            byte[] a2 = TTEncryptUtils.a(bArr2, bArr2.length);
            if (a2 != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    if (!str.endsWith("?")) {
                        str = str + "?";
                    }
                } else if (!str.endsWith("&")) {
                    str = str + "&";
                }
                str = str + "tt_data=a";
                str2 = "application/octet-stream;tt-data=a";
                bArr2 = a2;
            }
            return e(str, bArr2, str2, str4, "POST", true, true);
        }
        return e(str, bArr2, str2, str4, "POST", true, false);
    }

    public static e b(String str, String str2) {
        return d(str, str2, k());
    }

    public static e c(String str, String str2, String str3) {
        try {
            d dVar = new d(str, "UTF-8", true);
            dVar.c("json", str2);
            dVar.b("file", new File(str3));
            String a2 = dVar.a();
            try {
                JSONObject jSONObject = new JSONObject(a2);
                if ("succ".equals(jSONObject.optString("succ_kind"))) {
                    return new e(0, jSONObject);
                }
                return new e(204, a2);
            } catch (JSONException e2) {
                return new e(205, e2);
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return new e(207);
        }
    }

    public static e d(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return a(2097152L, str, str2.getBytes(), a.GZIP, AbstractBceClient.DEFAULT_CONTENT_TYPE, z);
            }
            return new e(201);
        } catch (Throwable th) {
            l.k.c(th);
            return new e(207, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e e(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        InputStream inputStream;
        URL url;
        GZIPInputStream gZIPInputStream;
        byte[] h2;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            if (f30371b != null) {
                str = f30371b.a(str, bArr);
            }
            LinkedList<Pair> linkedList = new LinkedList();
            if (z2) {
                url = new URL(d.b.d.a.a.a.a.c(str, linkedList));
            } else {
                url = new URL(str);
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            if (z2) {
                try {
                    if (!linkedList.isEmpty()) {
                        for (Pair pair : linkedList) {
                            if (pair != null) {
                                httpURLConnection2.setRequestProperty((String) pair.first, (String) pair.second);
                            }
                        }
                    }
                } catch (Throwable th) {
                    httpURLConnection = httpURLConnection2;
                    th = th;
                    inputStream = null;
                    try {
                        l.k.c(th);
                        return new e(207, th);
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        l.g.a(inputStream);
                    }
                }
            }
            if (z) {
                httpURLConnection2.setDoOutput(true);
            } else {
                httpURLConnection2.setDoOutput(false);
            }
            if (str2 != null) {
                httpURLConnection2.setRequestProperty("Content-Type", str2);
            }
            if (str3 != null) {
                httpURLConnection2.setRequestProperty("Content-Encoding", str3);
            }
            httpURLConnection2.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            if (str4 != null) {
                httpURLConnection2.setRequestMethod(str4);
                if (bArr != null && bArr.length > 0) {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            l.g.a(dataOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            l.g.a(dataOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        dataOutputStream = null;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode == 200) {
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                            try {
                                gZIPInputStream = new GZIPInputStream(inputStream);
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                h2 = h(gZIPInputStream);
                                l.g.a(gZIPInputStream);
                            } catch (Throwable th5) {
                                th = th5;
                                gZIPInputStream2 = gZIPInputStream;
                                l.g.a(gZIPInputStream2);
                                throw th;
                            }
                        } else {
                            h2 = h(inputStream);
                        }
                        e m = m(h2);
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        l.g.a(inputStream);
                        return m;
                    } catch (Throwable th6) {
                        httpURLConnection = httpURLConnection2;
                        th = th6;
                        l.k.c(th);
                        return new e(207, th);
                    }
                }
                e eVar = new e(206, "http response code " + responseCode);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused3) {
                    }
                }
                l.g.a(null);
                return eVar;
            }
            throw new IllegalArgumentException("request method is not null");
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }

    public static String f(Map map) {
        return m.f().a();
    }

    public static boolean g() {
        return true;
    }

    public static byte[] h(InputStream inputStream) throws IOException {
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
                    l.g.a(byteArrayOutputStream);
                }
            }
        }
    }

    public static byte[] i(byte[] bArr) {
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

    public static e j(String str, String str2) {
        return d(str, str2, g());
    }

    public static boolean k() {
        return true;
    }

    public static byte[] l(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                l.k.c(th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    public static e m(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            String str = new String(bArr, Charset.forName("utf-8"));
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    return new e(0, jSONObject);
                }
                return new e(204, str);
            } catch (JSONException unused) {
                return new e(204, str);
            }
        }
        return new e(203);
    }
}
