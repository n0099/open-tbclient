package d.a.j0.d3.l0.d;

import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import d.a.c.e.p.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g {
    public static String a(String str) {
        String[] split;
        String[] split2;
        String[] split3;
        if (k.isEmpty(str) || (split = str.split("\\?")) == null || split.length == 0 || (split2 = split[0].split("\\/\\/")) == null || split2.length < 2 || (split3 = split2[1].split("\\/")) == null || split2.length < 2) {
            return null;
        }
        return split3[split3.length - 1];
    }

    public static String b(String str) {
        Uri parse;
        if (k.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return parse.getQueryParameter("callback");
    }

    public static String c(String str) {
        Uri parse;
        if (k.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return parse.getQueryParameter(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    }

    public static String d(String str) {
        String[] split;
        String[] split2;
        String str2;
        String[] split3;
        String str3;
        try {
            if (!k.isEmpty(str) && (split = str.split("\\?")) != null && split.length != 0 && (split2 = split[0].split("\\/\\/")) != null && split2.length >= 2 && (split3 = (str2 = split2[1]).split("\\/")) != null && split2.length >= 2 && (str3 = split3[split3.length - 1]) != null && str3.length() != 0) {
                return str2.substring(0, (str2.length() - str3.length()) - 1);
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }

    public static String e(String str) {
        Uri parse;
        if (k.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return parse.getQueryParameter("notificationName");
    }

    public static JSONObject f(String str) throws JSONException {
        if (k.isEmpty(str)) {
            return new JSONObject();
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return new JSONObject();
        }
        String queryParameter = parse.getQueryParameter("params");
        if (k.isEmpty(queryParameter)) {
            return new JSONObject();
        }
        return new JSONObject(queryParameter);
    }
}
