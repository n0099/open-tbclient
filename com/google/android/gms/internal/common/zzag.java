package com.google.android.gms.internal.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
/* loaded from: classes7.dex */
public abstract class zzag<E> extends zzac<E> implements List<E>, RandomAccess {
    public static final zzak<Object> zza = new zzae(zzai.zza, 0);

    @Override // com.google.android.gms.internal.common.zzac
    @Deprecated
    public final zzag<E> zzd() {
        return this;
    }

    public static <E> zzag<E> zzl() {
        return (zzag<E>) zzai.zza;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // com.google.android.gms.internal.common.zzac, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final zzaj<E> zze() {
        return listIterator(0);
    }

    public static <E> zzag<E> zzi(Object[] objArr, int i) {
        if (i == 0) {
            return (zzag<E>) zzai.zza;
        }
        return new zzai(objArr, i);
    }

    public static <E> zzag<E> zzn(E e, E e2) {
        Object[] objArr = {e, e2};
        zzah.zza(objArr, 2);
        return zzi(objArr, 2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.common.zzac
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    /* renamed from: zzh */
    public zzag<E> subList(int i, int i2) {
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

    public static <E> zzag<E> zzj(Iterable<? extends E> iterable) {
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

    public static <E> zzag<E> zzk(Collection<? extends E> collection) {
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

    public static <E> zzag<E> zzm(E e) {
        Object[] objArr = {e};
        zzah.zza(objArr, 1);
        return zzi(objArr, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
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

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
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

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    /* renamed from: zzo */
    public final zzak<E> listIterator(int i) {
        zzs.zzb(i, size(), "index");
        if (isEmpty()) {
            return (zzak<E>) zza;
        }
        return new zzae(this, i);
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
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
}
