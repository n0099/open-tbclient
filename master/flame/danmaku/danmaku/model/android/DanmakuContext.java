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
    private List<WeakReference<a>> nGB;
    private b nGE;
    private boolean nGF;
    private boolean nGG;
    public master.flame.danmaku.danmaku.model.a nGw;
    public Typeface nGm = null;
    public int nGh = master.flame.danmaku.danmaku.model.c.MAX;
    public float nGi = 1.0f;
    public int fCz = 0;
    public boolean nGn = true;
    public boolean nGo = true;
    public boolean nGp = true;
    public boolean nGq = true;
    public boolean nGr = true;
    List<Integer> nDx = new ArrayList();
    public int nGs = -1;
    public float nGt = 1.0f;
    public int nGu = 15;
    public BorderType nGv = BorderType.SHADOW;
    public int nGx = 3;
    List<Integer> nGy = new ArrayList();
    List<Integer> nGz = new ArrayList();
    List<String> nGA = new ArrayList();
    private boolean nGC = false;
    private boolean nFm = false;
    private boolean nGD = false;
    private final master.flame.danmaku.danmaku.model.b nGH = new master.flame.danmaku.danmaku.model.android.a();
    public final j nGI = new j();
    public final master.flame.danmaku.a.b nGJ = new master.flame.danmaku.a.b();
    public final c nGK = c.dLh();

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

    public static DanmakuContext dLa() {
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

    public master.flame.danmaku.danmaku.model.b dLb() {
        return this.nGH;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nGJ.aR(str, z).setData(t);
    }

    public DanmakuContext j(int i, float... fArr) {
        this.nGH.i(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext wL(boolean z) {
        if (this.nFm != z) {
            this.nFm = z;
            this.nGI.dKH();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dLc() {
        return this.nFm;
    }

    public boolean dLd() {
        return this.nGD;
    }

    public DanmakuContext F(Map<Integer, Boolean> map) {
        this.nGG = map != null;
        if (map == null) {
            this.nGJ.aT("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nGI.dKH();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dLe() {
        return this.nGF;
    }

    public boolean dLf() {
        return this.nGG;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nGE = bVar;
        if (this.nGE != null) {
            this.nGE.a(aVar);
            this.nGH.a(this.nGE);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nGB == null) {
            this.nGB = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nGB) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nGB.add(new WeakReference<>(aVar));
    }

    public void dLg() {
        if (this.nGB != null) {
            this.nGB.clear();
            this.nGB = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nGB != null) {
            for (WeakReference<a> weakReference : this.nGB) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
