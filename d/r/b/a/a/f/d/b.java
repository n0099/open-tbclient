package d.r.b.a.a.f.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class b {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0098 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00e2 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: java.util.zip.GZIPInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.util.zip.GZIPInputStream, java.io.InputStream] */
    public static String a(String str, String str2) {
        GZIPInputStream gZIPInputStream;
        BufferedReader bufferedReader;
        String str3 = "";
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty(Config.LAUNCH_REFERER, "https://www.yy.com/index.html");
                    httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "application/json");
                    if (str2 != 0 && !TextUtils.isEmpty(str2)) {
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(str2.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        str2 = new GZIPInputStream(httpURLConnection.getInputStream());
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader((InputStream) str2, "UTF-8"));
                        } catch (Exception e2) {
                            e = e2;
                        }
                        try {
                            str3 = bufferedReader.readLine();
                            bufferedReader2 = bufferedReader;
                            gZIPInputStream = str2;
                        } catch (Exception e3) {
                            bufferedReader2 = bufferedReader;
                            e = e3;
                            e.printStackTrace();
                            Log.e("yyrevenue", "xxxxx > " + e.toString());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (str2 != 0) {
                                str2.close();
                            }
                            return str3;
                        } catch (Throwable th) {
                            bufferedReader2 = bufferedReader;
                            th = th;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (str2 != 0) {
                                try {
                                    str2.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        gZIPInputStream = null;
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e8) {
                e = e8;
                str2 = 0;
            } catch (Throwable th3) {
                th = th3;
                str2 = 0;
            }
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        return str3;
    }
}
