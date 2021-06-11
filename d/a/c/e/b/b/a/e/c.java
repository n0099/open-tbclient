package d.a.c.e.b.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Type[] f42149a;

    /* renamed from: b  reason: collision with root package name */
    public Type f42150b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f42151c;

    public c(Type type) {
        this.f42149a = null;
        this.f42150b = null;
        this.f42151c = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.f42149a = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            this.f42150b = rawType;
            Type[] typeArr = this.f42149a;
            if (typeArr == null || typeArr.length <= 0) {
                return;
            }
            try {
                this.f42151c = (Class) rawType;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            this.f42151c = (Class) type;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public Class<?> a() {
        return this.f42151c;
    }

    public Type[] b() {
        return this.f42149a;
    }
}
