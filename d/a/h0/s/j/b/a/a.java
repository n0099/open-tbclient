package d.a.h0.s.j.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import d.a.h0.a.c0.c;
import d.a.h0.a.i2.h0;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47649a = k.f43101a;

    /* renamed from: d.a.h0.s.j.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1006a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppComponentContainerView f47650e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f47651f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47652g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47653h;

        public RunnableC1006a(SwanAppComponentContainerView swanAppComponentContainerView, boolean z, String str, String str2) {
            this.f47650e = swanAppComponentContainerView;
            this.f47651f = z;
            this.f47652g = str;
            this.f47653h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                int H = h0.H(this.f47650e.getWidth());
                int H2 = h0.H(this.f47650e.getHeight());
                jSONObject.putOpt("fullscreen", this.f47651f ? "1" : "0");
                jSONObject.putOpt("width", String.valueOf(H));
                jSONObject.putOpt("height", String.valueOf(H2));
            } catch (JSONException e2) {
                if (a.f47649a) {
                    e2.printStackTrace();
                }
            }
            a.b(this.f47652g, this.f47653h, "fullscreenchange", jSONObject);
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
                if (f47649a) {
                    e2.printStackTrace();
                }
            }
            c.a("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
            d.a.h0.a.j2.f.c.a.d(str2, str, "video", str3, jSONObject2);
        } else if (f47649a) {
            Log.e("VideoStatusEventHelper", "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str);
        }
    }

    public static void c(String str, String str2, boolean z, VideoContainerManager videoContainerManager) {
        SwanAppComponentContainerView I = videoContainerManager.I();
        I.post(new RunnableC1006a(I, z, str, str2));
    }
}
