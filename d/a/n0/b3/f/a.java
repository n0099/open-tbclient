package d.a.n0.b3.f;

import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public String f52111a;

    /* renamed from: b  reason: collision with root package name */
    public int f52112b;

    public int a() {
        return this.f52112b;
    }

    public String b() {
        return this.f52111a;
    }

    public boolean c() {
        return this.f52111a != null;
    }

    public abstract void d(JSONObject jSONObject) throws Exception;

    public void e(String str) {
        try {
            f(new JSONObject(str));
        } catch (Exception e2) {
            g("网络不给力呀");
            e2.printStackTrace();
        }
    }

    public void f(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("error_code", 0);
            this.f52112b = optInt;
            if (optInt != 0) {
                g(jSONObject.optString("error_msg", "网络不给力呀"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                int optInt2 = optJSONObject.optInt("errno", 0);
                this.f52112b = optInt2;
                if (optInt2 != 0) {
                    g(optJSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG, "网络不给力呀"));
                    return;
                }
            }
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                new Date(optLong * 1000);
            }
            d(jSONObject);
        } catch (Exception e2) {
            g("网络不给力呀");
            e2.printStackTrace();
        }
    }

    public void g(String str) {
        this.f52111a = str;
    }
}
