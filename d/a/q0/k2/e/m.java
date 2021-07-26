package d.a.q0.k2.e;

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
    public int f60038a;

    /* renamed from: b  reason: collision with root package name */
    public Long f60039b;

    /* renamed from: c  reason: collision with root package name */
    public String f60040c;

    /* renamed from: d  reason: collision with root package name */
    public String f60041d;

    /* renamed from: e  reason: collision with root package name */
    public String f60042e;

    /* renamed from: f  reason: collision with root package name */
    public String f60043f;

    /* renamed from: g  reason: collision with root package name */
    public String f60044g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f60045h;

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
        this.f60038a = 0;
        if (smartApp == null) {
            return;
        }
        this.f60039b = smartApp.swan_app_id;
        this.f60040c = smartApp.id;
        this.f60041d = smartApp.avatar;
        this.f60042e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f60043f = smartApp.h5_url;
        this.f60044g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f60038a = 1;
        }
        this.f60045h = smartApp.is_game;
    }

    public Long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60039b : (Long) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60040c : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60041d : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60043f : (String) invokeV.objValue;
    }

    public Integer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60045h : (Integer) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f60044g : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60042e : (String) invokeV.objValue;
    }

    @Override // d.a.q0.k2.e.c
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60038a : invokeV.intValue;
    }
}
