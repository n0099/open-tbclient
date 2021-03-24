package org.webrtc;
/* loaded from: classes7.dex */
public class NativeLibrary {
    public static String TAG = "NativeLibrary";
    public static boolean libraryLoaded = false;
    public static Object lock = new Object();

    /* loaded from: classes7.dex */
    public static class DefaultLoader implements NativeLibraryLoader {
        @Override // org.webrtc.NativeLibraryLoader
        public boolean load(String str) {
            String str2 = NativeLibrary.TAG;
            Logging.d(str2, "Loading library: " + str);
            try {
                System.loadLibrary(str);
                return true;
            } catch (UnsatisfiedLinkError e2) {
                String str3 = NativeLibrary.TAG;
                Logging.e(str3, "Failed to load native library: " + str, e2);
                Logging.e(NativeLibrary.TAG, "force treat as OK.", e2);
                return true;
            }
        }
    }

    public static void initialize(NativeLibraryLoader nativeLibraryLoader, String str) {
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

    public static boolean isLoaded() {
        boolean z;
        synchronized (lock) {
            z = libraryLoaded;
        }
        return z;
    }
}
