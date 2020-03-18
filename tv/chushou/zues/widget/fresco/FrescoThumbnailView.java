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
    private boolean nZP;
    private boolean nZQ;
    private boolean nZR;
    private boolean nZS;
    private boolean nZT;
    private c<f> nZU;
    private c<f> nZV;
    private c<f> nZW;
    private a nZX;

    /* loaded from: classes5.dex */
    public interface a {
        void ej(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.nZP = false;
        this.nZQ = false;
        this.nZR = false;
        this.nZS = false;
        this.nZT = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nZP = false;
        this.nZQ = false;
        this.nZR = false;
        this.nZS = false;
        this.nZT = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nZP = false;
        this.nZQ = false;
        this.nZR = false;
        this.nZS = false;
        this.nZT = false;
    }

    public void xw(int i) {
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
        this.nZX = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.nZP = z;
    }

    public void setBlur(boolean z) {
        this.nZQ = z;
    }

    public void setAutoRotated(boolean z) {
        this.nZS = z;
    }

    public void setAnim(boolean z) {
        this.nZR = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.o(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dnD().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).HV(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().dnf().q(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.vt(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.lOI);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.lOI);
    }

    public void setRetryImage(Drawable drawable) {
        this.nZT = true;
        getHierarchy().d(drawable, p.b.lOI);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().HR(i);
            } catch (Throwable th) {
                return;
            }
        }
        Uri parse = !h.isEmpty(str2) ? Uri.parse(str2) : null;
        if (parse == null) {
            if (i > 0) {
                ax(i, i2, i3);
                return;
            }
            return;
        }
        a(str != null ? Uri.parse(str) : null, parse, i2, i3, i4);
    }

    private void ax(int i, int i2, int i3) {
        tv.chushou.zues.widget.fresco.a.b bVar;
        boolean z = false;
        if (i > 0) {
            if (this.nZP) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dRk();
            } else if (!this.nZQ) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.dRj();
            }
            if (this.nZR) {
                RoundingParams dnf = getHierarchy().dnf();
                if (dnf != null) {
                    if (!dnf.dny()) {
                        float[] dnz = dnf.dnz();
                        if (dnz != null && dnz.length > 0) {
                            int length = dnz.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dnz[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.IW(i).vD(true).a(this.nZS ? e.doU() : e.doV());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dlW().bg(a2.dta()).vo(z).c(getController()).dmN());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.nZP) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dRk();
            } else if (this.nZQ) {
                bVar = tv.chushou.zues.widget.fresco.a.a.dRj();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.Y(uri2).vD(true).a(this.nZS ? e.doU() : e.doV());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.nZR) {
                RoundingParams dnf = getHierarchy().dnf();
                if (dnf != null) {
                    if (!dnf.dny()) {
                        float[] dnz = dnf.dnz();
                        if (dnz != null && dnz.length > 0) {
                            int length = dnz.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dnz[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dlW().bg(a2.dta()).vn(this.nZT).vo(z).c(getController());
            if (i3 != 0) {
                b.c(OB(i3));
            }
            if (ImageRequest.W(uri) != null) {
                b.bh(ImageRequest.W(uri));
            }
            setController(b.dmN());
        }
    }

    private c<f> OB(int i) {
        if (i == 1) {
            if (this.nZU == null) {
                this.nZU = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
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
                            if (FrescoThumbnailView.this.nZX != null) {
                                FrescoThumbnailView.this.nZX.ej(width, height);
                            }
                        }
                    }
                };
            }
            return this.nZU;
        } else if (i == 2) {
            if (this.nZV == null) {
                this.nZV = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void onFinalImageSet(String str, f fVar, Animatable animatable) {
                        super.onFinalImageSet(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.nZX != null) {
                                FrescoThumbnailView.this.nZX.ej(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.nZV;
        } else if (i == 3) {
            if (this.nZW == null) {
                this.nZW = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
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
                            if (FrescoThumbnailView.this.nZX != null) {
                                FrescoThumbnailView.this.nZX.ej(width, height);
                            }
                        }
                    }
                };
            }
            return this.nZW;
        } else {
            return null;
        }
    }
}
