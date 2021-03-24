package com.vivo.push.cache.impl;

import android.content.Context;
import com.vivo.push.PushClientConstants;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.cache.c;
import com.vivo.push.model.SubscribeAppInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes7.dex */
public final class b extends a implements ISubscribeAppTagManager {
    public b(Context context) {
        super(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    /* renamed from: a */
    public ArrayList<String> getSubscribeTags() {
        ArrayList<String> arrayList;
        synchronized (c.sAppLock) {
            arrayList = new ArrayList<>();
            for (T t : this.mAppDatas) {
                if (t != null && t.getTargetStatus() == 1) {
                    arrayList.add(t.getName());
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final boolean delTags(Set<String> set) {
        boolean z = false;
        if (set == null) {
            return false;
        }
        synchronized (c.sAppLock) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Iterator it2 = this.mAppDatas.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it2.next();
                        if (subscribeAppInfo.getName().equals(next)) {
                            if (subscribeAppInfo.getTargetStatus() == 2) {
                                it.remove();
                                break;
                            }
                            subscribeAppInfo.setTargetStatus(2);
                            subscribeAppInfo.setActualStatus(1);
                            z = true;
                        }
                    }
                }
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                hashSet.add(new SubscribeAppInfo(str, 2, 1));
            }
            if (hashSet.size() > 0) {
                addDatas(hashSet);
                z = true;
            } else if (z) {
                updateDataToSP(this.mAppDatas);
            }
        }
        return z;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final void delTagsSuccess(Set<String> set) {
        synchronized (c.sAppLock) {
            boolean z = false;
            for (String str : set) {
                Iterator it = this.mAppDatas.iterator();
                while (it.hasNext()) {
                    SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it.next();
                    if (str.equals(subscribeAppInfo.getName()) && subscribeAppInfo.getActualStatus() != 2) {
                        if (subscribeAppInfo.getTargetStatus() == 2) {
                            it.remove();
                        } else {
                            subscribeAppInfo.setActualStatus(2);
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                updateDataToSP(this.mAppDatas);
            }
        }
    }

    @Override // com.vivo.push.cache.c
    public final String generateStrByType() {
        return PushClientConstants.PUSH_APP_TAGS;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final ArrayList<String> getRetrySubscribeAppInfo() {
        ArrayList<String> arrayList;
        synchronized (c.sAppLock) {
            arrayList = new ArrayList<>();
            for (T t : this.mAppDatas) {
                if (t != null && t.getTargetStatus() == 1 && t.getTargetStatus() != t.getActualStatus()) {
                    arrayList.add(t.getName());
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final ArrayList<String> getRetryUnsubscribeAppInfo() {
        ArrayList<String> arrayList;
        synchronized (c.sAppLock) {
            arrayList = new ArrayList<>();
            for (T t : this.mAppDatas) {
                if (t != null && t.getTargetStatus() == 2 && t.getTargetStatus() != t.getActualStatus()) {
                    arrayList.add(t.getName());
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final boolean setTags(Set<String> set) {
        boolean z = false;
        if (set == null) {
            return false;
        }
        synchronized (c.sAppLock) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Iterator it2 = this.mAppDatas.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it2.next();
                        if (subscribeAppInfo.getName().equals(next)) {
                            if (subscribeAppInfo.getTargetStatus() == 1) {
                                it.remove();
                                break;
                            }
                            subscribeAppInfo.setTargetStatus(1);
                            subscribeAppInfo.setActualStatus(2);
                            z = true;
                        }
                    }
                }
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                hashSet.add(new SubscribeAppInfo(str, 1, 2));
            }
            if (hashSet.size() > 0) {
                addDatas(hashSet);
                z = true;
            } else if (z) {
                updateDataToSP(this.mAppDatas);
            }
        }
        return z;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final void setTagsSuccess(Set<String> set) {
        synchronized (c.sAppLock) {
            boolean z = false;
            for (String str : set) {
                for (T t : this.mAppDatas) {
                    if (str.equals(t.getName()) && t.getActualStatus() != 1) {
                        t.setActualStatus(1);
                        z = true;
                    }
                }
            }
            if (z) {
                updateDataToSP(this.mAppDatas);
            }
        }
    }
}
