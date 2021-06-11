package d.r.b.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Locale;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String[][] f71466a = {new String[]{"com.duowan.mobile", "7.10.0"}};

    public static int a(Context context) {
        String[][] strArr;
        try {
            boolean z = false;
            for (String[] strArr2 : f71466a) {
                if (strArr2.length > 1) {
                    String str = strArr2[0];
                    try {
                        if (c.a(context.getPackageManager().getPackageInfo(str, 1).versionName, strArr2[1]) >= 0) {
                            Intent intent = new Intent();
                            intent.setClassName(str, "com.yy.udbauth.open.activity.AgentActivity");
                            if (c.e(context, intent)) {
                                return 0;
                            }
                        }
                        z = true;
                    } catch (Exception unused) {
                        z = false;
                    }
                }
            }
            return z ? 2 : 1;
        } catch (Exception unused2) {
            return 1;
        }
    }

    public static String b(Context context) {
        Signature[] signatureArr;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (Signature signature : signatureArr) {
                if (signature != null) {
                    byteArrayOutputStream.write(signature.toByteArray());
                }
            }
            byteArrayOutputStream.flush();
            String f2 = f(byteArrayOutputStream.toByteArray());
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            return f2;
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            e.printStackTrace();
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                    return "";
                } catch (IOException unused2) {
                    return "";
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public static String c(Context context, String str, String str2, boolean z) {
        return String.format(Locale.getDefault(), "%s?appId=%s&appType=android&appSign=%s&appDeviceid=%s&grantType=code&callbackType=uri&redirectUri=%s&state=%s", "https://thirdlogin.yy.com/open/oauth/authorize.do", str, b(context), b.a(context), g(z), str2);
    }

    public static Bundle d(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", str);
        bundle.putString("appname", c.b(context, context.getPackageName()));
        bundle.putString("appver", c.c(context));
        bundle.putString("appdeviceid", b.a(context));
        bundle.putString(BaseStatisContent.SDKVER, BuildConfig.VERSION_NAME);
        return bundle;
    }

    public static Intent e(Context context) {
        for (String[] strArr : f71466a) {
            String str = strArr[0];
            Intent intent = new Intent();
            intent.setClassName(str, "com.yy.udbauth.open.activity.AgentActivity");
            if (c.e(context, intent)) {
                return intent;
            }
        }
        return null;
    }

    public static String f(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i2 = 0;
            for (byte b2 : digest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String g(boolean z) {
        return z ? "https://raqweb.yy.com/" : "https://raq.yy.com/";
    }

    public static String h(int i2) {
        if (i2 != 444111001) {
            switch (i2) {
                case 444222000:
                    return "参数为空，请检查";
                case 444222001:
                    return "请求操作类型错误";
                case 444222002:
                    return "请求操作附带参数为空";
                case 444222003:
                    return "请求操作附带参数错误";
                default:
                    switch (i2) {
                        case 444222104:
                            return "授权APP返回的请求码出错";
                        case 444222105:
                            return "Json格式错误";
                        default:
                            return "未知错误";
                    }
            }
        }
        return "成功";
    }
}
