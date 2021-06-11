package com.yy.hiidostatis.defs.obj;

import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
/* loaded from: classes7.dex */
public class Property implements Serializable {
    public static final String DIVIDE_PROPERTY = ",";
    public static final int MAX_EVENT_FIELD_BYTES = 256;
    public static final int MAX_SIZE = 30;
    public static final long serialVersionUID = -6839046473425691433L;
    public LinkedHashMap<String, PropertyPair> mParams = new LinkedHashMap<>(30);

    private boolean isOverSize() {
        return this.mParams.size() >= 30;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LinkedHashMap<String, PropertyPair> linkedHashMap = (LinkedHashMap) objectInputStream.readObject();
        this.mParams = linkedHashMap;
        if (linkedHashMap == null) {
            this.mParams = new LinkedHashMap<>();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.mParams);
    }

    public synchronized void clear() {
        this.mParams.clear();
    }

    public synchronized boolean containsKey(String str) {
        return this.mParams.containsKey(str);
    }

    public synchronized Property copy() {
        Property property;
        property = new Property();
        if (this.mParams != null) {
            property.mParams.putAll(this.mParams);
        }
        return property;
    }

    public synchronized String getConnectedPropertys() {
        LinkedHashMap<String, PropertyPair> linkedHashMap = this.mParams;
        if (linkedHashMap != null && linkedHashMap.size() != 0) {
            if (linkedHashMap.size() == 1) {
                return Util.replaceEncode(linkedHashMap.values().iterator().next().getConnectedPair(), ",");
            }
            StringBuilder sb = new StringBuilder();
            for (PropertyPair propertyPair : linkedHashMap.values()) {
                sb.append(Util.replaceEncode(propertyPair.getConnectedPair(), ","));
                sb.append(",");
            }
            sb.replace(sb.length() - 1, sb.length(), "");
            return sb.toString();
        }
        return null;
    }

    public synchronized void putDouble(String str, double d2) {
        if (isOverSize()) {
            L.warn(this, "Property max size is %d,now is %d,so get up this inParam:key=[%s],value=[%s]", 30, Integer.valueOf(size()), str + "", d2 + "");
        } else if (Util.empty(str)) {
            L.debug(this, "key is not allow null.", new Object[0]);
        } else if (str.getBytes().length > 256) {
            L.warn(this, "key[%s] bytes[%d] must under %d bytes", str, Integer.valueOf(str.getBytes().length), 256);
        } else {
            this.mParams.put(str, new PropertyPair(str, d2));
        }
    }

    public synchronized void putString(String str, String str2) {
        if (!isOverSize()) {
            if (Util.empty(str)) {
                L.debug(this, "key is not allow null.", new Object[0]);
                return;
            } else {
                this.mParams.put(str, new PropertyPair(str, str2));
                return;
            }
        }
        L.warn(this, "Property max size is %d,now is %d,so get up this inParam:key=[%s],value=[%s]", 30, Integer.valueOf(size()), str + "", str2 + "");
    }

    public synchronized boolean removeProperty(String str) {
        return this.mParams.remove(str) != null;
    }

    public synchronized int size() {
        return this.mParams.size();
    }
}
