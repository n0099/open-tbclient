package d.a.j0.t.d.e.b;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.heytap.mcssdk.mode.CommandMessage;
import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a2 f60681a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60682b;

    /* renamed from: c  reason: collision with root package name */
    public long f60683c;

    /* renamed from: d  reason: collision with root package name */
    public List<a> f60684d;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f60685a;

        /* renamed from: b  reason: collision with root package name */
        public String f60686b;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f60685a = jSONObject.optInt("tag_type");
            this.f60686b = jSONObject.optString("tag_word");
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60682b = jSONObject.optInt(TiebaStatic.Params.IS_FOLLOW) == 1;
        this.f60683c = jSONObject.optLong("last_watch_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("thread_info");
        if (optJSONObject != null) {
            a2 a2Var = new a2();
            this.f60681a = a2Var;
            a2Var.Q2(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        this.f60684d = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                a aVar = new a();
                aVar.a(optJSONObject2);
                this.f60684d.add(aVar);
            }
        }
    }
}
