package com.facebook.soloader;

import android.util.Log;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public abstract class NativeLibrary {
    public static final String TAG = "com.facebook.soloader.NativeLibrary";
    @Nullable
    public List<String> mLibraryNames;
    public final Object mLock = new Object();
    public Boolean mLoadLibraries = Boolean.TRUE;
    public boolean mLibrariesLoaded = false;
    @Nullable
    public volatile UnsatisfiedLinkError mLinkError = null;

    public void initialNativeCheck() throws UnsatisfiedLinkError {
    }

    public NativeLibrary(List<String> list) {
        this.mLibraryNames = list;
    }

    public void ensureLoaded() throws UnsatisfiedLinkError {
        if (loadLibraries()) {
            return;
        }
        throw this.mLinkError;
    }

    @Nullable
    public UnsatisfiedLinkError getError() {
        return this.mLinkError;
    }

    @Nullable
    public boolean loadLibraries() {
        synchronized (this.mLock) {
            if (!this.mLoadLibraries.booleanValue()) {
                return this.mLibrariesLoaded;
            }
            try {
                if (this.mLibraryNames != null) {
                    for (String str : this.mLibraryNames) {
                        SoLoader.loadLibrary(str);
                    }
                }
                initialNativeCheck();
                this.mLibrariesLoaded = true;
                this.mLibraryNames = null;
            } catch (UnsatisfiedLinkError e) {
                Log.e(TAG, "Failed to load native lib (initial check): ", e);
                this.mLinkError = e;
                this.mLibrariesLoaded = false;
            }
            this.mLoadLibraries = Boolean.FALSE;
            return this.mLibrariesLoaded;
        }
    }
}
