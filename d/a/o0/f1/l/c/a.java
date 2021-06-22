package d.a.o0.f1.l.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f58420a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d.a.o0.f1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1378a {

        /* renamed from: a  reason: collision with root package name */
        public String f58421a;

        /* renamed from: b  reason: collision with root package name */
        public String f58422b;

        /* renamed from: c  reason: collision with root package name */
        public String f58423c;

        /* renamed from: d  reason: collision with root package name */
        public String f58424d;

        /* renamed from: e  reason: collision with root package name */
        public String f58425e;

        /* renamed from: f  reason: collision with root package name */
        public String f58426f;

        /* renamed from: g  reason: collision with root package name */
        public int f58427g;

        /* renamed from: h  reason: collision with root package name */
        public long f58428h;

        /* renamed from: i  reason: collision with root package name */
        public String f58429i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;
    }

    public static List<C1378a> a(String str, String str2, long j, long j2) {
        return b(str, str2, null, 0L, j, j2);
    }

    public static List<C1378a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = -1;
        int userType = userData != null ? userData.getUserType() : -1;
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("title");
                String optString2 = optJSONObject.optString("url");
                String optString3 = optJSONObject.optString("src");
                String optString4 = optJSONObject.optString("text");
                optJSONObject.optLong("picId");
                String optString5 = optJSONObject.optString("msg_src");
                C1378a c1378a = new C1378a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = f58420a.matcher(optString2);
                    if (matcher.find()) {
                        c1378a.n = matcher.group(1);
                    }
                }
                c1378a.f58424d = optString2;
                c1378a.f58421a = optString;
                c1378a.f58422b = optString4;
                c1378a.f58423c = optString3;
                c1378a.f58425e = str2;
                c1378a.k = j2;
                c1378a.l = j3;
                c1378a.f58426f = optString5;
                if (userType > i2) {
                    c1378a.f58427g = userType;
                }
                if (userData != null) {
                    c1378a.f58428h = j;
                    c1378a.f58429i = userData.getUserId();
                    c1378a.j = userData.getUserType();
                }
                linkedList.add(c1378a);
                i3++;
                i2 = -1;
            }
            return linkedList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
