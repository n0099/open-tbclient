package d.a.o0.o2;

import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import d.a.n0.r.q.z0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f61659a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public z0 f61660b = new z0();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f61661a;

        /* renamed from: b  reason: collision with root package name */
        public String f61662b;

        /* renamed from: c  reason: collision with root package name */
        public long f61663c;

        /* renamed from: d  reason: collision with root package name */
        public String f61664d;

        /* renamed from: e  reason: collision with root package name */
        public String f61665e;

        /* renamed from: f  reason: collision with root package name */
        public long f61666f;

        /* renamed from: g  reason: collision with root package name */
        public int f61667g;

        /* renamed from: h  reason: collision with root package name */
        public int f61668h;

        /* renamed from: i  reason: collision with root package name */
        public String f61669i;
    }

    public boolean a() {
        List<a> list = this.f61659a;
        return (list == null || list.size() == 0) ? false : true;
    }

    public boolean b() {
        z0 z0Var = this.f61660b;
        return z0Var != null && z0Var.b() == 1;
    }

    public void c(JSONObject jSONObject) {
        JSONArray jSONArray;
        String str;
        int i2;
        String str2 = "";
        if (jSONObject == null) {
            return;
        }
        try {
            this.f61660b.i(jSONObject.getJSONObject("page"));
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return;
            }
            this.f61659a.clear();
            int i3 = 0;
            while (i3 < optJSONArray.length()) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                if (jSONObject2 == null) {
                    jSONArray = optJSONArray;
                    str = str2;
                    i2 = i3;
                } else {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
                    String optString = jSONObject3.optString("name_show", str2);
                    jSONObject3.optString("name", str2);
                    long optLong = jSONObject2.optLong("pid", 0L);
                    String optString2 = jSONObject2.optString("title", str2);
                    long optLong2 = jSONObject2.optLong("time", 0L) * 1000;
                    String optString3 = jSONObject2.optString("content", str2);
                    String optString4 = jSONObject2.optString("fname", str2);
                    long optLong3 = jSONObject2.optLong("tid", 0L);
                    jSONArray = optJSONArray;
                    int optInt = jSONObject2.optInt("is_floor", 0);
                    str = str2;
                    int optInt2 = jSONObject2.optInt("is_replay", 0);
                    i2 = i3;
                    if (jSONObject2.optInt("thread_type", 0) != 33) {
                        a aVar = new a();
                        aVar.f61661a = optLong;
                        aVar.f61662b = optString2;
                        aVar.f61663c = optLong2;
                        aVar.f61664d = optString3;
                        aVar.f61665e = optString4;
                        aVar.f61666f = optLong3;
                        aVar.f61667g = optInt;
                        aVar.f61668h = optInt2;
                        aVar.f61669i = optString;
                        this.f61659a.add(aVar);
                    }
                }
                i3 = i2 + 1;
                optJSONArray = jSONArray;
                str2 = str;
            }
        } catch (Exception e2) {
            BdLog.d(e2.getMessage());
        }
    }
}
