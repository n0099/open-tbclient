package d.a.o0.v.d.e.b;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.heytap.mcssdk.mode.CommandMessage;
import d.a.n0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a2 f65532a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65533b;

    /* renamed from: c  reason: collision with root package name */
    public long f65534c;

    /* renamed from: d  reason: collision with root package name */
    public List<a> f65535d;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f65536a;

        /* renamed from: b  reason: collision with root package name */
        public String f65537b;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f65536a = jSONObject.optInt("tag_type");
            this.f65537b = jSONObject.optString("tag_word");
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65533b = jSONObject.optInt(TiebaStatic.Params.IS_FOLLOW) == 1;
        this.f65534c = jSONObject.optLong("last_watch_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("thread_info");
        if (optJSONObject != null) {
            a2 a2Var = new a2();
            this.f65532a = a2Var;
            a2Var.U2(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        this.f65535d = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                a aVar = new a();
                aVar.a(optJSONObject2);
                this.f65535d.add(aVar);
            }
        }
    }
}
