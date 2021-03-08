package com.kwad.sdk.glide;

import com.kwad.sdk.glide.h;
/* loaded from: classes3.dex */
public abstract class h<CHILD extends h<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private com.kwad.sdk.glide.request.b.c<? super TranscodeType> f6639a = com.kwad.sdk.glide.request.b.a.a();

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.kwad.sdk.glide.request.b.c<? super TranscodeType> b() {
        return this.f6639a;
    }
}
