package io.reactivex.disposables;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.reactivex.annotations.NonNull;
/* loaded from: classes7.dex */
public final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    public static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@NonNull Runnable runnable) {
        runnable.run();
    }
}
