package d.a.n0.o2;

import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import d.a.m0.r.q.z0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f61534a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public z0 f61535b = new z0();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f61536a;

        /* renamed from: b  reason: collision with root package name */
        public String f61537b;

        /* renamed from: c  reason: collision with root package name */
        public long f61538c;

        /* renamed from: d  reason: collision with root package name */
        public String f61539d;

        /* renamed from: e  reason: collision with root package name */
        public String f61540e;

        /* renamed from: f  reason: collision with root package name */
        public long f61541f;

        /* renamed from: g  reason: collision with root package name */
        public int f61542g;

        /* renamed from: h  reason: collision with root package name */
        public int f61543h;

        /* renamed from: i  reason: collision with root package name */
        public String f61544i;
    }

    public boolean a() {
        List<a> list = this.f61534a;
        return (list == null || list.size() == 0) ? false : true;
    }

    public boolean b() {
        z0 z0Var = this.f61535b;
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
            this.f61535b.i(jSONObject.getJSONObject("page"));
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return;
            }
            this.f61534a.clear();
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
                        aVar.f61536a = optLong;
                        aVar.f61537b = optString2;
                        aVar.f61538c = optLong2;
                        aVar.f61539d = optString3;
                        aVar.f61540e = optString4;
                        aVar.f61541f = optLong3;
                        aVar.f61542g = optInt;
                        aVar.f61543h = optInt2;
                        aVar.f61544i = optString;
                        this.f61534a.add(aVar);
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
