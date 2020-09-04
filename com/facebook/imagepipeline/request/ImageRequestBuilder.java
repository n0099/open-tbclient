package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c nuW;
    private Uri nAi = null;
    private ImageRequest.RequestLevel nyg = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d ntB = null;
    @Nullable
    private e ntC = null;
    private com.facebook.imagepipeline.common.b ntD = com.facebook.imagepipeline.common.b.dSo();
    private ImageRequest.CacheChoice nAh = ImageRequest.CacheChoice.DEFAULT;
    private boolean nvF = h.dSP().dTj();
    private boolean nAk = false;
    private Priority nAl = Priority.HIGH;
    @Nullable
    private b nzz = null;
    private boolean nvA = true;
    private boolean nAp = true;
    @Nullable
    private com.facebook.imagepipeline.common.a nwX = null;
    private Map<String, String> nAn = null;
    private String mTag = null;
    private String nAo = null;

    public static ImageRequestBuilder ab(Uri uri) {
        return new ImageRequestBuilder().ac(uri);
    }

    public static ImageRequestBuilder Mt(int i) {
        return ab(com.facebook.common.util.d.KW(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ab(imageRequest.dWp()).a(imageRequest.dWt()).d(imageRequest.dUB()).a(imageRequest.dWo()).yk(imageRequest.dWv()).a(imageRequest.dVz()).a(imageRequest.dWx()).yj(imageRequest.dWu()).b(imageRequest.dVB()).c(imageRequest.dWr()).c(imageRequest.dPC()).a(imageRequest.dWs()).c(imageRequest.dPC()).y(imageRequest.dVO()).UL(imageRequest.mTag).UM(imageRequest.nAo);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dVO() {
        return this.nAn;
    }

    public ImageRequestBuilder y(Map<String, String> map) {
        this.nAn = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder UL(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.nAo;
    }

    public ImageRequestBuilder UM(String str) {
        this.nAo = str;
        return this;
    }

    public ImageRequestBuilder ac(Uri uri) {
        g.checkNotNull(uri);
        this.nAi = uri;
        return this;
    }

    public Uri dWp() {
        return this.nAi;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.nyg = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dVz() {
        return this.nyg;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.ntB = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dWr() {
        return this.ntB;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.ntC = eVar;
        return this;
    }

    @Nullable
    public e dWs() {
        return this.ntC;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.nwX = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dUB() {
        return this.nwX;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.ntD = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dWt() {
        return this.ntD;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.nAh = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dWo() {
        return this.nAh;
    }

    public ImageRequestBuilder yj(boolean z) {
        this.nvF = z;
        return this;
    }

    public boolean dTj() {
        return this.nvF;
    }

    public ImageRequestBuilder yk(boolean z) {
        this.nAk = z;
        return this;
    }

    public boolean dWy() {
        return this.nAk;
    }

    public boolean dSS() {
        return this.nvA && com.facebook.common.util.d.I(this.nAi);
    }

    public boolean dWw() {
        return this.nAp;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.nAl = priority;
        return this;
    }

    public Priority dWz() {
        return this.nAl;
    }

    public ImageRequestBuilder a(b bVar) {
        this.nzz = bVar;
        return this;
    }

    @Nullable
    public b dWx() {
        return this.nzz;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.nuW = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dPC() {
        return this.nuW;
    }

    public ImageRequest dWA() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes8.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.nAi == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.M(this.nAi)) {
            if (!this.nAi.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.nAi.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.nAi.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.L(this.nAi) && !this.nAi.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
