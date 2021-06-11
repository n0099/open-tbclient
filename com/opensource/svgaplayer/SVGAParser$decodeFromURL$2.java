package com.opensource.svgaplayer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAParser;
import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Ljava/io/InputStream;", "invoke"}, k = 3, mv = {1, 1, 13}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class SVGAParser$decodeFromURL$2 extends Lambda implements Function1<InputStream, Unit> {
    public final /* synthetic */ SVGAParser.b $callback;
    public final /* synthetic */ URL $url;
    public final /* synthetic */ SVGAParser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAParser$decodeFromURL$2(SVGAParser sVGAParser, URL url, SVGAParser.b bVar) {
        super(1);
        this.this$0 = sVGAParser;
        this.$url = url;
        this.$callback = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InputStream inputStream) {
        invoke2(inputStream);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(InputStream inputStream) {
        SVGAParser sVGAParser = this.this$0;
        SVGAParser.p(sVGAParser, inputStream, sVGAParser.l(this.$url), this.$callback, false, 8, null);
    }
}
