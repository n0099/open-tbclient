package javassist.tools.reflect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ClassMetaobject implements Serializable {
    static final String methodPrefix = "_m_";
    static final int methodPrefixLen = 3;
    public static boolean useContextClassLoader = false;
    private Constructor[] constructors;
    private Class javaClass;
    private Method[] methods;

    public ClassMetaobject(String[] strArr) {
        try {
            this.javaClass = a(strArr[0]);
            this.constructors = this.javaClass.getConstructors();
            this.methods = null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("not found: " + strArr[0] + ", useContextClassLoader: " + Boolean.toString(useContextClassLoader), e);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeUTF(this.javaClass.getName());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.javaClass = a(objectInputStream.readUTF());
        this.constructors = this.javaClass.getConstructors();
        this.methods = null;
    }

    private Class a(String str) {
        return useContextClassLoader ? Thread.currentThread().getContextClassLoader().loadClass(str) : Class.forName(str);
    }

    public final Class getJavaClass() {
        return this.javaClass;
    }

    public final String getName() {
        return this.javaClass.getName();
    }

    public final boolean isInstance(Object obj) {
        return this.javaClass.isInstance(obj);
    }

    public final Object newInstance(Object[] objArr) {
        for (int i = 0; i < this.constructors.length; i++) {
            try {
                return this.constructors[i].newInstance(objArr);
            } catch (IllegalAccessException e) {
                throw new CannotCreateException(e);
            } catch (IllegalArgumentException e2) {
            } catch (InstantiationException e3) {
                throw new CannotCreateException(e3);
            } catch (InvocationTargetException e4) {
                throw new CannotCreateException(e4);
            }
        }
        throw new CannotCreateException("no constructor matches");
    }

    public Object trapFieldRead(String str) {
        try {
            return getJavaClass().getField(str).get(null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.toString());
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    public void trapFieldWrite(String str, Object obj) {
        try {
            getJavaClass().getField(str).set(null, obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.toString());
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    public static Object invoke(Object obj, int i, Object[] objArr) {
        Method[] methods = obj.getClass().getMethods();
        int length = methods.length;
        String str = methodPrefix + i;
        for (int i2 = 0; i2 < length; i2++) {
            if (methods[i2].getName().startsWith(str)) {
                try {
                    return methods[i2].invoke(obj, objArr);
                } catch (IllegalAccessException e) {
                    throw new CannotInvokeException(e);
                } catch (InvocationTargetException e2) {
                    throw e2.getTargetException();
                }
            }
        }
        throw new CannotInvokeException("cannot find a method");
    }

    public Object trapMethodcall(int i, Object[] objArr) {
        try {
            return getReflectiveMethods()[i].invoke(null, objArr);
        } catch (IllegalAccessException e) {
            throw new CannotInvokeException(e);
        } catch (InvocationTargetException e2) {
            throw e2.getTargetException();
        }
    }

    public final Method[] getReflectiveMethods() {
        int i;
        if (this.methods != null) {
            return this.methods;
        }
        Method[] declaredMethods = getJavaClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int[] iArr = new int[length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String name = declaredMethods[i2].getName();
            if (name.startsWith(methodPrefix)) {
                int i4 = 3;
                int i5 = 0;
                while (true) {
                    char charAt = name.charAt(i4);
                    if ('0' > charAt || charAt > '9') {
                        break;
                    }
                    i5 = ((i5 * 10) + charAt) - 48;
                    i4++;
                }
                i = i5 + 1;
                iArr[i2] = i;
                if (i > i3) {
                    i2++;
                    i3 = i;
                }
            }
            i = i3;
            i2++;
            i3 = i;
        }
        this.methods = new Method[i3];
        for (int i6 = 0; i6 < length; i6++) {
            if (iArr[i6] > 0) {
                this.methods[iArr[i6] - 1] = declaredMethods[i6];
            }
        }
        return this.methods;
    }

    public final Method getMethod(int i) {
        return getReflectiveMethods()[i];
    }

    public final String getMethodName(int i) {
        int i2;
        String name = getReflectiveMethods()[i].getName();
        int i3 = 3;
        while (true) {
            i2 = i3 + 1;
            char charAt = name.charAt(i3);
            if (charAt < '0' || '9' < charAt) {
                break;
            }
            i3 = i2;
        }
        return name.substring(i2);
    }

    public final Class[] getParameterTypes(int i) {
        return getReflectiveMethods()[i].getParameterTypes();
    }

    public final Class getReturnType(int i) {
        return getReflectiveMethods()[i].getReturnType();
    }

    public final int getMethodIndex(String str, Class[] clsArr) {
        Method[] reflectiveMethods = getReflectiveMethods();
        for (int i = 0; i < reflectiveMethods.length; i++) {
            if (reflectiveMethods[i] != null && getMethodName(i).equals(str) && Arrays.equals(clsArr, reflectiveMethods[i].getParameterTypes())) {
                return i;
            }
        }
        throw new NoSuchMethodException("Method " + str + " not found");
    }
}
