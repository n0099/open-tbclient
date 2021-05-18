package com.ss.android.downloadlib.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import d.o.a.d.e$g.c;
import d.o.a.d.f.n;
import d.o.a.e.a.h.b;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a implements Parcelable {
    public static int a(Parcel parcel, int i2) {
        parcel.writeInt(i2 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void b(Parcel parcel, int i2, int i3) {
        if (i3 >= 65535) {
            parcel.writeInt(i2 | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i3);
            return;
        }
        parcel.writeInt(i2 | (i3 << 16));
    }

    public static void c(Parcel parcel, Field field, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable == null) {
            if (z) {
                b(parcel, i2, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i2);
        parcelable.writeToParcel(parcel, i3);
        i(parcel, a2);
    }

    public static void d(Parcel parcel, Field field, int i2, Integer num, int i3, boolean z) {
        if (num == null) {
            return;
        }
        b(parcel, i2, 4);
        parcel.writeInt(num.intValue());
    }

    public static void e(Parcel parcel, Field field, int i2, Object obj, int i3, boolean z) {
        if (field.getType() == String.class) {
            f(parcel, field, i2, (String) obj, i3, z);
        } else if (field.getType() != Integer.class && field.getType() != Integer.TYPE) {
            if (Parcelable.class.isAssignableFrom(field.getType())) {
                c(parcel, field, i2, (Parcelable) obj, i3, z);
            }
        } else {
            d(parcel, field, i2, (Integer) obj, i3, z);
        }
    }

    public static void f(Parcel parcel, Field field, int i2, String str, int i3, boolean z) {
        int a2 = a(parcel, i2);
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

    public static void h(a aVar, Parcel parcel, Field field, int i2) throws IllegalAccessException {
        int b2 = ((c) field.getAnnotation(c.class)).b();
        boolean a2 = ((c) field.getAnnotation(c.class)).a();
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        e(parcel, field, b2, field.get(aVar), i2, a2);
        field.setAccessible(isAccessible);
    }

    public static void i(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Field[] declaredFields;
        Class<?> cls = getClass();
        int a2 = a(parcel, 20293);
        g(this, parcel, cls);
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(c.class)) {
                    try {
                        h(this, parcel, field, i2);
                    } catch (Throwable unused) {
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        i(parcel, a2);
    }
}
