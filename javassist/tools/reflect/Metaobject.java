package javassist.tools.reflect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class Metaobject implements Serializable {
    protected a baseobject;
    protected ClassMetaobject classmetaobject;
    protected Method[] methods;

    public Metaobject(Object obj, Object[] objArr) {
        this.baseobject = (a) obj;
        this.classmetaobject = this.baseobject.a();
        this.methods = this.classmetaobject.getReflectiveMethods();
    }

    protected Metaobject() {
        this.baseobject = null;
        this.classmetaobject = null;
        this.methods = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.baseobject);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.baseobject = (a) objectInputStream.readObject();
        this.classmetaobject = this.baseobject.a();
        this.methods = this.classmetaobject.getReflectiveMethods();
    }

    public final ClassMetaobject getClassMetaobject() {
        return this.classmetaobject;
    }

    public final Object getObject() {
        return this.baseobject;
    }

    public final void setObject(Object obj) {
        this.baseobject = (a) obj;
        this.classmetaobject = this.baseobject.a();
        this.methods = this.classmetaobject.getReflectiveMethods();
        this.baseobject.a(this);
    }

    public final String getMethodName(int i) {
        int i2;
        String name = this.methods[i].getName();
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
        return this.methods[i].getParameterTypes();
    }

    public final Class getReturnType(int i) {
        return this.methods[i].getReturnType();
    }

    public Object trapFieldRead(String str) {
        try {
            return getClassMetaobject().getJavaClass().getField(str).get(getObject());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.toString());
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    public void trapFieldWrite(String str, Object obj) {
        try {
            getClassMetaobject().getJavaClass().getField(str).set(getObject(), obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.toString());
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    public Object trapMethodcall(int i, Object[] objArr) {
        try {
            return this.methods[i].invoke(getObject(), objArr);
        } catch (IllegalAccessException e) {
            throw new CannotInvokeException(e);
        } catch (InvocationTargetException e2) {
            throw e2.getTargetException();
        }
    }
}
