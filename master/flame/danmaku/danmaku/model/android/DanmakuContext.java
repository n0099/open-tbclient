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
    public master.flame.danmaku.danmaku.model.a oxV;
    private List<WeakReference<a>> oya;
    private b oyd;
    private boolean oye;
    private boolean oyf;
    public Typeface oxL = null;
    public int oxG = master.flame.danmaku.danmaku.model.c.MAX;
    public float oxH = 1.0f;
    public int heU = 0;
    public boolean oxM = true;
    public boolean oxN = true;
    public boolean oxO = true;
    public boolean oxP = true;
    public boolean oxQ = true;
    List<Integer> ouW = new ArrayList();
    public int oxR = -1;
    public float oxS = 1.0f;
    public int oxT = 15;
    public BorderType oxU = BorderType.SHADOW;
    public int oxW = 3;
    List<Integer> oxX = new ArrayList();
    List<Integer> oxY = new ArrayList();
    List<String> oxZ = new ArrayList();
    private boolean oyb = false;
    private boolean owL = false;
    private boolean oyc = false;
    private final master.flame.danmaku.danmaku.model.b oyg = new master.flame.danmaku.danmaku.model.android.a();
    public final j oyh = new j();
    public final master.flame.danmaku.a.b oyi = new master.flame.danmaku.a.b();
    public final c oyj = c.eiv();

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

    public static DanmakuContext eio() {
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

    public master.flame.danmaku.danmaku.model.b eip() {
        return this.oyg;
    }

    private <T> void a(String str, T t, boolean z) {
        this.oyi.bd(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.oyg.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext yV(boolean z) {
        if (this.owL != z) {
            this.owL = z;
            this.oyh.ehV();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean eiq() {
        return this.owL;
    }

    public boolean eir() {
        return this.oyc;
    }

    public DanmakuContext E(Map<Integer, Boolean> map) {
        this.oyf = map != null;
        if (map == null) {
            this.oyi.bf("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.oyh.ehV();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean eis() {
        return this.oye;
    }

    public boolean eit() {
        return this.oyf;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.oyd = bVar;
        if (this.oyd != null) {
            this.oyd.a(aVar);
            this.oyg.a(this.oyd);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.oya == null) {
            this.oya = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.oya) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.oya.add(new WeakReference<>(aVar));
    }

    public void eiu() {
        if (this.oya != null) {
            this.oya.clear();
            this.oya = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.oya != null) {
            for (WeakReference<a> weakReference : this.oya) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
