package org.chromium.base;
/* loaded from: classes2.dex */
public class NativeLibraryLoadedStatus {
    public static NativeLibraryLoadedStatusProvider sProvider;

    /* loaded from: classes2.dex */
    public interface NativeLibraryLoadedStatusProvider {
        boolean areMainDexNativeMethodsReady();

        boolean areNativeMethodsReady();
    }

    public static NativeLibraryLoadedStatusProvider getProviderForTesting() {
        return sProvider;
    }

    public static void checkLoaded(boolean z) {
        NativeLibraryLoadedStatusProvider nativeLibraryLoadedStatusProvider;
        boolean areNativeMethodsReady;
        if (!BuildConfig.DCHECK_IS_ON || (nativeLibraryLoadedStatusProvider = sProvider) == null) {
            return;
        }
        if (z) {
            areNativeMethodsReady = nativeLibraryLoadedStatusProvider.areMainDexNativeMethodsReady();
        } else {
            areNativeMethodsReady = nativeLibraryLoadedStatusProvider.areNativeMethodsReady();
        }
        if (areNativeMethodsReady) {
            return;
        }
        throw new JniException("Native method called before the native library was ready.");
    }

    public static void setProvider(NativeLibraryLoadedStatusProvider nativeLibraryLoadedStatusProvider) {
        sProvider = nativeLibraryLoadedStatusProvider;
    }
}
