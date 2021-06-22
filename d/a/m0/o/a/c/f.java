package d.a.m0.o.a.c;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Map;
/* loaded from: classes3.dex */
public class f<K, V> {

    /* renamed from: h  reason: collision with root package name */
    public static Object[] f52084h;

    /* renamed from: i  reason: collision with root package name */
    public static int f52085i;
    public static Object[] j;
    public static int k;

    /* renamed from: e  reason: collision with root package name */
    public int[] f52086e = b.f52065a;

    /* renamed from: f  reason: collision with root package name */
    public Object[] f52087f = b.f52066b;

    /* renamed from: g  reason: collision with root package name */
    public int f52088g = 0;

    public static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (k < 10) {
                    objArr[0] = j;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    j = objArr;
                    k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (f52085i < 10) {
                    objArr[0] = f52084h;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f52084h = objArr;
                    f52085i++;
                }
            }
        }
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (a.class) {
                if (j != null) {
                    Object[] objArr = j;
                    this.f52087f = objArr;
                    j = (Object[]) objArr[0];
                    this.f52086e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (a.class) {
                if (f52084h != null) {
                    Object[] objArr2 = f52084h;
                    this.f52087f = objArr2;
                    f52084h = (Object[]) objArr2[0];
                    this.f52086e = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f52085i--;
                    return;
                }
            }
        }
        this.f52086e = new int[i2];
        this.f52087f = new Object[i2 << 1];
    }

    public void b(int i2) {
        int[] iArr = this.f52086e;
        if (iArr.length < i2) {
            Object[] objArr = this.f52087f;
            a(i2);
            int i3 = this.f52088g;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f52086e, 0, i3);
                System.arraycopy(objArr, 0, this.f52087f, 0, this.f52088g << 1);
            }
            c(iArr, objArr, this.f52088g);
        }
    }

    public void clear() {
        int i2 = this.f52088g;
        if (i2 != 0) {
            c(this.f52086e, this.f52087f, i2);
            this.f52086e = b.f52065a;
            this.f52087f = b.f52066b;
            this.f52088g = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public int d(Object obj, int i2) {
        int i3 = this.f52088g;
        if (i3 == 0) {
            return -1;
        }
        int a2 = b.a(this.f52086e, i3, i2);
        if (a2 >= 0 && !obj.equals(this.f52087f[a2 << 1])) {
            int i4 = a2 + 1;
            while (i4 < i3 && this.f52086e[i4] == i2) {
                if (obj.equals(this.f52087f[i4 << 1])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = a2 - 1; i5 >= 0 && this.f52086e[i5] == i2; i5--) {
                if (obj.equals(this.f52087f[i5 << 1])) {
                    return i5;
                }
            }
            return ~i4;
        }
        return a2;
    }

    public int e(Object obj) {
        return obj == null ? f() : d(obj, obj.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f52088g; i2++) {
                try {
                    K h2 = h(i2);
                    V k2 = k(i2);
                    Object obj2 = map.get(h2);
                    if (k2 == null) {
                        if (obj2 != null || !map.containsKey(h2)) {
                            return false;
                        }
                    } else if (!k2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        int i2 = this.f52088g;
        if (i2 == 0) {
            return -1;
        }
        int a2 = b.a(this.f52086e, i2, 0);
        if (a2 >= 0 && this.f52087f[a2 << 1] != null) {
            int i3 = a2 + 1;
            while (i3 < i2 && this.f52086e[i3] == 0) {
                if (this.f52087f[i3 << 1] == null) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a2 - 1; i4 >= 0 && this.f52086e[i4] == 0; i4--) {
                if (this.f52087f[i4 << 1] == null) {
                    return i4;
                }
            }
            return ~i3;
        }
        return a2;
    }

    public int g(Object obj) {
        int i2 = this.f52088g * 2;
        Object[] objArr = this.f52087f;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public V get(Object obj) {
        int e2 = e(obj);
        if (e2 >= 0) {
            return (V) this.f52087f[(e2 << 1) + 1];
        }
        return null;
    }

    public K h(int i2) {
        return (K) this.f52087f[i2 << 1];
    }

    public int hashCode() {
        int[] iArr = this.f52086e;
        Object[] objArr = this.f52087f;
        int i2 = this.f52088g;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public V i(int i2) {
        Object[] objArr = this.f52087f;
        int i3 = i2 << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.f52088g;
        if (i4 <= 1) {
            c(this.f52086e, objArr, i4);
            this.f52086e = b.f52065a;
            this.f52087f = b.f52066b;
            this.f52088g = 0;
        } else {
            int[] iArr = this.f52086e;
            if (iArr.length > 8 && i4 < iArr.length / 3) {
                int i5 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr2 = this.f52086e;
                Object[] objArr2 = this.f52087f;
                a(i5);
                this.f52088g--;
                if (i2 > 0) {
                    System.arraycopy(iArr2, 0, this.f52086e, 0, i2);
                    System.arraycopy(objArr2, 0, this.f52087f, 0, i3);
                }
                int i6 = this.f52088g;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr2, i7, this.f52086e, i2, i6 - i2);
                    System.arraycopy(objArr2, i7 << 1, this.f52087f, i3, (this.f52088g - i2) << 1);
                }
            } else {
                int i8 = this.f52088g - 1;
                this.f52088g = i8;
                if (i2 < i8) {
                    int[] iArr3 = this.f52086e;
                    int i9 = i2 + 1;
                    System.arraycopy(iArr3, i9, iArr3, i2, i8 - i2);
                    Object[] objArr3 = this.f52087f;
                    System.arraycopy(objArr3, i9 << 1, objArr3, i3, (this.f52088g - i2) << 1);
                }
                Object[] objArr4 = this.f52087f;
                int i10 = this.f52088g;
                objArr4[i10 << 1] = null;
                objArr4[(i10 << 1) + 1] = null;
            }
        }
        return v;
    }

    public boolean isEmpty() {
        return this.f52088g <= 0;
    }

    public V j(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.f52087f;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    public V k(int i2) {
        return (V) this.f52087f[(i2 << 1) + 1];
    }

    public V put(K k2, V v) {
        int i2;
        int d2;
        if (k2 == null) {
            d2 = f();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            d2 = d(k2, hashCode);
        }
        if (d2 >= 0) {
            int i3 = (d2 << 1) + 1;
            Object[] objArr = this.f52087f;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~d2;
        int i5 = this.f52088g;
        if (i5 >= this.f52086e.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f52086e;
            Object[] objArr2 = this.f52087f;
            a(i6);
            int[] iArr2 = this.f52086e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f52087f, 0, objArr2.length);
            }
            c(iArr, objArr2, this.f52088g);
        }
        int i7 = this.f52088g;
        if (i4 < i7) {
            int[] iArr3 = this.f52086e;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr3 = this.f52087f;
            System.arraycopy(objArr3, i4 << 1, objArr3, i8 << 1, (this.f52088g - i4) << 1);
        }
        this.f52086e[i4] = i2;
        Object[] objArr4 = this.f52087f;
        int i9 = i4 << 1;
        objArr4[i9] = k2;
        objArr4[i9 + 1] = v;
        this.f52088g++;
        return null;
    }

    public V remove(Object obj) {
        int e2 = e(obj);
        if (e2 >= 0) {
            return i(e2);
        }
        return null;
    }

    public int size() {
        return this.f52088g;
    }

    public String toString() {
        if (isEmpty()) {
            return StringUtil.EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder(this.f52088g * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f52088g; i2++) {
            if (i2 > 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            K h2 = h(i2);
            if (h2 != this) {
                sb.append(h2);
            } else {
                sb.append("(this Map)");
            }
            sb.append(com.alipay.sdk.encrypt.a.f1886h);
            V k2 = k(i2);
            if (k2 != this) {
                sb.append(k2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
