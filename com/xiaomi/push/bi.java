package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class bi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f42884a;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final bi f42885a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with other field name */
        public int f153a;

        /* renamed from: a  reason: collision with other field name */
        public Object f154a;

        /* renamed from: a  reason: collision with other field name */
        public String f155a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1654660668, "Lcom/xiaomi/push/bi$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1654660668, "Lcom/xiaomi/push/bi$a;");
                    return;
                }
            }
            f42885a = new bi();
        }

        public a(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f153a = i2;
            this.f154a = obj;
        }
    }

    public bi() {
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
        this.f42884a = new LinkedList<>();
    }

    public static bi a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f42885a : (bi) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m177a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f42884a.size() <= 100) {
            return;
        }
        this.f42884a.removeFirst();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m178a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.f42884a.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m179a() {
        InterceptResult invokeV;
        LinkedList<a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                linkedList = this.f42884a;
                this.f42884a = new LinkedList<>();
            }
            return linkedList;
        }
        return (LinkedList) invokeV.objValue;
    }

    public synchronized void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            synchronized (this) {
                this.f42884a.add(new a(0, obj));
                m177a();
            }
        }
    }
}
