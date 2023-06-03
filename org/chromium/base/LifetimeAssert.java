package org.chromium.base;

import androidx.annotation.VisibleForTesting;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.chromium.base.annotations.CheckDiscard;
@CheckDiscard("Lifetime assertions aren't used when DCHECK is off.")
/* loaded from: classes2.dex */
public class LifetimeAssert {
    public static TestHook sTestHook;
    public final Object mTarget;
    @VisibleForTesting
    public final WrappedReference mWrapper;

    /* loaded from: classes2.dex */
    public interface TestHook {
        void onCleaned(WrappedReference wrappedReference, String str);
    }

    /* loaded from: classes2.dex */
    public static class CreationException extends RuntimeException {
        public CreationException() {
            super("vvv This is where object was created. vvv");
        }
    }

    /* loaded from: classes2.dex */
    public static class LifetimeAssertException extends RuntimeException {
        public LifetimeAssertException(String str, Throwable th) {
            super(str, th);
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static class WrappedReference extends PhantomReference<Object> {
        public final CreationException mCreationException;
        public boolean mSafeToGc;
        public final Class<?> mTargetClass;
        public static ReferenceQueue<Object> sReferenceQueue = new ReferenceQueue<>();
        public static Set<WrappedReference> sActiveWrappers = Collections.synchronizedSet(new HashSet());

        static {
            new Thread("GcStateAssertQueue") { // from class: org.chromium.base.LifetimeAssert.WrappedReference.1
                {
                    setDaemon(true);
                    start();
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    WrappedReference wrappedReference;
                    String format;
                    while (true) {
                        try {
                            wrappedReference = (WrappedReference) WrappedReference.sReferenceQueue.remove();
                            WrappedReference.sActiveWrappers.remove(wrappedReference);
                            if (!wrappedReference.mSafeToGc) {
                                format = String.format("Object of type %s was GC'ed without cleanup. Refer to \"Caused by\" for where object was created.", wrappedReference.mTargetClass.getName());
                                if (LifetimeAssert.sTestHook == null) {
                                    break;
                                }
                                LifetimeAssert.sTestHook.onCleaned(wrappedReference, format);
                            } else if (LifetimeAssert.sTestHook != null) {
                                LifetimeAssert.sTestHook.onCleaned(wrappedReference, null);
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    throw new LifetimeAssertException(format, wrappedReference.mCreationException);
                }
            };
        }

        public WrappedReference(Object obj, CreationException creationException, boolean z) {
            super(obj, sReferenceQueue);
            this.mCreationException = creationException;
            this.mSafeToGc = z;
            this.mTargetClass = obj.getClass();
            sActiveWrappers.add(this);
        }
    }

    public LifetimeAssert(WrappedReference wrappedReference, Object obj) {
        this.mWrapper = wrappedReference;
        this.mTarget = obj;
    }

    public static LifetimeAssert create(Object obj, boolean z) {
        if (!BuildConfig.DCHECK_IS_ON) {
            return null;
        }
        return new LifetimeAssert(new WrappedReference(obj, new CreationException(), z), obj);
    }

    public static void setSafeToGc(LifetimeAssert lifetimeAssert, boolean z) {
        if (BuildConfig.DCHECK_IS_ON) {
            synchronized (lifetimeAssert.mTarget) {
                lifetimeAssert.mWrapper.mSafeToGc = z;
            }
        }
    }

    public static void assertAllInstancesDestroyedForTesting() throws LifetimeAssertException {
        if (BuildConfig.DCHECK_IS_ON) {
            synchronized (WrappedReference.sActiveWrappers) {
                for (WrappedReference wrappedReference : WrappedReference.sActiveWrappers) {
                    if (!wrappedReference.mSafeToGc) {
                        throw new LifetimeAssertException(String.format("Object of type %s was not destroyed after test completed. Refer to \"Caused by\" for where object was created.", wrappedReference.mTargetClass.getName()), wrappedReference.mCreationException);
                    }
                }
            }
        }
    }

    public static LifetimeAssert create(Object obj) {
        if (!BuildConfig.DCHECK_IS_ON) {
            return null;
        }
        return new LifetimeAssert(new WrappedReference(obj, new CreationException(), false), obj);
    }
}
