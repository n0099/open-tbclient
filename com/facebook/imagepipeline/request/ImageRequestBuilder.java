package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes25.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c nET;
    private Uri nKf = null;
    private ImageRequest.RequestLevel nId = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d nDz = null;
    @Nullable
    private e nDA = null;
    private com.facebook.imagepipeline.common.b nDB = com.facebook.imagepipeline.common.b.dWm();
    private ImageRequest.CacheChoice nKe = ImageRequest.CacheChoice.DEFAULT;
    private boolean nFC = h.dWN().dXh();
    private boolean nKh = false;
    private Priority nKi = Priority.HIGH;
    @Nullable
    private b nJw = null;
    private boolean nFx = true;
    private boolean nKm = true;
    @Nullable
    private com.facebook.imagepipeline.common.a nGU = null;
    private Map<String, String> nKk = null;
    private String mTag = null;
    private String nKl = null;

    public static ImageRequestBuilder ad(Uri uri) {
        return new ImageRequestBuilder().ae(uri);
    }

    public static ImageRequestBuilder MY(int i) {
        return ad(com.facebook.common.util.d.LB(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ad(imageRequest.ean()).a(imageRequest.ear()).d(imageRequest.dYz()).a(imageRequest.eam()).yt(imageRequest.eat()).a(imageRequest.dZx()).a(imageRequest.eav()).ys(imageRequest.eas()).b(imageRequest.dZz()).c(imageRequest.eap()).c(imageRequest.dTA()).a(imageRequest.eaq()).c(imageRequest.dTA()).y(imageRequest.dZM()).Vn(imageRequest.mTag).Vo(imageRequest.nKl);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dZM() {
        return this.nKk;
    }

    public ImageRequestBuilder y(Map<String, String> map) {
        this.nKk = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Vn(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.nKl;
    }

    public ImageRequestBuilder Vo(String str) {
        this.nKl = str;
        return this;
    }

    public ImageRequestBuilder ae(Uri uri) {
        g.checkNotNull(uri);
        this.nKf = uri;
        return this;
    }

    public Uri ean() {
        return this.nKf;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.nId = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dZx() {
        return this.nId;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.nDz = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eap() {
        return this.nDz;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.nDA = eVar;
        return this;
    }

    @Nullable
    public e eaq() {
        return this.nDA;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.nGU = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dYz() {
        return this.nGU;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.nDB = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b ear() {
        return this.nDB;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.nKe = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice eam() {
        return this.nKe;
    }

    public ImageRequestBuilder ys(boolean z) {
        this.nFC = z;
        return this;
    }

    public boolean dXh() {
        return this.nFC;
    }

    public ImageRequestBuilder yt(boolean z) {
        this.nKh = z;
        return this;
    }

    public boolean eaw() {
        return this.nKh;
    }

    public boolean dWQ() {
        return this.nFx && com.facebook.common.util.d.K(this.nKf);
    }

    public boolean eau() {
        return this.nKm;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.nKi = priority;
        return this;
    }

    public Priority eax() {
        return this.nKi;
    }

    public ImageRequestBuilder a(b bVar) {
        this.nJw = bVar;
        return this;
    }

    @Nullable
    public b eav() {
        return this.nJw;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.nET = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dTA() {
        return this.nET;
    }

    public ImageRequest eay() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes25.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.nKf == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.O(this.nKf)) {
            if (!this.nKf.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.nKf.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.nKf.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.N(this.nKf) && !this.nKf.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
