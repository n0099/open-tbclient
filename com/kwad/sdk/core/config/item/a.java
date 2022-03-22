package com.kwad.sdk.core.config.item;

import androidx.annotation.Nullable;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
/* loaded from: classes7.dex */
public abstract class a<T> extends b<T> {
    public a(String str, T t) {
        super(str, t);
    }

    @Override // com.kwad.sdk.core.config.item.b
    @Nullable
    public T a() {
        DevelopMangerPlugin.DevelopValue a = (!com.kwad.sdk.b.f39154c.booleanValue() || com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class) == null) ? null : ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a(b());
        return a != null ? (T) a.getValue() : (T) super.a();
    }
}
