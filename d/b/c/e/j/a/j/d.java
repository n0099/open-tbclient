package d.b.c.e.j.a.j;

import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.p.k;
import d.b.c.e.p.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
/* loaded from: classes.dex */
public class d {
    public static String a(String str) {
        int indexOf;
        int max;
        if (k.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (Exception e2) {
            BdLog.e(e2);
            if (!str.startsWith("http") || (indexOf = str.indexOf(":")) == -1) {
                return "";
            }
            int i = indexOf + 3;
            int indexOf2 = str.indexOf(":", i);
            int indexOf3 = str.indexOf("/", i);
            if (indexOf2 != -1 && indexOf3 != -1) {
                max = Math.min(indexOf2, indexOf3);
            } else {
                max = Math.max(indexOf2, indexOf3);
            }
            if (max != -1 || i >= str.length()) {
                if (i != -1 && i < max) {
                    return str.substring(i, max);
                }
                return "";
            }
            return str.substring(i);
        }
    }

    public static String b(String str) {
        return k.isEmpty(str) ? "" : str.startsWith("https://") ? str.replace("https://", "http://") : str;
    }

    public static String c() {
        String d2 = d();
        String e2 = e();
        return d2 + e2;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125 A[Catch: Exception -> 0x014d, TryCatch #1 {Exception -> 0x014d, blocks: (B:3:0x0009, B:19:0x009b, B:46:0x00dd, B:49:0x00f0, B:51:0x00fb, B:52:0x0114, B:53:0x011a, B:54:0x011f, B:56:0x0125, B:57:0x012d, B:69:0x014c, B:68:0x0145, B:44:0x00d4, B:41:0x00cf, B:16:0x0096, B:65:0x0140), top: B:75:0x0009, inners: #6, #9, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d() {
        long currentTimeMillis;
        String str;
        HttpGet httpGet;
        byte[] bArr;
        byte[] bArr2;
        int i;
        HttpResponse execute;
        InputStream content;
        StringBuilder sb = new StringBuilder();
        try {
            currentTimeMillis = System.currentTimeMillis();
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 3000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, 1024);
            HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
            HttpClientParams.setRedirecting(basicHttpParams, true);
            ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(15));
            ConnManagerParams.setTimeout(basicHttpParams, 10000L);
            ConnManagerParams.setMaxTotalConnections(basicHttpParams, 15);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
            str = "";
            int i2 = 0;
            InputStream inputStream = null;
            try {
                httpGet = new HttpGet("http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg");
                try {
                    try {
                        execute = defaultHttpClient.execute(httpGet);
                        i = execute.getStatusLine().getStatusCode();
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        content = execute.getEntity().getContent();
                    } catch (Exception e3) {
                        e = e3;
                        i2 = i;
                        bArr = null;
                        str = e.toString();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                        if (httpGet != null) {
                            try {
                                httpGet.abort();
                            } catch (Exception e4) {
                                BdLog.e(e4.getMessage());
                            }
                        }
                        bArr2 = bArr;
                        i = i2;
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        sb.append("-imgResponseCode_");
                        sb.append(i);
                        if (i == 200) {
                        }
                        if (!k.isEmpty(str)) {
                        }
                        sb.append("-costTime_");
                        sb.append(currentTimeMillis2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                } catch (Exception e5) {
                    e = e5;
                    i2 = i;
                    inputStream = content;
                    bArr = null;
                    str = e.toString();
                    if (inputStream != null) {
                    }
                    if (httpGet != null) {
                    }
                    bArr2 = bArr;
                    i = i2;
                    long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                    sb.append("-imgResponseCode_");
                    sb.append(i);
                    if (i == 200) {
                    }
                    if (!k.isEmpty(str)) {
                    }
                    sb.append("-costTime_");
                    sb.append(currentTimeMillis22);
                    return sb.toString();
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = content;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (httpGet != null) {
                        try {
                            httpGet.abort();
                        } catch (Exception e6) {
                            BdLog.e(e6.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                bArr = null;
                httpGet = null;
            } catch (Throwable th3) {
                th = th3;
                httpGet = null;
            }
        } catch (Exception e8) {
            sb.append("-imgTestFail_");
            sb.append(e8.toString());
        }
        if (content != null) {
            byte[] bArr3 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                int read = content.read(bArr3);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (content != null) {
                try {
                    content.close();
                } catch (Exception unused3) {
                }
            }
            try {
                httpGet.abort();
            } catch (Exception e9) {
                BdLog.e(e9.getMessage());
            }
            long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
            sb.append("-imgResponseCode_");
            sb.append(i);
            if (i == 200) {
                if (bArr2 != null) {
                    int length = bArr2.length;
                    String d2 = q.d(bArr2);
                    if (!"BA30C9CC61C537ACBD68397F95684A27".equalsIgnoreCase(d2)) {
                        sb.append("-MD5Error_");
                        sb.append(d2);
                        sb.append("_");
                        sb.append("BA30C9CC61C537ACBD68397F95684A27");
                        sb.append("-size_");
                        sb.append(length);
                    } else {
                        sb.append("-imgTestOk");
                    }
                } else {
                    sb.append("-downSizeZero");
                }
            }
            if (!k.isEmpty(str)) {
                sb.append("-imgException_");
                sb.append(str);
            }
            sb.append("-costTime_");
            sb.append(currentTimeMillis222);
            return sb.toString();
        }
        throw new IOException("get_content_is_null");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0105 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e() {
        Exception e2;
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        int i;
        HttpURLConnection httpURLConnection2;
        String str;
        byte[] bArr2;
        InputStream inputStream;
        byte[] bArr3;
        ?? r0 = "http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg";
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        InputStream inputStream2 = null;
        try {
            try {
                r0 = (HttpURLConnection) new URL("http://tb.hiphotos.baidu.com/album/%3Bq%3D90/sign=b0a01f07223fb80e409d69de06d12ffb/dcc451da81cb39db07b47460d3160924ab18308b.jpg").openConnection();
                try {
                } catch (Exception e3) {
                    bArr = null;
                    e2 = e3;
                    httpURLConnection = r0;
                    i = 0;
                    httpURLConnection2 = httpURLConnection;
                    String exc = e2.toString();
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e4) {
                            BdLog.e(e4.getMessage());
                        }
                    }
                    str = exc;
                    bArr2 = bArr;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    sb.append("-imgResponseCode_");
                    sb.append(i);
                    if (i == 200) {
                    }
                    if (!k.isEmpty(str)) {
                    }
                    sb.append("-costTime_");
                    sb.append(currentTimeMillis2);
                    return sb.toString();
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e5) {
            e2 = e5;
            httpURLConnection = null;
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
            r0 = 0;
        }
        if (r0 != 0) {
            r0.setConnectTimeout(3000);
            r0.setReadTimeout(10000);
            r0.connect();
            i = r0.getResponseCode();
            try {
                inputStream = r0.getInputStream();
            } catch (Exception e6) {
                e2 = e6;
                bArr = null;
                httpURLConnection2 = r0;
            }
            try {
                bArr3 = new byte[1024];
            } catch (Exception e7) {
                e2 = e7;
                bArr = null;
                inputStream2 = inputStream;
                httpURLConnection2 = r0;
                String exc2 = e2.toString();
                if (inputStream2 != null) {
                }
                if (httpURLConnection2 != null) {
                }
                str = exc2;
                bArr2 = bArr;
                long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                sb.append("-imgResponseCode_");
                sb.append(i);
                if (i == 200) {
                }
                if (!k.isEmpty(str)) {
                }
                sb.append("-costTime_");
                sb.append(currentTimeMillis22);
                return sb.toString();
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception unused2) {
                    }
                }
                if (r0 != 0) {
                    try {
                        r0.disconnect();
                    } catch (Exception e8) {
                        BdLog.e(e8.getMessage());
                    }
                }
                throw th;
            }
            if (inputStream != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                while (true) {
                    int read = inputStream.read(bArr3);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                if (r0 != 0) {
                    try {
                        r0.disconnect();
                    } catch (Exception e9) {
                        BdLog.e(e9.getMessage());
                    }
                }
                str = "";
                long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
                sb.append("-imgResponseCode_");
                sb.append(i);
                if (i == 200) {
                    if (bArr2 != null) {
                        int length = bArr2.length;
                        String d2 = q.d(bArr2);
                        if (!"BA30C9CC61C537ACBD68397F95684A27".equalsIgnoreCase(d2)) {
                            sb.append("-MD5Error_");
                            sb.append(d2);
                            sb.append("_");
                            sb.append("BA30C9CC61C537ACBD68397F95684A27");
                            sb.append("-size_");
                            sb.append(length);
                        } else {
                            sb.append("-imgTestOk");
                        }
                    } else {
                        sb.append("-downSizeZero");
                    }
                }
                if (!k.isEmpty(str)) {
                    sb.append("-imgException_");
                    sb.append(str);
                }
                sb.append("-costTime_");
                sb.append(currentTimeMillis222);
                return sb.toString();
            }
            throw new IOException("get_content_is_null");
        }
        throw new SocketException();
    }
}
