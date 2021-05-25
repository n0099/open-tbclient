package d.a.l0.n.j.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.node.Node;
import com.tencent.open.SocialOperation;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f48161a;

    /* renamed from: b  reason: collision with root package name */
    public final int f48162b;

    /* renamed from: c  reason: collision with root package name */
    public final int f48163c;

    /* renamed from: d  reason: collision with root package name */
    public final String f48164d;

    /* renamed from: e  reason: collision with root package name */
    public final String f48165e;

    /* renamed from: f  reason: collision with root package name */
    public final String f48166f;

    /* renamed from: g  reason: collision with root package name */
    public final Set<String> f48167g;

    /* renamed from: h  reason: collision with root package name */
    public final String f48168h;

    /* renamed from: i  reason: collision with root package name */
    public final Long f48169i;

    public a(String str, int i2, int i3, String str2, String str3, String str4, Set<String> set, String str5, Long l) {
        this.f48161a = str;
        this.f48163c = i3;
        this.f48162b = i2;
        this.f48164d = str2;
        this.f48165e = str3;
        this.f48166f = str4;
        this.f48167g = set;
        this.f48168h = str5;
        this.f48169i = l;
    }

    public static a a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (d.a.l0.n.c.f47984a) {
            Log.d(Node.TAG, "host info " + jSONObject.toString());
        }
        try {
            String optString = jSONObject.optString("version");
            if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return null;
            }
            String optString2 = optJSONObject.optString("content_type");
            int optInt = optJSONObject.optInt("official_no");
            int optInt2 = optJSONObject.optInt("container_no");
            String optString3 = optJSONObject.optString("host_name");
            String optString4 = optJSONObject.optString("share_callback_url");
            JSONArray optJSONArray = optJSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
            String optString5 = optJSONObject.optString("scheme_head");
            HashSet hashSet = new HashSet();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString6 = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString6)) {
                        hashSet.add(optString6);
                    }
                }
            }
            return new a(optString2, optInt, optInt2, optString3, optString4, optString, hashSet.size() > 0 ? hashSet : null, optString5, null);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
