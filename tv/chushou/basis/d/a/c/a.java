package tv.chushou.basis.d.a.c;

import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public interface a<T> {
    void onFailure(int i, @Nullable String str, @Nullable Throwable th);

    void onStart();

    void onSuccess(T t);
}
