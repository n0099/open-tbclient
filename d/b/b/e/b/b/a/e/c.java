package d.b.b.e.b.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Type[] f41657a;

    /* renamed from: b  reason: collision with root package name */
    public Type f41658b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f41659c;

    public c(Type type) {
        this.f41657a = null;
        this.f41658b = null;
        this.f41659c = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.f41657a = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            this.f41658b = rawType;
            Type[] typeArr = this.f41657a;
            if (typeArr == null || typeArr.length <= 0) {
                return;
            }
            try {
                this.f41659c = (Class) rawType;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            this.f41659c = (Class) type;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public Class<?> a() {
        return this.f41659c;
    }

    public Type[] b() {
        return this.f41657a;
    }
}
