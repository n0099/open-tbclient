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
    private final AspectRatioFrameLayout mGE;
    private final View mGF;
    private final View mGG;
    private final ImageView mGH;
    private final SubtitleView mGI;
    private final PlaybackControlView mGJ;
    private final a mGK;
    private final FrameLayout mGL;
    private w mGM;
    private boolean mGN;
    private boolean mGO;
    private Bitmap mGP;
    private int mGQ;
    private boolean mGR;
    private boolean mGS;

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
            this.mGE = null;
            this.mGF = null;
            this.mGG = null;
            this.mGH = null;
            this.mGI = null;
            this.mGJ = null;
            this.mGK = null;
            this.mGL = null;
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
        this.mGK = new a();
        setDescendantFocusability(262144);
        this.mGE = (AspectRatioFrameLayout) findViewById(a.c.exo_content_frame);
        if (this.mGE != null) {
            a(this.mGE, i5);
        }
        this.mGF = findViewById(a.c.exo_shutter);
        if (this.mGF != null && z5) {
            this.mGF.setBackgroundColor(i7);
        }
        if (this.mGE != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mGG = i4 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.mGG.setLayoutParams(layoutParams);
            this.mGE.addView(this.mGG, 0);
        } else {
            this.mGG = null;
        }
        this.mGL = (FrameLayout) findViewById(a.c.exo_overlay);
        this.mGH = (ImageView) findViewById(a.c.exo_artwork);
        this.mGO = z && this.mGH != null;
        if (i3 != 0) {
            this.mGP = BitmapFactory.decodeResource(context.getResources(), i3);
        }
        this.mGI = (SubtitleView) findViewById(a.c.exo_subtitles);
        if (this.mGI != null) {
            this.mGI.setUserDefaultStyle();
            this.mGI.setUserDefaultTextSize();
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) findViewById(a.c.exo_controller);
        View findViewById = findViewById(a.c.exo_controller_placeholder);
        if (playbackControlView != null) {
            this.mGJ = playbackControlView;
        } else if (findViewById != null) {
            this.mGJ = new PlaybackControlView(context, null, 0, attributeSet);
            this.mGJ.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(this.mGJ, indexOfChild);
        } else {
            this.mGJ = null;
        }
        this.mGQ = this.mGJ == null ? 0 : i6;
        this.mGS = z3;
        this.mGR = z4;
        this.mGN = z2 && this.mGJ != null;
        dzk();
    }

    public w getPlayer() {
        return this.mGM;
    }

    public void setPlayer(w wVar) {
        if (this.mGM != wVar) {
            if (this.mGM != null) {
                this.mGM.b((r.b) this.mGK);
                this.mGM.b((j) this.mGK);
                this.mGM.b((w.b) this.mGK);
                if (this.mGG instanceof TextureView) {
                    this.mGM.c((TextureView) this.mGG);
                } else if (this.mGG instanceof SurfaceView) {
                    this.mGM.b((SurfaceView) this.mGG);
                }
            }
            this.mGM = wVar;
            if (this.mGN) {
                this.mGJ.setPlayer(wVar);
            }
            if (this.mGF != null) {
                this.mGF.setVisibility(0);
            }
            if (wVar != null) {
                if (this.mGG instanceof TextureView) {
                    wVar.b((TextureView) this.mGG);
                } else if (this.mGG instanceof SurfaceView) {
                    wVar.a((SurfaceView) this.mGG);
                }
                wVar.a((w.b) this.mGK);
                wVar.a((j) this.mGK);
                wVar.a((r.b) this.mGK);
                wa(false);
                dzm();
                return;
            }
            dzk();
            dzn();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mGG instanceof SurfaceView) {
            this.mGG.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mGE != null);
        this.mGE.setResizeMode(i);
    }

    public boolean getUseArtwork() {
        return this.mGO;
    }

    public void setUseArtwork(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mGH == null) ? false : true);
        if (this.mGO != z) {
            this.mGO = z;
            dzm();
        }
    }

    public Bitmap getDefaultArtwork() {
        return this.mGP;
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.mGP != bitmap) {
            this.mGP = bitmap;
            dzm();
        }
    }

    public boolean getUseController() {
        return this.mGN;
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.util.a.checkState((z && this.mGJ == null) ? false : true);
        if (this.mGN != z) {
            this.mGN = z;
            if (z) {
                this.mGJ.setPlayer(this.mGM);
            } else if (this.mGJ != null) {
                this.mGJ.hide();
                this.mGJ.setPlayer(null);
            }
        }
    }

    public void setShutterBackgroundColor(int i) {
        if (this.mGF != null) {
            this.mGF.setBackgroundColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mGM != null && this.mGM.dtz()) {
            this.mGL.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = LV(keyEvent.getKeyCode()) && this.mGN && !this.mGJ.isVisible();
        wa(true);
        return z || b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        return this.mGN && this.mGJ.b(keyEvent);
    }

    public void dzk() {
        if (this.mGJ != null) {
            this.mGJ.hide();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.mGQ;
    }

    public void setControllerShowTimeoutMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mGJ != null);
        this.mGQ = i;
    }

    public boolean getControllerHideOnTouch() {
        return this.mGS;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mGJ != null);
        this.mGS = z;
    }

    public boolean getControllerAutoShow() {
        return this.mGR;
    }

    public void setControllerAutoShow(boolean z) {
        this.mGR = z;
    }

    public void setControllerVisibilityListener(PlaybackControlView.d dVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mGJ != null);
        this.mGJ.setVisibilityListener(dVar);
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mGJ != null);
        this.mGJ.setControlDispatcher(cVar);
    }

    public void setRewindIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mGJ != null);
        this.mGJ.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mGJ != null);
        this.mGJ.setFastForwardIncrementMs(i);
    }

    public void setRepeatToggleModes(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mGJ != null);
        this.mGJ.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mGJ != null);
        this.mGJ.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mGJ != null);
        this.mGJ.setShowMultiWindowTimeBar(z);
    }

    public View getVideoSurfaceView() {
        return this.mGG;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.mGL;
    }

    public SubtitleView getSubtitleView() {
        return this.mGI;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mGN || this.mGM == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.mGJ.isVisible()) {
            wa(true);
            return true;
        } else if (this.mGS) {
            this.mGJ.hide();
            return true;
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.mGN || this.mGM == null) {
            return false;
        }
        wa(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(boolean z) {
        if (!dtz() && this.mGN) {
            boolean z2 = this.mGJ.isVisible() && this.mGJ.getShowTimeoutMs() <= 0;
            boolean dzl = dzl();
            if (z || z2 || dzl) {
                sm(dzl);
            }
        }
    }

    private boolean dzl() {
        if (this.mGM == null) {
            return true;
        }
        int dan = this.mGM.dan();
        return this.mGR && (dan == 1 || dan == 4 || !this.mGM.dtr());
    }

    private void sm(boolean z) {
        if (this.mGN) {
            this.mGJ.setShowTimeoutMs(z ? 0 : this.mGQ);
            this.mGJ.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtz() {
        return this.mGM != null && this.mGM.dtz() && this.mGM.dtr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzm() {
        if (this.mGM != null) {
            g dtB = this.mGM.dtB();
            for (int i = 0; i < dtB.length; i++) {
                if (this.mGM.IZ(i) == 2 && dtB.LO(i) != null) {
                    dzn();
                    return;
                }
            }
            if (this.mGF != null) {
                this.mGF.setVisibility(0);
            }
            if (this.mGO) {
                for (int i2 = 0; i2 < dtB.length; i2++) {
                    f LO = dtB.LO(i2);
                    if (LO != null) {
                        for (int i3 = 0; i3 < LO.length(); i3++) {
                            Metadata metadata = LO.KW(i3).metadata;
                            if (metadata != null && f(metadata)) {
                                return;
                            }
                        }
                        continue;
                    }
                }
                if (ae(this.mGP)) {
                    return;
                }
            }
            dzn();
        }
    }

    private boolean f(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry Kl = metadata.Kl(i);
            if (Kl instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) Kl).pictureData;
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
            if (this.mGE != null) {
                this.mGE.setAspectRatio(width / height);
            }
            this.mGH.setImageBitmap(bitmap);
            this.mGH.setVisibility(0);
            return true;
        }
        return false;
    }

    private void dzn() {
        if (this.mGH != null) {
            this.mGH.setImageResource(17170445);
            this.mGH.setVisibility(4);
        }
    }

    @TargetApi(23)
    private static void a(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(a.b.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(a.C0689a.exo_edit_mode_background_color, null));
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(a.b.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(a.C0689a.exo_edit_mode_background_color));
    }

    private static void a(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    @SuppressLint({"InlinedApi"})
    private boolean LV(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* loaded from: classes6.dex */
    private final class a extends r.a implements j, w.b {
        private a() {
        }

        @Override // com.google.android.exoplayer2.text.j
        public void eZ(List<com.google.android.exoplayer2.text.b> list) {
            if (SimpleExoPlayerView.this.mGI != null) {
                SimpleExoPlayerView.this.mGI.eZ(list);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void b(int i, int i2, int i3, float f) {
            if (SimpleExoPlayerView.this.mGE != null) {
                SimpleExoPlayerView.this.mGE.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
            }
        }

        @Override // com.google.android.exoplayer2.w.b
        public void daP() {
            if (SimpleExoPlayerView.this.mGF != null) {
                SimpleExoPlayerView.this.mGF.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(u uVar, g gVar) {
            SimpleExoPlayerView.this.dzm();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
            if (!SimpleExoPlayerView.this.dtz()) {
                SimpleExoPlayerView.this.wa(false);
            } else {
                SimpleExoPlayerView.this.dzk();
            }
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void Fa(int i) {
            if (SimpleExoPlayerView.this.dtz()) {
                SimpleExoPlayerView.this.dzk();
            }
        }
    }
}
