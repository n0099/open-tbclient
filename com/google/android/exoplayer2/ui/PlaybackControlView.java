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
    public static final b mEc;
    private final TextView eft;
    private final TextView efv;
    private final x.b lbE;
    private final x.a lbF;
    private final StringBuilder mDN;
    private final Formatter mDO;
    private boolean mDV;
    private long[] mDZ;
    private int mEA;
    private int mEB;
    private int mEC;
    private boolean mED;
    private long mEE;
    private long[] mEF;
    private boolean[] mEG;
    private final Runnable mEH;
    private final Runnable mEI;
    private boolean[] mEa;
    private final a mEd;
    private final View mEe;
    private final View mEf;
    private final View mEg;
    private final View mEh;
    private final View mEi;
    private final View mEj;
    private final ImageView mEk;
    private final View mEl;
    private final com.google.android.exoplayer2.ui.c mEm;
    private final Drawable mEn;
    private final Drawable mEo;
    private final Drawable mEp;
    private final String mEq;
    private final String mEr;
    private final String mEs;
    private r mEt;
    private com.google.android.exoplayer2.c mEu;
    private d mEv;
    private boolean mEw;
    private boolean mEx;
    private boolean mEy;
    private int mEz;

    @Deprecated
    /* loaded from: classes6.dex */
    public interface b extends com.google.android.exoplayer2.c {
    }

    /* loaded from: classes6.dex */
    public interface d {
        void LO(int i);
    }

    static {
        l.Pl("goog.exo.ui");
        mEc = new c();
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
        this.mEH = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.ahC();
            }
        };
        this.mEI = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.hide();
            }
        };
        int i2 = a.d.exo_playback_control_view;
        this.mEz = 5000;
        this.mEA = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
        this.mEB = 5000;
        this.mEC = 0;
        this.mED = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, a.f.PlaybackControlView, 0, 0);
            try {
                this.mEz = obtainStyledAttributes.getInt(a.f.PlaybackControlView_rewind_increment, this.mEz);
                this.mEA = obtainStyledAttributes.getInt(a.f.PlaybackControlView_fastforward_increment, this.mEA);
                this.mEB = obtainStyledAttributes.getInt(a.f.PlaybackControlView_show_timeout, this.mEB);
                i2 = obtainStyledAttributes.getResourceId(a.f.PlaybackControlView_controller_layout_id, i2);
                this.mEC = b(obtainStyledAttributes, this.mEC);
                this.mED = obtainStyledAttributes.getBoolean(a.f.PlaybackControlView_show_shuffle_button, this.mED);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.lbF = new x.a();
        this.lbE = new x.b();
        this.mDN = new StringBuilder();
        this.mDO = new Formatter(this.mDN, Locale.getDefault());
        this.mDZ = new long[0];
        this.mEa = new boolean[0];
        this.mEF = new long[0];
        this.mEG = new boolean[0];
        this.mEd = new a();
        this.mEu = new com.google.android.exoplayer2.d();
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        this.efv = (TextView) findViewById(a.c.exo_duration);
        this.eft = (TextView) findViewById(a.c.exo_position);
        this.mEm = (com.google.android.exoplayer2.ui.c) findViewById(a.c.exo_progress);
        if (this.mEm != null) {
            this.mEm.a(this.mEd);
        }
        this.mEg = findViewById(a.c.exo_play);
        if (this.mEg != null) {
            this.mEg.setOnClickListener(this.mEd);
        }
        this.mEh = findViewById(a.c.exo_pause);
        if (this.mEh != null) {
            this.mEh.setOnClickListener(this.mEd);
        }
        this.mEe = findViewById(a.c.exo_prev);
        if (this.mEe != null) {
            this.mEe.setOnClickListener(this.mEd);
        }
        this.mEf = findViewById(a.c.exo_next);
        if (this.mEf != null) {
            this.mEf.setOnClickListener(this.mEd);
        }
        this.mEj = findViewById(a.c.exo_rew);
        if (this.mEj != null) {
            this.mEj.setOnClickListener(this.mEd);
        }
        this.mEi = findViewById(a.c.exo_ffwd);
        if (this.mEi != null) {
            this.mEi.setOnClickListener(this.mEd);
        }
        this.mEk = (ImageView) findViewById(a.c.exo_repeat_toggle);
        if (this.mEk != null) {
            this.mEk.setOnClickListener(this.mEd);
        }
        this.mEl = findViewById(a.c.exo_shuffle);
        if (this.mEl != null) {
            this.mEl.setOnClickListener(this.mEd);
        }
        Resources resources = context.getResources();
        this.mEn = resources.getDrawable(a.b.exo_controls_repeat_off);
        this.mEo = resources.getDrawable(a.b.exo_controls_repeat_one);
        this.mEp = resources.getDrawable(a.b.exo_controls_repeat_all);
        this.mEq = resources.getString(a.e.exo_controls_repeat_off_description);
        this.mEr = resources.getString(a.e.exo_controls_repeat_one_description);
        this.mEs = resources.getString(a.e.exo_controls_repeat_all_description);
    }

    private static int b(TypedArray typedArray, int i) {
        return typedArray.getInt(a.f.PlaybackControlView_repeat_toggle_modes, i);
    }

    public r getPlayer() {
        return this.mEt;
    }

    public void setPlayer(r rVar) {
        if (this.mEt != rVar) {
            if (this.mEt != null) {
                this.mEt.b(this.mEd);
            }
            this.mEt = rVar;
            if (rVar != null) {
                rVar.a(this.mEd);
            }
            updateAll();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.mEx = z;
        dyI();
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.mEF = new long[0];
            this.mEG = new boolean[0];
        } else {
            com.google.android.exoplayer2.util.a.checkArgument(jArr.length == zArr.length);
            this.mEF = jArr;
            this.mEG = zArr;
        }
        ahC();
    }

    public void setVisibilityListener(d dVar) {
        this.mEv = dVar;
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        if (cVar == null) {
            cVar = new com.google.android.exoplayer2.d();
        }
        this.mEu = cVar;
    }

    public void setRewindIncrementMs(int i) {
        this.mEz = i;
        dyF();
    }

    public void setFastForwardIncrementMs(int i) {
        this.mEA = i;
        dyF();
    }

    public int getShowTimeoutMs() {
        return this.mEB;
    }

    public void setShowTimeoutMs(int i) {
        this.mEB = i;
    }

    public int getRepeatToggleModes() {
        return this.mEC;
    }

    public void setRepeatToggleModes(int i) {
        this.mEC = i;
        if (this.mEt != null) {
            int repeatMode = this.mEt.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.mEu.a(this.mEt, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.mEu.a(this.mEt, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.mEu.a(this.mEt, 2);
            }
        }
    }

    public boolean getShowShuffleButton() {
        return this.mED;
    }

    public void setShowShuffleButton(boolean z) {
        this.mED = z;
        dyH();
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            if (this.mEv != null) {
                this.mEv.LO(getVisibility());
            }
            updateAll();
            dyJ();
        }
        dyD();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            if (this.mEv != null) {
                this.mEv.LO(getVisibility());
            }
            removeCallbacks(this.mEH);
            removeCallbacks(this.mEI);
            this.mEE = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyD() {
        removeCallbacks(this.mEI);
        if (this.mEB > 0) {
            this.mEE = SystemClock.uptimeMillis() + this.mEB;
            if (this.mEw) {
                postDelayed(this.mEI, this.mEB);
                return;
            }
            return;
        }
        this.mEE = -9223372036854775807L;
    }

    private void updateAll() {
        dyE();
        dyF();
        dyG();
        dyH();
        ahC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyE() {
        boolean z;
        boolean z2 = true;
        if (isVisible() && this.mEw) {
            boolean z3 = this.mEt != null && this.mEt.dsR();
            if (this.mEg != null) {
                boolean z4 = false | (z3 && this.mEg.isFocused());
                this.mEg.setVisibility(z3 ? 8 : 0);
                z = z4;
            } else {
                z = false;
            }
            if (this.mEh != null) {
                if (z3 || !this.mEh.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                this.mEh.setVisibility(z3 ? 0 : 8);
            }
            if (z) {
                dyJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyF() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (isVisible() && this.mEw) {
            x dtc = this.mEt != null ? this.mEt.dtc() : null;
            if (!((dtc == null || dtc.isEmpty()) ? false : true) || this.mEt.dsZ()) {
                z = false;
                z2 = false;
                z3 = false;
            } else {
                dtc.a(this.mEt.dsV(), this.lbE);
                z3 = this.lbE.maq;
                z2 = (!z3 && this.lbE.isDynamic && this.mEt.dsX() == -1) ? false : true;
                z = this.lbE.isDynamic || this.mEt.dsW() != -1;
            }
            a(z2, this.mEe);
            a(z, this.mEf);
            a(this.mEA > 0 && z3, this.mEi);
            if (this.mEz <= 0 || !z3) {
                z4 = false;
            }
            a(z4, this.mEj);
            if (this.mEm != null) {
                this.mEm.setEnabled(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyG() {
        if (isVisible() && this.mEw && this.mEk != null) {
            if (this.mEC == 0) {
                this.mEk.setVisibility(8);
            } else if (this.mEt == null) {
                a(false, (View) this.mEk);
            } else {
                a(true, (View) this.mEk);
                switch (this.mEt.getRepeatMode()) {
                    case 0:
                        this.mEk.setImageDrawable(this.mEn);
                        this.mEk.setContentDescription(this.mEq);
                        break;
                    case 1:
                        this.mEk.setImageDrawable(this.mEo);
                        this.mEk.setContentDescription(this.mEr);
                        break;
                    case 2:
                        this.mEk.setImageDrawable(this.mEp);
                        this.mEk.setContentDescription(this.mEs);
                        break;
                }
                this.mEk.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyH() {
        if (isVisible() && this.mEw && this.mEl != null) {
            if (!this.mED) {
                this.mEl.setVisibility(8);
            } else if (this.mEt == null) {
                a(false, this.mEl);
            } else {
                this.mEl.setAlpha(this.mEt.dsS() ? 1.0f : 0.3f);
                this.mEl.setEnabled(true);
                this.mEl.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyI() {
        if (this.mEt != null) {
            this.mEy = this.mEx && a(this.mEt.dtc(), this.lbE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahC() {
        long j;
        long bufferedPosition;
        if (isVisible() && this.mEw) {
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            if (this.mEt != null) {
                long j5 = 0;
                long j6 = 0;
                int i = 0;
                x dtc = this.mEt.dtc();
                if (!dtc.isEmpty()) {
                    int dsV = this.mEt.dsV();
                    int i2 = this.mEy ? 0 : dsV;
                    int dtz = this.mEy ? dtc.dtz() - 1 : dsV;
                    int i3 = i2;
                    while (true) {
                        if (i3 > dtz) {
                            break;
                        }
                        if (i3 == dsV) {
                            j5 = j6;
                        }
                        dtc.a(i3, this.lbE);
                        if (this.lbE.lZB == -9223372036854775807L) {
                            com.google.android.exoplayer2.util.a.checkState(!this.mEy);
                        } else {
                            for (int i4 = this.lbE.mar; i4 <= this.lbE.mas; i4++) {
                                dtc.a(i4, this.lbF);
                                int dtE = this.lbF.dtE();
                                for (int i5 = 0; i5 < dtE; i5++) {
                                    long IZ = this.lbF.IZ(i5);
                                    if (IZ == Long.MIN_VALUE) {
                                        if (this.lbF.lZB != -9223372036854775807L) {
                                            IZ = this.lbF.lZB;
                                        }
                                    }
                                    long dtD = this.lbF.dtD() + IZ;
                                    if (dtD >= 0 && dtD <= this.lbE.lZB) {
                                        if (i == this.mDZ.length) {
                                            int length = this.mDZ.length == 0 ? 1 : this.mDZ.length * 2;
                                            this.mDZ = Arrays.copyOf(this.mDZ, length);
                                            this.mEa = Arrays.copyOf(this.mEa, length);
                                        }
                                        this.mDZ[i] = com.google.android.exoplayer2.b.fn(dtD + j6);
                                        this.mEa[i] = this.lbF.Jb(i5);
                                        i++;
                                    }
                                }
                            }
                            j6 += this.lbE.lZB;
                            i3++;
                        }
                    }
                }
                long fn = com.google.android.exoplayer2.b.fn(j6);
                long fn2 = com.google.android.exoplayer2.b.fn(j5);
                if (this.mEt.dsZ()) {
                    bufferedPosition = fn2 + this.mEt.dta();
                    j2 = bufferedPosition;
                } else {
                    j2 = this.mEt.getCurrentPosition() + fn2;
                    bufferedPosition = fn2 + this.mEt.getBufferedPosition();
                }
                if (this.mEm != null) {
                    int length2 = this.mEF.length;
                    int i6 = i + length2;
                    if (i6 > this.mDZ.length) {
                        this.mDZ = Arrays.copyOf(this.mDZ, i6);
                        this.mEa = Arrays.copyOf(this.mEa, i6);
                    }
                    System.arraycopy(this.mEF, 0, this.mDZ, i, length2);
                    System.arraycopy(this.mEG, 0, this.mEa, i, length2);
                    this.mEm.setAdGroupTimesMs(this.mDZ, this.mEa, i6);
                }
                j3 = bufferedPosition;
                j4 = fn;
            }
            if (this.efv != null) {
                this.efv.setText(v.a(this.mDN, this.mDO, j4));
            }
            if (this.eft != null && !this.mDV) {
                this.eft.setText(v.a(this.mDN, this.mDO, j2));
            }
            if (this.mEm != null) {
                this.mEm.setPosition(j2);
                this.mEm.setBufferedPosition(j3);
                this.mEm.setDuration(j4);
            }
            removeCallbacks(this.mEH);
            int cZN = this.mEt == null ? 1 : this.mEt.cZN();
            if (cZN != 1 && cZN != 4) {
                if (this.mEt.dsR() && cZN == 3) {
                    float f = this.mEt.dsT().speed;
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
                postDelayed(this.mEH, j);
            }
        }
    }

    private void dyJ() {
        boolean z = this.mEt != null && this.mEt.dsR();
        if (!z && this.mEg != null) {
            this.mEg.requestFocus();
        } else if (z && this.mEh != null) {
            this.mEh.requestFocus();
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
        x dtc = this.mEt.dtc();
        if (!dtc.isEmpty()) {
            dtc.a(this.mEt.dsV(), this.lbE);
            int dsX = this.mEt.dsX();
            if (dsX != -1 && (this.mEt.getCurrentPosition() <= 3000 || (this.lbE.isDynamic && !this.lbE.maq))) {
                A(dsX, -9223372036854775807L);
            } else {
                seekTo(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        x dtc = this.mEt.dtc();
        if (!dtc.isEmpty()) {
            int dsV = this.mEt.dsV();
            int dsW = this.mEt.dsW();
            if (dsW != -1) {
                A(dsW, -9223372036854775807L);
            } else if (dtc.a(dsV, this.lbE, false).isDynamic) {
                A(dsV, -9223372036854775807L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.mEz > 0) {
            seekTo(Math.max(this.mEt.getCurrentPosition() - this.mEz, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.mEA > 0) {
            long duration = this.mEt.getDuration();
            long currentPosition = this.mEt.getCurrentPosition() + this.mEA;
            if (duration != -9223372036854775807L) {
                currentPosition = Math.min(currentPosition, duration);
            }
            seekTo(currentPosition);
        }
    }

    private void seekTo(long j) {
        A(this.mEt.dsV(), j);
    }

    private void A(int i, long j) {
        if (!this.mEu.a(this.mEt, i, j)) {
            ahC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(long j) {
        int dsV;
        x dtc = this.mEt.dtc();
        if (this.mEy && !dtc.isEmpty()) {
            int dtz = dtc.dtz();
            dsV = 0;
            while (true) {
                long dtB = dtc.a(dsV, this.lbE).dtB();
                if (j < dtB) {
                    break;
                } else if (dsV == dtz - 1) {
                    j = dtB;
                    break;
                } else {
                    j -= dtB;
                    dsV++;
                }
            }
        } else {
            dsV = this.mEt.dsV();
        }
        A(dsV, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mEw = true;
        if (this.mEE != -9223372036854775807L) {
            long uptimeMillis = this.mEE - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.mEI, uptimeMillis);
            }
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mEw = false;
        removeCallbacks(this.mEH);
        removeCallbacks(this.mEI);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mEt == null || !LN(keyCode)) {
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
                        this.mEu.a(this.mEt, this.mEt.dsR() ? false : true);
                        return true;
                    case 87:
                        next();
                        return true;
                    case 88:
                        previous();
                        return true;
                    case Opcodes.IAND /* 126 */:
                        this.mEu.a(this.mEt, true);
                        return true;
                    case 127:
                        this.mEu.a(this.mEt, false);
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
        if (xVar.dtz() > 100) {
            return false;
        }
        int dtz = xVar.dtz();
        for (int i = 0; i < dtz; i++) {
            if (xVar.a(i, bVar).lZB == -9223372036854775807L) {
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
            PlaybackControlView.this.removeCallbacks(PlaybackControlView.this.mEI);
            PlaybackControlView.this.mDV = true;
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void b(com.google.android.exoplayer2.ui.c cVar, long j) {
            if (PlaybackControlView.this.eft != null) {
                PlaybackControlView.this.eft.setText(v.a(PlaybackControlView.this.mDN, PlaybackControlView.this.mDO, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j, boolean z) {
            PlaybackControlView.this.mDV = false;
            if (!z && PlaybackControlView.this.mEt != null) {
                PlaybackControlView.this.gE(j);
            }
            PlaybackControlView.this.dyD();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
            PlaybackControlView.this.dyE();
            PlaybackControlView.this.ahC();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
            PlaybackControlView.this.dyG();
            PlaybackControlView.this.dyF();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ue(boolean z) {
            PlaybackControlView.this.dyH();
            PlaybackControlView.this.dyF();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ET(int i) {
            PlaybackControlView.this.dyF();
            PlaybackControlView.this.ahC();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
            PlaybackControlView.this.dyF();
            PlaybackControlView.this.dyI();
            PlaybackControlView.this.ahC();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlaybackControlView.this.mEt != null) {
                if (PlaybackControlView.this.mEf == view) {
                    PlaybackControlView.this.next();
                } else if (PlaybackControlView.this.mEe == view) {
                    PlaybackControlView.this.previous();
                } else if (PlaybackControlView.this.mEi == view) {
                    PlaybackControlView.this.fastForward();
                } else if (PlaybackControlView.this.mEj == view) {
                    PlaybackControlView.this.rewind();
                } else if (PlaybackControlView.this.mEg == view) {
                    PlaybackControlView.this.mEu.a(PlaybackControlView.this.mEt, true);
                } else if (PlaybackControlView.this.mEh == view) {
                    PlaybackControlView.this.mEu.a(PlaybackControlView.this.mEt, false);
                } else if (PlaybackControlView.this.mEk != view) {
                    if (PlaybackControlView.this.mEl == view) {
                        PlaybackControlView.this.mEu.b(PlaybackControlView.this.mEt, PlaybackControlView.this.mEt.dsS() ? false : true);
                    }
                } else {
                    PlaybackControlView.this.mEu.a(PlaybackControlView.this.mEt, o.dX(PlaybackControlView.this.mEt.getRepeatMode(), PlaybackControlView.this.mEC));
                }
            }
            PlaybackControlView.this.dyD();
        }
    }
}
