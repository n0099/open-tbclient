package d.a.j0.e1.l.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
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
    public static Pattern f53709a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d.a.j0.e1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1228a {

        /* renamed from: a  reason: collision with root package name */
        public String f53710a;

        /* renamed from: b  reason: collision with root package name */
        public String f53711b;

        /* renamed from: c  reason: collision with root package name */
        public String f53712c;

        /* renamed from: d  reason: collision with root package name */
        public String f53713d;

        /* renamed from: e  reason: collision with root package name */
        public String f53714e;

        /* renamed from: f  reason: collision with root package name */
        public String f53715f;

        /* renamed from: g  reason: collision with root package name */
        public int f53716g;

        /* renamed from: h  reason: collision with root package name */
        public long f53717h;

        /* renamed from: i  reason: collision with root package name */
        public String f53718i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;
    }

    public static List<C1228a> a(String str, String str2, long j, long j2) {
        return b(str, str2, null, 0L, j, j2);
    }

    public static List<C1228a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
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
                String optString3 = optJSONObject.optString(UserAccountActionItem.KEY_SRC);
                String optString4 = optJSONObject.optString("text");
                optJSONObject.optLong("picId");
                String optString5 = optJSONObject.optString("msg_src");
                C1228a c1228a = new C1228a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = f53709a.matcher(optString2);
                    if (matcher.find()) {
                        c1228a.n = matcher.group(1);
                    }
                }
                c1228a.f53713d = optString2;
                c1228a.f53710a = optString;
                c1228a.f53711b = optString4;
                c1228a.f53712c = optString3;
                c1228a.f53714e = str2;
                c1228a.k = j2;
                c1228a.l = j3;
                c1228a.f53715f = optString5;
                if (userType > i2) {
                    c1228a.f53716g = userType;
                }
                if (userData != null) {
                    c1228a.f53717h = j;
                    c1228a.f53718i = userData.getUserId();
                    c1228a.j = userData.getUserType();
                }
                linkedList.add(c1228a);
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
