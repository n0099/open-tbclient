package d.a.n0.j0.d;

import android.text.TextUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f59521a;

    /* renamed from: b  reason: collision with root package name */
    public int f59522b;

    /* renamed from: c  reason: collision with root package name */
    public String f59523c;

    public boolean a() {
        return !TextUtils.isEmpty(this.f59523c);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("pic");
        this.f59521a = jSONObject.optString("url");
        jSONObject.optInt("server_time");
        this.f59522b = jSONObject.optInt(XAdRemoteAPKDownloadExtraInfo.ADID);
        this.f59523c = jSONObject.optString("big_pic");
        jSONObject.optString("small_pic");
    }
}
