package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.CartoonThread;
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public long f53908a;

    /* renamed from: b  reason: collision with root package name */
    public int f53909b;

    public long a() {
        return this.f53908a;
    }

    public int b() {
        return this.f53909b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53908a = jSONObject.optLong("cartoon_id");
            this.f53909b = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void d(CartoonThread cartoonThread) {
        if (cartoonThread == null) {
            return;
        }
        this.f53908a = cartoonThread.cartoon_id.longValue();
        this.f53909b = cartoonThread.chapter_id.intValue();
    }
}
