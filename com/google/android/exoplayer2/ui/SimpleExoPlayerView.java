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
/* loaded from: classes5.dex */
public final class SimpleExoPlayerView extends FrameLayout {
    private final AspectRatioFrameLayout mDZ;
    private final View mEa;
    private final View mEb;
    private final ImageView mEc;
    private final SubtitleView mEd;
    private final PlaybackControlView mEe;
    private final a mEf;
    private final FrameLayout mEg;
    private w mEh;
    private boolean mEi;
    private boolean mEj;
    private Bitmap mEk;
    private int mEl;
    private boolean mEm;
    private boolean mEn;

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
            this.mDZ = null;
            this.mEa = null;
            this.mEb = null;
            this.mEc = null;
            this.mEd = null;
            this.mEe = null;
            this.mEf = null;
            this.mEg = null;
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
        this.mEf = new a();
        setDescendantFocusability(262144);
        this.mDZ = (AspectRatioFrameLayout) findViewById(a.c.exo_content_frame);
        if (this.mDZ != null) {
            a(this.mDZ, i5);
        }
        this.mEa = findViewById(a.c.exo_shutter);
        if (this.mEa != null && z5) {
            this.mEa.setBackgroundColor(i7);
        }
        if (this.mDZ != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mEb = i4 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.mEb.setLayoutParams(layoutParams);
            this.mDZ.addView(this.mEb, 0);
        } else {
            this.mEb = null;
        }
        this.mEg = (FrameLayout) findViewById(a.c.exo_overlay);
        this.mEc = (ImageView) findViewById(a.c.exo_artwork);
        this.mEj = z && this.mEc != null;
        if (i3 != 0) {
            this.mEk = BitmapFactory.decodeResource(context.getResources(), i3);
        }
        this.mEd = (SubtitleView) findViewById(a.c.exo_subtitles);
        if (this.mEd != null) {
            this.mEd.setUserDefaultStyle();
            this.mEd.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(a.c.exo_controller);
        View findViewById = findViewById(a.c.exo_controller_placeholder);
        if (playbackControlView != null) {
            this.mEe = playbackControlView;
        } else if (findViewById != null) {
            this.mEe = new PlaybackControlView(context, null, 0, attributeSet);
            this.mEe.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(this.mEe, indexOfChild);
        } else {
            this.mEe = null;
        }
        this.mEl = this.mEe == null ? 0 : i6;
        this.mEn = z3;
        this.mEm = z4;
        this.mEi = z2 && this.mEe != null;
        dxy();
    }

    public w getPlayer() {
        return this.mEh;
    }

    public void setPlayer(w wVar) {
        if (this.mEh != wVar) {
            if (this.mEh != null) {
                this.mEh.b((r.b) this.mEf);
                this.mEh.b((j) this.mEf);
                this.mEh.b((w.b) this.mEf);
                if (this.mEb instanceof TextureView) {
                    this.mEh.c((TextureView) this.mEb);
                } else if (this.mEb instanceof SurfaceView) {
                    this.mEh.b((SurfaceView) this.mEb);
                }
            }
            this.mEh = wVar;
            if (this.mEi) {
                this.mEe.setPlayer(wVar);
            }
            if (this.mEa != null) {
                this.mEa.setVisibility(0);
            }
            if (wVar != null) {
                if (this.mEb instanceof TextureView) {
                    wVar.b((TextureView) this.mEb);
                } else if (this.mEb instanceof SurfaceView) {
                    wVar.a((SurfaceView) this.mEb);
                }
                wVar.a((w.b) this.mEf);
                wVar.a((j) this.mEf);
                wVar.a((r.b) this.mEf);
                vP(false);
                dxA();
                return;
            }
            dxy();
            dxB();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mEb instanceof SurfaceView) {
            this.mEb.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mDZ != null);
        this.mDZ.setResizeMode(i);
    }

    public boolean getUseArtwork() {
        return this.mEj;
    }

