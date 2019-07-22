package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.Set;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class HttpManager {
    private static final String BOUNDARY;
    private static final String END_MP_BOUNDARY;
    private static final String MP_BOUNDARY;
    private static final String TAG = "HttpManager";

    private static native String calcOauthSignNative(Context context, String str, String str2);

    static {
        System.loadLibrary("weibosdkcore");
        BOUNDARY = getBoundry();
        MP_BOUNDARY = "--" + BOUNDARY;
        END_MP_BOUNDARY = "--" + BOUNDARY + "--";
    }

    public static String openUrl(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        String requestHttpExecute = requestHttpExecute(context, str, str2, weiboParameters);
        LogUtil.d(TAG, "Response : " + requestHttpExecute);
        return requestHttpExecute;
    }

    private static String requestHttpExecute(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpURLConnection createConnect;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                setHttpCommonParam(context, weiboParameters);
                if ("GET".equals(str2)) {
                    createConnect = ConnectionFactory.createConnect(str + "?" + weiboParameters.encodeUrl(), context);
                    createConnect.setRequestMethod("GET");
                    createConnect.setInstanceFollowRedirects(true);
                    createConnect.connect();
                } else {
                    createConnect = ConnectionFactory.createConnect(str, context);
                    createConnect.setInstanceFollowRedirects(true);
                    createConnect.connect();
                    if (weiboParameters.hasBinaryData()) {
                        DataOutputStream dataOutputStream = new DataOutputStream(createConnect.getOutputStream());
                        buildParams(dataOutputStream, weiboParameters);
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    } else {
                        DataOutputStream dataOutputStream2 = new DataOutputStream(createConnect.getOutputStream());
                        dataOutputStream2.write(weiboParameters.encodeUrl().getBytes(HTTP.UTF_8));
                        dataOutputStream2.flush();
                        dataOutputStream2.close();
                    }
                }
                int responseCode = createConnect.getResponseCode();
                if (responseCode != 200) {
                    throw new WeiboHttpException(readConnectResponse(createConnect, true), responseCode);
                }
                String readConnectResponse = readConnectResponse(createConnect, false);
                if (createConnect != null) {
                    createConnect.disconnect();
                }
                return readConnectResponse;
            } catch (IOException e) {
                e.printStackTrace();
                throw new WeiboException(e);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String readConnectResponse(HttpURLConnection httpURLConnection, boolean z) {
        InputStream inputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream = null;
        String str = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[8192];
            if (z) {
                inputStream = httpURLConnection.getErrorStream();
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                if (inputStream != null) {
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        } catch (IOException e) {
                            e = e;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream2 = inputStream;
                            try {
                                throw new WeiboException(e);
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (inputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            throw th;
                        }
                    }
                    str = new String(byteArrayOutputStream2.toByteArray(), HTTP.UTF_8);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                return str;
            } catch (IOException e6) {
                e = e6;
                inputStream2 = inputStream;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e7) {
            e = e7;
            inputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    private static void setHttpCommonParam(Context context, WeiboParameters weiboParameters) {
        String str;
        String str2 = "";
        if (!TextUtils.isEmpty(weiboParameters.getAppKey())) {
            str2 = Utility.getAid(context, weiboParameters.getAppKey());
            if (!TextUtils.isEmpty(str2)) {
                weiboParameters.put("aid", str2);
            }
        }
        String str3 = str2;
        String timestamp = getTimestamp();
        weiboParameters.put("oauth_timestamp", timestamp);
        Object obj = weiboParameters.get("access_token");
        Object obj2 = weiboParameters.get(Oauth2AccessToken.KEY_REFRESH_TOKEN);
        Object obj3 = weiboParameters.get("phone");
        if (obj != null && (obj instanceof String)) {
            str = (String) obj;
        } else if (obj2 != null && (obj2 instanceof String)) {
            str = (String) obj2;
        } else if (obj3 == null || !(obj3 instanceof String)) {
            str = "";
        } else {
            str = (String) obj3;
        }
        weiboParameters.put("oauth_sign", getOauthSign(context, str3, str, weiboParameters.getAppKey(), timestamp));
    }

    public static void fillCommonRequestParam(IRequestParam iRequestParam) {
    }

    public static String openRedirectUrl4LocationUri(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpURLConnection createConnect;
        String str3;
        if (str2.equals("GET")) {
            if (str.endsWith("?")) {
                str3 = str + weiboParameters.encodeUrl();
            } else {
                str3 = str + "?" + weiboParameters.encodeUrl();
            }
            str = str3;
            createConnect = ConnectionFactory.createConnect(str3, context);
        } else {
            createConnect = ConnectionFactory.createConnect(str, context);
        }
        try {
            createConnect.setInstanceFollowRedirects(false);
            createConnect.connect();
            int responseCode = createConnect.getResponseCode();
            if (responseCode == 302 || responseCode == 301) {
                return createConnect.getHeaderField("Location");
            }
            if (responseCode != 200) {
                return "";
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public static synchronized String downloadFile(Context context, String str, String str2, String str3) throws WeiboException {
        String str4;
        long j;
        long contentLength;
        synchronized (HttpManager.class) {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str3);
            if (file2.exists()) {
                str4 = file2.getPath();
            } else if (!URLUtil.isValidUrl(str)) {
                str4 = "";
            } else {
                File file3 = new File(str2, str3 + "_temp");
                HttpURLConnection createConnect = ConnectionFactory.createConnect(str, context);
                createConnect.setConnectTimeout(300000);
                createConnect.setReadTimeout(300000);
                try {
                    createConnect.setRequestMethod("GET");
                } catch (Exception e) {
                }
                try {
                    if (file3.exists()) {
                        j = file3.length();
                    } else {
                        file3.createNewFile();
                        j = 0;
                    }
                    createConnect.setRequestProperty("RANGE", "bytes=" + j);
                    int responseCode = createConnect.getResponseCode();
                    if (responseCode == 206) {
                        contentLength = 0;
                    } else if (responseCode == 200) {
                        contentLength = createConnect.getContentLength();
                    } else {
                        throw new WeiboHttpException(readConnectResponse(createConnect, true), responseCode);
                    }
                    InputStream inputStream = createConnect.getInputStream();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
                    randomAccessFile.seek(0L);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                    }
                    randomAccessFile.close();
                    inputStream.close();
                } catch (Exception e2) {
                }
                if (contentLength == 0 || file3.length() < contentLength) {
                    file3.delete();
                    str4 = "";
                } else {
                    file3.renameTo(file2);
                    str4 = file2.getPath();
                }
            }
        }
        return str4;
    }

    public static void buildParams(OutputStream outputStream, WeiboParameters weiboParameters) throws WeiboException {
        try {
            Set<String> keySet = weiboParameters.keySet();
            for (String str : keySet) {
                if (weiboParameters.get(str) instanceof String) {
                    StringBuilder sb = new StringBuilder(100);
                    sb.setLength(0);
                    sb.append(MP_BOUNDARY).append("\r\n");
                    sb.append("content-disposition: form-data; name=\"").append(str).append("\"\r\n\r\n");
                    sb.append(weiboParameters.get(str)).append("\r\n");
                    outputStream.write(sb.toString().getBytes());
                }
            }
            for (String str2 : keySet) {
                Object obj = weiboParameters.get(str2);
                if (obj instanceof Bitmap) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(MP_BOUNDARY).append("\r\n");
                    sb2.append("content-disposition: form-data; name=\"").append(str2).append("\"; filename=\"file\"\r\n");
                    sb2.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(sb2.toString().getBytes());
                    Bitmap bitmap = (Bitmap) obj;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.write("\r\n".getBytes());
                } else if (obj instanceof ByteArrayOutputStream) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(MP_BOUNDARY).append("\r\n");
                    sb3.append("content-disposition: form-data; name=\"").append(str2).append("\"; filename=\"file\"\r\n");
                    sb3.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(sb3.toString().getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) obj;
                    outputStream.write(byteArrayOutputStream2.toByteArray());
                    outputStream.write("\r\n".getBytes());
                    byteArrayOutputStream2.close();
                }
            }
            outputStream.write(("\r\n" + END_MP_BOUNDARY).getBytes());
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    public static String getBoundry() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            long currentTimeMillis = System.currentTimeMillis() + i;
            if (currentTimeMillis % 3 == 0) {
                stringBuffer.append(((char) currentTimeMillis) % '\t');
            } else if (currentTimeMillis % 3 == 1) {
                stringBuffer.append((char) ((currentTimeMillis % 26) + 65));
            } else {
                stringBuffer.append((char) ((currentTimeMillis % 26) + 97));
            }
        }
        return stringBuffer.toString();
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String getOauthSign(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
        }
        return calcOauthSignNative(context, sb.toString(), str4);
    }
}
