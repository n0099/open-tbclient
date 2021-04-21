package d.b.j0.n2;

import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import d.b.i0.r.q.z0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f58948a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public z0 f58949b = new z0();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f58950a;

        /* renamed from: b  reason: collision with root package name */
        public String f58951b;

        /* renamed from: c  reason: collision with root package name */
        public long f58952c;

        /* renamed from: d  reason: collision with root package name */
        public String f58953d;

        /* renamed from: e  reason: collision with root package name */
        public String f58954e;

        /* renamed from: f  reason: collision with root package name */
        public long f58955f;

        /* renamed from: g  reason: collision with root package name */
        public int f58956g;

        /* renamed from: h  reason: collision with root package name */
        public int f58957h;
        public String i;
    }

    public boolean a() {
        List<a> list = this.f58948a;
        return (list == null || list.size() == 0) ? false : true;
    }

    public boolean b() {
        z0 z0Var = this.f58949b;
        return z0Var != null && z0Var.b() == 1;
    }

    public void c(JSONObject jSONObject) {
        JSONArray jSONArray;
        String str;
        int i;
        String str2 = "";
        if (jSONObject == null) {
            return;
        }
        try {
            this.f58949b.i(jSONObject.getJSONObject("page"));
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return;
            }
            this.f58948a.clear();
            int i2 = 0;
            while (i2 < optJSONArray.length()) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                if (jSONObject2 == null) {
                    jSONArray = optJSONArray;
                    str = str2;
                    i = i2;
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
                    i = i2;
                    if (jSONObject2.optInt("thread_type", 0) != 33) {
                        a aVar = new a();
                        aVar.f58950a = optLong;
                        aVar.f58951b = optString2;
                        aVar.f58952c = optLong2;
                        aVar.f58953d = optString3;
                        aVar.f58954e = optString4;
                        aVar.f58955f = optLong3;
                        aVar.f58956g = optInt;
                        aVar.f58957h = optInt2;
                        aVar.i = optString;
                        this.f58948a.add(aVar);
                    }
                }
                i2 = i + 1;
                optJSONArray = jSONArray;
                str2 = str;
            }
        } catch (Exception e2) {
            BdLog.d(e2.getMessage());
        }
    }
}
