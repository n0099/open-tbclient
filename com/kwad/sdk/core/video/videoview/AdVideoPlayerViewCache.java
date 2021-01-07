package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class AdVideoPlayerViewCache {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, WeakReference<b>> f9758a;

    /* loaded from: classes5.dex */
    private enum Holder {
        INSTANCE;
        
        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache();

        Holder() {
        }

        AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    private AdVideoPlayerViewCache() {
        this.f9758a = new HashMap<>(1);
    }

    public static AdVideoPlayerViewCache a() {
        return Holder.INSTANCE.getInstance();
    }

    public void a(String str) {
        this.f9758a.remove(str);
    }

    public void a(String str, b bVar) {
        this.f9758a.put(str, new WeakReference<>(bVar));
    }

    public b b(String str) {
        WeakReference<b> weakReference = this.f9758a.get(str);
        if (weakReference != null) {
            b bVar = weakReference.get();
            if (bVar != null) {
                return bVar;
            }
            this.f9758a.remove(str);
            return null;
        }
        return null;
    }
}
