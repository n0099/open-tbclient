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
/* loaded from: classes9.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f68145a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f68146b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f68147c;

    /* renamed from: d  reason: collision with root package name */
    public final int f68148d;

    /* renamed from: e  reason: collision with root package name */
    public int f68149e;

    /* renamed from: f  reason: collision with root package name */
    public int f68150f;

    /* renamed from: g  reason: collision with root package name */
    public final int f68151g;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f68152a;

        /* renamed from: b  reason: collision with root package name */
        public int f68153b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f68154c;

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
            this.f68154c = lVar;
            this.f68152a = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.f68145a.add(this.f68152a);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                l.f68146b.add(this.f68152a);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68152a : (String) invokeV.objValue;
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
        f68145a = new HashSet();
        f68146b = new HashSet();
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
        this.f68149e = -1;
        if (!list.isEmpty()) {
            this.f68148d = list.size();
            this.f68147c = new ArrayList<>(this.f68148d);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(this, str);
                if (f68145a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (f68146b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.f68147c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.f68147c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.f68147c.addAll(arrayList2);
            }
            Integer num = e.f68048i;
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            } else {
                i2 = this.f68148d >= 2 ? 1 : 2;
            }
            this.f68151g = i2;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68150f < this.f68151g : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (a()) {
                int i2 = this.f68149e + 1;
                if (i2 >= this.f68148d - 1) {
                    this.f68149e = -1;
                    this.f68150f++;
                } else {
                    this.f68149e = i2;
                }
                a aVar = this.f68147c.get(i2);
                aVar.f68153b = (this.f68150f * this.f68148d) + this.f68149e;
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
        this.f68149e = -1;
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f68147c = arrayList;
        arrayList.add(new a(this, str));
        this.f68148d = 1;
        this.f68151g = 1;
    }
}
