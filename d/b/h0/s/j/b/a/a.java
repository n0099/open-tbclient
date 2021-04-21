package d.b.h0.s.j.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import d.b.h0.a.c0.c;
import d.b.h0.a.i2.h0;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50116a = k.f45772a;

    /* renamed from: d.b.h0.s.j.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1067a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppComponentContainerView f50117e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f50118f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50119g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50120h;

        public RunnableC1067a(SwanAppComponentContainerView swanAppComponentContainerView, boolean z, String str, String str2) {
            this.f50117e = swanAppComponentContainerView;
            this.f50118f = z;
            this.f50119g = str;
            this.f50120h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                int H = h0.H(this.f50117e.getWidth());
                int H2 = h0.H(this.f50117e.getHeight());
                jSONObject.putOpt("fullscreen", this.f50118f ? "1" : "0");
                jSONObject.putOpt("width", String.valueOf(H));
                jSONObject.putOpt("height", String.valueOf(H2));
            } catch (JSONException e2) {
                if (a.f50116a) {
                    e2.printStackTrace();
                }
            }
            a.b(this.f50119g, this.f50120h, "fullscreenchange", jSONObject);
        }
    }

    public static void b(String str, String str2, String str3, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("wvID", str2);
                jSONObject2.put("vtype", str3);
                jSONObject.putOpt("videoId", str);
                jSONObject2.put("data", jSONObject.toString());
            } catch (JSONException e2) {
                if (f50116a) {
                    e2.printStackTrace();
                }
            }
            c.a("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
            d.b.h0.a.j2.f.c.a.d(str2, str, "video", str3, jSONObject2);
        } else if (f50116a) {
            Log.e("VideoStatusEventHelper", "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str);
        }
    }

    public static void c(String str, String str2, boolean z, VideoContainerManager videoContainerManager) {
        SwanAppComponentContainerView I = videoContainerManager.I();
        I.post(new RunnableC1067a(I, z, str, str2));
    }
}
