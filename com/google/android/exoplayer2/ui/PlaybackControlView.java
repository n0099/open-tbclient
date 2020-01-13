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
    public static final b mDp;
    private final TextView ebq;
    private final TextView ebs;
    private final x.b laT;
    private final x.a laU;
    private final StringBuilder mCZ;
    private final View mDA;
    private final com.google.android.exoplayer2.ui.c mDB;
    private final Drawable mDC;
    private final Drawable mDD;
    private final Drawable mDE;
    private final String mDF;
    private final String mDG;
    private final String mDH;
    private r mDI;
    private com.google.android.exoplayer2.c mDJ;
    private d mDK;
    private boolean mDL;
    private boolean mDM;
    private boolean mDN;
    private int mDO;
    private int mDP;
    private int mDQ;
    private int mDR;
    private boolean mDS;
    private long mDT;
    private long[] mDU;
    private boolean[] mDV;
    private final Runnable mDW;
    private final Runnable mDX;
    private final Formatter mDa;
    private boolean mDi;
    private long[] mDm;
    private boolean[] mDn;
    private final a mDq;
    private final View mDr;
    private final View mDs;
    private final View mDt;
    private final View mDu;
    private final View mDv;
    private final View mDw;
    private final ImageView mDz;

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
        mDp = new c();
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
        this.mDW = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.afo();
            }
        };
        this.mDX = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.hide();
            }
        };
        int i2 = a.d.exo_playback_control_view;
        this.mDO = 5000;
        this.mDP = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
        this.mDQ = 5000;
        this.mDR = 0;
        this.mDS = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, a.f.PlaybackControlView, 0, 0);
            try {
                this.mDO = obtainStyledAttributes.getInt(a.f.PlaybackControlView_rewind_increment, this.mDO);
                this.mDP = obtainStyledAttributes.getInt(a.f.PlaybackControlView_fastforward_increment, this.mDP);
                this.mDQ = obtainStyledAttributes.getInt(a.f.PlaybackControlView_show_timeout, this.mDQ);
                i2 = obtainStyledAttributes.getResourceId(a.f.PlaybackControlView_controller_layout_id, i2);
                this.mDR = b(obtainStyledAttributes, this.mDR);
                this.mDS = obtainStyledAttributes.getBoolean(a.f.PlaybackControlView_show_shuffle_button, this.mDS);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.laU = new x.a();
        this.laT = new x.b();
        this.mCZ = new StringBuilder();
        this.mDa = new Formatter(this.mCZ, Locale.getDefault());
        this.mDm = new long[0];
        this.mDn = new boolean[0];
        this.mDU = new long[0];
        this.mDV = new boolean[0];
        this.mDq = new a();
        this.mDJ = new com.google.android.exoplayer2.d();
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        this.ebs = (TextView) findViewById(a.c.exo_duration);
        this.ebq = (TextView) findViewById(a.c.exo_position);
        this.mDB = (com.google.android.exoplayer2.ui.c) findViewById(a.c.exo_progress);
        if (this.mDB != null) {
            this.mDB.a(this.mDq);
        }
        this.mDt = findViewById(a.c.exo_play);
        if (this.mDt != null) {
            this.mDt.setOnClickListener(this.mDq);
        }
        this.mDu = findViewById(a.c.exo_pause);
        if (this.mDu != null) {
            this.mDu.setOnClickListener(this.mDq);
        }
        this.mDr = findViewById(a.c.exo_prev);
        if (this.mDr != null) {
            this.mDr.setOnClickListener(this.mDq);
        }
        this.mDs = findViewById(a.c.exo_next);
        if (this.mDs != null) {
            this.mDs.setOnClickListener(this.mDq);
        }
        this.mDw = findViewById(a.c.exo_rew);
        if (this.mDw != null) {
            this.mDw.setOnClickListener(this.mDq);
        }
        this.mDv = findViewById(a.c.exo_ffwd);
        if (this.mDv != null) {
            this.mDv.setOnClickListener(this.mDq);
        }
        this.mDz = (ImageView) findViewById(a.c.exo_repeat_toggle);
        if (this.mDz != null) {
            this.mDz.setOnClickListener(this.mDq);
        }
        this.mDA = findViewById(a.c.exo_shuffle);
        if (this.mDA != null) {
            this.mDA.setOnClickListener(this.mDq);
        }
        Resources resources = context.getResources();
        this.mDC = resources.getDrawable(a.b.exo_controls_repeat_off);
        this.mDD = resources.getDrawable(a.b.exo_controls_repeat_one);
        this.mDE = resources.getDrawable(a.b.exo_controls_repeat_all);
        this.mDF = resources.getString(a.e.exo_controls_repeat_off_description);
        this.mDG = resources.getString(a.e.exo_controls_repeat_one_description);
        this.mDH = resources.getString(a.e.exo_controls_repeat_all_description);
    }

    private static int b(TypedArray typedArray, int i) {
        return typedArray.getInt(a.f.PlaybackControlView_repeat_toggle_modes, i);
    }

    public r getPlayer() {
        return this.mDI;
    }

    public void setPlayer(r rVar) {
        if (this.mDI != rVar) {
            if (this.mDI != null) {
                this.mDI.b(this.mDq);
            }
            this.mDI = rVar;
            if (rVar != null) {
                rVar.a(this.mDq);
            }
            updateAll();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.mDM = z;
        dxw();
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.mDU = new long[0];
            this.mDV = new boolean[0];
        } else {
            com.google.android.exoplayer2.util.a.checkArgument(jArr.length == zArr.length);
            this.mDU = jArr;
            this.mDV = zArr;
        }
        afo();
    }

    public void setVisibilityListener(d dVar) {
        this.mDK = dVar;
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        if (cVar == null) {
            cVar = new com.google.android.exoplayer2.d();
        }
        this.mDJ = cVar;
    }

    public void setRewindIncrementMs(int i) {
        this.mDO = i;
        dxt();
    }

    public void setFastForwardIncrementMs(int i) {
        this.mDP = i;
        dxt();
    }

    public int getShowTimeoutMs() {
        return this.mDQ;
    }

    public void setShowTimeoutMs(int i) {
        this.mDQ = i;
    }

    public int getRepeatToggleModes() {
        return this.mDR;
    }

    public void setRepeatToggleModes(int i) {
        this.mDR = i;
        if (this.mDI != null) {
            int repeatMode = this.mDI.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.mDJ.a(this.mDI, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.mDJ.a(this.mDI, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.mDJ.a(this.mDI, 2);
            }
        }
    }

    public boolean getShowShuffleButton() {
        return this.mDS;
    }

    public void setShowShuffleButton(boolean z) {
        this.mDS = z;
        dxv();
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            if (this.mDK != null) {
                this.mDK.LJ(getVisibility());
            }
            updateAll();
            dxx();
        }
        dxr();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            if (this.mDK != null) {
                this.mDK.LJ(getVisibility());
            }
            removeCallbacks(this.mDW);
            removeCallbacks(this.mDX);
            this.mDT = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxr() {
        removeCallbacks(this.mDX);
        if (this.mDQ > 0) {
            this.mDT = SystemClock.uptimeMillis() + this.mDQ;
            if (this.mDL) {
                postDelayed(this.mDX, this.mDQ);
                return;
            }
            return;
        }
        this.mDT = -9223372036854775807L;
    }

    private void updateAll() {
        dxs();
        dxt();
        dxu();
        dxv();
        afo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxs() {
        boolean z;
        boolean z2 = true;
        if (isVisible() && this.mDL) {
            boolean z3 = this.mDI != null && this.mDI.drD();
            if (this.mDt != null) {
                boolean z4 = false | (z3 && this.mDt.isFocused());
                this.mDt.setVisibility(z3 ? 8 : 0);
                z = z4;
            } else {
                z = false;
            }
            if (this.mDu != null) {
                if (z3 || !this.mDu.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                this.mDu.setVisibility(z3 ? 0 : 8);
            }
            if (z) {
                dxx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxt() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (isVisible() && this.mDL) {
            x drO = this.mDI != null ? this.mDI.drO() : null;
            if (!((drO == null || drO.isEmpty()) ? false : true) || this.mDI.drL()) {
                z = false;
                z2 = false;
                z3 = false;
            } else {
                drO.a(this.mDI.drH(), this.laT);
                z3 = this.laT.lZD;
                z2 = (!z3 && this.laT.isDynamic && this.mDI.drJ() == -1) ? false : true;
                z = this.laT.isDynamic || this.mDI.drI() != -1;
            }
            a(z2, this.mDr);
            a(z, this.mDs);
            a(this.mDP > 0 && z3, this.mDv);
            if (this.mDO <= 0 || !z3) {
                z4 = false;
            }
            a(z4, this.mDw);
            if (this.mDB != null) {
                this.mDB.setEnabled(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxu() {
        if (isVisible() && this.mDL && this.mDz != null) {
            if (this.mDR == 0) {
                this.mDz.setVisibility(8);
            } else if (this.mDI == null) {
                a(false, (View) this.mDz);
            } else {
                a(true, (View) this.mDz);
                switch (this.mDI.getRepeatMode()) {
                    case 0:
                        this.mDz.setImageDrawable(this.mDC);
                        this.mDz.setContentDescription(this.mDF);
                        break;
                    case 1:
                        this.mDz.setImageDrawable(this.mDD);
                        this.mDz.setContentDescription(this.mDG);
                        break;
                    case 2:
                        this.mDz.setImageDrawable(this.mDE);
                        this.mDz.setContentDescription(this.mDH);
                        break;
                }
                this.mDz.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxv() {
        if (isVisible() && this.mDL && this.mDA != null) {
            if (!this.mDS) {
                this.mDA.setVisibility(8);
            } else if (this.mDI == null) {
                a(false, this.mDA);
            } else {
                this.mDA.setAlpha(this.mDI.drE() ? 1.0f : 0.3f);
                this.mDA.setEnabled(true);
                this.mDA.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxw() {
        if (this.mDI != null) {
            this.mDN = this.mDM && a(this.mDI.drO(), this.laT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        long j;
        long bufferedPosition;
        if (isVisible() && this.mDL) {
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            if (this.mDI != null) {
                long j5 = 0;
                long j6 = 0;
                int i = 0;
                x drO = this.mDI.drO();
                if (!drO.isEmpty()) {
                    int drH = this.mDI.drH();
                    int i2 = this.mDN ? 0 : drH;
                    int dsl = this.mDN ? drO.dsl() - 1 : drH;
                    int i3 = i2;
                    while (true) {
                        if (i3 > dsl) {
                            break;
                        }
                        if (i3 == drH) {
                            j5 = j6;
                        }
                        drO.a(i3, this.laT);
                        if (this.laT.lYQ == -9223372036854775807L) {
                            com.google.android.exoplayer2.util.a.checkState(!this.mDN);
                        } else {
                            for (int i4 = this.laT.lZE; i4 <= this.laT.lZF; i4++) {
                                drO.a(i4, this.laU);
                                int dsr = this.laU.dsr();
                                for (int i5 = 0; i5 < dsr; i5++) {
                                    long IU = this.laU.IU(i5);
                                    if (IU == Long.MIN_VALUE) {
                                        if (this.laU.lYQ != -9223372036854775807L) {
                                            IU = this.laU.lYQ;
                                        }
                                    }
                                    long dsq = this.laU.dsq() + IU;
                                    if (dsq >= 0 && dsq <= this.laT.lYQ) {
                                        if (i == this.mDm.length) {
                                            int length = this.mDm.length == 0 ? 1 : this.mDm.length * 2;
                                            this.mDm = Arrays.copyOf(this.mDm, length);
                                            this.mDn = Arrays.copyOf(this.mDn, length);
                                        }
                                        this.mDm[i] = com.google.android.exoplayer2.b.fp(dsq + j6);
                                        this.mDn[i] = this.laU.IW(i5);
                                        i++;
                                    }
                                }
                            }
                            j6 += this.laT.lYQ;
                            i3++;
                        }
                    }
                }
                long fp = com.google.android.exoplayer2.b.fp(j6);
                long fp2 = com.google.android.exoplayer2.b.fp(j5);
                if (this.mDI.drL()) {
                    bufferedPosition = fp2 + this.mDI.drM();
                    j2 = bufferedPosition;
                } else {
                    j2 = this.mDI.getCurrentPosition() + fp2;
                    bufferedPosition = fp2 + this.mDI.getBufferedPosition();
                }
                if (this.mDB != null) {
                    int length2 = this.mDU.length;
                    int i6 = i + length2;
                    if (i6 > this.mDm.length) {
                        this.mDm = Arrays.copyOf(this.mDm, i6);
                        this.mDn = Arrays.copyOf(this.mDn, i6);
                    }
                    System.arraycopy(this.mDU, 0, this.mDm, i, length2);
                    System.arraycopy(this.mDV, 0, this.mDn, i, length2);
                    this.mDB.setAdGroupTimesMs(this.mDm, this.mDn, i6);
                }
                j3 = bufferedPosition;
                j4 = fp;
            }
            if (this.ebs != null) {
                this.ebs.setText(v.a(this.mCZ, this.mDa, j4));
            }
            if (this.ebq != null && !this.mDi) {
                this.ebq.setText(v.a(this.mCZ, this.mDa, j2));
            }
            if (this.mDB != null) {
                this.mDB.setPosition(j2);
                this.mDB.setBufferedPosition(j3);
                this.mDB.setDuration(j4);
            }
            removeCallbacks(this.mDW);
            int cYx = this.mDI == null ? 1 : this.mDI.cYx();
            if (cYx != 1 && cYx != 4) {
                if (this.mDI.drD() && cYx == 3) {
                    float f = this.mDI.drF().speed;
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
                postDelayed(this.mDW, j);
            }
        }
    }

    private void dxx() {
        boolean z = this.mDI != null && this.mDI.drD();
        if (!z && this.mDt != null) {
            this.mDt.requestFocus();
        } else if (z && this.mDu != null) {
            this.mDu.requestFocus();
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
        x drO = this.mDI.drO();
        if (!drO.isEmpty()) {
            drO.a(this.mDI.drH(), this.laT);
            int drJ = this.mDI.drJ();
            if (drJ != -1 && (this.mDI.getCurrentPosition() <= 3000 || (this.laT.isDynamic && !this.laT.lZD))) {
                B(drJ, -9223372036854775807L);
            } else {
                seekTo(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        x drO = this.mDI.drO();
        if (!drO.isEmpty()) {
            int drH = this.mDI.drH();
            int drI = this.mDI.drI();
            if (drI != -1) {
                B(drI, -9223372036854775807L);
            } else if (drO.a(drH, this.laT, false).isDynamic) {
                B(drH, -9223372036854775807L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.mDO > 0) {
            seekTo(Math.max(this.mDI.getCurrentPosition() - this.mDO, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.mDP > 0) {
            long duration = this.mDI.getDuration();
            long currentPosition = this.mDI.getCurrentPosition() + this.mDP;
            if (duration != -9223372036854775807L) {
                currentPosition = Math.min(currentPosition, duration);
            }
            seekTo(currentPosition);
        }
    }

    private void seekTo(long j) {
        B(this.mDI.drH(), j);
    }

    private void B(int i, long j) {
        if (!this.mDJ.a(this.mDI, i, j)) {
            afo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG(long j) {
        int drH;
        x drO = this.mDI.drO();
        if (this.mDN && !drO.isEmpty()) {
            int dsl = drO.dsl();
            drH = 0;
            while (true) {
                long dsn = drO.a(drH, this.laT).dsn();
                if (j < dsn) {
                    break;
                } else if (drH == dsl - 1) {
                    j = dsn;
                    break;
                } else {
                    j -= dsn;
                    drH++;
                }
            }
        } else {
            drH = this.mDI.drH();
        }
        B(drH, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mDL = true;
        if (this.mDT != -9223372036854775807L) {
            long uptimeMillis = this.mDT - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.mDX, uptimeMillis);
            }
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mDL = false;
        removeCallbacks(this.mDW);
        removeCallbacks(this.mDX);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mDI == null || !LI(keyCode)) {
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
                        this.mDJ.a(this.mDI, this.mDI.drD() ? false : true);
                        return true;
                    case 87:
                        next();
                        return true;
                    case 88:
                        previous();
                        return true;
                    case 126:
                        this.mDJ.a(this.mDI, true);
                        return true;
                    case 127:
                        this.mDJ.a(this.mDI, false);
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
        if (xVar.dsl() > 100) {
            return false;
        }
        int dsl = xVar.dsl();
        for (int i = 0; i < dsl; i++) {
            if (xVar.a(i, bVar).lYQ == -9223372036854775807L) {
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
            PlaybackControlView.this.removeCallbacks(PlaybackControlView.this.mDX);
            PlaybackControlView.this.mDi = true;
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void b(com.google.android.exoplayer2.ui.c cVar, long j) {
            if (PlaybackControlView.this.ebq != null) {
                PlaybackControlView.this.ebq.setText(v.a(PlaybackControlView.this.mCZ, PlaybackControlView.this.mDa, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j, boolean z) {
            PlaybackControlView.this.mDi = false;
            if (!z && PlaybackControlView.this.mDI != null) {
                PlaybackControlView.this.gG(j);
            }
            PlaybackControlView.this.dxr();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void z(boolean z, int i) {
            PlaybackControlView.this.dxs();
            PlaybackControlView.this.afo();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
            PlaybackControlView.this.dxu();
            PlaybackControlView.this.dxt();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ua(boolean z) {
            PlaybackControlView.this.dxv();
            PlaybackControlView.this.dxt();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void EO(int i) {
            PlaybackControlView.this.dxt();
            PlaybackControlView.this.afo();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
            PlaybackControlView.this.dxt();
            PlaybackControlView.this.dxw();
            PlaybackControlView.this.afo();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlaybackControlView.this.mDI != null) {
                if (PlaybackControlView.this.mDs == view) {
                    PlaybackControlView.this.next();
                } else if (PlaybackControlView.this.mDr == view) {
                    PlaybackControlView.this.previous();
                } else if (PlaybackControlView.this.mDv == view) {
                    PlaybackControlView.this.fastForward();
                } else if (PlaybackControlView.this.mDw == view) {
                    PlaybackControlView.this.rewind();
                } else if (PlaybackControlView.this.mDt == view) {
                    PlaybackControlView.this.mDJ.a(PlaybackControlView.this.mDI, true);
                } else if (PlaybackControlView.this.mDu == view) {
                    PlaybackControlView.this.mDJ.a(PlaybackControlView.this.mDI, false);
                } else if (PlaybackControlView.this.mDz != view) {
                    if (PlaybackControlView.this.mDA == view) {
                        PlaybackControlView.this.mDJ.b(PlaybackControlView.this.mDI, PlaybackControlView.this.mDI.drE() ? false : true);
                    }
                } else {
                    PlaybackControlView.this.mDJ.a(PlaybackControlView.this.mDI, o.dU(PlaybackControlView.this.mDI.getRepeatMode(), PlaybackControlView.this.mDR));
                }
            }
            PlaybackControlView.this.dxr();
        }
    }
}
