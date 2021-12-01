package com.google.vr.dynamite.client;

import android.os.IInterface;
/* loaded from: classes2.dex */
public interface INativeLibraryLoader extends IInterface {
    int checkVersion(String str);

    long initializeAndLoadNativeLibrary(String str);
}
