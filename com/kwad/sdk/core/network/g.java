package com.kwad.sdk.core.network;

import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface g {
    JSONObject getBody();

    Map getBodyMap();

    Map getHeader();

    SceneImpl getScene();

    String getUrl();
}
