package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.ui.a;
import com.google.android.exoplayer2.ui.c;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.x;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes4.dex */
public class PlaybackControlView extends FrameLayout {
    @Deprecated
    public static final b mzy;
    private final TextView ebh;
    private final TextView ebj;
    private final x.b kXt;
    private final x.a kXu;
    private long mAa;
    private long[] mAb;
    private boolean[] mAc;
    private final Runnable mAd;
    private final Runnable mAe;
    private final View mzA;
    private final View mzB;
    private final View mzC;
    private final View mzD;
    private final View mzE;
    private final View mzF;
    private final ImageView mzG;
    private final View mzH;
    private final com.google.android.exoplayer2.ui.c mzI;
    private final Drawable mzJ;
    private final Drawable mzK;
    private final Drawable mzL;
    private final String mzM;
    private final String mzN;
    private final String mzO;
    private r mzP;
    private com.google.android.exoplayer2.c mzQ;
    private d mzR;
    private boolean mzS;
    private boolean mzT;
    private boolean mzU;
    private int mzV;
    private int mzW;
    private int mzX;
    private int mzY;
    private boolean mzZ;
    private final StringBuilder mzj;
    private final Formatter mzk;
    private boolean mzr;
    private long[] mzv;
    private boolean[] mzw;
    private final a mzz;

    @Deprecated
    /* loaded from: classes4.dex */
    public interface b extends com.google.android.exoplayer2.c {
    }

    /* loaded from: classes4.dex */
    public interface d {
        void LA(int i);
    }

    static {
        l.ON("goog.exo.ui");
        mzy = new c();
    }

    /* loaded from: classes4.dex */
    private static final class c extends com.google.android.exoplayer2.d implements b {
        private c() {
        }
    }

