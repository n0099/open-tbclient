package com.repackage;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public interface rl1 {
    String a();

    @AnyThread
    void b(@NonNull String str, @NonNull Set<String> set, @NonNull SubscribeHelper.i iVar);

    void c(@NonNull String str, dd2 dd2Var);

    void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, dd2 dd2Var);

    void e(String str, ft2 ft2Var);
}
