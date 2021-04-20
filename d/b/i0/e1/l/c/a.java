package d.b.i0.e1.l.c;

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
    public static Pattern f55428a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d.b.i0.e1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1266a {

        /* renamed from: a  reason: collision with root package name */
        public String f55429a;

        /* renamed from: b  reason: collision with root package name */
        public String f55430b;

        /* renamed from: c  reason: collision with root package name */
        public String f55431c;

        /* renamed from: d  reason: collision with root package name */
        public String f55432d;

        /* renamed from: e  reason: collision with root package name */
        public String f55433e;

        /* renamed from: f  reason: collision with root package name */
        public String f55434f;

        /* renamed from: g  reason: collision with root package name */
        public int f55435g;

        /* renamed from: h  reason: collision with root package name */
        public long f55436h;
        public String i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;
    }

    public static List<C1266a> a(String str, String str2, long j, long j2) {
        return b(str, str2, null, 0L, j, j2);
    }

    public static List<C1266a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = -1;
        int userType = userData != null ? userData.getUserType() : -1;
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            int i2 = 0;
            while (i2 < length) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                String optString = optJSONObject.optString("title");
                String optString2 = optJSONObject.optString("url");
                String optString3 = optJSONObject.optString(UserAccountActionItem.KEY_SRC);
                String optString4 = optJSONObject.optString("text");
                optJSONObject.optLong("picId");
                String optString5 = optJSONObject.optString("msg_src");
                C1266a c1266a = new C1266a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = f55428a.matcher(optString2);
                    if (matcher.find()) {
                        c1266a.n = matcher.group(1);
                    }
                }
                c1266a.f55432d = optString2;
                c1266a.f55429a = optString;
                c1266a.f55430b = optString4;
                c1266a.f55431c = optString3;
                c1266a.f55433e = str2;
                c1266a.k = j2;
                c1266a.l = j3;
                c1266a.f55434f = optString5;
                if (userType > i) {
                    c1266a.f55435g = userType;
                }
                if (userData != null) {
                    c1266a.f55436h = j;
                    c1266a.i = userData.getUserId();
                    c1266a.j = userData.getUserType();
                }
                linkedList.add(c1266a);
                i2++;
                i = -1;
            }
            return linkedList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
