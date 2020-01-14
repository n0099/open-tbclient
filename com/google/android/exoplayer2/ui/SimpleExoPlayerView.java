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
    private final AspectRatioFrameLayout mEe;
    private final View mEf;
    private final View mEg;
    private final ImageView mEh;
    private final SubtitleView mEi;
    private final PlaybackControlView mEj;
    private final a mEk;
    private final FrameLayout mEl;
    private w mEm;
    private boolean mEn;
    private boolean mEo;
    private Bitmap mEp;
    private int mEq;
    private boolean mEr;
    private boolean mEs;

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
            this.mEe = null;
            this.mEf = null;
            this.mEg = null;
            this.mEh = null;
            this.mEi = null;
            this.mEj = null;
            this.mEk = null;
            this.mEl = null;
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
        this.mEk = new a();
        setDescendantFocusability(262144);
        this.mEe = (AspectRatioFrameLayout) findViewById(a.c.exo_content_frame);
        if (this.mEe != null) {
            a(this.mEe, i5);
        }
        this.mEf = findViewById(a.c.exo_shutter);
        if (this.mEf != null && z5) {
            this.mEf.setBackgroundColor(i7);
        }
        if (this.mEe != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mEg = i4 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.mEg.setLayoutParams(layoutParams);
            this.mEe.addView(this.mEg, 0);
        } else {
            this.mEg = null;
        }
        this.mEl = (FrameLayout) findViewById(a.c.exo_overlay);
        this.mEh = (ImageView) findViewById(a.c.exo_artwork);
        this.mEo = z && this.mEh != null;
        if (i3 != 0) {
            this.mEp = BitmapFactory.decodeResource(context.getResources(), i3);
        }
        this.mEi = (SubtitleView) findViewById(a.c.exo_subtitles);
        if (this.mEi != null) {
            this.mEi.setUserDefaultStyle();
            this.mEi.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(a.c.exo_controller);
        View findViewById = findViewById(a.c.exo_controller_placeholder);
        if (playbackControlView != null) {
            this.mEj = playbackControlView;
        } else if (findViewById != null) {
            this.mEj = new PlaybackControlView(context, null, 0, attributeSet);
            this.mEj.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(this.mEj, indexOfChild);
        } else {
            this.mEj = null;
        }
        this.mEq = this.mEj == null ? 0 : i6;
        this.mEs = z3;
        this.mEr = z4;
        this.mEn = z2 && this.mEj != null;
        dxA();
    }

    public w getPlayer() {
        return this.mEm;
    }

    public void setPlayer(w wVar) {
        if (this.mEm != wVar) {
            if (this.mEm != null) {
                this.mEm.b((r.b) this.mEk);
                this.mEm.b((j) this.mEk);
                this.mEm.b((w.b) this.mEk);
                if (this.mEg instanceof TextureView) {
                    this.mEm.c((TextureView) this.mEg);
                } else if (this.mEg instanceof SurfaceView) {
                    this.mEm.b((SurfaceView) this.mEg);
                }
            }
            this.mEm = wVar;
            if (this.mEn) {
                this.mEj.setPlayer(wVar);
            }
            if (this.mEf != null) {
                this.mEf.setVisibility(0);
            }
            if (wVar != null) {
                if (this.mEg instanceof TextureView) {
                    wVar.b((TextureView) this.mEg);
                } else if (this.mEg instanceof SurfaceView) {
                    wVar.a((SurfaceView) this.mEg);
                }
                wVar.a((w.b) this.mEk);
                wVar.a((j) this.mEk);
                wVar.a((r.b) this.mEk);
                vP(false);
                dxC();
                return;
            }
            dxA();
            dxD();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mEg instanceof SurfaceView) {
            this.mEg.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEe != null);
        this.mEe.setResizeMode(i);
    }

    public boolean getUseArtwork() {
        return this.mEo;
    }

    public void setUseArtwork(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mEh == null) ? false : true);
        if (this.mEo != z) {
            this.mEo = z;
            dxC();
        }
    }

    public Bitmap getDefaultArtwork() {
        return this.mEp;
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.mEp != bitmap) {
            this.mEp = bitmap;
            dxC();
        }
    }

    public boolean getUseController() {
        return this.mEn;
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mEj == null) ? false : true);
        if (this.mEn != z) {
            this.mEn = z;
            if (z) {
                this.mEj.setPlayer(this.mEm);
            } else if (this.mEj != null) {
                this.mEj.hide();
                this.mEj.setPlayer(null);
            }
        }
    }

    public void setShutterBackgroundColor(int i) {
        if (this.mEf != null) {
            this.mEf.setBackgroundColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mEm != null && this.mEm.drN()) {
            this.mEl.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = LK(keyEvent.getKeyCode()) && this.mEn && !this.mEj.isVisible();
        vP(true);
        return z || b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        return this.mEn && this.mEj.b(keyEvent);
    }

    public void dxA() {
        if (this.mEj != null) {
            this.mEj.hide();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.mEq;
    }

    public void setControllerShowTimeoutMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEj != null);
        this.mEq = i;
    }

    public boolean getControllerHideOnTouch() {
        return this.mEs;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mEj != null);
        this.mEs = z;
    }

    public boolean getControllerAutoShow() {
        return this.mEr;
    }

    public void setControllerAutoShow(boolean z) {
        this.mEr = z;
    }

    public void setControllerVisibilityListener(PlaybackControlView.d dVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mEj != null);
        this.mEj.setVisibilityListener(dVar);
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mEj != null);
        this.mEj.setControlDispatcher(cVar);
    }

    public void setRewindIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEj != null);
        this.mEj.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEj != null);
        this.mEj.setFastForwardIncrementMs(i);
    }

    public void setRepeatToggleModes(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mEj != null);
        this.mEj.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mEj != null);
        this.mEj.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mEj != null);
        this.mEj.setShowMultiWindowTimeBar(z);
    }

    public View getVideoSurfaceView() {
        return this.mEg;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.mEl;
    }

    public SubtitleView getSubtitleView() {
        return this.mEi;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEn || this.mEm == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.mEj.isVisible()) {
            vP(true);
            return true;
        } else if (this.mEs) {
            this.mEj.hide();
            return true;
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.mEn || this.mEm == null) {
            return false;
        }
        vP(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(boolean z) {
        if (!drN() && this.mEn) {
            boolean z2 = this.mEj.isVisible() && this.mEj.getShowTimeoutMs() <= 0;
            boolean dxB = dxB();
            if (z || z2 || dxB) {
                sd(dxB);
            }
        }
    }

    private boolean dxB() {
        if (this.mEm == null) {
            return true;
        }
        int cYz = this.mEm.cYz();
        return this.mEr && (cYz == 1 || cYz == 4 || !this.mEm.drF());
    }

    private void sd(boolean z) {
        if (this.mEn) {
            this.mEj.setShowTimeoutMs(z ? 0 : this.mEq);
            this.mEj.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean drN() {
        return this.mEm != null && this.mEm.drN() && this.mEm.drF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxC() {
        if (this.mEm != null) {
            g drP = this.mEm.drP();
            for (int i = 0; i < drP.length; i++) {
                if (this.mEm.IO(i) == 2 && drP.LD(i) != null) {
                    dxD();
                    return;
                }
            }
            if (this.mEf != null) {
                this.mEf.setVisibility(0);
            }
            if (this.mEo) {
                for (int i2 = 0; i2 < drP.length; i2++) {
                    f LD = drP.LD(i2);
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
                if (ae(this.mEp)) {
                    return;
                }
            }
            dxD();
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
            if (this.mEe != null) {
                this.mEe.setAspectRatio(width / height);
            }
            this.mEh.setImageBitmap(bitmap);
            this.mEh.setVisibility(0);
            return true;
        }
        return false;
    }

    private void dxD() {
        if (this.mEh != null) {
            this.mEh.setImageResource(17170445);
            this.mEh.setVisibility(4);
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
            if (SimpleExoPlayerView.this.mEi != null) {
                SimpleExoPlayerView.this.mEi.fe(list);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void b(int i, int i2, int i3, float f) {
            if (SimpleExoPlayerView.this.mEe != null) {
                SimpleExoPlayerView.this.mEe.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void cZb() {
            if (SimpleExoPlayerView.this.mEf != null) {
                SimpleExoPlayerView.this.mEf.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(u uVar, g gVar) {
            SimpleExoPlayerView.this.dxC();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void z(boolean z, int i) {
            if (!SimpleExoPlayerView.this.drN()) {
                SimpleExoPlayerView.this.vP(false);
            } else {
                SimpleExoPlayerView.this.dxA();
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void EO(int i) {
            if (SimpleExoPlayerView.this.drN()) {
                SimpleExoPlayerView.this.dxA();
            }
        }
    }
}
