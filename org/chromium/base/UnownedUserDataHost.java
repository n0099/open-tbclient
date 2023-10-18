package org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import org.chromium.base.ThreadUtils;
import org.chromium.base.UnownedUserDataHost;
/* loaded from: classes2.dex */
public final class UnownedUserDataHost {
    public Handler mHandler;
    public final ThreadUtils.ThreadChecker mThreadChecker;
    public HashMap<UnownedUserDataKey<?>, WeakReference<? extends UnownedUserData>> mUnownedUserDataMap;

    public UnownedUserDataHost() {
        this(new Handler(retrieveNonNullLooperOrThrow()));
    }

    public static Looper retrieveNonNullLooperOrThrow() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return myLooper;
        }
        throw new IllegalStateException();
    }

    @VisibleForTesting(otherwise = 5)
    public int getMapSize() {
        this.mThreadChecker.assertOnValidThreadAndState();
        return this.mUnownedUserDataMap.size();
    }

    public boolean isDestroyed() {
        if (this.mUnownedUserDataMap == null) {
            return true;
        }
        return false;
    }

    @VisibleForTesting(otherwise = 2)
    public UnownedUserDataHost(Handler handler) {
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mUnownedUserDataMap = new HashMap<>();
        this.mHandler = handler;
    }

    public /* synthetic */ void a(UnownedUserData unownedUserData) {
        unownedUserData.onDetachedFromHost(this);
    }

    @Nullable
    public <T extends UnownedUserData> T get(@NonNull UnownedUserDataKey<T> unownedUserDataKey) {
        this.mThreadChecker.assertOnValidThreadAndState();
        WeakReference<? extends UnownedUserData> weakReference = this.mUnownedUserDataMap.get(unownedUserDataKey);
        if (weakReference == null) {
            return null;
        }
        UnownedUserData unownedUserData = weakReference.get();
        if (unownedUserData == null) {
            unownedUserDataKey.detachFromHost(this);
            return null;
        }
        return unownedUserDataKey.getValueClass().cast(unownedUserData);
    }

    public <T extends UnownedUserData> void remove(@NonNull UnownedUserDataKey<T> unownedUserDataKey) {
        final UnownedUserData unownedUserData;
        this.mThreadChecker.assertOnValidThreadAndState();
        WeakReference<? extends UnownedUserData> remove = this.mUnownedUserDataMap.remove(unownedUserDataKey);
        if (remove != null && (unownedUserData = remove.get()) != null && unownedUserData.informOnDetachmentFromHost()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.l4c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        UnownedUserDataHost.this.a(unownedUserData);
                    }
                }
            });
        }
    }

    public void destroy() {
        this.mThreadChecker.assertOnValidThread();
        if (isDestroyed()) {
            return;
        }
        for (UnownedUserDataKey unownedUserDataKey : new HashSet(this.mUnownedUserDataMap.keySet())) {
            unownedUserDataKey.detachFromHost(this);
        }
        this.mUnownedUserDataMap = null;
        this.mHandler = null;
        this.mThreadChecker.destroy();
    }

    public <T extends UnownedUserData> void set(@NonNull UnownedUserDataKey<T> unownedUserDataKey, @NonNull T t) {
        this.mThreadChecker.assertOnValidThreadAndState();
        if (this.mUnownedUserDataMap.containsKey(unownedUserDataKey) && !t.equals(get(unownedUserDataKey))) {
            unownedUserDataKey.detachFromHost(this);
        }
        this.mUnownedUserDataMap.put(unownedUserDataKey, new WeakReference<>(t));
    }
}
