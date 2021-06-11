package d.a.c.e.b.b.a.c;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public Bundle f42120a;

    public a(Bundle bundle) {
        this.f42120a = bundle;
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Set<String> a() {
        return this.f42120a.keySet();
    }

    @Override // d.a.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.f42120a.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.f42120a.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.f42120a.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.f42120a.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.f42120a.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.f42120a.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.f42120a.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.f42120a.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.f42120a.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.f42120a.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList<String> arrayList = (ArrayList) obj;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            String str2 = arrayList.get(0);
            if (str2 instanceof String) {
                this.f42120a.putStringArrayList(str, arrayList);
            } else if (str2 instanceof Integer) {
                this.f42120a.putIntegerArrayList(str, arrayList);
            } else if (str2 instanceof Parcelable) {
                this.f42120a.putParcelableArrayList(str, arrayList);
            }
        } else if (obj instanceof SparseArray) {
            this.f42120a.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.f42120a.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.f42120a.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.f42120a.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.f42120a.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.f42120a.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.f42120a.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.f42120a.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.f42120a.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.f42120a.putStringArray(str, (String[]) obj);
            } else if (d.a.c.e.b.a.a.g(componentType, Parcelable.class)) {
                this.f42120a.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.f42120a.putCharSequence(str, (CharSequence) obj);
        } else if (obj instanceof IBinder) {
        } else {
            if (obj instanceof Parcelable) {
                this.f42120a.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.f42120a.putSerializable(str, (Serializable) obj);
            }
        }
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        Object d2 = d(str);
        if (d2 != null) {
            d.a.c.e.b.b.a.e.c cVar = new d.a.c.e.b.b.a.e.c(type);
            d.a.c.e.b.b.a.d.h a2 = d.a.c.e.b.b.a.e.g.a(d2);
            if (a2 != null) {
                return a2.a(cVar);
            }
            return null;
        }
        return null;
    }

    public Object d(String str) {
        return this.f42120a.get(str);
    }
}
