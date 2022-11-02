package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class AdVideoPlayerViewCache {
    public HashMap<String, WeakReference<a>> ya;

    /* loaded from: classes8.dex */
    public enum Holder {
        INSTANCE;
        
        public AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache((byte) 0);

        Holder() {
        }

        public final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    public AdVideoPlayerViewCache() {
        this.ya = new HashMap<>(1);
    }

    public /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str, a aVar) {
        this.ya.put(str, new WeakReference<>(aVar));
    }

    public final a cw(String str) {
        WeakReference<a> weakReference = this.ya.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.ya.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.ya.remove(str);
    }
}
