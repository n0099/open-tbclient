package d.a.c.e.b.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Type[] f38832a;

    /* renamed from: b  reason: collision with root package name */
    public Type f38833b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f38834c;

    public c(Type type) {
        this.f38832a = null;
        this.f38833b = null;
        this.f38834c = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.f38832a = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            this.f38833b = rawType;
            Type[] typeArr = this.f38832a;
            if (typeArr == null || typeArr.length <= 0) {
                return;
            }
            try {
                this.f38834c = (Class) rawType;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            this.f38834c = (Class) type;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public Class<?> a() {
        return this.f38834c;
    }

    public Type[] b() {
        return this.f38832a;
    }
}
