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
    public master.flame.danmaku.danmaku.model.a ncT;
    private List<WeakReference<a>> ncY;
    private b ndb;
    private boolean ndc;
    private boolean ndd;
    public Typeface ncJ = null;
    public int ncE = master.flame.danmaku.danmaku.model.c.MAX;
    public float ncF = 1.0f;
    public int gkE = 0;
    public boolean ncK = true;
    public boolean ncL = true;
    public boolean ncM = true;
    public boolean ncN = true;
    public boolean ncO = true;
    List<Integer> mZS = new ArrayList();
    public int ncP = -1;
    public float ncQ = 1.0f;
    public int ncR = 15;
    public BorderType ncS = BorderType.SHADOW;
    public int ncU = 3;
    List<Integer> ncV = new ArrayList();
    List<Integer> ncW = new ArrayList();
    List<String> ncX = new ArrayList();
    private boolean ncZ = false;
    private boolean nbJ = false;
    private boolean nda = false;
    private final master.flame.danmaku.danmaku.model.b nde = new master.flame.danmaku.danmaku.model.android.a();
    public final j ndf = new j();
    public final master.flame.danmaku.a.b ndg = new master.flame.danmaku.a.b();
    public final c ndh = c.dFT();

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

    public static DanmakuContext dFM() {
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

    public master.flame.danmaku.danmaku.model.b dFN() {
        return this.nde;
    }

    private <T> void a(String str, T t, boolean z) {
        this.ndg.aN(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.nde.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext wB(boolean z) {
        if (this.nbJ != z) {
            this.nbJ = z;
            this.ndf.dFt();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dFO() {
        return this.nbJ;
    }

    public boolean dFP() {
        return this.nda;
    }

    public DanmakuContext D(Map<Integer, Boolean> map) {
        this.ndd = map != null;
        if (map == null) {
            this.ndg.aP("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.ndf.dFt();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dFQ() {
        return this.ndc;
    }

    public boolean dFR() {
        return this.ndd;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.ndb = bVar;
        if (this.ndb != null) {
            this.ndb.a(aVar);
            this.nde.a(this.ndb);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.ncY == null) {
            this.ncY = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.ncY) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.ncY.add(new WeakReference<>(aVar));
    }

    public void dFS() {
        if (this.ncY != null) {
            this.ncY.clear();
            this.ncY = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.ncY != null) {
            for (WeakReference<a> weakReference : this.ncY) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
