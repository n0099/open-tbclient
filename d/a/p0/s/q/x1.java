package d.a.p0.s.q;

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
public class x1 implements d.a.p0.s.f0.o.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f53478a;

    /* renamed from: b  reason: collision with root package name */
    public String f53479b;

    /* renamed from: c  reason: collision with root package name */
    public String f53480c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53481d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53482e;

    /* renamed from: f  reason: collision with root package name */
    public int f53483f;

    /* renamed from: g  reason: collision with root package name */
    public e0 f53484g;

    /* renamed from: h  reason: collision with root package name */
    public int f53485h;

    /* renamed from: i  reason: collision with root package name */
    public int f53486i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53480c : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53483f : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f53482e : invokeV.booleanValue;
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f53478a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f53479b = jSONObject.optString("name");
        this.f53480c = jSONObject.optString("avatar");
        this.f53483f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            e0 e0Var = new e0();
            this.f53484g = e0Var;
            e0Var.a(optJSONObject);
        }
        int optInt = jSONObject.optInt("memberNum", 0);
        this.f53486i = optInt;
        if (optInt == 0) {
            this.f53486i = jSONObject.optInt("member_num", 0);
        }
        this.f53485h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, simpleForum) == null) || simpleForum == null) {
            return;
        }
        this.f53478a = String.valueOf(simpleForum.id);
        this.f53479b = simpleForum.name;
        this.f53480c = simpleForum.avatar;
        this.f53481d = simpleForum.is_liked.intValue() == 1;
        this.f53483f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            e0 e0Var = new e0();
            this.f53484g = e0Var;
            e0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.f53486i = simpleForum.member_num.intValue();
        this.f53485h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.a.p0.s.f0.o.c.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53479b : (String) invokeV.objValue;
    }

    @Override // d.a.p0.s.f0.o.a
    public boolean getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f53481d : invokeV.booleanValue;
    }

    @Override // d.a.p0.s.f0.o.c.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f53478a : (String) invokeV.objValue;
    }

    @Override // d.a.p0.s.f0.o.c.b
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f53482e = z;
        }
    }

    @Override // d.a.p0.s.f0.o.a
    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f53481d = z;
        }
    }
}
