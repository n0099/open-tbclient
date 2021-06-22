package com.kwad.sdk.glide;

import com.kwad.sdk.glide.h;
/* loaded from: classes7.dex */
public abstract class h<CHILD extends h<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.glide.request.b.c<? super TranscodeType> f36013a = com.kwad.sdk.glide.request.b.a.a();

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final com.kwad.sdk.glide.request.b.c<? super TranscodeType> b() {
        return this.f36013a;
    }
}
