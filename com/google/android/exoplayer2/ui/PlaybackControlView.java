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
/* loaded from: classes5.dex */
public class PlaybackControlView extends FrameLayout {
    @Deprecated
    public static final b mDu;
    private final TextView ebq;
    private final TextView ebs;
    private final x.b laY;
    private final x.a laZ;
    private final View mDA;
    private final View mDB;
    private final View mDC;
    private final View mDD;
    private final ImageView mDE;
    private final View mDF;
    private final com.google.android.exoplayer2.ui.c mDG;
    private final Drawable mDH;
    private final Drawable mDI;
    private final Drawable mDJ;
    private final String mDK;
    private final String mDL;
    private final String mDM;
    private r mDN;
    private com.google.android.exoplayer2.c mDO;
    private d mDP;
    private boolean mDQ;
    private boolean mDR;
    private boolean mDS;
    private int mDT;
    private int mDU;
    private int mDV;
    private int mDW;
    private boolean mDX;
    private long mDY;
    private long[] mDZ;
    private final StringBuilder mDf;
    private final Formatter mDg;
    private boolean mDn;
    private long[] mDr;
    private boolean[] mDs;
    private final a mDv;
    private final View mDw;
    private final View mDz;
    private boolean[] mEa;
    private final Runnable mEb;
    private final Runnable mEc;

    @Deprecated
    /* loaded from: classes5.dex */
    public interface b extends com.google.android.exoplayer2.c {
    }

    /* loaded from: classes5.dex */
    public interface d {
        void LJ(int i);
    }

    static {
        l.OY("goog.exo.ui");
        mDu = new c();
    }

