package org.chromium.base;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class DiscardableReferencePool {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Set<DiscardableReference<?>> mPool = Collections.newSetFromMap(new WeakHashMap());

    /* loaded from: classes2.dex */
    public static class DiscardableReference<T> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        @Nullable
        public T mPayload;

        public DiscardableReference(T t) {
            this.mPayload = t;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void discard() {
            this.mPayload = null;
        }

        @Nullable
        public T get() {
            return this.mPayload;
        }
    }

    public void drain() {
        for (DiscardableReference<?> discardableReference : this.mPool) {
            discardableReference.discard();
        }
        this.mPool.clear();
    }

    public <T> DiscardableReference<T> put(T t) {
        DiscardableReference<T> discardableReference = new DiscardableReference<>(t);
        this.mPool.add(discardableReference);
        return discardableReference;
    }

    public void remove(DiscardableReference<?> discardableReference) {
        if (this.mPool.contains(discardableReference)) {
            discardableReference.discard();
            this.mPool.remove(discardableReference);
        }
    }
}
