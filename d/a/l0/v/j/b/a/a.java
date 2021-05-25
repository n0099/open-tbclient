package d.a.l0.v.j.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48556a = k.f43199a;

    /* renamed from: d.a.l0.v.j.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1091a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppComponentContainerView f48557e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48558f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48559g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48560h;

        public RunnableC1091a(SwanAppComponentContainerView swanAppComponentContainerView, boolean z, String str, String str2) {
            this.f48557e = swanAppComponentContainerView;
            this.f48558f = z;
            this.f48559g = str;
            this.f48560h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                int K = n0.K(this.f48557e.getWidth());
                int K2 = n0.K(this.f48557e.getHeight());
                jSONObject.putOpt("fullscreen", this.f48558f ? "1" : "0");
                jSONObject.putOpt("width", String.valueOf(K));
                jSONObject.putOpt("height", String.valueOf(K2));
            } catch (JSONException e2) {
                if (a.f48556a) {
                    e2.printStackTrace();
                }
            }
            a.b(this.f48559g, this.f48560h, "fullscreenchange", jSONObject);
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
                if (f48556a) {
                    e2.printStackTrace();
                }
            }
            d.a("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
            d.a.l0.a.w2.g.c.a.d(str2, str, "video", str3, jSONObject2);
        } else if (f48556a) {
            Log.e("VideoStatusEventHelper", "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str);
        }
    }

    public static void c(String str, String str2, boolean z, VideoContainerManager videoContainerManager) {
        SwanAppComponentContainerView I = videoContainerManager.I();
        I.post(new RunnableC1091a(I, z, str, str2));
    }
}
