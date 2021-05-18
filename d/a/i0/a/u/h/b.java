package d.a.i0.a.u.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
import d.a.i0.a.k;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f45062b;

    /* renamed from: c  reason: collision with root package name */
    public String f45063c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f45064d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45065e;

    public b() {
        this.f45065e = false;
    }

    public static String c(int i2) {
        if (i2 != 0) {
            if (i2 != 101) {
                if (i2 != 201) {
                    if (i2 != 202) {
                        if (i2 != 301) {
                            if (i2 != 302) {
                                switch (i2) {
                                    case 401:
                                        return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_sec_check_fail);
                                    case 402:
                                        return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_acl_check_fail);
                                    case 403:
                                        return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_allow_close);
                                    default:
                                        return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
                                }
                            }
                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_notfound);
                        }
                        return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_module_notfound);
                    }
                    return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_params_parse_fail);
                }
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
            }
            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_not_support);
        }
        return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_ok);
    }

    @Override // d.a.i0.a.u.h.a
    public boolean a() {
        return this.f45062b == 0;
    }

    @Override // d.a.i0.a.u.h.a
    @NonNull
    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(this.f45062b));
            if (TextUtils.isEmpty(this.f45063c)) {
                this.f45063c = c(this.f45062b);
            }
            jSONObject.put("message", this.f45063c);
            if (this.f45064d != null) {
                jSONObject.put("data", this.f45065e ? Uri.encode(this.f45064d.toString(), StandardCharsets.UTF_8.name()) : this.f45064d);
            }
        } catch (JSONException e2) {
            if (k.f43025a) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public void d(@NonNull String str, @NonNull Object obj) {
        if (this.f45064d == null) {
            this.f45064d = new JSONObject();
        }
        try {
            this.f45064d.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public boolean e(@NonNull String str, @Nullable Object obj) {
        if (this.f45064d == null) {
            this.f45064d = new JSONObject();
        }
        try {
            this.f45064d.put(str, obj);
            return true;
        } catch (JSONException e2) {
            if (k.f43025a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public String toString() {
        return b();
    }

    public b(int i2) {
        this.f45065e = false;
        this.f45062b = i2;
    }

    public b(int i2, @NonNull String str) {
        this.f45065e = false;
        this.f45062b = i2;
        this.f45063c = str;
    }

    public b(int i2, @NonNull JSONObject jSONObject) {
        this.f45065e = false;
        this.f45062b = i2;
        this.f45064d = jSONObject;
    }

    public b(int i2, @NonNull JSONObject jSONObject, boolean z) {
        this.f45065e = false;
        this.f45062b = i2;
        this.f45064d = jSONObject;
        this.f45065e = z;
    }

    public b(int i2, @NonNull String str, @NonNull JSONObject jSONObject) {
        this.f45065e = false;
        this.f45062b = i2;
        this.f45063c = str;
        this.f45064d = jSONObject;
    }
}
