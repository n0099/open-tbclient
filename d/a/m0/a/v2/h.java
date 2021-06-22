package d.a.m0.a.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.AssetUtils;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class h {
    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            d.a.m0.t.d.d(context.getAssets().open(str, 0));
            return true;
        } catch (IOException unused) {
            d.a.m0.t.d.d(null);
            return false;
        } catch (Throwable th) {
            d.a.m0.t.d.d(null);
            throw th;
        }
    }

    public static String b(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        r0 = null;
        String str2 = null;
        try {
            inputStream = context.getAssets().open(str);
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            d.a.m0.t.d.d(inputStream2);
            throw th;
        }
        if (inputStream == null) {
            d.a.m0.t.d.d(inputStream);
            return null;
        }
        try {
            try {
                str2 = d.a.m0.t.g.b(inputStream);
            } catch (IOException e3) {
                e = e3;
                if (d.a.m0.a.k.f46983a) {
                    Log.w(AssetUtils.TAG, "loadPresetDatas", e);
                }
                d.a.m0.t.d.d(inputStream);
                return str2;
            }
            d.a.m0.t.d.d(inputStream);
            return str2;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            d.a.m0.t.d.d(inputStream2);
            throw th;
        }
    }
}
