package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class h<K extends m, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a<K, V> f38026a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<K, a<K, V>> f38027b;

    /* loaded from: classes7.dex */
    public static class a<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final K f38028a;

        /* renamed from: b  reason: collision with root package name */
        public a<K, V> f38029b;

        /* renamed from: c  reason: collision with root package name */
        public a<K, V> f38030c;

        /* renamed from: d  reason: collision with root package name */
        public List<V> f38031d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(K k) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f38030c = this;
            this.f38029b = this;
            this.f38028a = k;
        }

        @Nullable
        public V a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int b2 = b();
                if (b2 > 0) {
                    return this.f38031d.remove(b2 - 1);
                }
                return null;
            }
            return (V) invokeV.objValue;
        }

        public void a(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                if (this.f38031d == null) {
                    this.f38031d = new ArrayList();
                }
                this.f38031d.add(v);
            }
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<V> list = this.f38031d;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }
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
                return;
            }
        }
        this.f38026a = new a<>();
        this.f38027b = new HashMap();
    }

    private void a(a<K, V> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            d(aVar);
            a<K, V> aVar2 = this.f38026a;
            aVar.f38030c = aVar2;
            aVar.f38029b = aVar2.f38029b;
            c(aVar);
        }
    }

    private void b(a<K, V> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, aVar) == null) {
            d(aVar);
            a<K, V> aVar2 = this.f38026a;
            aVar.f38030c = aVar2.f38030c;
            aVar.f38029b = aVar2;
            c(aVar);
        }
    }

    public static <K, V> void c(a<K, V> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            aVar.f38029b.f38030c = aVar;
            aVar.f38030c.f38029b = aVar;
        }
    }

    public static <K, V> void d(a<K, V> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, aVar) == null) {
            a<K, V> aVar2 = aVar.f38030c;
            aVar2.f38029b = aVar.f38029b;
            aVar.f38029b.f38030c = aVar2;
        }
    }

    @Nullable
    public V a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (V) invokeV.objValue;
        }
        a aVar = this.f38026a;
        while (true) {
            aVar = aVar.f38030c;
            if (aVar.equals(this.f38026a)) {
                return null;
            }
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            d(aVar);
            this.f38027b.remove(aVar.f38028a);
            ((m) aVar.f38028a).a();
        }
    }

    @Nullable
    public V a(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
            a<K, V> aVar = this.f38027b.get(k);
            if (aVar == null) {
                aVar = new a<>(k);
                this.f38027b.put(k, aVar);
            } else {
                k.a();
            }
            a(aVar);
            return aVar.a();
        }
        return (V) invokeL.objValue;
    }

    public void a(K k, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k, v) == null) {
            a<K, V> aVar = this.f38027b.get(k);
            if (aVar == null) {
                aVar = new a<>(k);
                b(aVar);
                this.f38027b.put(k, aVar);
            } else {
                k.a();
            }
            aVar.a(v);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
            boolean z = false;
            for (a aVar = this.f38026a.f38029b; !aVar.equals(this.f38026a); aVar = aVar.f38029b) {
                z = true;
                sb.append('{');
                sb.append(aVar.f38028a);
                sb.append(':');
                sb.append(aVar.b());
                sb.append("}, ");
            }
            if (z) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append(" )");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
