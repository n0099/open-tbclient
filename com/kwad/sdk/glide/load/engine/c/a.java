package com.kwad.sdk.glide.load.engine.c;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.e;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final h f6751a;
    private final e b;
    private final DecodeFormat c;
    private final Handler d = new Handler(Looper.getMainLooper());

    public a(h hVar, e eVar, DecodeFormat decodeFormat) {
        this.f6751a = hVar;
        this.b = eVar;
        this.c = decodeFormat;
    }
}
