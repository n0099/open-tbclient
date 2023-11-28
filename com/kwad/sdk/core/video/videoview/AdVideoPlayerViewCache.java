package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class AdVideoPlayerViewCache {
    public HashMap<String, WeakReference<a>> Ck;

    /* loaded from: classes10.dex */
    public enum Holder {
        INSTANCE;
        
        public AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache((byte) 0);

        public final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }

    public AdVideoPlayerViewCache() {
        this.Ck = new HashMap<>(1);
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    public final a eb(String str) {
        WeakReference<a> weakReference = this.Ck.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.Ck.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.Ck.remove(str);
    }

    public final void a(String str, a aVar) {
        this.Ck.put(str, new WeakReference<>(aVar));
    }
}
