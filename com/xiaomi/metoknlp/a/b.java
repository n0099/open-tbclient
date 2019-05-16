package com.xiaomi.metoknlp.a;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes3.dex */
public class b {
    public static String a(String str, Map map) {
        HttpsURLConnection httpsURLConnection;
        BufferedReader bufferedReader;
        String str2;
        String str3;
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        bufferedReader2 = null;
        HttpURLConnection httpURLConnection = null;
        String str4 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            URL url = new URL(str);
            try {
                httpsURLConnection = url.getProtocol().toLowerCase().equals("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
                try {
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setDoOutput(false);
                    if (map != null && map.size() > 0) {
                        for (String str5 : map.keySet()) {
                            httpsURLConnection.addRequestProperty(str5, (String) map.get(str5));
                        }
                    }
                    httpsURLConnection.connect();
                    if (httpsURLConnection.getResponseCode() == 200) {
                        BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = bufferedReader4.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            }
                            str4 = stringBuffer.toString();
                            bufferedReader4.close();
                            bufferedReader3 = bufferedReader4;
                            str3 = str4;
                        } catch (Exception e) {
                            bufferedReader = bufferedReader4;
                            httpURLConnection = httpsURLConnection;
                            str2 = str4;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e2) {
                                    return str2;
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return str2;
                            }
                            return str2;
                        } catch (Throwable th) {
                            bufferedReader2 = bufferedReader4;
                            th = th;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e3) {
                                    throw th;
                                }
                            }
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } else {
                        str3 = "";
                    }
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (Exception e4) {
                            return str3;
                        }
                    }
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                        return str3;
                    }
                    return str3;
                } catch (Exception e5) {
                    bufferedReader = null;
                    str2 = "";
                    httpURLConnection = httpsURLConnection;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                bufferedReader = null;
                str2 = "";
            } catch (Throwable th3) {
                th = th3;
                httpsURLConnection = null;
            }
        } catch (MalformedURLException e7) {
            return "";
        }
    }
}
