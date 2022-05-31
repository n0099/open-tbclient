package com.repackage;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public interface pk1 {
    String a();

    @AnyThread
    void b(@NonNull String str, @NonNull Set<String> set, @NonNull SubscribeHelper.i iVar);

    void c(@NonNull String str, bc2 bc2Var);

    void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, bc2 bc2Var);

    void e(String str, ds2 ds2Var);
}
