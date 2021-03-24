package d.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65051e;

    public q(Context context) {
        super(false, false);
        this.f65051e = context;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        String str;
        try {
            str = Settings.Secure.getString(this.f65051e.getContentResolver(), "android_id");
        } catch (Exception e2) {
            r0.d("", e2);
            str = null;
        }
        if (!j.n(str) || "9774d56d682e549c".equals(str)) {
            SharedPreferences sharedPreferences = this.f65051e.getSharedPreferences("snssdk_openudid", 0);
            String string = sharedPreferences.getString("openudid", null);
            if (!j.n(string)) {
                string = new BigInteger(64, new SecureRandom()).toString(16);
                if (string.charAt(0) == '-') {
                    string = string.substring(1);
                }
                int length = 13 - string.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(string);
                    string = sb.toString();
                }
                try {
                    string = a("openudid.dat", string);
                } catch (Exception unused) {
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("openudid", string);
                edit.apply();
            }
            str = string;
        }
        jSONObject.put("openudid", str);
        return true;
    }
}
