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
    public master.flame.danmaku.danmaku.model.a nUU;
    private List<WeakReference<a>> nUZ;
    private b nVc;
    private boolean nVd;
    private boolean nVe;
    public Typeface nUK = null;
    public int nUF = master.flame.danmaku.danmaku.model.c.MAX;
    public float nUG = 1.0f;
    public int gMr = 0;
    public boolean nUL = true;
    public boolean nUM = true;
    public boolean nUN = true;
    public boolean nUO = true;
    public boolean nUP = true;
    List<Integer> nRU = new ArrayList();
    public int nUQ = -1;
    public float nUR = 1.0f;
    public int nUS = 15;
    public BorderType nUT = BorderType.SHADOW;
    public int nUV = 3;
    List<Integer> nUW = new ArrayList();
    List<Integer> nUX = new ArrayList();
    List<String> nUY = new ArrayList();
    private boolean nVa = false;
    private boolean nTK = false;
    private boolean nVb = false;
    private final master.flame.danmaku.danmaku.model.b nVf = new master.flame.danmaku.danmaku.model.android.a();
    public final j nVg = new j();
    public final master.flame.danmaku.a.b nVh = new master.flame.danmaku.a.b();
    public final c nVi = c.dSM();

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

    public static DanmakuContext dSF() {
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

    public master.flame.danmaku.danmaku.model.b dSG() {
        return this.nVf;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nVh.bc(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.nVf.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext xw(boolean z) {
        if (this.nTK != z) {
            this.nTK = z;
            this.nVg.dSm();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dSH() {
        return this.nTK;
    }

    public boolean dSI() {
        return this.nVb;
    }

    public DanmakuContext E(Map<Integer, Boolean> map) {
        this.nVe = map != null;
        if (map == null) {
            this.nVh.be("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nVg.dSm();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dSJ() {
        return this.nVd;
    }

    public boolean dSK() {
        return this.nVe;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nVc = bVar;
        if (this.nVc != null) {
            this.nVc.a(aVar);
            this.nVf.a(this.nVc);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nUZ == null) {
            this.nUZ = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nUZ) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nUZ.add(new WeakReference<>(aVar));
    }

    public void dSL() {
        if (this.nUZ != null) {
            this.nUZ.clear();
            this.nUZ = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nUZ != null) {
            for (WeakReference<a> weakReference : this.nUZ) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
