package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c mby;
    private Uri mgI = null;
    private ImageRequest.RequestLevel meG = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d maa = null;
    @Nullable
    private e mab = null;
    private com.facebook.imagepipeline.common.b mad = com.facebook.imagepipeline.common.b.dqJ();
    private ImageRequest.CacheChoice mgH = ImageRequest.CacheChoice.DEFAULT;
    private boolean mch = h.drk().drE();
    private boolean mgK = false;
    private Priority mgL = Priority.HIGH;
    @Nullable
    private b mfZ = null;
    private boolean mcc = true;
    private boolean mgP = true;
    @Nullable
    private com.facebook.imagepipeline.common.a mdx = null;
    private Map<String, String> mgN = null;
    private String mTag = null;
    private String mgO = null;

    public static ImageRequestBuilder Z(Uri uri) {
        return new ImageRequestBuilder().aa(uri);
    }

    public static ImageRequestBuilder Hz(int i) {
        return Z(com.facebook.common.util.d.Gc(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return Z(imageRequest.duL()).a(imageRequest.duP()).d(imageRequest.dsW()).a(imageRequest.duK()).vQ(imageRequest.duR()).a(imageRequest.dtV()).a(imageRequest.duT()).vP(imageRequest.duQ()).b(imageRequest.dtX()).c(imageRequest.duN()).c(imageRequest.dnV()).a(imageRequest.duO()).c(imageRequest.dnV()).x(imageRequest.duk()).Or(imageRequest.mTag).Os(imageRequest.mgO);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> duk() {
        return this.mgN;
    }

    public ImageRequestBuilder x(Map<String, String> map) {
        this.mgN = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Or(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.mgO;
    }

    public ImageRequestBuilder Os(String str) {
        this.mgO = str;
        return this;
    }

    public ImageRequestBuilder aa(Uri uri) {
        g.checkNotNull(uri);
        this.mgI = uri;
        return this;
    }

    public Uri duL() {
        return this.mgI;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.meG = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dtV() {
        return this.meG;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.maa = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d duN() {
        return this.maa;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.mab = eVar;
        return this;
    }

    @Nullable
    public e duO() {
        return this.mab;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mdx = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dsW() {
        return this.mdx;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.mad = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b duP() {
        return this.mad;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.mgH = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice duK() {
        return this.mgH;
    }

    public ImageRequestBuilder vP(boolean z) {
        this.mch = z;
        return this;
    }

    public boolean drE() {
        return this.mch;
    }

    public ImageRequestBuilder vQ(boolean z) {
        this.mgK = z;
        return this;
    }

    public boolean duU() {
        return this.mgK;
    }

    public boolean drn() {
        return this.mcc && com.facebook.common.util.d.G(this.mgI);
    }

    public boolean duS() {
        return this.mgP;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.mgL = priority;
        return this;
    }

    public Priority duV() {
        return this.mgL;
    }

    public ImageRequestBuilder a(b bVar) {
        this.mfZ = bVar;
        return this;
    }

    @Nullable
    public b duT() {
        return this.mfZ;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.mby = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dnV() {
        return this.mby;
    }

    public ImageRequest duW() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes12.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.mgI == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.K(this.mgI)) {
            if (!this.mgI.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.mgI.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.mgI.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.J(this.mgI) && !this.mgI.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
