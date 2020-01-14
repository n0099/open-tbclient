package tv.chushou.zues.widget.fresco.a;

import com.facebook.cache.common.g;
/* loaded from: classes4.dex */
public class a extends com.facebook.imagepipeline.j.a {
    private static final a nXs = new a();
    private static final com.facebook.cache.common.b nXt = new g("BlurPostprocessor");

    public static a dPt() {
        return nXs;
    }

    private a() {
        super(3, 4);
    }

    @Override // com.facebook.imagepipeline.j.a, com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public com.facebook.cache.common.b dqi() {
        return nXt;
    }
}
