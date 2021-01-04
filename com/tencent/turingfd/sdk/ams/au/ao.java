package com.tencent.turingfd.sdk.ams.au;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class ao {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f13780a;

    /* renamed from: b  reason: collision with root package name */
    public String f13781b = "GBK";

    public ao(byte[] bArr) {
        this.f13780a = ByteBuffer.wrap(bArr);
    }

    public byte a(byte b2, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new ak("require field not exist.");
            }
            return b2;
        }
        ByteBuffer byteBuffer = this.f13780a;
        byte b3 = byteBuffer.get();
        byte b4 = (byte) (b3 & 15);
        if (((b3 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b4 != 0) {
            if (b4 != 11) {
                if (b4 == 12) {
                    return (byte) 0;
                }
                throw new ak("type mismatch.");
            }
            return b2;
        }
        return this.f13780a.get();
    }

    public double a(double d, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new ak("require field not exist.");
            }
            return d;
        }
        ByteBuffer byteBuffer = this.f13780a;
        byte b2 = byteBuffer.get();
        byte b3 = (byte) (b2 & 15);
        if (((b2 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b3 != 4) {
            if (b3 != 5) {
                if (b3 != 11) {
                    if (b3 == 12) {
                        return 0.0d;
                    }
                    throw new ak("type mismatch.");
                }
                return d;
            }
            return this.f13780a.getDouble();
        }
        return this.f13780a.getFloat();
    }

    public float a(float f, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new ak("require field not exist.");
            }
            return f;
        }
        ByteBuffer byteBuffer = this.f13780a;
        byte b2 = byteBuffer.get();
        byte b3 = (byte) (b2 & 15);
        if (((b2 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b3 != 4) {
            if (b3 != 11) {
                if (b3 == 12) {
                    return 0.0f;
                }
                throw new ak("type mismatch.");
            }
            return f;
        }
        return this.f13780a.getFloat();
    }

    public int a(int i, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new ak("require field not exist.");
            }
            return i;
        }
        ByteBuffer byteBuffer = this.f13780a;
        byte b2 = byteBuffer.get();
        byte b3 = (byte) (b2 & 15);
        if (((b2 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b3 != 0) {
            if (b3 != 1) {
                if (b3 != 2) {
                    if (b3 != 11) {
                        if (b3 == 12) {
                            return 0;
                        }
                        throw new ak("type mismatch.");
                    }
                    return i;
                }
                return this.f13780a.getInt();
            }
            return this.f13780a.getShort();
        }
        return this.f13780a.get();
    }

    public long a(long j, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new ak("require field not exist.");
            }
            return j;
        }
        ByteBuffer byteBuffer = this.f13780a;
        byte b2 = byteBuffer.get();
        byte b3 = (byte) (b2 & 15);
        if (((b2 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b3 != 11) {
            if (b3 != 12) {
                switch (b3) {
                    case 0:
                        return this.f13780a.get();
                    case 1:
                        return this.f13780a.getShort();
                    case 2:
                        return this.f13780a.getInt();
                    case 3:
                        return this.f13780a.getLong();
                    default:
                        throw new ak("type mismatch.");
                }
            }
            return 0L;
        }
        return j;
    }

    public bf a(bf bfVar, int i, boolean z) {
        bf bfVar2 = null;
        if (a(i)) {
            try {
                bfVar2 = (bf) bfVar.getClass().newInstance();
                ByteBuffer byteBuffer = this.f13780a;
                byte b2 = byteBuffer.get();
                byte b3 = (byte) (b2 & 15);
                if (((b2 & 240) >> 4) == 15) {
                    byteBuffer.get();
                }
                if (b3 != 10) {
                    throw new ak("type mismatch.");
                }
                bfVar2.a(this);
                a();
            } catch (Exception e) {
                throw new ak(e.getMessage());
            }
        } else if (z) {
            throw new ak("require field not exist.");
        }
        return bfVar2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.tencent.turingfd.sdk.ams.au.ao */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0L, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i, z));
        }
        if (t instanceof String) {
            return a(i, z);
        }
        if (t instanceof Map) {
            Map map = (Map) t;
            HashMap hashMap = new HashMap();
            if (map == null || map.isEmpty()) {
                return new HashMap();
            }
            Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!a(i)) {
                if (z) {
                    throw new ak("require field not exist.");
                }
                return hashMap;
            }
            ByteBuffer byteBuffer = this.f13780a;
            byte b2 = byteBuffer.get();
            byte b3 = (byte) (b2 & 15);
            if (((b2 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b3 != 8) {
                if (b3 == 11) {
                    return hashMap;
                }
                throw new ak("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                for (int i2 = 0; i2 < a2; i2++) {
                    hashMap.put(a((ao) key, 0, true), a((ao) value, 1, true));
                }
                return hashMap;
            }
            throw new ak(ab.a("size invalid: ", a2));
        }
        if (t instanceof List) {
            List list = (List) t;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            Object[] b4 = b(list.get(0), i, z);
            if (b4 != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : b4) {
                    arrayList.add(obj);
                }
                return arrayList;
            }
        } else if (t instanceof bf) {
            return a((bf) t, i, z);
        } else {
            if (!t.getClass().isArray()) {
                throw new ak("read object error: unsupport type.");
            }
            if ((t instanceof byte[]) || (t instanceof Byte[])) {
                if (a(i)) {
                    ByteBuffer byteBuffer2 = this.f13780a;
                    byte b5 = byteBuffer2.get();
                    byte b6 = (byte) (b5 & 15);
                    if (((b5 & 240) >> 4) == 15) {
                        byteBuffer2.get();
                    }
                    if (b6 == 9) {
                        int a3 = a(0, 0, true);
                        if (a3 >= 0) {
                            byte[] bArr = new byte[a3];
                            for (int i3 = 0; i3 < a3; i3++) {
                                bArr[i3] = a(bArr[0], 0, true);
                            }
                            return bArr;
                        }
                        throw new ak(ab.a("size invalid: ", a3));
                    } else if (b6 != 11) {
                        if (b6 == 13) {
                            ByteBuffer byteBuffer3 = this.f13780a;
                            byte b7 = byteBuffer3.get();
                            byte b8 = (byte) (b7 & 15);
                            if (((b7 & 240) >> 4) == 15) {
                                byteBuffer3.get();
                            }
                            if (b8 == 0) {
                                int a4 = a(0, 0, true);
                                if (a4 >= 0) {
                                    byte[] bArr2 = new byte[a4];
                                    this.f13780a.get(bArr2);
                                    return bArr2;
                                }
                                throw new ak("invalid size, tag: " + i + ", type: " + ((int) b6) + ", " + ((int) b8) + ", size: " + a4);
                            }
                            throw new ak("type mismatch, tag: " + i + ", type: " + ((int) b6) + ", " + ((int) b8));
                        }
                        throw new ak("type mismatch.");
                    }
                } else if (z) {
                    throw new ak("require field not exist.");
                }
            } else if (t instanceof boolean[]) {
                if (a(i)) {
                    ByteBuffer byteBuffer4 = this.f13780a;
                    byte b9 = byteBuffer4.get();
                    byte b10 = (byte) (b9 & 15);
                    if (((b9 & 240) >> 4) == 15) {
                        byteBuffer4.get();
                    }
                    if (b10 == 9) {
                        int a5 = a(0, 0, true);
                        if (a5 >= 0) {
                            boolean[] zArr = new boolean[a5];
                            for (int i4 = 0; i4 < a5; i4++) {
                                zArr[i4] = a(zArr[0], 0, true);
                            }
                            return zArr;
                        }
                        throw new ak(ab.a("size invalid: ", a5));
                    } else if (b10 != 11) {
                        throw new ak("type mismatch.");
                    }
                } else if (z) {
                    throw new ak("require field not exist.");
                }
            } else if (t instanceof short[]) {
                if (a(i)) {
                    ByteBuffer byteBuffer5 = this.f13780a;
                    byte b11 = byteBuffer5.get();
                    byte b12 = (byte) (b11 & 15);
                    if (((b11 & 240) >> 4) == 15) {
                        byteBuffer5.get();
                    }
                    if (b12 == 9) {
                        int a6 = a(0, 0, true);
                        if (a6 >= 0) {
                            short[] sArr = new short[a6];
                            for (int i5 = 0; i5 < a6; i5++) {
                                sArr[i5] = a(sArr[0], 0, true);
                            }
                            return sArr;
                        }
                        throw new ak(ab.a("size invalid: ", a6));
                    } else if (b12 != 11) {
                        throw new ak("type mismatch.");
                    }
                } else if (z) {
                    throw new ak("require field not exist.");
                }
            } else if (t instanceof int[]) {
                if (a(i)) {
                    ByteBuffer byteBuffer6 = this.f13780a;
                    byte b13 = byteBuffer6.get();
                    byte b14 = (byte) (b13 & 15);
                    if (((b13 & 240) >> 4) == 15) {
                        byteBuffer6.get();
                    }
                    if (b14 == 9) {
                        int a7 = a(0, 0, true);
                        if (a7 >= 0) {
                            int[] iArr = new int[a7];
                            for (int i6 = 0; i6 < a7; i6++) {
                                iArr[i6] = a(iArr[0], 0, true);
                            }
                            return iArr;
                        }
                        throw new ak(ab.a("size invalid: ", a7));
                    } else if (b14 != 11) {
                        throw new ak("type mismatch.");
                    }
                } else if (z) {
                    throw new ak("require field not exist.");
                }
            } else if (t instanceof long[]) {
                if (a(i)) {
                    ByteBuffer byteBuffer7 = this.f13780a;
                    byte b15 = byteBuffer7.get();
                    byte b16 = (byte) (b15 & 15);
                    if (((b15 & 240) >> 4) == 15) {
                        byteBuffer7.get();
                    }
                    if (b16 == 9) {
                        int a8 = a(0, 0, true);
                        if (a8 >= 0) {
                            long[] jArr = new long[a8];
                            for (int i7 = 0; i7 < a8; i7++) {
                                jArr[i7] = a(jArr[0], 0, true);
                            }
                            return jArr;
                        }
                        throw new ak(ab.a("size invalid: ", a8));
                    } else if (b16 != 11) {
                        throw new ak("type mismatch.");
                    }
                } else if (z) {
                    throw new ak("require field not exist.");
                }
            } else if (t instanceof float[]) {
                if (a(i)) {
                    ByteBuffer byteBuffer8 = this.f13780a;
                    byte b17 = byteBuffer8.get();
                    byte b18 = (byte) (b17 & 15);
                    if (((b17 & 240) >> 4) == 15) {
                        byteBuffer8.get();
                    }
                    if (b18 == 9) {
                        int a9 = a(0, 0, true);
                        if (a9 >= 0) {
                            float[] fArr = new float[a9];
                            for (int i8 = 0; i8 < a9; i8++) {
                                fArr[i8] = a(fArr[0], 0, true);
                            }
                            return fArr;
                        }
                        throw new ak(ab.a("size invalid: ", a9));
                    } else if (b18 != 11) {
                        throw new ak("type mismatch.");
                    }
                } else if (z) {
                    throw new ak("require field not exist.");
                }
            } else if (!(t instanceof double[])) {
                Object[] objArr = (Object[]) t;
                if (objArr.length != 0) {
                    return b(objArr[0], i, z);
                }
                throw new ak("unable to get type of key and value.");
            } else if (a(i)) {
                ByteBuffer byteBuffer9 = this.f13780a;
                byte b19 = byteBuffer9.get();
                byte b20 = (byte) (b19 & 15);
                if (((b19 & 240) >> 4) == 15) {
                    byteBuffer9.get();
                }
                if (b20 == 9) {
                    int a10 = a(0, 0, true);
                    if (a10 >= 0) {
                        double[] dArr = new double[a10];
                        for (int i9 = 0; i9 < a10; i9++) {
                            dArr[i9] = a(dArr[0], 0, true);
                        }
                        return dArr;
                    }
                    throw new ak(ab.a("size invalid: ", a10));
                } else if (b20 != 11) {
                    throw new ak("type mismatch.");
                }
            } else if (z) {
                throw new ak("require field not exist.");
            }
        }
        return null;
    }

    public String a(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new ak("require field not exist.");
            }
            return null;
        }
        ByteBuffer byteBuffer = this.f13780a;
        byte b2 = byteBuffer.get();
        byte b3 = (byte) (b2 & 15);
        if (((b2 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b3 == 6) {
            int i2 = this.f13780a.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.f13780a.get(bArr);
            try {
                return new String(bArr, this.f13781b);
            } catch (UnsupportedEncodingException e) {
                return new String(bArr);
            }
        } else if (b3 != 7) {
            if (b3 == 11) {
                return null;
            }
            throw new ak("type mismatch.");
        } else {
            int i3 = this.f13780a.getInt();
            if (i3 > 104857600 || i3 < 0) {
                throw new ak(ab.a("String too long: ", i3));
            }
            byte[] bArr2 = new byte[i3];
            this.f13780a.get(bArr2);
            try {
                return new String(bArr2, this.f13781b);
            } catch (UnsupportedEncodingException e2) {
                return new String(bArr2);
            }
        }
    }

    public short a(short s, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new ak("require field not exist.");
            }
            return s;
        }
        ByteBuffer byteBuffer = this.f13780a;
        byte b2 = byteBuffer.get();
        byte b3 = (byte) (b2 & 15);
        if (((b2 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b3 != 0) {
            if (b3 != 1) {
                if (b3 != 11) {
                    if (b3 == 12) {
                        return (short) 0;
                    }
                    throw new ak("type mismatch.");
                }
                return s;
            }
            return this.f13780a.getShort();
        }
        return this.f13780a.get();
    }

    public void a() {
        while (this.f13780a.remaining() != 0) {
            ByteBuffer byteBuffer = this.f13780a;
            byte b2 = byteBuffer.get();
            byte b3 = (byte) (b2 & 15);
            if (((b2 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            a(b3);
            if (b3 == 11) {
                return;
            }
        }
    }

    public final void a(byte b2) {
        int i = 0;
        switch (b2) {
            case 0:
                b(1);
                return;
            case 1:
                b(2);
                return;
            case 2:
                b(4);
                return;
            case 3:
                b(8);
                return;
            case 4:
                b(4);
                return;
            case 5:
                b(8);
                return;
            case 6:
                int i2 = this.f13780a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                b(i2);
                return;
            case 7:
                b(this.f13780a.getInt());
                return;
            case 8:
                int a2 = a(0, 0, true);
                while (i < a2 * 2) {
                    b();
                    i++;
                }
                return;
            case 9:
                int a3 = a(0, 0, true);
                while (i < a3) {
                    b();
                    i++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                ByteBuffer byteBuffer = this.f13780a;
                byte b3 = byteBuffer.get();
                byte b4 = (byte) (b3 & 15);
                if (((b3 & 240) >> 4) == 15) {
                    byteBuffer.get();
                }
                if (b4 != 0) {
                    throw new ak("skipField with invalid type, type value: " + ((int) b2) + ", " + ((int) b4));
                }
                b(a(0, 0, true));
                return;
            default:
                throw new ak("invalid type.");
        }
    }

    public boolean a(int i) {
        int i2;
        int i3;
        while (true) {
            try {
                ByteBuffer duplicate = this.f13780a.duplicate();
                byte b2 = duplicate.get();
                byte b3 = (byte) (b2 & 15);
                i2 = (b2 & 240) >> 4;
                if (i2 == 15) {
                    i2 = duplicate.get() & 255;
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (i <= i2 || b3 == 11) {
                    break;
                }
                b(i3);
                a(b3);
            } catch (ak e) {
                return false;
            } catch (BufferUnderflowException e2) {
                return false;
            }
        }
        return i == i2;
    }

    public boolean a(boolean z, int i, boolean z2) {
        return a(z ? (byte) 1 : (byte) 0, i, z2) != 0;
    }

    public final void b() {
        ByteBuffer byteBuffer = this.f13780a;
        byte b2 = byteBuffer.get();
        byte b3 = (byte) (b2 & 15);
        if (((b2 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        a(b3);
    }

    public final void b(int i) {
        ByteBuffer byteBuffer = this.f13780a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] b(T t, int i, boolean z) {
        if (a(i)) {
            ByteBuffer byteBuffer = this.f13780a;
            byte b2 = byteBuffer.get();
            byte b3 = (byte) (b2 & 15);
            if (((b2 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b3 == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
                    for (int i2 = 0; i2 < a2; i2++) {
                        tArr[i2] = a((ao) t, 0, true);
                    }
                    return tArr;
                }
                throw new ak(ab.a("size invalid: ", a2));
            } else if (b3 != 11) {
                throw new ak("type mismatch.");
            }
        } else if (z) {
            throw new ak("require field not exist.");
        }
        return null;
    }
}
