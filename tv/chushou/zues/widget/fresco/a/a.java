package tv.chushou.zues.widget.fresco.a;

import com.facebook.cache.common.g;
/* loaded from: classes6.dex */
public class a extends com.facebook.imagepipeline.j.a {
    private static final a pnP = new a();
    private static final com.facebook.cache.common.b pnQ = new g("BlurPostprocessor");

    public static a eus() {
        return pnP;
    }

    private a() {
        super(3, 4);
    }

    @Override // com.facebook.imagepipeline.j.a, com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public com.facebook.cache.common.b edf() {
        return pnQ;
    }
}
