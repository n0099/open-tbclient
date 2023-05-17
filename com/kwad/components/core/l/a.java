package com.kwad.components.core.l;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class a implements SpeedLimitApi {
    @Override // com.kwad.sdk.api.core.SpeedLimitApi
    public InputStream wrapInputStream(InputStream inputStream) {
        b.or();
        return b.wrapInputStream(inputStream);
    }
}
