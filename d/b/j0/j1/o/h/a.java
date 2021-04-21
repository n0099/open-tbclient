package d.b.j0.j1.o.h;

import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f57788a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f57789b;

    /* renamed from: c  reason: collision with root package name */
    public String f57790c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f57791d;

    public a() {
        this.f57788a = "";
        this.f57789b = new Rect(0, 0, 0, 0);
        this.f57790c = "";
        this.f57791d = new Rect(0, 0, 0, 0);
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new a();
        }
        try {
            return new a(new JSONObject(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return new a();
        }
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.f57790c) || this.f57791d.isEmpty()) ? false : true;
    }

    public boolean c() {
        return (TextUtils.isEmpty(this.f57788a) || this.f57789b.isEmpty()) ? false : true;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
            if (optJSONArray == null) {
                return;
            }
            try {
                JSONObject jSONObject = (JSONObject) optJSONArray.get(1);
                if (jSONObject == null) {
                    return;
                }
                this.f57790c = jSONObject.optString("pic_url");
                this.f57791d = new Rect(0, 0, jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH), jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String toString() {
        if (c()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pic_url", this.f57788a);
                jSONObject.put("rect_left", this.f57789b.left);
                jSONObject.put("rect_top", this.f57789b.top);
                jSONObject.put("rect_right", this.f57789b.right);
                jSONObject.put("rect_bottom", this.f57789b.bottom);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return "";
    }

    public a(JSONObject jSONObject) {
        this.f57788a = jSONObject.optString("pic_url");
        this.f57789b = new Rect(jSONObject.optInt("rect_left"), jSONObject.optInt("rect_top"), jSONObject.optInt("rect_right"), jSONObject.optInt("rect_bottom"));
    }
}
