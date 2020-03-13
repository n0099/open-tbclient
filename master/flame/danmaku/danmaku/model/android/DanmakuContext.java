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
    public master.flame.danmaku.danmaku.model.a nHA;
    private List<WeakReference<a>> nHF;
    private b nHI;
    private boolean nHJ;
    private boolean nHK;
    public Typeface nHq = null;
    public int nHl = master.flame.danmaku.danmaku.model.c.MAX;
    public float nHm = 1.0f;
    public int fFl = 0;
    public boolean nHr = true;
    public boolean nHs = true;
    public boolean nHt = true;
    public boolean nHu = true;
    public boolean nHv = true;
    List<Integer> nEC = new ArrayList();
    public int nHw = -1;
    public float nHx = 1.0f;
    public int nHy = 15;
    public BorderType nHz = BorderType.SHADOW;
    public int nHB = 3;
    List<Integer> nHC = new ArrayList();
    List<Integer> nHD = new ArrayList();
    List<String> nHE = new ArrayList();
    private boolean nHG = false;
    private boolean nGr = false;
    private boolean nHH = false;
    private final master.flame.danmaku.danmaku.model.b nHL = new master.flame.danmaku.danmaku.model.android.a();
    public final j nHM = new j();
    public final master.flame.danmaku.a.b nHN = new master.flame.danmaku.a.b();
    public final c nHO = c.dMx();

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

    public static DanmakuContext dMq() {
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

    public master.flame.danmaku.danmaku.model.b dMr() {
        return this.nHL;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nHN.aR(str, z).setData(t);
    }

    public DanmakuContext j(int i, float... fArr) {
        this.nHL.i(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext wO(boolean z) {
        if (this.nGr != z) {
            this.nGr = z;
            this.nHM.dLX();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dMs() {
        return this.nGr;
    }

    public boolean dMt() {
        return this.nHH;
    }

    public DanmakuContext F(Map<Integer, Boolean> map) {
        this.nHK = map != null;
        if (map == null) {
            this.nHN.aT("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nHM.dLX();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dMu() {
        return this.nHJ;
    }

    public boolean dMv() {
        return this.nHK;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nHI = bVar;
        if (this.nHI != null) {
            this.nHI.a(aVar);
            this.nHL.a(this.nHI);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nHF == null) {
            this.nHF = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nHF) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nHF.add(new WeakReference<>(aVar));
    }

    public void dMw() {
        if (this.nHF != null) {
            this.nHF.clear();
            this.nHF = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nHF != null) {
            for (WeakReference<a> weakReference : this.nHF) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
