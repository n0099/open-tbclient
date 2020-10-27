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
    private boolean qeL;
    private boolean qeM;
    private boolean qeN;
    private boolean qeO;
    private boolean qeP;
    private c<f> qeQ;
    private c<f> qeR;
    private c<f> qeS;
    private a qeT;

    /* loaded from: classes6.dex */
    public interface a {
        void ef(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.qeL = false;
        this.qeM = false;
        this.qeN = false;
        this.qeO = false;
        this.qeP = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qeL = false;
        this.qeM = false;
        this.qeN = false;
        this.qeO = false;
        this.qeP = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qeL = false;
        this.qeM = false;
        this.qeN = false;
        this.qeO = false;
        this.qeP = false;
    }

    public void DK(int i) {
        a((String) null, (String) null, i, 0, 0, 0);
    }

    public void cc(String str, int i) {
        a((String) null, str, i, 0, 0, 0);
    }

    public void i(String str, int i, int i2, int i3) {
        a((String) null, str, i, i2, i3, 0);
    }

    public void j(String str, int i, int i2, int i3) {
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
        this.qeT = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.qeL = z;
    }

    public void setBlur(boolean z) {
        this.qeM = z;
    }

    public void setAutoRotated(boolean z) {
        this.qeO = z;
    }

    public void setAnim(boolean z) {
        this.qeN = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.k(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.eiJ().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).Os(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().ein().p(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.zZ(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.oGq);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.oGq);
    }

    public void setRetryImage(Drawable drawable) {
        this.qeP = true;
        getHierarchy().d(drawable, p.b.oGq);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().Oo(i);
            } catch (Throwable th) {
                return;
            }
        }
        Uri parse = !h.isEmpty(str2) ? Uri.parse(str2) : null;
        if (parse == null) {
            if (i > 0) {
                ar(i, i2, i3);
                return;
            }
            return;
        }
        a(str != null ? Uri.parse(str) : null, parse, i2, i3, i4);
    }

    private void ar(int i, int i2, int i3) {
        tv.chushou.zues.widget.fresco.a.b bVar;
        boolean z = false;
        if (i > 0) {
            if (this.qeL) {
                bVar = tv.chushou.zues.widget.fresco.a.b.eEr();
            } else if (!this.qeM) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.eEq();
            }
            if (this.qeN) {
                RoundingParams ein = getHierarchy().ein();
                if (ein != null) {
                    if (!ein.eiE()) {
                        float[] eiF = ein.eiF();
                        if (eiF != null && eiF.length > 0) {
                            int length = eiF.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (eiF[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.Pv(i).Ai(true).a(this.qeO ? e.ekf() : e.ekg());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.ehd().bn(a2.eoj()).zU(z).c(getController()).ehU());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.qeL) {
                bVar = tv.chushou.zues.widget.fresco.a.b.eEr();
            } else if (this.qeM) {
                bVar = tv.chushou.zues.widget.fresco.a.a.eEq();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.ad(uri2).Ai(true).a(this.qeO ? e.ekf() : e.ekg());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.qeN) {
                RoundingParams ein = getHierarchy().ein();
                if (ein != null) {
                    if (!ein.eiE()) {
                        float[] eiF = ein.eiF();
                        if (eiF != null && eiF.length > 0) {
                            int length = eiF.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (eiF[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.ehd().bn(a2.eoj()).zT(this.qeP).zU(z).c(getController());
            if (i3 != 0) {
                b.c(RP(i3));
            }
            if (ImageRequest.ab(uri) != null) {
                b.bo(ImageRequest.ab(uri));
            }
            setController(b.ehU());
        }
    }

    private c<f> RP(int i) {
        if (i == 1) {
            if (this.qeQ == null) {
                this.qeQ = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
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
                            if (FrescoThumbnailView.this.qeT != null) {
                                FrescoThumbnailView.this.qeT.ef(width, height);
                            }
                        }
                    }
                };
            }
            return this.qeQ;
        } else if (i == 2) {
            if (this.qeR == null) {
                this.qeR = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.qeT != null) {
                                FrescoThumbnailView.this.qeT.ef(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.qeR;
        } else if (i == 3) {
            if (this.qeS == null) {
                this.qeS = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
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
                            if (FrescoThumbnailView.this.qeT != null) {
                                FrescoThumbnailView.this.qeT.ef(width, height);
                            }
                        }
                    }
                };
            }
            return this.qeS;
        } else {
            return null;
        }
    }
}
