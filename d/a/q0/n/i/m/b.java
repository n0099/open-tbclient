package d.a.q0.n.i.m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes8.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Set<a> f54023d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<? extends a> list, @Nullable d.a.q0.n.o.a aVar) {
        super(-1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f54023d = new LinkedHashSet();
        Map<String, PMSAppInfo> t = d.a.q0.n.g.a.h().t();
        Map<String, d.a.q0.n.h.f> p = d.a.q0.n.g.a.h().p();
        for (a aVar2 : list) {
            if (aVar2 != null && !TextUtils.isEmpty(aVar2.b())) {
                g(t, p, aVar2, aVar);
                this.f54023d.add(aVar2);
            }
        }
    }

    @Nullable
    public Set<a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54023d : (Set) invokeV.objValue;
    }

    public void g(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, d.a.q0.n.h.f> map2, @NonNull a aVar, @Nullable d.a.q0.n.o.a aVar2) {
        PMSAppInfo pMSAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, map2, aVar, aVar2) == null) && map.containsKey(aVar.b()) && (pMSAppInfo = map.get(aVar.b())) != null) {
            if (aVar.c() == -1) {
                aVar.f(pMSAppInfo.appCategory);
            }
            if (!map2.containsKey(aVar.b())) {
                aVar.g(0L);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.a(aVar.b(), aVar.c())) {
                aVar.g(0L);
            } else {
                d.a.q0.n.h.f fVar = map2.get(aVar.b());
                if (fVar != null) {
                    aVar.g(fVar.f53940i);
                } else {
                    aVar.g(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.a()) {
                aVar.e(pMSAppInfo.appSign);
            } else {
                aVar.e(0L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f54024a;

        /* renamed from: b  reason: collision with root package name */
        public int f54025b;

        /* renamed from: c  reason: collision with root package name */
        public long f54026c;

        /* renamed from: d  reason: collision with root package name */
        public long f54027d;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54025b = -1;
            this.f54026c = 0L;
            this.f54027d = 0L;
            this.f54024a = str;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54027d : invokeV.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54024a : (String) invokeV.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54025b : invokeV.intValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54026c : invokeV.longValue;
        }

        public void e(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.f54027d = j;
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (super.equals(obj)) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return TextUtils.equals(aVar.b(), this.f54024a) && aVar.c() == this.f54025b;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.f54025b = i2;
            }
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                this.f54026c = j;
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Objects.hash(this.f54024a, Integer.valueOf(this.f54025b)) : invokeV.intValue;
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f54025b = -1;
            this.f54026c = 0L;
            this.f54027d = 0L;
            this.f54024a = str;
            this.f54025b = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Collection<String> collection, @Nullable d.a.q0.n.o.a aVar) {
        super(-1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.f54023d = new LinkedHashSet();
        Map<String, PMSAppInfo> t = d.a.q0.n.g.a.h().t();
        Map<String, d.a.q0.n.h.f> p = d.a.q0.n.g.a.h().p();
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                a aVar2 = new a(str);
                g(t, p, aVar2, aVar);
                this.f54023d.add(aVar2);
            }
        }
    }
}
