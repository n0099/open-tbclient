package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class i<T extends c> implements h<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, T> f65925a;

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
                return;
            }
        }
        this.f65925a = new LinkedHashMap();
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized long a() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                int size = this.f65925a.size();
                com.kwad.sdk.core.d.a.a("MemReportCache", "size() = " + size);
                j = size;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public synchronized void a(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            synchronized (this) {
                this.f65925a.put(t.f65918a, t);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.core.report.i<T extends com.kwad.sdk.core.report.c> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.report.h
    public /* bridge */ /* synthetic */ void a(@NonNull Object obj) {
        a((i<T>) ((c) obj));
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized void a(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            synchronized (this) {
                for (T t : list) {
                    this.f65925a.remove(t.f65918a);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized List<T> b() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.f65925a.size());
                for (Map.Entry<String, T> entry : this.f65925a.entrySet()) {
                    arrayList.add(entry.getValue());
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
