package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.CartoonThread;
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public long f51629a;

    /* renamed from: b  reason: collision with root package name */
    public int f51630b;

    public long a() {
        return this.f51629a;
    }

    public int b() {
        return this.f51630b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51629a = jSONObject.optLong("cartoon_id");
            this.f51630b = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void d(CartoonThread cartoonThread) {
        if (cartoonThread == null) {
            return;
        }
        this.f51629a = cartoonThread.cartoon_id.longValue();
        this.f51630b = cartoonThread.chapter_id.intValue();
    }
}
