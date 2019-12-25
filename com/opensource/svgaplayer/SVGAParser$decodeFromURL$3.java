package com.opensource.svgaplayer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class SVGAParser$decodeFromURL$3 extends Lambda implements kotlin.jvm.a.b<Exception, kotlin.g> {
    final /* synthetic */ d.c $callback;
    final /* synthetic */ d this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAParser$decodeFromURL$3(d dVar, d.c cVar) {
        super(1);
        this.this$0 = dVar;
        this.$callback = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ kotlin.g invoke(Exception exc) {
        invoke2(exc);
        return kotlin.g.mYA;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Exception exc) {
        p.j(exc, AdvanceSetting.NETWORK_TYPE);
        this.this$0.a(exc, this.$callback);
    }
}
