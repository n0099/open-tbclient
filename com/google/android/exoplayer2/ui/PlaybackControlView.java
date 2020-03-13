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
import com.alibaba.fastjson.asm.Opcodes;
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
/* loaded from: classes6.dex */
public class PlaybackControlView extends FrameLayout {
    @Deprecated
    public static final b mEp;
    private final TextView efH;
    private final TextView efJ;
    private final x.b lbS;
    private final x.a lbT;
    private final Drawable mEA;
    private final Drawable mEB;
    private final Drawable mEC;
    private final String mED;
    private final String mEE;
    private final String mEF;
    private r mEG;
    private com.google.android.exoplayer2.c mEH;
    private d mEI;
    private boolean mEJ;
    private boolean mEK;
    private boolean mEL;
    private int mEM;
    private int mEN;
    private int mEO;
    private int mEP;
    private boolean mEQ;
    private long mER;
    private long[] mES;
    private boolean[] mET;
    private final Runnable mEU;
    private final Runnable mEV;
    private final StringBuilder mEa;
    private final Formatter mEb;
    private boolean mEi;
    private long[] mEm;
    private boolean[] mEn;
    private final a mEq;
    private final View mEr;
    private final View mEs;
    private final View mEt;
    private final View mEu;
    private final View mEv;
    private final View mEw;
    private final ImageView mEx;
    private final View mEy;
    private final com.google.android.exoplayer2.ui.c mEz;

    @Deprecated
    /* loaded from: classes6.dex */
    public interface b extends com.google.android.exoplayer2.c {
    }

    /* loaded from: classes6.dex */
    public interface d {
        void LO(int i);
    }

    static {
        l.Pm("goog.exo.ui");
        mEp = new c();
    }

