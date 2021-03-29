package d.b.g0.l.m.i;

import com.baidu.rtc.PeerConnectionClient;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f49022e = new a(200, PeerConnectionClient.HD_VIDEO_HEIGHT, 10, 168);

    /* renamed from: a  reason: collision with root package name */
    public final int f49023a;

    /* renamed from: b  reason: collision with root package name */
    public final int f49024b;

    /* renamed from: c  reason: collision with root package name */
    public final int f49025c;

    /* renamed from: d  reason: collision with root package name */
    public final int f49026d;

    public a(int i, int i2, int i3, int i4) {
        this.f49023a = i;
        this.f49024b = i2;
        this.f49025c = i3;
        this.f49026d = i4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", PeerConnectionClient.HD_VIDEO_HEIGHT), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
