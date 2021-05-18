package d.a.k0.e1.l.c;

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
    public static Pattern f54416a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d.a.k0.e1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1300a {

        /* renamed from: a  reason: collision with root package name */
        public String f54417a;

        /* renamed from: b  reason: collision with root package name */
        public String f54418b;

        /* renamed from: c  reason: collision with root package name */
        public String f54419c;

        /* renamed from: d  reason: collision with root package name */
        public String f54420d;

        /* renamed from: e  reason: collision with root package name */
        public String f54421e;

        /* renamed from: f  reason: collision with root package name */
        public String f54422f;

        /* renamed from: g  reason: collision with root package name */
        public int f54423g;

        /* renamed from: h  reason: collision with root package name */
        public long f54424h;

        /* renamed from: i  reason: collision with root package name */
        public String f54425i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;
    }

    public static List<C1300a> a(String str, String str2, long j, long j2) {
        return b(str, str2, null, 0L, j, j2);
    }

    public static List<C1300a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
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
                C1300a c1300a = new C1300a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = f54416a.matcher(optString2);
                    if (matcher.find()) {
                        c1300a.n = matcher.group(1);
                    }
                }
                c1300a.f54420d = optString2;
                c1300a.f54417a = optString;
                c1300a.f54418b = optString4;
                c1300a.f54419c = optString3;
                c1300a.f54421e = str2;
                c1300a.k = j2;
                c1300a.l = j3;
                c1300a.f54422f = optString5;
                if (userType > i2) {
                    c1300a.f54423g = userType;
                }
                if (userData != null) {
                    c1300a.f54424h = j;
                    c1300a.f54425i = userData.getUserId();
                    c1300a.j = userData.getUserType();
                }
                linkedList.add(c1300a);
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
