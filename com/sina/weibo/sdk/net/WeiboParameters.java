package com.sina.weibo.sdk.net;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Set;
/* loaded from: classes6.dex */
public class WeiboParameters {
    public static final String DEFAULT_CHARSET = "UTF-8";
    public String mAnonymousCookie;
    public String mAppKey;
    public LinkedHashMap<String, Object> mParams = new LinkedHashMap<>();

    public WeiboParameters(String str) {
        this.mAppKey = str;
    }

    @Deprecated
    public void add(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public boolean containsKey(String str) {
        return this.mParams.containsKey(str);
    }

    public boolean containsValue(String str) {
        return this.mParams.containsValue(str);
    }

    public String encodeUrl() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : this.mParams.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            Object obj = this.mParams.get(str);
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        sb.append(URLEncoder.encode(str, "UTF-8") + "=" + URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return sb.toString();
    }

    public Object get(String str) {
        return this.mParams.get(str);
    }

    public String getAnonymousCookie() {
        return this.mAnonymousCookie;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public LinkedHashMap<String, Object> getParams() {
        return this.mParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasBinaryData() {
        for (String str : this.mParams.keySet()) {
            Object obj = this.mParams.get(str);
            if ((obj instanceof ByteArrayOutputStream) || (obj instanceof Bitmap)) {
                return true;
            }
            while (r0.hasNext()) {
            }
        }
        return false;
    }

    public Set<String> keySet() {
        return this.mParams.keySet();
    }

    public void put(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public void remove(String str) {
        if (this.mParams.containsKey(str)) {
            this.mParams.remove(str);
            LinkedHashMap<String, Object> linkedHashMap = this.mParams;
            linkedHashMap.remove(linkedHashMap.get(str));
        }
    }

    public void setAnonymousCookie(String str) {
        this.mAnonymousCookie = str;
    }

    public void setParams(LinkedHashMap<String, Object> linkedHashMap) {
        this.mParams = linkedHashMap;
    }

    public int size() {
        return this.mParams.size();
    }

    @Deprecated
    public void add(String str, int i) {
        this.mParams.put(str, String.valueOf(i));
    }

    public void put(String str, int i) {
        this.mParams.put(str, String.valueOf(i));
    }

    @Deprecated
    public void add(String str, long j) {
        this.mParams.put(str, String.valueOf(j));
    }

    public void put(String str, long j) {
        this.mParams.put(str, String.valueOf(j));
    }

    @Deprecated
    public void add(String str, Object obj) {
        this.mParams.put(str, obj.toString());
    }

    public void put(String str, Bitmap bitmap) {
        this.mParams.put(str, bitmap);
    }

    public void put(String str, Object obj) {
        this.mParams.put(str, obj.toString());
    }
}
