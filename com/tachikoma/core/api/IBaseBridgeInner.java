package com.tachikoma.core.api;

import androidx.annotation.Nullable;
import com.kwad.v8.V8Function;
/* loaded from: classes8.dex */
public interface IBaseBridgeInner {
    Object invoke(String str, @Nullable String str2, @Nullable V8Function v8Function);

    Object invokeM(String str, String str2, @Nullable String str3, @Nullable V8Function v8Function);
}
