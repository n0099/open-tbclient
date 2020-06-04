package com.kascend.chushou.player;

import android.support.annotation.Nullable;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.FullRoomInfo;
import com.kascend.chushou.constants.GeneralTabGift;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.constants.TrumpetPocket;
import com.kascend.chushou.player.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    public String a;
    public ArrayList<PlayUrl> f;
    public String h;
    private PlayUrl mKC;
    public ListItem mKH;
    public ListItem mKI;
    public ListItem mKJ;
    public ListItem mKK;
    public ListItem mKL;
    public ListItem mKM;
    public ListItem mKN;
    public ListItem mKO;
    public TrumpetPocket mKR;
    public List<ListItem> t;
    private final String A = "PlayerViewHelper";
    private boolean B = false;
    private FullRoomInfo mKD = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> mKE = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> F = null;
    private boolean I = true;
    public IconConfig mKP = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> mKS = new HashMap();
    public boolean z = false;
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a mKF = new a();
    private List<ListItem> G = new ArrayList();
    private List<ListItem> mKG = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> mKQ = new ArrayList();
    public List<g.a> w = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.mKS.clear();
        this.z = false;
    }

    public void b() {
        if (this.mKF != null) {
            this.mKF.a();
            this.mKF = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.mKE != null) {
            this.mKE.clear();
            this.mKE = null;
        }
        if (this.mKD != null) {
            this.mKD.release();
            this.mKD = null;
        }
        if (this.F != null) {
            this.F.clear();
            this.F = null;
        }
        if (this.i != null) {
            this.i.clear();
            this.i = null;
        }
    }

    public void a(ArrayList<ChatInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (!"2".equals(arrayList.get(i).mType) || h.isEmpty(arrayList.get(i).mDisplayPosition) || arrayList.get(i).mDisplayPosition.contains("2")) {
                    arrayList2.add(arrayList.get(i));
                }
            }
            if (this.mKE == null) {
                this.mKE = new ArrayList<>(arrayList2);
                return;
            }
            this.mKE.addAll(new ArrayList(arrayList2));
            int size = this.mKE.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.mKE.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.mKE;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean d() {
        return this.B;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.mKD = fullRoomInfo;
    }

    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.F == null) {
            this.F = new HashMap<>();
        }
        if (aVar != null) {
            this.F.put(aVar.p, aVar);
        }
    }

    public HashMap e() {
        return this.F;
    }

    public void a(String str) {
        if (this.F != null && this.F.containsKey(str)) {
            this.F.remove(str);
        }
    }

    public void f() {
        if (this.F != null) {
            this.F.clear();
        }
    }

    public FullRoomInfo dEZ() {
        return this.mKD;
    }

    public void a(PlayUrl playUrl) {
        this.mKC = playUrl;
    }

    public PlayUrl dFa() {
        return this.mKC;
    }

    public List<ListItem> dFb() {
        return this.G;
    }

    public List<ListItem> j() {
        return this.mKG;
    }

    public b fj(List<ListItem> list) {
        this.G = list;
        this.mKG.clear();
        if (list != null) {
            this.mKG.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dFc() {
        if (this.mKD != null) {
            return this.mKD.mRoominfo;
        }
        return null;
    }

    public boolean l() {
        return this.I;
    }

    public void b(boolean z) {
        this.I = z;
    }

    public boolean m() {
        return (this.mKD == null || this.mKD.mRoominfo == null || !this.mKD.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.mKS.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
