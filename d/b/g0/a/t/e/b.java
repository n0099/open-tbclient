package d.b.g0.a.t.e;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
import d.b.g0.a.k;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f46215b;

    /* renamed from: c  reason: collision with root package name */
    public String f46216c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f46217d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46218e;

    public b() {
        this.f46218e = false;
    }

    public static String c(int i) {
        if (i != 0) {
            if (i != 101) {
                if (i != 201) {
                    if (i != 202) {
                        if (i != 301) {
                            if (i != 302) {
                                switch (i) {
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

    @Override // d.b.g0.a.t.e.a
    @NonNull
    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(this.f46215b));
            if (TextUtils.isEmpty(this.f46216c)) {
                this.f46216c = c(this.f46215b);
            }
            jSONObject.put("message", this.f46216c);
            if (this.f46217d != null) {
                jSONObject.put("data", this.f46218e ? Uri.encode(this.f46217d.toString(), StandardCharsets.UTF_8.name()) : this.f46217d);
            }
        } catch (JSONException e2) {
            if (k.f45051a) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    @Override // d.b.g0.a.t.e.a
    public boolean b() {
        return this.f46215b == 0;
    }

    public boolean d(@NonNull String str, @Nullable Object obj) {
        if (this.f46217d == null) {
            this.f46217d = new JSONObject();
        }
        try {
            this.f46217d.put(str, obj);
            return true;
        } catch (JSONException e2) {
            if (k.f45051a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public String toString() {
        return a();
    }

    public b(int i) {
        this.f46218e = false;
        this.f46215b = i;
    }

    public b(int i, @NonNull String str) {
        this.f46218e = false;
        this.f46215b = i;
        this.f46216c = str;
    }

    public b(int i, @NonNull JSONObject jSONObject) {
        this.f46218e = false;
        this.f46215b = i;
        this.f46217d = jSONObject;
    }

    public b(int i, @NonNull JSONObject jSONObject, boolean z) {
        this.f46218e = false;
        this.f46215b = i;
        this.f46217d = jSONObject;
        this.f46218e = z;
    }

    public b(int i, @NonNull String str, @NonNull JSONObject jSONObject) {
        this.f46218e = false;
        this.f46215b = i;
        this.f46216c = str;
        this.f46217d = jSONObject;
    }
}
