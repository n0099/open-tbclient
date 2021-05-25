package d.a.l0.a.u.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
import d.a.l0.a.k;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f45238b;

    /* renamed from: c  reason: collision with root package name */
    public String f45239c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f45240d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45241e;

    public b() {
        this.f45241e = false;
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

    @Override // d.a.l0.a.u.h.a
    public boolean a() {
        return this.f45238b == 0;
    }

    @Override // d.a.l0.a.u.h.a
    @NonNull
    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(this.f45238b));
            if (TextUtils.isEmpty(this.f45239c)) {
                this.f45239c = c(this.f45238b);
            }
            jSONObject.put("message", this.f45239c);
            if (this.f45240d != null) {
                jSONObject.put("data", this.f45241e ? Uri.encode(this.f45240d.toString(), StandardCharsets.UTF_8.name()) : this.f45240d);
            }
        } catch (JSONException e2) {
            if (k.f43199a) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public void d(@NonNull String str, @NonNull Object obj) {
        if (this.f45240d == null) {
            this.f45240d = new JSONObject();
        }
        try {
            this.f45240d.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public boolean e(@NonNull String str, @Nullable Object obj) {
        if (this.f45240d == null) {
            this.f45240d = new JSONObject();
        }
        try {
            this.f45240d.put(str, obj);
            return true;
        } catch (JSONException e2) {
            if (k.f43199a) {
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
        this.f45241e = false;
        this.f45238b = i2;
    }

    public b(int i2, @NonNull String str) {
        this.f45241e = false;
        this.f45238b = i2;
        this.f45239c = str;
    }

    public b(int i2, @NonNull JSONObject jSONObject) {
        this.f45241e = false;
        this.f45238b = i2;
        this.f45240d = jSONObject;
    }

    public b(int i2, @NonNull JSONObject jSONObject, boolean z) {
        this.f45241e = false;
        this.f45238b = i2;
        this.f45240d = jSONObject;
        this.f45241e = z;
    }

    public b(int i2, @NonNull String str, @NonNull JSONObject jSONObject) {
        this.f45241e = false;
        this.f45238b = i2;
        this.f45239c = str;
        this.f45240d = jSONObject;
    }
}
