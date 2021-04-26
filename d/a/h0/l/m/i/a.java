package d.a.h0.l.m.i;

import com.baidu.rtc.PeerConnectionClient;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f47257e = new a(200, PeerConnectionClient.HD_VIDEO_HEIGHT, 10, 168);

    /* renamed from: a  reason: collision with root package name */
    public final int f47258a;

    /* renamed from: b  reason: collision with root package name */
    public final int f47259b;

    /* renamed from: c  reason: collision with root package name */
    public final int f47260c;

    /* renamed from: d  reason: collision with root package name */
    public final int f47261d;

    public a(int i2, int i3, int i4, int i5) {
        this.f47258a = i2;
        this.f47259b = i3;
        this.f47260c = i4;
        this.f47261d = i5;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optInt("clean_max_count", 200), jSONObject.optInt("force_clean_hour", PeerConnectionClient.HD_VIDEO_HEIGHT), jSONObject.optInt("hold_max_count", 10), jSONObject.optInt("ignore_clean_hour", 168));
    }
}
