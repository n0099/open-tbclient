package d.b.i0.r2.b0;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f59755c;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, List<JSONObject>> f59756a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f59757b = new ConcurrentHashMap<>();

    public static JSONObject b(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return null;
        }
        return c(threadInfo, threadInfo.fname);
    }

    public static JSONObject c(ThreadInfo threadInfo, String str) {
        Long l;
        if (threadInfo == null) {
            return null;
        }
        String str2 = "" + threadInfo.tid;
        if (StringUtils.isNull(str2) || "0".equals(str2)) {
            str2 = "" + threadInfo.id;
        }
        String str3 = threadInfo.video_info != null ? "" + threadInfo.video_info.video_duration : "0";
        StringBuilder sb = new StringBuilder();
        List<Abstract> list = threadInfo._abstract;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Abstract r6 = (Abstract) d.b.i0.i1.o.k.a.d(list, i);
                if (r6 != null && r6.type.intValue() == 0) {
                    sb.append(r6.text);
                }
            }
        }
        String sb2 = sb.toString();
        String str4 = "" + threadInfo.author_id;
        User user = threadInfo.author;
        if (user != null && (l = user.id) != null && l.longValue() != 0) {
            str4 = "" + threadInfo.author.id;
        }
        if (StringUtils.isNull(str)) {
            str = threadInfo.fname;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", threadInfo.title);
            jSONObject.put("tid", str2);
            jSONObject.put("fname", str);
            jSONObject.put("abstract", sb2);
            jSONObject.put("author_id", str4);
            jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static b f() {
        if (f59755c == null) {
            synchronized (b.class) {
                if (f59755c == null) {
                    f59755c = new b();
                }
            }
        }
        return f59755c;
    }

    public void a(String str) {
        this.f59756a.put(str, new ArrayList());
    }

    public String d(String str) {
        return g(this.f59756a.get(str));
    }

    public int e(String str) {
        Integer num = this.f59757b.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final String g(List<JSONObject> list) {
        try {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : list) {
                if (jSONObject != null) {
                    jSONArray.put(jSONObject);
                }
            }
            return d.b.b.e.p.c.j(jSONArray.toString().getBytes("UTF-8"));
        } catch (Exception unused) {
            return "";
        }
    }

    public void h(String str, List<JSONObject> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        this.f59756a.put(str, arrayList);
    }

    public void i(String str, int i) {
        this.f59757b.put(str, Integer.valueOf(i));
    }
}
