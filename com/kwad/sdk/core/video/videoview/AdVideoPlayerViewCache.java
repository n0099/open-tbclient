package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class AdVideoPlayerViewCache {
    public HashMap<String, WeakReference<a>> a;

    /* loaded from: classes5.dex */
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
        this.a = new HashMap<>(1);
    }

    public /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    public static AdVideoPlayerViewCache a() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str) {
        this.a.remove(str);
    }

    public final void a(String str, a aVar) {
        this.a.put(str, new WeakReference<>(aVar));
    }

    public final a b(String str) {
        WeakReference<a> weakReference = this.a.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.a.remove(str);
        }
        return null;
    }
}
