package d.a.n0.j0.d;

import android.text.TextUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55832a;

    /* renamed from: b  reason: collision with root package name */
    public int f55833b;

    /* renamed from: c  reason: collision with root package name */
    public String f55834c;

    public boolean a() {
        return !TextUtils.isEmpty(this.f55834c);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("pic");
        this.f55832a = jSONObject.optString("url");
        jSONObject.optInt("server_time");
        this.f55833b = jSONObject.optInt(XAdRemoteAPKDownloadExtraInfo.ADID);
        this.f55834c = jSONObject.optString("big_pic");
        jSONObject.optString("small_pic");
    }
}
