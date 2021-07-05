package d.f.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public final class r<K, V> extends q<K, V> implements w<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(e1<K, V> e1Var, d.f.d.a.o<? super Map.Entry<K, V>> oVar) {
        super(e1Var, oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e1Var, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((q0) objArr2[0], (d.f.d.a.o) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.f.d.c.q, d.f.d.c.q0, d.f.d.c.p0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((r<K, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.d.c.c
    /* renamed from: h */
    public Set<Map.Entry<K, V>> createEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Sets.b(b().entries(), c()) : (Set) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.f.d.c.c, d.f.d.c.q0, d.f.d.c.p0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((r<K, V>) obj, iterable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.d.c.u, d.f.d.c.w
    public e1<K, V> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (e1) this.f73786e : (e1) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.d.c.c, d.f.d.c.q0
    public Set<Map.Entry<K, V>> entries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (Set) super.entries() : (Set) invokeV.objValue;
    }

    @Override // d.f.d.c.q, d.f.d.c.q0, d.f.d.c.p0
    public Set<V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) ? (Set) super.get((r<K, V>) k) : (Set) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.d.c.q, d.f.d.c.q0, d.f.d.c.p0
    public Set<V> removeAll(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? (Set) super.removeAll(obj) : (Set) invokeL.objValue;
    }

    @Override // d.f.d.c.c, d.f.d.c.q0, d.f.d.c.p0
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, k, iterable)) == null) ? (Set) super.replaceValues((r<K, V>) k, (Iterable) iterable) : (Set) invokeLL.objValue;
    }
}
