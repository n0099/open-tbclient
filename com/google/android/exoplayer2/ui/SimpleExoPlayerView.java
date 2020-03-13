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
/* loaded from: classes6.dex */
public final class SimpleExoPlayerView extends FrameLayout {
    private final AspectRatioFrameLayout mEX;
    private final View mEY;
    private final View mEZ;
    private final ImageView mFa;
    private final SubtitleView mFb;
    private final PlaybackControlView mFc;
    private final a mFe;
    private final FrameLayout mFf;
    private w mFg;
    private boolean mFh;
    private boolean mFi;
    private Bitmap mFj;
    private int mFk;
    private boolean mFl;
    private boolean mFm;

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
            this.mEX = null;
            this.mEY = null;
            this.mEZ = null;
            this.mFa = null;
            this.mFb = null;
            this.mFc = null;
            this.mFe = null;
            this.mFf = null;
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
        this.mFe = new a();
        setDescendantFocusability(262144);
        this.mEX = (AspectRatioFrameLayout) findViewById(a.c.exo_content_frame);
        if (this.mEX != null) {
            a(this.mEX, i5);
        }
        this.mEY = findViewById(a.c.exo_shutter);
        if (this.mEY != null && z5) {
            this.mEY.setBackgroundColor(i7);
        }
        if (this.mEX != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mEZ = i4 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.mEZ.setLayoutParams(layoutParams);
            this.mEX.addView(this.mEZ, 0);
        } else {
            this.mEZ = null;
        }
        this.mFf = (FrameLayout) findViewById(a.c.exo_overlay);
        this.mFa = (ImageView) findViewById(a.c.exo_artwork);
        this.mFi = z && this.mFa != null;
        if (i3 != 0) {
            this.mFj = BitmapFactory.decodeResource(context.getResources(), i3);
        }
        this.mFb = (SubtitleView) findViewById(a.c.exo_subtitles);
        if (this.mFb != null) {
            this.mFb.setUserDefaultStyle();
            this.mFb.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(a.c.exo_controller);
        View findViewById = findViewById(a.c.exo_controller_placeholder);
        if (playbackControlView != null) {
            this.mFc = playbackControlView;
        } else if (findViewById != null) {
            this.mFc = new PlaybackControlView(context, null, 0, attributeSet);
            this.mFc.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(this.mFc, indexOfChild);
        } else {
            this.mFc = null;
        }
        this.mFk = this.mFc == null ? 0 : i6;
        this.mFm = z3;
        this.mFl = z4;
        this.mFh = z2 && this.mFc != null;
        dyN();
    }

    public w getPlayer() {
        return this.mFg;
    }

    public void setPlayer(w wVar) {
        if (this.mFg != wVar) {
            if (this.mFg != null) {
                this.mFg.b((r.b) this.mFe);
                this.mFg.b((j) this.mFe);
                this.mFg.b((w.b) this.mFe);
                if (this.mEZ instanceof TextureView) {
                    this.mFg.c((TextureView) this.mEZ);
                } else if (this.mEZ instanceof SurfaceView) {
                    this.mFg.b((SurfaceView) this.mEZ);
                }
            }
            this.mFg = wVar;
            if (this.mFh) {
                this.mFc.setPlayer(wVar);
            }
            if (this.mEY != null) {
                this.mEY.setVisibility(0);
            }
            if (wVar != null) {
                if (this.mEZ instanceof TextureView) {
                    wVar.b((TextureView) this.mEZ);
                } else if (this.mEZ instanceof SurfaceView) {
                    wVar.a((SurfaceView) this.mEZ);
                }
                wVar.a((w.b) this.mFe);
                wVar.a((j) this.mFe);
                wVar.a((r.b) this.mFe);
                vT(false);
                dyP();
                return;
            }
            dyN();
            dyQ();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mEZ instanceof SurfaceView) {
            this.mEZ.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEX != null);
        this.mEX.setResizeMode(i);
    }

    public boolean getUseArtwork() {
        return this.mFi;
    }

