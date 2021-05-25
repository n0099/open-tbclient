package d.a.l0.f.j.n;

import com.baidu.down.manage.Download;
import com.baidu.down.request.task.ProgressInfo;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends d.a.l0.f.j.q.a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46931d = k.f43199a;

    public h(int i2) {
        super("onSuccess", 0, f(null, i2, false));
    }

    public static JSONObject d(Download download) {
        return e(download, false);
    }

    public static JSONObject e(Download download, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (download == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("apkId", new a(download).f());
            jSONObject.put("downloadId", download.getId());
            jSONObject.put("packageName", download.getKeyByUser());
            jSONObject.put("url", download.getUrl());
            if (z) {
                jSONObject.put("status", Download.DownloadState.CANCEL.ordinal());
            } else {
                jSONObject.put("status", download.getState().ordinal());
            }
            jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, download.getCurrentbytes());
            jSONObject.put("total", download.getTotalbytes());
            jSONObject.put("fileExist", b.c(download) ? "1" : "0");
        } catch (JSONException e2) {
            if (f46931d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static String f(Object obj, int i2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", obj);
            if (i2 > -1) {
                jSONObject.put("progress", i2);
            }
            jSONObject.put("installed", z);
        } catch (JSONException e2) {
            if (f46931d) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public h(boolean z) {
        super("onSuccess", 0, f(null, -1, z));
    }

    public h(Download download) {
        super("onSuccess", 0, f(d(download), -1, false));
    }

    public h(Download download, boolean z) {
        super("onSuccess", 0, f(e(download, z), -1, false));
    }
}
