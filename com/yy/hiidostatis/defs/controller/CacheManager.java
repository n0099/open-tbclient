package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
/* loaded from: classes8.dex */
public class CacheManager {
    public Context c;
    public String mCacheKey;
    public String mCacheValue;
    public String mPrefCacheKey;
    public String mPrefCacheValue;

    public CacheManager(Context context, String str, String str2) {
        this.c = context;
        this.mPrefCacheKey = str;
        this.mPrefCacheValue = str2;
        String cacheKey = getCacheKey();
        this.mCacheKey = cacheKey;
        this.mCacheValue = getCacheValue(context, cacheKey);
    }

    private void saveCacheValue(Context context, String str, String str2) {
        DefaultPreference.getPreference().clearKey(context, DefaultPreference.getPreference().getPrefString(context, this.mPrefCacheKey, ""));
        DefaultPreference.getPreference().setPrefString(context, this.mPrefCacheKey, str);
        DefaultPreference.getPreference().setPrefString(context, this.mPrefCacheValue, Base64Util.encode(str2.getBytes()));
    }

    private String getCacheKey() {
        try {
            return Util.formatDate("yyyyMMdd", System.currentTimeMillis());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void finish() {
        saveCacheValue(this.c, this.mCacheKey, this.mCacheValue);
        this.mCacheValue = null;
    }

    private String getCacheValue(Context context, String str) {
        String prefString;
        String prefString2 = DefaultPreference.getPreference().getPrefString(context, this.mPrefCacheKey, null);
        if (prefString2 != null && prefString2.equals(this.mCacheKey) && (prefString = DefaultPreference.getPreference().getPrefString(context, this.mPrefCacheValue, null)) != null) {
            return new String(Base64Util.decode(prefString));
        }
        return "";
    }

    public void add(String str) {
        if (this.mCacheValue.length() == 0) {
            this.mCacheValue = "|";
        }
        this.mCacheValue += str + "|";
    }

    public boolean isContains(String str) {
        String str2 = this.mCacheValue;
        return str2.contains("|" + str + "|");
    }
}
