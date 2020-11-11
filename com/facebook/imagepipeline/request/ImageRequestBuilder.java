package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c oUX;
    private Uri pai = null;
    private ImageRequest.RequestLevel oYf = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d oTD = null;
    @Nullable
    private e oTE = null;
    private com.facebook.imagepipeline.common.b oTF = com.facebook.imagepipeline.common.b.enL();
    private ImageRequest.CacheChoice pah = ImageRequest.CacheChoice.DEFAULT;
    private boolean oVG = h.eon().eoH();
    private boolean pak = false;
    private Priority pal = Priority.HIGH;
    @Nullable
    private b oZy = null;
    private boolean oVB = true;
    private boolean pap = true;
    @Nullable
    private com.facebook.imagepipeline.common.a oWW = null;
    private Map<String, String> pan = null;
    private String mTag = null;
    private String pao = null;

    public static ImageRequestBuilder ad(Uri uri) {
        return new ImageRequestBuilder().ae(uri);
    }

    public static ImageRequestBuilder PQ(int i) {
        return ad(com.facebook.common.util.d.Ot(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ad(imageRequest.erN()).a(imageRequest.erR()).d(imageRequest.epZ()).a(imageRequest.erM()).At(imageRequest.erT()).a(imageRequest.eqX()).a(imageRequest.erV()).As(imageRequest.erS()).b(imageRequest.eqZ()).c(imageRequest.erP()).c(imageRequest.ekY()).a(imageRequest.erQ()).c(imageRequest.ekY()).I(imageRequest.erm()).Ys(imageRequest.mTag).Yt(imageRequest.pao);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> erm() {
        return this.pan;
    }

    public ImageRequestBuilder I(Map<String, String> map) {
        this.pan = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Ys(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pao;
    }

    public ImageRequestBuilder Yt(String str) {
        this.pao = str;
        return this;
    }

    public ImageRequestBuilder ae(Uri uri) {
        g.checkNotNull(uri);
        this.pai = uri;
        return this;
    }

    public Uri erN() {
        return this.pai;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.oYf = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel eqX() {
        return this.oYf;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.oTD = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d erP() {
        return this.oTD;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.oTE = eVar;
        return this;
    }

    @Nullable
    public e erQ() {
        return this.oTE;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.oWW = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a epZ() {
        return this.oWW;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.oTF = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b erR() {
        return this.oTF;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pah = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice erM() {
        return this.pah;
    }

    public ImageRequestBuilder As(boolean z) {
        this.oVG = z;
        return this;
    }

    public boolean eoH() {
        return this.oVG;
    }

    public ImageRequestBuilder At(boolean z) {
        this.pak = z;
        return this;
    }

    public boolean erW() {
        return this.pak;
    }

    public boolean eoq() {
        return this.oVB && com.facebook.common.util.d.K(this.pai);
    }

    public boolean erU() {
        return this.pap;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pal = priority;
        return this;
    }

    public Priority erX() {
        return this.pal;
    }

    public ImageRequestBuilder a(b bVar) {
        this.oZy = bVar;
        return this;
    }

    @Nullable
    public b erV() {
        return this.oZy;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.oUX = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c ekY() {
        return this.oUX;
    }

    public ImageRequest erY() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes18.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.pai == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.O(this.pai)) {
            if (!this.pai.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pai.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pai.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.N(this.pai) && !this.pai.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
