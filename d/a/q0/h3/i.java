package d.a.q0.h3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f58593a;

    /* renamed from: b  reason: collision with root package name */
    public String f58594b;

    /* renamed from: c  reason: collision with root package name */
    public String f58595c;

    /* renamed from: d  reason: collision with root package name */
    public int f58596d;

    /* renamed from: e  reason: collision with root package name */
    public String f58597e;

    /* renamed from: f  reason: collision with root package name */
    public String f58598f;

    /* renamed from: g  reason: collision with root package name */
    public String f58599g;

    /* renamed from: h  reason: collision with root package name */
    public int f58600h;

    /* renamed from: i  reason: collision with root package name */
    public long f58601i;
    public List<j> j;
    public int k;
    public List<String> l;

    public i() {
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

    public List<j> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (List) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58601i : invokeV.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58594b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58595c : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58600h : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58599g : (String) invokeV.objValue;
    }

    public List<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (List) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58597e : (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.intValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f58593a : (String) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f58596d : invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f58598f : (String) invokeV.objValue;
    }

    public void m(BusinessPromot businessPromot) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, businessPromot) == null) || businessPromot == null) {
            return;
        }
        this.f58593a = businessPromot.title;
        this.f58594b = businessPromot.img;
        this.f58595c = businessPromot.img_popup;
        this.f58596d = businessPromot.type.intValue();
        this.f58597e = businessPromot.thread_id;
        this.f58598f = businessPromot.url;
        this.f58599g = businessPromot.schema;
        this.f58600h = businessPromot.join_num.intValue();
        this.f58601i = businessPromot.id.longValue();
        if (businessPromot.comment_list != null) {
            this.j = new LinkedList();
            for (int i2 = 0; i2 < businessPromot.comment_list.size(); i2++) {
                if (businessPromot.comment_list.get(i2) != null) {
                    j jVar = new j();
                    jVar.c(businessPromot.comment_list.get(i2));
                    this.j.add(jVar);
                }
            }
        }
        this.k = businessPromot.thread_type.intValue();
        this.l = businessPromot.third_statistics_url;
    }
}
