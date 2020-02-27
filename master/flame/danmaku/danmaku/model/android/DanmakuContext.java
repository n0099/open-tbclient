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
    public master.flame.danmaku.danmaku.model.a nHn;
    private List<WeakReference<a>> nHs;
    private b nHv;
    private boolean nHw;
    private boolean nHx;
    public Typeface nHd = null;
    public int nGY = master.flame.danmaku.danmaku.model.c.MAX;
    public float nGZ = 1.0f;
    public int fEW = 0;
    public boolean nHe = true;
    public boolean nHf = true;
    public boolean nHg = true;
    public boolean nHh = true;
    public boolean nHi = true;
    List<Integer> nEp = new ArrayList();
    public int nHj = -1;
    public float nHk = 1.0f;
    public int nHl = 15;
    public BorderType nHm = BorderType.SHADOW;
    public int nHo = 3;
    List<Integer> nHp = new ArrayList();
    List<Integer> nHq = new ArrayList();
    List<String> nHr = new ArrayList();
    private boolean nHt = false;
    private boolean nGe = false;
    private boolean nHu = false;
    private final master.flame.danmaku.danmaku.model.b nHy = new master.flame.danmaku.danmaku.model.android.a();
    public final j nHz = new j();
    public final master.flame.danmaku.a.b nHA = new master.flame.danmaku.a.b();
    public final c nHB = c.dMu();

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

    public static DanmakuContext dMn() {
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

    public master.flame.danmaku.danmaku.model.b dMo() {
        return this.nHy;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nHA.aR(str, z).setData(t);
    }

    public DanmakuContext j(int i, float... fArr) {
        this.nHy.i(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext wO(boolean z) {
        if (this.nGe != z) {
            this.nGe = z;
            this.nHz.dLU();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dMp() {
        return this.nGe;
    }

    public boolean dMq() {
        return this.nHu;
    }

    public DanmakuContext F(Map<Integer, Boolean> map) {
        this.nHx = map != null;
        if (map == null) {
            this.nHA.aT("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nHz.dLU();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dMr() {
        return this.nHw;
    }

    public boolean dMs() {
        return this.nHx;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nHv = bVar;
        if (this.nHv != null) {
            this.nHv.a(aVar);
            this.nHy.a(this.nHv);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nHs == null) {
            this.nHs = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nHs) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nHs.add(new WeakReference<>(aVar));
    }

    public void dMt() {
        if (this.nHs != null) {
            this.nHs.clear();
            this.nHs = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nHs != null) {
            for (WeakReference<a> weakReference : this.nHs) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
