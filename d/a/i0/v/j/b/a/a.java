package d.a.i0.v.j.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
import d.a.i0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48380a = k.f43025a;

    /* renamed from: d.a.i0.v.j.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1080a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppComponentContainerView f48381e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48382f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48383g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48384h;

        public RunnableC1080a(SwanAppComponentContainerView swanAppComponentContainerView, boolean z, String str, String str2) {
            this.f48381e = swanAppComponentContainerView;
            this.f48382f = z;
            this.f48383g = str;
            this.f48384h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                int K = n0.K(this.f48381e.getWidth());
                int K2 = n0.K(this.f48381e.getHeight());
                jSONObject.putOpt("fullscreen", this.f48382f ? "1" : "0");
                jSONObject.putOpt("width", String.valueOf(K));
                jSONObject.putOpt("height", String.valueOf(K2));
            } catch (JSONException e2) {
                if (a.f48380a) {
                    e2.printStackTrace();
                }
            }
            a.b(this.f48383g, this.f48384h, "fullscreenchange", jSONObject);
        }
    }

    public static void b(String str, String str2, String str3, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                jSONObject2.put("vtype", str3);
                jSONObject.putOpt("videoId", str);
                jSONObject2.put("data", jSONObject.toString());
            } catch (JSONException e2) {
                if (f48380a) {
                    e2.printStackTrace();
                }
            }
            d.a("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
            d.a.i0.a.w2.g.c.a.d(str2, str, "video", str3, jSONObject2);
        } else if (f48380a) {
            Log.e("VideoStatusEventHelper", "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str);
        }
    }

    public static void c(String str, String str2, boolean z, VideoContainerManager videoContainerManager) {
        SwanAppComponentContainerView I = videoContainerManager.I();
        I.post(new RunnableC1080a(I, z, str, str2));
    }
}
