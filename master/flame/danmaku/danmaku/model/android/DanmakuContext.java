package master.flame.danmaku.danmaku.model.android;

import android.graphics.Typeface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.b;
import master.flame.danmaku.danmaku.model.j;
/* loaded from: classes5.dex */
public class DanmakuContext {
    public master.flame.danmaku.danmaku.model.a nUR;
    private List<WeakReference<a>> nUW;
    private b nUZ;
    private boolean nVa;
    private boolean nVb;
    public Typeface nUH = null;
    public int nUC = master.flame.danmaku.danmaku.model.c.MAX;
    public float nUD = 1.0f;
    public int gMr = 0;
    public boolean nUI = true;
    public boolean nUJ = true;
    public boolean nUK = true;
    public boolean nUL = true;
    public boolean nUM = true;
    List<Integer> nRR = new ArrayList();
    public int nUN = -1;
    public float nUO = 1.0f;
    public int nUP = 15;
    public BorderType nUQ = BorderType.SHADOW;
    public int nUS = 3;
    List<Integer> nUT = new ArrayList();
    List<Integer> nUU = new ArrayList();
    List<String> nUV = new ArrayList();
    private boolean nUX = false;
    private boolean nTH = false;
    private boolean nUY = false;
    private final master.flame.danmaku.danmaku.model.b nVc = new master.flame.danmaku.danmaku.model.android.a();
    public final j nVd = new j();
    public final master.flame.danmaku.a.b nVe = new master.flame.danmaku.a.b();
    public final c nVf = c.dSI();

    /* loaded from: classes5.dex */
    public enum BorderType {
        NONE,
        SHADOW,
        STROKEN
    }

    /* loaded from: classes5.dex */
    public interface a {
        boolean a(DanmakuContext danmakuContext, DanmakuConfigTag danmakuConfigTag, Object... objArr);
    }

    public static DanmakuContext dSB() {
        return new DanmakuContext();
    }

    /* loaded from: classes5.dex */
    public enum DanmakuConfigTag {
        FT_DANMAKU_VISIBILITY,
        FB_DANMAKU_VISIBILITY,
        L2R_DANMAKU_VISIBILITY,
        R2L_DANMAKU_VISIBILIY,
        SPECIAL_DANMAKU_VISIBILITY,
        TYPEFACE,
        TRANSPARENCY,
        SCALE_TEXTSIZE,
        MAXIMUM_NUMS_IN_SCREEN,
        DANMAKU_STYLE,
        DANMAKU_BOLD,
        COLOR_VALUE_WHITE_LIST,
        USER_ID_BLACK_LIST,
        USER_HASH_BLACK_LIST,
        SCROLL_SPEED_FACTOR,
        BLOCK_GUEST_DANMAKU,
        DUPLICATE_MERGING_ENABLED,
        MAXIMUN_LINES,
        OVERLAPPING_ENABLE,
        ALIGN_BOTTOM,
        DANMAKU_MARGIN;

        public boolean isVisibilityRelatedTag() {
            return equals(FT_DANMAKU_VISIBILITY) || equals(FB_DANMAKU_VISIBILITY) || equals(L2R_DANMAKU_VISIBILITY) || equals(R2L_DANMAKU_VISIBILIY) || equals(SPECIAL_DANMAKU_VISIBILITY) || equals(COLOR_VALUE_WHITE_LIST) || equals(USER_ID_BLACK_LIST);
        }
    }

    public master.flame.danmaku.danmaku.model.b dSC() {
        return this.nVc;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nVe.bc(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.nVc.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext xw(boolean z) {
        if (this.nTH != z) {
            this.nTH = z;
            this.nVd.dSi();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dSD() {
        return this.nTH;
    }

    public boolean dSE() {
        return this.nUY;
    }

    public DanmakuContext E(Map<Integer, Boolean> map) {
        this.nVb = map != null;
        if (map == null) {
            this.nVe.be("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nVd.dSi();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dSF() {
        return this.nVa;
    }

    public boolean dSG() {
        return this.nVb;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nUZ = bVar;
        if (this.nUZ != null) {
            this.nUZ.a(aVar);
            this.nVc.a(this.nUZ);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nUW == null) {
            this.nUW = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nUW) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nUW.add(new WeakReference<>(aVar));
    }

    public void dSH() {
        if (this.nUW != null) {
            this.nUW.clear();
            this.nUW = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nUW != null) {
            for (WeakReference<a> weakReference : this.nUW) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
