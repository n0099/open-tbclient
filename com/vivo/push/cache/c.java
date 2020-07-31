package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
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
/* loaded from: classes3.dex */
public abstract class c<T> {
    protected static final String TAG = "IAppManager";
    protected Context mContext;
    public static final byte[] CRPYT_IV_BYTE = {34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, 41, 35, 35, 32, 32};
    public static final byte[] CRPYT_KEY_BYTE = {33, 34, 35, 36, 37, 38, 39, 40, 41, 32, 38, 37, 33, 35, 34, 33};
    protected static final Object sAppLock = new Object();
    private static int MAX_CLIENT_SAVE_LENGTH = 10000;
    protected Set<T> mAppDatas = new HashSet();
    private w mSharePreferenceManager = w.b();

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
            h.a(generateStrByType());
            this.mAppDatas.clear();
            String a = this.mSharePreferenceManager.a(generateStrByType());
            if (TextUtils.isEmpty(a)) {
                p.d(TAG, "AppManager init strApps empty.");
            } else if (a.length() > MAX_CLIENT_SAVE_LENGTH) {
                p.d(TAG, "sync  strApps lenght too large");
                clearData();
            } else {
                try {
                    String str = new String(g.a(g.a(CRPYT_IV_BYTE), g.a(CRPYT_KEY_BYTE), Base64.decode(a, 2)), "utf-8");
                    p.d(TAG, "AppManager init strApps : " + str);
                    Set<T> parseAppStr = parseAppStr(str);
                    if (parseAppStr != null) {
                        this.mAppDatas.addAll(parseAppStr);
                    }
                } catch (Exception e) {
                    clearData();
                    p.d(TAG, p.a(e));
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
            String a = g.a(CRPYT_IV_BYTE);
            String a2 = g.a(CRPYT_KEY_BYTE);
            byte[] bytes = appStr.getBytes("utf-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(a2.getBytes("utf-8"), com.baidu.sapi2.utils.h.q);
            Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.h.p);
            cipher.init(1, secretKeySpec, new IvParameterSpec(a.getBytes("utf-8")));
            String encodeToString = Base64.encodeToString(cipher.doFinal(bytes), 2);
            if (!TextUtils.isEmpty(encodeToString) && encodeToString.length() > MAX_CLIENT_SAVE_LENGTH) {
                p.d(TAG, "sync  strApps lenght too large");
                clearData();
            } else {
                p.d(TAG, "sync  strApps: " + encodeToString);
                this.mSharePreferenceManager.a(generateStrByType(), encodeToString);
                str = appStr;
            }
        } catch (Exception e) {
            p.d(TAG, p.a(e));
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
