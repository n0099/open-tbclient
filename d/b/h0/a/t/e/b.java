package d.b.h0.a.t.e;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
import d.b.h0.a.k;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f46936b;

    /* renamed from: c  reason: collision with root package name */
    public String f46937c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f46938d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46939e;

    public b() {
        this.f46939e = false;
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

    @Override // d.b.h0.a.t.e.a
    @NonNull
    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(this.f46936b));
            if (TextUtils.isEmpty(this.f46937c)) {
                this.f46937c = c(this.f46936b);
            }
            jSONObject.put("message", this.f46937c);
            if (this.f46938d != null) {
                jSONObject.put("data", this.f46939e ? Uri.encode(this.f46938d.toString(), StandardCharsets.UTF_8.name()) : this.f46938d);
            }
        } catch (JSONException e2) {
            if (k.f45772a) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    @Override // d.b.h0.a.t.e.a
    public boolean b() {
        return this.f46936b == 0;
    }

    public boolean d(@NonNull String str, @Nullable Object obj) {
        if (this.f46938d == null) {
            this.f46938d = new JSONObject();
        }
        try {
            this.f46938d.put(str, obj);
            return true;
        } catch (JSONException e2) {
            if (k.f45772a) {
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
        this.f46939e = false;
        this.f46936b = i;
    }

    public b(int i, @NonNull String str) {
        this.f46939e = false;
        this.f46936b = i;
        this.f46937c = str;
    }

    public b(int i, @NonNull JSONObject jSONObject) {
        this.f46939e = false;
        this.f46936b = i;
        this.f46938d = jSONObject;
    }

    public b(int i, @NonNull JSONObject jSONObject, boolean z) {
        this.f46939e = false;
        this.f46936b = i;
        this.f46938d = jSONObject;
        this.f46939e = z;
    }

    public b(int i, @NonNull String str, @NonNull JSONObject jSONObject) {
        this.f46939e = false;
        this.f46936b = i;
        this.f46937c = str;
        this.f46938d = jSONObject;
    }
}
