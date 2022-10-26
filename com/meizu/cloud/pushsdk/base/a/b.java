package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes8.dex */
public class b {
    public String a = "ReflectConstructor";
    public a b;
    public Class[] c;

    public b(a aVar, Class... clsArr) {
        this.b = aVar;
        this.c = clsArr;
    }

    public d a(Object... objArr) {
        d dVar = new d();
        try {
            Constructor declaredConstructor = this.b.a().getDeclaredConstructor(this.c);
            declaredConstructor.setAccessible(true);
            dVar.b = declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e) {
            h.b().a(this.a, "newInstance", e);
        }
        return dVar;
    }
}
