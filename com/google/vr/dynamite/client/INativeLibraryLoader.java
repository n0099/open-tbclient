package com.google.vr.dynamite.client;

import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes14.dex */
public interface INativeLibraryLoader extends IInterface {
    int checkVersion(String str) throws RemoteException;

    long initializeAndLoadNativeLibrary(String str) throws RemoteException;
}
