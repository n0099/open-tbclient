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
/* loaded from: classes5.dex */
public class FrescoThumbnailView extends SimpleDraweeView {
    private boolean ntJ;
    private boolean ntK;
    private boolean ntL;
    private boolean ntM;
    private boolean ntN;
    private c<f> ntO;
    private c<f> ntP;
    private c<f> ntQ;
    private a ntR;

    /* loaded from: classes5.dex */
    public interface a {
        void dv(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.ntJ = false;
        this.ntK = false;
        this.ntL = false;
        this.ntM = false;
        this.ntN = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ntJ = false;
        this.ntK = false;
        this.ntL = false;
        this.ntM = false;
        this.ntN = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ntJ = false;
        this.ntK = false;
        this.ntL = false;
        this.ntM = false;
        this.ntN = false;
    }

    public void xW(int i) {
        a((String) null, (String) null, i, 0, 0, 0);
    }

    public void bU(String str, int i) {
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
        this.ntR = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.ntJ = z;
    }

    public void setBlur(boolean z) {
        this.ntK = z;
    }

    public void setAutoRotated(boolean z) {
        this.ntM = z;
    }

    public void setAnim(boolean z) {
        this.ntL = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.i(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dpw().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).Gw(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().doZ().o(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.vH(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.lWe);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.lWe);
    }

    public void setRetryImage(Drawable drawable) {
        this.ntN = true;
        getHierarchy().d(drawable, p.b.lWe);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().Gs(i);
            } catch (Throwable th) {
                return;
            }
        }
        Uri parse = !h.isEmpty(str2) ? Uri.parse(str2) : null;
        if (parse == null) {
            if (i > 0) {
                aq(i, i2, i3);
                return;
            }
            return;
        }
        a(str != null ? Uri.parse(str) : null, parse, i2, i3, i4);
    }

    private void aq(int i, int i2, int i3) {
        tv.chushou.zues.widget.fresco.a.b bVar;
        boolean z = false;
        if (i > 0) {
            if (this.ntJ) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dKm();
            } else if (!this.ntK) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.dKl();
            }
            if (this.ntL) {
                RoundingParams doZ = getHierarchy().doZ();
                if (doZ != null) {
                    if (!doZ.dpr()) {
                        float[] dps = doZ.dps();
                        if (dps != null && dps.length > 0) {
                            int length = dps.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dps[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.Hz(i).vQ(true).a(this.ntM ? e.dqT() : e.dqU());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dnP().aW(a2.duW()).vC(z).c(getController()).doG());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.ntJ) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dKm();
            } else if (this.ntK) {
                bVar = tv.chushou.zues.widget.fresco.a.a.dKl();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.Z(uri2).vQ(true).a(this.ntM ? e.dqT() : e.dqU());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.ntL) {
                RoundingParams doZ = getHierarchy().doZ();
                if (doZ != null) {
                    if (!doZ.dpr()) {
                        float[] dps = doZ.dps();
                        if (dps != null && dps.length > 0) {
                            int length = dps.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dps[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dnP().aW(a2.duW()).vB(this.ntN).vC(z).c(getController());
            if (i3 != 0) {
                b.c(JX(i3));
            }
            if (ImageRequest.X(uri) != null) {
                b.aX(ImageRequest.X(uri));
            }
            setController(b.doG());
        }
    }

    private c<f> JX(int i) {
        if (i == 1) {
            if (this.ntO == null) {
                this.ntO = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getHeight() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.width = (layoutParams.height * width) / height;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                            if (FrescoThumbnailView.this.ntR != null) {
                                FrescoThumbnailView.this.ntR.dv(width, height);
                            }
                        }
                    }
                };
            }
            return this.ntO;
        } else if (i == 2) {
            if (this.ntP == null) {
                this.ntP = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.ntR != null) {
                                FrescoThumbnailView.this.ntR.dv(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.ntP;
        } else if (i == 3) {
            if (this.ntQ == null) {
                this.ntQ = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getHeight() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.width = (layoutParams.height * width) / height;
                            if (layoutParams instanceof FlexboxLayout.LayoutParams) {
                                ((FlexboxLayout.LayoutParams) layoutParams).setMinWidth(layoutParams.width);
                            }
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                            if (FrescoThumbnailView.this.ntR != null) {
                                FrescoThumbnailView.this.ntR.dv(width, height);
                            }
                        }
                    }
                };
            }
            return this.ntQ;
        } else {
            return null;
        }
    }
}
