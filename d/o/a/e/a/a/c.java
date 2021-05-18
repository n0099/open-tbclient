package d.o.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends a {

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f66969d;

    public c(Context context, d.o.a.e.b.j.a aVar, String str, JSONObject jSONObject) {
        super(context, aVar, str);
        this.f66969d = jSONObject;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void c(JSONObject jSONObject, String str, String str2, Intent intent) {
        char c2;
        switch (str2.hashCode()) {
            case -1325958191:
                if (str2.equals("double")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -891985903:
                if (str2.equals("string")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 104431:
                if (str2.equals("int")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3327612:
                if (str2.equals("long")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 64711720:
                if (str2.equals("boolean")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            intent.putExtra(str, jSONObject.optInt(str));
        } else if (c2 == 1) {
            intent.putExtra(str, jSONObject.optBoolean(str));
        } else if (c2 == 2) {
            intent.putExtra(str, jSONObject.optLong(str));
        } else if (c2 == 3) {
            intent.putExtra(str, jSONObject.optDouble(str));
        } else if (c2 != 4) {
        } else {
            intent.putExtra(str, jSONObject.optString(str));
        }
    }

    @Override // d.o.a.e.a.a.e
    public Intent b() {
        String optString = this.f66969d.optString("action");
        String optString2 = this.f66969d.optString("category");
        int optInt = this.f66969d.optInt("flags", 1342210048);
        String optString3 = this.f66969d.optString("path_extra_key");
        String optString4 = this.f66969d.optString("path_data_key");
        JSONObject optJSONObject = this.f66969d.optJSONObject("extra");
        JSONObject optJSONObject2 = this.f66969d.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, this.f66968c)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.f66968c);
        }
        b(intent, optJSONObject, optJSONObject2);
        return intent;
    }

    public static void b(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject2.optString(next);
            if (optString != null) {
                c(jSONObject, next, optString, intent);
            }
        }
    }
}
