package d.b.i0.d1.l.c;

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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f53906a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d.b.i0.d1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1203a {

        /* renamed from: a  reason: collision with root package name */
        public String f53907a;

        /* renamed from: b  reason: collision with root package name */
        public String f53908b;

        /* renamed from: c  reason: collision with root package name */
        public String f53909c;

        /* renamed from: d  reason: collision with root package name */
        public String f53910d;

        /* renamed from: e  reason: collision with root package name */
        public String f53911e;

        /* renamed from: f  reason: collision with root package name */
        public String f53912f;

        /* renamed from: g  reason: collision with root package name */
        public int f53913g;

        /* renamed from: h  reason: collision with root package name */
        public long f53914h;
        public String i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;
    }

    public static List<C1203a> a(String str, String str2, long j, long j2) {
        return b(str, str2, null, 0L, j, j2);
    }

    public static List<C1203a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
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
                C1203a c1203a = new C1203a();
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = optString2.trim();
                    Matcher matcher = f53906a.matcher(optString2);
                    if (matcher.find()) {
                        c1203a.n = matcher.group(1);
                    }
                }
                c1203a.f53910d = optString2;
                c1203a.f53907a = optString;
                c1203a.f53908b = optString4;
                c1203a.f53909c = optString3;
                c1203a.f53911e = str2;
                c1203a.k = j2;
                c1203a.l = j3;
                c1203a.f53912f = optString5;
                if (userType > i) {
                    c1203a.f53913g = userType;
                }
                if (userData != null) {
                    c1203a.f53914h = j;
                    c1203a.i = userData.getUserId();
                    c1203a.j = userData.getUserType();
                }
                linkedList.add(c1203a);
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
