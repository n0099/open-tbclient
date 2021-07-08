package d.a.p0.k2.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class m implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f59424a;

    /* renamed from: b  reason: collision with root package name */
    public Long f59425b;

    /* renamed from: c  reason: collision with root package name */
    public String f59426c;

    /* renamed from: d  reason: collision with root package name */
    public String f59427d;

    /* renamed from: e  reason: collision with root package name */
    public String f59428e;

    /* renamed from: f  reason: collision with root package name */
    public String f59429f;

    /* renamed from: g  reason: collision with root package name */
    public String f59430g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f59431h;

    public m(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {smartApp};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59424a = 0;
        if (smartApp == null) {
            return;
        }
        this.f59425b = smartApp.swan_app_id;
        this.f59426c = smartApp.id;
        this.f59427d = smartApp.avatar;
        this.f59428e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f59429f = smartApp.h5_url;
        this.f59430g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f59424a = 1;
        }
        this.f59431h = smartApp.is_game;
    }

    public Long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59425b : (Long) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59426c : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59427d : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59429f : (String) invokeV.objValue;
    }

    public Integer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59431h : (Integer) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59430g : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59428e : (String) invokeV.objValue;
    }

    @Override // d.a.p0.k2.e.c
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59424a : invokeV.intValue;
    }
}
