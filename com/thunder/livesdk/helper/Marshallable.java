package com.thunder.livesdk.helper;

import com.thunder.livesdk.log.ThunderLog;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class Marshallable implements IPtotoPacket {
    public static final int kProtoPacketSize = 4096;
    protected ByteBuffer mBuffer;

    /* loaded from: classes4.dex */
    public enum ELenType {
        E_SHORT,
        E_INT,
        E_NONE
    }

    public Marshallable() {
        this.mBuffer = null;
        this.mBuffer = ByteBuffer.allocate(4096);
        this.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public Marshallable(boolean z) {
        this.mBuffer = null;
        if (z) {
            this.mBuffer = ByteBuffer.allocate(4096);
            this.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public Marshallable(int i) {
        this.mBuffer = null;
        this.mBuffer = ByteBuffer.allocate(i);
        this.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // com.thunder.livesdk.helper.IPtotoPacket
    public byte[] marshall() {
        byte[] bArr = new byte[this.mBuffer.position()];
        this.mBuffer.position(0);
        this.mBuffer.get(bArr);
        return bArr;
    }

    @Override // com.thunder.livesdk.helper.IPtotoPacket
    public void marshall(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    @Override // com.thunder.livesdk.helper.IPtotoPacket
    public void unmarshall(byte[] bArr) {
        this.mBuffer = ByteBuffer.wrap(bArr);
        this.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // com.thunder.livesdk.helper.IPtotoPacket
    public void unmarshall(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public void pushBool(Boolean bool) {
        byte b2 = bool.booleanValue() ? (byte) 1 : (byte) 0;
        check_capactiy(1);
        this.mBuffer.put(b2);
    }

    public Boolean popBool() {
        return Boolean.valueOf(this.mBuffer.get() == 1);
    }

    public void pushByte(byte b2) {
        check_capactiy(1);
        this.mBuffer.put(b2);
    }

    public byte popByte() {
        return this.mBuffer.get();
    }

    public void pushBytes(byte[] bArr) {
        if (bArr == null) {
            check_capactiy(2);
            this.mBuffer.putShort((short) 0);
        } else if (bArr.length > 65535) {
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(ThunderLog.kLogTagSdk, "pushBytes, buf overflow, size=" + bArr.length);
            }
            check_capactiy(2);
            this.mBuffer.putShort((short) 0);
        } else {
            check_capactiy(bArr.length + 2);
            this.mBuffer.putShort((short) bArr.length);
            this.mBuffer.put(bArr);
        }
    }

    public byte[] popBytes() {
        int i = this.mBuffer.getShort();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.mBuffer.get(bArr);
        return bArr;
    }

    public void pushBytes32(byte[] bArr) {
        if (bArr == null) {
            check_capactiy(4);
            this.mBuffer.putInt(0);
            return;
        }
        check_capactiy(bArr.length + 4);
        this.mBuffer.putInt(bArr.length);
        this.mBuffer.put(bArr);
    }

    public byte[] popBytes32() {
        int i = this.mBuffer.getInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.mBuffer.get(bArr);
        return bArr;
    }

    public byte[] popAll() {
        byte[] bArr = new byte[this.mBuffer.remaining()];
        this.mBuffer.get(bArr);
        return bArr;
    }

    public void pushShort(short s) {
        check_capactiy(2);
        this.mBuffer.putShort(s);
    }

    public short popShort() {
        return this.mBuffer.getShort();
    }

    public void pushInt(int i) {
        check_capactiy(4);
        this.mBuffer.putInt(i);
    }

    public void pushInt(long j) {
        check_capactiy(4);
        this.mBuffer.putInt((int) j);
    }

    public void pushFloat(float f) {
        check_capactiy(4);
        this.mBuffer.putFloat(f);
    }

    public float popFloat() {
        return this.mBuffer.getFloat();
    }

    public int popInt() {
        return this.mBuffer.getInt();
    }

    public long popInt2Long() {
        return this.mBuffer.getInt() & 4294967295L;
    }

    public void pushInt64(long j) {
        check_capactiy(8);
        this.mBuffer.putLong(j);
    }

    public long popInt64() {
        return this.mBuffer.getLong();
    }

    public void pushString16(String str) {
        if (str == null) {
            check_capactiy(2);
            this.mBuffer.putShort((short) 0);
            return;
        }
        check_capactiy(str.getBytes().length + 2);
        this.mBuffer.putShort((short) str.getBytes().length);
        if (str.getBytes().length > 0) {
            this.mBuffer.put(str.getBytes());
        }
    }

    public String popString16() {
        int i = this.mBuffer.getShort();
        if (i >= 0) {
            byte[] bArr = new byte[i];
            this.mBuffer.get(bArr);
            try {
                return new String(bArr, "ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String popString16UTF8() {
        int i = this.mBuffer.getShort();
        if (i >= 0) {
            byte[] bArr = new byte[i];
            this.mBuffer.get(bArr);
            try {
                return new String(bArr, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public void pushIntArray(int[] iArr) {
        if (iArr == null) {
            pushInt(0);
            return;
        }
        pushInt(iArr.length);
        for (int i : iArr) {
            pushInt(i);
        }
    }

    public void pushIntArray(Integer[] numArr) {
        if (numArr == null) {
            pushInt(0);
            return;
        }
        pushInt(numArr.length);
        for (Integer num : numArr) {
            pushInt(num.intValue());
        }
    }

    public void pushIntArray(long[] jArr) {
        if (jArr == null) {
            pushInt(0);
            return;
        }
        pushInt(jArr.length);
        for (long j : jArr) {
            pushInt(j);
        }
    }

    public int[] popIntArray() {
        int popInt = popInt();
        int[] iArr = new int[popInt];
        for (int i = 0; i < popInt; i++) {
            iArr[i] = popInt();
        }
        return iArr;
    }

    public long[] popIntArray2Long() {
        int popInt = popInt();
        long[] jArr = new long[popInt];
        for (int i = 0; i < popInt; i++) {
            jArr[i] = popInt2Long();
        }
        return jArr;
    }

    public void pushShortArray(short[] sArr) {
        if (sArr == null) {
            pushInt(0);
            return;
        }
        pushInt(sArr.length);
        for (short s : sArr) {
            pushShort(s);
        }
    }

    public short[] popShortArray() {
        int popInt = popInt();
        short[] sArr = new short[popInt];
        for (int i = 0; i < popInt; i++) {
            sArr[i] = popShort();
        }
        return sArr;
    }

    public String popString32() {
        int i = this.mBuffer.getInt();
        if (i >= 0) {
            byte[] bArr = new byte[i];
            this.mBuffer.get(bArr);
            try {
                return new String(bArr, "ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String popString16(String str) {
        int i = this.mBuffer.getShort();
        if (i >= 0) {
            byte[] bArr = new byte[i];
            this.mBuffer.get(bArr);
            try {
                return new String(bArr, str);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public void pushString32(String str) {
        if (str == null) {
            check_capactiy(4);
            this.mBuffer.putInt(0);
            return;
        }
        check_capactiy(str.getBytes().length + 4);
        this.mBuffer.putInt(str.getBytes().length);
        if (str.getBytes().length > 0) {
            this.mBuffer.put(str.getBytes());
        }
    }

    public void pushString32(String str, String str2) {
        if (str == null) {
            check_capactiy(4);
            this.mBuffer.putInt(0);
            return;
        }
        try {
            check_capactiy(str.getBytes().length + 4);
            this.mBuffer.putInt(str.getBytes(str2).length);
            if (str.getBytes().length > 0) {
                this.mBuffer.put(str.getBytes(str2));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String popString32(String str) {
        int i = this.mBuffer.getInt();
        if (i >= 0) {
            byte[] bArr = new byte[i];
            this.mBuffer.get(bArr);
            try {
                return new String(bArr, str);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    protected void check_capactiy(int i) {
        if (this.mBuffer.capacity() - this.mBuffer.position() < i) {
            increase_capacity(i - (this.mBuffer.capacity() - this.mBuffer.position()));
        }
    }

    protected void increase_capacity(int i) {
        int capacity = this.mBuffer.capacity();
        if (capacity != 0) {
            int i2 = capacity * 2;
            if (i > capacity) {
                i2 = capacity + i;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i2);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            this.mBuffer.limit(this.mBuffer.position());
            this.mBuffer.position(0);
            allocate.put(this.mBuffer);
            this.mBuffer = allocate;
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(ThunderLog.kLogTagSdk, "increase_capacity, size=" + i2);
            }
        }
    }

    public void pushMarshallable(Marshallable marshallable) {
        if (marshallable != null) {
            marshallable.marshall(this.mBuffer);
        }
    }

    public Marshallable popMarshallable(Class<? extends Marshallable> cls) {
        Marshallable marshallable;
        try {
            marshallable = cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            marshallable = null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            marshallable = null;
        }
        marshallable.unmarshall(this.mBuffer);
        return marshallable;
    }

    private <K> void pushKey(K k, ELenType eLenType) {
        if (k instanceof Byte) {
            pushByte(((Byte) k).byteValue());
        } else if (k instanceof Short) {
            pushShort(((Short) k).shortValue());
        } else if (k instanceof Integer) {
            pushInt(((Integer) k).intValue());
        } else if (k instanceof Long) {
            pushInt64(((Long) k).longValue());
        } else if (k instanceof String) {
            pushString16((String) k);
        } else if (k instanceof byte[]) {
            pushBytes((byte[]) k);
        } else {
            throw new IllegalStateException("marshall Map but unknown key type: " + k.getClass().getName());
        }
    }

    private <K> K popKey(Class<K> cls, ELenType eLenType, String str) {
        if (cls == Byte.class) {
            return (K) Short.valueOf(popByte());
        }
        if (cls == Short.class) {
            return (K) Short.valueOf(popShort());
        }
        if (cls == Integer.class) {
            return (K) Integer.valueOf(popInt());
        }
        if (cls == Long.class) {
            return (K) Long.valueOf(popInt64());
        }
        if (cls == byte[].class) {
            if (eLenType == ELenType.E_SHORT) {
                return (K) popBytes();
            }
            if (eLenType == ELenType.E_INT) {
                return (K) popBytes32();
            }
            ThunderLog.warn(ThunderLog.kLogTagSdk, ThunderLog.kLogTagSdk, "invalid lenType=%d for popBytes", eLenType);
            return null;
        } else if (cls == String.class) {
            if (eLenType == ELenType.E_SHORT) {
                return (K) popString16(str);
            }
            if (eLenType == ELenType.E_INT) {
                return (K) popString32(str);
            }
            ThunderLog.warn(ThunderLog.kLogTagSdk, "invalid lenType=%d for popString", eLenType);
            return null;
        } else {
            throw new IllegalStateException("unMarshall Map but unknown key type: " + cls.getName());
        }
    }

    private <T> void pushElem(T t, Class<T> cls, ELenType eLenType) {
        if (cls == Integer.class) {
            pushInt(((Integer) t).intValue());
        } else if (cls == Short.class) {
            pushShort(((Short) t).shortValue());
        } else if (cls == Long.class) {
            pushInt64(((Long) t).longValue());
        } else if (cls == Byte.class) {
            pushByte(((Byte) t).byteValue());
        } else if (cls == String.class) {
            if (eLenType == ELenType.E_SHORT) {
                pushString16((String) t);
            } else if (eLenType == ELenType.E_INT) {
                pushString32((String) t);
            } else {
                ThunderLog.warn(ThunderLog.kLogTagSdk, "invalid lenType=%d for pushString", eLenType);
            }
        } else if (cls == byte[].class) {
            if (eLenType == ELenType.E_SHORT) {
                pushBytes((byte[]) t);
            } else if (eLenType == ELenType.E_INT) {
                pushBytes32((byte[]) t);
            } else {
                ThunderLog.warn(ThunderLog.kLogTagSdk, "invalid lenType=%d for pushBytes", eLenType);
            }
        } else if (t instanceof Marshallable) {
            ((Marshallable) t).marshall(this.mBuffer);
        } else {
            throw new RuntimeException("unable to marshal element of class " + cls.getName());
        }
    }

    private <T> T popElem(Class<T> cls, ELenType eLenType, String str) {
        T t = null;
        if (cls == Integer.class) {
            return (T) Integer.valueOf(popInt());
        }
        if (cls == Short.class) {
            return (T) Short.valueOf(popShort());
        }
        if (cls == Long.class) {
            return (T) Long.valueOf(popInt64());
        }
        if (cls == Byte.class) {
            return (T) Byte.valueOf(popByte());
        }
        if (cls == String.class) {
            if (eLenType == ELenType.E_SHORT) {
                return (T) popString16(str);
            }
            if (eLenType == ELenType.E_INT) {
                return (T) popString32(str);
            }
            ThunderLog.warn(ThunderLog.kLogTagSdk, "invalid lenType=%d for popString", eLenType);
            return null;
        } else if (cls == byte[].class) {
            if (eLenType == ELenType.E_SHORT) {
                return (T) popBytes();
            }
            if (eLenType == ELenType.E_INT) {
                return (T) popBytes32();
            }
            ThunderLog.warn(ThunderLog.kLogTagSdk, "invalid lenType=%d for popBytes", eLenType);
            return null;
        } else {
            try {
                t = cls.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
            if (t instanceof Marshallable) {
                ((Marshallable) t).unmarshall(this.mBuffer);
                return t;
            }
            ThunderLog.warn(ThunderLog.kLogTagSdk, "unmarshall invalid elemClass type=%s ", cls.getName());
            return t;
        }
    }

    public <T> void pushCollection(Collection<T> collection, Class<T> cls, ELenType eLenType) {
        if (collection == null || collection.size() == 0) {
            pushInt(0);
            return;
        }
        pushInt(collection.size());
        for (T t : collection) {
            pushElem(t, cls, eLenType);
        }
    }

    public <T> void pushCollection(Collection<T> collection, Class<T> cls) {
        pushCollection(collection, cls, ELenType.E_NONE);
    }

    public <T> Collection<T> popCollection(Class<? extends Collection> cls, Class<T> cls2) {
        return popCollection(cls, cls2, ELenType.E_SHORT, "utf-8");
    }

    public <T> Collection<T> popCollection(Class<? extends Collection> cls, Class<T> cls2, ELenType eLenType, String str) {
        Collection<T> collection;
        int popInt = popInt();
        try {
            collection = cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            collection = null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            collection = null;
        }
        if (collection == null) {
            return null;
        }
        for (int i = 0; i < popInt; i++) {
            collection.add(popElem(cls2, eLenType, str));
        }
        return collection;
    }

    public <K, T> void pushMap(Map<K, T> map, Class<T> cls) {
        pushMap(map, cls, ELenType.E_SHORT, ELenType.E_SHORT);
    }

    public <K, T> void pushMap(Map<K, T> map, Class<T> cls, ELenType eLenType, ELenType eLenType2) {
        if (map == null || map.size() == 0) {
            pushInt(0);
            return;
        }
        pushInt(map.size());
        for (Map.Entry<K, T> entry : map.entrySet()) {
            pushKey(entry.getKey(), eLenType);
            pushElem(entry.getValue(), cls, eLenType2);
        }
    }

    public <K, T> Map<K, T> popMap(Class<K> cls, Class<T> cls2) {
        return popMap(cls, ELenType.E_SHORT, "utf-8", cls2, ELenType.E_SHORT, "utf-8");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.TreeMap */
    /* JADX WARN: Multi-variable type inference failed */
    public <K, T> Map<K, T> popMap(Class<K> cls, ELenType eLenType, String str, Class<T> cls2, ELenType eLenType2, String str2) {
        int popInt = popInt();
        TreeMap treeMap = new TreeMap();
        for (int i = 0; i < popInt; i++) {
            treeMap.put(popKey(cls, eLenType, str), popElem(cls2, eLenType2, str2));
        }
        return treeMap;
    }
}
