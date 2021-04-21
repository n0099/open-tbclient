package d.b.h0.a.q.g.b;

import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46207g = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f46208a;

    /* renamed from: b  reason: collision with root package name */
    public String f46209b;

    /* renamed from: c  reason: collision with root package name */
    public String f46210c;

    /* renamed from: d  reason: collision with root package name */
    public String f46211d;

    /* renamed from: e  reason: collision with root package name */
    public String f46212e;

    /* renamed from: f  reason: collision with root package name */
    public long f46213f;

    public a(String str, String str2) {
        this.f46208a = str;
        this.f46209b = str2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f46208a);
            jSONObject.put("name", this.f46209b);
            jSONObject.put("userAgent", this.f46210c);
            jSONObject.put("contentDisposition", this.f46211d);
            jSONObject.put("mimeType", this.f46212e);
            jSONObject.put(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH, this.f46213f);
        } catch (JSONException e2) {
            if (f46207g) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public a(String str, String str2, String str3) {
        this.f46208a = str;
        this.f46209b = str2;
    }
}
