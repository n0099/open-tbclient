package com.kwad.components.offline.api.core.api;

import java.io.File;
/* loaded from: classes8.dex */
public interface IEncrypt {
    String getFileMD5(File file);

    byte[] getFileMD5Digest(File file);

    String getResponseData(String str);
}
