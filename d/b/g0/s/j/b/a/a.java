package d.b.g0.s.j.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.h0;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49395a = k.f45051a;

    /* renamed from: d.b.g0.s.j.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1035a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppComponentContainerView f49396e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f49397f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f49398g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f49399h;

        public RunnableC1035a(SwanAppComponentContainerView swanAppComponentContainerView, boolean z, String str, String str2) {
            this.f49396e = swanAppComponentContainerView;
            this.f49397f = z;
            this.f49398g = str;
            this.f49399h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                int H = h0.H(this.f49396e.getWidth());
                int H2 = h0.H(this.f49396e.getHeight());
                jSONObject.putOpt("fullscreen", this.f49397f ? "1" : "0");
                jSONObject.putOpt("width", String.valueOf(H));
                jSONObject.putOpt("height", String.valueOf(H2));
            } catch (JSONException e2) {
                if (a.f49395a) {
                    e2.printStackTrace();
                }
            }
            a.b(this.f49398g, this.f49399h, "fullscreenchange", jSONObject);
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
                if (f49395a) {
                    e2.printStackTrace();
                }
            }
            c.a("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
            d.b.g0.a.j2.f.c.a.d(str2, str, "video", str3, jSONObject2);
        } else if (f49395a) {
            Log.e("VideoStatusEventHelper", "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str);
        }
    }

    public static void c(String str, String str2, boolean z, VideoContainerManager videoContainerManager) {
        SwanAppComponentContainerView I = videoContainerManager.I();
        I.post(new RunnableC1035a(I, z, str, str2));
    }
}
