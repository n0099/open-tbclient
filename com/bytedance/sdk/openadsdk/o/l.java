package com.bytedance.sdk.openadsdk.o;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f31697a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f31698b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f31699c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31700d;

    /* renamed from: e  reason: collision with root package name */
    public int f31701e;

    /* renamed from: f  reason: collision with root package name */
    public int f31702f;

    /* renamed from: g  reason: collision with root package name */
    public final int f31703g;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f31704a;

        /* renamed from: b  reason: collision with root package name */
        public int f31705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f31706c;

        public a(l lVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31706c = lVar;
            this.f31704a = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.f31697a.add(this.f31704a);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                l.f31698b.add(this.f31704a);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31704a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98050052, "Lcom/bytedance/sdk/openadsdk/o/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98050052, "Lcom/bytedance/sdk/openadsdk/o/l;");
                return;
            }
        }
        f31697a = new HashSet();
        f31698b = new HashSet();
    }

    public l(@NonNull List<String> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f31701e = -1;
        if (!list.isEmpty()) {
            this.f31700d = list.size();
            this.f31699c = new ArrayList<>(this.f31700d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(this, str);
                if (f31697a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f31698b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f31699c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f31699c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f31699c.addAll(arrayList2);
            }
            Integer num = e.f31603i;
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            } else {
                i2 = this.f31700d >= 2 ? 1 : 2;
            }
            this.f31703g = i2;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31702f < this.f31703g : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (a()) {
                int i2 = this.f31701e + 1;
                if (i2 >= this.f31700d - 1) {
                    this.f31701e = -1;
                    this.f31702f++;
                } else {
                    this.f31701e = i2;
                }
                a aVar = this.f31699c.get(i2);
                aVar.f31705b = (this.f31702f * this.f31700d) + this.f31701e;
                return aVar;
            }
            throw new NoSuchElementException();
        }
        return (a) invokeV.objValue;
    }

    public l(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31701e = -1;
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f31699c = arrayList;
        arrayList.add(new a(this, str));
        this.f31700d = 1;
        this.f31703g = 1;
    }
}