    public PlaybackControlView(Context context) {
        this(context, null);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        this.mAd = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.aeV();
            }
        };
        this.mAe = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.hide();
            }
        };
        int i2 = a.d.exo_playback_control_view;
        this.mzV = 5000;
        this.mzW = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
        this.mzX = 5000;
        this.mzY = 0;
        this.mzZ = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, a.f.PlaybackControlView, 0, 0);
            try {
                this.mzV = obtainStyledAttributes.getInt(a.f.PlaybackControlView_rewind_increment, this.mzV);
                this.mzW = obtainStyledAttributes.getInt(a.f.PlaybackControlView_fastforward_increment, this.mzW);
                this.mzX = obtainStyledAttributes.getInt(a.f.PlaybackControlView_show_timeout, this.mzX);
                i2 = obtainStyledAttributes.getResourceId(a.f.PlaybackControlView_controller_layout_id, i2);
                this.mzY = b(obtainStyledAttributes, this.mzY);
                this.mzZ = obtainStyledAttributes.getBoolean(a.f.PlaybackControlView_show_shuffle_button, this.mzZ);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.kXu = new x.a();
        this.kXt = new x.b();
        this.mzj = new StringBuilder();
        this.mzk = new Formatter(this.mzj, Locale.getDefault());
        this.mzv = new long[0];
        this.mzw = new boolean[0];
        this.mAb = new long[0];
        this.mAc = new boolean[0];
        this.mzz = new a();
        this.mzQ = new com.google.android.exoplayer2.d();
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        this.ebj = (TextView) findViewById(a.c.exo_duration);
        this.ebh = (TextView) findViewById(a.c.exo_position);
        this.mzI = (com.google.android.exoplayer2.ui.c) findViewById(a.c.exo_progress);
        if (this.mzI != null) {
            this.mzI.a(this.mzz);
        }
        this.mzC = findViewById(a.c.exo_play);
        if (this.mzC != null) {
            this.mzC.setOnClickListener(this.mzz);
        }
        this.mzD = findViewById(a.c.exo_pause);
        if (this.mzD != null) {
            this.mzD.setOnClickListener(this.mzz);
        }
        this.mzA = findViewById(a.c.exo_prev);
        if (this.mzA != null) {
            this.mzA.setOnClickListener(this.mzz);
        }
        this.mzB = findViewById(a.c.exo_next);
        if (this.mzB != null) {
            this.mzB.setOnClickListener(this.mzz);
        }
        this.mzF = findViewById(a.c.exo_rew);
        if (this.mzF != null) {
            this.mzF.setOnClickListener(this.mzz);
        }
        this.mzE = findViewById(a.c.exo_ffwd);
        if (this.mzE != null) {
            this.mzE.setOnClickListener(this.mzz);
        }
        this.mzG = (ImageView) findViewById(a.c.exo_repeat_toggle);
        if (this.mzG != null) {
            this.mzG.setOnClickListener(this.mzz);
        }
        this.mzH = findViewById(a.c.exo_shuffle);
        if (this.mzH != null) {
            this.mzH.setOnClickListener(this.mzz);
        }
        Resources resources = context.getResources();
        this.mzJ = resources.getDrawable(a.b.exo_controls_repeat_off);
        this.mzK = resources.getDrawable(a.b.exo_controls_repeat_one);
        this.mzL = resources.getDrawable(a.b.exo_controls_repeat_all);
        this.mzM = resources.getString(a.e.exo_controls_repeat_off_description);
        this.mzN = resources.getString(a.e.exo_controls_repeat_one_description);
        this.mzO = resources.getString(a.e.exo_controls_repeat_all_description);
    }

    private static int b(TypedArray typedArray, int i) {
        return typedArray.getInt(a.f.PlaybackControlView_repeat_toggle_modes, i);
    }

    public r getPlayer() {
        return this.mzP;
    }

    public void setPlayer(r rVar) {
        if (this.mzP != rVar) {
            if (this.mzP != null) {
                this.mzP.b(this.mzz);
            }
            this.mzP = rVar;
            if (rVar != null) {
                rVar.a(this.mzz);
            }
            updateAll();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.mzT = z;
        dwl();
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.mAb = new long[0];
            this.mAc = new boolean[0];
        } else {
            com.google.android.exoplayer2.util.a.checkArgument(jArr.length == zArr.length);
            this.mAb = jArr;
            this.mAc = zArr;
        }
        aeV();
    }

    public void setVisibilityListener(d dVar) {
        this.mzR = dVar;
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        if (cVar == null) {
            cVar = new com.google.android.exoplayer2.d();
        }
        this.mzQ = cVar;
    }

    public void setRewindIncrementMs(int i) {
        this.mzV = i;
        dwi();
    }

    public void setFastForwardIncrementMs(int i) {
        this.mzW = i;
        dwi();
    }

    public int getShowTimeoutMs() {
        return this.mzX;
    }

    public void setShowTimeoutMs(int i) {
        this.mzX = i;
    }

    public int getRepeatToggleModes() {
        return this.mzY;
    }

    public void setRepeatToggleModes(int i) {
        this.mzY = i;
        if (this.mzP != null) {
            int repeatMode = this.mzP.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.mzQ.a(this.mzP, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.mzQ.a(this.mzP, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.mzQ.a(this.mzP, 2);
            }
        }
    }

    public boolean getShowShuffleButton() {
        return this.mzZ;
    }

    public void setShowShuffleButton(boolean z) {
        this.mzZ = z;
        dwk();
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            if (this.mzR != null) {
                this.mzR.LA(getVisibility());
            }
            updateAll();
            dwm();
        }
        dwg();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            if (this.mzR != null) {
                this.mzR.LA(getVisibility());
            }
            removeCallbacks(this.mAd);
            removeCallbacks(this.mAe);
            this.mAa = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwg() {
        removeCallbacks(this.mAe);
        if (this.mzX > 0) {
            this.mAa = SystemClock.uptimeMillis() + this.mzX;
            if (this.mzS) {
                postDelayed(this.mAe, this.mzX);
                return;
            }
            return;
        }
        this.mAa = -9223372036854775807L;
    }

    private void updateAll() {
        dwh();
        dwi();
        dwj();
        dwk();
        aeV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwh() {
        boolean z;
        boolean z2 = true;
        if (isVisible() && this.mzS) {
            boolean z3 = this.mzP != null && this.mzP.dqr();
            if (this.mzC != null) {
                boolean z4 = false | (z3 && this.mzC.isFocused());
                this.mzC.setVisibility(z3 ? 8 : 0);
                z = z4;
            } else {
                z = false;
            }
            if (this.mzD != null) {
                if (z3 || !this.mzD.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                this.mzD.setVisibility(z3 ? 0 : 8);
            }
            if (z) {
                dwm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwi() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (isVisible() && this.mzS) {
            x dqC = this.mzP != null ? this.mzP.dqC() : null;
            if (!((dqC == null || dqC.isEmpty()) ? false : true) || this.mzP.dqz()) {
                z = false;
                z2 = false;
                z3 = false;
            } else {
                dqC.a(this.mzP.dqv(), this.kXt);
                z3 = this.kXt.lVO;
                z2 = (!z3 && this.kXt.isDynamic && this.mzP.dqx() == -1) ? false : true;
                z = this.kXt.isDynamic || this.mzP.dqw() != -1;
            }
            a(z2, this.mzA);
            a(z, this.mzB);
            a(this.mzW > 0 && z3, this.mzE);
            if (this.mzV <= 0 || !z3) {
                z4 = false;
            }
            a(z4, this.mzF);
            if (this.mzI != null) {
                this.mzI.setEnabled(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwj() {
        if (isVisible() && this.mzS && this.mzG != null) {
            if (this.mzY == 0) {
                this.mzG.setVisibility(8);
            } else if (this.mzP == null) {
                a(false, (View) this.mzG);
            } else {
                a(true, (View) this.mzG);
                switch (this.mzP.getRepeatMode()) {
                    case 0:
                        this.mzG.setImageDrawable(this.mzJ);
                        this.mzG.setContentDescription(this.mzM);
                        break;
                    case 1:
                        this.mzG.setImageDrawable(this.mzK);
                        this.mzG.setContentDescription(this.mzN);
                        break;
                    case 2:
                        this.mzG.setImageDrawable(this.mzL);
                        this.mzG.setContentDescription(this.mzO);
                        break;
                }
                this.mzG.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwk() {
        if (isVisible() && this.mzS && this.mzH != null) {
            if (!this.mzZ) {
                this.mzH.setVisibility(8);
            } else if (this.mzP == null) {
                a(false, this.mzH);
            } else {
                this.mzH.setAlpha(this.mzP.dqs() ? 1.0f : 0.3f);
                this.mzH.setEnabled(true);
                this.mzH.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwl() {
        if (this.mzP != null) {
            this.mzU = this.mzT && a(this.mzP.dqC(), this.kXt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeV() {
        long j;
        long bufferedPosition;
        if (isVisible() && this.mzS) {
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            if (this.mzP != null) {
                long j5 = 0;
                long j6 = 0;
                int i = 0;
                x dqC = this.mzP.dqC();
                if (!dqC.isEmpty()) {
                    int dqv = this.mzP.dqv();
                    int i2 = this.mzU ? 0 : dqv;
                    int dqZ = this.mzU ? dqC.dqZ() - 1 : dqv;
                    int i3 = i2;
                    while (true) {
                        if (i3 > dqZ) {
                            break;
                        }
                        if (i3 == dqv) {
                            j5 = j6;
                        }
                        dqC.a(i3, this.kXt);
                        if (this.kXt.lUZ == -9223372036854775807L) {
                            com.google.android.exoplayer2.util.a.checkState(!this.mzU);
                        } else {
                            for (int i4 = this.kXt.lVP; i4 <= this.kXt.lVQ; i4++) {
                                dqC.a(i4, this.kXu);
                                int drf = this.kXu.drf();
                                for (int i5 = 0; i5 < drf; i5++) {
                                    long IL = this.kXu.IL(i5);
                                    if (IL == Long.MIN_VALUE) {
                                        if (this.kXu.lUZ != -9223372036854775807L) {
                                            IL = this.kXu.lUZ;
                                        }
                                    }
                                    long dre = this.kXu.dre() + IL;
                                    if (dre >= 0 && dre <= this.kXt.lUZ) {
                                        if (i == this.mzv.length) {
                                            int length = this.mzv.length == 0 ? 1 : this.mzv.length * 2;
                                            this.mzv = Arrays.copyOf(this.mzv, length);
                                            this.mzw = Arrays.copyOf(this.mzw, length);
                                        }
                                        this.mzv[i] = com.google.android.exoplayer2.b.fk(dre + j6);
                                        this.mzw[i] = this.kXu.IN(i5);
                                        i++;
                                    }
                                }
                            }
                            j6 += this.kXt.lUZ;
                            i3++;
                        }
                    }
                }
                long fk = com.google.android.exoplayer2.b.fk(j6);
                long fk2 = com.google.android.exoplayer2.b.fk(j5);
                if (this.mzP.dqz()) {
                    bufferedPosition = fk2 + this.mzP.dqA();
                    j2 = bufferedPosition;
                } else {
                    j2 = this.mzP.getCurrentPosition() + fk2;
                    bufferedPosition = fk2 + this.mzP.getBufferedPosition();
                }
                if (this.mzI != null) {
                    int length2 = this.mAb.length;
                    int i6 = i + length2;
                    if (i6 > this.mzv.length) {
                        this.mzv = Arrays.copyOf(this.mzv, i6);
                        this.mzw = Arrays.copyOf(this.mzw, i6);
                    }
                    System.arraycopy(this.mAb, 0, this.mzv, i, length2);
                    System.arraycopy(this.mAc, 0, this.mzw, i, length2);
                    this.mzI.setAdGroupTimesMs(this.mzv, this.mzw, i6);
                }
                j3 = bufferedPosition;
                j4 = fk;
            }
            if (this.ebj != null) {
                this.ebj.setText(v.a(this.mzj, this.mzk, j4));
            }
            if (this.ebh != null && !this.mzr) {
                this.ebh.setText(v.a(this.mzj, this.mzk, j2));
            }
            if (this.mzI != null) {
                this.mzI.setPosition(j2);
                this.mzI.setBufferedPosition(j3);
                this.mzI.setDuration(j4);
            }
            removeCallbacks(this.mAd);
            int cXu = this.mzP == null ? 1 : this.mzP.cXu();
            if (cXu != 1 && cXu != 4) {
                if (this.mzP.dqr() && cXu == 3) {
                    float f = this.mzP.dqt().speed;
                    if (f <= 0.1f) {
                        j = 1000;
                    } else if (f <= 5.0f) {
                        long max = 1000 / Math.max(1, Math.round(1.0f / f));
                        j = max - (j2 % max);
                        if (j < max / 5) {
                            j += max;
                        }
                        if (f != 1.0f) {
                            j = ((float) j) / f;
                        }
                    } else {
                        j = 200;
                    }
                } else {
                    j = 1000;
                }
                postDelayed(this.mAd, j);
            }
        }
    }

    private void dwm() {
        boolean z = this.mzP != null && this.mzP.dqr();
        if (!z && this.mzC != null) {
            this.mzC.requestFocus();
        } else if (z && this.mzD != null) {
            this.mzD.requestFocus();
        }
    }

    private void a(boolean z, View view) {
        if (view != null) {
            view.setEnabled(z);
            view.setAlpha(z ? 1.0f : 0.3f);
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void previous() {
        x dqC = this.mzP.dqC();
        if (!dqC.isEmpty()) {
            dqC.a(this.mzP.dqv(), this.kXt);
            int dqx = this.mzP.dqx();
            if (dqx != -1 && (this.mzP.getCurrentPosition() <= 3000 || (this.kXt.isDynamic && !this.kXt.lVO))) {
                B(dqx, -9223372036854775807L);
            } else {
                seekTo(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        x dqC = this.mzP.dqC();
        if (!dqC.isEmpty()) {
            int dqv = this.mzP.dqv();
            int dqw = this.mzP.dqw();
            if (dqw != -1) {
                B(dqw, -9223372036854775807L);
            } else if (dqC.a(dqv, this.kXt, false).isDynamic) {
                B(dqv, -9223372036854775807L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.mzV > 0) {
            seekTo(Math.max(this.mzP.getCurrentPosition() - this.mzV, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.mzW > 0) {
            long duration = this.mzP.getDuration();
            long currentPosition = this.mzP.getCurrentPosition() + this.mzW;
            if (duration != -9223372036854775807L) {
                currentPosition = Math.min(currentPosition, duration);
            }
            seekTo(currentPosition);
        }
    }

    private void seekTo(long j) {
        B(this.mzP.dqv(), j);
    }

    private void B(int i, long j) {
        if (!this.mzQ.a(this.mzP, i, j)) {
            aeV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(long j) {
        int dqv;
        x dqC = this.mzP.dqC();
        if (this.mzU && !dqC.isEmpty()) {
            int dqZ = dqC.dqZ();
            dqv = 0;
            while (true) {
                long drb = dqC.a(dqv, this.kXt).drb();
                if (j < drb) {
                    break;
                } else if (dqv == dqZ - 1) {
                    j = drb;
                    break;
                } else {
                    j -= drb;
                    dqv++;
                }
            }
        } else {
            dqv = this.mzP.dqv();
        }
        B(dqv, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mzS = true;
        if (this.mAa != -9223372036854775807L) {
            long uptimeMillis = this.mAa - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.mAe, uptimeMillis);
            }
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mzS = false;
        removeCallbacks(this.mAd);
        removeCallbacks(this.mAe);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mzP == null || !Lz(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                fastForward();
                return true;
            } else if (keyCode == 89) {
                rewind();
                return true;
            } else if (keyEvent.getRepeatCount() == 0) {
                switch (keyCode) {
                    case 85:
                        this.mzQ.a(this.mzP, this.mzP.dqr() ? false : true);
                        return true;
                    case 87:
                        next();
                        return true;
                    case 88:
                        previous();
                        return true;
                    case 126:
                        this.mzQ.a(this.mzP, true);
                        return true;
                    case 127:
                        this.mzQ.a(this.mzP, false);
                        return true;
                    default:
                        return true;
                }
            } else {
                return true;
            }
        }
        return true;
    }

    @SuppressLint({"InlinedApi"})
    private static boolean Lz(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    private static boolean a(x xVar, x.b bVar) {
        if (xVar.dqZ() > 100) {
            return false;
        }
        int dqZ = xVar.dqZ();
        for (int i = 0; i < dqZ; i++) {
            if (xVar.a(i, bVar).lUZ == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* loaded from: classes4.dex */
    private final class a extends r.a implements View.OnClickListener, c.a {
        private a() {
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j) {
            PlaybackControlView.this.removeCallbacks(PlaybackControlView.this.mAe);
            PlaybackControlView.this.mzr = true;
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void b(com.google.android.exoplayer2.ui.c cVar, long j) {
            if (PlaybackControlView.this.ebh != null) {
                PlaybackControlView.this.ebh.setText(v.a(PlaybackControlView.this.mzj, PlaybackControlView.this.mzk, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j, boolean z) {
            PlaybackControlView.this.mzr = false;
            if (!z && PlaybackControlView.this.mzP != null) {
                PlaybackControlView.this.gB(j);
            }
            PlaybackControlView.this.dwg();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void y(boolean z, int i) {
            PlaybackControlView.this.dwh();
            PlaybackControlView.this.aeV();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
            PlaybackControlView.this.dwj();
            PlaybackControlView.this.dwi();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void tO(boolean z) {
            PlaybackControlView.this.dwk();
            PlaybackControlView.this.dwi();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void EJ(int i) {
            PlaybackControlView.this.dwi();
            PlaybackControlView.this.aeV();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
            PlaybackControlView.this.dwi();
            PlaybackControlView.this.dwl();
            PlaybackControlView.this.aeV();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlaybackControlView.this.mzP != null) {
                if (PlaybackControlView.this.mzB == view) {
                    PlaybackControlView.this.next();
                } else if (PlaybackControlView.this.mzA == view) {
                    PlaybackControlView.this.previous();
                } else if (PlaybackControlView.this.mzE == view) {
                    PlaybackControlView.this.fastForward();
                } else if (PlaybackControlView.this.mzF == view) {
                    PlaybackControlView.this.rewind();
                } else if (PlaybackControlView.this.mzC == view) {
                    PlaybackControlView.this.mzQ.a(PlaybackControlView.this.mzP, true);
                } else if (PlaybackControlView.this.mzD == view) {
                    PlaybackControlView.this.mzQ.a(PlaybackControlView.this.mzP, false);
                } else if (PlaybackControlView.this.mzG != view) {
                    if (PlaybackControlView.this.mzH == view) {
                        PlaybackControlView.this.mzQ.b(PlaybackControlView.this.mzP, PlaybackControlView.this.mzP.dqs() ? false : true);
                    }
                } else {
                    PlaybackControlView.this.mzQ.a(PlaybackControlView.this.mzP, o.dW(PlaybackControlView.this.mzP.getRepeatMode(), PlaybackControlView.this.mzY));
                }
            }
            PlaybackControlView.this.dwg();
        }
    }
}
