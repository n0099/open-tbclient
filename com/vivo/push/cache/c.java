package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.m;
import com.vivo.push.util.t;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class c<T> {
    public static final String CRPYT_IV = "2015120111293300";
    public static final String CRPYT_KEY = "1234567890651321";
    protected static final String TAG = "IAppManager";
    protected Context mContext;
    protected static final Object sAppLock = new Object();
    private static int MAX_CLIENT_SAVE_LENGTH = 10000;
    protected Set<T> mAppDatas = new HashSet();
    private t mSharePreferenceManager = t.b();

    protected abstract String generateStrByType();

    protected abstract Set<T> parseAppStr(String str);

    protected abstract String toAppStr(Set<T> set);

    public c(Context context) {
        this.mContext = context.getApplicationContext();
        this.mSharePreferenceManager.a(this.mContext);
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadData() {
        synchronized (sAppLock) {
            com.vivo.push.util.e.a(generateStrByType());
            this.mAppDatas.clear();
            String a = this.mSharePreferenceManager.a(generateStrByType());
            if (TextUtils.isEmpty(a)) {
                m.d(TAG, "AppManager init strApps empty.");
            } else if (a.length() > MAX_CLIENT_SAVE_LENGTH) {
                m.d(TAG, "sync  strApps lenght too large");
                clearData();
            } else {
                try {
                    String str = new String(com.vivo.push.util.d.b(CRPYT_IV, CRPYT_KEY, Base64.decode(a, 0)), "utf-8");
                    m.d(TAG, "AppManager init strApps : " + str);
                    Set<T> parseAppStr = parseAppStr(str);
                    if (parseAppStr != null) {
                        this.mAppDatas.addAll(parseAppStr);
                    }
                } catch (Exception e) {
                    m.d(TAG, m.a(e));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addData(T t) {
        synchronized (sAppLock) {
            Iterator<T> it = this.mAppDatas.iterator();
            while (it.hasNext()) {
                if (t.equals(it.next())) {
                    it.remove();
                }
            }
            this.mAppDatas.add(t);
            updateDataToSP(this.mAppDatas);
        }
    }

    protected void removeData(T t) {
        synchronized (sAppLock) {
            boolean z = false;
            Iterator<T> it = this.mAppDatas.iterator();
            while (it.hasNext()) {
                if (t.equals(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                updateDataToSP(this.mAppDatas);
            }
        }
    }

    protected void removeDatas(Set<T> set) {
        synchronized (sAppLock) {
            Iterator<T> it = this.mAppDatas.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (set.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                updateDataToSP(this.mAppDatas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addDatas(Set<T> set) {
        if (set != null) {
            synchronized (sAppLock) {
                Iterator<T> it = this.mAppDatas.iterator();
                while (it.hasNext()) {
                    if (set.contains(it.next())) {
                        it.remove();
                    }
                }
                this.mAppDatas.addAll(set);
                updateDataToSP(this.mAppDatas);
            }
        }
    }

    public String updateDataToSP(Set<T> set) {
        String str = null;
        String appStr = toAppStr(set);
        try {
            String encodeToString = Base64.encodeToString(com.vivo.push.util.d.a(CRPYT_IV, CRPYT_KEY, appStr.getBytes("utf-8")), 0);
            if (!TextUtils.isEmpty(encodeToString) && encodeToString.length() > MAX_CLIENT_SAVE_LENGTH) {
                m.d(TAG, "sync  strApps lenght too large");
                clearData();
            } else {
                m.d(TAG, "sync  strApps: " + encodeToString);
                this.mSharePreferenceManager.a(generateStrByType(), encodeToString);
                str = appStr;
            }
        } catch (Exception e) {
            m.d(TAG, m.a(e));
            clearData();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearData() {
        synchronized (sAppLock) {
            this.mAppDatas.clear();
            this.mSharePreferenceManager.c(generateStrByType());
        }
    }

    public boolean isEmpty() {
        return this.mAppDatas == null || this.mAppDatas.size() == 0;
    }
}
