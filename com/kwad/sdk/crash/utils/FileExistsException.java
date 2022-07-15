package com.kwad.sdk.crash.utils;

import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class FileExistsException extends IOException {
    public static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(File file) {
        super("File " + file + " already exists");
    }

    public FileExistsException(String str) {
        super(str);
    }
}
