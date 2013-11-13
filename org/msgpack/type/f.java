package org.msgpack.type;

import java.util.ListIterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private static f f2957a = new f(new r[0], true);
    private r[] b;

    public static ArrayValue b() {
        return f2957a;
    }

    @Override // org.msgpack.type.ArrayValue
    public r[] a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(r[] rVarArr, boolean z) {
        if (z) {
            this.b = rVarArr;
            return;
        }
        this.b = new r[rVarArr.length];
        System.arraycopy(rVarArr, 0, this.b, 0, rVarArr.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.b.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.b.length == 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public r get(int i) {
        if (i < 0 || this.b.length <= i) {
            throw new IndexOutOfBoundsException();
        }
        return this.b[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int i = 0; i < this.b.length; i++) {
            if (this.b[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int length = this.b.length - 1; length >= 0; length--) {
            if (this.b[length].equals(obj)) {
                return length;
            }
        }
        return -1;
    }

    @Override // org.msgpack.type.r
    public void writeTo(org.msgpack.packer.a aVar) {
        aVar.c(this.b.length);
        for (int i = 0; i < this.b.length; i++) {
            this.b[i].writeTo(aVar);
        }
        aVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.isArrayValue()) {
                if (rVar.getClass() == f.class) {
                    return a((f) rVar);
                }
                ListIterator<r> listIterator = rVar.asArrayValue().listIterator();
                while (0 < this.b.length) {
                    if (!listIterator.hasNext() || !this.b[0].equals(listIterator.next())) {
                        return false;
                    }
                    while (0 < this.b.length) {
                    }
                }
                return !listIterator.hasNext();
            }
            return false;
        }
        return false;
    }

    private boolean a(f fVar) {
        if (this.b.length != fVar.b.length) {
            return false;
        }
        for (int i = 0; i < this.b.length; i++) {
            if (!this.b[i].equals(fVar.b[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.b.length; i2++) {
            i = (i * 31) + this.b[i2].hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return toString(new StringBuilder()).toString();
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        if (this.b.length == 0) {
            return sb.append("[]");
        }
        sb.append("[");
        sb.append(this.b[0]);
        for (int i = 1; i < this.b.length; i++) {
            sb.append(",");
            this.b[i].toString(sb);
        }
        sb.append("]");
        return sb;
    }
}
