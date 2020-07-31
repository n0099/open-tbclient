package com.vivo.push.cache.impl;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.cache.c;
import com.vivo.push.model.SubscribeAppInfo;
import com.vivo.push.util.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class a extends c<SubscribeAppInfo> {
    private static final String SPILTE_TAG = "@#";
    private static final String TAG = "SubscribeAppInfoManager";

    public a(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.cache.c
    public void loadData() {
        boolean z;
        super.loadData();
        synchronized (sAppLock) {
            boolean z2 = false;
            Iterator it = this.mAppDatas.iterator();
            while (it.hasNext()) {
                SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it.next();
                if (subscribeAppInfo.getTargetStatus() == 2 && subscribeAppInfo.getActualStatus() == 2) {
                    it.remove();
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
            if (z2) {
                updateDataToSP(this.mAppDatas);
            }
        }
    }

    @Override // com.vivo.push.cache.c
    public Set<SubscribeAppInfo> parseAppStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.trim().split(SPILTE_TAG)) {
                String[] split = str2.trim().trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 3) {
                    try {
                        hashSet.add(new SubscribeAppInfo(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                    } catch (Exception e) {
                        p.d(TAG, "str2Clients E: " + e);
                    }
                }
            }
            return hashSet;
        }
        return hashSet;
    }

    public void updateSubscribeApp(SubscribeAppInfo subscribeAppInfo) {
        boolean z;
        synchronized (sAppLock) {
            if (!TextUtils.isEmpty(subscribeAppInfo.getName())) {
                for (T t : this.mAppDatas) {
                    if (t.getName().equals(subscribeAppInfo.getName())) {
                        t.setTargetStatus(subscribeAppInfo.getTargetStatus());
                        t.setActualStatus(subscribeAppInfo.getActualStatus());
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                updateDataToSP(this.mAppDatas);
            }
        }
    }

    @Override // com.vivo.push.cache.c
    public String toAppStr(Set<SubscribeAppInfo> set) {
        if (set == null || set.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (SubscribeAppInfo subscribeAppInfo : set) {
            stringBuffer.append(subscribeAppInfo.getName());
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(subscribeAppInfo.getTargetStatus());
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(subscribeAppInfo.getActualStatus());
            stringBuffer.append(SPILTE_TAG);
        }
        return stringBuffer.substring(0, stringBuffer.length() - 2);
    }

    public SubscribeAppInfo getConfigByName(String str) {
        SubscribeAppInfo subscribeAppInfo;
        synchronized (sAppLock) {
            Iterator it = this.mAppDatas.iterator();
            while (true) {
                if (!it.hasNext()) {
                    subscribeAppInfo = null;
                    break;
                }
                subscribeAppInfo = (SubscribeAppInfo) it.next();
                if (!TextUtils.isEmpty(subscribeAppInfo.getName()) && subscribeAppInfo.getName().equals(str)) {
                    break;
                }
            }
        }
        return subscribeAppInfo;
    }
}
