package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface cl0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends bl0> void a(@Nullable T t);

    <T extends bl0> void b(@NonNull Object obj, @NonNull el0<T> el0Var);

    void unregister(@NonNull Object obj);
}
