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
    public master.flame.danmaku.danmaku.model.a oWP;
    private List<WeakReference<a>> oWU;
    private b oWX;
    private boolean oWY;
    private boolean oWZ;
    public Typeface oWF = null;
    public int oWA = master.flame.danmaku.danmaku.model.c.MAX;
    public float oWB = 1.0f;
    public int margin = 0;
    public boolean oWG = true;
    public boolean oWH = true;
    public boolean oWI = true;
    public boolean oWJ = true;
    public boolean oWK = true;
    List<Integer> oTR = new ArrayList();
    public int oWL = -1;
    public float oWM = 1.0f;
    public int oWN = 15;
    public BorderType oWO = BorderType.SHADOW;
    public int oWQ = 3;
    List<Integer> oWR = new ArrayList();
    List<Integer> oWS = new ArrayList();
    List<String> oWT = new ArrayList();
    private boolean oWV = false;
    private boolean oVG = false;
    private boolean oWW = false;
    private final master.flame.danmaku.danmaku.model.b oXa = new master.flame.danmaku.danmaku.model.android.a();
    public final j oXb = new j();
    public final master.flame.danmaku.a.b oXc = new master.flame.danmaku.a.b();
    public final c oXd = c.eqf();

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

    public static DanmakuContext epY() {
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

    public master.flame.danmaku.danmaku.model.b epZ() {
        return this.oXa;
    }

    private <T> void a(String str, T t, boolean z) {
        this.oXc.bi(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.oXa.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext zK(boolean z) {
        if (this.oVG != z) {
            this.oVG = z;
            this.oXb.epF();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean eqa() {
        return this.oVG;
    }

    public boolean eqb() {
        return this.oWW;
    }

    public DanmakuContext O(Map<Integer, Boolean> map) {
        this.oWZ = map != null;
        if (map == null) {
            this.oXc.bk("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.oXb.epF();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean eqc() {
        return this.oWY;
    }

    public boolean eqd() {
        return this.oWZ;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.oWX = bVar;
        if (this.oWX != null) {
            this.oWX.a(aVar);
            this.oXa.a(this.oWX);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.oWU == null) {
            this.oWU = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.oWU) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.oWU.add(new WeakReference<>(aVar));
    }

    public void eqe() {
        if (this.oWU != null) {
            this.oWU.clear();
            this.oWU = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.oWU != null) {
            for (WeakReference<a> weakReference : this.oWU) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
