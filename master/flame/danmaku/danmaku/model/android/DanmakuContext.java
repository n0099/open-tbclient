package master.flame.danmaku.danmaku.model.android;

import android.graphics.Typeface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.b;
import master.flame.danmaku.danmaku.model.j;
/* loaded from: classes6.dex */
public class DanmakuContext {
    public master.flame.danmaku.danmaku.model.a pXF;
    private List<WeakReference<a>> pXK;
    private b pXN;
    private boolean pXO;
    private boolean pXP;
    public Typeface pXv = null;
    public int pXq = master.flame.danmaku.danmaku.model.c.MAX;
    public float pXr = 1.0f;
    public int margin = 0;
    public boolean pXw = true;
    public boolean pXx = true;
    public boolean pXy = true;
    public boolean pXz = true;
    public boolean pXA = true;
    List<Integer> pUH = new ArrayList();
    public int pXB = -1;
    public float pXC = 1.0f;
    public int pXD = 15;
    public BorderType pXE = BorderType.SHADOW;
    public int pXG = 3;
    List<Integer> pXH = new ArrayList();
    List<Integer> pXI = new ArrayList();
    List<String> pXJ = new ArrayList();
    private boolean pXL = false;
    private boolean pWw = false;
    private boolean pXM = false;
    private final master.flame.danmaku.danmaku.model.b pXQ = new master.flame.danmaku.danmaku.model.android.a();
    public final j pXR = new j();
    public final master.flame.danmaku.a.b pXS = new master.flame.danmaku.a.b();
    public final c pXT = c.eDS();

    /* loaded from: classes6.dex */
    public enum BorderType {
        NONE,
        SHADOW,
        STROKEN
    }

    /* loaded from: classes6.dex */
    public interface a {
        boolean a(DanmakuContext danmakuContext, DanmakuConfigTag danmakuConfigTag, Object... objArr);
    }

    public static DanmakuContext eDL() {
        return new DanmakuContext();
    }

    /* loaded from: classes6.dex */
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

    public master.flame.danmaku.danmaku.model.b eDM() {
        return this.pXQ;
    }

    private <T> void a(String str, T t, boolean z) {
        this.pXS.bq(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.pXQ.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext Bd(boolean z) {
        if (this.pWw != z) {
            this.pWw = z;
            this.pXR.eDs();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean eDN() {
        return this.pWw;
    }

    public boolean eDO() {
        return this.pXM;
    }

    public DanmakuContext O(Map<Integer, Boolean> map) {
        this.pXP = map != null;
        if (map == null) {
            this.pXS.bs("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.pXR.eDs();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean eDP() {
        return this.pXO;
    }

    public boolean eDQ() {
        return this.pXP;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.pXN = bVar;
        if (this.pXN != null) {
            this.pXN.a(aVar);
            this.pXQ.a(this.pXN);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.pXK == null) {
            this.pXK = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.pXK) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.pXK.add(new WeakReference<>(aVar));
    }

    public void eDR() {
        if (this.pXK != null) {
            this.pXK.clear();
            this.pXK = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.pXK != null) {
            for (WeakReference<a> weakReference : this.pXK) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
