package d.b.c.e.b.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Type[] f42154a;

    /* renamed from: b  reason: collision with root package name */
    public Type f42155b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f42156c;

    public c(Type type) {
        this.f42154a = null;
        this.f42155b = null;
        this.f42156c = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.f42154a = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            this.f42155b = rawType;
            Type[] typeArr = this.f42154a;
            if (typeArr == null || typeArr.length <= 0) {
                return;
            }
            try {
                this.f42156c = (Class) rawType;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            this.f42156c = (Class) type;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public Class<?> a() {
        return this.f42156c;
    }

    public Type[] b() {
        return this.f42154a;
    }
}
