package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.internal.bc;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class bd extends bc.a {
    private final Object a;

    private bd(Object obj) {
        this.a = obj;
    }

    public static bc a(Object obj) {
        return new bd(obj);
    }

    public static Object a(bc bcVar) {
        if (bcVar instanceof bd) {
            return ((bd) bcVar).a;
        }
        IBinder asBinder = bcVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (NullPointerException e3) {
                throw new IllegalArgumentException("Binder object is null.", e3);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
