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
    public String a;
    public ArrayList<PlayUrl> f;
    public String h;
    public ListItem npA;
    public ListItem npB;
    public ListItem npC;
    public ListItem npD;
    public ListItem npE;
    public TrumpetPocket npH;
    private PlayUrl npr;
    public ListItem npx;
    public ListItem npy;
    public ListItem npz;
    public List<ListItem> t;
    private final String A = "PlayerViewHelper";
    private boolean B = false;
    private FullRoomInfo nps = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> npt = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> F = null;
    private boolean I = true;
    public IconConfig npF = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> npI = new HashMap();
    public boolean z = false;
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a npu = new a();
    private List<ListItem> npv = new ArrayList();
    private List<ListItem> npw = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> npG = new ArrayList();
    public List<g.a> w = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.npI.clear();
        this.z = false;
    }

    public void b() {
        if (this.npu != null) {
            this.npu.a();
            this.npu = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.npt != null) {
            this.npt.clear();
            this.npt = null;
        }
        if (this.nps != null) {
            this.nps.release();
            this.nps = null;
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
            if (this.npt == null) {
                this.npt = new ArrayList<>(arrayList2);
                return;
            }
            this.npt.addAll(new ArrayList(arrayList2));
            int size = this.npt.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.npt.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.npt;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean d() {
        return this.B;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.nps = fullRoomInfo;
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

    public FullRoomInfo dNb() {
        return this.nps;
    }

    public void a(PlayUrl playUrl) {
        this.npr = playUrl;
    }

    public PlayUrl dNc() {
        return this.npr;
    }

    public List<ListItem> dNd() {
        return this.npv;
    }

    public List<ListItem> j() {
        return this.npw;
    }

    public b fE(List<ListItem> list) {
        this.npv = list;
        this.npw.clear();
        if (list != null) {
            this.npw.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dNe() {
        if (this.nps != null) {
            return this.nps.mRoominfo;
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
        return (this.nps == null || this.nps.mRoominfo == null || !this.nps.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.npI.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
