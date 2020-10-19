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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f4119a;
    public ArrayList<PlayUrl> f;
    public String h;
    private PlayUrl oiK;
    public ListItem oiP;
    public ListItem oiQ;
    public ListItem oiR;
    public ListItem oiS;
    public ListItem oiT;
    public ListItem oiU;
    public ListItem oiV;
    public ListItem oiW;
    public TrumpetPocket oja;
    public List<ListItem> t;
    private final String A = "PlayerViewHelper";
    private boolean B = false;
    private FullRoomInfo oiL = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> oiM = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> F = null;
    private boolean I = true;
    public IconConfig oiY = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> ojb = new HashMap();
    public boolean z = false;
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a oiN = new a();
    private List<ListItem> G = new ArrayList();
    private List<ListItem> oiO = new ArrayList();
    public List<ListItem> oiX = new ArrayList();
    public List<ListItem> oiZ = new ArrayList();
    public List<g.a> w = new ArrayList();

    public b(String str) {
        this.f4119a = str;
    }

    public void a() {
        this.ojb.clear();
        this.z = false;
    }

    public void b() {
        if (this.oiN != null) {
            this.oiN.a();
            this.oiN = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.oiM != null) {
            this.oiM.clear();
            this.oiM = null;
        }
        if (this.oiL != null) {
            this.oiL.release();
            this.oiL = null;
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
            if (this.oiM == null) {
                this.oiM = new ArrayList<>(arrayList2);
                return;
            }
            this.oiM.addAll(new ArrayList(arrayList2));
            int size = this.oiM.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.oiM.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.oiM;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean d() {
        return this.B;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.oiL = fullRoomInfo;
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

    public FullRoomInfo egU() {
        return this.oiL;
    }

    public void a(PlayUrl playUrl) {
        this.oiK = playUrl;
    }

    public PlayUrl egV() {
        return this.oiK;
    }

    public List<ListItem> i() {
        return this.G;
    }

    public List<ListItem> j() {
        return this.oiO;
    }

    public b ga(List<ListItem> list) {
        this.G = list;
        this.oiO.clear();
        if (list != null) {
            this.oiO.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo egW() {
        if (this.oiL != null) {
            return this.oiL.mRoominfo;
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
        return (this.oiL == null || this.oiL.mRoominfo == null || !this.oiL.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.ojb.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
