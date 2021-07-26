package d.a.o0.a.h0.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<C0743a> f45291a;

    /* renamed from: d.a.o0.a.h0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0743a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f45292a;

        /* renamed from: b  reason: collision with root package name */
        public String f45293b;

        /* renamed from: c  reason: collision with root package name */
        public String f45294c;

        public C0743a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45292a = str;
            this.f45293b = str2;
            this.f45294c = str3;
        }

        public static C0743a a(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) ? new C0743a(str, str2, str3) : (C0743a) invokeLLL.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "1".equals(this.f45292a) : invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "1".equals(this.f45294c) : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "JSErrorModel{mType='" + this.f45292a + "', mContent='" + this.f45293b + "', mSource='" + this.f45294c + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    public a() {
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
        this.f45291a = new ArrayList();
    }

    public synchronized boolean a(C0743a c0743a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0743a)) == null) {
            synchronized (this) {
                if (c0743a != null) {
                    return this.f45291a.add(c0743a);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                String g2 = k.g(System.currentTimeMillis(), "【HH:mm:ss】");
                if (d()) {
                    return String.format("\n%s jserror：共0个；", g2);
                }
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                for (C0743a c0743a : this.f45291a) {
                    if (c0743a.b()) {
                        i2++;
                        if (c0743a.c()) {
                            i4++;
                        } else {
                            i3++;
                        }
                    }
                }
                return String.format("\n%s jserror：共%d个，影响渲染%d个（框架%d个，开发者%d个）；", g2, Integer.valueOf(e()), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                z = false;
                Iterator<C0743a> it = this.f45291a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().b()) {
                        z = true;
                        break;
                    }
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                isEmpty = this.f45291a.isEmpty();
            }
            return isEmpty;
        }
        return invokeV.booleanValue;
    }

    public synchronized int e() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                size = this.f45291a.size();
            }
            return size;
        }
        return invokeV.intValue;
    }
}
