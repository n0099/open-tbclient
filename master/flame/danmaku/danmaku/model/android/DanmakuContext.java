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
    public master.flame.danmaku.danmaku.model.a nzg;
    private List<WeakReference<a>> nzl;
    private b nzo;
    private boolean nzp;
    private boolean nzq;
    public Typeface nyW = null;
    public int nyR = master.flame.danmaku.danmaku.model.c.MAX;
    public float nyS = 1.0f;
    public int gzF = 0;
    public boolean nyX = true;
    public boolean nyY = true;
    public boolean nyZ = true;
    public boolean nza = true;
    public boolean nzb = true;
    List<Integer> nwf = new ArrayList();
    public int nzc = -1;
    public float nzd = 1.0f;
    public int nze = 15;
    public BorderType nzf = BorderType.SHADOW;
    public int nzh = 3;
    List<Integer> nzi = new ArrayList();
    List<Integer> nzj = new ArrayList();
    List<String> nzk = new ArrayList();
    private boolean nzm = false;
    private boolean nxW = false;
    private boolean nzn = false;
    private final master.flame.danmaku.danmaku.model.b nzr = new master.flame.danmaku.danmaku.model.android.a();
    public final j nzs = new j();
    public final master.flame.danmaku.a.b nzt = new master.flame.danmaku.a.b();
    public final c nzu = c.dOc();

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

    public static DanmakuContext dNV() {
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

    public master.flame.danmaku.danmaku.model.b dNW() {
        return this.nzr;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nzt.ba(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.nzr.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext xb(boolean z) {
        if (this.nxW != z) {
            this.nxW = z;
            this.nzs.dNC();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dNX() {
        return this.nxW;
    }

    public boolean dNY() {
        return this.nzn;
    }

    public DanmakuContext D(Map<Integer, Boolean> map) {
        this.nzq = map != null;
        if (map == null) {
            this.nzt.bc("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nzs.dNC();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dNZ() {
        return this.nzp;
    }

    public boolean dOa() {
        return this.nzq;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nzo = bVar;
        if (this.nzo != null) {
            this.nzo.a(aVar);
            this.nzr.a(this.nzo);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nzl == null) {
            this.nzl = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nzl) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nzl.add(new WeakReference<>(aVar));
    }

    public void dOb() {
        if (this.nzl != null) {
            this.nzl.clear();
            this.nzl = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nzl != null) {
            for (WeakReference<a> weakReference : this.nzl) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
