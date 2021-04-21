package com.kwad.sdk.glide.load.engine.c;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.e;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final h f35900a;

    /* renamed from: b  reason: collision with root package name */
    public final e f35901b;

    /* renamed from: c  reason: collision with root package name */
    public final DecodeFormat f35902c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f35903d = new Handler(Looper.getMainLooper());

    public a(h hVar, e eVar, DecodeFormat decodeFormat) {
        this.f35900a = hVar;
        this.f35901b = eVar;
        this.f35902c = decodeFormat;
    }
}
