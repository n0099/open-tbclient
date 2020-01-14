package tv.chushou.zues.widget.fresco;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.facebook.drawee.controller.c;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.g.f;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.flexbox.FlexboxLayout;
import tv.chushou.zues.b;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class FrescoThumbnailView extends SimpleDraweeView {
    private boolean nXb;
    private boolean nXc;
    private boolean nXd;
    private boolean nXe;
    private boolean nXf;
    private c<f> nXg;
    private c<f> nXh;
    private c<f> nXi;
    private a nXj;

    /* loaded from: classes4.dex */
    public interface a {
        void ef(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.nXb = false;
        this.nXc = false;
        this.nXd = false;
        this.nXe = false;
        this.nXf = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nXb = false;
        this.nXc = false;
        this.nXd = false;
        this.nXe = false;
        this.nXf = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nXb = false;
        this.nXc = false;
        this.nXd = false;
        this.nXe = false;
        this.nXf = false;
    }

    public void xi(int i) {
        a((String) null, (String) null, i, 0, 0, 0);
    }

    public void bV(String str, int i) {
        a((String) null, str, i, 0, 0, 0);
    }

    public void h(String str, int i, int i2, int i3) {
        a((String) null, str, i, i2, i3, 0);
    }

    public void i(String str, int i, int i2, int i3) {
        a(str, i, i2, i3, 0);
    }

    public void a(String str, int i, int i2, int i3, int i4) {
        a(str, i, i2, i3, i4, (a) null);
    }

    public void a(String str, int i, int i2, int i3, int i4, a aVar) {
        Object tag = getTag(b.e.zues_fresco_url_tag);
        boolean z = false;
        if (tag != null && tag.equals(str)) {
            z = true;
        }
        this.nXj = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.nXb = z;
    }

    public void setBlur(boolean z) {
        this.nXc = z;
    }

    public void setAutoRotated(boolean z) {
        this.nXe = z;
    }

    public void setAnim(boolean z) {
        this.nXd = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.o(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dlQ().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).HK(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().dlt().q(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.vi(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.lMi);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.lMi);
    }

    public void setRetryImage(Drawable drawable) {
        this.nXf = true;
        getHierarchy().d(drawable, p.b.lMi);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().HG(i);
            } catch (Throwable th) {
                return;
            }
        }
        Uri parse = !h.isEmpty(str2) ? Uri.parse(str2) : null;
        if (parse == null) {
            if (i > 0) {
                aw(i, i2, i3);
                return;
            }
            return;
        }
        a(str != null ? Uri.parse(str) : null, parse, i2, i3, i4);
    }

    private void aw(int i, int i2, int i3) {
        tv.chushou.zues.widget.fresco.a.b bVar;
        boolean z = false;
        if (i > 0) {
            if (this.nXb) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dPu();
            } else if (!this.nXc) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.dPt();
            }
            if (this.nXd) {
                RoundingParams dlt = getHierarchy().dlt();
                if (dlt != null) {
                    if (!dlt.dlL()) {
                        float[] dlM = dlt.dlM();
                        if (dlM != null && dlM.length > 0) {
                            int length = dlM.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dlM[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.IL(i).vs(true).a(this.nXe ? e.dnh() : e.dni());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dkj().be(a2.dro()).vd(z).c(getController()).dla());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.nXb) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dPu();
            } else if (this.nXc) {
                bVar = tv.chushou.zues.widget.fresco.a.a.dPt();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.X(uri2).vs(true).a(this.nXe ? e.dnh() : e.dni());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.nXd) {
                RoundingParams dlt = getHierarchy().dlt();
                if (dlt != null) {
                    if (!dlt.dlL()) {
                        float[] dlM = dlt.dlM();
                        if (dlM != null && dlM.length > 0) {
                            int length = dlM.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dlM[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dkj().be(a2.dro()).vc(this.nXf).vd(z).c(getController());
            if (i3 != 0) {
                b.c(Os(i3));
            }
            if (ImageRequest.V(uri) != null) {
                b.bf(ImageRequest.V(uri));
            }
            setController(b.dla());
        }
    }

    private c<f> Os(int i) {
        if (i == 1) {
            if (this.nXg == null) {
                this.nXg = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void onFinalImageSet(String str, f fVar, Animatable animatable) {
                        super.onFinalImageSet(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getHeight() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.width = (layoutParams.height * width) / height;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                            if (FrescoThumbnailView.this.nXj != null) {
                                FrescoThumbnailView.this.nXj.ef(width, height);
                            }
                        }
                    }
                };
            }
            return this.nXg;
        } else if (i == 2) {
            if (this.nXh == null) {
                this.nXh = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void onFinalImageSet(String str, f fVar, Animatable animatable) {
                        super.onFinalImageSet(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.nXj != null) {
                                FrescoThumbnailView.this.nXj.ef(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.nXh;
        } else if (i == 3) {
            if (this.nXi == null) {
                this.nXi = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void onFinalImageSet(String str, f fVar, Animatable animatable) {
                        super.onFinalImageSet(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getHeight() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.width = (layoutParams.height * width) / height;
                            if (layoutParams instanceof FlexboxLayout.LayoutParams) {
                                ((FlexboxLayout.LayoutParams) layoutParams).setMinWidth(layoutParams.width);
                            }
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                            if (FrescoThumbnailView.this.nXj != null) {
                                FrescoThumbnailView.this.nXj.ef(width, height);
                            }
                        }
                    }
                };
            }
            return this.nXi;
        } else {
            return null;
        }
    }
}
