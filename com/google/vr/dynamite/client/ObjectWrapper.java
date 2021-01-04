package com.google.vr.dynamite.client;

import android.os.IBinder;
import com.google.vr.dynamite.client.IObjectWrapper;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public final class ObjectWrapper<T> extends IObjectWrapper.a {
    private final T wrappedObject;

    private ObjectWrapper(T t) {
        this.wrappedObject = t;
    }

    public static <T> IObjectWrapper a(T t) {
        return new ObjectWrapper(t);
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper, Class<T> cls) {
        if (iObjectWrapper == null) {
            return null;
        }
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).wrappedObject;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        Field field = null;
        while (true) {
            if (i >= length) {
                break;
            }
            Field field2 = declaredFields[i];
            if (!field2.isSynthetic()) {
                if (field != null) {
                    field = null;
                    break;
                }
            } else {
                field2 = field;
            }
            try {
                i++;
                field = field2;
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (NullPointerException e3) {
                throw new IllegalArgumentException("Binder object is null.", e3);
            }
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                Object obj = field.get(asBinder);
                if (obj == null) {
                    return null;
                }
                if (!cls.isInstance(obj)) {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.");
                }
                return cls.cast(obj);
            }
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
