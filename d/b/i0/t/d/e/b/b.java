package d.b.i0.t.d.e.b;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.heytap.mcssdk.mode.CommandMessage;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a2 f60509a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60510b;

    /* renamed from: c  reason: collision with root package name */
    public long f60511c;

    /* renamed from: d  reason: collision with root package name */
    public List<a> f60512d;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f60513a;

        /* renamed from: b  reason: collision with root package name */
        public String f60514b;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f60513a = jSONObject.optInt("tag_type");
            this.f60514b = jSONObject.optString("tag_word");
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60510b = jSONObject.optInt(TiebaStatic.Params.IS_FOLLOW) == 1;
        this.f60511c = jSONObject.optLong("last_watch_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("thread_info");
        if (optJSONObject != null) {
            a2 a2Var = new a2();
            this.f60509a = a2Var;
            a2Var.P2(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        this.f60512d = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
            if (optJSONObject2 != null) {
                a aVar = new a();
                aVar.a(optJSONObject2);
                this.f60512d.add(aVar);
            }
        }
    }
}
