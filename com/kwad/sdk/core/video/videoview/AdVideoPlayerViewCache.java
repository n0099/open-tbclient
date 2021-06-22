package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class AdVideoPlayerViewCache {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, WeakReference<b>> f34864a;

    /* loaded from: classes7.dex */
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
        this.f34864a = new HashMap<>(1);
    }

    public static AdVideoPlayerViewCache a() {
        return Holder.INSTANCE.getInstance();
    }

    public void a(String str) {
        this.f34864a.remove(str);
    }

    public void a(String str, b bVar) {
        this.f34864a.put(str, new WeakReference<>(bVar));
    }

    public b b(String str) {
        WeakReference<b> weakReference = this.f34864a.get(str);
        if (weakReference != null) {
            b bVar = weakReference.get();
            if (bVar != null) {
                return bVar;
            }
            this.f34864a.remove(str);
        }
        return null;
    }
}
