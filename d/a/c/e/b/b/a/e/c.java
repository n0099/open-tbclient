package d.a.c.e.b.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Type[] f39587a;

    /* renamed from: b  reason: collision with root package name */
    public Type f39588b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f39589c;

    public c(Type type) {
        this.f39587a = null;
        this.f39588b = null;
        this.f39589c = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.f39587a = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            this.f39588b = rawType;
            Type[] typeArr = this.f39587a;
            if (typeArr == null || typeArr.length <= 0) {
                return;
            }
            try {
                this.f39589c = (Class) rawType;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            this.f39589c = (Class) type;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public Class<?> a() {
        return this.f39589c;
    }

    public Type[] b() {
        return this.f39587a;
    }
}
