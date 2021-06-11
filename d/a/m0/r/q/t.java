package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.CartoonThread;
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public long f53801a;

    /* renamed from: b  reason: collision with root package name */
    public int f53802b;

    public long a() {
        return this.f53801a;
    }

    public int b() {
        return this.f53802b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53801a = jSONObject.optLong("cartoon_id");
            this.f53802b = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void d(CartoonThread cartoonThread) {
        if (cartoonThread == null) {
            return;
        }
        this.f53801a = cartoonThread.cartoon_id.longValue();
        this.f53802b = cartoonThread.chapter_id.intValue();
    }
}
