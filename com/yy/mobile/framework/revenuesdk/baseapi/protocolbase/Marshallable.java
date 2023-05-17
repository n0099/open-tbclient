package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import kotlin.UShort;
/* loaded from: classes10.dex */
public class Marshallable extends PacketBase {

    /* loaded from: classes10.dex */
    public enum ELenType {
        E_INT16,
        E_INT32,
        E_INT64,
        E_NONE
    }

    public final byte[] popByteArray16() throws Exception {
        checkPacket(2);
        int popInt16 = popInt16();
        checkPacket(popInt16);
        byte[] bArr = new byte[popInt16];
        this.buffer.get(bArr);
        return bArr;
    }

    public final short popInt16() throws Exception {
        checkPacket(2);
        return this.buffer.getShort();
    }

    public final int popInt32() throws Exception {
        checkPacket(4);
        return this.buffer.getInt();
    }

    public final long popInt64() throws Exception {
        checkPacket(8);
        return this.buffer.getLong();
    }

    public final byte popInt8() throws Exception {
        checkPacket(1);
        return this.buffer.get();
    }

    public final String popStingWithOutLength() throws Exception {
        int remaining = this.buffer.remaining();
        byte[] bArr = new byte[remaining];
        checkPacket(remaining);
        this.buffer.get(bArr);
        return new String(bArr, "UTF-8");
    }

    public final String popString16() throws Exception {
        checkPacket(2);
        int popInt16 = popInt16();
        checkPacket(popInt16);
        byte[] bArr = new byte[popInt16];
        this.buffer.get(bArr);
        return new String(bArr, "UTF-8");
    }

    public final String popString32() throws Exception {
        checkPacket(4);
        int popInt32 = popInt32();
        checkPacket(popInt32);
        byte[] bArr = new byte[popInt32];
        this.buffer.get(bArr);
        return new String(bArr, "UTF-8");
    }

    public final int popUint16() throws Exception {
        checkPacket(2);
        return popInt16() & UShort.MAX_VALUE;
    }

    public final long popUint32() throws Exception {
        checkPacket(4);
        return popInt32() & 4294967295L;
    }

    public final short popUint8() throws Exception {
        checkPacket(1);
        return (short) (popInt8() & 255);
    }

    private <K> K popKey(Class<K> cls, ELenType eLenType) throws Exception {
        if (cls == Byte.class) {
            return (K) Byte.valueOf(popInt8());
        }
        if (cls == Short.class) {
            return (K) Short.valueOf(popInt16());
        }
        if (cls == Integer.class) {
            if (eLenType == ELenType.E_INT16) {
                return (K) Integer.valueOf(popUint16());
            }
            return (K) Integer.valueOf(popInt32());
        } else if (cls == Long.class) {
            if (eLenType == ELenType.E_INT32) {
                return (K) Long.valueOf(popUint32());
            }
            return (K) Long.valueOf(popInt64());
        } else if (cls == String.class) {
            if (eLenType == ELenType.E_INT16) {
                return (K) popString16();
            }
            return (K) popString32();
        } else {
            throw new IllegalStateException("unknow map key type: " + cls.getName());
        }
    }

    private <V> V popValue(Class<V> cls, ELenType eLenType) throws Exception {
        if (cls == Byte.class) {
            return (V) Byte.valueOf(popInt8());
        }
        if (cls == Short.class) {
            return (V) Short.valueOf(popInt16());
        }
        if (cls == Integer.class) {
            return (V) Integer.valueOf(popInt32());
        }
        if (cls == Long.class) {
            if (eLenType == ELenType.E_INT32) {
                return (V) Long.valueOf(popUint32());
            }
            return (V) Long.valueOf(popInt64());
        } else if (cls == String.class) {
            if (eLenType == ELenType.E_INT16) {
                return (V) popString16();
            }
            return (V) popString32();
        } else {
            throw new IllegalStateException("unknow map value type: " + cls.getName());
        }
    }

    private <K> void pushKey(K k) {
        if (k instanceof Byte) {
            pushInt8(((Byte) k).byteValue());
        } else if (k instanceof Short) {
            pushInt16(((Short) k).shortValue());
        } else if (k instanceof Integer) {
            pushInt32(((Integer) k).intValue());
        } else if (k instanceof String) {
            pushString16((String) k);
        } else {
            throw new IllegalStateException("unknow map value type: " + k.getClass().getName());
        }
    }

    private <V> void pushValue(V v) {
        if (v instanceof Byte) {
            pushInt8(((Byte) v).byteValue());
        } else if (v instanceof Short) {
            pushInt16(((Short) v).shortValue());
        } else if (v instanceof Integer) {
            pushInt32(((Integer) v).intValue());
        } else if (v instanceof String) {
            pushString16((String) v);
        } else {
            throw new IllegalStateException("unknow map value type: " + v.getClass().getName());
        }
    }

    public final <T> Collection<T> popCollection(Class<? extends Collection> cls, Class<T> cls2) throws Exception {
        return popCollection(cls, cls2, ELenType.E_INT32);
    }

    public <K, V> Map<K, V> popMap(Class<K> cls, Class<V> cls2) throws Exception {
        ELenType eLenType = ELenType.E_INT64;
        return popMap(cls, eLenType, cls2, eLenType);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.Collection<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Collection<T> popCollection(Class<? extends Collection> cls, Class<T> cls2, ELenType eLenType) throws Exception {
        int popInt32 = popInt32();
        Collection<T> collection = (Collection<T>) cls.newInstance();
        if (collection != 0) {
            for (int i = 0; i < popInt32; i++) {
                collection.add(popValue(cls2, eLenType));
            }
        }
        return collection;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.TreeMap */
    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> popMap(Class<K> cls, ELenType eLenType, Class<V> cls2, ELenType eLenType2) throws Exception {
        int popInt32 = popInt32();
        TreeMap treeMap = new TreeMap();
        for (int i = 0; i < popInt32; i++) {
            treeMap.put(popKey(cls, eLenType), popValue(cls2, eLenType2));
        }
        return treeMap;
    }

    public final void pushByteArray(byte[] bArr) {
        this.buffer.put(bArr);
    }

    public final void pushInt16(short s) {
        this.buffer.putShort(s);
    }

    public final void pushInt32(int i) {
        this.buffer.putInt(i);
    }

    public final void pushInt64(long j) {
        this.buffer.putLong(j);
    }

    public final void pushInt8(byte b) {
        this.buffer.put(b);
    }

    public final void pushString16(String str) {
        byte[] bArr;
        if (str != null) {
            try {
                bArr = str.getBytes(IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                bArr = new byte[0];
            }
            pushInt16((short) bArr.length);
            this.buffer.put(bArr);
        }
    }

    public final void pushString32(String str) {
        byte[] bArr;
        if (str != null) {
            try {
                bArr = str.getBytes(IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                bArr = new byte[0];
            }
            pushInt32(bArr.length);
            this.buffer.put(bArr);
        }
    }

    public final void pushStringWithoutLength(String str) {
        byte[] bArr;
        if (str != null) {
            try {
                bArr = str.getBytes(IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                bArr = new byte[0];
            }
            this.buffer.put(bArr);
        }
    }

    public <K, V> void pushMap(Map<K, V> map) {
        if (map != null && map.size() != 0) {
            pushInt32(map.size());
            for (Map.Entry<K, V> entry : map.entrySet()) {
                pushKey(entry.getKey());
                pushValue(entry.getValue());
            }
            return;
        }
        pushInt32(0);
    }
}
