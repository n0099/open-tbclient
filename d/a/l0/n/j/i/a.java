package d.a.l0.n.j.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.rtc.PeerConnectionClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f51803a;

    /* renamed from: b  reason: collision with root package name */
    public int f51804b;

    /* renamed from: c  reason: collision with root package name */
    public int f51805c;

    /* renamed from: d  reason: collision with root package name */
    public int f51806d;

    /* renamed from: e  reason: collision with root package name */
    public int f51807e;

    public a(int i2, int i3, int i4, int i5, int i6) {
        this.f51803a = i2;
        this.f51804b = i3;
        this.f51805c = i4;
        this.f51806d = i6;
        this.f51807e = i5;
    }

    @NonNull
    public static a a() {
        return new a(24, 70, 1440, PeerConnectionClient.HD_VIDEO_HEIGHT, 30);
    }

    @NonNull
    public static a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return a();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new a(jSONObject.optInt("clean_check_hour", 24), jSONObject.optInt("hold_history_max_count", 70), jSONObject.optInt("history_force_clean_hour", 1440), jSONObject.optInt("force_clean_hour", PeerConnectionClient.HD_VIDEO_HEIGHT), jSONObject.optInt("hold_max_count", 30));
        } catch (JSONException e2) {
            if (d.a.l0.n.c.f51658a) {
                e2.printStackTrace();
            }
            return a();
        }
    }
}
