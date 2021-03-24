package d.c.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class s extends h2 {
    public s() {
        super(true, false);
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(16);
        if (c()) {
            sb.append("MIUI-");
        } else if (e()) {
            sb.append("FLYME-");
        } else {
            String g2 = g();
            if (d(g2)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(g2)) {
                sb.append(g2);
                sb.append("-");
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put(Config.ROM, sb.toString());
        return true;
    }

    public final boolean c() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = g();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("emotionui")) {
            return f();
        }
        return true;
    }

    public final boolean e() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || ImmersiveOSUtils.FLYME.equals(Build.USER);
    }

    public final boolean f() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith(RomUtils.MANUFACTURER_HUAWEI)) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith(RomUtils.MANUFACTURER_HUAWEI));
    }

    public final String g() {
        BufferedReader bufferedReader;
        String str = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.emui").getInputStream()), 1024);
            try {
                str = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Throwable th) {
                th = th;
                try {
                    r0.b(th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }
}
