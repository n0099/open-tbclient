package d.b.h.b.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public final class b {
    public static String a(String str) {
        MessageDigest messageDigest;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                dataInputStream = new DataInputStream(new FileInputStream(str));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[131072];
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            String b2 = b(messageDigest.digest(), "");
            try {
                dataInputStream.close();
            } catch (Exception unused) {
            }
            return b2;
        } catch (Exception e3) {
            e = e3;
            dataInputStream2 = dataInputStream;
            e.printStackTrace();
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (Exception unused2) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            dataInputStream2 = dataInputStream;
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    public static String b(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean c() {
        String processTypeString = WebKitFactory.getProcessTypeString();
        if (TextUtils.isEmpty(processTypeString) || !processTypeString.equals("1")) {
            Boolean bool = Boolean.FALSE;
            WebViewFactoryProvider provider = WebViewFactory.getProvider();
            if (provider != null) {
                bool = (Boolean) provider.getStaticWebSeting(WebViewFactoryProvider.SETTING_NA2_WEB_ENABLE);
            }
            return bool.booleanValue();
        }
        return false;
    }

    public static boolean d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            int type = activeNetworkInfo.getType();
            if (activeNetworkInfo.isAvailable() && 1 == type) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(View view) {
        ViewParent parent;
        if (view == null || (parent = view.getParent()) == null || view.getVisibility() != 0) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int indexOfChild = viewGroup.indexOfChild(view);
        int childCount = viewGroup.getChildCount();
        if (indexOfChild == childCount - 1) {
            return true;
        }
        for (int i = indexOfChild + 1; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0 && childAt.getHeight() > 0 && childAt.getWidth() > 0 && view.getHeight() > 0 && view.getWidth() > 0 && childAt.getWidth() >= view.getWidth() && childAt.getHeight() >= view.getHeight()) {
                return false;
            }
        }
        return true;
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(new String(a.a(str.getBytes())), "UTF-8");
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return "";
        }
    }
}
