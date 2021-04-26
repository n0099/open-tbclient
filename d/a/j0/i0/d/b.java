package d.a.j0.i0.d;

import android.text.TextUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f54941a;

    /* renamed from: b  reason: collision with root package name */
    public int f54942b;

    /* renamed from: c  reason: collision with root package name */
    public String f54943c;

    public boolean a() {
        return !TextUtils.isEmpty(this.f54943c);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("pic");
        this.f54941a = jSONObject.optString("url");
        jSONObject.optInt("server_time");
        this.f54942b = jSONObject.optInt(XAdRemoteAPKDownloadExtraInfo.ADID);
        this.f54943c = jSONObject.optString("big_pic");
        jSONObject.optString("small_pic");
    }
}
