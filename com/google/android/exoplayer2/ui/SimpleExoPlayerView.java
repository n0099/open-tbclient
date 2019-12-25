package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.ui.PlaybackControlView;
import com.google.android.exoplayer2.ui.a;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.w;
import java.util.List;
@TargetApi(16)
/* loaded from: classes4.dex */
public final class SimpleExoPlayerView extends FrameLayout {
    private final AspectRatioFrameLayout mAg;
    private final View mAh;
    private final View mAi;
    private final ImageView mAj;
    private final SubtitleView mAl;
    private final PlaybackControlView mAm;
    private final a mAn;
    private final FrameLayout mAo;
    private w mAp;
    private boolean mAq;
    private boolean mAr;
    private Bitmap mAs;
    private int mAt;
    private boolean mAu;
    private boolean mAv;

    public SimpleExoPlayerView(Context context) {
        this(context, null);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        boolean z3;
        boolean z4;
        if (isInEditMode()) {
            this.mAg = null;
            this.mAh = null;
            this.mAi = null;
            this.mAj = null;
            this.mAl = null;
            this.mAm = null;
            this.mAn = null;
            this.mAo = null;
            ImageView imageView = new ImageView(context);
            if (v.SDK_INT >= 23) {
                a(getResources(), imageView);
            } else {
                b(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        boolean z5 = false;
        int i7 = 0;
        int i8 = a.d.exo_simple_player_view;
        if (attributeSet == null) {
            i2 = i8;
            z = true;
            i3 = 0;
            z2 = true;
            i4 = 1;
            i5 = 0;
            i6 = 5000;
            z3 = true;
            z4 = true;
        } else {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.SimpleExoPlayerView, 0, 0);
            try {
                z5 = obtainStyledAttributes.hasValue(a.f.SimpleExoPlayerView_shutter_background_color);
                i7 = obtainStyledAttributes.getColor(a.f.SimpleExoPlayerView_shutter_background_color, 0);
                int resourceId = obtainStyledAttributes.getResourceId(a.f.SimpleExoPlayerView_player_layout_id, i8);
                boolean z6 = obtainStyledAttributes.getBoolean(a.f.SimpleExoPlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(a.f.SimpleExoPlayerView_default_artwork, 0);
                boolean z7 = obtainStyledAttributes.getBoolean(a.f.SimpleExoPlayerView_use_controller, true);
                int i9 = obtainStyledAttributes.getInt(a.f.SimpleExoPlayerView_surface_type, 1);
                int i10 = obtainStyledAttributes.getInt(a.f.SimpleExoPlayerView_resize_mode, 0);
                int i11 = obtainStyledAttributes.getInt(a.f.SimpleExoPlayerView_show_timeout, 5000);
                boolean z8 = obtainStyledAttributes.getBoolean(a.f.SimpleExoPlayerView_hide_on_touch, true);
                boolean z9 = obtainStyledAttributes.getBoolean(a.f.SimpleExoPlayerView_auto_show, true);
                obtainStyledAttributes.recycle();
                i2 = resourceId;
                z = z6;
                i3 = resourceId2;
                z2 = z7;
                i4 = i9;
                i5 = i10;
                i6 = i11;
                z3 = z8;
                z4 = z9;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        LayoutInflater.from(context).inflate(i2, this);
        this.mAn = new a();
        setDescendantFocusability(262144);
        this.mAg = (AspectRatioFrameLayout) findViewById(a.c.exo_content_frame);
        if (this.mAg != null) {
            a(this.mAg, i5);
        }
        this.mAh = findViewById(a.c.exo_shutter);
        if (this.mAh != null && z5) {
            this.mAh.setBackgroundColor(i7);
        }
        if (this.mAg != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mAi = i4 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.mAi.setLayoutParams(layoutParams);
            this.mAg.addView(this.mAi, 0);
        } else {
            this.mAi = null;
        }
        this.mAo = (FrameLayout) findViewById(a.c.exo_overlay);
        this.mAj = (ImageView) findViewById(a.c.exo_artwork);
        this.mAr = z && this.mAj != null;
        if (i3 != 0) {
            this.mAs = BitmapFactory.decodeResource(context.getResources(), i3);
        }
        this.mAl = (SubtitleView) findViewById(a.c.exo_subtitles);
        if (this.mAl != null) {
            this.mAl.setUserDefaultStyle();
            this.mAl.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(a.c.exo_controller);
        View findViewById = findViewById(a.c.exo_controller_placeholder);
        if (playbackControlView != null) {
            this.mAm = playbackControlView;
        } else if (findViewById != null) {
            this.mAm = new PlaybackControlView(context, null, 0, attributeSet);
            this.mAm.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(this.mAm, indexOfChild);
        } else {
            this.mAm = null;
        }
        this.mAt = this.mAm == null ? 0 : i6;
        this.mAv = z3;
        this.mAu = z4;
        this.mAq = z2 && this.mAm != null;
        dwn();
    }

    public w getPlayer() {
        return this.mAp;
    }

    public void setPlayer(w wVar) {
        if (this.mAp != wVar) {
            if (this.mAp != null) {
                this.mAp.b((r.b) this.mAn);
                this.mAp.b((j) this.mAn);
                this.mAp.b((w.b) this.mAn);
                if (this.mAi instanceof TextureView) {
                    this.mAp.c((TextureView) this.mAi);
                } else if (this.mAi instanceof SurfaceView) {
                    this.mAp.b((SurfaceView) this.mAi);
                }
            }
            this.mAp = wVar;
            if (this.mAq) {
                this.mAm.setPlayer(wVar);
            }
            if (this.mAh != null) {
                this.mAh.setVisibility(0);
            }
            if (wVar != null) {
                if (this.mAi instanceof TextureView) {
                    wVar.b((TextureView) this.mAi);
                } else if (this.mAi instanceof SurfaceView) {
                    wVar.a((SurfaceView) this.mAi);
                }
                wVar.a((w.b) this.mAn);
                wVar.a((j) this.mAn);
                wVar.a((r.b) this.mAn);
                vD(false);
                dwp();
                return;
            }
            dwn();
            dwq();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mAi instanceof SurfaceView) {
            this.mAi.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mAg != null);
        this.mAg.setResizeMode(i);
    }

    public boolean getUseArtwork() {
        return this.mAr;
    }

    public void setUseArtwork(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mAj == null) ? false : true);
        if (this.mAr != z) {
            this.mAr = z;
            dwp();
        }
    }

    public Bitmap getDefaultArtwork() {
        return this.mAs;
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.mAs != bitmap) {
            this.mAs = bitmap;
            dwp();
        }
    }

    public boolean getUseController() {
        return this.mAq;
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mAm == null) ? false : true);
        if (this.mAq != z) {
            this.mAq = z;
            if (z) {
                this.mAm.setPlayer(this.mAp);
            } else if (this.mAm != null) {
                this.mAm.hide();
                this.mAm.setPlayer(null);
            }
        }
    }

    public void setShutterBackgroundColor(int i) {
        if (this.mAh != null) {
            this.mAh.setBackgroundColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mAp != null && this.mAp.dqz()) {
            this.mAo.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = LB(keyEvent.getKeyCode()) && this.mAq && !this.mAm.isVisible();
        vD(true);
        return z || b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        return this.mAq && this.mAm.b(keyEvent);
    }

    public void dwn() {
        if (this.mAm != null) {
            this.mAm.hide();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.mAt;
    }

    public void setControllerShowTimeoutMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mAm != null);
        this.mAt = i;
    }

    public boolean getControllerHideOnTouch() {
        return this.mAv;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAm != null);
        this.mAv = z;
    }

