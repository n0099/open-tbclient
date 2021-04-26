package d.a.h0.a.t.e;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
import d.a.h0.a.k;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f44324b;

    /* renamed from: c  reason: collision with root package name */
    public String f44325c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f44326d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44327e;

    public b() {
        this.f44327e = false;
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

    @Override // d.a.h0.a.t.e.a
    public boolean a() {
        return this.f44324b == 0;
    }

    @Override // d.a.h0.a.t.e.a
    @NonNull
    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(this.f44324b));
            if (TextUtils.isEmpty(this.f44325c)) {
                this.f44325c = c(this.f44324b);
            }
            jSONObject.put("message", this.f44325c);
            if (this.f44326d != null) {
                jSONObject.put("data", this.f44327e ? Uri.encode(this.f44326d.toString(), StandardCharsets.UTF_8.name()) : this.f44326d);
            }
        } catch (JSONException e2) {
            if (k.f43101a) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public boolean d(@NonNull String str, @Nullable Object obj) {
        if (this.f44326d == null) {
            this.f44326d = new JSONObject();
        }
        try {
            this.f44326d.put(str, obj);
            return true;
        } catch (JSONException e2) {
            if (k.f43101a) {
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
        this.f44327e = false;
        this.f44324b = i2;
    }

    public b(int i2, @NonNull String str) {
        this.f44327e = false;
        this.f44324b = i2;
        this.f44325c = str;
    }

    public b(int i2, @NonNull JSONObject jSONObject) {
        this.f44327e = false;
        this.f44324b = i2;
        this.f44326d = jSONObject;
    }

    public b(int i2, @NonNull JSONObject jSONObject, boolean z) {
        this.f44327e = false;
        this.f44324b = i2;
        this.f44326d = jSONObject;
        this.f44327e = z;
    }

    public b(int i2, @NonNull String str, @NonNull JSONObject jSONObject) {
        this.f44327e = false;
        this.f44324b = i2;
        this.f44325c = str;
        this.f44326d = jSONObject;
    }
}
