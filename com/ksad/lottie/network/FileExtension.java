package com.ksad.lottie.network;

import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.ksad.lottie.c;
/* loaded from: classes6.dex */
public enum FileExtension {
    Json(".json"),
    Zip(".zip");
    
    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        FileExtension[] values;
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        c.b("Unable to find correct extension for " + str);
        return Json;
    }

    public String tempExtension() {
        return XAdSimpleImageLoader.TEMP_SUFFIX + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
