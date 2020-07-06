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
    private PlayUrl ngD;
    public ListItem ngJ;
    public ListItem ngK;
    public ListItem ngL;
    public ListItem ngM;
    public ListItem ngN;
    public ListItem ngO;
    public ListItem ngP;
    public ListItem ngQ;
    public TrumpetPocket ngT;
    public List<ListItem> t;
    private final String A = "PlayerViewHelper";
    private boolean B = false;
    private FullRoomInfo ngE = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> ngF = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> F = null;
    private boolean I = true;
    public IconConfig ngR = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> ngU = new HashMap();
    public boolean z = false;
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a ngG = new a();
    private List<ListItem> ngH = new ArrayList();
    private List<ListItem> ngI = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> ngS = new ArrayList();
    public List<g.a> w = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.ngU.clear();
        this.z = false;
    }

    public void b() {
        if (this.ngG != null) {
            this.ngG.a();
            this.ngG = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.ngF != null) {
            this.ngF.clear();
            this.ngF = null;
        }
        if (this.ngE != null) {
            this.ngE.release();
            this.ngE = null;
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
            if (this.ngF == null) {
                this.ngF = new ArrayList<>(arrayList2);
                return;
            }
            this.ngF.addAll(new ArrayList(arrayList2));
            int size = this.ngF.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.ngF.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.ngF;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean d() {
        return this.B;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.ngE = fullRoomInfo;
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

    public FullRoomInfo dJF() {
        return this.ngE;
    }

    public void a(PlayUrl playUrl) {
        this.ngD = playUrl;
    }

    public PlayUrl dJG() {
        return this.ngD;
    }

    public List<ListItem> dJH() {
        return this.ngH;
    }

    public List<ListItem> j() {
        return this.ngI;
    }

    public b fv(List<ListItem> list) {
        this.ngH = list;
        this.ngI.clear();
        if (list != null) {
            this.ngI.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dJI() {
        if (this.ngE != null) {
            return this.ngE.mRoominfo;
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
        return (this.ngE == null || this.ngE.mRoominfo == null || !this.ngE.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.ngU.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
