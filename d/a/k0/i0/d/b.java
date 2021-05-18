package d.a.k0.i0.d;

import android.text.TextUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55648a;

    /* renamed from: b  reason: collision with root package name */
    public int f55649b;

    /* renamed from: c  reason: collision with root package name */
    public String f55650c;

    public boolean a() {
        return !TextUtils.isEmpty(this.f55650c);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("pic");
        this.f55648a = jSONObject.optString("url");
        jSONObject.optInt("server_time");
        this.f55649b = jSONObject.optInt(XAdRemoteAPKDownloadExtraInfo.ADID);
        this.f55650c = jSONObject.optString("big_pic");
        jSONObject.optString("small_pic");
    }
}
