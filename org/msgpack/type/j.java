package org.msgpack.type;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends c {

    /* renamed from: a  reason: collision with root package name */
    private static j f2960a = new j(new r[0], true);
    private r[] b;

    public static MapValue b() {
        return f2960a;
    }

    @Override // org.msgpack.type.MapValue
    public r[] a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(r[] rVarArr, boolean z) {
        if (rVarArr.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        if (z) {
            this.b = rVarArr;
            return;
        }
        this.b = new r[rVarArr.length];
        System.arraycopy(rVarArr, 0, this.b, 0, rVarArr.length);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public r get(Object obj) {
        if (obj == null) {
            return null;
        }
        for (int length = this.b.length - 2; length >= 0; length -= 2) {
            if (this.b[length].equals(obj)) {
                return this.b[length + 1];
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<r, r>> entrySet() {
        return new k(this.b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<r> keySet() {
        return new m(this.b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<r> values() {
        return new n(this.b);
    }

    @Override // org.msgpack.type.r
    public void writeTo(org.msgpack.packer.a aVar) {
        aVar.d(this.b.length / 2);
        for (int i = 0; i < this.b.length; i++) {
            this.b[i].writeTo(aVar);
        }
        aVar.b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.isMapValue()) {
                MapValue asMapValue = rVar.asMapValue();
                if (asMapValue.size() != this.b.length / 2) {
                    return false;
                }
                for (int i = 0; i < this.b.length; i += 2) {
                    try {
                        if (!this.b[i + 1].equals(asMapValue.get(this.b[i]))) {
                            return false;
                        }
                    } catch (ClassCastException e) {
                        return false;
                    } catch (NullPointerException e2) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.b.length; i2 += 2) {
            i += this.b[i2].hashCode() ^ this.b[i2 + 1].hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return toString(new StringBuilder()).toString();
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        if (this.b.length == 0) {
            return sb.append("{}");
        }
        sb.append("{");
        sb.append(this.b[0]);
        sb.append(":");
        sb.append(this.b[1]);
        for (int i = 2; i < this.b.length; i += 2) {
            sb.append(",");
            this.b[i].toString(sb);
            sb.append(":");
            this.b[i + 1].toString(sb);
        }
        sb.append("}");
        return sb;
    }
}