    /* loaded from: classes6.dex */
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
        this.mEU = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.ahE();
            }
        };
        this.mEV = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.hide();
            }
        };
        int i2 = a.d.exo_playback_control_view;
        this.mEM = 5000;
        this.mEN = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
        this.mEO = 5000;
        this.mEP = 0;
        this.mEQ = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, a.f.PlaybackControlView, 0, 0);
            try {
                this.mEM = obtainStyledAttributes.getInt(a.f.PlaybackControlView_rewind_increment, this.mEM);
                this.mEN = obtainStyledAttributes.getInt(a.f.PlaybackControlView_fastforward_increment, this.mEN);
                this.mEO = obtainStyledAttributes.getInt(a.f.PlaybackControlView_show_timeout, this.mEO);
                i2 = obtainStyledAttributes.getResourceId(a.f.PlaybackControlView_controller_layout_id, i2);
                this.mEP = b(obtainStyledAttributes, this.mEP);
                this.mEQ = obtainStyledAttributes.getBoolean(a.f.PlaybackControlView_show_shuffle_button, this.mEQ);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.lbT = new x.a();
        this.lbS = new x.b();
        this.mEa = new StringBuilder();
        this.mEb = new Formatter(this.mEa, Locale.getDefault());
        this.mEm = new long[0];
        this.mEn = new boolean[0];
        this.mES = new long[0];
        this.mET = new boolean[0];
        this.mEq = new a();
        this.mEH = new com.google.android.exoplayer2.d();
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        this.efJ = (TextView) findViewById(a.c.exo_duration);
        this.efH = (TextView) findViewById(a.c.exo_position);
        this.mEz = (com.google.android.exoplayer2.ui.c) findViewById(a.c.exo_progress);
        if (this.mEz != null) {
            this.mEz.a(this.mEq);
        }
        this.mEt = findViewById(a.c.exo_play);
        if (this.mEt != null) {
            this.mEt.setOnClickListener(this.mEq);
        }
        this.mEu = findViewById(a.c.exo_pause);
        if (this.mEu != null) {
            this.mEu.setOnClickListener(this.mEq);
        }
        this.mEr = findViewById(a.c.exo_prev);
        if (this.mEr != null) {
            this.mEr.setOnClickListener(this.mEq);
        }
        this.mEs = findViewById(a.c.exo_next);
        if (this.mEs != null) {
            this.mEs.setOnClickListener(this.mEq);
        }
        this.mEw = findViewById(a.c.exo_rew);
        if (this.mEw != null) {
            this.mEw.setOnClickListener(this.mEq);
        }
        this.mEv = findViewById(a.c.exo_ffwd);
        if (this.mEv != null) {
            this.mEv.setOnClickListener(this.mEq);
        }
        this.mEx = (ImageView) findViewById(a.c.exo_repeat_toggle);
        if (this.mEx != null) {
            this.mEx.setOnClickListener(this.mEq);
        }
        this.mEy = findViewById(a.c.exo_shuffle);
        if (this.mEy != null) {
            this.mEy.setOnClickListener(this.mEq);
        }
        Resources resources = context.getResources();
        this.mEA = resources.getDrawable(a.b.exo_controls_repeat_off);
        this.mEB = resources.getDrawable(a.b.exo_controls_repeat_one);
        this.mEC = resources.getDrawable(a.b.exo_controls_repeat_all);
        this.mED = resources.getString(a.e.exo_controls_repeat_off_description);
        this.mEE = resources.getString(a.e.exo_controls_repeat_one_description);
        this.mEF = resources.getString(a.e.exo_controls_repeat_all_description);
    }

    private static int b(TypedArray typedArray, int i) {
        return typedArray.getInt(a.f.PlaybackControlView_repeat_toggle_modes, i);
    }

    public r getPlayer() {
        return this.mEG;
    }

    public void setPlayer(r rVar) {
        if (this.mEG != rVar) {
            if (this.mEG != null) {
                this.mEG.b(this.mEq);
            }
            this.mEG = rVar;
            if (rVar != null) {
                rVar.a(this.mEq);
            }
            updateAll();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.mEK = z;
        dyL();
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.mES = new long[0];
            this.mET = new boolean[0];
        } else {
            com.google.android.exoplayer2.util.a.checkArgument(jArr.length == zArr.length);
            this.mES = jArr;
            this.mET = zArr;
        }
        ahE();
    }

    public void setVisibilityListener(d dVar) {
        this.mEI = dVar;
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        if (cVar == null) {
            cVar = new com.google.android.exoplayer2.d();
        }
        this.mEH = cVar;
    }

    public void setRewindIncrementMs(int i) {
        this.mEM = i;
        dyI();
    }

    public void setFastForwardIncrementMs(int i) {
        this.mEN = i;
        dyI();
    }

    public int getShowTimeoutMs() {
        return this.mEO;
    }

    public void setShowTimeoutMs(int i) {
        this.mEO = i;
    }

    public int getRepeatToggleModes() {
        return this.mEP;
    }

    public void setRepeatToggleModes(int i) {
        this.mEP = i;
        if (this.mEG != null) {
            int repeatMode = this.mEG.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.mEH.a(this.mEG, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.mEH.a(this.mEG, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.mEH.a(this.mEG, 2);
            }
        }
    }

    public boolean getShowShuffleButton() {
        return this.mEQ;
    }

    public void setShowShuffleButton(boolean z) {
        this.mEQ = z;
        dyK();
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            if (this.mEI != null) {
                this.mEI.LO(getVisibility());
            }
            updateAll();
            dyM();
        }
        dyG();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            if (this.mEI != null) {
                this.mEI.LO(getVisibility());
            }
            removeCallbacks(this.mEU);
            removeCallbacks(this.mEV);
            this.mER = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyG() {
        removeCallbacks(this.mEV);
        if (this.mEO > 0) {
            this.mER = SystemClock.uptimeMillis() + this.mEO;
            if (this.mEJ) {
                postDelayed(this.mEV, this.mEO);
                return;
            }
            return;
        }
        this.mER = -9223372036854775807L;
    }

    private void updateAll() {
        dyH();
        dyI();
        dyJ();
        dyK();
        ahE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyH() {
        boolean z;
        boolean z2 = true;
        if (isVisible() && this.mEJ) {
            boolean z3 = this.mEG != null && this.mEG.dsU();
            if (this.mEt != null) {
                boolean z4 = false | (z3 && this.mEt.isFocused());
                this.mEt.setVisibility(z3 ? 8 : 0);
                z = z4;
            } else {
                z = false;
            }
            if (this.mEu != null) {
                if (z3 || !this.mEu.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                this.mEu.setVisibility(z3 ? 0 : 8);
            }
            if (z) {
                dyM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyI() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (isVisible() && this.mEJ) {
            x dtf = this.mEG != null ? this.mEG.dtf() : null;
            if (!((dtf == null || dtf.isEmpty()) ? false : true) || this.mEG.dtc()) {
                z = false;
                z2 = false;
                z3 = false;
            } else {
                dtf.a(this.mEG.dsY(), this.lbS);
                z3 = this.lbS.maE;
                z2 = (!z3 && this.lbS.isDynamic && this.mEG.dta() == -1) ? false : true;
                z = this.lbS.isDynamic || this.mEG.dsZ() != -1;
            }
            a(z2, this.mEr);
            a(z, this.mEs);
            a(this.mEN > 0 && z3, this.mEv);
            if (this.mEM <= 0 || !z3) {
                z4 = false;
            }
            a(z4, this.mEw);
            if (this.mEz != null) {
                this.mEz.setEnabled(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyJ() {
        if (isVisible() && this.mEJ && this.mEx != null) {
            if (this.mEP == 0) {
                this.mEx.setVisibility(8);
            } else if (this.mEG == null) {
                a(false, (View) this.mEx);
            } else {
                a(true, (View) this.mEx);
                switch (this.mEG.getRepeatMode()) {
                    case 0:
                        this.mEx.setImageDrawable(this.mEA);
                        this.mEx.setContentDescription(this.mED);
                        break;
                    case 1:
                        this.mEx.setImageDrawable(this.mEB);
                        this.mEx.setContentDescription(this.mEE);
                        break;
                    case 2:
                        this.mEx.setImageDrawable(this.mEC);
                        this.mEx.setContentDescription(this.mEF);
                        break;
                }
                this.mEx.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyK() {
        if (isVisible() && this.mEJ && this.mEy != null) {
            if (!this.mEQ) {
                this.mEy.setVisibility(8);
            } else if (this.mEG == null) {
                a(false, this.mEy);
            } else {
                this.mEy.setAlpha(this.mEG.dsV() ? 1.0f : 0.3f);
                this.mEy.setEnabled(true);
                this.mEy.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyL() {
        if (this.mEG != null) {
            this.mEL = this.mEK && a(this.mEG.dtf(), this.lbS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahE() {
        long j;
        long bufferedPosition;
        if (isVisible() && this.mEJ) {
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            if (this.mEG != null) {
                long j5 = 0;
                long j6 = 0;
                int i = 0;
                x dtf = this.mEG.dtf();
                if (!dtf.isEmpty()) {
                    int dsY = this.mEG.dsY();
                    int i2 = this.mEL ? 0 : dsY;
                    int dtC = this.mEL ? dtf.dtC() - 1 : dsY;
                    int i3 = i2;
                    while (true) {
                        if (i3 > dtC) {
                            break;
                        }
                        if (i3 == dsY) {
                            j5 = j6;
                        }
                        dtf.a(i3, this.lbS);
                        if (this.lbS.lZO == -9223372036854775807L) {
                            com.google.android.exoplayer2.util.a.checkState(!this.mEL);
                        } else {
                            for (int i4 = this.lbS.maF; i4 <= this.lbS.maG; i4++) {
                                dtf.a(i4, this.lbT);
                                int dtH = this.lbT.dtH();
                                for (int i5 = 0; i5 < dtH; i5++) {
                                    long IZ = this.lbT.IZ(i5);
                                    if (IZ == Long.MIN_VALUE) {
                                        if (this.lbT.lZO != -9223372036854775807L) {
                                            IZ = this.lbT.lZO;
                                        }
                                    }
                                    long dtG = this.lbT.dtG() + IZ;
                                    if (dtG >= 0 && dtG <= this.lbS.lZO) {
                                        if (i == this.mEm.length) {
                                            int length = this.mEm.length == 0 ? 1 : this.mEm.length * 2;
                                            this.mEm = Arrays.copyOf(this.mEm, length);
                                            this.mEn = Arrays.copyOf(this.mEn, length);
                                        }
                                        this.mEm[i] = com.google.android.exoplayer2.b.fn(dtG + j6);
                                        this.mEn[i] = this.lbT.Jb(i5);
                                        i++;
                                    }
                                }
                            }
                            j6 += this.lbS.lZO;
                            i3++;
                        }
                    }
                }
                long fn = com.google.android.exoplayer2.b.fn(j6);
                long fn2 = com.google.android.exoplayer2.b.fn(j5);
                if (this.mEG.dtc()) {
                    bufferedPosition = fn2 + this.mEG.dtd();
                    j2 = bufferedPosition;
                } else {
                    j2 = this.mEG.getCurrentPosition() + fn2;
                    bufferedPosition = fn2 + this.mEG.getBufferedPosition();
                }
                if (this.mEz != null) {
                    int length2 = this.mES.length;
                    int i6 = i + length2;
                    if (i6 > this.mEm.length) {
                        this.mEm = Arrays.copyOf(this.mEm, i6);
                        this.mEn = Arrays.copyOf(this.mEn, i6);
                    }
                    System.arraycopy(this.mES, 0, this.mEm, i, length2);
                    System.arraycopy(this.mET, 0, this.mEn, i, length2);
                    this.mEz.setAdGroupTimesMs(this.mEm, this.mEn, i6);
                }
                j3 = bufferedPosition;
                j4 = fn;
            }
            if (this.efJ != null) {
                this.efJ.setText(v.a(this.mEa, this.mEb, j4));
            }
            if (this.efH != null && !this.mEi) {
                this.efH.setText(v.a(this.mEa, this.mEb, j2));
            }
            if (this.mEz != null) {
                this.mEz.setPosition(j2);
                this.mEz.setBufferedPosition(j3);
                this.mEz.setDuration(j4);
            }
            removeCallbacks(this.mEU);
            int cZQ = this.mEG == null ? 1 : this.mEG.cZQ();
            if (cZQ != 1 && cZQ != 4) {
                if (this.mEG.dsU() && cZQ == 3) {
                    float f = this.mEG.dsW().speed;
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
                postDelayed(this.mEU, j);
            }
        }
    }

    private void dyM() {
        boolean z = this.mEG != null && this.mEG.dsU();
        if (!z && this.mEt != null) {
            this.mEt.requestFocus();
        } else if (z && this.mEu != null) {
            this.mEu.requestFocus();
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
        x dtf = this.mEG.dtf();
        if (!dtf.isEmpty()) {
            dtf.a(this.mEG.dsY(), this.lbS);
            int dta = this.mEG.dta();
            if (dta != -1 && (this.mEG.getCurrentPosition() <= 3000 || (this.lbS.isDynamic && !this.lbS.maE))) {
                A(dta, -9223372036854775807L);
            } else {
                seekTo(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        x dtf = this.mEG.dtf();
        if (!dtf.isEmpty()) {
            int dsY = this.mEG.dsY();
            int dsZ = this.mEG.dsZ();
            if (dsZ != -1) {
                A(dsZ, -9223372036854775807L);
            } else if (dtf.a(dsY, this.lbS, false).isDynamic) {
                A(dsY, -9223372036854775807L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.mEM > 0) {
            seekTo(Math.max(this.mEG.getCurrentPosition() - this.mEM, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.mEN > 0) {
            long duration = this.mEG.getDuration();
            long currentPosition = this.mEG.getCurrentPosition() + this.mEN;
            if (duration != -9223372036854775807L) {
                currentPosition = Math.min(currentPosition, duration);
            }
            seekTo(currentPosition);
        }
    }

    private void seekTo(long j) {
        A(this.mEG.dsY(), j);
    }

    private void A(int i, long j) {
        if (!this.mEH.a(this.mEG, i, j)) {
            ahE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(long j) {
        int dsY;
        x dtf = this.mEG.dtf();
        if (this.mEL && !dtf.isEmpty()) {
            int dtC = dtf.dtC();
            dsY = 0;
            while (true) {
                long dtE = dtf.a(dsY, this.lbS).dtE();
                if (j < dtE) {
                    break;
                } else if (dsY == dtC - 1) {
                    j = dtE;
                    break;
                } else {
                    j -= dtE;
                    dsY++;
                }
            }
        } else {
            dsY = this.mEG.dsY();
        }
        A(dsY, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mEJ = true;
        if (this.mER != -9223372036854775807L) {
            long uptimeMillis = this.mER - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.mEV, uptimeMillis);
            }
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mEJ = false;
        removeCallbacks(this.mEU);
        removeCallbacks(this.mEV);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mEG == null || !LN(keyCode)) {
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
                        this.mEH.a(this.mEG, this.mEG.dsU() ? false : true);
                        return true;
                    case 87:
                        next();
                        return true;
                    case 88:
                        previous();
                        return true;
                    case Opcodes.IAND /* 126 */:
                        this.mEH.a(this.mEG, true);
                        return true;
                    case 127:
                        this.mEH.a(this.mEG, false);
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
    private static boolean LN(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    private static boolean a(x xVar, x.b bVar) {
        if (xVar.dtC() > 100) {
            return false;
        }
        int dtC = xVar.dtC();
        for (int i = 0; i < dtC; i++) {
            if (xVar.a(i, bVar).lZO == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* loaded from: classes6.dex */
    private final class a extends r.a implements View.OnClickListener, c.a {
        private a() {
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j) {
            PlaybackControlView.this.removeCallbacks(PlaybackControlView.this.mEV);
            PlaybackControlView.this.mEi = true;
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void b(com.google.android.exoplayer2.ui.c cVar, long j) {
            if (PlaybackControlView.this.efH != null) {
                PlaybackControlView.this.efH.setText(v.a(PlaybackControlView.this.mEa, PlaybackControlView.this.mEb, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j, boolean z) {
            PlaybackControlView.this.mEi = false;
            if (!z && PlaybackControlView.this.mEG != null) {
                PlaybackControlView.this.gE(j);
            }
            PlaybackControlView.this.dyG();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
            PlaybackControlView.this.dyH();
            PlaybackControlView.this.ahE();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
            PlaybackControlView.this.dyJ();
            PlaybackControlView.this.dyI();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ue(boolean z) {
            PlaybackControlView.this.dyK();
            PlaybackControlView.this.dyI();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ET(int i) {
            PlaybackControlView.this.dyI();
            PlaybackControlView.this.ahE();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
            PlaybackControlView.this.dyI();
            PlaybackControlView.this.dyL();
            PlaybackControlView.this.ahE();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlaybackControlView.this.mEG != null) {
                if (PlaybackControlView.this.mEs == view) {
                    PlaybackControlView.this.next();
                } else if (PlaybackControlView.this.mEr == view) {
                    PlaybackControlView.this.previous();
                } else if (PlaybackControlView.this.mEv == view) {
                    PlaybackControlView.this.fastForward();
                } else if (PlaybackControlView.this.mEw == view) {
                    PlaybackControlView.this.rewind();
                } else if (PlaybackControlView.this.mEt == view) {
                    PlaybackControlView.this.mEH.a(PlaybackControlView.this.mEG, true);
                } else if (PlaybackControlView.this.mEu == view) {
                    PlaybackControlView.this.mEH.a(PlaybackControlView.this.mEG, false);
                } else if (PlaybackControlView.this.mEx != view) {
                    if (PlaybackControlView.this.mEy == view) {
                        PlaybackControlView.this.mEH.b(PlaybackControlView.this.mEG, PlaybackControlView.this.mEG.dsV() ? false : true);
                    }
                } else {
                    PlaybackControlView.this.mEH.a(PlaybackControlView.this.mEG, o.dX(PlaybackControlView.this.mEG.getRepeatMode(), PlaybackControlView.this.mEP));
                }
            }
            PlaybackControlView.this.dyG();
        }
    }
}
