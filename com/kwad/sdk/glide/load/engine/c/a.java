package com.kwad.sdk.glide.load.engine.c;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.e;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final h f36301a;

    /* renamed from: b  reason: collision with root package name */
    public final e f36302b;

    /* renamed from: c  reason: collision with root package name */
    public final DecodeFormat f36303c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f36304d = new Handler(Looper.getMainLooper());

    public a(h hVar, e eVar, DecodeFormat decodeFormat) {
        this.f36301a = hVar;
        this.f36302b = eVar;
        this.f36303c = decodeFormat;
    }
}
