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
    public master.flame.danmaku.danmaku.model.a ncQ;
    private List<WeakReference<a>> ncV;
    private b ncY;
    private boolean ncZ;
    private boolean nda;
    public Typeface ncG = null;
    public int ncB = master.flame.danmaku.danmaku.model.c.MAX;
    public float ncC = 1.0f;
    public int gky = 0;
    public boolean ncH = true;
    public boolean ncI = true;
    public boolean ncJ = true;
    public boolean ncK = true;
    public boolean ncL = true;
    List<Integer> mZP = new ArrayList();
    public int ncM = -1;
    public float ncN = 1.0f;
    public int ncO = 15;
    public BorderType ncP = BorderType.SHADOW;
    public int ncR = 3;
    List<Integer> ncS = new ArrayList();
    List<Integer> ncT = new ArrayList();
    List<String> ncU = new ArrayList();
    private boolean ncW = false;
    private boolean nbG = false;
    private boolean ncX = false;
    private final master.flame.danmaku.danmaku.model.b ndb = new master.flame.danmaku.danmaku.model.android.a();
    public final j ndc = new j();
    public final master.flame.danmaku.a.b ndd = new master.flame.danmaku.a.b();
    public final c nde = c.dFX();

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

    public static DanmakuContext dFQ() {
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

    public master.flame.danmaku.danmaku.model.b dFR() {
        return this.ndb;
    }

    private <T> void a(String str, T t, boolean z) {
        this.ndd.aN(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.ndb.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext wB(boolean z) {
        if (this.nbG != z) {
            this.nbG = z;
            this.ndc.dFx();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dFS() {
        return this.nbG;
    }

    public boolean dFT() {
        return this.ncX;
    }

    public DanmakuContext D(Map<Integer, Boolean> map) {
        this.nda = map != null;
        if (map == null) {
            this.ndd.aP("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.ndc.dFx();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dFU() {
        return this.ncZ;
    }

    public boolean dFV() {
        return this.nda;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.ncY = bVar;
        if (this.ncY != null) {
            this.ncY.a(aVar);
            this.ndb.a(this.ncY);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.ncV == null) {
            this.ncV = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.ncV) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.ncV.add(new WeakReference<>(aVar));
    }

    public void dFW() {
        if (this.ncV != null) {
            this.ncV.clear();
            this.ncV = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.ncV != null) {
            for (WeakReference<a> weakReference : this.ncV) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
