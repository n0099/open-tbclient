package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.webkit.internal.Base64;
import com.vivo.push.util.g;
import com.vivo.push.util.h;
import com.vivo.push.util.p;
import com.vivo.push.util.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes7.dex */
public abstract class c<T> {
    public static final String TAG = "IAppManager";
    public Set<T> mAppDatas = new HashSet();
    public Context mContext;
    public w mSharePreferenceManager;
    public static final byte[] CRPYT_IV_BYTE = {34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 37, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 41, Base64.INTERNAL_PADDING, Base64.INTERNAL_PADDING, 32, 32};
    public static final byte[] CRPYT_KEY_BYTE = {PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 32, 38, 37, PublicSuffixDatabase.EXCEPTION_MARKER, Base64.INTERNAL_PADDING, 34, PublicSuffixDatabase.EXCEPTION_MARKER};
    public static final Object sAppLock = new Object();
    public static int MAX_CLIENT_SAVE_LENGTH = 10000;

    public c(Context context) {
        this.mContext = context.getApplicationContext();
        w b2 = w.b();
        this.mSharePreferenceManager = b2;
        b2.a(this.mContext);
        loadData();
    }

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

    public void addDatas(Set<T> set) {
        if (set == null) {
            return;
        }
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

    public void clearData() {
        synchronized (sAppLock) {
            this.mAppDatas.clear();
            this.mSharePreferenceManager.c(generateStrByType());
        }
    }

    public abstract String generateStrByType();

    public boolean isEmpty() {
        Set<T> set = this.mAppDatas;
        return set == null || set.size() == 0;
    }

    public void loadData() {
        synchronized (sAppLock) {
            h.a(generateStrByType());
            this.mAppDatas.clear();
            String a2 = this.mSharePreferenceManager.a(generateStrByType());
            if (TextUtils.isEmpty(a2)) {
                p.d(TAG, "AppManager init strApps empty.");
            } else if (a2.length() > MAX_CLIENT_SAVE_LENGTH) {
                p.d(TAG, "sync  strApps lenght too large");
                clearData();
            } else {
                try {
                    String str = new String(g.a(g.a(CRPYT_IV_BYTE), g.a(CRPYT_KEY_BYTE), android.util.Base64.decode(a2, 2)), "utf-8");
                    p.d(TAG, "AppManager init strApps : " + str);
                    Set<T> parseAppStr = parseAppStr(str);
                    if (parseAppStr != null) {
                        this.mAppDatas.addAll(parseAppStr);
                    }
                } catch (Exception e2) {
                    clearData();
                    p.d(TAG, p.a(e2));
                }
            }
        }
    }

    public abstract Set<T> parseAppStr(String str);

    public void removeData(T t) {
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

    public void removeDatas(Set<T> set) {
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

    public abstract String toAppStr(Set<T> set);

    public String updateDataToSP(Set<T> set) {
        String appStr = toAppStr(set);
        try {
            String a2 = g.a(CRPYT_IV_BYTE);
            String a3 = g.a(CRPYT_KEY_BYTE);
            byte[] bytes = appStr.getBytes("utf-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(a3.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(a2.getBytes("utf-8")));
            String encodeToString = android.util.Base64.encodeToString(cipher.doFinal(bytes), 2);
            if (!TextUtils.isEmpty(encodeToString) && encodeToString.length() > MAX_CLIENT_SAVE_LENGTH) {
                p.d(TAG, "sync  strApps lenght too large");
                clearData();
                return null;
            }
            p.d(TAG, "sync  strApps: " + encodeToString);
            this.mSharePreferenceManager.a(generateStrByType(), encodeToString);
            return appStr;
        } catch (Exception e2) {
            p.d(TAG, p.a(e2));
            clearData();
            return null;
        }
    }
}
