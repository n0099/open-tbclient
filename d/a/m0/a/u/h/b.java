package d.a.m0.a.u.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
import d.a.m0.a.k;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f49020b;

    /* renamed from: c  reason: collision with root package name */
    public String f49021c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f49022d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49023e;

    public b() {
        this.f49023e = false;
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

    @Override // d.a.m0.a.u.h.a
    @NonNull
    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(this.f49020b));
            if (TextUtils.isEmpty(this.f49021c)) {
                this.f49021c = b(this.f49020b);
            }
            jSONObject.put("message", this.f49021c);
            if (this.f49022d != null) {
                jSONObject.put("data", this.f49023e ? Uri.encode(this.f49022d.toString(), StandardCharsets.UTF_8.name()) : this.f49022d);
            }
        } catch (JSONException e2) {
            if (k.f46983a) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public void c(@NonNull String str, @NonNull Object obj) {
        if (this.f49022d == null) {
            this.f49022d = new JSONObject();
        }
        try {
            this.f49022d.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public boolean d(@NonNull String str, @Nullable Object obj) {
        if (this.f49022d == null) {
            this.f49022d = new JSONObject();
        }
        try {
            this.f49022d.put(str, obj);
            return true;
        } catch (JSONException e2) {
            if (k.f46983a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Override // d.a.m0.a.u.h.a
    public boolean isSuccess() {
        return this.f49020b == 0;
    }

    public String toString() {
        return a();
    }

    public b(int i2) {
        this.f49023e = false;
        this.f49020b = i2;
    }

    public b(int i2, @NonNull String str) {
        this.f49023e = false;
        this.f49020b = i2;
        this.f49021c = str;
    }

    public b(int i2, @NonNull JSONObject jSONObject) {
        this.f49023e = false;
        this.f49020b = i2;
        this.f49022d = jSONObject;
    }

    public b(int i2, @NonNull JSONObject jSONObject, boolean z) {
        this.f49023e = false;
        this.f49020b = i2;
        this.f49022d = jSONObject;
        this.f49023e = z;
    }

    public b(int i2, @NonNull String str, @NonNull JSONObject jSONObject) {
        this.f49023e = false;
        this.f49020b = i2;
        this.f49021c = str;
        this.f49022d = jSONObject;
    }
}
