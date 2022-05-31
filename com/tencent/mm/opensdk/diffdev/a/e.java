package com.tencent.mm.opensdk.diffdev.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:108:0x0146 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream2;
        HttpURLConnection httpURLConnection2;
        ByteArrayOutputStream byteArrayOutputStream3;
        HttpURLConnection httpURLConnection3;
        ByteArrayOutputStream byteArrayOutputStream4;
        ByteArrayOutputStream byteArrayOutputStream5;
        ByteArrayOutputStream byteArrayOutputStream6;
        ByteArrayOutputStream byteArrayOutputStream7;
        HttpURLConnection httpURLConnection4;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection5;
        InputStream inputStream3;
        HttpURLConnection httpURLConnection6;
        InputStream inputStream4;
        ByteArrayOutputStream byteArrayOutputStream8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            HttpURLConnection httpURLConnection7 = null;
            if (str != 0) {
                try {
                    if (str.length() != 0) {
                        try {
                            str = (HttpURLConnection) new URL(str).openConnection();
                            try {
                                if (str == 0) {
                                    Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");
                                    if (str != 0) {
                                        try {
                                            str.disconnect();
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    return null;
                                }
                                str.setRequestMethod("GET");
                                str.setConnectTimeout(60000);
                                str.setReadTimeout(60000);
                                if (str.getResponseCode() >= 300) {
                                    Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");
                                    if (str != 0) {
                                        try {
                                            str.disconnect();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    return null;
                                }
                                InputStream inputStream5 = str.getInputStream();
                                try {
                                    byteArrayOutputStream8 = new ByteArrayOutputStream();
                                } catch (MalformedURLException e) {
                                    byteArrayOutputStream7 = null;
                                    inputStream4 = inputStream5;
                                    e = e;
                                    httpURLConnection6 = str;
                                } catch (IOException e2) {
                                    byteArrayOutputStream6 = null;
                                    inputStream3 = inputStream5;
                                    e = e2;
                                    httpURLConnection5 = str;
                                } catch (Exception e3) {
                                    byteArrayOutputStream5 = null;
                                    inputStream2 = inputStream5;
                                    e = e3;
                                    httpURLConnection4 = str;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = null;
                                    inputStream = inputStream5;
                                    httpURLConnection7 = str;
                                    if (httpURLConnection7 != null) {
                                        try {
                                            httpURLConnection7.disconnect();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused4) {
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Throwable unused5) {
                                        }
                                    }
                                    throw th;
                                }
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream5.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream8.write(bArr, 0, read);
                                    }
                                    byte[] byteArray = byteArrayOutputStream8.toByteArray();
                                    Log.d("MicroMsg.SDK.NetUtil", "httpGet end");
                                    if (str != 0) {
                                        try {
                                            str.disconnect();
                                        } catch (Throwable unused6) {
                                        }
                                    }
                                    if (inputStream5 != null) {
                                        try {
                                            inputStream5.close();
                                        } catch (Throwable unused7) {
                                        }
                                    }
                                    try {
                                        byteArrayOutputStream8.close();
                                    } catch (Throwable unused8) {
                                    }
                                    return byteArray;
                                } catch (MalformedURLException e4) {
                                    inputStream4 = inputStream5;
                                    e = e4;
                                    byteArrayOutputStream7 = byteArrayOutputStream8;
                                    httpURLConnection6 = str;
                                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                    if (httpURLConnection6 != null) {
                                    }
                                    if (inputStream4 != 0) {
                                    }
                                    if (byteArrayOutputStream7 != null) {
                                    }
                                    return null;
                                } catch (IOException e5) {
                                    inputStream3 = inputStream5;
                                    e = e5;
                                    byteArrayOutputStream6 = byteArrayOutputStream8;
                                    httpURLConnection5 = str;
                                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                    if (httpURLConnection5 != null) {
                                    }
                                    if (inputStream3 != 0) {
                                    }
                                    if (byteArrayOutputStream6 != null) {
                                    }
                                    return null;
                                } catch (Exception e6) {
                                    inputStream2 = inputStream5;
                                    e = e6;
                                    byteArrayOutputStream5 = byteArrayOutputStream8;
                                    httpURLConnection4 = str;
                                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                    if (httpURLConnection4 != null) {
                                    }
                                    if (inputStream2 != 0) {
                                    }
                                    if (byteArrayOutputStream5 != null) {
                                    }
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    httpURLConnection7 = str;
                                    byteArrayOutputStream = byteArrayOutputStream8;
                                    inputStream = inputStream5;
                                    if (httpURLConnection7 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    throw th;
                                }
                            } catch (MalformedURLException e7) {
                                e = e7;
                                byteArrayOutputStream4 = null;
                                httpURLConnection3 = str;
                                byteArrayOutputStream7 = byteArrayOutputStream4;
                                inputStream4 = byteArrayOutputStream4;
                                httpURLConnection6 = httpURLConnection3;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                if (httpURLConnection6 != null) {
                                    try {
                                        httpURLConnection6.disconnect();
                                    } catch (Throwable unused9) {
                                    }
                                }
                                if (inputStream4 != 0) {
                                    try {
                                        inputStream4.close();
                                    } catch (Throwable unused10) {
                                    }
                                }
                                if (byteArrayOutputStream7 != null) {
                                    try {
                                        byteArrayOutputStream7.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                                return null;
                            } catch (IOException e8) {
                                e = e8;
                                byteArrayOutputStream3 = null;
                                httpURLConnection2 = str;
                                byteArrayOutputStream6 = byteArrayOutputStream3;
                                inputStream3 = byteArrayOutputStream3;
                                httpURLConnection5 = httpURLConnection2;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                if (httpURLConnection5 != null) {
                                    try {
                                        httpURLConnection5.disconnect();
                                    } catch (Throwable unused12) {
                                    }
                                }
                                if (inputStream3 != 0) {
                                    try {
                                        inputStream3.close();
                                    } catch (Throwable unused13) {
                                    }
                                }
                                if (byteArrayOutputStream6 != null) {
                                    try {
                                        byteArrayOutputStream6.close();
                                    } catch (Throwable unused14) {
                                    }
                                }
                                return null;
                            } catch (Exception e9) {
                                e = e9;
                                byteArrayOutputStream2 = null;
                                httpURLConnection = str;
                                byteArrayOutputStream5 = byteArrayOutputStream2;
                                inputStream2 = byteArrayOutputStream2;
                                httpURLConnection4 = httpURLConnection;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                                if (httpURLConnection4 != null) {
                                    try {
                                        httpURLConnection4.disconnect();
                                    } catch (Throwable unused15) {
                                    }
                                }
                                if (inputStream2 != 0) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable unused16) {
                                    }
                                }
                                if (byteArrayOutputStream5 != null) {
                                    try {
                                        byteArrayOutputStream5.close();
                                    } catch (Throwable unused17) {
                                    }
                                }
                                return null;
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                                byteArrayOutputStream = null;
                            }
                        } catch (MalformedURLException e10) {
                            e = e10;
                            httpURLConnection3 = null;
                            byteArrayOutputStream4 = null;
                        } catch (IOException e11) {
                            e = e11;
                            httpURLConnection2 = null;
                            byteArrayOutputStream3 = null;
                        } catch (Exception e12) {
                            e = e12;
                            httpURLConnection = null;
                            byteArrayOutputStream2 = null;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = null;
                            byteArrayOutputStream = null;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
