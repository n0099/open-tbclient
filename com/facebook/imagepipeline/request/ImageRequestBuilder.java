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
    private com.facebook.imagepipeline.h.c nuE;
    private Uri nzQ = null;
    private ImageRequest.RequestLevel nxO = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d ntj = null;
    @Nullable
    private e ntk = null;
    private com.facebook.imagepipeline.common.b ntl = com.facebook.imagepipeline.common.b.dSf();
    private ImageRequest.CacheChoice nzP = ImageRequest.CacheChoice.DEFAULT;
    private boolean nvn = h.dSG().dTa();
    private boolean nzS = false;
    private Priority nzT = Priority.HIGH;
    @Nullable
    private b nzh = null;
    private boolean nvi = true;
    private boolean nzX = true;
    @Nullable
    private com.facebook.imagepipeline.common.a nwF = null;
    private Map<String, String> nzV = null;
    private String mTag = null;
    private String nzW = null;

    public static ImageRequestBuilder ab(Uri uri) {
        return new ImageRequestBuilder().ac(uri);
    }

    public static ImageRequestBuilder Mt(int i) {
        return ab(com.facebook.common.util.d.KW(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ab(imageRequest.dWg()).a(imageRequest.dWk()).d(imageRequest.dUs()).a(imageRequest.dWf()).yi(imageRequest.dWm()).a(imageRequest.dVq()).a(imageRequest.dWo()).yh(imageRequest.dWl()).b(imageRequest.dVs()).c(imageRequest.dWi()).c(imageRequest.dPt()).a(imageRequest.dWj()).c(imageRequest.dPt()).y(imageRequest.dVF()).UL(imageRequest.mTag).UM(imageRequest.nzW);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dVF() {
        return this.nzV;
    }

    public ImageRequestBuilder y(Map<String, String> map) {
        this.nzV = map;
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
        return this.nzW;
    }

    public ImageRequestBuilder UM(String str) {
        this.nzW = str;
        return this;
    }

    public ImageRequestBuilder ac(Uri uri) {
        g.checkNotNull(uri);
        this.nzQ = uri;
        return this;
    }

    public Uri dWg() {
        return this.nzQ;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.nxO = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dVq() {
        return this.nxO;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.ntj = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dWi() {
        return this.ntj;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.ntk = eVar;
        return this;
    }

    @Nullable
    public e dWj() {
        return this.ntk;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.nwF = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dUs() {
        return this.nwF;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.ntl = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dWk() {
        return this.ntl;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.nzP = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dWf() {
        return this.nzP;
    }

    public ImageRequestBuilder yh(boolean z) {
        this.nvn = z;
        return this;
    }

    public boolean dTa() {
        return this.nvn;
    }

    public ImageRequestBuilder yi(boolean z) {
        this.nzS = z;
        return this;
    }

    public boolean dWp() {
        return this.nzS;
    }

    public boolean dSJ() {
        return this.nvi && com.facebook.common.util.d.I(this.nzQ);
    }

    public boolean dWn() {
        return this.nzX;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.nzT = priority;
        return this;
    }

    public Priority dWq() {
        return this.nzT;
    }

    public ImageRequestBuilder a(b bVar) {
        this.nzh = bVar;
        return this;
    }

    @Nullable
    public b dWo() {
        return this.nzh;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.nuE = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dPt() {
        return this.nuE;
    }

    public ImageRequest dWr() {
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
        if (this.nzQ == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.M(this.nzQ)) {
            if (!this.nzQ.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.nzQ.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.nzQ.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.L(this.nzQ) && !this.nzQ.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
