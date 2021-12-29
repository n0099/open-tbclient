package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdVideoPlayerViewCache {
    public HashMap<String, WeakReference<b>> a;

    /* loaded from: classes3.dex */
    public enum Holder {
        INSTANCE;
        
        public AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache();

        Holder() {
        }

        public AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    public AdVideoPlayerViewCache() {
        this.a = new HashMap<>(1);
    }

    public static AdVideoPlayerViewCache a() {
        return Holder.INSTANCE.getInstance();
    }

    public void a(String str) {
        this.a.remove(str);
    }

    public void a(String str, b bVar) {
        this.a.put(str, new WeakReference<>(bVar));
    }

    public b b(String str) {
        WeakReference<b> weakReference = this.a.get(str);
        if (weakReference != null) {
            b bVar = weakReference.get();
            if (bVar != null) {
                return bVar;
            }
            this.a.remove(str);
        }
        return null;
    }
}
