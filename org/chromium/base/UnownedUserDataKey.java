package org.chromium.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import org.chromium.base.UnownedUserData;
/* loaded from: classes2.dex */
public final class UnownedUserDataKey<T extends UnownedUserData> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    @NonNull
    public final Class<T> mClazz;
    public final Set<UnownedUserDataHost> mWeakHostAttachments = Collections.newSetFromMap(new WeakHashMap());

    public UnownedUserDataKey(@NonNull Class<T> cls) {
        this.mClazz = cls;
    }

    private void removeHostAttachment(UnownedUserDataHost unownedUserDataHost) {
        unownedUserDataHost.remove(this);
        this.mWeakHostAttachments.remove(unownedUserDataHost);
    }

    public final void detachFromAllHosts(@NonNull T t) {
        assertNoDestroyedAttachments();
        Iterator it = new ArrayList(this.mWeakHostAttachments).iterator();
        while (it.hasNext()) {
            UnownedUserDataHost unownedUserDataHost = (UnownedUserDataHost) it.next();
            if (t.equals(unownedUserDataHost.get(this))) {
                removeHostAttachment(unownedUserDataHost);
            }
        }
    }

    public final void detachFromHost(@NonNull UnownedUserDataHost unownedUserDataHost) {
        assertNoDestroyedAttachments();
        Iterator it = new ArrayList(this.mWeakHostAttachments).iterator();
        while (it.hasNext()) {
            UnownedUserDataHost unownedUserDataHost2 = (UnownedUserDataHost) it.next();
            if (unownedUserDataHost.equals(unownedUserDataHost2)) {
                removeHostAttachment(unownedUserDataHost2);
            }
        }
    }

    @VisibleForTesting(otherwise = 2)
    public int getHostAttachmentCount(@NonNull T t) {
        assertNoDestroyedAttachments();
        int i = 0;
        for (UnownedUserDataHost unownedUserDataHost : this.mWeakHostAttachments) {
            if (t.equals(unownedUserDataHost.get(this))) {
                i++;
            }
        }
        return i;
    }

    public final boolean isAttachedToAnyHost(@NonNull T t) {
        if (getHostAttachmentCount(t) > 0) {
            return true;
        }
        return false;
    }

    public final boolean isAttachedToHost(@NonNull UnownedUserDataHost unownedUserDataHost) {
        if (retrieveDataFromHost(unownedUserDataHost) != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final T retrieveDataFromHost(@NonNull UnownedUserDataHost unownedUserDataHost) {
        assertNoDestroyedAttachments();
        for (UnownedUserDataHost unownedUserDataHost2 : this.mWeakHostAttachments) {
            if (unownedUserDataHost.equals(unownedUserDataHost2)) {
                return (T) unownedUserDataHost.get(this);
            }
        }
        return null;
    }

    private void assertNoDestroyedAttachments() {
        if (BuildConfig.DCHECK_IS_ON) {
            for (UnownedUserDataHost unownedUserDataHost : this.mWeakHostAttachments) {
                if (unownedUserDataHost.isDestroyed()) {
                    throw new IllegalStateException();
                }
            }
        }
    }

    @NonNull
    public final Class<T> getValueClass() {
        return this.mClazz;
    }

    public final void attachToHost(@NonNull UnownedUserDataHost unownedUserDataHost, @NonNull T t) {
        Objects.requireNonNull(t);
        unownedUserDataHost.set(this, t);
        if (!isAttachedToHost(unownedUserDataHost)) {
            this.mWeakHostAttachments.add(unownedUserDataHost);
        }
    }
}
