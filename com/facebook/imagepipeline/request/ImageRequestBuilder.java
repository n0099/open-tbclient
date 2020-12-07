package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.g.c plp;
    private Uri pqE = null;
    private ImageRequest.RequestLevel poA = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d pjW = null;
    @Nullable
    private e pjX = null;
    private com.facebook.imagepipeline.common.b pjY = com.facebook.imagepipeline.common.b.etq();
    private ImageRequest.CacheChoice pqD = ImageRequest.CacheChoice.DEFAULT;
    private boolean plY = h.etQ().euk();
    private boolean pqG = false;
    private Priority pqH = Priority.HIGH;
    @Nullable
    private b ppV = null;
    private boolean plT = true;
    private boolean pqL = true;
    @Nullable
    private com.facebook.imagepipeline.common.a pno = null;
    private Map<String, String> pqJ = null;
    private String mTag = null;
    private String pqK = null;

    public static ImageRequestBuilder af(Uri uri) {
        return new ImageRequestBuilder().ag(uri);
    }

    public static ImageRequestBuilder Ro(int i) {
        return af(com.facebook.common.util.d.PU(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return af(imageRequest.exl()).a(imageRequest.exp()).c(imageRequest.evC()).a(imageRequest.exk()).Bb(imageRequest.exr()).a(imageRequest.ewx()).a(imageRequest.ext()).Ba(imageRequest.exq()).b(imageRequest.ewz()).c(imageRequest.exn()).c(imageRequest.eqL()).a(imageRequest.exo()).c(imageRequest.eqL()).I(imageRequest.exj()).Zw(imageRequest.mTag).Zx(imageRequest.pqK);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> exj() {
        return this.pqJ;
    }

    public ImageRequestBuilder I(Map<String, String> map) {
        this.pqJ = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Zw(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pqK;
    }

    public ImageRequestBuilder Zx(String str) {
        this.pqK = str;
        return this;
    }

    public ImageRequestBuilder ag(Uri uri) {
        g.checkNotNull(uri);
        this.pqE = uri;
        return this;
    }

    public Uri exl() {
        return this.pqE;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.poA = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel ewx() {
        return this.poA;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.pjW = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d exn() {
        return this.pjW;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.pjX = eVar;
        return this;
    }

    @Nullable
    public e exo() {
        return this.pjX;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pno = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evC() {
        return this.pno;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.pjY = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b exp() {
        return this.pjY;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pqD = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice exk() {
        return this.pqD;
    }

    public ImageRequestBuilder Ba(boolean z) {
        this.plY = z;
        return this;
    }

    public boolean euk() {
        return this.plY;
    }

    public ImageRequestBuilder Bb(boolean z) {
        this.pqG = z;
        return this;
    }

    public boolean exu() {
        return this.pqG;
    }

    public boolean etT() {
        return this.plT && com.facebook.common.util.d.M(this.pqE);
    }

    public boolean exs() {
        return this.pqL;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pqH = priority;
        return this;
    }

    public Priority exv() {
        return this.pqH;
    }

    public ImageRequestBuilder a(b bVar) {
        this.ppV = bVar;
        return this;
    }

    @Nullable
    public b ext() {
        return this.ppV;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.g.c cVar) {
        this.plp = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c eqL() {
        return this.plp;
    }

    public ImageRequest exw() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes15.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.pqE == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.Q(this.pqE)) {
            if (!this.pqE.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pqE.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pqE.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.P(this.pqE) && !this.pqE.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
