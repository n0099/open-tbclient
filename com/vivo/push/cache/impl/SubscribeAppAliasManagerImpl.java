package com.vivo.push.cache.impl;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.PushClientConstants;
import com.vivo.push.cache.ISubscribeAppAliasManager;
import com.vivo.push.model.SubscribeAppInfo;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class SubscribeAppAliasManagerImpl extends a implements ISubscribeAppAliasManager {
    public SubscribeAppAliasManagerImpl(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public boolean setAlias(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = this.mAppDatas.size();
        SubscribeAppInfo subscribeAppInfo = getSubscribeAppInfo();
        if (size == 1 && subscribeAppInfo != null && str.equals(subscribeAppInfo.getName()) && subscribeAppInfo.getTargetStatus() == 1) {
            return false;
        }
        clearData();
        addData(new SubscribeAppInfo(str, 1, 2));
        return true;
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public boolean delAlias(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = this.mAppDatas.size();
        SubscribeAppInfo subscribeAppInfo = getSubscribeAppInfo();
        if (size == 1 && subscribeAppInfo != null && str.equals(subscribeAppInfo.getName()) && subscribeAppInfo.getTargetStatus() == 2) {
            return false;
        }
        clearData();
        addData(new SubscribeAppInfo(str, 2, 1));
        return true;
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public void setAliasSuccess(String str) {
        boolean z;
        synchronized (sAppLock) {
            if (!TextUtils.isEmpty(str)) {
                for (T t : this.mAppDatas) {
                    if (t.getName().equals(str) && t.getActualStatus() != 1) {
                        t.setActualStatus(1);
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

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public void delAliasSuccess(String str) {
        boolean z;
        synchronized (sAppLock) {
            if (!TextUtils.isEmpty(str)) {
                for (T t : this.mAppDatas) {
                    if (t.getName().equals(str) && t.getActualStatus() != 2) {
                        t.setActualStatus(2);
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                SubscribeAppInfo subscribeAppInfo = getSubscribeAppInfo();
                if (subscribeAppInfo != null) {
                    if (subscribeAppInfo.getActualStatus() == subscribeAppInfo.getTargetStatus()) {
                        clearData();
                    } else {
                        updateDataToSP(this.mAppDatas);
                    }
                }
            }
        }
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public SubscribeAppInfo getSubscribeAppInfo() {
        SubscribeAppInfo subscribeAppInfo;
        synchronized (sAppLock) {
            Iterator it = this.mAppDatas.iterator();
            subscribeAppInfo = it.hasNext() ? (SubscribeAppInfo) it.next() : null;
        }
        return subscribeAppInfo;
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public SubscribeAppInfo getRetrySubscribeAppInfo() {
        SubscribeAppInfo subscribeAppInfo = getSubscribeAppInfo();
        if (subscribeAppInfo == null || subscribeAppInfo.getTargetStatus() == subscribeAppInfo.getActualStatus()) {
            return null;
        }
        return subscribeAppInfo;
    }

    @Override // com.vivo.push.cache.c
    protected String generateStrByType() {
        return PushClientConstants.PUSH_APP_ALIAS;
    }
}
