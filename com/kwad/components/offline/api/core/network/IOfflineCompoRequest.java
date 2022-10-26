package com.kwad.components.offline.api.core.network;

import com.kwad.sdk.api.KsScene;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface IOfflineCompoRequest {
    boolean encryptDisable();

    JSONObject getBody();

    Map getBodyMap();

    Map getHeader();

    String getRequestHost();

    KsScene getScene();

    String getUrl();
}
