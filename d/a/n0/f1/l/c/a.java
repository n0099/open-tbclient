package d.a.n0.f1.l.c;

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
    public static Pattern f54606a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d.a.n0.f1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1318a {

        /* renamed from: a  reason: collision with root package name */
        public String f54607a;

        /* renamed from: b  reason: collision with root package name */
        public String f54608b;

        /* renamed from: c  reason: collision with root package name */
        public String f54609c;

        /* renamed from: d  reason: collision with root package name */
        public String f54610d;

        /* renamed from: e  reason: collision with root package name */
        public String f54611e;

        /* renamed from: f  reason: collision with root package name */
        public String f54612f;

        /* renamed from: g  reason: collision with root package name */
        public int f54613g;

        /* renamed from: h  reason: collision with root package name */
        public long f54614h;

        /* renamed from: i  reason: collision with root package name */
        public String f54615i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;
    }

    public static List<C1318a> a(String str, String str2, long j, long j2) {
        return b(str, str2, null, 0L, j, j2);
    }

    public static List<C1318a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
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
                C1318a c1318a = new C1318a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = f54606a.matcher(optString2);
                    if (matcher.find()) {
                        c1318a.n = matcher.group(1);
                    }
                }
                c1318a.f54610d = optString2;
                c1318a.f54607a = optString;
                c1318a.f54608b = optString4;
                c1318a.f54609c = optString3;
                c1318a.f54611e = str2;
                c1318a.k = j2;
                c1318a.l = j3;
                c1318a.f54612f = optString5;
                if (userType > i2) {
                    c1318a.f54613g = userType;
                }
                if (userData != null) {
                    c1318a.f54614h = j;
                    c1318a.f54615i = userData.getUserId();
                    c1318a.j = userData.getUserType();
                }
                linkedList.add(c1318a);
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
