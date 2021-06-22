package d.a.c.e.b.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Type[] f42252a;

    /* renamed from: b  reason: collision with root package name */
    public Type f42253b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f42254c;

    public c(Type type) {
        this.f42252a = null;
        this.f42253b = null;
        this.f42254c = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.f42252a = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            this.f42253b = rawType;
            Type[] typeArr = this.f42252a;
            if (typeArr == null || typeArr.length <= 0) {
                return;
            }
            try {
                this.f42254c = (Class) rawType;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            this.f42254c = (Class) type;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public Class<?> a() {
        return this.f42254c;
    }

    public Type[] b() {
        return this.f42252a;
    }
}
