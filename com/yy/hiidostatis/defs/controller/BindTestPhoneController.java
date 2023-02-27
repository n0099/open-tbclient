package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes8.dex */
public class BindTestPhoneController {
    public static void bind(String str, Context context) {
        int indexOf = str.indexOf(":");
        if (indexOf < 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(indexOf + 3);
        if (!substring.toLowerCase().startsWith("https://")) {
            sb.append("https://");
        }
        sb.append(substring);
        if (str.indexOf("?") > 0) {
            sb.append("&hdid=");
            sb.append(DeviceProxy.getHdid(context));
        } else {
            sb.append("?hdid=");
            sb.append(DeviceProxy.getHdid(context));
        }
        try {
            sb.append("&sjp=");
            sb.append(URLEncoder.encode(ArdUtil.getSjp(context), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            sb.append("&sjm=");
            sb.append(URLEncoder.encode(ArdUtil.getSjm(context), "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        sb.append("&sys=");
        sb.append(2);
        try {
            sb.append("&mbos=");
            sb.append(URLEncoder.encode(ArdUtil.getOS(), "UTF-8"));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        try {
            sb.append("&name=");
            sb.append(URLEncoder.encode(ArdUtil.getDeviceName(context), "UTF-8"));
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
        final String sb2 = sb.toString();
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.BindTestPhoneController.1
            @Override // java.lang.Runnable
            public void run() {
                BindTestPhoneController.get(sb2);
            }
        });
    }

    public static void get(String str) {
        InputStream inputStream;
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        InputStream inputStream2 = null;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setReadTimeout(60000);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setInstanceFollowRedirects(true);
            httpsURLConnection.setRequestProperty("User-Agent", "Hiido");
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                L.verbose("HttpUtil", "get url=[%s] is ok", str);
                inputStream2 = httpsURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                L.verbose("HttpUtil", "the result is %s", new String(byteArrayOutputStream.toByteArray(), "UTF-8"));
                byteArrayOutputStream.close();
            } else {
                L.warn("HttpUtil", "http get [%s] error! status:%d", str, Integer.valueOf(httpsURLConnection.getResponseCode()));
            }
            if (httpsURLConnection != null) {
                try {
                    httpsURLConnection.disconnect();
                } catch (Throwable th2) {
                    L.debug("BindTestPhoneController", th2.getMessage(), new Object[0]);
                    return;
                }
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            httpsURLConnection2 = httpsURLConnection;
            try {
                L.error("BindTestPhoneController", th.getMessage(), new Object[0]);
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (Throwable th4) {
                        L.debug("BindTestPhoneController", th4.getMessage(), new Object[0]);
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th5) {
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (Throwable th6) {
                        L.debug("BindTestPhoneController", th6.getMessage(), new Object[0]);
                        throw th5;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th5;
            }
        }
    }
}
