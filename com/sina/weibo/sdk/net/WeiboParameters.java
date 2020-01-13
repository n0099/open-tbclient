package com.sina.weibo.sdk.net;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Set;
/* loaded from: classes5.dex */
public class WeiboParameters {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private String mAnonymousCookie;
    private String mAppKey;
    private LinkedHashMap<String, Object> mParams = new LinkedHashMap<>();

    public WeiboParameters(String str) {
        this.mAppKey = str;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public LinkedHashMap<String, Object> getParams() {
        return this.mParams;
    }

    public void setParams(LinkedHashMap<String, Object> linkedHashMap) {
        this.mParams = linkedHashMap;
    }

    @Deprecated
    public void add(String str, String str2) {
        this.mParams.put(str, str2);
    }

    @Deprecated
    public void add(String str, int i) {
        this.mParams.put(str, String.valueOf(i));
    }

    @Deprecated
    public void add(String str, long j) {
        this.mParams.put(str, String.valueOf(j));
    }

    @Deprecated
    public void add(String str, Object obj) {
        this.mParams.put(str, obj.toString());
    }

    public void put(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public void put(String str, int i) {
        this.mParams.put(str, String.valueOf(i));
    }

    public void put(String str, long j) {
        this.mParams.put(str, String.valueOf(j));
    }

    public void put(String str, Bitmap bitmap) {
        this.mParams.put(str, bitmap);
    }

    public void put(String str, Object obj) {
        this.mParams.put(str, obj.toString());
    }

    public Object get(String str) {
        return this.mParams.get(str);
    }

    public void remove(String str) {
        if (this.mParams.containsKey(str)) {
            this.mParams.remove(str);
            this.mParams.remove(this.mParams.get(str));
        }
    }

    public Set<String> keySet() {
        return this.mParams.keySet();
    }

    public boolean containsKey(String str) {
        return this.mParams.containsKey(str);
    }

    public boolean containsValue(String str) {
        return this.mParams.containsValue(str);
    }

    public int size() {
        return this.mParams.size();
    }

    public String encodeUrl() {
        boolean z;
        String str;
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (String str2 : this.mParams.keySet()) {
            if (z2) {
                z = false;
            } else {
                sb.append(ETAG.ITEM_SEPARATOR);
                z = z2;
            }
            Object obj = this.mParams.get(str2);
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((String) obj)) {
                    try {
                        sb.append(URLEncoder.encode(str2, "UTF-8") + ETAG.EQUAL + URLEncoder.encode(str, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            z2 = z;
        }
        return sb.toString();
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
            while (r1.hasNext()) {
            }
        }
        return false;
    }

    public void setAnonymousCookie(String str) {
        this.mAnonymousCookie = str;
    }

    public String getAnonymousCookie() {
        return this.mAnonymousCookie;
    }
}
