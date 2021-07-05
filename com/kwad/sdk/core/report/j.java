package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.d;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class j<T extends d> implements i<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, T> f36541a;

    public j() {
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
        this.f36541a = new LinkedHashMap();
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized long a() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                int size = this.f36541a.size();
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
                this.f36541a.put(t.f36535a, t);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.core.report.j<T extends com.kwad.sdk.core.report.d> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.report.i
    public /* bridge */ /* synthetic */ void a(@NonNull Object obj) {
        a((j<T>) ((d) obj));
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized void a(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            synchronized (this) {
                for (T t : list) {
                    this.f36541a.remove(t.f36535a);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized List<T> b() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.f36541a.size());
                for (Map.Entry<String, T> entry : this.f36541a.entrySet()) {
                    arrayList.add(entry.getValue());
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
