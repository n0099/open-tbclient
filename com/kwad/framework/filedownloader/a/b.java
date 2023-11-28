package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public interface b {
    String aW(String str);

    void addHeader(String str, String str2);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    Map<String, List<String>> uS();

    Map<String, List<String>> uT();

    void uU();
}