    public void setUseArtwork(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mFa == null) ? false : true);
        if (this.mFi != z) {
            this.mFi = z;
            dyP();
        }
    }

    public Bitmap getDefaultArtwork() {
        return this.mFj;
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.mFj != bitmap) {
            this.mFj = bitmap;
            dyP();
        }
    }

    public boolean getUseController() {
        return this.mFh;
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mFc == null) ? false : true);
        if (this.mFh != z) {
            this.mFh = z;
            if (z) {
                this.mFc.setPlayer(this.mFg);
            } else if (this.mFc != null) {
                this.mFc.hide();
                this.mFc.setPlayer(null);
            }
        }
    }

    public void setShutterBackgroundColor(int i) {
        if (this.mEY != null) {
            this.mEY.setBackgroundColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mFg != null && this.mFg.dtc()) {
            this.mFf.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = LP(keyEvent.getKeyCode()) && this.mFh && !this.mFc.isVisible();
        vT(true);
        return z || b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        return this.mFh && this.mFc.b(keyEvent);
    }

    public void dyN() {
        if (this.mFc != null) {
            this.mFc.hide();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.mFk;
    }

    public void setControllerShowTimeoutMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mFc != null);
        this.mFk = i;
    }

    public boolean getControllerHideOnTouch() {
        return this.mFm;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mFc != null);
        this.mFm = z;
    }

    public boolean getControllerAutoShow() {
        return this.mFl;
    }

    public void setControllerAutoShow(boolean z) {
        this.mFl = z;
    }

    public void setControllerVisibilityListener(PlaybackControlView.d dVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mFc != null);
        this.mFc.setVisibilityListener(dVar);
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mFc != null);
        this.mFc.setControlDispatcher(cVar);
    }

    public void setRewindIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mFc != null);
        this.mFc.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mFc != null);
        this.mFc.setFastForwardIncrementMs(i);
    }

    public void setRepeatToggleModes(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mFc != null);
        this.mFc.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mFc != null);
        this.mFc.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mFc != null);
        this.mFc.setShowMultiWindowTimeBar(z);
    }

    public View getVideoSurfaceView() {
        return this.mEZ;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.mFf;
    }

    public SubtitleView getSubtitleView() {
        return this.mFb;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mFh || this.mFg == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.mFc.isVisible()) {
            vT(true);
            return true;
        } else if (this.mFm) {
            this.mFc.hide();
            return true;
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.mFh || this.mFg == null) {
            return false;
        }
        vT(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(boolean z) {
        if (!dtc() && this.mFh) {
            boolean z2 = this.mFc.isVisible() && this.mFc.getShowTimeoutMs() <= 0;
            boolean dyO = dyO();
            if (z || z2 || dyO) {
                sg(dyO);
            }
        }
    }

    private boolean dyO() {
        if (this.mFg == null) {
            return true;
        }
        int cZQ = this.mFg.cZQ();
        return this.mFl && (cZQ == 1 || cZQ == 4 || !this.mFg.dsU());
    }

    private void sg(boolean z) {
        if (this.mFh) {
            this.mFc.setShowTimeoutMs(z ? 0 : this.mFk);
            this.mFc.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtc() {
        return this.mFg != null && this.mFg.dtc() && this.mFg.dsU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyP() {
        if (this.mFg != null) {
            g dte = this.mFg.dte();
            for (int i = 0; i < dte.length; i++) {
                if (this.mFg.IT(i) == 2 && dte.LI(i) != null) {
                    dyQ();
                    return;
                }
            }
            if (this.mEY != null) {
                this.mEY.setVisibility(0);
            }
            if (this.mFi) {
                for (int i2 = 0; i2 < dte.length; i2++) {
                    f LI = dte.LI(i2);
                    if (LI != null) {
                        for (int i3 = 0; i3 < LI.length(); i3++) {
                            Metadata metadata = LI.KQ(i3).metadata;
                            if (metadata != null && f(metadata)) {
                                return;
                            }
                        }
                        continue;
                    }
                }
                if (ae(this.mFj)) {
                    return;
                }
            }
            dyQ();
        }
    }

    private boolean f(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry Kf = metadata.Kf(i);
            if (Kf instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) Kf).pictureData;
                return ae(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
        }
        return false;
    }

    private boolean ae(Bitmap bitmap) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= 0 || height <= 0) {
                return false;
            }
            if (this.mEX != null) {
                this.mEX.setAspectRatio(width / height);
            }
            this.mFa.setImageBitmap(bitmap);
            this.mFa.setVisibility(0);
            return true;
        }
        return false;
    }

    private void dyQ() {
        if (this.mFa != null) {
            this.mFa.setImageResource(17170445);
            this.mFa.setVisibility(4);
        }
    }

    @TargetApi(23)
    private static void a(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(a.b.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(a.C0688a.exo_edit_mode_background_color, null));
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(a.b.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(a.C0688a.exo_edit_mode_background_color));
    }

    private static void a(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    @SuppressLint({"InlinedApi"})
    private boolean LP(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* loaded from: classes6.dex */
    private final class a extends r.a implements j, w.b {
        private a() {
        }

        @Override // com.google.android.exoplayer2.text.j
        public void eZ(List<com.google.android.exoplayer2.text.b> list) {
            if (SimpleExoPlayerView.this.mFb != null) {
                SimpleExoPlayerView.this.mFb.eZ(list);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void b(int i, int i2, int i3, float f) {
            if (SimpleExoPlayerView.this.mEX != null) {
                SimpleExoPlayerView.this.mEX.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void das() {
            if (SimpleExoPlayerView.this.mEY != null) {
                SimpleExoPlayerView.this.mEY.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(u uVar, g gVar) {
            SimpleExoPlayerView.this.dyP();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
            if (!SimpleExoPlayerView.this.dtc()) {
                SimpleExoPlayerView.this.vT(false);
            } else {
                SimpleExoPlayerView.this.dyN();
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ET(int i) {
            if (SimpleExoPlayerView.this.dtc()) {
                SimpleExoPlayerView.this.dyN();
            }
        }
    }
}
