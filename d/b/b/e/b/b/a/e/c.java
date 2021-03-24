package d.b.b.e.b.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Type[] f41656a;

    /* renamed from: b  reason: collision with root package name */
    public Type f41657b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f41658c;

    public c(Type type) {
        this.f41656a = null;
        this.f41657b = null;
        this.f41658c = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.f41656a = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            this.f41657b = rawType;
            Type[] typeArr = this.f41656a;
            if (typeArr == null || typeArr.length <= 0) {
                return;
            }
            try {
                this.f41658c = (Class) rawType;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            this.f41658c = (Class) type;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public Class<?> a() {
        return this.f41658c;
    }

    public Type[] b() {
        return this.f41656a;
    }
}
