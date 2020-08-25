package com.vivo.push.cache.impl;

import android.content.Context;
import com.vivo.push.PushClientConstants;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.model.SubscribeAppInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes9.dex */
public final class b extends a implements ISubscribeAppTagManager {
    public b(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final boolean setTags(Set<String> set) {
        boolean z;
        boolean z2 = false;
        if (set != null) {
            synchronized (sAppLock) {
                Iterator<String> it = set.iterator();
                boolean z3 = false;
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator it2 = this.mAppDatas.iterator();
                    boolean z4 = z3;
                    while (true) {
                        if (!it2.hasNext()) {
                            z3 = z4;
                            break;
                        }
                        SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it2.next();
                        if (!subscribeAppInfo.getName().equals(next)) {
                            z = z4;
                        } else if (subscribeAppInfo.getTargetStatus() == 1) {
                            it.remove();
                            z3 = z4;
                            break;
                        } else {
                            subscribeAppInfo.setTargetStatus(1);
                            subscribeAppInfo.setActualStatus(2);
                            z = true;
                        }
                        z4 = z;
                    }
                }
                HashSet hashSet = new HashSet();
                for (String str : set) {
                    hashSet.add(new SubscribeAppInfo(str, 1, 2));
                }
                if (hashSet.size() > 0) {
                    addDatas(hashSet);
                    z2 = true;
                } else {
                    if (z3) {
                        updateDataToSP(this.mAppDatas);
                    }
                    z2 = z3;
                }
            }
        }
        return z2;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final boolean delTags(Set<String> set) {
        boolean z;
        boolean z2 = false;
        if (set != null) {
            synchronized (sAppLock) {
                Iterator<String> it = set.iterator();
                boolean z3 = false;
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator it2 = this.mAppDatas.iterator();
                    boolean z4 = z3;
                    while (true) {
                        if (!it2.hasNext()) {
                            z3 = z4;
                            break;
                        }
                        SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it2.next();
                        if (!subscribeAppInfo.getName().equals(next)) {
                            z = z4;
                        } else if (subscribeAppInfo.getTargetStatus() == 2) {
                            it.remove();
                            z3 = z4;
                            break;
                        } else {
                            subscribeAppInfo.setTargetStatus(2);
                            subscribeAppInfo.setActualStatus(1);
                            z = true;
                        }
                        z4 = z;
                    }
                }
                HashSet hashSet = new HashSet();
                for (String str : set) {
                    hashSet.add(new SubscribeAppInfo(str, 2, 1));
                }
                if (hashSet.size() > 0) {
                    addDatas(hashSet);
                    z2 = true;
                } else {
                    if (z3) {
                        updateDataToSP(this.mAppDatas);
                    }
                    z2 = z3;
                }
            }
        }
        return z2;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final void setTagsSuccess(Set<String> set) {
        boolean z;
        synchronized (sAppLock) {
            boolean z2 = false;
            for (String str : set) {
                for (T t : this.mAppDatas) {
                    if (!str.equals(t.getName()) || t.getActualStatus() == 1) {
                        z = z2;
                    } else {
                        t.setActualStatus(1);
                        z = true;
                    }
                    z2 = z;
                }
            }
            if (z2) {
                updateDataToSP(this.mAppDatas);
            }
        }
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final void delTagsSuccess(Set<String> set) {
        boolean z;
        synchronized (sAppLock) {
            boolean z2 = false;
            for (String str : set) {
                Iterator it = this.mAppDatas.iterator();
                while (it.hasNext()) {
                    SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it.next();
                    if (!str.equals(subscribeAppInfo.getName()) || subscribeAppInfo.getActualStatus() == 2) {
                        z = z2;
                    } else {
                        if (subscribeAppInfo.getTargetStatus() == 2) {
                            it.remove();
                        } else {
                            subscribeAppInfo.setActualStatus(2);
                        }
                        z = true;
                    }
                    z2 = z;
                }
            }
            if (z2) {
                updateDataToSP(this.mAppDatas);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    /* renamed from: a */
    public ArrayList<String> getSubscribeTags() {
        ArrayList<String> arrayList;
        synchronized (sAppLock) {
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
    public final ArrayList<String> getRetrySubscribeAppInfo() {
        ArrayList<String> arrayList;
        synchronized (sAppLock) {
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
        synchronized (sAppLock) {
            arrayList = new ArrayList<>();
            for (T t : this.mAppDatas) {
                if (t != null && t.getTargetStatus() == 2 && t.getTargetStatus() != t.getActualStatus()) {
                    arrayList.add(t.getName());
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.c
    protected final String generateStrByType() {
        return PushClientConstants.PUSH_APP_TAGS;
    }
}
