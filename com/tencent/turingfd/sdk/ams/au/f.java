package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.turingfd.sdk.ams.au.TuringDIDService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes15.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f13524a = new f();

    /* renamed from: b  reason: collision with root package name */
    public static Map<Integer, Integer> f13525b = new HashMap();
    public Map<Integer, Integer> c = new HashMap();
    public Map<Integer, Integer> d = new HashMap();
    public Map<Integer, Integer> e = new HashMap();
    public d f;

    static {
        f13525b.put(Integer.valueOf(u.t.aO), 0);
        f13525b.put(Integer.valueOf(u.g.aO), 1);
        f13525b.put(10001, 0);
        f13525b.put(Integer.valueOf(u.r.aO), 0);
        f13525b.put(Integer.valueOf(u.R.aO), 0);
    }

    public String a() {
        HashSet hashSet = new HashSet();
        for (Integer num : this.c.keySet()) {
            if (this.c.get(num).intValue() == 0) {
                hashSet.add(num);
            }
        }
        Iterator it = hashSet.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append("" + ((Integer) it.next()).intValue());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void a(int i, int i2) {
        this.d.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void a(Context context) {
        synchronized (this) {
            this.c.clear();
            for (Integer num : f13525b.keySet()) {
            }
            this.c.putAll(f13525b);
            Map<Integer, Integer> a2 = e.f13523a.a(context);
            for (Integer num2 : a2.keySet()) {
            }
            this.c.putAll(a2);
            for (Integer num3 : this.d.keySet()) {
                int intValue = num3.intValue();
                if (a(intValue)) {
                    this.c.put(Integer.valueOf(intValue), this.d.get(Integer.valueOf(intValue)));
                }
            }
            for (Integer num4 : this.e.keySet()) {
                int intValue2 = num4.intValue();
                if (a(intValue2)) {
                    this.c.put(Integer.valueOf(intValue2), this.e.get(Integer.valueOf(intValue2)));
                }
            }
            if (a(u.r.aO)) {
                this.c.put(Integer.valueOf(u.O.aO), 0);
                this.c.put(Integer.valueOf(u.R.aO), 0);
            }
            for (Integer num5 : this.c.keySet()) {
            }
        }
    }

    public boolean a(int i) {
        return (this.c.containsKey(Integer.valueOf(i)) && this.c.get(Integer.valueOf(i)).intValue() == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb A[Catch: all -> 0x00ed, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:10:0x001b, B:12:0x0051, B:15:0x0058, B:21:0x0066, B:23:0x0078, B:27:0x0086, B:32:0x00bb, B:34:0x00c1, B:59:0x0107, B:36:0x00c7, B:38:0x00cd, B:18:0x005d), top: B:65:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Context context, int i, String str, long j, String str2) {
        byte[] bArr;
        b a2;
        z zVar;
        boolean z;
        synchronized (this) {
            if (Math.abs(System.currentTimeMillis() - j) <= e.f13523a.c(context) * 1000) {
                z = false;
            } else {
                byte[] bArr2 = new byte[0];
                HashMap hashMap = new HashMap();
                ab.a(ab.a(""), af.f13469a, hashMap, "1");
                hashMap.put("101", str);
                hashMap.put("2002", e.f13523a.e(context));
                hashMap.put("207", str2);
                try {
                    SparseArray<Object> e = TuringDIDService.aa.e(aj.d(), context, hashMap, i);
                    bArr = aj.a(e) != 0 ? bArr2 : aj.b(e);
                } catch (Throwable th) {
                    bArr = bArr2;
                }
                if (bArr.length != 0) {
                    a2 = ((be) this.f).f13511a.a(context, bArr, 8119, 18119);
                    byte[] bArr3 = a2.f13507b != 0 ? new byte[0] : a2.c;
                    if (i == 1) {
                        try {
                            bArr3 = aj.b(TuringDIDService.aa.f(aj.d(), bArr3, i));
                        } catch (Throwable th2) {
                        }
                    } else if (i != 0) {
                        bArr3 = new byte[0];
                    }
                    az azVar = new az();
                    ao aoVar = new ao(bArr3);
                    azVar.c = aoVar.a(azVar.c, 0, true);
                    azVar.d = (z) aoVar.a((bf) az.f13504a, 1, false);
                    azVar.e = aoVar.a(azVar.e, 2, true);
                    if (azVar.c >= 0) {
                        if (azVar.c == 1) {
                            zVar = new z();
                        } else {
                            z zVar2 = azVar.d;
                            if (zVar2 == null) {
                                zVar = new z();
                            } else {
                                for (Integer num : zVar2.h.keySet()) {
                                }
                                zVar = zVar2;
                            }
                        }
                        if (zVar != null) {
                            Map<Integer, Integer> map = zVar.h;
                            e eVar = e.f13523a;
                            if (map == null || map.size() == 0) {
                                eVar.d(context);
                            } else {
                                eVar.a(context, zVar);
                            }
                            z = true;
                        }
                    }
                    zVar = null;
                    if (zVar != null) {
                    }
                }
                z = false;
            }
        }
        return z;
    }

    public String b(Context context) {
        return e.f13523a.b(context);
    }

    public void b(int i, int i2) {
        this.e.put(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
