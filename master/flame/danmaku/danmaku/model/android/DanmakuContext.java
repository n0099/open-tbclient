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
    public master.flame.danmaku.danmaku.model.a odG;
    private List<WeakReference<a>> odL;
    private b odO;
    private boolean odP;
    private boolean odQ;
    public Typeface odw = null;
    public int odr = master.flame.danmaku.danmaku.model.c.MAX;
    public float ods = 1.0f;
    public int gRX = 0;
    public boolean odx = true;
    public boolean ody = true;
    public boolean odz = true;
    public boolean odA = true;
    public boolean odB = true;
    List<Integer> oaF = new ArrayList();
    public int odC = -1;
    public float odD = 1.0f;
    public int odE = 15;
    public BorderType odF = BorderType.SHADOW;
    public int odH = 3;
    List<Integer> odI = new ArrayList();
    List<Integer> odJ = new ArrayList();
    List<String> odK = new ArrayList();
    private boolean odM = false;
    private boolean ocw = false;
    private boolean odN = false;
    private final master.flame.danmaku.danmaku.model.b odR = new master.flame.danmaku.danmaku.model.android.a();
    public final j odS = new j();
    public final master.flame.danmaku.a.b odT = new master.flame.danmaku.a.b();
    public final c odU = c.dWj();

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

    public static DanmakuContext dWc() {
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

    public master.flame.danmaku.danmaku.model.b dWd() {
        return this.odR;
    }

    private <T> void a(String str, T t, boolean z) {
        this.odT.aZ(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.odR.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext yb(boolean z) {
        if (this.ocw != z) {
            this.ocw = z;
            this.odS.dVJ();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dWe() {
        return this.ocw;
    }

    public boolean dWf() {
        return this.odN;
    }

    public DanmakuContext E(Map<Integer, Boolean> map) {
        this.odQ = map != null;
        if (map == null) {
            this.odT.bb("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.odS.dVJ();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dWg() {
        return this.odP;
    }

    public boolean dWh() {
        return this.odQ;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.odO = bVar;
        if (this.odO != null) {
            this.odO.a(aVar);
            this.odR.a(this.odO);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.odL == null) {
            this.odL = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.odL) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.odL.add(new WeakReference<>(aVar));
    }

    public void dWi() {
        if (this.odL != null) {
            this.odL.clear();
            this.odL = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.odL != null) {
            for (WeakReference<a> weakReference : this.odL) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
