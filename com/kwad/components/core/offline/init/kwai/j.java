package com.kwad.components.core.offline.init.kwai;

import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.bk;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes8.dex */
public final class j implements IZipper {
    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(InputStream inputStream, String str) {
        return bk.unZip(inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return bk.zip(file, file2);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        bk.zipFile(file);
    }
}
