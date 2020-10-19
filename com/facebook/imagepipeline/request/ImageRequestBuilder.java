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
    private com.facebook.imagepipeline.h.c nUm;
    private Uri nZw = null;
    private ImageRequest.RequestLevel nXu = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d nSS = null;
    @Nullable
    private e nST = null;
    private com.facebook.imagepipeline.common.b nSU = com.facebook.imagepipeline.common.b.dZX();
    private ImageRequest.CacheChoice nZv = ImageRequest.CacheChoice.DEFAULT;
    private boolean nUV = h.eay().eaS();
    private boolean nZy = false;
    private Priority nZz = Priority.HIGH;
    @Nullable
    private b nYN = null;
    private boolean nUQ = true;
    private boolean nZD = true;
    @Nullable
    private com.facebook.imagepipeline.common.a nWl = null;
    private Map<String, String> nZB = null;
    private String mTag = null;
    private String nZC = null;

    public static ImageRequestBuilder ad(Uri uri) {
        return new ImageRequestBuilder().ae(uri);
    }

    public static ImageRequestBuilder NE(int i) {
        return ad(com.facebook.common.util.d.Mh(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ad(imageRequest.edY()).a(imageRequest.eec()).d(imageRequest.eck()).a(imageRequest.edX()).za(imageRequest.eee()).a(imageRequest.edi()).a(imageRequest.eeg()).yZ(imageRequest.eed()).b(imageRequest.edk()).c(imageRequest.eea()).c(imageRequest.dXl()).a(imageRequest.eeb()).c(imageRequest.dXl()).I(imageRequest.edx()).Wb(imageRequest.mTag).Wc(imageRequest.nZC);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> edx() {
        return this.nZB;
    }

    public ImageRequestBuilder I(Map<String, String> map) {
        this.nZB = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Wb(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.nZC;
    }

    public ImageRequestBuilder Wc(String str) {
        this.nZC = str;
        return this;
    }

    public ImageRequestBuilder ae(Uri uri) {
        g.checkNotNull(uri);
        this.nZw = uri;
        return this;
    }

    public Uri edY() {
        return this.nZw;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.nXu = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel edi() {
        return this.nXu;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.nSS = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eea() {
        return this.nSS;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.nST = eVar;
        return this;
    }

    @Nullable
    public e eeb() {
        return this.nST;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.nWl = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eck() {
        return this.nWl;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.nSU = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b eec() {
        return this.nSU;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.nZv = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice edX() {
        return this.nZv;
    }

    public ImageRequestBuilder yZ(boolean z) {
        this.nUV = z;
        return this;
    }

    public boolean eaS() {
        return this.nUV;
    }

    public ImageRequestBuilder za(boolean z) {
        this.nZy = z;
        return this;
    }

    public boolean eeh() {
        return this.nZy;
    }

    public boolean eaB() {
        return this.nUQ && com.facebook.common.util.d.K(this.nZw);
    }

    public boolean eef() {
        return this.nZD;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.nZz = priority;
        return this;
    }

    public Priority eei() {
        return this.nZz;
    }

    public ImageRequestBuilder a(b bVar) {
        this.nYN = bVar;
        return this;
    }

    @Nullable
    public b eeg() {
        return this.nYN;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.nUm = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dXl() {
        return this.nUm;
    }

    public ImageRequest eej() {
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
        if (this.nZw == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.O(this.nZw)) {
            if (!this.nZw.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.nZw.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.nZw.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.N(this.nZw) && !this.nZw.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
