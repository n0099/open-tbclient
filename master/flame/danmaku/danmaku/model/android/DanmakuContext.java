package master.flame.danmaku.danmaku.model.android;

import android.graphics.Typeface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.b;
import master.flame.danmaku.danmaku.model.j;
/* loaded from: classes4.dex */
public class DanmakuContext {
    private boolean nGA;
    private boolean nGB;
    public master.flame.danmaku.danmaku.model.a nGr;
    private List<WeakReference<a>> nGw;
    private b nGz;
    public Typeface nGh = null;
    public int nGc = master.flame.danmaku.danmaku.model.c.MAX;
    public float nGd = 1.0f;
    public int fCz = 0;
    public boolean nGi = true;
    public boolean nGj = true;
    public boolean nGk = true;
    public boolean nGl = true;
    public boolean nGm = true;
    List<Integer> nDs = new ArrayList();
    public int nGn = -1;
    public float nGo = 1.0f;
    public int nGp = 15;
    public BorderType nGq = BorderType.SHADOW;
    public int nGs = 3;
    List<Integer> nGt = new ArrayList();
    List<Integer> nGu = new ArrayList();
    List<String> nGv = new ArrayList();
    private boolean nGx = false;
    private boolean nFh = false;
    private boolean nGy = false;
    private final master.flame.danmaku.danmaku.model.b nGC = new master.flame.danmaku.danmaku.model.android.a();
    public final j nGD = new j();
    public final master.flame.danmaku.a.b nGE = new master.flame.danmaku.a.b();
    public final c nGF = c.dLf();

    /* loaded from: classes4.dex */
    public enum BorderType {
        NONE,
        SHADOW,
        STROKEN
    }

    /* loaded from: classes4.dex */
    public interface a {
        boolean a(DanmakuContext danmakuContext, DanmakuConfigTag danmakuConfigTag, Object... objArr);
    }

    public static DanmakuContext dKY() {
        return new DanmakuContext();
    }

    /* loaded from: classes4.dex */
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

    public master.flame.danmaku.danmaku.model.b dKZ() {
        return this.nGC;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nGE.aR(str, z).setData(t);
    }

    public DanmakuContext j(int i, float... fArr) {
        this.nGC.i(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext wL(boolean z) {
        if (this.nFh != z) {
            this.nFh = z;
            this.nGD.dKF();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dLa() {
        return this.nFh;
    }

    public boolean dLb() {
        return this.nGy;
    }

    public DanmakuContext F(Map<Integer, Boolean> map) {
        this.nGB = map != null;
        if (map == null) {
            this.nGE.aT("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nGD.dKF();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dLc() {
        return this.nGA;
    }

    public boolean dLd() {
        return this.nGB;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nGz = bVar;
        if (this.nGz != null) {
            this.nGz.a(aVar);
            this.nGC.a(this.nGz);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nGw == null) {
            this.nGw = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nGw) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nGw.add(new WeakReference<>(aVar));
    }

    public void dLe() {
        if (this.nGw != null) {
            this.nGw.clear();
            this.nGw = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nGw != null) {
            for (WeakReference<a> weakReference : this.nGw) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
