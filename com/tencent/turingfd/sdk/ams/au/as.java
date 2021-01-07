package com.tencent.turingfd.sdk.ams.au;

import com.baidu.android.imsdk.internal.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class as {

    /* renamed from: b  reason: collision with root package name */
    public String f13790b = "GBK";

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f13789a = ByteBuffer.allocate(128);

    public void a(byte b2, int i) {
        if (i < 15) {
            this.f13789a.put((byte) ((i << 4) | b2));
        } else if (i >= 256) {
            throw new ai(ab.a("tag is too large: ", i));
        } else {
            this.f13789a.put((byte) (b2 | 240));
            this.f13789a.put((byte) i);
        }
    }

    public void a(int i) {
        if (this.f13789a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f13789a.capacity() + i) * 2);
            allocate.put(this.f13789a.array(), 0, this.f13789a.position());
            this.f13789a = allocate;
        }
    }

    public void a(int i, int i2) {
        a(6);
        if (i >= -32768 && i <= 32767) {
            a((short) i, i2);
            return;
        }
        a((byte) 2, i2);
        this.f13789a.putInt(i);
    }

    public void a(long j, int i) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            a((int) j, i);
            return;
        }
        a((byte) 3, i);
        this.f13789a.putLong(j);
    }

    public void a(bf bfVar, int i) {
        a(2);
        a((byte) 10, i);
        bfVar.a(this);
        a(2);
        a(Constants.GZIP_CAST_TYPE, 0);
    }

    public void a(Object obj, int i) {
        if (obj instanceof Byte) {
            b(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            a(6);
            a((byte) 4, i);
            this.f13789a.putFloat(floatValue);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            a(10);
            a((byte) 5, i);
            this.f13789a.putDouble(doubleValue);
        } else if (obj instanceof String) {
            a((String) obj, i);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
        } else if (obj instanceof List) {
            a((Collection) ((List) obj), i);
        } else if (obj instanceof bf) {
            a((bf) obj, i);
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            a(bArr.length + 8);
            a((byte) 13, i);
            a((byte) 0, 0);
            a(bArr.length, 0);
            this.f13789a.put(bArr);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            a((byte) 9, i);
            a(zArr.length, 0);
            for (boolean z : zArr) {
                a(z, 0);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            a((byte) 9, i);
            a(sArr.length, 0);
            for (short s : sArr) {
                a(s, 0);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            a((byte) 9, i);
            a(iArr.length, 0);
            for (int i2 : iArr) {
                a(i2, 0);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            a((byte) 9, i);
            a(jArr.length, 0);
            for (long j : jArr) {
                a(j, 0);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            a((byte) 9, i);
            a(fArr.length, 0);
            for (float f : fArr) {
                a(6);
                a((byte) 4, 0);
                this.f13789a.putFloat(f);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            a((byte) 9, i);
            a(dArr.length, 0);
            for (double d : dArr) {
                a(10);
                a((byte) 5, 0);
                this.f13789a.putDouble(d);
            }
        } else if (!obj.getClass().isArray()) {
            if (!(obj instanceof Collection)) {
                throw new ai(ab.a("write object error: unsupport type. ").append(obj.getClass()).toString());
            }
            a((Collection) obj, i);
        } else {
            Object[] objArr = (Object[]) obj;
            a(8);
            a((byte) 9, i);
            a(objArr.length, 0);
            for (Object obj2 : objArr) {
                a(obj2, 0);
            }
        }
    }

    public void a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f13790b);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            a((byte) 7, i);
            this.f13789a.putInt(bytes.length);
            this.f13789a.put(bytes);
            return;
        }
        a((byte) 6, i);
        this.f13789a.put((byte) bytes.length);
        this.f13789a.put(bytes);
    }

    public <T> void a(Collection<T> collection, int i) {
        a(8);
        a((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t : collection) {
                a(t, 0);
            }
        }
    }

    public <K, V> void a(Map<K, V> map, int i) {
        a(8);
        a((byte) 8, i);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public void a(short s, int i) {
        a(4);
        if (s >= -128 && s <= 127) {
            b((byte) s, i);
            return;
        }
        a((byte) 1, i);
        this.f13789a.putShort(s);
    }

    public void a(boolean z, int i) {
        b(z ? (byte) 1 : (byte) 0, i);
    }

    public void b(byte b2, int i) {
        a(3);
        if (b2 == 0) {
            a((byte) 12, i);
            return;
        }
        a((byte) 0, i);
        this.f13789a.put(b2);
    }
}
