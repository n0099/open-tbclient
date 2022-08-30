package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidubce.http.Headers;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.crash.utils.g;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public static Map<String, String> a(f fVar) {
        HashMap hashMap = new HashMap();
        if (fVar == null) {
            return hashMap;
        }
        if (!TextUtils.isEmpty(fVar.aih)) {
            hashMap.put("uploadToken", fVar.aih);
        }
        if (!TextUtils.isEmpty(fVar.aie)) {
            hashMap.put("sys", fVar.aie);
        }
        if (!TextUtils.isEmpty(fVar.aid)) {
            hashMap.put("did", fVar.aid);
        }
        if (!TextUtils.isEmpty(fVar.aib)) {
            hashMap.put("sid", fVar.aib);
        }
        if (!TextUtils.isEmpty(fVar.ahu)) {
            hashMap.put("appver", fVar.ahu);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            hashMap.put("taskId", fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.aic)) {
            hashMap.put("token", fVar.aic);
        }
        if (!TextUtils.isEmpty(fVar.aia)) {
            hashMap.put("uid", fVar.aia);
        }
        if (!TextUtils.isEmpty(fVar.aif)) {
            hashMap.put("extraInfo", fVar.aif);
        }
        return hashMap;
    }

    public static void a(File file, f fVar, a aVar) {
        a(file, fVar.aid, fVar.aic, a(fVar), aVar);
    }

    public static void a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull a aVar) {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String uuid = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.tH().F(INet.HostType.ULOG, "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i = -1;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                httpURLConnection2.setRequestProperty("User-Agent", o.getUserAgent());
                httpURLConnection2.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                httpURLConnection2.setRequestProperty(Headers.CONTENT_MD5, Base64.encodeToString(com.kwad.sdk.utils.a.dw(file.getPath()), 2));
                httpURLConnection2.setRequestProperty("file-type", "." + com.kwad.sdk.utils.o.getExtension(file.getName()));
                httpURLConnection2.setRequestProperty("origin-name", name);
                httpURLConnection2.setRequestProperty("Cookie", "did=" + str);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(d(str4, map.get(str4), uuid));
                    }
                    byte[] bytes = ("\r\n--" + uuid + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(uuid);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = dataInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        outputStream.write("\r\n".getBytes());
                        outputStream.write(bytes);
                        outputStream.flush();
                        int responseCode = httpURLConnection2.getResponseCode();
                        cVar.code = responseCode;
                        cVar.XT = responseCode;
                        if (responseCode == 200) {
                            cVar.XV = g.b(httpURLConnection2.getInputStream());
                            try {
                                int optInt = new JSONObject(cVar.XV).optInt(TiebaStatic.LogFields.RESULT, -1);
                                if (optInt == 1) {
                                    aVar.wV();
                                } else {
                                    e eVar = e.ahW;
                                    new StringBuilder("result is ").append(optInt);
                                    aVar.wU();
                                }
                            } catch (JSONException unused) {
                                e eVar2 = e.ahX;
                                e eVar3 = e.ahX;
                                aVar.wU();
                            }
                            com.kwad.sdk.core.e.b.d("ExceptionCollector", "response.body= " + cVar.XV);
                        } else {
                            e eVar4 = e.ahV;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(e.ahV.wX());
                            sb2.append(responseCode);
                            aVar.wU();
                            com.kwad.sdk.core.network.idc.a.tH().a(str3, cVar.code == 0 ? -1 : cVar.code, (Throwable) null);
                        }
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        try {
                            e eVar5 = e.ahV;
                            e.getCause();
                            aVar.wU();
                            com.kwad.sdk.core.network.idc.a tH = com.kwad.sdk.core.network.idc.a.tH();
                            if (cVar.code != 0) {
                                i = cVar.code;
                            }
                            tH.a(str3, i, e);
                            com.kwad.sdk.core.e.b.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            outputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    public static byte[] d(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append("\r\n");
        sb.append("Content-Length: " + str2.length());
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(str2);
        sb.append("\r\n");
        return sb.toString().getBytes();
    }
}
