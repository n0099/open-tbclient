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
    public master.flame.danmaku.danmaku.model.a nxW;
    private List<WeakReference<a>> nyb;
    private b nye;
    private boolean nyf;
    private boolean nyg;
    public Typeface nxM = null;
    public int nxH = master.flame.danmaku.danmaku.model.c.MAX;
    public float nxI = 1.0f;
    public int gzu = 0;
    public boolean nxN = true;
    public boolean nxO = true;
    public boolean nxP = true;
    public boolean nxQ = true;
    public boolean nxR = true;
    List<Integer> nuV = new ArrayList();
    public int nxS = -1;
    public float nxT = 1.0f;
    public int nxU = 15;
    public BorderType nxV = BorderType.SHADOW;
    public int nxX = 3;
    List<Integer> nxY = new ArrayList();
    List<Integer> nxZ = new ArrayList();
    List<String> nya = new ArrayList();
    private boolean nyc = false;
    private boolean nwM = false;
    private boolean nyd = false;
    private final master.flame.danmaku.danmaku.model.b nyh = new master.flame.danmaku.danmaku.model.android.a();
    public final j nyi = new j();
    public final master.flame.danmaku.a.b nyj = new master.flame.danmaku.a.b();
    public final c nyk = c.dNO();

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

    public static DanmakuContext dNH() {
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

    public master.flame.danmaku.danmaku.model.b dNI() {
        return this.nyh;
    }

    private <T> void a(String str, T t, boolean z) {
        this.nyj.ba(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.nyh.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext wZ(boolean z) {
        if (this.nwM != z) {
            this.nwM = z;
            this.nyi.dNo();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean dNJ() {
        return this.nwM;
    }

    public boolean dNK() {
        return this.nyd;
    }

    public DanmakuContext D(Map<Integer, Boolean> map) {
        this.nyg = map != null;
        if (map == null) {
            this.nyj.bc("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.nyi.dNo();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean dNL() {
        return this.nyf;
    }

    public boolean dNM() {
        return this.nyg;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.nye = bVar;
        if (this.nye != null) {
            this.nye.a(aVar);
            this.nyh.a(this.nye);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.nyb == null) {
            this.nyb = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.nyb) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.nyb.add(new WeakReference<>(aVar));
    }

    public void dNN() {
        if (this.nyb != null) {
            this.nyb.clear();
            this.nyb = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.nyb != null) {
            for (WeakReference<a> weakReference : this.nyb) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
