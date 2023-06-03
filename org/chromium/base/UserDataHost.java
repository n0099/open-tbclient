package org.chromium.base;

import android.os.Process;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class UserDataHost {
    public final long mThreadId = Process.myTid();
    public HashMap<Class<? extends UserData>, UserData> mUserDataMap = new HashMap<>();

    private void checkThreadAndState() {
        if (this.mThreadId == Process.myTid()) {
            if (this.mUserDataMap != null) {
                return;
            }
            throw new IllegalStateException("Operation is not allowed after destroy().");
        }
        throw new IllegalStateException("UserData must only be used on a single thread.");
    }

    public void destroy() {
        checkThreadAndState();
        HashMap<Class<? extends UserData>, UserData> hashMap = this.mUserDataMap;
        this.mUserDataMap = null;
        for (UserData userData : hashMap.values()) {
            userData.destroy();
        }
    }

    public static void checkArgument(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Neither key nor object of UserDataHost can be null.");
    }

    public <T extends UserData> T getUserData(Class<T> cls) {
        boolean z;
        checkThreadAndState();
        if (cls != null) {
            z = true;
        } else {
            z = false;
        }
        checkArgument(z);
        return cls.cast(this.mUserDataMap.get(cls));
    }

    public <T extends UserData> T removeUserData(Class<T> cls) {
        boolean z;
        checkThreadAndState();
        if (cls != null) {
            z = true;
        } else {
            z = false;
        }
        checkArgument(z);
        if (this.mUserDataMap.containsKey(cls)) {
            return cls.cast(this.mUserDataMap.remove(cls));
        }
        throw new IllegalStateException("UserData for the key is not present.");
    }

    public <T extends UserData> T setUserData(Class<T> cls, T t) {
        boolean z;
        checkThreadAndState();
        if (cls != null && t != null) {
            z = true;
        } else {
            z = false;
        }
        checkArgument(z);
        this.mUserDataMap.put(cls, t);
        return (T) getUserData(cls);
    }
}
