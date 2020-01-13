package com.tb.airbnb.lottie.network;

import com.tb.airbnb.lottie.c;
/* loaded from: classes5.dex */
public enum FileExtension {
    Json(".json"),
    Zip(".zip");
    
    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }

    public static FileExtension forFile(String str) {
        FileExtension[] values;
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        c.warn("Unable to find correct extension for " + str);
        return Json;
    }
}
