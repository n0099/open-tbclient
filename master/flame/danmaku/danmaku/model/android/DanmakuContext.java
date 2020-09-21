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
    public master.flame.danmaku.danmaku.model.a oHA;
    private List<WeakReference<a>> oHF;
    private b oHI;
    private boolean oHJ;
    private boolean oHK;
    public Typeface oHq = null;
    public int oHl = master.flame.danmaku.danmaku.model.c.MAX;
    public float oHm = 1.0f;
    public int margin = 0;
    public boolean oHr = true;
    public boolean oHs = true;
    public boolean oHt = true;
    public boolean oHu = true;
    public boolean oHv = true;
    List<Integer> oEC = new ArrayList();
    public int oHw = -1;
    public float oHx = 1.0f;
    public int oHy = 15;
    public BorderType oHz = BorderType.SHADOW;
    public int oHB = 3;
    List<Integer> oHC = new ArrayList();
    List<Integer> oHD = new ArrayList();
    List<String> oHE = new ArrayList();
    private boolean oHG = false;
    private boolean oGr = false;
    private boolean oHH = false;
    private final master.flame.danmaku.danmaku.model.b oHL = new master.flame.danmaku.danmaku.model.android.a();
    public final j oHM = new j();
    public final master.flame.danmaku.a.b oHN = new master.flame.danmaku.a.b();
    public final c oHO = c.ems();

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

    public static DanmakuContext eml() {
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

    public master.flame.danmaku.danmaku.model.b emm() {
        return this.oHL;
    }

    private <T> void a(String str, T t, boolean z) {
        this.oHN.be(str, z).setData(t);
    }

    public DanmakuContext c(int i, float... fArr) {
        this.oHL.b(i, fArr);
        a(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext zd(boolean z) {
        if (this.oGr != z) {
            this.oGr = z;
            this.oHM.elS();
            a(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public boolean emn() {
        return this.oGr;
    }

    public boolean emo() {
        return this.oHH;
    }

    public DanmakuContext E(Map<Integer, Boolean> map) {
        this.oHK = map != null;
        if (map == null) {
            this.oHN.bg("1019_Filter", false);
        } else {
            a("1019_Filter", map, false);
        }
        this.oHM.elS();
        a(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean emp() {
        return this.oHJ;
    }

    public boolean emq() {
        return this.oHK;
    }

    public DanmakuContext a(b bVar, b.a aVar) {
        this.oHI = bVar;
        if (this.oHI != null) {
            this.oHI.a(aVar);
            this.oHL.a(this.oHI);
        }
        return this;
    }

    public void a(a aVar) {
        if (aVar == null || this.oHF == null) {
            this.oHF = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.oHF) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.oHF.add(new WeakReference<>(aVar));
    }

    public void emr() {
        if (this.oHF != null) {
            this.oHF.clear();
            this.oHF = null;
        }
    }

    private void a(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (this.oHF != null) {
            for (WeakReference<a> weakReference : this.oHF) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
