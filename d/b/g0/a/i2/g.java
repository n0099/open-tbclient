package d.b.g0.a.i2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.AssetUtils;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class g {
    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            d.b.g0.p.d.a(context.getAssets().open(str, 0));
            return true;
        } catch (IOException unused) {
            d.b.g0.p.d.a(null);
            return false;
        } catch (Throwable th) {
            d.b.g0.p.d.a(null);
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
            d.b.g0.p.d.a(inputStream2);
            throw th;
        }
        if (inputStream == null) {
            d.b.g0.p.d.a(inputStream);
            return null;
        }
        try {
            try {
                str2 = d.b.g0.p.f.b(inputStream);
            } catch (IOException e3) {
                e = e3;
                if (d.b.g0.a.k.f45443a) {
                    Log.w(AssetUtils.TAG, "loadPresetDatas", e);
                }
                d.b.g0.p.d.a(inputStream);
                return str2;
            }
            d.b.g0.p.d.a(inputStream);
            return str2;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            d.b.g0.p.d.a(inputStream2);
            throw th;
        }
    }
}
