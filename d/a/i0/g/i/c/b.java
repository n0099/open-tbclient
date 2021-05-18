package d.a.i0.g.i.c;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.RomUtils;
import d.a.i0.a.a2.e;
import d.a.i0.a.k;
import d.a.i0.a.v2.a0;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.i0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46917c = k.f43025a;

    public b() {
        super("startPermissionsPage");
    }

    @Override // d.a.i0.g.f.a
    public d.a.i0.a.u.h.b a(JSONObject jSONObject, d.a.i0.a.u0.b bVar) {
        e Q = e.Q();
        if (Q != null && Q.x() != null) {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                str = str.toLowerCase(Locale.US);
            }
            if (TextUtils.equals(str, RomUtils.MANUFACTURER_OPPO)) {
                try {
                    Intent intent = new Intent(Q.x().getPackageName());
                    intent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
                    Q.x().startActivity(intent);
                } catch (Exception e2) {
                    if (f46917c) {
                        e2.printStackTrace();
                    }
                    a0.f(Q.x());
                }
            } else {
                a0.g(Q.x());
            }
            bVar.b(null);
        } else if (f46917c) {
            Log.d("StartPermissionsPage", "swan or activity is null");
        }
        return null;
    }
}
