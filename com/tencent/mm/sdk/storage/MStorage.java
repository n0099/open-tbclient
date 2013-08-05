package com.tencent.mm.sdk.storage;

import android.os.Looper;
/* loaded from: classes.dex */
public abstract class MStorage {
    private final MStorageEvent bM = new MStorageEvent() { // from class: com.tencent.mm.sdk.storage.MStorage.1
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        protected /* synthetic */ void processEvent(Object obj, Object obj2) {
            MStorage mStorage = MStorage.this;
            ((IOnStorageChange) obj).onNotifyChange((String) obj2);
        }
    };
    private final MStorageEvent bN = new MStorageEvent() { // from class: com.tencent.mm.sdk.storage.MStorage.2
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        protected /* synthetic */ void processEvent(Object obj, Object obj2) {
            MStorage mStorage = MStorage.this;
            ((IOnStorageLoaded) obj).onNotifyLoaded();
        }
    };

    /* loaded from: classes.dex */
    public interface IOnStorageChange {
        void onNotifyChange(String str);
    }

    /* loaded from: classes.dex */
    public interface IOnStorageLoaded {
        void onNotifyLoaded();
    }

    public void add(IOnStorageChange iOnStorageChange) {
        this.bM.add(iOnStorageChange, Looper.getMainLooper());
    }

    public void addLoadedListener(IOnStorageLoaded iOnStorageLoaded) {
        this.bN.add(iOnStorageLoaded, Looper.getMainLooper());
    }

    public void doNotify() {
        this.bM.event("*");
        this.bM.doNotify();
    }

    public void doNotify(String str) {
        this.bM.event(str);
        this.bM.doNotify();
    }

    public void lock() {
        this.bM.lock();
    }

    public void remove(IOnStorageChange iOnStorageChange) {
        this.bM.remove(iOnStorageChange);
    }

    public void removeLoadedListener(IOnStorageLoaded iOnStorageLoaded) {
        this.bN.remove(iOnStorageLoaded);
    }

    public void unlock() {
        this.bM.unlock();
    }
}
