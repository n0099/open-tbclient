package d.a.r0.a.d;

import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import d.a.r0.a.c;
import d.a.r0.a.e.g;
import d.a.r0.a.f.i;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.UUID;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {

    /* loaded from: classes5.dex */
    public interface a<T> {
        void a(T t);

        void a(String str);
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0175: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:51:0x0175 */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file, String str) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        String uuid = UUID.randomUUID().toString();
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setReadTimeout(20000);
                    httpURLConnection.setConnectTimeout(40000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                    httpURLConnection.setRequestProperty("Content-Type", IMAudioTransRequest.CONTENT_TYPE + ";boundary=" + uuid);
                    httpURLConnection.setRequestProperty("token", c.i().j());
                    if (file != null) {
                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("--");
                        stringBuffer.append(uuid);
                        stringBuffer.append(Part.CRLF);
                        stringBuffer.append("Content-Disposition: form-data; name=\"txt\"; filename=\"" + file.getName() + "\"" + Part.CRLF);
                        StringBuilder sb = new StringBuilder("Content-Type: application/octet-stream; charset=utf-8");
                        sb.append(Part.CRLF);
                        stringBuffer.append(sb.toString());
                        stringBuffer.append(Part.CRLF);
                        dataOutputStream.write(stringBuffer.toString().getBytes("UTF-8"));
                        fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                dataOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream.close();
                            dataOutputStream.write(Part.CRLF.getBytes("UTF-8"));
                            dataOutputStream.write(("--" + uuid + "--" + Part.CRLF).getBytes("UTF-8"));
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            if (httpURLConnection.getResponseCode() == 200) {
                                InputStream inputStream3 = httpURLConnection.getInputStream();
                                StringBuffer stringBuffer2 = new StringBuffer();
                                while (true) {
                                    int read2 = inputStream3.read();
                                    if (read2 == -1) {
                                        break;
                                    }
                                    stringBuffer2.append((char) read2);
                                }
                                inputStream3.close();
                                httpURLConnection.disconnect();
                                String stringBuffer3 = stringBuffer2.toString();
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                return stringBuffer3;
                            }
                            d.a.r0.a.f.a.b(file.getAbsolutePath() + "     上传文件失败…………");
                            httpURLConnection.disconnect();
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            return null;
                        } catch (IOException e4) {
                            e = e4;
                            i.d(e);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        } catch (Exception e5) {
                            e = e5;
                            i.d(e);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                fileInputStream = null;
            } catch (Exception e8) {
                e = e8;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        return null;
    }

    public static String b(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str.toString().getBytes("UTF-8").length));
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestProperty("token", c.i().j());
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer("");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(new String(readLine.getBytes("UTF-8"), "utf-8"));
                    } else {
                        bufferedReader.close();
                        inputStreamReader.close();
                        httpURLConnection.disconnect();
                        return stringBuffer.toString();
                    }
                }
            } else {
                d.a.r0.a.f.a.b("上传log失败    ");
                httpURLConnection.disconnect();
                return null;
            }
        } catch (Exception e2) {
            d.a.r0.a.f.a.b("上传log失败    " + e2.getMessage());
            i.d(e2);
            return null;
        }
    }

    public static boolean c(String str, a aVar) {
        try {
        } catch (Exception e2) {
            i.d(e2);
        }
        if (str == null) {
            if (aVar != null) {
                aVar.a("-1");
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getString("status").equals("0")) {
            if (aVar != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    aVar.a((a) optJSONObject);
                    return true;
                }
                aVar.a((a) jSONObject.optJSONArray("data"));
                return true;
            }
            return true;
        } else if (jSONObject.getString("status").equals("1")) {
            if (aVar != null) {
                aVar.a(jSONObject.optString("status"));
            }
            d.a.r0.a.f.a.b("net status  error ");
            return false;
        } else {
            if (jSONObject.getString("status").equals("2")) {
                g.h(c.i().g());
                d.a.r0.a.f.a.b("net  token error ");
                return false;
            }
            if (aVar != null) {
                aVar.a("-1");
            }
            return false;
        }
    }

    public static String d(String str, Map<String, Object> map) {
        String str2 = "";
        if (map.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            if (!map.isEmpty()) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (stringBuffer.length() <= 0) {
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("=");
                        stringBuffer.append(entry.getValue());
                    } else {
                        stringBuffer.append("&");
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("=");
                        stringBuffer.append(entry.getValue());
                    }
                }
                str2 = stringBuffer.toString();
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("token", c.i().j());
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8"));
            printWriter.write(str2);
            printWriter.flush();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                } else {
                    printWriter.close();
                    bufferedInputStream.close();
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString("utf-8");
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (Exception e2) {
            i.e(e2);
            return null;
        }
    }
}
