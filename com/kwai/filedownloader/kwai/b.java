package com.kwai.filedownloader.kwai;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public interface b {
    Map<String, List<String>> U();

    Map<String, List<String>> V();

    void W();

    void addHeader(String str, String str2);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    String p(String str);
}
