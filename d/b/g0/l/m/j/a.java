package d.b.g0.l.m.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.node.Node;
import com.tencent.open.SocialOperation;
import d.b.g0.l.f;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f49036a;

    /* renamed from: b  reason: collision with root package name */
    public final int f49037b;

    /* renamed from: c  reason: collision with root package name */
    public final int f49038c;

    /* renamed from: d  reason: collision with root package name */
    public final String f49039d;

    /* renamed from: e  reason: collision with root package name */
    public final String f49040e;

    /* renamed from: f  reason: collision with root package name */
    public final String f49041f;

    /* renamed from: g  reason: collision with root package name */
    public final Set<String> f49042g;

    /* renamed from: h  reason: collision with root package name */
    public final String f49043h;

    public a(String str, int i, int i2, String str2, String str3, String str4, Set<String> set, String str5) {
        this.f49036a = str;
        this.f49038c = i2;
        this.f49037b = i;
        this.f49039d = str2;
        this.f49040e = str3;
        this.f49041f = str4;
        this.f49042g = set;
        this.f49043h = str5;
    }

    public static a a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (f.f48888a) {
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
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString6 = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString6)) {
                        hashSet.add(optString6);
                    }
                }
            }
            return new a(optString2, optInt, optInt2, optString3, optString4, optString, hashSet.size() > 0 ? hashSet : null, optString5);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
