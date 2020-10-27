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
    public master.flame.danmaku.danmaku.model.a pOl;
    private List<WeakReference<a>> pOq;
    private b pOt;
    private boolean pOu;
    private boolean pOv;
    public Typeface pOb = null;
    public int pNW = master.flame.danmaku.danmaku.model.c.MAX;
    public float pNX = 1.0f;
    public int margin = 0;
    public boolean pOc = true;
    public boolean pOd = true;
    public boolean pOe = true;
    public boolean pOf = true;
    public boolean pOg = true;
    List<Integer> pLn = new ArrayList();
    public int pOh = -1;
    public float pOi = 1.0f;
    public int pOj = 15;
    public BorderType pOk = BorderType.SHADOW;
    public int pOm = 3;
    List<Integer> pOn = new ArrayList();
    List<Integer> pOo = new ArrayList();
    List<String> pOp = new ArrayList();
    private boolean pOr = false;
    private boolean pNc = false;
    private boolean pOs = false;
    private final master.flame.danmaku.danmaku.model.b pOw = new master.flame.danmaku.danmaku.model.android.a();
    public final j pOx = new j();
    public final master.flame.danmaku.a.b pOy = new master.flame.danmaku.a.b();
    public final c pOz = c.eAd();

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

    public static DanmakuContext ezW() {
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

    public master.flame.danmaku.danmaku.model.b ezX() {
        return this.pOw;
    }

    private <T> void a(String str, T t, boolean z) {
        this.pOy.bo(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.pOw.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext AS(boolean z) {
        if (this.pNc != z) {
            this.pNc = z;
            this.pOx.ezD();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean ezY() {
        return this.pNc;
    }

    public boolean ezZ() {
        return this.pOs;
    }

    public DanmakuContext O(Map<Integer, Boolean> map) {
        this.pOv = map != null;
        if (map == null) {
            this.pOy.bq("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.pOx.ezD();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean eAa() {
        return this.pOu;
    }

    public boolean eAb() {
        return this.pOv;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.pOt = bVar;
        if (this.pOt != null) {
            this.pOt.a(aVar);
            this.pOw.a(this.pOt);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.pOq == null) {
            this.pOq = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.pOq) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.pOq.add(new WeakReference<>(aVar));
    }

    public void eAc() {
        if (this.pOq != null) {
            this.pOq.clear();
            this.pOq = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.pOq != null) {
            for (WeakReference<a> weakReference : this.pOq) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
