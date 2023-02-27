package com.facebook.common.soloader;
/* loaded from: classes7.dex */
public class SoLoaderProxy {
    public static volatile Loader sLoader = new DefaultLoader();

    /* loaded from: classes7.dex */
    public interface Loader {
        void loadLibrary(String str);
    }

    /* loaded from: classes7.dex */
    public static class DefaultLoader implements Loader {
        @Override // com.facebook.common.soloader.SoLoaderProxy.Loader
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
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
