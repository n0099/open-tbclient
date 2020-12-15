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
    private com.facebook.imagepipeline.g.c plr;
    private Uri pqG = null;
    private ImageRequest.RequestLevel poC = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d pjY = null;
    @Nullable
    private e pjZ = null;
    private com.facebook.imagepipeline.common.b pka = com.facebook.imagepipeline.common.b.etr();
    private ImageRequest.CacheChoice pqF = ImageRequest.CacheChoice.DEFAULT;
    private boolean pma = h.etR().eul();
    private boolean pqI = false;
    private Priority pqJ = Priority.HIGH;
    @Nullable
    private b ppX = null;
    private boolean plV = true;
    private boolean pqN = true;
    @Nullable
    private com.facebook.imagepipeline.common.a pnq = null;
    private Map<String, String> pqL = null;
    private String mTag = null;
    private String pqM = null;

    public static ImageRequestBuilder af(Uri uri) {
        return new ImageRequestBuilder().ag(uri);
    }

    public static ImageRequestBuilder Ro(int i) {
        return af(com.facebook.common.util.d.PU(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return af(imageRequest.exm()).a(imageRequest.exq()).c(imageRequest.evD()).a(imageRequest.exl()).Bb(imageRequest.exs()).a(imageRequest.ewy()).a(imageRequest.exu()).Ba(imageRequest.exr()).b(imageRequest.ewA()).c(imageRequest.exo()).c(imageRequest.eqM()).a(imageRequest.exp()).c(imageRequest.eqM()).I(imageRequest.exk()).Zw(imageRequest.mTag).Zx(imageRequest.pqM);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> exk() {
        return this.pqL;
    }

    public ImageRequestBuilder I(Map<String, String> map) {
        this.pqL = map;
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
        return this.pqM;
    }

    public ImageRequestBuilder Zx(String str) {
        this.pqM = str;
        return this;
    }

    public ImageRequestBuilder ag(Uri uri) {
        g.checkNotNull(uri);
        this.pqG = uri;
        return this;
    }

    public Uri exm() {
        return this.pqG;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.poC = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel ewy() {
        return this.poC;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.pjY = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d exo() {
        return this.pjY;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.pjZ = eVar;
        return this;
    }

    @Nullable
    public e exp() {
        return this.pjZ;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pnq = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evD() {
        return this.pnq;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.pka = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b exq() {
        return this.pka;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pqF = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice exl() {
        return this.pqF;
    }

    public ImageRequestBuilder Ba(boolean z) {
        this.pma = z;
        return this;
    }

    public boolean eul() {
        return this.pma;
    }

    public ImageRequestBuilder Bb(boolean z) {
        this.pqI = z;
        return this;
    }

    public boolean exv() {
        return this.pqI;
    }

    public boolean etU() {
        return this.plV && com.facebook.common.util.d.M(this.pqG);
    }

    public boolean ext() {
        return this.pqN;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pqJ = priority;
        return this;
    }

    public Priority exw() {
        return this.pqJ;
    }

    public ImageRequestBuilder a(b bVar) {
        this.ppX = bVar;
        return this;
    }

    @Nullable
    public b exu() {
        return this.ppX;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.g.c cVar) {
        this.plr = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c eqM() {
        return this.plr;
    }

    public ImageRequest exx() {
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
        if (this.pqG == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.Q(this.pqG)) {
            if (!this.pqG.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pqG.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pqG.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.P(this.pqG) && !this.pqG.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