    public boolean getControllerAutoShow() {
        return this.mAu;
    }

    public void setControllerAutoShow(boolean z) {
        this.mAu = z;
    }

    public void setControllerVisibilityListener(PlaybackControlView.d dVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mAm != null);
        this.mAm.setVisibilityListener(dVar);
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mAm != null);
        this.mAm.setControlDispatcher(cVar);
    }

    public void setRewindIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mAm != null);
        this.mAm.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mAm != null);
        this.mAm.setFastForwardIncrementMs(i);
    }

    public void setRepeatToggleModes(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mAm != null);
        this.mAm.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAm != null);
        this.mAm.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAm != null);
        this.mAm.setShowMultiWindowTimeBar(z);
    }

    public View getVideoSurfaceView() {
        return this.mAi;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.mAo;
    }

    public SubtitleView getSubtitleView() {
        return this.mAl;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mAq || this.mAp == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.mAm.isVisible()) {
            vD(true);
            return true;
        } else if (this.mAv) {
            this.mAm.hide();
            return true;
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.mAq || this.mAp == null) {
            return false;
        }
        vD(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vD(boolean z) {
        if (!dqz() && this.mAq) {
            boolean z2 = this.mAm.isVisible() && this.mAm.getShowTimeoutMs() <= 0;
            boolean dwo = dwo();
            if (z || z2 || dwo) {
                rR(dwo);
            }
        }
    }

    private boolean dwo() {
        if (this.mAp == null) {
            return true;
        }
        int cXu = this.mAp.cXu();
        return this.mAu && (cXu == 1 || cXu == 4 || !this.mAp.dqr());
    }

    private void rR(boolean z) {
        if (this.mAq) {
            this.mAm.setShowTimeoutMs(z ? 0 : this.mAt);
            this.mAm.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dqz() {
        return this.mAp != null && this.mAp.dqz() && this.mAp.dqr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwp() {
        if (this.mAp != null) {
            g dqB = this.mAp.dqB();
            for (int i = 0; i < dqB.length; i++) {
                if (this.mAp.IF(i) == 2 && dqB.Lu(i) != null) {
                    dwq();
                    return;
                }
            }
            if (this.mAh != null) {
                this.mAh.setVisibility(0);
            }
            if (this.mAr) {
                for (int i2 = 0; i2 < dqB.length; i2++) {
                    f Lu = dqB.Lu(i2);
                    if (Lu != null) {
                        for (int i3 = 0; i3 < Lu.length(); i3++) {
                            Metadata metadata = Lu.KC(i3).metadata;
                            if (metadata != null && f(metadata)) {
                                return;
                            }
                        }
                        continue;
                    }
                }
                if (ad(this.mAs)) {
                    return;
                }
            }
            dwq();
        }
    }

    private boolean f(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry JR = metadata.JR(i);
            if (JR instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) JR).pictureData;
                return ad(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
        }
        return false;
    }

    private boolean ad(Bitmap bitmap) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= 0 || height <= 0) {
                return false;
            }
            if (this.mAg != null) {
                this.mAg.setAspectRatio(width / height);
            }
            this.mAj.setImageBitmap(bitmap);
            this.mAj.setVisibility(0);
            return true;
        }
        return false;
    }

    private void dwq() {
        if (this.mAj != null) {
            this.mAj.setImageResource(17170445);
            this.mAj.setVisibility(4);
        }
    }

    @TargetApi(23)
    private static void a(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(a.b.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(a.C0674a.exo_edit_mode_background_color, null));
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(a.b.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(a.C0674a.exo_edit_mode_background_color));
    }

    private static void a(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    @SuppressLint({"InlinedApi"})
    private boolean LB(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* loaded from: classes4.dex */
    private final class a extends r.a implements j, w.b {
        private a() {
        }

        @Override // com.google.android.exoplayer2.text.j
        public void fe(List<com.google.android.exoplayer2.text.b> list) {
            if (SimpleExoPlayerView.this.mAl != null) {
                SimpleExoPlayerView.this.mAl.fe(list);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void b(int i, int i2, int i3, float f) {
            if (SimpleExoPlayerView.this.mAg != null) {
                SimpleExoPlayerView.this.mAg.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void cXW() {
            if (SimpleExoPlayerView.this.mAh != null) {
                SimpleExoPlayerView.this.mAh.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(u uVar, g gVar) {
            SimpleExoPlayerView.this.dwp();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void y(boolean z, int i) {
            if (!SimpleExoPlayerView.this.dqz()) {
                SimpleExoPlayerView.this.vD(false);
            } else {
                SimpleExoPlayerView.this.dwn();
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void EJ(int i) {
            if (SimpleExoPlayerView.this.dqz()) {
                SimpleExoPlayerView.this.dwn();
            }
        }
    }
}
