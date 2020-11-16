package org.webrtc;
/* loaded from: classes16.dex */
class NativeLibrary {
    private static String TAG = "NativeLibrary";
    private static boolean libraryLoaded;
    private static Object lock = new Object();

    /* loaded from: classes16.dex */
    static class DefaultLoader implements NativeLibraryLoader {
        @Override // org.webrtc.NativeLibraryLoader
        public boolean load(String str) {
            String str2 = NativeLibrary.TAG;
            Logging.d(str2, "Loading library: " + str);
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e) {
                String str3 = NativeLibrary.TAG;
                Logging.e(str3, "Failed to load native library: " + str, e);
                Logging.e(NativeLibrary.TAG, "force treat as OK.", e);
            }
            return true;
        }
    }

    NativeLibrary() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initialize(NativeLibraryLoader nativeLibraryLoader, String str) {
        Object obj = lock;
        synchronized (lock) {
            if (libraryLoaded) {
                Logging.d(TAG, "Native library has already been loaded.");
            } else {
                String str2 = TAG;
                Logging.d(str2, "Loading native library: " + str);
                libraryLoaded = nativeLibraryLoader.load(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLoaded() {
        boolean z;
        Object obj = lock;
        synchronized (lock) {
            z = libraryLoaded;
        }
        return z;
    }
}
