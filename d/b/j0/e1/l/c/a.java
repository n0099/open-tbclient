package d.b.j0.e1.l.c;

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
    public static Pattern f55849a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d.b.j0.e1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1289a {

        /* renamed from: a  reason: collision with root package name */
        public String f55850a;

        /* renamed from: b  reason: collision with root package name */
        public String f55851b;

        /* renamed from: c  reason: collision with root package name */
        public String f55852c;

        /* renamed from: d  reason: collision with root package name */
        public String f55853d;

        /* renamed from: e  reason: collision with root package name */
        public String f55854e;

        /* renamed from: f  reason: collision with root package name */
        public String f55855f;

        /* renamed from: g  reason: collision with root package name */
        public int f55856g;

        /* renamed from: h  reason: collision with root package name */
        public long f55857h;
        public String i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;
    }

    public static List<C1289a> a(String str, String str2, long j, long j2) {
        return b(str, str2, null, 0L, j, j2);
    }

    public static List<C1289a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
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
                C1289a c1289a = new C1289a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = f55849a.matcher(optString2);
                    if (matcher.find()) {
                        c1289a.n = matcher.group(1);
                    }
                }
                c1289a.f55853d = optString2;
                c1289a.f55850a = optString;
                c1289a.f55851b = optString4;
                c1289a.f55852c = optString3;
                c1289a.f55854e = str2;
                c1289a.k = j2;
                c1289a.l = j3;
                c1289a.f55855f = optString5;
                if (userType > i) {
                    c1289a.f55856g = userType;
                }
                if (userData != null) {
                    c1289a.f55857h = j;
                    c1289a.i = userData.getUserId();
                    c1289a.j = userData.getUserType();
                }
                linkedList.add(c1289a);
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
