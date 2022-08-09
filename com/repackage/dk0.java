package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface dk0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends ck0> void a(@Nullable T t);

    <T extends ck0> void b(@NonNull Object obj, @NonNull fk0<T> fk0Var);

    <T extends ck0> void c(@NonNull Object obj, int i, @NonNull fk0<T> fk0Var);

    void unregister(@NonNull Object obj);
}
