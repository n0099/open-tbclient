package com.opensource.svgaplayer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.d;
import java.io.InputStream;
import java.net.URL;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import kotlin.l;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes.dex */
public final class SVGAParser$decodeFromURL$2 extends Lambda implements kotlin.jvm.a.b<InputStream, l> {
    final /* synthetic */ d.c $callback;
    final /* synthetic */ URL $url;
    final /* synthetic */ d this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAParser$decodeFromURL$2(d dVar, URL url, d.c cVar) {
        super(1);
        this.this$0 = dVar;
        this.$url = url;
        this.$callback = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ l invoke(InputStream inputStream) {
        invoke2(inputStream);
        return l.nse;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(InputStream inputStream) {
        q.m(inputStream, AdvanceSetting.NETWORK_TYPE);
        d.a(this.this$0, inputStream, this.this$0.d(this.$url), this.$callback, false, 8, null);
    }
}
