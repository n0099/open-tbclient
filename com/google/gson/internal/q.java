package com.google.gson.internal;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/* loaded from: classes.dex */
public final class q extends AbstractMap {
    private static final Map.Entry[] b = new w[2];
    private static final int i = new Random().nextInt();
    private int d;
    private Set f;
    private Set g;
    private Collection h;
    private w[] c = (w[]) b;
    private int e = -1;

    /* renamed from: a  reason: collision with root package name */
    private w f1659a = new w();

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return (obj instanceof String) && a((String) obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        w a2;
        if (!(obj instanceof String) || (a2 = a((String) obj)) == null) {
            return null;
        }
        return a2.b;
    }

    private w a(String str) {
        if (str == null) {
            return null;
        }
        int b2 = b(str);
        w[] wVarArr = this.c;
        for (w wVar = wVarArr[(wVarArr.length - 1) & b2]; wVar != null; wVar = wVar.d) {
            String str2 = wVar.f1664a;
            if (str2 == str || (wVar.c == b2 && str.equals(str2))) {
                return wVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public Object put(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        int b2 = b(str);
        w[] wVarArr = this.c;
        int length = (wVarArr.length - 1) & b2;
        for (w wVar = wVarArr[length]; wVar != null; wVar = wVar.d) {
            if (wVar.c == b2 && str.equals(wVar.f1664a)) {
                Object obj2 = wVar.b;
                wVar.b = obj;
                return obj2;
            }
        }
        int i2 = this.d;
        this.d = i2 + 1;
        if (i2 > this.e) {
            length = (a().length - 1) & b2;
        }
        a(str, obj, b2, length);
        return null;
    }

    private void a(String str, Object obj, int i2, int i3) {
        w wVar = this.f1659a;
        w wVar2 = wVar.f;
        w wVar3 = new w(str, obj, i2, this.c[i3], wVar, wVar2);
        w[] wVarArr = this.c;
        wVar.f = wVar3;
        wVar2.e = wVar3;
        wVarArr[i3] = wVar3;
    }

    private w[] a(int i2) {
        w[] wVarArr = new w[i2];
        this.c = wVarArr;
        this.e = (i2 >> 1) + (i2 >> 2);
        return wVarArr;
    }

    private w[] a() {
        int i2;
        w[] wVarArr = this.c;
        int length = wVarArr.length;
        if (length == 1073741824) {
            return wVarArr;
        }
        w[] a2 = a(length * 2);
        if (this.d == 0) {
            return a2;
        }
        for (int i3 = 0; i3 < length; i3++) {
            w wVar = wVarArr[i3];
            if (wVar != null) {
                int i4 = wVar.c & length;
                a2[i3 | i4] = wVar;
                w wVar2 = null;
                w wVar3 = wVar;
                for (w wVar4 = wVar.d; wVar4 != null; wVar4 = wVar4.d) {
                    int i5 = wVar4.c & length;
                    if (i5 != i4) {
                        if (wVar2 == null) {
                            a2[i3 | i5] = wVar4;
                        } else {
                            wVar2.d = wVar4;
                        }
                        i2 = i5;
                    } else {
                        wVar3 = wVar2;
                        i2 = i4;
                    }
                    i4 = i2;
                    wVar2 = wVar3;
                    wVar3 = wVar4;
                }
                if (wVar2 != null) {
                    wVar2.d = null;
                }
            }
        }
        return a2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null || !(obj instanceof String)) {
            return null;
        }
        int b2 = b((String) obj);
        w[] wVarArr = this.c;
        int length = b2 & (wVarArr.length - 1);
        w wVar = wVarArr[length];
        w wVar2 = null;
        while (wVar != null) {
            if (wVar.c != b2 || !obj.equals(wVar.f1664a)) {
                w wVar3 = wVar;
                wVar = wVar.d;
                wVar2 = wVar3;
            } else {
                if (wVar2 == null) {
                    wVarArr[length] = wVar.d;
                } else {
                    wVar2.d = wVar.d;
                }
                this.d--;
                a(wVar);
                return wVar.b;
            }
        }
        return null;
    }

    private void a(w wVar) {
        wVar.f.e = wVar.e;
        wVar.e.f = wVar.f;
        wVar.f = null;
        wVar.e = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (this.d != 0) {
            Arrays.fill(this.c, (Object) null);
            this.d = 0;
        }
        w wVar = this.f1659a;
        w wVar2 = wVar.e;
        while (wVar2 != wVar) {
            w wVar3 = wVar2.e;
            wVar2.f = null;
            wVar2.e = null;
            wVar2 = wVar3;
        }
        wVar.f = wVar;
        wVar.e = wVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f;
        if (set != null) {
            return set;
        }
        u uVar = new u(this);
        this.f = uVar;
        return uVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.h;
        if (collection != null) {
            return collection;
        }
        y yVar = new y(this);
        this.h = yVar;
        return yVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.g;
        if (set != null) {
            return set;
        }
        s sVar = new s(this);
        this.g = sVar;
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj, Object obj2) {
        if (obj == null || !(obj instanceof String)) {
            return false;
        }
        int b2 = b((String) obj);
        w[] wVarArr = this.c;
        int length = b2 & (wVarArr.length - 1);
        w wVar = wVarArr[length];
        w wVar2 = null;
        while (wVar != null) {
            if (wVar.c != b2 || !obj.equals(wVar.f1664a)) {
                w wVar3 = wVar;
                wVar = wVar.d;
                wVar2 = wVar3;
            } else if (obj2 != null ? !obj2.equals(wVar.b) : wVar.b != null) {
                return false;
            } else {
                if (wVar2 == null) {
                    wVarArr[length] = wVar.d;
                } else {
                    wVar2.d = wVar.d;
                }
                this.d--;
                a(wVar);
                return true;
            }
        }
        return false;
    }

    private static int b(String str) {
        int i2 = i;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int charAt = i2 + str.charAt(i3);
            int i4 = (charAt + charAt) << 10;
            i2 = i4 ^ (i4 >>> 6);
        }
        int i5 = ((i2 >>> 20) ^ (i2 >>> 12)) ^ i2;
        return (i5 >>> 4) ^ ((i5 >>> 7) ^ i5);
    }
}
