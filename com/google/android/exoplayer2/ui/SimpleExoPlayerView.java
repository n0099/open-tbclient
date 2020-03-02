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
    private final AspectRatioFrameLayout mEM;
    private final View mEN;
    private final View mEO;
    private final ImageView mEP;
    private final SubtitleView mEQ;
    private final PlaybackControlView mER;
    private final a mES;
    private final FrameLayout mET;
    private w mEU;
    private boolean mEV;
    private boolean mEW;
    private Bitmap mEX;
    private int mEY;
    private boolean mEZ;
    private boolean mFa;

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
            this.mEM = null;
            this.mEN = null;
            this.mEO = null;
            this.mEP = null;
            this.mEQ = null;
            this.mER = null;
            this.mES = null;
            this.mET = null;
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
        this.mES = new a();
        setDescendantFocusability(262144);
        this.mEM = (AspectRatioFrameLayout) findViewById(a.c.exo_content_frame);
        if (this.mEM != null) {
            a(this.mEM, i5);
        }
        this.mEN = findViewById(a.c.exo_shutter);
        if (this.mEN != null && z5) {
            this.mEN.setBackgroundColor(i7);
        }
        if (this.mEM != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mEO = i4 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.mEO.setLayoutParams(layoutParams);
            this.mEM.addView(this.mEO, 0);
        } else {
            this.mEO = null;
        }
        this.mET = (FrameLayout) findViewById(a.c.exo_overlay);
        this.mEP = (ImageView) findViewById(a.c.exo_artwork);
        this.mEW = z && this.mEP != null;
        if (i3 != 0) {
            this.mEX = BitmapFactory.decodeResource(context.getResources(), i3);
        }
        this.mEQ = (SubtitleView) findViewById(a.c.exo_subtitles);
        if (this.mEQ != null) {
            this.mEQ.setUserDefaultStyle();
            this.mEQ.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(a.c.exo_controller);
        View findViewById = findViewById(a.c.exo_controller_placeholder);
        if (playbackControlView != null) {
            this.mER = playbackControlView;
        } else if (findViewById != null) {
            this.mER = new PlaybackControlView(context, null, 0, attributeSet);
            this.mER.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(this.mER, indexOfChild);
        } else {
            this.mER = null;
        }
        this.mEY = this.mER == null ? 0 : i6;
        this.mFa = z3;
        this.mEZ = z4;
        this.mEV = z2 && this.mER != null;
        dyM();
    }

    public w getPlayer() {
        return this.mEU;
    }

    public void setPlayer(w wVar) {
        if (this.mEU != wVar) {
            if (this.mEU != null) {
                this.mEU.b((r.b) this.mES);
                this.mEU.b((j) this.mES);
                this.mEU.b((w.b) this.mES);
                if (this.mEO instanceof TextureView) {
                    this.mEU.c((TextureView) this.mEO);
                } else if (this.mEO instanceof SurfaceView) {
                    this.mEU.b((SurfaceView) this.mEO);
                }
            }
            this.mEU = wVar;
            if (this.mEV) {
                this.mER.setPlayer(wVar);
            }
            if (this.mEN != null) {
                this.mEN.setVisibility(0);
            }
            if (wVar != null) {
                if (this.mEO instanceof TextureView) {
                    wVar.b((TextureView) this.mEO);
                } else if (this.mEO instanceof SurfaceView) {
                    wVar.a((SurfaceView) this.mEO);
                }
                wVar.a((w.b) this.mES);
                wVar.a((j) this.mES);
                wVar.a((r.b) this.mES);
                vT(false);
                dyO();
                return;
            }
            dyM();
            dyP();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mEO instanceof SurfaceView) {
            this.mEO.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEM != null);
        this.mEM.setResizeMode(i);
    }

    public boolean getUseArtwork() {
        return this.mEW;
    }

    public void setUseArtwork(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mEP == null) ? false : true);
        if (this.mEW != z) {
            this.mEW = z;
            dyO();
        }
    }

    public Bitmap getDefaultArtwork() {
        return this.mEX;
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.mEX != bitmap) {
            this.mEX = bitmap;
            dyO();
        }
    }

    public boolean getUseController() {
        return this.mEV;
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mER == null) ? false : true);
        if (this.mEV != z) {
            this.mEV = z;
            if (z) {
                this.mER.setPlayer(this.mEU);
            } else if (this.mER != null) {
                this.mER.hide();
                this.mER.setPlayer(null);
            }
        }
    }

    public void setShutterBackgroundColor(int i) {
        if (this.mEN != null) {
            this.mEN.setBackgroundColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mEU != null && this.mEU.dtb()) {
            this.mET.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = LP(keyEvent.getKeyCode()) && this.mEV && !this.mER.isVisible();
        vT(true);
        return z || b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        return this.mEV && this.mER.b(keyEvent);
    }

    public void dyM() {
        if (this.mER != null) {
            this.mER.hide();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.mEY;
    }

    public void setControllerShowTimeoutMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mER != null);
        this.mEY = i;
    }

    public boolean getControllerHideOnTouch() {
        return this.mFa;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mER != null);
        this.mFa = z;
    }

    public boolean getControllerAutoShow() {
        return this.mEZ;
    }

    public void setControllerAutoShow(boolean z) {
        this.mEZ = z;
    }

    public void setControllerVisibilityListener(PlaybackControlView.d dVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mER != null);
        this.mER.setVisibilityListener(dVar);
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mER != null);
        this.mER.setControlDispatcher(cVar);
    }

    public void setRewindIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mER != null);
        this.mER.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mER != null);
        this.mER.setFastForwardIncrementMs(i);
    }

    public void setRepeatToggleModes(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mER != null);
        this.mER.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mER != null);
        this.mER.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mER != null);
        this.mER.setShowMultiWindowTimeBar(z);
    }

    public View getVideoSurfaceView() {
        return this.mEO;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.mET;
    }

    public SubtitleView getSubtitleView() {
        return this.mEQ;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEV || this.mEU == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.mER.isVisible()) {
            vT(true);
            return true;
        } else if (this.mFa) {
            this.mER.hide();
            return true;
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.mEV || this.mEU == null) {
            return false;
        }
        vT(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(boolean z) {
        if (!dtb() && this.mEV) {
            boolean z2 = this.mER.isVisible() && this.mER.getShowTimeoutMs() <= 0;
            boolean dyN = dyN();
            if (z || z2 || dyN) {
                sg(dyN);
            }
        }
    }

    private boolean dyN() {
        if (this.mEU == null) {
            return true;
        }
        int cZP = this.mEU.cZP();
        return this.mEZ && (cZP == 1 || cZP == 4 || !this.mEU.dsT());
    }

    private void sg(boolean z) {
        if (this.mEV) {
            this.mER.setShowTimeoutMs(z ? 0 : this.mEY);
            this.mER.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtb() {
        return this.mEU != null && this.mEU.dtb() && this.mEU.dsT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyO() {
        if (this.mEU != null) {
            g dtd = this.mEU.dtd();
            for (int i = 0; i < dtd.length; i++) {
                if (this.mEU.IT(i) == 2 && dtd.LI(i) != null) {
                    dyP();
                    return;
                }
            }
            if (this.mEN != null) {
                this.mEN.setVisibility(0);
            }
            if (this.mEW) {
                for (int i2 = 0; i2 < dtd.length; i2++) {
                    f LI = dtd.LI(i2);
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
                if (ae(this.mEX)) {
                    return;
                }
            }
            dyP();
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
            if (this.mEM != null) {
                this.mEM.setAspectRatio(width / height);
            }
            this.mEP.setImageBitmap(bitmap);
            this.mEP.setVisibility(0);
            return true;
        }
        return false;
    }

    private void dyP() {
        if (this.mEP != null) {
            this.mEP.setImageResource(17170445);
            this.mEP.setVisibility(4);
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
            if (SimpleExoPlayerView.this.mEQ != null) {
                SimpleExoPlayerView.this.mEQ.eZ(list);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void b(int i, int i2, int i3, float f) {
            if (SimpleExoPlayerView.this.mEM != null) {
                SimpleExoPlayerView.this.mEM.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void dar() {
            if (SimpleExoPlayerView.this.mEN != null) {
                SimpleExoPlayerView.this.mEN.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(u uVar, g gVar) {
            SimpleExoPlayerView.this.dyO();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
            if (!SimpleExoPlayerView.this.dtb()) {
                SimpleExoPlayerView.this.vT(false);
            } else {
                SimpleExoPlayerView.this.dyM();
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ET(int i) {
            if (SimpleExoPlayerView.this.dtb()) {
                SimpleExoPlayerView.this.dyM();
            }
        }
    }
}
