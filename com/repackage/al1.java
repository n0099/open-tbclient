package com.repackage;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public interface al1 {
    String a();

    @AnyThread
    void b(@NonNull String str, @NonNull Set<String> set, @NonNull SubscribeHelper.i iVar);

    void c(@NonNull String str, mc2 mc2Var);

    void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, mc2 mc2Var);

    void e(String str, os2 os2Var);
}
