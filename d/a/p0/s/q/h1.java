package d.a.p0.s.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f53342a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f53343b;

    /* renamed from: c  reason: collision with root package name */
    public a1 f53344c;

    /* renamed from: d  reason: collision with root package name */
    public int f53345d;

    /* renamed from: e  reason: collision with root package name */
    public int f53346e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53347f;

    /* renamed from: g  reason: collision with root package name */
    public String f53348g;

    /* renamed from: h  reason: collision with root package name */
    public int f53349h;

    /* renamed from: i  reason: collision with root package name */
    public String f53350i;
    public int j;

    public h1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53342a = new ArrayList<>();
        this.f53343b = new ArrayList<>();
        this.f53344c = new a1();
    }

    public ArrayList<UserData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53343b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<UserData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53342a : (ArrayList) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            boolean z = true;
            if (jSONObject.optJSONObject("page") != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f53342a.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i3));
                        userData2.mAttentionType = 1;
                        this.f53343b.add(userData2);
                    }
                }
                this.f53344c.i(jSONObject.optJSONObject("page"));
                if (this.f53344c != null) {
                    this.f53345d = this.f53344c.a();
                    this.f53346e = this.f53344c.f();
                    if (this.f53344c.b() != 1) {
                        z = false;
                    }
                    this.f53347f = z;
                }
                jSONObject.optInt("tafriendnum", 0);
                jSONObject.optInt("commonfriendnum", 0);
            } else {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                if (optJSONArray3 != null) {
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        UserData userData3 = new UserData();
                        userData3.parserJson(optJSONArray3.getJSONObject(i4));
                        this.f53342a.add(userData3);
                    }
                }
                if (optJSONArray4 != null) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        UserData userData4 = new UserData();
                        userData4.parserJson(optJSONArray4.getJSONObject(i5));
                        userData4.mAttentionType = 1;
                        userData4.setHave_attention(1);
                        this.f53343b.add(userData4);
                    }
                }
                this.f53345d = jSONObject.optInt(Config.PACKAGE_NAME);
                this.f53346e = jSONObject.optInt("total_follow_num", 0);
                if (jSONObject.optInt("has_more", 0) != 1) {
                    z = false;
                }
                this.f53347f = z;
                this.j = jSONObject.optInt("follow_list_switch", 0);
            }
            this.f53350i = jSONObject.optString("tips_text");
            this.f53349h = jSONObject.optInt("type", 0);
            this.f53348g = jSONObject.optString("block_text");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
