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
    public ListItem nJC;
    public ListItem nJD;
    public ListItem nJE;
    public ListItem nJF;
    public ListItem nJG;
    public ListItem nJH;
    public ListItem nJI;
    public ListItem nJJ;
    public TrumpetPocket nJN;
    private PlayUrl nJx;
    public List<ListItem> t;
    private final String A = "PlayerViewHelper";
    private boolean B = false;
    private FullRoomInfo nJy = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> nJz = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> F = null;
    private boolean I = true;
    public IconConfig nJL = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> nJO = new HashMap();
    public boolean z = false;
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a nJA = new a();
    private List<ListItem> G = new ArrayList();
    private List<ListItem> nJB = new ArrayList();
    public List<ListItem> nJK = new ArrayList();
    public List<ListItem> nJM = new ArrayList();
    public List<g.a> w = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.nJO.clear();
        this.z = false;
    }

    public void b() {
        if (this.nJA != null) {
            this.nJA.a();
            this.nJA = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.nJz != null) {
            this.nJz.clear();
            this.nJz = null;
        }
        if (this.nJy != null) {
            this.nJy.release();
            this.nJy = null;
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
            if (this.nJz == null) {
                this.nJz = new ArrayList<>(arrayList2);
                return;
            }
            this.nJz.addAll(new ArrayList(arrayList2));
            int size = this.nJz.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.nJz.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.nJz;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean d() {
        return this.B;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.nJy = fullRoomInfo;
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

    public FullRoomInfo dZl() {
        return this.nJy;
    }

    public void a(PlayUrl playUrl) {
        this.nJx = playUrl;
    }

    public PlayUrl dZm() {
        return this.nJx;
    }

    public List<ListItem> i() {
        return this.G;
    }

    public List<ListItem> j() {
        return this.nJB;
    }

    public b fO(List<ListItem> list) {
        this.G = list;
        this.nJB.clear();
        if (list != null) {
            this.nJB.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dZn() {
        if (this.nJy != null) {
            return this.nJy.mRoominfo;
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
        return (this.nJy == null || this.nJy.mRoominfo == null || !this.nJy.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.nJO.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
