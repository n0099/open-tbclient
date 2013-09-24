package com.tencent.mm.sdk.storage;

import android.os.Looper;
/* loaded from: classes.dex */
public abstract class MStorage {
    private final MStorageEvent<IOnStorageChange, String> bM = new MStorageEvent<IOnStorageChange, String>() { // from class: com.tencent.mm.sdk.storage.MStorage.1
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        protected /* synthetic */ void processEvent(IOnStorageChange iOnStorageChange, String str) {
            MStorage mStorage = MStorage.this;
            iOnStorageChange.onNotifyChange(str);
        }
    };
    private final MStorageEvent<IOnStorageLoaded, String> bN = new MStorageEvent<IOnStorageLoaded, String>() { // from class: com.tencent.mm.sdk.storage.MStorage.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        protected /* synthetic */ void processEvent(IOnStorageLoaded iOnStorageLoaded, String str) {
            MStorage mStorage = MStorage.this;
            iOnStorageLoaded.onNotifyLoaded();
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
