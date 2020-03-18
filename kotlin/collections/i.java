package kotlin.collections;

import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class i extends h {
    public static final <T> List<T> asList(T[] tArr) {
        kotlin.jvm.internal.q.j(tArr, "receiver$0");
        List<T> asList = k.asList(tArr);
        kotlin.jvm.internal.q.i(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a extends d<Byte> implements RandomAccess {
        final /* synthetic */ byte[] nDJ;

        a(byte[] bArr) {
            this.nDJ = bArr;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return l(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // kotlin.collections.d, java.util.List
        public final int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return m(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public final int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return n(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return this.nDJ.length;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.nDJ.length == 0;
        }

        public boolean l(byte b) {
            return f.a(this.nDJ, b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.collections.d, java.util.List
        /* renamed from: NJ */
        public Byte get(int i) {
            return Byte.valueOf(this.nDJ[i]);
        }

        public int m(byte b) {
            return f.b(this.nDJ, b);
        }

        public int n(byte b) {
            return f.c(this.nDJ, b);
        }
    }

    public static final List<Byte> aG(byte[] bArr) {
        kotlin.jvm.internal.q.j(bArr, "receiver$0");
        return new a(bArr);
    }

    public static final byte[] l(byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.q.j(bArr, "receiver$0");
        f.eq(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        kotlin.jvm.internal.q.i(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }
}