    /* loaded from: classes5.dex */
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
        this.mEb = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.afo();
            }
        };
        this.mEc = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.hide();
            }
        };
        int i2 = a.d.exo_playback_control_view;
        this.mDT = 5000;
        this.mDU = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
        this.mDV = 5000;
        this.mDW = 0;
        this.mDX = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, a.f.PlaybackControlView, 0, 0);
            try {
                this.mDT = obtainStyledAttributes.getInt(a.f.PlaybackControlView_rewind_increment, this.mDT);
                this.mDU = obtainStyledAttributes.getInt(a.f.PlaybackControlView_fastforward_increment, this.mDU);
                this.mDV = obtainStyledAttributes.getInt(a.f.PlaybackControlView_show_timeout, this.mDV);
                i2 = obtainStyledAttributes.getResourceId(a.f.PlaybackControlView_controller_layout_id, i2);
                this.mDW = b(obtainStyledAttributes, this.mDW);
                this.mDX = obtainStyledAttributes.getBoolean(a.f.PlaybackControlView_show_shuffle_button, this.mDX);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.laZ = new x.a();
        this.laY = new x.b();
        this.mDf = new StringBuilder();
        this.mDg = new Formatter(this.mDf, Locale.getDefault());
        this.mDr = new long[0];
        this.mDs = new boolean[0];
        this.mDZ = new long[0];
        this.mEa = new boolean[0];
        this.mDv = new a();
        this.mDO = new com.google.android.exoplayer2.d();
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        this.ebs = (TextView) findViewById(a.c.exo_duration);
        this.ebq = (TextView) findViewById(a.c.exo_position);
        this.mDG = (com.google.android.exoplayer2.ui.c) findViewById(a.c.exo_progress);
        if (this.mDG != null) {
            this.mDG.a(this.mDv);
        }
        this.mDA = findViewById(a.c.exo_play);
        if (this.mDA != null) {
            this.mDA.setOnClickListener(this.mDv);
        }
        this.mDB = findViewById(a.c.exo_pause);
        if (this.mDB != null) {
            this.mDB.setOnClickListener(this.mDv);
        }
        this.mDw = findViewById(a.c.exo_prev);
        if (this.mDw != null) {
            this.mDw.setOnClickListener(this.mDv);
        }
        this.mDz = findViewById(a.c.exo_next);
        if (this.mDz != null) {
            this.mDz.setOnClickListener(this.mDv);
        }
        this.mDD = findViewById(a.c.exo_rew);
        if (this.mDD != null) {
            this.mDD.setOnClickListener(this.mDv);
        }
        this.mDC = findViewById(a.c.exo_ffwd);
        if (this.mDC != null) {
            this.mDC.setOnClickListener(this.mDv);
        }
        this.mDE = (ImageView) findViewById(a.c.exo_repeat_toggle);
        if (this.mDE != null) {
            this.mDE.setOnClickListener(this.mDv);
        }
        this.mDF = findViewById(a.c.exo_shuffle);
        if (this.mDF != null) {
            this.mDF.setOnClickListener(this.mDv);
        }
        Resources resources = context.getResources();
        this.mDH = resources.getDrawable(a.b.exo_controls_repeat_off);
        this.mDI = resources.getDrawable(a.b.exo_controls_repeat_one);
        this.mDJ = resources.getDrawable(a.b.exo_controls_repeat_all);
        this.mDK = resources.getString(a.e.exo_controls_repeat_off_description);
        this.mDL = resources.getString(a.e.exo_controls_repeat_one_description);
        this.mDM = resources.getString(a.e.exo_controls_repeat_all_description);
    }

    private static int b(TypedArray typedArray, int i) {
        return typedArray.getInt(a.f.PlaybackControlView_repeat_toggle_modes, i);
    }

    public r getPlayer() {
        return this.mDN;
    }

    public void setPlayer(r rVar) {
        if (this.mDN != rVar) {
            if (this.mDN != null) {
                this.mDN.b(this.mDv);
            }
            this.mDN = rVar;
            if (rVar != null) {
                rVar.a(this.mDv);
            }
            updateAll();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.mDR = z;
        dxy();
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.mDZ = new long[0];
            this.mEa = new boolean[0];
        } else {
            com.google.android.exoplayer2.util.a.checkArgument(jArr.length == zArr.length);
            this.mDZ = jArr;
            this.mEa = zArr;
        }
        afo();
    }

    public void setVisibilityListener(d dVar) {
        this.mDP = dVar;
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        if (cVar == null) {
            cVar = new com.google.android.exoplayer2.d();
        }
        this.mDO = cVar;
    }

    public void setRewindIncrementMs(int i) {
        this.mDT = i;
        dxv();
    }

    public void setFastForwardIncrementMs(int i) {
        this.mDU = i;
        dxv();
    }

    public int getShowTimeoutMs() {
        return this.mDV;
    }

    public void setShowTimeoutMs(int i) {
        this.mDV = i;
    }

    public int getRepeatToggleModes() {
        return this.mDW;
    }

    public void setRepeatToggleModes(int i) {
        this.mDW = i;
        if (this.mDN != null) {
            int repeatMode = this.mDN.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.mDO.a(this.mDN, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.mDO.a(this.mDN, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.mDO.a(this.mDN, 2);
            }
        }
    }

    public boolean getShowShuffleButton() {
        return this.mDX;
    }

    public void setShowShuffleButton(boolean z) {
        this.mDX = z;
        dxx();
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            if (this.mDP != null) {
                this.mDP.LJ(getVisibility());
            }
            updateAll();
            dxz();
        }
        dxt();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            if (this.mDP != null) {
                this.mDP.LJ(getVisibility());
            }
            removeCallbacks(this.mEb);
            removeCallbacks(this.mEc);
            this.mDY = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxt() {
        removeCallbacks(this.mEc);
        if (this.mDV > 0) {
            this.mDY = SystemClock.uptimeMillis() + this.mDV;
            if (this.mDQ) {
                postDelayed(this.mEc, this.mDV);
                return;
            }
            return;
        }
        this.mDY = -9223372036854775807L;
    }

    private void updateAll() {
        dxu();
        dxv();
        dxw();
        dxx();
        afo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxu() {
        boolean z;
        boolean z2 = true;
        if (isVisible() && this.mDQ) {
            boolean z3 = this.mDN != null && this.mDN.drF();
            if (this.mDA != null) {
                boolean z4 = false | (z3 && this.mDA.isFocused());
                this.mDA.setVisibility(z3 ? 8 : 0);
                z = z4;
            } else {
                z = false;
            }
            if (this.mDB != null) {
                if (z3 || !this.mDB.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                this.mDB.setVisibility(z3 ? 0 : 8);
            }
            if (z) {
                dxz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxv() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (isVisible() && this.mDQ) {
            x drQ = this.mDN != null ? this.mDN.drQ() : null;
            if (!((drQ == null || drQ.isEmpty()) ? false : true) || this.mDN.drN()) {
                z = false;
                z2 = false;
                z3 = false;
            } else {
                drQ.a(this.mDN.drJ(), this.laY);
                z3 = this.laY.lZI;
                z2 = (!z3 && this.laY.isDynamic && this.mDN.drL() == -1) ? false : true;
                z = this.laY.isDynamic || this.mDN.drK() != -1;
            }
            a(z2, this.mDw);
            a(z, this.mDz);
            a(this.mDU > 0 && z3, this.mDC);
            if (this.mDT <= 0 || !z3) {
                z4 = false;
            }
            a(z4, this.mDD);
            if (this.mDG != null) {
                this.mDG.setEnabled(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxw() {
        if (isVisible() && this.mDQ && this.mDE != null) {
            if (this.mDW == 0) {
                this.mDE.setVisibility(8);
            } else if (this.mDN == null) {
                a(false, (View) this.mDE);
            } else {
                a(true, (View) this.mDE);
                switch (this.mDN.getRepeatMode()) {
                    case 0:
                        this.mDE.setImageDrawable(this.mDH);
                        this.mDE.setContentDescription(this.mDK);
                        break;
                    case 1:
                        this.mDE.setImageDrawable(this.mDI);
                        this.mDE.setContentDescription(this.mDL);
                        break;
                    case 2:
                        this.mDE.setImageDrawable(this.mDJ);
                        this.mDE.setContentDescription(this.mDM);
                        break;
                }
                this.mDE.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxx() {
        if (isVisible() && this.mDQ && this.mDF != null) {
            if (!this.mDX) {
                this.mDF.setVisibility(8);
            } else if (this.mDN == null) {
                a(false, this.mDF);
            } else {
                this.mDF.setAlpha(this.mDN.drG() ? 1.0f : 0.3f);
                this.mDF.setEnabled(true);
                this.mDF.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxy() {
        if (this.mDN != null) {
            this.mDS = this.mDR && a(this.mDN.drQ(), this.laY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        long j;
        long bufferedPosition;
        if (isVisible() && this.mDQ) {
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            if (this.mDN != null) {
                long j5 = 0;
                long j6 = 0;
                int i = 0;
                x drQ = this.mDN.drQ();
                if (!drQ.isEmpty()) {
                    int drJ = this.mDN.drJ();
                    int i2 = this.mDS ? 0 : drJ;
                    int dsn = this.mDS ? drQ.dsn() - 1 : drJ;
                    int i3 = i2;
                    while (true) {
                        if (i3 > dsn) {
                            break;
                        }
                        if (i3 == drJ) {
                            j5 = j6;
                        }
                        drQ.a(i3, this.laY);
                        if (this.laY.lYV == -9223372036854775807L) {
                            com.google.android.exoplayer2.util.a.checkState(!this.mDS);
                        } else {
                            for (int i4 = this.laY.lZJ; i4 <= this.laY.lZK; i4++) {
                                drQ.a(i4, this.laZ);
                                int dst = this.laZ.dst();
                                for (int i5 = 0; i5 < dst; i5++) {
                                    long IU = this.laZ.IU(i5);
                                    if (IU == Long.MIN_VALUE) {
                                        if (this.laZ.lYV != -9223372036854775807L) {
                                            IU = this.laZ.lYV;
                                        }
                                    }
                                    long dss = this.laZ.dss() + IU;
                                    if (dss >= 0 && dss <= this.laY.lYV) {
                                        if (i == this.mDr.length) {
                                            int length = this.mDr.length == 0 ? 1 : this.mDr.length * 2;
                                            this.mDr = Arrays.copyOf(this.mDr, length);
                                            this.mDs = Arrays.copyOf(this.mDs, length);
                                        }
                                        this.mDr[i] = com.google.android.exoplayer2.b.fp(dss + j6);
                                        this.mDs[i] = this.laZ.IW(i5);
                                        i++;
                                    }
                                }
                            }
                            j6 += this.laY.lYV;
                            i3++;
                        }
                    }
                }
                long fp = com.google.android.exoplayer2.b.fp(j6);
                long fp2 = com.google.android.exoplayer2.b.fp(j5);
                if (this.mDN.drN()) {
                    bufferedPosition = fp2 + this.mDN.drO();
                    j2 = bufferedPosition;
                } else {
                    j2 = this.mDN.getCurrentPosition() + fp2;
                    bufferedPosition = fp2 + this.mDN.getBufferedPosition();
                }
                if (this.mDG != null) {
                    int length2 = this.mDZ.length;
                    int i6 = i + length2;
                    if (i6 > this.mDr.length) {
                        this.mDr = Arrays.copyOf(this.mDr, i6);
                        this.mDs = Arrays.copyOf(this.mDs, i6);
                    }
                    System.arraycopy(this.mDZ, 0, this.mDr, i, length2);
                    System.arraycopy(this.mEa, 0, this.mDs, i, length2);
                    this.mDG.setAdGroupTimesMs(this.mDr, this.mDs, i6);
                }
                j3 = bufferedPosition;
                j4 = fp;
            }
            if (this.ebs != null) {
                this.ebs.setText(v.a(this.mDf, this.mDg, j4));
            }
            if (this.ebq != null && !this.mDn) {
                this.ebq.setText(v.a(this.mDf, this.mDg, j2));
            }
            if (this.mDG != null) {
                this.mDG.setPosition(j2);
                this.mDG.setBufferedPosition(j3);
                this.mDG.setDuration(j4);
            }
            removeCallbacks(this.mEb);
            int cYz = this.mDN == null ? 1 : this.mDN.cYz();
            if (cYz != 1 && cYz != 4) {
                if (this.mDN.drF() && cYz == 3) {
                    float f = this.mDN.drH().speed;
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
                postDelayed(this.mEb, j);
            }
        }
    }

    private void dxz() {
        boolean z = this.mDN != null && this.mDN.drF();
        if (!z && this.mDA != null) {
            this.mDA.requestFocus();
        } else if (z && this.mDB != null) {
            this.mDB.requestFocus();
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
        x drQ = this.mDN.drQ();
        if (!drQ.isEmpty()) {
            drQ.a(this.mDN.drJ(), this.laY);
            int drL = this.mDN.drL();
            if (drL != -1 && (this.mDN.getCurrentPosition() <= 3000 || (this.laY.isDynamic && !this.laY.lZI))) {
                B(drL, -9223372036854775807L);
            } else {
                seekTo(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        x drQ = this.mDN.drQ();
        if (!drQ.isEmpty()) {
            int drJ = this.mDN.drJ();
            int drK = this.mDN.drK();
            if (drK != -1) {
                B(drK, -9223372036854775807L);
            } else if (drQ.a(drJ, this.laY, false).isDynamic) {
                B(drJ, -9223372036854775807L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.mDT > 0) {
            seekTo(Math.max(this.mDN.getCurrentPosition() - this.mDT, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.mDU > 0) {
            long duration = this.mDN.getDuration();
            long currentPosition = this.mDN.getCurrentPosition() + this.mDU;
            if (duration != -9223372036854775807L) {
                currentPosition = Math.min(currentPosition, duration);
            }
            seekTo(currentPosition);
        }
    }

    private void seekTo(long j) {
        B(this.mDN.drJ(), j);
    }

    private void B(int i, long j) {
        if (!this.mDO.a(this.mDN, i, j)) {
            afo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG(long j) {
        int drJ;
        x drQ = this.mDN.drQ();
        if (this.mDS && !drQ.isEmpty()) {
            int dsn = drQ.dsn();
            drJ = 0;
            while (true) {
                long dsp = drQ.a(drJ, this.laY).dsp();
                if (j < dsp) {
                    break;
                } else if (drJ == dsn - 1) {
                    j = dsp;
                    break;
                } else {
                    j -= dsp;
                    drJ++;
                }
            }
        } else {
            drJ = this.mDN.drJ();
        }
        B(drJ, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mDQ = true;
        if (this.mDY != -9223372036854775807L) {
            long uptimeMillis = this.mDY - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.mEc, uptimeMillis);
            }
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mDQ = false;
        removeCallbacks(this.mEb);
        removeCallbacks(this.mEc);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mDN == null || !LI(keyCode)) {
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
                        this.mDO.a(this.mDN, this.mDN.drF() ? false : true);
                        return true;
                    case 87:
                        next();
                        return true;
                    case 88:
                        previous();
                        return true;
                    case 126:
                        this.mDO.a(this.mDN, true);
                        return true;
                    case 127:
                        this.mDO.a(this.mDN, false);
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
    private static boolean LI(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    private static boolean a(x xVar, x.b bVar) {
        if (xVar.dsn() > 100) {
            return false;
        }
        int dsn = xVar.dsn();
        for (int i = 0; i < dsn; i++) {
            if (xVar.a(i, bVar).lYV == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* loaded from: classes5.dex */
    private final class a extends r.a implements View.OnClickListener, c.a {
        private a() {
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j) {
            PlaybackControlView.this.removeCallbacks(PlaybackControlView.this.mEc);
            PlaybackControlView.this.mDn = true;
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void b(com.google.android.exoplayer2.ui.c cVar, long j) {
            if (PlaybackControlView.this.ebq != null) {
                PlaybackControlView.this.ebq.setText(v.a(PlaybackControlView.this.mDf, PlaybackControlView.this.mDg, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j, boolean z) {
            PlaybackControlView.this.mDn = false;
            if (!z && PlaybackControlView.this.mDN != null) {
                PlaybackControlView.this.gG(j);
            }
            PlaybackControlView.this.dxt();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void z(boolean z, int i) {
            PlaybackControlView.this.dxu();
            PlaybackControlView.this.afo();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
            PlaybackControlView.this.dxw();
            PlaybackControlView.this.dxv();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ua(boolean z) {
            PlaybackControlView.this.dxx();
            PlaybackControlView.this.dxv();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void EO(int i) {
            PlaybackControlView.this.dxv();
            PlaybackControlView.this.afo();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
            PlaybackControlView.this.dxv();
            PlaybackControlView.this.dxy();
            PlaybackControlView.this.afo();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlaybackControlView.this.mDN != null) {
                if (PlaybackControlView.this.mDz == view) {
                    PlaybackControlView.this.next();
                } else if (PlaybackControlView.this.mDw == view) {
                    PlaybackControlView.this.previous();
                } else if (PlaybackControlView.this.mDC == view) {
                    PlaybackControlView.this.fastForward();
                } else if (PlaybackControlView.this.mDD == view) {
                    PlaybackControlView.this.rewind();
                } else if (PlaybackControlView.this.mDA == view) {
                    PlaybackControlView.this.mDO.a(PlaybackControlView.this.mDN, true);
                } else if (PlaybackControlView.this.mDB == view) {
                    PlaybackControlView.this.mDO.a(PlaybackControlView.this.mDN, false);
                } else if (PlaybackControlView.this.mDE != view) {
                    if (PlaybackControlView.this.mDF == view) {
                        PlaybackControlView.this.mDO.b(PlaybackControlView.this.mDN, PlaybackControlView.this.mDN.drG() ? false : true);
                    }
                } else {
                    PlaybackControlView.this.mDO.a(PlaybackControlView.this.mDN, o.dU(PlaybackControlView.this.mDN.getRepeatMode(), PlaybackControlView.this.mDW));
                }
            }
            PlaybackControlView.this.dxt();
        }
    }
}
