package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface tj0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends sj0> void a(@Nullable T t);

    <T extends sj0> void b(@NonNull Object obj, @NonNull vj0<T> vj0Var);

    <T extends sj0> void c(@NonNull Object obj, int i, @NonNull vj0<T> vj0Var);

    void unregister(@NonNull Object obj);
}
