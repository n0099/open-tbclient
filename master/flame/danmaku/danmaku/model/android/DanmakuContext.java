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
    public master.flame.danmaku.danmaku.model.a nHp;
    private List<WeakReference<a>> nHu;
    private b nHx;
    private boolean nHy;
    private boolean nHz;
    public Typeface nHf = null;
    public int nHa = master.flame.danmaku.danmaku.model.c.MAX;
    public float nHb = 1.0f;
    public int fEY = 0;
    public boolean nHg = true;
    public boolean nHh = true;
    public boolean nHi = true;
    public boolean nHj = true;
    public boolean nHk = true;
    List<Integer> nEr = new ArrayList();
    public int nHl = -1;
    public float nHm = 1.0f;
    public int nHn = 15;
    public BorderType nHo = BorderType.SHADOW;
    public int nHq = 3;
    List<Integer> nHr = new ArrayList();
    List<Integer> nHs = new ArrayList();
    List<String> nHt = new ArrayList();
    private boolean nHv = false;
    private boolean nGg = false;
    private boolean nHw = false;
    private final master.flame.danmaku.danmaku.model.b nHA = new master.flame.danmaku.danmaku.model.android.a();
    public final j nHB = new j();
    public final master.flame.danmaku.a.b nHC = new master.flame.danmaku.a.b();
    public final c nHD = c.dMw();

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

    public static DanmakuContext dMp() {
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

    public master.flame.danmaku.danmaku.model.b dMq() {
        return this.nHA;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nHC.aR(str, z).setData(t);
    }

    public DanmakuContext j(int i, float... fArr) {
        this.nHA.i(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext wO(boolean z) {
        if (this.nGg != z) {
            this.nGg = z;
            this.nHB.dLW();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dMr() {
        return this.nGg;
    }

    public boolean dMs() {
        return this.nHw;
    }

    public DanmakuContext F(Map<Integer, Boolean> map) {
        this.nHz = map != null;
        if (map == null) {
            this.nHC.aT("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nHB.dLW();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dMt() {
        return this.nHy;
    }

    public boolean dMu() {
        return this.nHz;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nHx = bVar;
        if (this.nHx != null) {
            this.nHx.a(aVar);
            this.nHA.a(this.nHx);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nHu == null) {
            this.nHu = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nHu) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nHu.add(new WeakReference<>(aVar));
    }

    public void dMv() {
        if (this.nHu != null) {
            this.nHu.clear();
            this.nHu = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nHu != null) {
            for (WeakReference<a> weakReference : this.nHu) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
