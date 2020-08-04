package kotlin.collections;

import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class i extends h {
    public static final <T> List<T> asList(T[] tArr) {
        kotlin.jvm.internal.q.m(tArr, "receiver$0");
        List<T> asList = k.asList(tArr);
        kotlin.jvm.internal.q.l((Object) asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a extends d<Byte> implements RandomAccess {
        final /* synthetic */ byte[] nXY;

        a(byte[] bArr) {
            this.nXY = bArr;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return e(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // kotlin.collections.d, java.util.List
        public final int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return f(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public final int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return g(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return this.nXY.length;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.nXY.length == 0;
        }

        public boolean e(byte b) {
            return f.a(this.nXY, b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.collections.d, java.util.List
        /* renamed from: Lr */
        public Byte get(int i) {
            return Byte.valueOf(this.nXY[i]);
        }

        public int f(byte b) {
            return f.b(this.nXY, b);
        }

        public int g(byte b) {
            return f.c(this.nXY, b);
        }
    }

    public static final List<Byte> au(byte[] bArr) {
        kotlin.jvm.internal.q.m(bArr, "receiver$0");
        return new a(bArr);
    }

    public static final byte[] p(byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.q.m(bArr, "receiver$0");
        f.dR(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        kotlin.jvm.internal.q.l((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }
}
