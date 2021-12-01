package com.kuaishou.tachikoma.api.page;

import androidx.annotation.Nullable;
import com.kwad.v8.V8Function;
@Deprecated
/* loaded from: classes2.dex */
public interface IBaseBridge {
    Object invoke(String str, @Nullable String str2, @Nullable V8Function v8Function);

    Object invoke(String str, String str2, @Nullable String str3, @Nullable V8Function v8Function);
}
