package d.b.g0.l.m.i;

import com.baidu.rtc.PeerConnectionClient;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f49414e = new a(200, PeerConnectionClient.HD_VIDEO_HEIGHT, 10, 168);

    /* renamed from: a  reason: collision with root package name */
    public final int f49415a;

    /* renamed from: b  reason: collision with root package name */
    public final int f49416b;

    /* renamed from: c  reason: collision with root package name */
    public final int f49417c;

    /* renamed from: d  reason: collision with root package name */
    public final int f49418d;

    public a(int i, int i2, int i3, int i4) {
        this.f49415a = i;
        this.f49416b = i2;
        this.f49417c = i3;
        this.f49418d = i4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", PeerConnectionClient.HD_VIDEO_HEIGHT), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
