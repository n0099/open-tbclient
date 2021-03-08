package com.thunder.livesdk.helper;

import com.thunder.livesdk.log.ThunderLog;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes6.dex */
public class ThunderHttpsRequestHandler {
    private static final int ERR_IOEXCEPTION = 12;
    private static final int ERR_MALFORMED_URL = 10;
    private static final int ERR_NONE = 0;
    private static final int ERR_OTHERS = 13;
    private static final int ERR_PROTOCOL = 11;
    private static final String TAG = "HttpsRequestHandler";

    public void send(final String str, final int i) {
        new Thread(new Runnable() { // from class: com.thunder.livesdk.helper.ThunderHttpsRequestHandler.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [74=7, 75=6] */
            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0010 */
            /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.thunder.livesdk.helper.ThunderHttpsRequestHandler */
            /* JADX DEBUG: Multi-variable search result rejected for r2v15, resolved type: com.thunder.livesdk.helper.ThunderHttpsRequestHandler */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Exception e;
                IOException e2;
                ProtocolException e3;
                MalformedURLException e4;
                Throwable th;
                HttpsURLConnection httpsURLConnection;
                if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(ThunderHttpsRequestHandler.TAG, "fetching...");
                }
                HttpsURLConnection httpsURLConnection2 = null;
                try {
                    try {
                        httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (MalformedURLException e5) {
                    e4 = e5;
                } catch (ProtocolException e6) {
                    e3 = e6;
                } catch (IOException e7) {
                    e2 = e7;
                } catch (Exception e8) {
                    e = e8;
                }
                try {
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setReadTimeout(5000);
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        ThunderHttpsRequestHandler thunderHttpsRequestHandler = ThunderHttpsRequestHandler.this;
                        thunderHttpsRequestHandler.onHttpsResponse(httpsURLConnection, str, responseCode, i);
                        httpsURLConnection2 = thunderHttpsRequestHandler;
                    } else {
                        ThunderHttpsRequestHandler thunderHttpsRequestHandler2 = ThunderHttpsRequestHandler.this;
                        thunderHttpsRequestHandler2.onHttpsFailed(str, responseCode, 0, i);
                        httpsURLConnection2 = thunderHttpsRequestHandler2;
                    }
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (MalformedURLException e9) {
                    e4 = e9;
                    httpsURLConnection2 = httpsURLConnection;
                    ThunderHttpsRequestHandler.this.onHttpsFailed(str, 0, 10, i);
                    e4.printStackTrace();
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                } catch (ProtocolException e10) {
                    e3 = e10;
                    httpsURLConnection2 = httpsURLConnection;
                    ThunderHttpsRequestHandler.this.onHttpsFailed(str, 0, 11, i);
                    e3.printStackTrace();
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                } catch (IOException e11) {
                    e2 = e11;
                    httpsURLConnection2 = httpsURLConnection;
                    ThunderHttpsRequestHandler.this.onHttpsFailed(str, 0, 12, i);
                    e2.printStackTrace();
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                } catch (Exception e12) {
                    e = e12;
                    httpsURLConnection2 = httpsURLConnection;
                    ThunderHttpsRequestHandler.this.onHttpsFailed(str, 0, 13, i);
                    e.printStackTrace();
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpsURLConnection2 = httpsURLConnection;
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                    throw th;
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHttpsResponse(HttpsURLConnection httpsURLConnection, String str, int i, int i2) {
        String contentType = httpsURLConnection.getContentType();
        int contentLength = httpsURLConnection.getContentLength();
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "contentType=" + contentType + " contentLength=" + contentLength);
        }
        if (contentType.indexOf("text") != -1) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                    } else {
                        bufferedReader.close();
                        ThunderNative.setHttpsTextResponse(str, stringBuffer.toString(), i, 0, i2);
                        return;
                    }
                }
            } catch (IOException e) {
                onHttpsFailed(str, 0, 12, i2);
            }
        } else {
            try {
                InputStream inputStream = httpsURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[contentLength];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        inputStream.close();
                        byteArrayOutputStream.close();
                        ThunderNative.setHttpsBinaryResponse(str, byteArrayOutputStream.toByteArray(), i, 0, i2);
                        return;
                    }
                }
            } catch (IOException e2) {
                onHttpsFailed(str, 0, 12, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHttpsFailed(String str, int i, int i2, int i3) {
        ThunderLog.warn(TAG, "onHttpsFailed statusCode=" + i + " errCode=" + i2 + " target=" + i3);
        ThunderNative.setHttpsTextResponse(str, "", i, i2, i3);
    }
}
