package com.google.android.exoplayer2.util;
/* loaded from: classes9.dex */
public final class LibraryLoader {
    public boolean isAvailable;
    public boolean loadAttempted;
    public String[] nativeLibraries;

    public LibraryLoader(String... strArr) {
        this.nativeLibraries = strArr;
    }

    public synchronized void setLibraries(String... strArr) {
        boolean z;
        if (!this.loadAttempted) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z, "Cannot set libraries after loading");
        this.nativeLibraries = strArr;
    }

    public synchronized boolean isAvailable() {
        if (this.loadAttempted) {
            return this.isAvailable;
        }
        this.loadAttempted = true;
        try {
            for (String str : this.nativeLibraries) {
                System.loadLibrary(str);
            }
            this.isAvailable = true;
        } catch (UnsatisfiedLinkError unused) {
        }
        return this.isAvailable;
    }
}
