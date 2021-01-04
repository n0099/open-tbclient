package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.g.c pAU;
    private Uri pGg = null;
    private ImageRequest.RequestLevel pEc = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d pzD = null;
    @Nullable
    private e pzE = null;
    private com.facebook.imagepipeline.common.b pzF = com.facebook.imagepipeline.common.b.exa();
    private ImageRequest.CacheChoice pGf = ImageRequest.CacheChoice.DEFAULT;
    private boolean pBD = h.exA().exU();
    private boolean pGi = false;
    private Priority pGj = Priority.HIGH;
    @Nullable
    private b pFx = null;
    private boolean pBy = true;
    private boolean pGn = true;
    @Nullable
    private com.facebook.imagepipeline.common.a pCT = null;
    private Map<String, String> pGl = null;
    private String mTag = null;
    private String pGm = null;

    public static ImageRequestBuilder aj(Uri uri) {
        return new ImageRequestBuilder().ak(uri);
    }

    public static ImageRequestBuilder Rl(int i) {
        return aj(com.facebook.common.util.d.Qd(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return aj(imageRequest.eAT()).a(imageRequest.eAX()).c(imageRequest.ezk()).a(imageRequest.eAS()).Bj(imageRequest.eAZ()).a(imageRequest.eAf()).a(imageRequest.eBb()).Bi(imageRequest.eAY()).b(imageRequest.eAh()).c(imageRequest.eAV()).c(imageRequest.euO()).a(imageRequest.eAW()).c(imageRequest.euO()).N(imageRequest.eAR()).ZG(imageRequest.mTag).ZH(imageRequest.pGm);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> eAR() {
        return this.pGl;
    }

    public ImageRequestBuilder N(Map<String, String> map) {
        this.pGl = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder ZG(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pGm;
    }

    public ImageRequestBuilder ZH(String str) {
        this.pGm = str;
        return this;
    }

    public ImageRequestBuilder ak(Uri uri) {
        g.checkNotNull(uri);
        this.pGg = uri;
        return this;
    }

    public Uri eAT() {
        return this.pGg;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.pEc = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel eAf() {
        return this.pEc;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.pzD = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eAV() {
        return this.pzD;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.pzE = eVar;
        return this;
    }

    @Nullable
    public e eAW() {
        return this.pzE;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pCT = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ezk() {
        return this.pCT;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.pzF = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b eAX() {
        return this.pzF;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pGf = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice eAS() {
        return this.pGf;
    }

    public ImageRequestBuilder Bi(boolean z) {
        this.pBD = z;
        return this;
    }

    public boolean exU() {
        return this.pBD;
    }

    public ImageRequestBuilder Bj(boolean z) {
        this.pGi = z;
        return this;
    }

    public boolean eBc() {
        return this.pGi;
    }

    public boolean exD() {
        return this.pBy && com.facebook.common.util.d.N(this.pGg);
    }

    public boolean eBa() {
        return this.pGn;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pGj = priority;
        return this;
    }

    public Priority eBd() {
        return this.pGj;
    }

    public ImageRequestBuilder a(b bVar) {
        this.pFx = bVar;
        return this;
    }

    @Nullable
    public b eBb() {
        return this.pFx;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.g.c cVar) {
        this.pAU = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c euO() {
        return this.pAU;
    }

    public ImageRequest eBe() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes5.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.pGg == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.T(this.pGg)) {
            if (!this.pGg.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pGg.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pGg.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.S(this.pGg) && !this.pGg.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
