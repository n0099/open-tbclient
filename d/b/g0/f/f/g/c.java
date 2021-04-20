package d.b.g0.f.f.g;

import com.baidu.down.manage.Download;
import com.baidu.down.request.task.ProgressInfo;
import d.b.g0.a.k;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48221d = k.f45443a;

    public c(String str) {
        super("onSuccess", 0, g(null, str));
    }

    public static JSONArray e(Collection<Download> collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection == null) {
            return jSONArray;
        }
        for (Download download : collection) {
            if (download != null) {
                jSONArray.put(f(download));
            }
        }
        return jSONArray;
    }

    public static JSONObject f(Download download) {
        JSONObject jSONObject = new JSONObject();
        if (download == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("apkId", new d.b.g0.f.f.d.a(download).c());
            jSONObject.put("downloadId", download.getId());
            jSONObject.put("packageName", download.getKeyByUser());
            jSONObject.put("url", download.getUrl());
            jSONObject.put("status", download.getState().ordinal());
            jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, download.getCurrentbytes());
            jSONObject.put("total", download.getTotalbytes());
            jSONObject.put("fileExist", d.b.g0.f.f.d.c.i(download) ? "1" : "0");
        } catch (JSONException e2) {
            if (f48221d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static String g(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", obj);
            jSONObject.put("message", str);
        } catch (JSONException e2) {
            if (f48221d) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public c(Download download) {
        super("onSuccess", 0, g(f(download), ""));
    }

    public c(Collection<Download> collection) {
        super("onSuccess", 0, g(e(collection), ""));
    }
}
