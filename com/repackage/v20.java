package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v20 extends l20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v20() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00eb  */
    @Override // com.repackage.n20
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, String str2, Map<String, String> map, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Throwable th;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, map, jSONObject)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("urlStr should not be null");
            }
            OutputStream outputStream3 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    try {
                        httpURLConnection.setConnectTimeout(15000);
                        httpURLConnection.setReadTimeout(15000);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestMethod(str2);
                        if (map != null) {
                            try {
                                if (map.size() > 0) {
                                    for (String str3 : map.keySet()) {
                                        httpURLConnection.setRequestProperty(str3, map.get(str3));
                                    }
                                    httpURLConnection.setRequestProperty("Content-type", "application/json");
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = null;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (outputStream3 != null) {
                                    try {
                                        outputStream3.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                        outputStream2 = httpURLConnection.getOutputStream();
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream = null;
                    }
                } catch (UnsupportedEncodingException unused) {
                    outputStream2 = null;
                } catch (MalformedURLException unused2) {
                    outputStream2 = null;
                } catch (ProtocolException unused3) {
                    outputStream2 = null;
                } catch (IOException unused4) {
                    outputStream2 = null;
                }
            } catch (UnsupportedEncodingException unused5) {
                httpURLConnection = null;
                outputStream2 = null;
            } catch (MalformedURLException unused6) {
                httpURLConnection = null;
                outputStream2 = null;
            } catch (ProtocolException unused7) {
                httpURLConnection = null;
                outputStream2 = null;
            } catch (IOException unused8) {
                httpURLConnection = null;
                outputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                outputStream = null;
            }
            try {
                outputStream2.write(jSONObject.toString().getBytes(IMAudioTransRequest.CHARSET));
                outputStream2.flush();
                if (httpURLConnection.getResponseCode() != 200) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), IMAudioTransRequest.CHARSET));
                String str4 = "";
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str4 = str4 + readLine;
                    } catch (IOException unused9) {
                    } catch (Throwable th5) {
                        outputStream3 = outputStream2;
                        th = th5;
                        if (httpURLConnection != null) {
                        }
                        if (outputStream3 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return str4;
            } catch (UnsupportedEncodingException unused10) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return null;
            } catch (MalformedURLException unused11) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                return null;
            } catch (ProtocolException unused12) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                return null;
            } catch (IOException unused13) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th6) {
                outputStream = outputStream2;
                th = th6;
                outputStream3 = outputStream;
                bufferedReader = null;
                if (httpURLConnection != null) {
                }
                if (outputStream3 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        }
        return (String) invokeLLLL.objValue;
    }
}
