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
/* loaded from: classes10.dex */
public class h implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f74021a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f74022b;

    /* renamed from: c  reason: collision with root package name */
    public String f74023c;

    /* renamed from: d  reason: collision with root package name */
    public String f74024d;

    /* renamed from: e  reason: collision with root package name */
    public String f74025e;

    /* renamed from: f  reason: collision with root package name */
    public String f74026f;

    /* renamed from: g  reason: collision with root package name */
    public String f74027g;

    /* renamed from: h  reason: collision with root package name */
    public String f74028h;

    /* renamed from: i  reason: collision with root package name */
    public Object f74029i;
    public boolean j;
    public String k;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f74030a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f74031b;

        /* renamed from: c  reason: collision with root package name */
        public String f74032c;

        /* renamed from: d  reason: collision with root package name */
        public String f74033d;

        /* renamed from: e  reason: collision with root package name */
        public String f74034e;

        /* renamed from: f  reason: collision with root package name */
        public String f74035f;

        /* renamed from: g  reason: collision with root package name */
        public String f74036g;

        /* renamed from: h  reason: collision with root package name */
        public String f74037h;

        /* renamed from: i  reason: collision with root package name */
        public String f74038i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f74021a : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f74023c : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74024d : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f74025e : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f74026f : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f74027g : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f74028h : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.c
    public Object j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f74029i : invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f74022b : invokeV.booleanValue;
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
        this.f74021a = bVar.f74030a;
        this.f74022b = bVar.f74031b;
        this.f74023c = bVar.f74032c;
        this.f74024d = bVar.f74033d;
        this.f74025e = bVar.f74034e;
        this.f74026f = bVar.f74035f;
        this.f74027g = bVar.f74036g;
        String unused = bVar.f74037h;
        String unused2 = bVar.f74038i;
        this.f74028h = bVar.j;
        String unused3 = bVar.k;
        this.f74029i = bVar.l;
        this.j = bVar.m;
        boolean unused4 = bVar.n;
        boolean unused5 = bVar.o;
        String unused6 = bVar.p;
        this.k = bVar.q;
    }
}
