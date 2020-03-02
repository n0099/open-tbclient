package com.dd.plist;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class i {
    static final String lGJ = System.getProperty("line.separator");

    public static h eU(long j) {
        return new h(j);
    }

    public static h x(double d) {
        return new h(d);
    }

    public static h uZ(boolean z) {
        return new h(z);
    }

    public static e ai(byte[] bArr) {
        return new e(bArr);
    }

    public static d I(Object[] objArr) {
        d dVar = new d(objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            dVar.j(i, aO(objArr[i]));
        }
        return dVar;
    }

    public static i aO(Object obj) {
        int i = 0;
        if (obj == null) {
            return null;
        }
        if (obj instanceof i) {
            return (i) obj;
        }
        Class<?> cls = obj.getClass();
        if (Boolean.class.equals(cls)) {
            return uZ(((Boolean) obj).booleanValue());
        }
        if (Byte.class.equals(cls)) {
            return eU(((Byte) obj).byteValue());
        }
        if (Short.class.equals(cls)) {
            return eU(((Short) obj).shortValue());
        }
        if (Integer.class.equals(cls)) {
            return eU(((Integer) obj).intValue());
        }
        if (Long.class.isAssignableFrom(cls)) {
            return eU(((Long) obj).longValue());
        }
        if (Float.class.equals(cls)) {
            return x(((Float) obj).floatValue());
        }
        if (Double.class.isAssignableFrom(cls)) {
            return x(((Double) obj).doubleValue());
        }
        if (String.class.equals(cls)) {
            return new k((String) obj);
        }
        if (Date.class.equals(cls)) {
            return new f((Date) obj);
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            if (componentType.equals(Byte.TYPE)) {
                return ai((byte[]) obj);
            }
            if (componentType.equals(Boolean.TYPE)) {
                boolean[] zArr = (boolean[]) obj;
                d dVar = new d(zArr.length);
                while (i < zArr.length) {
                    dVar.j(i, uZ(zArr[i]));
                    i++;
                }
                return dVar;
            } else if (Float.TYPE.equals(componentType)) {
                float[] fArr = (float[]) obj;
                d dVar2 = new d(fArr.length);
                while (i < fArr.length) {
                    dVar2.j(i, x(fArr[i]));
                    i++;
                }
                return dVar2;
            } else if (Double.TYPE.equals(componentType)) {
                double[] dArr = (double[]) obj;
                d dVar3 = new d(dArr.length);
                while (i < dArr.length) {
                    dVar3.j(i, x(dArr[i]));
                    i++;
                }
                return dVar3;
            } else if (Short.TYPE.equals(componentType)) {
                short[] sArr = (short[]) obj;
                d dVar4 = new d(sArr.length);
                while (i < sArr.length) {
                    dVar4.j(i, eU(sArr[i]));
                    i++;
                }
                return dVar4;
            } else if (Integer.TYPE.equals(componentType)) {
                int[] iArr = (int[]) obj;
                d dVar5 = new d(iArr.length);
                while (i < iArr.length) {
                    dVar5.j(i, eU(iArr[i]));
                    i++;
                }
                return dVar5;
            } else if (Long.TYPE.equals(componentType)) {
                long[] jArr = (long[]) obj;
                d dVar6 = new d(jArr.length);
                while (i < jArr.length) {
                    dVar6.j(i, eU(jArr[i]));
                    i++;
                }
                return dVar6;
            } else {
                return I((Object[]) obj);
            }
        } else if (Map.class.isAssignableFrom(cls)) {
            Map map = (Map) obj;
            Set keySet = map.keySet();
            g gVar = new g();
            for (Object obj2 : keySet) {
                gVar.put(String.valueOf(obj2), aO(map.get(obj2)));
            }
            return gVar;
        } else if (Collection.class.isAssignableFrom(cls)) {
            return I(((Collection) obj).toArray());
        } else {
            return aP(obj);
        }
    }

    public static e aP(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new e(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("The given object of class " + obj.getClass().toString() + " could not be serialized and stored in a NSData object.");
        }
    }
}
