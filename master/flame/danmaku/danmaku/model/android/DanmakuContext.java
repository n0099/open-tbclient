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
    public master.flame.danmaku.danmaku.model.a pZi;
    private List<WeakReference<a>> pZn;
    private b pZq;
    private boolean pZr;
    private boolean pZs;
    public Typeface pYY = null;
    public int pYT = master.flame.danmaku.danmaku.model.c.MAX;
    public float pYU = 1.0f;
    public int margin = 0;
    public boolean pYZ = true;
    public boolean pZa = true;
    public boolean pZb = true;
    public boolean pZc = true;
    public boolean pZd = true;
    List<Integer> pWk = new ArrayList();
    public int pZe = -1;
    public float pZf = 1.0f;
    public int pZg = 15;
    public BorderType pZh = BorderType.SHADOW;
    public int pZj = 3;
    List<Integer> pZk = new ArrayList();
    List<Integer> pZl = new ArrayList();
    List<String> pZm = new ArrayList();
    private boolean pZo = false;
    private boolean pXZ = false;
    private boolean pZp = false;
    private final master.flame.danmaku.danmaku.model.b pZt = new master.flame.danmaku.danmaku.model.android.a();
    public final j pZu = new j();
    public final master.flame.danmaku.a.b pZv = new master.flame.danmaku.a.b();
    public final c pZw = c.eDT();

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

    public static DanmakuContext eDM() {
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

    public master.flame.danmaku.danmaku.model.b eDN() {
        return this.pZt;
    }

    private <T> void a(String str, T t, boolean z) {
        this.pZv.bq(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.pZt.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext Bk(boolean z) {
        if (this.pXZ != z) {
            this.pXZ = z;
            this.pZu.eDt();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean eDO() {
        return this.pXZ;
    }

    public boolean eDP() {
        return this.pZp;
    }

    public DanmakuContext O(Map<Integer, Boolean> map) {
        this.pZs = map != null;
        if (map == null) {
            this.pZv.bs("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.pZu.eDt();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean eDQ() {
        return this.pZr;
    }

    public boolean eDR() {
        return this.pZs;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.pZq = bVar;
        if (this.pZq != null) {
            this.pZq.a(aVar);
            this.pZt.a(this.pZq);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.pZn == null) {
            this.pZn = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.pZn) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.pZn.add(new WeakReference<>(aVar));
    }

    public void eDS() {
        if (this.pZn != null) {
            this.pZn.clear();
            this.pZn = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.pZn != null) {
            for (WeakReference<a> weakReference : this.pZn) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
