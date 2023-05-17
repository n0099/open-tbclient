package com.kwad.components.offline.api.core.network;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface IOfflineCompoRequest {
    boolean encryptDisable();

    JSONObject getBody();

    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getRequestHost();

    @Nullable
    KsScene getScene();

    String getUrl();
}
