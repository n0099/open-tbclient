package d.b.a0.c;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41892a = f.f41882b;

    public static String a(int i) {
        if (i != 0) {
            if (i != 101) {
                if (i != 201) {
                    if (i != 202) {
                        if (i != 301) {
                            if (i != 302) {
                                switch (i) {
                                    case 401:
                                        return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_action_sec_check_fail);
                                    case 402:
                                        return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_action_acl_check_fail);
                                    case 403:
                                        return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_action_allow_close);
                                    default:
                                        return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_parse_fail);
                                }
                            }
                            return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_action_notfound);
                        }
                        return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_module_notfound);
                    }
                    return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_params_parse_fail);
                }
                return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_parse_fail);
            }
            return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_not_support);
        }
        return c.a().getString(d.b.e0.d.prologue_united_scheme_err_message_ok);
    }

    public static HashMap<String, String> b(String str) {
        String substring;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("#");
        if (indexOf < 0) {
            return hashMap;
        }
        if (indexOf2 < 0) {
            substring = str.substring(indexOf + 1);
        } else {
            substring = str.substring(indexOf + 1, indexOf2);
        }
        String[] split = substring.split("&");
        if (split == null) {
            return hashMap;
        }
        for (String str2 : split) {
            int indexOf3 = str2.indexOf("=");
            if (indexOf3 > 0) {
                try {
                    hashMap.put(URLDecoder.decode(str2.substring(0, indexOf3)), URLDecoder.decode(str2.substring(indexOf3 + 1)));
                } catch (IllegalArgumentException e2) {
                    if (f41892a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return hashMap;
    }

    public static String[] c(Uri uri) {
        if (uri == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(uri.getPathSegments());
        if (!d(uri)) {
            arrayList.add(0, uri.getHost());
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean d(Uri uri) {
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        return !TextUtils.isEmpty(host) && host.startsWith("v") && e(host);
    }

    public static boolean e(String str) {
        return Pattern.compile("[0-9]").matcher(str).find();
    }

    public static boolean f(Uri uri) {
        if (uri == null) {
            return false;
        }
        return TextUtils.equals(f.f41881a, uri.getScheme()) && !TextUtils.isEmpty(uri.getHost());
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f(Uri.parse(str));
    }

    public static JSONObject h(int i) {
        return j(null, i);
    }

    public static JSONObject i(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(i));
            jSONObject.put("message", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject j(JSONObject jSONObject, int i) {
        return k(jSONObject, i, a(i));
    }

    public static JSONObject k(JSONObject jSONObject, int i, String str) {
        JSONObject i2 = i(i, str);
        if (jSONObject != null) {
            try {
                i2.put("data", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return i2;
    }
}
