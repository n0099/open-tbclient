package tv.chushou.zues.widget.fresco.a;

import com.facebook.cache.common.g;
/* loaded from: classes5.dex */
public class a extends com.facebook.imagepipeline.j.a {
    private static final a nue = new a();
    private static final com.facebook.cache.common.b nuf = new g("BlurPostprocessor");

    public static a dKh() {
        return nue;
    }

    private a() {
        super(3, 4);
    }

    @Override // com.facebook.imagepipeline.j.a, com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public com.facebook.cache.common.b dtP() {
        return nuf;
    }
}
