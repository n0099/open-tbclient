package com.repackage;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public interface cm1 {
    String a();

    @AnyThread
    void b(@NonNull String str, @NonNull Set<String> set, @NonNull SubscribeHelper.i iVar);

    void c(@NonNull String str, od2 od2Var);

    void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, od2 od2Var);

    void e(String str, qt2 qt2Var);
}
