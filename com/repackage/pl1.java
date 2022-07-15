package com.repackage;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public interface pl1 {
    String a();

    @AnyThread
    void b(@NonNull String str, @NonNull Set<String> set, @NonNull SubscribeHelper.i iVar);

    void c(@NonNull String str, bd2 bd2Var);

    void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, bd2 bd2Var);

    void e(String str, dt2 dt2Var);
}
