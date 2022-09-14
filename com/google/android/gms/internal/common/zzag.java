package com.google.android.gms.internal.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
/* loaded from: classes7.dex */
public abstract class zzag<E> extends zzac<E> implements List<E>, RandomAccess {
    public static /* synthetic */ Interceptable $ic;
    public static final zzak<Object> zza;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1709540507, "Lcom/google/android/gms/internal/common/zzag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1709540507, "Lcom/google/android/gms/internal/common/zzag;");
                return;
            }
        }
        zza = new zzae(zzai.zza, 0);
    }

    public zzag() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <E> zzag<E> zzi(Object[] objArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, objArr, i)) == null) {
            if (i == 0) {
                return (zzag<E>) zzai.zza;
            }
            return new zzai(objArr, i);
        }
        return (zzag) invokeLI.objValue;
    }

    public static <E> zzag<E> zzj(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            if (iterable != null) {
                if (iterable instanceof Collection) {
                    return zzk((Collection) iterable);
                }
                Iterator<? extends E> it = iterable.iterator();
                if (!it.hasNext()) {
                    return (zzag<E>) zzai.zza;
                }
                E next = it.next();
                if (!it.hasNext()) {
                    return zzm(next);
                }
                zzad zzadVar = new zzad(4);
                zzadVar.zzb((zzad) next);
                zzadVar.zzc(it);
                zzadVar.zzc = true;
                return zzi(zzadVar.zza, zzadVar.zzb);
            }
            throw null;
        }
        return (zzag) invokeL.objValue;
    }

    public static <E> zzag<E> zzk(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, collection)) == null) {
            if (collection instanceof zzac) {
                zzag<E> zzd = ((zzac) collection).zzd();
                if (zzd.zzf()) {
                    Object[] array = zzd.toArray();
                    return zzi(array, array.length);
                }
                return zzd;
            }
            Object[] array2 = collection.toArray();
            int length = array2.length;
            zzah.zza(array2, length);
            return zzi(array2, length);
        }
        return (zzag) invokeL.objValue;
    }

    public static <E> zzag<E> zzl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (zzag<E>) zzai.zza : (zzag) invokeV.objValue;
    }

    public static <E> zzag<E> zzm(E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, e)) == null) {
            Object[] objArr = {e};
            zzah.zza(objArr, 1);
            return zzi(objArr, 1);
        }
        return (zzag) invokeL.objValue;
    }

    public static <E> zzag<E> zzn(E e, E e2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, e, e2)) == null) {
            Object[] objArr = {e, e2};
            zzah.zza(objArr, 2);
            return zzi(objArr, 2);
        }
        return (zzag) invokeLL.objValue;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, e) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeIL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? indexOf(obj) >= 0 : invokeL.booleanValue;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    if (list instanceof RandomAccess) {
                        for (int i = 0; i < size; i++) {
                            if (zzr.zza(get(i), list.get(i))) {
                            }
                        }
                        return true;
                    }
                    Iterator<E> it = iterator();
                    Iterator<E> it2 = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it2.hasNext()) {
                                if (!zzr.zza(it.next(), it2.next())) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else if (!it2.hasNext()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int size = size();
            int i = 1;
            for (int i2 = 0; i2 < size; i2++) {
                i = (i * 31) + get(i2).hashCode();
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == null) {
                return -1;
            }
            int size = size();
            for (int i = 0; i < size; i++) {
                if (obj.equals(get(i))) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // com.google.android.gms.internal.common.zzac, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj == null) {
                return -1;
            }
            for (int size = size() - 1; size >= 0; size--) {
                if (obj.equals(get(size))) {
                    return size;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            throw new UnsupportedOperationException();
        }
        return (E) invokeI.objValue;
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, e)) == null) {
            throw new UnsupportedOperationException();
        }
        return (E) invokeIL.objValue;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public int zza(Object[] objArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, objArr, i)) == null) {
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                objArr[i2] = get(i2);
            }
            return size;
        }
        return invokeLI.intValue;
    }

    @Override // com.google.android.gms.internal.common.zzac
    @Deprecated
    public final zzag<E> zzd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this : (zzag) invokeV.objValue;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final zzaj<E> zze() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? listIterator(0) : (zzaj) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    /* renamed from: zzh */
    public zzag<E> subList(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i, i2)) == null) {
            zzs.zzc(i, i2, size());
            int i3 = i2 - i;
            if (i3 == size()) {
                return this;
            }
            if (i3 == 0) {
                return (zzag<E>) zzai.zza;
            }
            return new zzaf(this, i, i3);
        }
        return (zzag) invokeII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    /* renamed from: zzo */
    public final zzak<E> listIterator(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            zzs.zzb(i, size(), "index");
            return isEmpty() ? (zzak<E>) zza : new zzae(this, i);
        }
        return (zzak) invokeI.objValue;
    }
}
