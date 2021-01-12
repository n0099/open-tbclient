package com.google.vr.dynamite.client;

import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes5.dex */
public interface ILoadedInstanceCreator extends IInterface {
    INativeLibraryLoader newNativeLibraryLoader(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
