package com.facebook.common.soloader;
/* loaded from: classes6.dex */
public class SoLoaderProxy {
    public static volatile Loader sLoader = new DefaultLoader();

    /* loaded from: classes6.dex */
    public static class DefaultLoader implements Loader {
        @Override // com.facebook.common.soloader.SoLoaderProxy.Loader
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    /* loaded from: classes6.dex */
    public interface Loader {
        void loadLibrary(String str);
    }

    public static void loadLibrary(String str) {
        sLoader.loadLibrary(str);
    }

    public static void setLoader(Loader loader) {
        if (loader != null) {
            sLoader = loader;
            return;
        }
        throw new NullPointerException("Loader cannot be null");
    }
}
