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
    private PlayUrl ngA;
    public ListItem ngG;
    public ListItem ngH;
    public ListItem ngI;
    public ListItem ngJ;
    public ListItem ngK;
    public ListItem ngL;
    public ListItem ngM;
    public ListItem ngN;
    public TrumpetPocket ngQ;
    public List<ListItem> t;
    private final String A = "PlayerViewHelper";
    private boolean B = false;
    private FullRoomInfo ngB = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> ngC = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> F = null;
    private boolean I = true;
    public IconConfig ngO = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> ngR = new HashMap();
    public boolean z = false;
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a ngD = new a();
    private List<ListItem> ngE = new ArrayList();
    private List<ListItem> ngF = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> ngP = new ArrayList();
    public List<g.a> w = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.ngR.clear();
        this.z = false;
    }

    public void b() {
        if (this.ngD != null) {
            this.ngD.a();
            this.ngD = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.ngC != null) {
            this.ngC.clear();
            this.ngC = null;
        }
        if (this.ngB != null) {
            this.ngB.release();
            this.ngB = null;
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
            if (this.ngC == null) {
                this.ngC = new ArrayList<>(arrayList2);
                return;
            }
            this.ngC.addAll(new ArrayList(arrayList2));
            int size = this.ngC.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.ngC.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.ngC;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean d() {
        return this.B;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.ngB = fullRoomInfo;
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

    public FullRoomInfo dJB() {
        return this.ngB;
    }

    public void a(PlayUrl playUrl) {
        this.ngA = playUrl;
    }

    public PlayUrl dJC() {
        return this.ngA;
    }

    public List<ListItem> dJD() {
        return this.ngE;
    }

    public List<ListItem> j() {
        return this.ngF;
    }

    public b fv(List<ListItem> list) {
        this.ngE = list;
        this.ngF.clear();
        if (list != null) {
            this.ngF.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dJE() {
        if (this.ngB != null) {
            return this.ngB.mRoominfo;
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
        return (this.ngB == null || this.ngB.mRoominfo == null || !this.ngB.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.ngR.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
