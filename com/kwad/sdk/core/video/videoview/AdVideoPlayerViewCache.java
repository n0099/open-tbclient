package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AdVideoPlayerViewCache {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, WeakReference<b>> f9458a;

    /* loaded from: classes4.dex */
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
        this.f9458a = new HashMap<>(1);
    }

    public static AdVideoPlayerViewCache a() {
        return Holder.INSTANCE.getInstance();
    }

    public void a(String str) {
        this.f9458a.remove(str);
    }

    public void a(String str, b bVar) {
        this.f9458a.put(str, new WeakReference<>(bVar));
    }

    public b b(String str) {
        WeakReference<b> weakReference = this.f9458a.get(str);
        if (weakReference != null) {
            b bVar = weakReference.get();
            if (bVar != null) {
                return bVar;
            }
            this.f9458a.remove(str);
            return null;
        }
        return null;
    }
}
