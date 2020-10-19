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
/* loaded from: classes6.dex */
public class FrescoThumbnailView extends SimpleDraweeView {
    private boolean pnA;
    private boolean pnB;
    private c<f> pnC;
    private c<f> pnD;
    private c<f> pnE;
    private a pnF;
    private boolean pnx;
    private boolean pny;
    private boolean pnz;

    /* loaded from: classes6.dex */
    public interface a {
        void dX(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.pnx = false;
        this.pny = false;
        this.pnz = false;
        this.pnA = false;
        this.pnB = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pnx = false;
        this.pny = false;
        this.pnz = false;
        this.pnA = false;
        this.pnB = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pnx = false;
        this.pny = false;
        this.pnz = false;
        this.pnA = false;
        this.pnB = false;
    }

    public void Dr(int i) {
        a((String) null, (String) null, i, 0, 0, 0);
    }

    public void bY(String str, int i) {
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
        this.pnF = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.pnx = z;
    }

    public void setBlur(boolean z) {
        this.pny = z;
    }

    public void setAutoRotated(boolean z) {
        this.pnA = z;
    }

    public void setAnim(boolean z) {
        this.pnz = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.i(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dYL().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).MB(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().dYp().p(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.yR(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.nOX);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.nOX);
    }

    public void setRetryImage(Drawable drawable) {
        this.pnB = true;
        getHierarchy().d(drawable, p.b.nOX);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().Mx(i);
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
            if (this.pnx) {
                bVar = tv.chushou.zues.widget.fresco.a.b.eut();
            } else if (!this.pny) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.eus();
            }
            if (this.pnz) {
                RoundingParams dYp = getHierarchy().dYp();
                if (dYp != null) {
                    if (!dYp.dYG()) {
                        float[] dYH = dYp.dYH();
                        if (dYH != null && dYH.length > 0) {
                            int length = dYH.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dYH[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.NE(i).za(true).a(this.pnA ? e.eah() : e.eai());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dXf().bj(a2.eej()).yM(z).c(getController()).dXW());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.pnx) {
                bVar = tv.chushou.zues.widget.fresco.a.b.eut();
            } else if (this.pny) {
                bVar = tv.chushou.zues.widget.fresco.a.a.eus();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.ad(uri2).za(true).a(this.pnA ? e.eah() : e.eai());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.pnz) {
                RoundingParams dYp = getHierarchy().dYp();
                if (dYp != null) {
                    if (!dYp.dYG()) {
                        float[] dYH = dYp.dYH();
                        if (dYH != null && dYH.length > 0) {
                            int length = dYH.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dYH[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dXf().bj(a2.eej()).yL(this.pnB).yM(z).c(getController());
            if (i3 != 0) {
                b.c(PY(i3));
            }
            if (ImageRequest.ab(uri) != null) {
                b.bk(ImageRequest.ab(uri));
            }
            setController(b.dXW());
        }
    }

    private c<f> PY(int i) {
        if (i == 1) {
            if (this.pnC == null) {
                this.pnC = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
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
                            if (FrescoThumbnailView.this.pnF != null) {
                                FrescoThumbnailView.this.pnF.dX(width, height);
                            }
                        }
                    }
                };
            }
            return this.pnC;
        } else if (i == 2) {
            if (this.pnD == null) {
                this.pnD = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.pnF != null) {
                                FrescoThumbnailView.this.pnF.dX(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.pnD;
        } else if (i == 3) {
            if (this.pnE == null) {
                this.pnE = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
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
                            if (FrescoThumbnailView.this.pnF != null) {
                                FrescoThumbnailView.this.pnF.dX(width, height);
                            }
                        }
                    }
                };
            }
            return this.pnE;
        } else {
            return null;
        }
    }
}
