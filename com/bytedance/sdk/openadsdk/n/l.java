package com.bytedance.sdk.openadsdk.n;

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
/* loaded from: classes5.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f31993a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f31994b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f31995c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31996d;

    /* renamed from: e  reason: collision with root package name */
    public int f31997e;

    /* renamed from: f  reason: collision with root package name */
    public int f31998f;

    /* renamed from: g  reason: collision with root package name */
    public final int f31999g;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f32000a;

        /* renamed from: b  reason: collision with root package name */
        public int f32001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f32002c;

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
            this.f32002c = lVar;
            this.f32000a = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.f31993a.add(this.f32000a);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                l.f31994b.add(this.f32000a);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32000a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98020261, "Lcom/bytedance/sdk/openadsdk/n/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98020261, "Lcom/bytedance/sdk/openadsdk/n/l;");
                return;
            }
        }
        f31993a = new HashSet();
        f31994b = new HashSet();
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
        this.f31997e = -1;
        if (!list.isEmpty()) {
            this.f31996d = list.size();
            this.f31995c = new ArrayList<>(this.f31996d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(this, str);
                if (f31993a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f31994b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f31995c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f31995c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f31995c.addAll(arrayList2);
            }
            Integer num = e.f31899i;
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            } else {
                i2 = this.f31996d >= 2 ? 1 : 2;
            }
            this.f31999g = i2;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31998f < this.f31999g : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (a()) {
                int i2 = this.f31997e + 1;
                if (i2 >= this.f31996d - 1) {
                    this.f31997e = -1;
                    this.f31998f++;
                } else {
                    this.f31997e = i2;
                }
                a aVar = this.f31995c.get(i2);
                aVar.f32001b = (this.f31998f * this.f31996d) + this.f31997e;
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
        this.f31997e = -1;
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f31995c = arrayList;
        arrayList.add(new a(this, str));
        this.f31996d = 1;
        this.f31999g = 1;
    }
}
