package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.webkit.internal.ETAG;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    public static c a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        c cVar = new c();
        try {
            new StringBuilder();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", HttpHelper.CONTENT_JSON);
            httpURLConnection.setRequestProperty("User-Agent", k.a());
            cVar.f9617a = httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                sb.append(new String(bArr, 0, read));
            }
        } catch (MalformedURLException e) {
            com.kwad.sdk.core.d.a.a(e);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        cVar.f9618b = sb.toString();
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(String str, Map<String, String> map, String str2, boolean z) {
        Throwable th;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        Exception e;
        c cVar = new c();
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                if (z) {
                    httpURLConnection2.setRequestProperty("Content-Type", HttpHelper.CONTENT_JSON);
                } else {
                    httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpURLConnection2.setRequestProperty("User-Agent", k.a());
                a(httpURLConnection2, map);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.connect();
                if (TextUtils.isEmpty(str2)) {
                    outputStream = null;
                } else {
                    outputStream = httpURLConnection2.getOutputStream();
                    try {
                        outputStream.write(str2.getBytes());
                        outputStream.flush();
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        try {
                            com.kwad.sdk.core.d.a.a(e);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    com.kwad.sdk.core.d.a.a(e3);
                                }
                            }
                            return cVar;
                        } catch (Throwable th2) {
                            th = th2;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e4) {
                                    com.kwad.sdk.core.d.a.a(e4);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                        }
                        if (outputStream != null) {
                        }
                        throw th;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                cVar.f9617a = responseCode;
                if (responseCode == 200) {
                    cVar.f9618b = a(httpURLConnection2.getInputStream());
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                        com.kwad.sdk.core.d.a.a(e5);
                    }
                }
            } catch (Exception e6) {
                e = e6;
                outputStream = null;
                httpURLConnection = httpURLConnection2;
            } catch (Throwable th4) {
                th = th4;
                outputStream = null;
                httpURLConnection = httpURLConnection2;
            }
        } catch (Exception e7) {
            e = e7;
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
            httpURLConnection = null;
        }
        return cVar;
    }

    public static c a(String str, Map<String, String> map, Map<String, String> map2) {
        String str2 = null;
        if (map2 != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                sb.append(entry.getKey()).append("=").append(a(entry.getValue())).append(ETAG.ITEM_SEPARATOR);
            }
            str2 = sb.substring(0, sb.length() - 1);
        }
        return a(str, map, str2, false);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF, INVOKE, MOVE_EXCEPTION] complete} */
    private static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    com.kwad.sdk.core.d.a.a(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            com.kwad.sdk.core.d.a.a(e3);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        com.kwad.sdk.core.d.a.a(e4);
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        com.kwad.sdk.core.d.a.a(e5);
                    }
                }
                throw th;
            }
        }
        String str = new String(byteArrayOutputStream.toByteArray());
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                com.kwad.sdk.core.d.a.a(e6);
            }
        }
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
                return str;
            } catch (IOException e7) {
                com.kwad.sdk.core.d.a.a(e7);
                return str;
            }
        }
        return str;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.a.a(e);
            return "";
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
