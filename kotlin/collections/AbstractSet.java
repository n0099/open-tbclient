package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b'\u0018\u0000 \u000f*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u000fB\t\b\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlin/collections/AbstractSet;", ExifInterface.LONGITUDE_EAST, "Ljava/util/Set;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "Lkotlin/collections/AbstractCollection;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "<init>", "()V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E>, KMappedMarker {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0002\b\u0006\b\u0080\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0007\u001a\u00020\u00042\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\f\u001a\u00020\t2\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\bH\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/collections/AbstractSet$Companion;", "", "c", "other", "", "setEquals$kotlin_stdlib", "(Ljava/util/Set;Ljava/util/Set;)Z", "setEquals", "", "", "unorderedHashCode$kotlin_stdlib", "(Ljava/util/Collection;)I", "unorderedHashCode", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        public final boolean setEquals$kotlin_stdlib(Set<?> set, Set<?> set2) {
            if (set.size() != set2.size()) {
                return false;
            }
            return set.containsAll(set2);
        }

        public final int unorderedHashCode$kotlin_stdlib(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                Object next = it.next();
                i += next != null ? next.hashCode() : 0;
            }
            return i;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return Companion.setEquals$kotlin_stdlib(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Companion.unorderedHashCode$kotlin_stdlib(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
