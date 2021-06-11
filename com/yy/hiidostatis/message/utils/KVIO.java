package com.yy.hiidostatis.message.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.yy.hiidostatis.inner.util.NumberUtil;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class KVIO {
    public static KVIO kvio;
    public SharedPreferences cache;
    public SharedPreferences.Editor editor;

    public KVIO(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ProcessUtil.getFileNameBindProcess(context, "hiido_kv.dat"), 0);
        this.cache = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public static KVIO get() {
        return kvio;
    }

    public static synchronized void initialize(Context context) {
        synchronized (KVIO.class) {
            if (kvio != null) {
                return;
            }
            kvio = new KVIO(context);
        }
    }

    public boolean commit() {
        return this.editor.commit();
    }

    public boolean decodeBool(String str) {
        return decodeBool(str, false);
    }

    public byte[] decodeBytes(String str) {
        return decodeBytes(str, null);
    }

    public double decodeDouble(String str) {
        return decodeDouble(str, 0.0d);
    }

    public float decodeFloat(String str) {
        return decodeFloat(str, 0.0f);
    }

    public int decodeInt(String str) {
        return decodeInt(str, 0);
    }

    public long decodeLong(String str) {
        return decodeLong(str, 0L);
    }

    public String decodeString(String str) {
        return decodeString(str, null);
    }

    public Set<String> decodeStringSet(String str) {
        return decodeStringSet(str, null);
    }

    public boolean encode(String str, boolean z) {
        this.editor.putBoolean(str, z).apply();
        return true;
    }

    public boolean decodeBool(String str, boolean z) {
        return this.cache.getBoolean(str, z);
    }

    public byte[] decodeBytes(String str, byte[] bArr) {
        String string = this.cache.getString(str, null);
        if (string == null) {
            return bArr;
        }
        try {
            return NumberUtil.toBytes(string);
        } catch (Throwable unused) {
            return bArr;
        }
    }

    public double decodeDouble(String str, double d2) {
        return this.cache.getLong(str, (long) d2);
    }

    public float decodeFloat(String str, float f2) {
        return this.cache.getFloat(str, f2);
    }

    public int decodeInt(String str, int i2) {
        return this.cache.getInt(str, i2);
    }

    public long decodeLong(String str, long j) {
        return this.cache.getLong(str, j);
    }

    public String decodeString(String str, String str2) {
        return this.cache.getString(str, str2);
    }

    public Set<String> decodeStringSet(String str, Set<String> set) {
        return decodeStringSet(str, set, HashSet.class);
    }

    public boolean encode(String str, int i2) {
        this.editor.putInt(str, i2).apply();
        return true;
    }

    private Set<String> decodeStringSet(String str, Set<String> set, Class<? extends Set> cls) {
        return this.cache.getStringSet(str, set);
    }

    public boolean encode(String str, long j) {
        this.editor.putLong(str, j).apply();
        return true;
    }

    public boolean encode(String str, float f2) {
        this.editor.putFloat(str, f2).apply();
        return true;
    }

    public boolean encode(String str, double d2) {
        this.editor.putLong(str, (long) d2).apply();
        return true;
    }

    public boolean encode(String str, String str2) {
        this.editor.putString(str, str2).apply();
        return true;
    }

    public boolean encode(String str, Set<String> set) {
        this.editor.putStringSet(str, set);
        return true;
    }

    public boolean encode(String str, byte[] bArr) {
        this.editor.putString(str, NumberUtil.toHex(bArr)).apply();
        return true;
    }
}
