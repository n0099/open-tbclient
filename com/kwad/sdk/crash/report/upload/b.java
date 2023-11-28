package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidubce.http.Headers;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
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
/* loaded from: classes10.dex */
public final class b {
    public static Map<String, String> a(f fVar) {
        HashMap hashMap = new HashMap();
        if (fVar == null) {
            return hashMap;
        }
        if (!TextUtils.isEmpty(fVar.aGG)) {
            hashMap.put("uploadToken", fVar.aGG);
        }
        if (!TextUtils.isEmpty(fVar.aGD)) {
            hashMap.put("sys", fVar.aGD);
        }
        if (!TextUtils.isEmpty(fVar.aGC)) {
            hashMap.put("did", fVar.aGC);
        }
        if (!TextUtils.isEmpty(fVar.aGA)) {
            hashMap.put("sid", fVar.aGA);
        }
        if (!TextUtils.isEmpty(fVar.aFa)) {
            hashMap.put("appver", fVar.aFa);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            hashMap.put("taskId", fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.aGB)) {
            hashMap.put("token", fVar.aGB);
        }
        if (!TextUtils.isEmpty(fVar.aGz)) {
            hashMap.put("uid", fVar.aGz);
        }
        if (!TextUtils.isEmpty(fVar.aGE)) {
            hashMap.put(DownloadCenterFunConstants.EXTRA_INFO, fVar.aGE);
        }
        return hashMap;
    }

    public static void a(File file, f fVar, a aVar) {
        a(file, fVar.aGC, fVar.aGB, a(fVar), aVar);
    }

    public static void a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull a aVar) {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        int i;
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String uuid = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.CJ().U("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i2 = -1;
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
                httpURLConnection2.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection2.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                httpURLConnection2.setRequestProperty(Headers.CONTENT_MD5, Base64.encodeToString(com.kwad.sdk.utils.a.fH(file.getPath()), 2));
                httpURLConnection2.setRequestProperty("file-type", "." + q.getExtension(file.getName()));
                httpURLConnection2.setRequestProperty("origin-name", name);
                httpURLConnection2.setRequestProperty("Cookie", "did=" + str);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(e(str4, map.get(str4), uuid));
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
                        cVar.atk = responseCode;
                        if (responseCode == 200) {
                            cVar.atm = h.a(httpURLConnection2.getInputStream());
                            try {
                                int optInt = new JSONObject(cVar.atm).optInt("result", -1);
                                if (optInt == 1) {
                                    aVar.GT();
                                } else {
                                    e eVar = e.aGv;
                                    new StringBuilder("result is ").append(optInt);
                                    aVar.GS();
                                }
                            } catch (JSONException unused) {
                                e eVar2 = e.aGw;
                                e eVar3 = e.aGw;
                                aVar.GS();
                            }
                            com.kwad.sdk.core.e.c.d("AdExceptionCollector", "response.body= " + cVar.atm);
                        } else {
                            e eVar4 = e.aGu;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(e.aGu.wd());
                            sb2.append(responseCode);
                            aVar.GS();
                            com.kwad.sdk.core.network.idc.a CJ = com.kwad.sdk.core.network.idc.a.CJ();
                            if (cVar.code == 0) {
                                i = -1;
                            } else {
                                i = cVar.code;
                            }
                            CJ.a(str3, i, (Throwable) null);
                        }
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        try {
                            e eVar5 = e.aGu;
                            e.getCause();
                            aVar.GS();
                            com.kwad.sdk.core.network.idc.a CJ2 = com.kwad.sdk.core.network.idc.a.CJ();
                            if (cVar.code != 0) {
                                i2 = cVar.code;
                            }
                            CJ2.a(str3, i2, e);
                            com.kwad.sdk.core.e.c.printStackTrace(e);
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

    public static byte[] e(String str, String str2, String str3) {
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
