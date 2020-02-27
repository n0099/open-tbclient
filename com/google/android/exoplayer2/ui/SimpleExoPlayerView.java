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
    private final AspectRatioFrameLayout mEK;
    private final View mEL;
    private final View mEM;
    private final ImageView mEN;
    private final SubtitleView mEO;
    private final PlaybackControlView mEP;
    private final a mEQ;
    private final FrameLayout mER;
    private w mES;
    private boolean mET;
    private boolean mEU;
    private Bitmap mEV;
    private int mEW;
    private boolean mEX;
    private boolean mEY;

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
            this.mEK = null;
            this.mEL = null;
            this.mEM = null;
            this.mEN = null;
            this.mEO = null;
            this.mEP = null;
            this.mEQ = null;
            this.mER = null;
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
        this.mEQ = new a();
        setDescendantFocusability(262144);
        this.mEK = (AspectRatioFrameLayout) findViewById(a.c.exo_content_frame);
        if (this.mEK != null) {
            a(this.mEK, i5);
        }
        this.mEL = findViewById(a.c.exo_shutter);
        if (this.mEL != null && z5) {
            this.mEL.setBackgroundColor(i7);
        }
        if (this.mEK != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mEM = i4 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.mEM.setLayoutParams(layoutParams);
            this.mEK.addView(this.mEM, 0);
        } else {
            this.mEM = null;
        }
        this.mER = (FrameLayout) findViewById(a.c.exo_overlay);
        this.mEN = (ImageView) findViewById(a.c.exo_artwork);
        this.mEU = z && this.mEN != null;
        if (i3 != 0) {
            this.mEV = BitmapFactory.decodeResource(context.getResources(), i3);
        }
        this.mEO = (SubtitleView) findViewById(a.c.exo_subtitles);
        if (this.mEO != null) {
            this.mEO.setUserDefaultStyle();
            this.mEO.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(a.c.exo_controller);
        View findViewById = findViewById(a.c.exo_controller_placeholder);
        if (playbackControlView != null) {
            this.mEP = playbackControlView;
        } else if (findViewById != null) {
            this.mEP = new PlaybackControlView(context, null, 0, attributeSet);
            this.mEP.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(this.mEP, indexOfChild);
        } else {
            this.mEP = null;
        }
        this.mEW = this.mEP == null ? 0 : i6;
        this.mEY = z3;
        this.mEX = z4;
        this.mET = z2 && this.mEP != null;
        dyK();
    }

    public w getPlayer() {
        return this.mES;
    }

    public void setPlayer(w wVar) {
        if (this.mES != wVar) {
            if (this.mES != null) {
                this.mES.b((r.b) this.mEQ);
                this.mES.b((j) this.mEQ);
                this.mES.b((w.b) this.mEQ);
                if (this.mEM instanceof TextureView) {
                    this.mES.c((TextureView) this.mEM);
                } else if (this.mEM instanceof SurfaceView) {
                    this.mES.b((SurfaceView) this.mEM);
                }
            }
            this.mES = wVar;
            if (this.mET) {
                this.mEP.setPlayer(wVar);
            }
            if (this.mEL != null) {
                this.mEL.setVisibility(0);
            }
            if (wVar != null) {
                if (this.mEM instanceof TextureView) {
                    wVar.b((TextureView) this.mEM);
                } else if (this.mEM instanceof SurfaceView) {
                    wVar.a((SurfaceView) this.mEM);
                }
                wVar.a((w.b) this.mEQ);
                wVar.a((j) this.mEQ);
                wVar.a((r.b) this.mEQ);
                vT(false);
                dyM();
                return;
            }
            dyK();
            dyN();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mEM instanceof SurfaceView) {
            this.mEM.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEK != null);
        this.mEK.setResizeMode(i);
    }

    public boolean getUseArtwork() {
        return this.mEU;
    }

    public void setUseArtwork(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mEN == null) ? false : true);
        if (this.mEU != z) {
            this.mEU = z;
            dyM();
        }
    }

    public Bitmap getDefaultArtwork() {
        return this.mEV;
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.mEV != bitmap) {
            this.mEV = bitmap;
            dyM();
        }
    }

    public boolean getUseController() {
        return this.mET;
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mEP == null) ? false : true);
        if (this.mET != z) {
            this.mET = z;
            if (z) {
                this.mEP.setPlayer(this.mES);
            } else if (this.mEP != null) {
                this.mEP.hide();
                this.mEP.setPlayer(null);
            }
        }
    }

    public void setShutterBackgroundColor(int i) {
        if (this.mEL != null) {
            this.mEL.setBackgroundColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mES != null && this.mES.dsZ()) {
            this.mER.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = LP(keyEvent.getKeyCode()) && this.mET && !this.mEP.isVisible();
        vT(true);
        return z || b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        return this.mET && this.mEP.b(keyEvent);
    }

    public void dyK() {
        if (this.mEP != null) {
            this.mEP.hide();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.mEW;
    }

    public void setControllerShowTimeoutMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEP != null);
        this.mEW = i;
    }

    public boolean getControllerHideOnTouch() {
        return this.mEY;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mEP != null);
        this.mEY = z;
    }

    public boolean getControllerAutoShow() {
        return this.mEX;
    }

    public void setControllerAutoShow(boolean z) {
        this.mEX = z;
    }

    public void setControllerVisibilityListener(PlaybackControlView.d dVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mEP != null);
        this.mEP.setVisibilityListener(dVar);
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mEP != null);
        this.mEP.setControlDispatcher(cVar);
    }

    public void setRewindIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEP != null);
        this.mEP.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEP != null);
        this.mEP.setFastForwardIncrementMs(i);
    }

    public void setRepeatToggleModes(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEP != null);
        this.mEP.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mEP != null);
        this.mEP.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mEP != null);
        this.mEP.setShowMultiWindowTimeBar(z);
    }

    public View getVideoSurfaceView() {
        return this.mEM;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.mER;
    }

    public SubtitleView getSubtitleView() {
        return this.mEO;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mET || this.mES == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.mEP.isVisible()) {
            vT(true);
            return true;
        } else if (this.mEY) {
            this.mEP.hide();
            return true;
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.mET || this.mES == null) {
            return false;
        }
        vT(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(boolean z) {
        if (!dsZ() && this.mET) {
            boolean z2 = this.mEP.isVisible() && this.mEP.getShowTimeoutMs() <= 0;
            boolean dyL = dyL();
            if (z || z2 || dyL) {
                sg(dyL);
            }
        }
    }

    private boolean dyL() {
        if (this.mES == null) {
            return true;
        }
        int cZN = this.mES.cZN();
        return this.mEX && (cZN == 1 || cZN == 4 || !this.mES.dsR());
    }

    private void sg(boolean z) {
        if (this.mET) {
            this.mEP.setShowTimeoutMs(z ? 0 : this.mEW);
            this.mEP.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dsZ() {
        return this.mES != null && this.mES.dsZ() && this.mES.dsR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyM() {
        if (this.mES != null) {
            g dtb = this.mES.dtb();
            for (int i = 0; i < dtb.length; i++) {
                if (this.mES.IT(i) == 2 && dtb.LI(i) != null) {
                    dyN();
                    return;
                }
            }
            if (this.mEL != null) {
                this.mEL.setVisibility(0);
            }
            if (this.mEU) {
                for (int i2 = 0; i2 < dtb.length; i2++) {
                    f LI = dtb.LI(i2);
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
                if (ae(this.mEV)) {
                    return;
                }
            }
            dyN();
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
            if (this.mEK != null) {
                this.mEK.setAspectRatio(width / height);
            }
            this.mEN.setImageBitmap(bitmap);
            this.mEN.setVisibility(0);
            return true;
        }
        return false;
    }

    private void dyN() {
        if (this.mEN != null) {
            this.mEN.setImageResource(17170445);
            this.mEN.setVisibility(4);
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
            if (SimpleExoPlayerView.this.mEO != null) {
                SimpleExoPlayerView.this.mEO.eZ(list);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void b(int i, int i2, int i3, float f) {
            if (SimpleExoPlayerView.this.mEK != null) {
                SimpleExoPlayerView.this.mEK.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void dap() {
            if (SimpleExoPlayerView.this.mEL != null) {
                SimpleExoPlayerView.this.mEL.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(u uVar, g gVar) {
            SimpleExoPlayerView.this.dyM();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
            if (!SimpleExoPlayerView.this.dsZ()) {
                SimpleExoPlayerView.this.vT(false);
            } else {
                SimpleExoPlayerView.this.dyK();
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ET(int i) {
            if (SimpleExoPlayerView.this.dsZ()) {
                SimpleExoPlayerView.this.dyK();
            }
        }
    }
}
