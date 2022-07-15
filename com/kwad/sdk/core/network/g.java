package com.kwad.sdk.core.network;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface g {
    JSONObject getBody();

    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getUrl();
}
