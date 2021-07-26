package d.a.o0.n.j.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialOperation;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f51289a;

    /* renamed from: b  reason: collision with root package name */
    public final int f51290b;

    /* renamed from: c  reason: collision with root package name */
    public final int f51291c;

    /* renamed from: d  reason: collision with root package name */
    public final String f51292d;

    /* renamed from: e  reason: collision with root package name */
    public final String f51293e;

    /* renamed from: f  reason: collision with root package name */
    public final String f51294f;

    /* renamed from: g  reason: collision with root package name */
    public final Set<String> f51295g;

    /* renamed from: h  reason: collision with root package name */
    public final String f51296h;

    /* renamed from: i  reason: collision with root package name */
    public final Long f51297i;

    public a(String str, int i2, int i3, String str2, String str3, String str4, Set<String> set, String str5, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, set, str5, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51289a = str;
        this.f51291c = i3;
        this.f51290b = i2;
        this.f51292d = str2;
        this.f51293e = str3;
        this.f51294f = str4;
        this.f51295g = set;
        this.f51296h = str5;
        this.f51297i = l;
    }

    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (d.a.o0.n.c.f51112a) {
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
        return (a) invokeL.objValue;
    }
}
