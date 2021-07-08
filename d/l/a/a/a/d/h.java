package d.l.a.a.a.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class h implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71073a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f71074b;

    /* renamed from: c  reason: collision with root package name */
    public String f71075c;

    /* renamed from: d  reason: collision with root package name */
    public String f71076d;

    /* renamed from: e  reason: collision with root package name */
    public String f71077e;

    /* renamed from: f  reason: collision with root package name */
    public String f71078f;

    /* renamed from: g  reason: collision with root package name */
    public String f71079g;

    /* renamed from: h  reason: collision with root package name */
    public String f71080h;

    /* renamed from: i  reason: collision with root package name */
    public Object f71081i;
    public boolean j;
    public String k;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f71082a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f71083b;

        /* renamed from: c  reason: collision with root package name */
        public String f71084c;

        /* renamed from: d  reason: collision with root package name */
        public String f71085d;

        /* renamed from: e  reason: collision with root package name */
        public String f71086e;

        /* renamed from: f  reason: collision with root package name */
        public String f71087f;

        /* renamed from: g  reason: collision with root package name */
        public String f71088g;

        /* renamed from: h  reason: collision with root package name */
        public String f71089h;

        /* renamed from: i  reason: collision with root package name */
        public String f71090i;
        public String j;
        public String k;
        public Object l;
        public boolean m;
        public boolean n;
        public boolean o;
        public String p;
        public String q;

        public b() {
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

        public h a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new h(this, null) : (h) invokeV.objValue;
        }
    }

    public /* synthetic */ h(b bVar, a aVar) {
        this(bVar);
    }

    @Override // d.l.a.a.a.d.c
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    @Override // d.l.a.a.a.d.c
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // d.l.a.a.a.d.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f71073a : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f71075c : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f71076d : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f71077e : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f71078f : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f71079g : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f71080h : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public Object j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f71081i : invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.l.a.a.a.d.c
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f71074b : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.c
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.c
    public JSONObject n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public JSONObject o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public h() {
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

    public h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71073a = bVar.f71082a;
        this.f71074b = bVar.f71083b;
        this.f71075c = bVar.f71084c;
        this.f71076d = bVar.f71085d;
        this.f71077e = bVar.f71086e;
        this.f71078f = bVar.f71087f;
        this.f71079g = bVar.f71088g;
        String unused = bVar.f71089h;
        String unused2 = bVar.f71090i;
        this.f71080h = bVar.j;
        String unused3 = bVar.k;
        this.f71081i = bVar.l;
        this.j = bVar.m;
        boolean unused4 = bVar.n;
        boolean unused5 = bVar.o;
        String unused6 = bVar.p;
        this.k = bVar.q;
    }
}
