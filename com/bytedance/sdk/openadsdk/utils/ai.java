package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes6.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private static String f5120a;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [40=4, 41=4, 46=4, 47=4, 49=4] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader2 = null;
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File("data/data/com.union_test.toutiao/" + str);
            if (!file.exists()) {
                if (0 != 0) {
                    try {
                        fileReader2.close();
                    } catch (Throwable th) {
                    }
                }
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                        return null;
                    } catch (Throwable th2) {
                        return null;
                    }
                }
                return null;
            }
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Throwable th3) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th4) {
                                }
                            }
                            return sb.toString();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable th6) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th7) {
                            }
                        }
                        throw th;
                    }
                }
                String sb2 = sb.toString();
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable th8) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        return sb2;
                    } catch (Throwable th9) {
                        return sb2;
                    }
                }
                return sb2;
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th10) {
                th = th10;
                bufferedReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th11) {
            th = th11;
            bufferedReader = null;
            fileReader = null;
        }
    }

    public static boolean a() {
        return u.c() && com.bytedance.sdk.openadsdk.core.i.d().v() && com.bytedance.sdk.openadsdk.core.i.d().w();
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
        if (str.contains("https://api-access.pangolin-sdk-toutiao.com")) {
            return str.replace("https://api-access.pangolin-sdk-toutiao.com", str2);
        }
        return str;
    }

    public static String b(String str) {
        try {
            if (a()) {
                String x = com.bytedance.sdk.openadsdk.core.i.d().x();
                if (!TextUtils.isEmpty(x)) {
                    Log.d("TestHelperUtils", "AnyDoorId=" + x);
                    return Uri.parse(str).buildUpon().appendQueryParameter(b(), x).appendQueryParameter("aid", "5001121").toString();
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(f5120a)) {
            f5120a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return f5120a;
    }
}
