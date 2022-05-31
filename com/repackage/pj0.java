package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface pj0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends oj0> void a(@Nullable T t);

    <T extends oj0> void b(@NonNull Object obj, @NonNull rj0<T> rj0Var);

    <T extends oj0> void c(@NonNull Object obj, int i, @NonNull rj0<T> rj0Var);

    void unregister(@NonNull Object obj);
}