    public void setUseArtwork(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mEc == null) ? false : true);
        if (this.mEj != z) {
            this.mEj = z;
            dxA();
        }
    }

    public Bitmap getDefaultArtwork() {
        return this.mEk;
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.mEk != bitmap) {
            this.mEk = bitmap;
            dxA();
        }
    }

    public boolean getUseController() {
        return this.mEi;
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mEe == null) ? false : true);
        if (this.mEi != z) {
            this.mEi = z;
            if (z) {
                this.mEe.setPlayer(this.mEh);
            } else if (this.mEe != null) {
                this.mEe.hide();
                this.mEe.setPlayer(null);
            }
        }
    }

    public void setShutterBackgroundColor(int i) {
        if (this.mEa != null) {
            this.mEa.setBackgroundColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mEh != null && this.mEh.drL()) {
            this.mEg.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = LK(keyEvent.getKeyCode()) && this.mEi && !this.mEe.isVisible();
        vP(true);
        return z || b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        return this.mEi && this.mEe.b(keyEvent);
    }

    public void dxy() {
        if (this.mEe != null) {
            this.mEe.hide();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.mEl;
    }

    public void setControllerShowTimeoutMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEl = i;
    }

    public boolean getControllerHideOnTouch() {
        return this.mEn;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEn = z;
    }

    public boolean getControllerAutoShow() {
        return this.mEm;
    }

    public void setControllerAutoShow(boolean z) {
        this.mEm = z;
    }

    public void setControllerVisibilityListener(PlaybackControlView.d dVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEe.setVisibilityListener(dVar);
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEe.setControlDispatcher(cVar);
    }

    public void setRewindIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEe.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEe.setFastForwardIncrementMs(i);
    }

    public void setRepeatToggleModes(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEe.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEe.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEe.setShowMultiWindowTimeBar(z);
    }

    public View getVideoSurfaceView() {
        return this.mEb;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.mEg;
    }

    public SubtitleView getSubtitleView() {
        return this.mEd;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEi || this.mEh == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.mEe.isVisible()) {
            vP(true);
            return true;
        } else if (this.mEn) {
            this.mEe.hide();
            return true;
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.mEi || this.mEh == null) {
            return false;
        }
        vP(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(boolean z) {
        if (!drL() && this.mEi) {
            boolean z2 = this.mEe.isVisible() && this.mEe.getShowTimeoutMs() <= 0;
            boolean dxz = dxz();
            if (z || z2 || dxz) {
                sd(dxz);
            }
        }
    }

    private boolean dxz() {
        if (this.mEh == null) {
            return true;
        }
        int cYx = this.mEh.cYx();
        return this.mEm && (cYx == 1 || cYx == 4 || !this.mEh.drD());
    }

    private void sd(boolean z) {
        if (this.mEi) {
            this.mEe.setShowTimeoutMs(z ? 0 : this.mEl);
            this.mEe.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean drL() {
        return this.mEh != null && this.mEh.drL() && this.mEh.drD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxA() {
        if (this.mEh != null) {
            g drN = this.mEh.drN();
            for (int i = 0; i < drN.length; i++) {
                if (this.mEh.IO(i) == 2 && drN.LD(i) != null) {
                    dxB();
                    return;
                }
            }
            if (this.mEa != null) {
                this.mEa.setVisibility(0);
            }
            if (this.mEj) {
                for (int i2 = 0; i2 < drN.length; i2++) {
                    f LD = drN.LD(i2);
                    if (LD != null) {
                        for (int i3 = 0; i3 < LD.length(); i3++) {
                            Metadata metadata = LD.KL(i3).metadata;
                            if (metadata != null && f(metadata)) {
                                return;
                            }
                        }
                        continue;
                    }
                }
                if (ae(this.mEk)) {
                    return;
                }
            }
            dxB();
        }
    }

    private boolean f(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry Ka = metadata.Ka(i);
            if (Ka instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) Ka).pictureData;
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
            if (this.mDZ != null) {
                this.mDZ.setAspectRatio(width / height);
            }
            this.mEc.setImageBitmap(bitmap);
            this.mEc.setVisibility(0);
            return true;
        }
        return false;
    }

    private void dxB() {
        if (this.mEc != null) {
            this.mEc.setImageResource(17170445);
            this.mEc.setVisibility(4);
        }
    }

    @TargetApi(23)
    private static void a(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(a.b.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(a.C0680a.exo_edit_mode_background_color, null));
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(a.b.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(a.C0680a.exo_edit_mode_background_color));
    }

    private static void a(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    @SuppressLint({"InlinedApi"})
    private boolean LK(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* loaded from: classes5.dex */
    private final class a extends r.a implements j, w.b {
        private a() {
        }

        @Override // com.google.android.exoplayer2.text.j
        public void fe(List<com.google.android.exoplayer2.text.b> list) {
            if (SimpleExoPlayerView.this.mEd != null) {
                SimpleExoPlayerView.this.mEd.fe(list);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void b(int i, int i2, int i3, float f) {
            if (SimpleExoPlayerView.this.mDZ != null) {
                SimpleExoPlayerView.this.mDZ.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void cYZ() {
            if (SimpleExoPlayerView.this.mEa != null) {
                SimpleExoPlayerView.this.mEa.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(u uVar, g gVar) {
            SimpleExoPlayerView.this.dxA();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void z(boolean z, int i) {
            if (!SimpleExoPlayerView.this.drL()) {
                SimpleExoPlayerView.this.vP(false);
            } else {
                SimpleExoPlayerView.this.dxy();
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void EO(int i) {
            if (SimpleExoPlayerView.this.drL()) {
                SimpleExoPlayerView.this.dxy();
            }
        }
    }
}
