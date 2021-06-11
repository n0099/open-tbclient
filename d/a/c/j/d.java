package d.a.c.j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.util.io.Closeables;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42855a = d.a.c.j.a.f42853a;

    /* loaded from: classes.dex */
    public static abstract class a implements b<JSONObject> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.j.d.b
        /* renamed from: c */
        public JSONObject a(int i2, String str, InputStream inputStream) throws IOException {
            if (i2 != 200) {
                throw new IOException("parse response error: statuscode is " + i2);
            } else if (inputStream != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString("UTF-8"));
                    if (d.f42855a) {
                        Log.d(TitanDownloadService.TAG, jSONObject.toString());
                    }
                    return jSONObject;
                } catch (Exception e2) {
                    throw new IOException(e2);
                }
            } else {
                throw new IOException("parse response error: input stream is null");
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        T a(int i2, String str, InputStream inputStream) throws IOException;

        void b(int i2, String str, T t);
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "0.8";
        }
    }

    public static String c(Context context) {
        String sb;
        String property = System.getProperty("http.agent");
        if (TextUtils.isEmpty(property)) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            int length = property.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb2.append(charAt);
                }
            }
            sb = sb2.toString();
        }
        String str = Build.VERSION.RELEASE;
        String replace = TextUtils.isEmpty(str) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str.replace("_", "-");
        return sb + " baiduboxapp/" + b(context) + " (Baidu; P1 " + replace + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x010e A[Catch: all -> 0x0121, TRY_LEAVE, TryCatch #0 {all -> 0x0121, blocks: (B:65:0x0109, B:67:0x010e), top: B:78:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void d(Context context, String str, String str2, byte[] bArr, Map<String, String> map, b<T> bVar) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection3;
        T t;
        OutputStream outputStream3 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestProperty("User-Agent", c(context));
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestMethod(str2);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (!TextUtils.equals(str2, "POST")) {
                    outputStream2 = null;
                } else if (bArr == null) {
                    if (f42855a) {
                        Log.d(TitanDownloadService.TAG, "post requestSync body is null");
                    }
                    if (bVar != null) {
                        bVar.b(-1, "post requestSync body is null", null);
                    }
                    Closeables.closeSafely((Closeable) null);
                    Closeables.closeSafely((Closeable) null);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } else {
                    httpURLConnection.setDoOutput(true);
                    if (map == null || !map.containsKey("Content-Type")) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    }
                    outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(bArr);
                    } catch (Exception e2) {
                        inputStream2 = null;
                        httpURLConnection3 = httpURLConnection;
                        outputStream = outputStream2;
                        e = e2;
                        httpURLConnection2 = httpURLConnection3;
                        try {
                            e.printStackTrace();
                            if (bVar != null) {
                            }
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(inputStream2);
                            if (httpURLConnection2 == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            outputStream3 = outputStream;
                            httpURLConnection = httpURLConnection2;
                            inputStream = inputStream2;
                            Closeables.closeSafely(outputStream3);
                            Closeables.closeSafely(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        outputStream3 = outputStream2;
                        th = th2;
                        inputStream = null;
                        Closeables.closeSafely(outputStream3);
                        Closeables.closeSafely(inputStream);
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                Log.d(TitanDownloadService.TAG, "request code = " + responseCode + " msg = " + httpURLConnection.getResponseMessage());
                if (responseCode == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    if (bVar != null) {
                        try {
                            t = bVar.a(responseCode, httpURLConnection.getResponseMessage(), inputStream);
                        } catch (Exception e3) {
                            httpURLConnection3 = httpURLConnection;
                            outputStream = outputStream2;
                            e = e3;
                            inputStream2 = inputStream;
                            httpURLConnection2 = httpURLConnection3;
                            e.printStackTrace();
                            if (bVar != null) {
                                bVar.b(-1, e.getMessage(), null);
                            }
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(inputStream2);
                            if (httpURLConnection2 == null) {
                                httpURLConnection2.disconnect();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            outputStream3 = outputStream2;
                            th = th3;
                            Closeables.closeSafely(outputStream3);
                            Closeables.closeSafely(inputStream);
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    } else {
                        t = null;
                    }
                } else {
                    inputStream = null;
                    t = null;
                }
                if (bVar != null) {
                    bVar.b(responseCode, httpURLConnection.getResponseMessage(), t);
                }
                Closeables.closeSafely(outputStream2);
                Closeables.closeSafely(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnection2 = httpURLConnection;
                outputStream = null;
                inputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            outputStream = null;
            httpURLConnection2 = null;
            inputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            inputStream = null;
        }
    }
}
