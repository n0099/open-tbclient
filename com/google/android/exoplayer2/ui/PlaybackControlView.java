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
    public static final b mEe;
    private final TextView efu;
    private final TextView efw;
    private final x.b lbG;
    private final x.a lbH;
    private final StringBuilder mDP;
    private final Formatter mDQ;
    private boolean mDX;
    private boolean mEA;
    private int mEB;
    private int mEC;
    private int mED;
    private int mEE;
    private boolean mEF;
    private long mEG;
    private long[] mEH;
    private boolean[] mEI;
    private final Runnable mEJ;
    private final Runnable mEK;
    private long[] mEb;
    private boolean[] mEc;
    private final a mEf;
    private final View mEg;
    private final View mEh;
    private final View mEi;
    private final View mEj;
    private final View mEk;
    private final View mEl;
    private final ImageView mEm;
    private final View mEn;
    private final com.google.android.exoplayer2.ui.c mEo;
    private final Drawable mEp;
    private final Drawable mEq;
    private final Drawable mEr;
    private final String mEs;
    private final String mEt;
    private final String mEu;
    private r mEv;
    private com.google.android.exoplayer2.c mEw;
    private d mEx;
    private boolean mEy;
    private boolean mEz;

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
        mEe = new c();
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
        this.mEJ = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.ahE();
            }
        };
        this.mEK = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.hide();
            }
        };
        int i2 = a.d.exo_playback_control_view;
        this.mEB = 5000;
        this.mEC = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
        this.mED = 5000;
        this.mEE = 0;
        this.mEF = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, a.f.PlaybackControlView, 0, 0);
            try {
                this.mEB = obtainStyledAttributes.getInt(a.f.PlaybackControlView_rewind_increment, this.mEB);
                this.mEC = obtainStyledAttributes.getInt(a.f.PlaybackControlView_fastforward_increment, this.mEC);
                this.mED = obtainStyledAttributes.getInt(a.f.PlaybackControlView_show_timeout, this.mED);
                i2 = obtainStyledAttributes.getResourceId(a.f.PlaybackControlView_controller_layout_id, i2);
                this.mEE = b(obtainStyledAttributes, this.mEE);
                this.mEF = obtainStyledAttributes.getBoolean(a.f.PlaybackControlView_show_shuffle_button, this.mEF);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.lbH = new x.a();
        this.lbG = new x.b();
        this.mDP = new StringBuilder();
        this.mDQ = new Formatter(this.mDP, Locale.getDefault());
        this.mEb = new long[0];
        this.mEc = new boolean[0];
        this.mEH = new long[0];
        this.mEI = new boolean[0];
        this.mEf = new a();
        this.mEw = new com.google.android.exoplayer2.d();
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        this.efw = (TextView) findViewById(a.c.exo_duration);
        this.efu = (TextView) findViewById(a.c.exo_position);
        this.mEo = (com.google.android.exoplayer2.ui.c) findViewById(a.c.exo_progress);
        if (this.mEo != null) {
            this.mEo.a(this.mEf);
        }
        this.mEi = findViewById(a.c.exo_play);
        if (this.mEi != null) {
            this.mEi.setOnClickListener(this.mEf);
        }
        this.mEj = findViewById(a.c.exo_pause);
        if (this.mEj != null) {
            this.mEj.setOnClickListener(this.mEf);
        }
        this.mEg = findViewById(a.c.exo_prev);
        if (this.mEg != null) {
            this.mEg.setOnClickListener(this.mEf);
        }
        this.mEh = findViewById(a.c.exo_next);
        if (this.mEh != null) {
            this.mEh.setOnClickListener(this.mEf);
        }
        this.mEl = findViewById(a.c.exo_rew);
        if (this.mEl != null) {
            this.mEl.setOnClickListener(this.mEf);
        }
        this.mEk = findViewById(a.c.exo_ffwd);
        if (this.mEk != null) {
            this.mEk.setOnClickListener(this.mEf);
        }
        this.mEm = (ImageView) findViewById(a.c.exo_repeat_toggle);
        if (this.mEm != null) {
            this.mEm.setOnClickListener(this.mEf);
        }
        this.mEn = findViewById(a.c.exo_shuffle);
        if (this.mEn != null) {
            this.mEn.setOnClickListener(this.mEf);
        }
        Resources resources = context.getResources();
        this.mEp = resources.getDrawable(a.b.exo_controls_repeat_off);
        this.mEq = resources.getDrawable(a.b.exo_controls_repeat_one);
        this.mEr = resources.getDrawable(a.b.exo_controls_repeat_all);
        this.mEs = resources.getString(a.e.exo_controls_repeat_off_description);
        this.mEt = resources.getString(a.e.exo_controls_repeat_one_description);
        this.mEu = resources.getString(a.e.exo_controls_repeat_all_description);
    }

    private static int b(TypedArray typedArray, int i) {
        return typedArray.getInt(a.f.PlaybackControlView_repeat_toggle_modes, i);
    }

    public r getPlayer() {
        return this.mEv;
    }

    public void setPlayer(r rVar) {
        if (this.mEv != rVar) {
            if (this.mEv != null) {
                this.mEv.b(this.mEf);
            }
            this.mEv = rVar;
            if (rVar != null) {
                rVar.a(this.mEf);
            }
            updateAll();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.mEz = z;
        dyK();
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.mEH = new long[0];
            this.mEI = new boolean[0];
        } else {
            com.google.android.exoplayer2.util.a.checkArgument(jArr.length == zArr.length);
            this.mEH = jArr;
            this.mEI = zArr;
        }
        ahE();
    }

    public void setVisibilityListener(d dVar) {
        this.mEx = dVar;
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        if (cVar == null) {
            cVar = new com.google.android.exoplayer2.d();
        }
        this.mEw = cVar;
    }

    public void setRewindIncrementMs(int i) {
        this.mEB = i;
        dyH();
    }

    public void setFastForwardIncrementMs(int i) {
        this.mEC = i;
        dyH();
    }

    public int getShowTimeoutMs() {
        return this.mED;
    }

    public void setShowTimeoutMs(int i) {
        this.mED = i;
    }

    public int getRepeatToggleModes() {
        return this.mEE;
    }

    public void setRepeatToggleModes(int i) {
        this.mEE = i;
        if (this.mEv != null) {
            int repeatMode = this.mEv.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.mEw.a(this.mEv, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.mEw.a(this.mEv, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.mEw.a(this.mEv, 2);
            }
        }
    }

    public boolean getShowShuffleButton() {
        return this.mEF;
    }

    public void setShowShuffleButton(boolean z) {
        this.mEF = z;
        dyJ();
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            if (this.mEx != null) {
                this.mEx.LO(getVisibility());
            }
            updateAll();
            dyL();
        }
        dyF();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            if (this.mEx != null) {
                this.mEx.LO(getVisibility());
            }
            removeCallbacks(this.mEJ);
            removeCallbacks(this.mEK);
            this.mEG = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyF() {
        removeCallbacks(this.mEK);
        if (this.mED > 0) {
            this.mEG = SystemClock.uptimeMillis() + this.mED;
            if (this.mEy) {
                postDelayed(this.mEK, this.mED);
                return;
            }
            return;
        }
        this.mEG = -9223372036854775807L;
    }

    private void updateAll() {
        dyG();
        dyH();
        dyI();
        dyJ();
        ahE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyG() {
        boolean z;
        boolean z2 = true;
        if (isVisible() && this.mEy) {
            boolean z3 = this.mEv != null && this.mEv.dsT();
            if (this.mEi != null) {
                boolean z4 = false | (z3 && this.mEi.isFocused());
                this.mEi.setVisibility(z3 ? 8 : 0);
                z = z4;
            } else {
                z = false;
            }
            if (this.mEj != null) {
                if (z3 || !this.mEj.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                this.mEj.setVisibility(z3 ? 0 : 8);
            }
            if (z) {
                dyL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyH() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (isVisible() && this.mEy) {
            x dte = this.mEv != null ? this.mEv.dte() : null;
            if (!((dte == null || dte.isEmpty()) ? false : true) || this.mEv.dtb()) {
                z = false;
                z2 = false;
                z3 = false;
            } else {
                dte.a(this.mEv.dsX(), this.lbG);
                z3 = this.lbG.mas;
                z2 = (!z3 && this.lbG.isDynamic && this.mEv.dsZ() == -1) ? false : true;
                z = this.lbG.isDynamic || this.mEv.dsY() != -1;
            }
            a(z2, this.mEg);
            a(z, this.mEh);
            a(this.mEC > 0 && z3, this.mEk);
            if (this.mEB <= 0 || !z3) {
                z4 = false;
            }
            a(z4, this.mEl);
            if (this.mEo != null) {
                this.mEo.setEnabled(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyI() {
        if (isVisible() && this.mEy && this.mEm != null) {
            if (this.mEE == 0) {
                this.mEm.setVisibility(8);
            } else if (this.mEv == null) {
                a(false, (View) this.mEm);
            } else {
                a(true, (View) this.mEm);
                switch (this.mEv.getRepeatMode()) {
                    case 0:
                        this.mEm.setImageDrawable(this.mEp);
                        this.mEm.setContentDescription(this.mEs);
                        break;
                    case 1:
                        this.mEm.setImageDrawable(this.mEq);
                        this.mEm.setContentDescription(this.mEt);
                        break;
                    case 2:
                        this.mEm.setImageDrawable(this.mEr);
                        this.mEm.setContentDescription(this.mEu);
                        break;
                }
                this.mEm.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyJ() {
        if (isVisible() && this.mEy && this.mEn != null) {
            if (!this.mEF) {
                this.mEn.setVisibility(8);
            } else if (this.mEv == null) {
                a(false, this.mEn);
            } else {
                this.mEn.setAlpha(this.mEv.dsU() ? 1.0f : 0.3f);
                this.mEn.setEnabled(true);
                this.mEn.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyK() {
        if (this.mEv != null) {
            this.mEA = this.mEz && a(this.mEv.dte(), this.lbG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahE() {
        long j;
        long bufferedPosition;
        if (isVisible() && this.mEy) {
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            if (this.mEv != null) {
                long j5 = 0;
                long j6 = 0;
                int i = 0;
                x dte = this.mEv.dte();
                if (!dte.isEmpty()) {
                    int dsX = this.mEv.dsX();
                    int i2 = this.mEA ? 0 : dsX;
                    int dtB = this.mEA ? dte.dtB() - 1 : dsX;
                    int i3 = i2;
                    while (true) {
                        if (i3 > dtB) {
                            break;
                        }
                        if (i3 == dsX) {
                            j5 = j6;
                        }
                        dte.a(i3, this.lbG);
                        if (this.lbG.lZD == -9223372036854775807L) {
                            com.google.android.exoplayer2.util.a.checkState(!this.mEA);
                        } else {
                            for (int i4 = this.lbG.mat; i4 <= this.lbG.mau; i4++) {
                                dte.a(i4, this.lbH);
                                int dtG = this.lbH.dtG();
                                for (int i5 = 0; i5 < dtG; i5++) {
                                    long IZ = this.lbH.IZ(i5);
                                    if (IZ == Long.MIN_VALUE) {
                                        if (this.lbH.lZD != -9223372036854775807L) {
                                            IZ = this.lbH.lZD;
                                        }
                                    }
                                    long dtF = this.lbH.dtF() + IZ;
                                    if (dtF >= 0 && dtF <= this.lbG.lZD) {
                                        if (i == this.mEb.length) {
                                            int length = this.mEb.length == 0 ? 1 : this.mEb.length * 2;
                                            this.mEb = Arrays.copyOf(this.mEb, length);
                                            this.mEc = Arrays.copyOf(this.mEc, length);
                                        }
                                        this.mEb[i] = com.google.android.exoplayer2.b.fn(dtF + j6);
                                        this.mEc[i] = this.lbH.Jb(i5);
                                        i++;
                                    }
                                }
                            }
                            j6 += this.lbG.lZD;
                            i3++;
                        }
                    }
                }
                long fn = com.google.android.exoplayer2.b.fn(j6);
                long fn2 = com.google.android.exoplayer2.b.fn(j5);
                if (this.mEv.dtb()) {
                    bufferedPosition = fn2 + this.mEv.dtc();
                    j2 = bufferedPosition;
                } else {
                    j2 = this.mEv.getCurrentPosition() + fn2;
                    bufferedPosition = fn2 + this.mEv.getBufferedPosition();
                }
                if (this.mEo != null) {
                    int length2 = this.mEH.length;
                    int i6 = i + length2;
                    if (i6 > this.mEb.length) {
                        this.mEb = Arrays.copyOf(this.mEb, i6);
                        this.mEc = Arrays.copyOf(this.mEc, i6);
                    }
                    System.arraycopy(this.mEH, 0, this.mEb, i, length2);
                    System.arraycopy(this.mEI, 0, this.mEc, i, length2);
                    this.mEo.setAdGroupTimesMs(this.mEb, this.mEc, i6);
                }
                j3 = bufferedPosition;
                j4 = fn;
            }
            if (this.efw != null) {
                this.efw.setText(v.a(this.mDP, this.mDQ, j4));
            }
            if (this.efu != null && !this.mDX) {
                this.efu.setText(v.a(this.mDP, this.mDQ, j2));
            }
            if (this.mEo != null) {
                this.mEo.setPosition(j2);
                this.mEo.setBufferedPosition(j3);
                this.mEo.setDuration(j4);
            }
            removeCallbacks(this.mEJ);
            int cZP = this.mEv == null ? 1 : this.mEv.cZP();
            if (cZP != 1 && cZP != 4) {
                if (this.mEv.dsT() && cZP == 3) {
                    float f = this.mEv.dsV().speed;
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
                postDelayed(this.mEJ, j);
            }
        }
    }

    private void dyL() {
        boolean z = this.mEv != null && this.mEv.dsT();
        if (!z && this.mEi != null) {
            this.mEi.requestFocus();
        } else if (z && this.mEj != null) {
            this.mEj.requestFocus();
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
        x dte = this.mEv.dte();
        if (!dte.isEmpty()) {
            dte.a(this.mEv.dsX(), this.lbG);
            int dsZ = this.mEv.dsZ();
            if (dsZ != -1 && (this.mEv.getCurrentPosition() <= 3000 || (this.lbG.isDynamic && !this.lbG.mas))) {
                A(dsZ, -9223372036854775807L);
            } else {
                seekTo(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        x dte = this.mEv.dte();
        if (!dte.isEmpty()) {
            int dsX = this.mEv.dsX();
            int dsY = this.mEv.dsY();
            if (dsY != -1) {
                A(dsY, -9223372036854775807L);
            } else if (dte.a(dsX, this.lbG, false).isDynamic) {
                A(dsX, -9223372036854775807L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.mEB > 0) {
            seekTo(Math.max(this.mEv.getCurrentPosition() - this.mEB, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.mEC > 0) {
            long duration = this.mEv.getDuration();
            long currentPosition = this.mEv.getCurrentPosition() + this.mEC;
            if (duration != -9223372036854775807L) {
                currentPosition = Math.min(currentPosition, duration);
            }
            seekTo(currentPosition);
        }
    }

    private void seekTo(long j) {
        A(this.mEv.dsX(), j);
    }

    private void A(int i, long j) {
        if (!this.mEw.a(this.mEv, i, j)) {
            ahE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(long j) {
        int dsX;
        x dte = this.mEv.dte();
        if (this.mEA && !dte.isEmpty()) {
            int dtB = dte.dtB();
            dsX = 0;
            while (true) {
                long dtD = dte.a(dsX, this.lbG).dtD();
                if (j < dtD) {
                    break;
                } else if (dsX == dtB - 1) {
                    j = dtD;
                    break;
                } else {
                    j -= dtD;
                    dsX++;
                }
            }
        } else {
            dsX = this.mEv.dsX();
        }
        A(dsX, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mEy = true;
        if (this.mEG != -9223372036854775807L) {
            long uptimeMillis = this.mEG - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.mEK, uptimeMillis);
            }
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mEy = false;
        removeCallbacks(this.mEJ);
        removeCallbacks(this.mEK);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mEv == null || !LN(keyCode)) {
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
                        this.mEw.a(this.mEv, this.mEv.dsT() ? false : true);
                        return true;
                    case 87:
                        next();
                        return true;
                    case 88:
                        previous();
                        return true;
                    case Opcodes.IAND /* 126 */:
                        this.mEw.a(this.mEv, true);
                        return true;
                    case 127:
                        this.mEw.a(this.mEv, false);
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
        if (xVar.dtB() > 100) {
            return false;
        }
        int dtB = xVar.dtB();
        for (int i = 0; i < dtB; i++) {
            if (xVar.a(i, bVar).lZD == -9223372036854775807L) {
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
            PlaybackControlView.this.removeCallbacks(PlaybackControlView.this.mEK);
            PlaybackControlView.this.mDX = true;
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void b(com.google.android.exoplayer2.ui.c cVar, long j) {
            if (PlaybackControlView.this.efu != null) {
                PlaybackControlView.this.efu.setText(v.a(PlaybackControlView.this.mDP, PlaybackControlView.this.mDQ, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j, boolean z) {
            PlaybackControlView.this.mDX = false;
            if (!z && PlaybackControlView.this.mEv != null) {
                PlaybackControlView.this.gE(j);
            }
            PlaybackControlView.this.dyF();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
            PlaybackControlView.this.dyG();
            PlaybackControlView.this.ahE();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
            PlaybackControlView.this.dyI();
            PlaybackControlView.this.dyH();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ue(boolean z) {
            PlaybackControlView.this.dyJ();
            PlaybackControlView.this.dyH();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ET(int i) {
            PlaybackControlView.this.dyH();
            PlaybackControlView.this.ahE();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
            PlaybackControlView.this.dyH();
            PlaybackControlView.this.dyK();
            PlaybackControlView.this.ahE();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlaybackControlView.this.mEv != null) {
                if (PlaybackControlView.this.mEh == view) {
                    PlaybackControlView.this.next();
                } else if (PlaybackControlView.this.mEg == view) {
                    PlaybackControlView.this.previous();
                } else if (PlaybackControlView.this.mEk == view) {
                    PlaybackControlView.this.fastForward();
                } else if (PlaybackControlView.this.mEl == view) {
                    PlaybackControlView.this.rewind();
                } else if (PlaybackControlView.this.mEi == view) {
                    PlaybackControlView.this.mEw.a(PlaybackControlView.this.mEv, true);
                } else if (PlaybackControlView.this.mEj == view) {
                    PlaybackControlView.this.mEw.a(PlaybackControlView.this.mEv, false);
                } else if (PlaybackControlView.this.mEm != view) {
                    if (PlaybackControlView.this.mEn == view) {
                        PlaybackControlView.this.mEw.b(PlaybackControlView.this.mEv, PlaybackControlView.this.mEv.dsU() ? false : true);
                    }
                } else {
                    PlaybackControlView.this.mEw.a(PlaybackControlView.this.mEv, o.dX(PlaybackControlView.this.mEv.getRepeatMode(), PlaybackControlView.this.mEE));
                }
            }
            PlaybackControlView.this.dyF();
        }
    }
}
