package javassist.util.proxy;

import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedActionException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SerializedProxy implements Serializable {
    private byte[] filterSignature;
    private c handler;
    private String[] interfaces;
    private String superClass;

    SerializedProxy(Class cls, byte[] bArr, c cVar) {
        this.filterSignature = bArr;
        this.handler = cVar;
        this.superClass = cls.getSuperclass().getName();
        Class<?>[] interfaces = cls.getInterfaces();
        int length = interfaces.length;
        this.interfaces = new String[length - 1];
        String name = ProxyObject.class.getName();
        String name2 = d.class.getName();
        for (int i = 0; i < length; i++) {
            String name3 = interfaces[i].getName();
            if (!name3.equals(name) && !name3.equals(name2)) {
                this.interfaces[i] = name3;
            }
        }
    }

    protected Class loadClass(String str) {
        try {
            return (Class) AccessController.doPrivileged(new r(this, str));
        } catch (PrivilegedActionException e) {
            throw new RuntimeException("cannot load the class: " + str, e.getException());
        }
    }

    Object readResolve() {
        try {
            int length = this.interfaces.length;
            Class[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = loadClass(this.interfaces[i]);
            }
            e eVar = new e();
            eVar.a(loadClass(this.superClass));
            eVar.a(clsArr);
            d dVar = (d) eVar.a(this.filterSignature).newInstance();
            dVar.a(this.handler);
            return dVar;
        } catch (ClassNotFoundException e) {
            throw new InvalidClassException(e.getMessage());
        } catch (IllegalAccessException e2) {
            throw new InvalidClassException(e2.getMessage());
        } catch (InstantiationException e3) {
            throw new InvalidObjectException(e3.getMessage());
        }
    }
}
