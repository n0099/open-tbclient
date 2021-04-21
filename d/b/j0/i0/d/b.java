package d.b.j0.i0.d;

import android.text.TextUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f57018a;

    /* renamed from: b  reason: collision with root package name */
    public int f57019b;

    /* renamed from: c  reason: collision with root package name */
    public String f57020c;

    public boolean a() {
        return !TextUtils.isEmpty(this.f57020c);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("pic");
        this.f57018a = jSONObject.optString("url");
        jSONObject.optInt("server_time");
        this.f57019b = jSONObject.optInt(XAdRemoteAPKDownloadExtraInfo.ADID);
        this.f57020c = jSONObject.optString("big_pic");
        jSONObject.optString("small_pic");
    }
}
