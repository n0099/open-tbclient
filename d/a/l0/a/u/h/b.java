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
    public int f48912b;

    /* renamed from: c  reason: collision with root package name */
    public String f48913c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f48914d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48915e;

    public b() {
        this.f48915e = false;
    }

    public static String b(int i2) {
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
    @NonNull
    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(this.f48912b));
            if (TextUtils.isEmpty(this.f48913c)) {
                this.f48913c = b(this.f48912b);
            }
            jSONObject.put("message", this.f48913c);
            if (this.f48914d != null) {
                jSONObject.put("data", this.f48915e ? Uri.encode(this.f48914d.toString(), StandardCharsets.UTF_8.name()) : this.f48914d);
            }
        } catch (JSONException e2) {
            if (k.f46875a) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public void c(@NonNull String str, @NonNull Object obj) {
        if (this.f48914d == null) {
            this.f48914d = new JSONObject();
        }
        try {
            this.f48914d.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public boolean d(@NonNull String str, @Nullable Object obj) {
        if (this.f48914d == null) {
            this.f48914d = new JSONObject();
        }
        try {
            this.f48914d.put(str, obj);
            return true;
        } catch (JSONException e2) {
            if (k.f46875a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Override // d.a.l0.a.u.h.a
    public boolean isSuccess() {
        return this.f48912b == 0;
    }

    public String toString() {
        return a();
    }

    public b(int i2) {
        this.f48915e = false;
        this.f48912b = i2;
    }

    public b(int i2, @NonNull String str) {
        this.f48915e = false;
        this.f48912b = i2;
        this.f48913c = str;
    }

    public b(int i2, @NonNull JSONObject jSONObject) {
        this.f48915e = false;
        this.f48912b = i2;
        this.f48914d = jSONObject;
    }

    public b(int i2, @NonNull JSONObject jSONObject, boolean z) {
        this.f48915e = false;
        this.f48912b = i2;
        this.f48914d = jSONObject;
        this.f48915e = z;
    }

    public b(int i2, @NonNull String str, @NonNull JSONObject jSONObject) {
        this.f48915e = false;
        this.f48912b = i2;
        this.f48913c = str;
        this.f48914d = jSONObject;
    }
}
