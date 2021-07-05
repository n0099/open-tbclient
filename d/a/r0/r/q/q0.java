package d.a.r0.r.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes9.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f56030g = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f56031a;

    /* renamed from: b  reason: collision with root package name */
    public String f56032b;

    /* renamed from: c  reason: collision with root package name */
    public String f56033c;

    /* renamed from: d  reason: collision with root package name */
    public String f56034d;

    /* renamed from: e  reason: collision with root package name */
    public int f56035e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56036f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2131425845, "Ld/a/r0/r/q/q0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2131425845, "Ld/a/r0/r/q/q0;");
        }
    }

    public q0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56035e = 0;
        this.f56036f = false;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56033c : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56034d : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56035e : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56032b : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56031a : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56036f : invokeV.booleanValue;
    }

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f56031a = jSONObject.optString("link_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2 != null) {
                    this.f56032b = jSONObject2.optString("link_title");
                    this.f56033c = jSONObject2.optString("link_abstract");
                    this.f56034d = jSONObject2.optString("link_head_small_pic");
                    this.f56035e = jSONObject2.optInt("link_type");
                    if (d.a.c.e.p.k.isEmpty(this.f56032b) && d.a.c.e.p.k.isEmpty(this.f56033c)) {
                        this.f56036f = true;
                    }
                } else {
                    this.f56036f = true;
                }
                return;
            } catch (JSONException unused) {
                this.f56036f = true;
                return;
            }
        }
        this.f56036f = true;
    }

    public void h(LinkThreadInfo linkThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, linkThreadInfo) == null) || linkThreadInfo == null) {
            return;
        }
        this.f56031a = linkThreadInfo.link_url;
        LinkThreadContent linkThreadContent = (LinkThreadContent) ListUtils.getItem(linkThreadInfo.link_content, 0);
        if (linkThreadContent != null) {
            this.f56032b = linkThreadContent.link_title;
            this.f56033c = linkThreadContent.link_abstract;
            this.f56034d = linkThreadContent.link_head_small_pic;
            this.f56035e = linkThreadContent.link_type.intValue();
            if (d.a.c.e.p.k.isEmpty(this.f56032b) && d.a.c.e.p.k.isEmpty(this.f56033c)) {
                this.f56036f = true;
                return;
            }
            return;
        }
        this.f56036f = true;
    }
}
