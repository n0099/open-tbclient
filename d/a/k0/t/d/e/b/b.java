package d.a.k0.t.d.e.b;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.heytap.mcssdk.mode.CommandMessage;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a2 f61405a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61406b;

    /* renamed from: c  reason: collision with root package name */
    public long f61407c;

    /* renamed from: d  reason: collision with root package name */
    public List<a> f61408d;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f61409a;

        /* renamed from: b  reason: collision with root package name */
        public String f61410b;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f61409a = jSONObject.optInt("tag_type");
            this.f61410b = jSONObject.optString("tag_word");
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61406b = jSONObject.optInt(TiebaStatic.Params.IS_FOLLOW) == 1;
        this.f61407c = jSONObject.optLong("last_watch_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("thread_info");
        if (optJSONObject != null) {
            a2 a2Var = new a2();
            this.f61405a = a2Var;
            a2Var.S2(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        this.f61408d = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                a aVar = new a();
                aVar.a(optJSONObject2);
                this.f61408d.add(aVar);
            }
        }
    }
}
