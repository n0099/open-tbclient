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
    public master.flame.danmaku.danmaku.model.a nJn;
    private List<WeakReference<a>> nJs;
    private b nJv;
    private boolean nJw;
    private boolean nJx;
    public Typeface nJd = null;
    public int nIY = master.flame.danmaku.danmaku.model.c.MAX;
    public float nIZ = 1.0f;
    public int fFT = 0;
    public boolean nJe = true;
    public boolean nJf = true;
    public boolean nJg = true;
    public boolean nJh = true;
    public boolean nJi = true;
    List<Integer> nGp = new ArrayList();
    public int nJj = -1;
    public float nJk = 1.0f;
    public int nJl = 15;
    public BorderType nJm = BorderType.SHADOW;
    public int nJo = 3;
    List<Integer> nJp = new ArrayList();
    List<Integer> nJq = new ArrayList();
    List<String> nJr = new ArrayList();
    private boolean nJt = false;
    private boolean nIe = false;
    private boolean nJu = false;
    private final master.flame.danmaku.danmaku.model.b nJy = new master.flame.danmaku.danmaku.model.android.a();
    public final j nJz = new j();
    public final master.flame.danmaku.a.b nJA = new master.flame.danmaku.a.b();
    public final c nJB = c.dMX();

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

    public static DanmakuContext dMQ() {
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

    public master.flame.danmaku.danmaku.model.b dMR() {
        return this.nJy;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nJA.aR(str, z).setData(t);
    }

    public DanmakuContext j(int i, float... fArr) {
        this.nJy.i(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext wW(boolean z) {
        if (this.nIe != z) {
            this.nIe = z;
            this.nJz.dMx();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dMS() {
        return this.nIe;
    }

    public boolean dMT() {
        return this.nJu;
    }

    public DanmakuContext F(Map<Integer, Boolean> map) {
        this.nJx = map != null;
        if (map == null) {
            this.nJA.aT("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nJz.dMx();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dMU() {
        return this.nJw;
    }

    public boolean dMV() {
        return this.nJx;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nJv = bVar;
        if (this.nJv != null) {
            this.nJv.a(aVar);
            this.nJy.a(this.nJv);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nJs == null) {
            this.nJs = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nJs) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nJs.add(new WeakReference<>(aVar));
    }

    public void dMW() {
        if (this.nJs != null) {
            this.nJs.clear();
            this.nJs = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nJs != null) {
            for (WeakReference<a> weakReference : this.nJs) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
