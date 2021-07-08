package d.a.o0.r.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes7.dex */
public class x1 implements d.a.o0.r.f0.o.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f52814a;

    /* renamed from: b  reason: collision with root package name */
    public String f52815b;

    /* renamed from: c  reason: collision with root package name */
    public String f52816c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52817d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52818e;

    /* renamed from: f  reason: collision with root package name */
    public int f52819f;

    /* renamed from: g  reason: collision with root package name */
    public e0 f52820g;

    /* renamed from: h  reason: collision with root package name */
    public int f52821h;

    /* renamed from: i  reason: collision with root package name */
    public int f52822i;
    public String j;

    public x1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52816c : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52819f : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52818e : invokeV.booleanValue;
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f52814a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f52815b = jSONObject.optString("name");
        this.f52816c = jSONObject.optString("avatar");
        this.f52819f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            e0 e0Var = new e0();
            this.f52820g = e0Var;
            e0Var.a(optJSONObject);
        }
        int optInt = jSONObject.optInt("memberNum", 0);
        this.f52822i = optInt;
        if (optInt == 0) {
            this.f52822i = jSONObject.optInt("member_num", 0);
        }
        this.f52821h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, simpleForum) == null) || simpleForum == null) {
            return;
        }
        this.f52814a = String.valueOf(simpleForum.id);
        this.f52815b = simpleForum.name;
        this.f52816c = simpleForum.avatar;
        this.f52817d = simpleForum.is_liked.intValue() == 1;
        this.f52819f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            e0 e0Var = new e0();
            this.f52820g = e0Var;
            e0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.f52822i = simpleForum.member_num.intValue();
        this.f52821h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.a.o0.r.f0.o.c.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f52815b : (String) invokeV.objValue;
    }

    @Override // d.a.o0.r.f0.o.a
    public boolean getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f52817d : invokeV.booleanValue;
    }

    @Override // d.a.o0.r.f0.o.c.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f52814a : (String) invokeV.objValue;
    }

    @Override // d.a.o0.r.f0.o.c.b
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f52818e = z;
        }
    }

    @Override // d.a.o0.r.f0.o.a
    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f52817d = z;
        }
    }
}
