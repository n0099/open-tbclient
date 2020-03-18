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
    public static final b mFW;
    private final TextView efX;
    private final TextView efZ;
    private final x.b ldx;
    private final x.a ldy;
    private final StringBuilder mFH;
    private final Formatter mFI;
    private boolean mFP;
    private long[] mFT;
    private boolean[] mFU;
    private final a mFX;
    private final View mFY;
    private final View mFZ;
    private boolean[] mGA;
    private final Runnable mGB;
    private final Runnable mGC;
    private final View mGa;
    private final View mGb;
    private final View mGc;
    private final View mGd;
    private final ImageView mGe;
    private final View mGf;
    private final com.google.android.exoplayer2.ui.c mGg;
    private final Drawable mGh;
    private final Drawable mGi;
    private final Drawable mGj;
    private final String mGk;
    private final String mGl;
    private final String mGm;
    private r mGn;
    private com.google.android.exoplayer2.c mGo;
    private d mGp;
    private boolean mGq;
    private boolean mGr;
    private boolean mGs;
    private int mGt;
    private int mGu;
    private int mGv;
    private int mGw;
    private boolean mGx;
    private long mGy;
    private long[] mGz;

    @Deprecated
    /* loaded from: classes6.dex */
    public interface b extends com.google.android.exoplayer2.c {
    }

    /* loaded from: classes6.dex */
    public interface d {
        void LU(int i);
    }

    static {
        l.Pl("goog.exo.ui");
        mFW = new c();
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
        this.mGB = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.ahH();
            }
        };
        this.mGC = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.hide();
            }
        };
        int i2 = a.d.exo_playback_control_view;
        this.mGt = 5000;
        this.mGu = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
        this.mGv = 5000;
        this.mGw = 0;
        this.mGx = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, a.f.PlaybackControlView, 0, 0);
            try {
                this.mGt = obtainStyledAttributes.getInt(a.f.PlaybackControlView_rewind_increment, this.mGt);
                this.mGu = obtainStyledAttributes.getInt(a.f.PlaybackControlView_fastforward_increment, this.mGu);
                this.mGv = obtainStyledAttributes.getInt(a.f.PlaybackControlView_show_timeout, this.mGv);
                i2 = obtainStyledAttributes.getResourceId(a.f.PlaybackControlView_controller_layout_id, i2);
                this.mGw = b(obtainStyledAttributes, this.mGw);
                this.mGx = obtainStyledAttributes.getBoolean(a.f.PlaybackControlView_show_shuffle_button, this.mGx);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.ldy = new x.a();
        this.ldx = new x.b();
        this.mFH = new StringBuilder();
        this.mFI = new Formatter(this.mFH, Locale.getDefault());
        this.mFT = new long[0];
        this.mFU = new boolean[0];
        this.mGz = new long[0];
        this.mGA = new boolean[0];
        this.mFX = new a();
        this.mGo = new com.google.android.exoplayer2.d();
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        this.efZ = (TextView) findViewById(a.c.exo_duration);
        this.efX = (TextView) findViewById(a.c.exo_position);
        this.mGg = (com.google.android.exoplayer2.ui.c) findViewById(a.c.exo_progress);
        if (this.mGg != null) {
            this.mGg.a(this.mFX);
        }
        this.mGa = findViewById(a.c.exo_play);
        if (this.mGa != null) {
            this.mGa.setOnClickListener(this.mFX);
        }
        this.mGb = findViewById(a.c.exo_pause);
        if (this.mGb != null) {
            this.mGb.setOnClickListener(this.mFX);
        }
        this.mFY = findViewById(a.c.exo_prev);
        if (this.mFY != null) {
            this.mFY.setOnClickListener(this.mFX);
        }
        this.mFZ = findViewById(a.c.exo_next);
        if (this.mFZ != null) {
            this.mFZ.setOnClickListener(this.mFX);
        }
        this.mGd = findViewById(a.c.exo_rew);
        if (this.mGd != null) {
            this.mGd.setOnClickListener(this.mFX);
        }
        this.mGc = findViewById(a.c.exo_ffwd);
        if (this.mGc != null) {
            this.mGc.setOnClickListener(this.mFX);
        }
        this.mGe = (ImageView) findViewById(a.c.exo_repeat_toggle);
        if (this.mGe != null) {
            this.mGe.setOnClickListener(this.mFX);
        }
        this.mGf = findViewById(a.c.exo_shuffle);
        if (this.mGf != null) {
            this.mGf.setOnClickListener(this.mFX);
        }
        Resources resources = context.getResources();
        this.mGh = resources.getDrawable(a.b.exo_controls_repeat_off);
        this.mGi = resources.getDrawable(a.b.exo_controls_repeat_one);
        this.mGj = resources.getDrawable(a.b.exo_controls_repeat_all);
        this.mGk = resources.getString(a.e.exo_controls_repeat_off_description);
        this.mGl = resources.getString(a.e.exo_controls_repeat_one_description);
        this.mGm = resources.getString(a.e.exo_controls_repeat_all_description);
    }

    private static int b(TypedArray typedArray, int i) {
        return typedArray.getInt(a.f.PlaybackControlView_repeat_toggle_modes, i);
    }

    public r getPlayer() {
        return this.mGn;
    }

    public void setPlayer(r rVar) {
        if (this.mGn != rVar) {
            if (this.mGn != null) {
                this.mGn.b(this.mFX);
            }
            this.mGn = rVar;
            if (rVar != null) {
                rVar.a(this.mFX);
            }
            updateAll();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.mGr = z;
        dzi();
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.mGz = new long[0];
            this.mGA = new boolean[0];
        } else {
            com.google.android.exoplayer2.util.a.checkArgument(jArr.length == zArr.length);
            this.mGz = jArr;
            this.mGA = zArr;
        }
        ahH();
    }

    public void setVisibilityListener(d dVar) {
        this.mGp = dVar;
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.c cVar) {
        if (cVar == null) {
            cVar = new com.google.android.exoplayer2.d();
        }
        this.mGo = cVar;
    }

    public void setRewindIncrementMs(int i) {
        this.mGt = i;
        dzf();
    }

    public void setFastForwardIncrementMs(int i) {
        this.mGu = i;
        dzf();
    }

    public int getShowTimeoutMs() {
        return this.mGv;
    }

    public void setShowTimeoutMs(int i) {
        this.mGv = i;
    }

    public int getRepeatToggleModes() {
        return this.mGw;
    }

    public void setRepeatToggleModes(int i) {
        this.mGw = i;
        if (this.mGn != null) {
            int repeatMode = this.mGn.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.mGo.a(this.mGn, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.mGo.a(this.mGn, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.mGo.a(this.mGn, 2);
            }
        }
    }

    public boolean getShowShuffleButton() {
        return this.mGx;
    }

    public void setShowShuffleButton(boolean z) {
        this.mGx = z;
        dzh();
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            if (this.mGp != null) {
                this.mGp.LU(getVisibility());
            }
            updateAll();
            dzj();
        }
        dzd();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            if (this.mGp != null) {
                this.mGp.LU(getVisibility());
            }
            removeCallbacks(this.mGB);
            removeCallbacks(this.mGC);
            this.mGy = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzd() {
        removeCallbacks(this.mGC);
        if (this.mGv > 0) {
            this.mGy = SystemClock.uptimeMillis() + this.mGv;
            if (this.mGq) {
                postDelayed(this.mGC, this.mGv);
                return;
            }
            return;
        }
        this.mGy = -9223372036854775807L;
    }

    private void updateAll() {
        dze();
        dzf();
        dzg();
        dzh();
        ahH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dze() {
        boolean z;
        boolean z2 = true;
        if (isVisible() && this.mGq) {
            boolean z3 = this.mGn != null && this.mGn.dtr();
            if (this.mGa != null) {
                boolean z4 = false | (z3 && this.mGa.isFocused());
                this.mGa.setVisibility(z3 ? 8 : 0);
                z = z4;
            } else {
                z = false;
            }
            if (this.mGb != null) {
                if (z3 || !this.mGb.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                this.mGb.setVisibility(z3 ? 0 : 8);
            }
            if (z) {
                dzj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzf() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (isVisible() && this.mGq) {
            x dtC = this.mGn != null ? this.mGn.dtC() : null;
            if (!((dtC == null || dtC.isEmpty()) ? false : true) || this.mGn.dtz()) {
                z = false;
                z2 = false;
                z3 = false;
            } else {
                dtC.a(this.mGn.dtv(), this.ldx);
                z3 = this.ldx.mck;
                z2 = (!z3 && this.ldx.isDynamic && this.mGn.dtx() == -1) ? false : true;
                z = this.ldx.isDynamic || this.mGn.dtw() != -1;
            }
            a(z2, this.mFY);
            a(z, this.mFZ);
            a(this.mGu > 0 && z3, this.mGc);
            if (this.mGt <= 0 || !z3) {
                z4 = false;
            }
            a(z4, this.mGd);
            if (this.mGg != null) {
                this.mGg.setEnabled(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzg() {
        if (isVisible() && this.mGq && this.mGe != null) {
            if (this.mGw == 0) {
                this.mGe.setVisibility(8);
            } else if (this.mGn == null) {
                a(false, (View) this.mGe);
            } else {
                a(true, (View) this.mGe);
                switch (this.mGn.getRepeatMode()) {
                    case 0:
                        this.mGe.setImageDrawable(this.mGh);
                        this.mGe.setContentDescription(this.mGk);
                        break;
                    case 1:
                        this.mGe.setImageDrawable(this.mGi);
                        this.mGe.setContentDescription(this.mGl);
                        break;
                    case 2:
                        this.mGe.setImageDrawable(this.mGj);
                        this.mGe.setContentDescription(this.mGm);
                        break;
                }
                this.mGe.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzh() {
        if (isVisible() && this.mGq && this.mGf != null) {
            if (!this.mGx) {
                this.mGf.setVisibility(8);
            } else if (this.mGn == null) {
                a(false, this.mGf);
            } else {
                this.mGf.setAlpha(this.mGn.dts() ? 1.0f : 0.3f);
                this.mGf.setEnabled(true);
                this.mGf.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzi() {
        if (this.mGn != null) {
            this.mGs = this.mGr && a(this.mGn.dtC(), this.ldx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahH() {
        long j;
        long bufferedPosition;
        if (isVisible() && this.mGq) {
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            if (this.mGn != null) {
                long j5 = 0;
                long j6 = 0;
                int i = 0;
                x dtC = this.mGn.dtC();
                if (!dtC.isEmpty()) {
                    int dtv = this.mGn.dtv();
                    int i2 = this.mGs ? 0 : dtv;
                    int dtZ = this.mGs ? dtC.dtZ() - 1 : dtv;
                    int i3 = i2;
                    while (true) {
                        if (i3 > dtZ) {
                            break;
                        }
                        if (i3 == dtv) {
                            j5 = j6;
                        }
                        dtC.a(i3, this.ldx);
                        if (this.ldx.mbx == -9223372036854775807L) {
                            com.google.android.exoplayer2.util.a.checkState(!this.mGs);
                        } else {
                            for (int i4 = this.ldx.mcl; i4 <= this.ldx.mcm; i4++) {
                                dtC.a(i4, this.ldy);
                                int due = this.ldy.due();
                                for (int i5 = 0; i5 < due; i5++) {
                                    long Jf = this.ldy.Jf(i5);
                                    if (Jf == Long.MIN_VALUE) {
                                        if (this.ldy.mbx != -9223372036854775807L) {
                                            Jf = this.ldy.mbx;
                                        }
                                    }
                                    long dud = this.ldy.dud() + Jf;
                                    if (dud >= 0 && dud <= this.ldx.mbx) {
                                        if (i == this.mFT.length) {
                                            int length = this.mFT.length == 0 ? 1 : this.mFT.length * 2;
                                            this.mFT = Arrays.copyOf(this.mFT, length);
                                            this.mFU = Arrays.copyOf(this.mFU, length);
                                        }
                                        this.mFT[i] = com.google.android.exoplayer2.b.fo(dud + j6);
                                        this.mFU[i] = this.ldy.Jh(i5);
                                        i++;
                                    }
                                }
                            }
                            j6 += this.ldx.mbx;
                            i3++;
                        }
                    }
                }
                long fo = com.google.android.exoplayer2.b.fo(j6);
                long fo2 = com.google.android.exoplayer2.b.fo(j5);
                if (this.mGn.dtz()) {
                    bufferedPosition = fo2 + this.mGn.dtA();
                    j2 = bufferedPosition;
                } else {
                    j2 = this.mGn.getCurrentPosition() + fo2;
                    bufferedPosition = fo2 + this.mGn.getBufferedPosition();
                }
                if (this.mGg != null) {
                    int length2 = this.mGz.length;
                    int i6 = i + length2;
                    if (i6 > this.mFT.length) {
                        this.mFT = Arrays.copyOf(this.mFT, i6);
                        this.mFU = Arrays.copyOf(this.mFU, i6);
                    }
                    System.arraycopy(this.mGz, 0, this.mFT, i, length2);
                    System.arraycopy(this.mGA, 0, this.mFU, i, length2);
                    this.mGg.setAdGroupTimesMs(this.mFT, this.mFU, i6);
                }
                j3 = bufferedPosition;
                j4 = fo;
            }
            if (this.efZ != null) {
                this.efZ.setText(v.a(this.mFH, this.mFI, j4));
            }
            if (this.efX != null && !this.mFP) {
                this.efX.setText(v.a(this.mFH, this.mFI, j2));
            }
            if (this.mGg != null) {
                this.mGg.setPosition(j2);
                this.mGg.setBufferedPosition(j3);
                this.mGg.setDuration(j4);
            }
            removeCallbacks(this.mGB);
            int dan = this.mGn == null ? 1 : this.mGn.dan();
            if (dan != 1 && dan != 4) {
                if (this.mGn.dtr() && dan == 3) {
                    float f = this.mGn.dtt().speed;
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
                postDelayed(this.mGB, j);
            }
        }
    }

    private void dzj() {
        boolean z = this.mGn != null && this.mGn.dtr();
        if (!z && this.mGa != null) {
            this.mGa.requestFocus();
        } else if (z && this.mGb != null) {
            this.mGb.requestFocus();
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
        x dtC = this.mGn.dtC();
        if (!dtC.isEmpty()) {
            dtC.a(this.mGn.dtv(), this.ldx);
            int dtx = this.mGn.dtx();
            if (dtx != -1 && (this.mGn.getCurrentPosition() <= 3000 || (this.ldx.isDynamic && !this.ldx.mck))) {
                A(dtx, -9223372036854775807L);
            } else {
                seekTo(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        x dtC = this.mGn.dtC();
        if (!dtC.isEmpty()) {
            int dtv = this.mGn.dtv();
            int dtw = this.mGn.dtw();
            if (dtw != -1) {
                A(dtw, -9223372036854775807L);
            } else if (dtC.a(dtv, this.ldx, false).isDynamic) {
                A(dtv, -9223372036854775807L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.mGt > 0) {
            seekTo(Math.max(this.mGn.getCurrentPosition() - this.mGt, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.mGu > 0) {
            long duration = this.mGn.getDuration();
            long currentPosition = this.mGn.getCurrentPosition() + this.mGu;
            if (duration != -9223372036854775807L) {
                currentPosition = Math.min(currentPosition, duration);
            }
            seekTo(currentPosition);
        }
    }

    private void seekTo(long j) {
        A(this.mGn.dtv(), j);
    }

    private void A(int i, long j) {
        if (!this.mGo.a(this.mGn, i, j)) {
            ahH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(long j) {
        int dtv;
        x dtC = this.mGn.dtC();
        if (this.mGs && !dtC.isEmpty()) {
            int dtZ = dtC.dtZ();
            dtv = 0;
            while (true) {
                long dub = dtC.a(dtv, this.ldx).dub();
                if (j < dub) {
                    break;
                } else if (dtv == dtZ - 1) {
                    j = dub;
                    break;
                } else {
                    j -= dub;
                    dtv++;
                }
            }
        } else {
            dtv = this.mGn.dtv();
        }
        A(dtv, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mGq = true;
        if (this.mGy != -9223372036854775807L) {
            long uptimeMillis = this.mGy - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.mGC, uptimeMillis);
            }
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mGq = false;
        removeCallbacks(this.mGB);
        removeCallbacks(this.mGC);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean b(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mGn == null || !LT(keyCode)) {
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
                        this.mGo.a(this.mGn, this.mGn.dtr() ? false : true);
                        return true;
                    case 87:
                        next();
                        return true;
                    case 88:
                        previous();
                        return true;
                    case Opcodes.IAND /* 126 */:
                        this.mGo.a(this.mGn, true);
                        return true;
                    case 127:
                        this.mGo.a(this.mGn, false);
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
    private static boolean LT(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    private static boolean a(x xVar, x.b bVar) {
        if (xVar.dtZ() > 100) {
            return false;
        }
        int dtZ = xVar.dtZ();
        for (int i = 0; i < dtZ; i++) {
            if (xVar.a(i, bVar).mbx == -9223372036854775807L) {
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
            PlaybackControlView.this.removeCallbacks(PlaybackControlView.this.mGC);
            PlaybackControlView.this.mFP = true;
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void b(com.google.android.exoplayer2.ui.c cVar, long j) {
            if (PlaybackControlView.this.efX != null) {
                PlaybackControlView.this.efX.setText(v.a(PlaybackControlView.this.mFH, PlaybackControlView.this.mFI, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.c.a
        public void a(com.google.android.exoplayer2.ui.c cVar, long j, boolean z) {
            PlaybackControlView.this.mFP = false;
            if (!z && PlaybackControlView.this.mGn != null) {
                PlaybackControlView.this.gF(j);
            }
            PlaybackControlView.this.dzd();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void A(boolean z, int i) {
            PlaybackControlView.this.dze();
            PlaybackControlView.this.ahH();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void onRepeatModeChanged(int i) {
            PlaybackControlView.this.dzg();
            PlaybackControlView.this.dzf();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void ul(boolean z) {
            PlaybackControlView.this.dzh();
            PlaybackControlView.this.dzf();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void Fa(int i) {
            PlaybackControlView.this.dzf();
            PlaybackControlView.this.ahH();
        }

        @Override // com.google.android.exoplayer2.r.a, com.google.android.exoplayer2.r.b
        public void a(x xVar, Object obj) {
            PlaybackControlView.this.dzf();
            PlaybackControlView.this.dzi();
            PlaybackControlView.this.ahH();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlaybackControlView.this.mGn != null) {
                if (PlaybackControlView.this.mFZ == view) {
                    PlaybackControlView.this.next();
                } else if (PlaybackControlView.this.mFY == view) {
                    PlaybackControlView.this.previous();
                } else if (PlaybackControlView.this.mGc == view) {
                    PlaybackControlView.this.fastForward();
                } else if (PlaybackControlView.this.mGd == view) {
                    PlaybackControlView.this.rewind();
                } else if (PlaybackControlView.this.mGa == view) {
                    PlaybackControlView.this.mGo.a(PlaybackControlView.this.mGn, true);
                } else if (PlaybackControlView.this.mGb == view) {
                    PlaybackControlView.this.mGo.a(PlaybackControlView.this.mGn, false);
                } else if (PlaybackControlView.this.mGe != view) {
                    if (PlaybackControlView.this.mGf == view) {
                        PlaybackControlView.this.mGo.b(PlaybackControlView.this.mGn, PlaybackControlView.this.mGn.dts() ? false : true);
                    }
                } else {
                    PlaybackControlView.this.mGo.a(PlaybackControlView.this.mGn, o.dY(PlaybackControlView.this.mGn.getRepeatMode(), PlaybackControlView.this.mGw));
                }
            }
            PlaybackControlView.this.dzd();
        }
    }
}
