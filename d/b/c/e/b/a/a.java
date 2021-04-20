package d.b.c.e.b.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final Field a(Class<?> cls, String str) {
        Field field = null;
        while (cls != Object.class && field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
            }
            cls = cls.getSuperclass();
        }
        return field;
    }

    public static final List<Field> b(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        while (cls != Object.class) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null) {
                for (Field field : declaredFields) {
                    if (field != null && !Modifier.isTransient(field.getModifiers())) {
                        linkedList.add(field);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return linkedList;
    }

    public static final Method c(Class<?> cls, String str, Object... objArr) {
        Method[] declaredMethods;
        Method method = null;
        while (cls != Object.class && method == null) {
            for (Method method2 : cls.getDeclaredMethods()) {
                if (method2 != null && method2.getName().equals(str)) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    if (parameterTypes != null || objArr != null) {
                        if (parameterTypes != null && objArr != null && parameterTypes.length == objArr.length) {
                            boolean z = true;
                            for (int i = 0; i < parameterTypes.length; i++) {
                                if (parameterTypes[i].isPrimitive()) {
                                    if (parameterTypes[i] == Integer.TYPE) {
                                        if (objArr[i].getClass() == Integer.class) {
                                        }
                                    }
                                    if (parameterTypes[i] == Short.TYPE) {
                                        if (objArr[i].getClass() == Short.class) {
                                        }
                                    }
                                    if (parameterTypes[i] == Long.TYPE) {
                                        if (objArr[i].getClass() == Long.class) {
                                        }
                                    }
                                    if (parameterTypes[i] == Float.TYPE) {
                                        if (objArr[i].getClass() == Float.class) {
                                        }
                                    }
                                    if (parameterTypes[i] == Double.TYPE) {
                                        if (objArr[i].getClass() == Double.class) {
                                        }
                                    }
                                    if (parameterTypes[i] == Boolean.TYPE) {
                                        if (objArr[i].getClass() == Boolean.class) {
                                        }
                                    }
                                    if (parameterTypes[i] == Byte.TYPE) {
                                        if (objArr[i].getClass() == Byte.class) {
                                        }
                                    }
                                    if (parameterTypes[i] == Character.TYPE && objArr[i].getClass() == Character.class) {
                                    }
                                    z = false;
                                } else {
                                    if (objArr[i].getClass() == parameterTypes[i]) {
                                    }
                                    z = false;
                                }
                            }
                            if (z) {
                            }
                        }
                    }
                    method = method2;
                    break;
                }
            }
            cls = cls.getSuperclass();
        }
        return method;
    }

    public static final Object d(Object obj, String str) {
        Field a2 = a(obj.getClass(), str);
        if (a2 != null) {
            try {
                a2.setAccessible(true);
                return a2.get(obj);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static final Object e(Method method, Object obj, Class<?> cls) {
        if (method == null) {
            return null;
        }
        try {
            method.setAccessible(true);
            return method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static final Object f(Method method, Object obj, Class<?> cls, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static final boolean g(Class<?> cls, Class<?> cls2) {
        if (cls == null || cls2 == null) {
            return false;
        }
        if (cls == cls2) {
            return true;
        }
        return cls2.isAssignableFrom(cls);
    }

    public static final Object h(Class<?> cls) {
        Object newInstance;
        try {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            if (declaredConstructors.length != 1) {
                for (Constructor<?> constructor : declaredConstructors) {
                    constructor.setAccessible(true);
                    if (constructor.getParameterTypes().length == 0) {
                        constructor.setAccessible(true);
                        newInstance = constructor.newInstance(new Object[0]);
                    }
                }
                return null;
            }
            Constructor<?> constructor2 = declaredConstructors[0];
            if (constructor2.getParameterTypes().length != 0) {
                return null;
            }
            constructor2.setAccessible(true);
            newInstance = constructor2.newInstance(new Object[0]);
            return newInstance;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static final Object i(Class<?> cls, int i) {
        Object newInstance;
        try {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            if (declaredConstructors.length != 1) {
                for (Constructor<?> constructor : declaredConstructors) {
                    constructor.setAccessible(true);
                    if (constructor.getParameterTypes().length == 1) {
                        constructor.setAccessible(true);
                        newInstance = constructor.newInstance(Integer.valueOf(i));
                    }
                }
                return null;
            }
            Constructor<?> constructor2 = declaredConstructors[0];
            if (constructor2.getParameterTypes().length != 1) {
                return null;
            }
            constructor2.setAccessible(true);
            newInstance = constructor2.newInstance(Integer.valueOf(i));
            return newInstance;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static final boolean j(Object obj, String str, Object obj2) {
        Field a2 = a(obj.getClass(), str);
        if (a2 != null) {
            try {
                a2.setAccessible(true);
                a2.set(obj, obj2);
                return true;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
