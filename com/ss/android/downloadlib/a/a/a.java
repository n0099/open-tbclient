package com.ss.android.downloadlib.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import d.p.a.d.e$g.c;
import d.p.a.d.f.n;
import d.p.a.e.a.h.b;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class a implements Parcelable {
    public static int a(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | (-65536));
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    public static void c(Parcel parcel, Field field, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        i(parcel, a2);
    }

    public static void d(Parcel parcel, Field field, int i, Integer num, int i2, boolean z) {
        if (num == null) {
            return;
        }
        b(parcel, i, 4);
        parcel.writeInt(num.intValue());
    }

    public static void e(Parcel parcel, Field field, int i, Object obj, int i2, boolean z) {
        if (field.getType() == String.class) {
            f(parcel, field, i, (String) obj, i2, z);
        } else if (field.getType() != Integer.class && field.getType() != Integer.TYPE) {
            if (Parcelable.class.isAssignableFrom(field.getType())) {
                c(parcel, field, i, (Parcelable) obj, i2, z);
            }
        } else {
            d(parcel, field, i, (Integer) obj, i2, z);
        }
    }

    public static void f(Parcel parcel, Field field, int i, String str, int i2, boolean z) {
        int a2 = a(parcel, i);
        parcel.writeString(str);
        i(parcel, a2);
    }

    public static void g(a aVar, Parcel parcel, Class cls) {
        TypeVariable<Class<?>>[] typeParameters = aVar.getClass().getTypeParameters();
        int a2 = a(parcel, 0);
        ArrayList arrayList = new ArrayList();
        if (typeParameters.length > 0) {
            JSONObject s = n.s();
            arrayList.add(b.b(s.optString("aw"), s.optString("s")));
        }
        parcel.writeStringArray((String[]) arrayList.toArray(new String[typeParameters.length]));
        i(parcel, a2);
    }

    public static void h(a aVar, Parcel parcel, Field field, int i) throws IllegalAccessException {
        int b2 = ((c) field.getAnnotation(c.class)).b();
        boolean a2 = ((c) field.getAnnotation(c.class)).a();
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        e(parcel, field, b2, field.get(aVar), i, a2);
        field.setAccessible(isAccessible);
    }

    public static void i(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Field[] declaredFields;
        Class<?> cls = getClass();
        int a2 = a(parcel, 20293);
        g(this, parcel, cls);
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(c.class)) {
                    try {
                        h(this, parcel, field, i);
                    } catch (Throwable unused) {
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        i(parcel, a2);
    }
}
