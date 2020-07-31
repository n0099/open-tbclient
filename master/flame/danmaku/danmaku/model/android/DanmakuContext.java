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
    public master.flame.danmaku.danmaku.model.a odE;
    private List<WeakReference<a>> odJ;
    private b odM;
    private boolean odN;
    private boolean odO;
    public Typeface odu = null;
    public int odp = master.flame.danmaku.danmaku.model.c.MAX;
    public float odq = 1.0f;
    public int gRX = 0;
    public boolean odv = true;
    public boolean odw = true;
    public boolean odx = true;
    public boolean ody = true;
    public boolean odz = true;
    List<Integer> oaD = new ArrayList();
    public int odA = -1;
    public float odB = 1.0f;
    public int odC = 15;
    public BorderType odD = BorderType.SHADOW;
    public int odF = 3;
    List<Integer> odG = new ArrayList();
    List<Integer> odH = new ArrayList();
    List<String> odI = new ArrayList();
    private boolean odK = false;
    private boolean ocu = false;
    private boolean odL = false;
    private final master.flame.danmaku.danmaku.model.b odP = new master.flame.danmaku.danmaku.model.android.a();
    public final j odQ = new j();
    public final master.flame.danmaku.a.b odR = new master.flame.danmaku.a.b();
    public final c odS = c.dWi();

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

    public static DanmakuContext dWb() {
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

    public master.flame.danmaku.danmaku.model.b dWc() {
        return this.odP;
    }

    private <T> void a(String str, T t, boolean z) {
        this.odR.aZ(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.odP.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext yb(boolean z) {
        if (this.ocu != z) {
            this.ocu = z;
            this.odQ.dVI();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dWd() {
        return this.ocu;
    }

    public boolean dWe() {
        return this.odL;
    }

    public DanmakuContext E(Map<Integer, Boolean> map) {
        this.odO = map != null;
        if (map == null) {
            this.odR.bb("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.odQ.dVI();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dWf() {
        return this.odN;
    }

    public boolean dWg() {
        return this.odO;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.odM = bVar;
        if (this.odM != null) {
            this.odM.a(aVar);
            this.odP.a(this.odM);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.odJ == null) {
            this.odJ = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.odJ) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.odJ.add(new WeakReference<>(aVar));
    }

    public void dWh() {
        if (this.odJ != null) {
            this.odJ.clear();
            this.odJ = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.odJ != null) {
            for (WeakReference<a> weakReference : this.odJ) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
