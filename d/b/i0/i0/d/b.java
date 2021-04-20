package d.b.i0.i0.d;

import android.text.TextUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f56597a;

    /* renamed from: b  reason: collision with root package name */
    public int f56598b;

    /* renamed from: c  reason: collision with root package name */
    public String f56599c;

    public boolean a() {
        return !TextUtils.isEmpty(this.f56599c);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("pic");
        this.f56597a = jSONObject.optString("url");
        jSONObject.optInt("server_time");
        this.f56598b = jSONObject.optInt(XAdRemoteAPKDownloadExtraInfo.ADID);
        this.f56599c = jSONObject.optString("big_pic");
        jSONObject.optString("small_pic");
    }
}
