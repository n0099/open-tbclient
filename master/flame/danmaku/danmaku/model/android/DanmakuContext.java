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
    public master.flame.danmaku.danmaku.model.a oxD;
    private List<WeakReference<a>> oxI;
    private b oxL;
    private boolean oxM;
    private boolean oxN;
    public Typeface oxt = null;
    public int oxo = master.flame.danmaku.danmaku.model.c.MAX;
    public float oxp = 1.0f;
    public int heQ = 0;
    public boolean oxu = true;
    public boolean oxv = true;
    public boolean oxw = true;
    public boolean oxx = true;
    public boolean oxy = true;
    List<Integer> ouE = new ArrayList();
    public int oxz = -1;
    public float oxA = 1.0f;
    public int oxB = 15;
    public BorderType oxC = BorderType.SHADOW;
    public int oxE = 3;
    List<Integer> oxF = new ArrayList();
    List<Integer> oxG = new ArrayList();
    List<String> oxH = new ArrayList();
    private boolean oxJ = false;
    private boolean owt = false;
    private boolean oxK = false;
    private final master.flame.danmaku.danmaku.model.b oxO = new master.flame.danmaku.danmaku.model.android.a();
    public final j oxP = new j();
    public final master.flame.danmaku.a.b oxQ = new master.flame.danmaku.a.b();
    public final c oxR = c.eim();

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

    public static DanmakuContext eif() {
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

    public master.flame.danmaku.danmaku.model.b eig() {
        return this.oxO;
    }

    private <T> void a(String str, T t, boolean z) {
        this.oxQ.bd(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.oxO.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext yT(boolean z) {
        if (this.owt != z) {
            this.owt = z;
            this.oxP.ehM();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean eih() {
        return this.owt;
    }

    public boolean eii() {
        return this.oxK;
    }

    public DanmakuContext E(Map<Integer, Boolean> map) {
        this.oxN = map != null;
        if (map == null) {
            this.oxQ.bf("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.oxP.ehM();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean eij() {
        return this.oxM;
    }

    public boolean eik() {
        return this.oxN;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.oxL = bVar;
        if (this.oxL != null) {
            this.oxL.a(aVar);
            this.oxO.a(this.oxL);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.oxI == null) {
            this.oxI = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.oxI) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.oxI.add(new WeakReference<>(aVar));
    }

    public void eil() {
        if (this.oxI != null) {
            this.oxI.clear();
            this.oxI = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.oxI != null) {
            for (WeakReference<a> weakReference : this.oxI) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
