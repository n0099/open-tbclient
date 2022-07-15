package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface gk0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends fk0> void a(@Nullable T t);

    <T extends fk0> void b(@NonNull Object obj, @NonNull ik0<T> ik0Var);

    <T extends fk0> void c(@NonNull Object obj, int i, @NonNull ik0<T> ik0Var);

    void unregister(@NonNull Object obj);
}
