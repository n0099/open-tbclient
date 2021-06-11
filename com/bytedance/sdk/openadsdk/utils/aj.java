package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes6.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    public static String f30264a;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x004c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0071 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.FileReader, java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Exception e2;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            try {
                File file = new File("data/data/com.union_test.toutiao/" + ((String) str));
                if (!file.exists()) {
                    return null;
                }
                str = new FileReader(file);
                try {
                    bufferedReader2 = new BufferedReader(str);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (Exception e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (str != 0) {
                                try {
                                    str.close();
                                } catch (Throwable unused) {
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            return sb.toString();
                        }
                    }
                    String sb2 = sb.toString();
                    try {
                        str.close();
                    } catch (Throwable unused3) {
                    }
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused4) {
                    }
                    return sb2;
                } catch (Exception e4) {
                    bufferedReader2 = null;
                    e2 = e4;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                    fileReader = str;
                    if (fileReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            bufferedReader2 = null;
            e2 = e5;
            str = 0;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable unused5) {
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused6) {
                }
            }
            throw th;
        }
    }

    public static String b(String str) {
        try {
            if (a()) {
                String y = com.bytedance.sdk.openadsdk.core.i.d().y();
                if (TextUtils.isEmpty(y)) {
                    return str;
                }
                Log.d("TestHelperUtils", "AnyDoorId=" + y);
                return Uri.parse(str).buildUpon().appendQueryParameter(b(), y).appendQueryParameter("aid", "5001121").toString();
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(f30264a)) {
            f30264a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return f30264a;
    }

    public static boolean a() {
        return u.c() && com.bytedance.sdk.openadsdk.core.i.d().w() && com.bytedance.sdk.openadsdk.core.i.d().x();
    }

    public static String a(String str, String str2) {
        if (str.contains("https://pangolin.snssdk.com")) {
            return str.replace("https://pangolin.snssdk.com", str2);
        }
        if (str.contains("https://is.snssdk.com")) {
            return str.replace("https://is.snssdk.com", str2);
        }
        if (str.contains("https://pangolin16.snssdk.com")) {
            return str.replace("https://pangolin16.snssdk.com", str2);
        }
        return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
    }
}
