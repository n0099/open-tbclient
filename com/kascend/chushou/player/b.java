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
    public ListItem mpA;
    public ListItem mpB;
    public ListItem mpC;
    public ListItem mpD;
    public ListItem mpE;
    public ListItem mpF;
    public ListItem mpG;
    public ListItem mpH;
    public TrumpetPocket mpL;
    private PlayUrl mpw;
    public List<ListItem> t;
    private final String z = "PlayerViewHelper";
    private boolean A = false;
    private FullRoomInfo mpx = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> D = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> mpz = null;
    private boolean H = true;
    public IconConfig mpI = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> mpM = new HashMap();
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a mpy = new a();
    private List<ListItem> F = new ArrayList();
    private List<ListItem> G = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> mpJ = new ArrayList();
    public List<g.a> mpK = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.mpM.clear();
    }

    public void b() {
        if (this.mpy != null) {
            this.mpy.a();
            this.mpy = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.D != null) {
            this.D.clear();
            this.D = null;
        }
        if (this.mpx != null) {
            this.mpx.release();
            this.mpx = null;
        }
        if (this.mpz != null) {
            this.mpz.clear();
            this.mpz = null;
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
            if (this.D == null) {
                this.D = new ArrayList<>(arrayList2);
                return;
            }
            this.D.addAll(new ArrayList(arrayList2));
            int size = this.D.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.D.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.D;
    }

    public void a(boolean z) {
        this.A = z;
    }

    public boolean d() {
        return this.A;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.mpx = fullRoomInfo;
    }

    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mpz == null) {
            this.mpz = new HashMap<>();
        }
        if (aVar != null) {
            this.mpz.put(aVar.p, aVar);
        }
    }

    public HashMap e() {
        return this.mpz;
    }

    public void a(String str) {
        if (this.mpz != null && this.mpz.containsKey(str)) {
            this.mpz.remove(str);
        }
    }

    public void f() {
        if (this.mpz != null) {
            this.mpz.clear();
        }
    }

    public FullRoomInfo dxt() {
        return this.mpx;
    }

    public void a(PlayUrl playUrl) {
        this.mpw = playUrl;
    }

    public PlayUrl dxu() {
        return this.mpw;
    }

    public List<ListItem> dxv() {
        return this.F;
    }

    public List<ListItem> j() {
        return this.G;
    }

    public b fa(List<ListItem> list) {
        this.F = list;
        this.G.clear();
        if (list != null) {
            this.G.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dxw() {
        if (this.mpx != null) {
            return this.mpx.mRoominfo;
        }
        return null;
    }

    public boolean l() {
        return this.H;
    }

    public void b(boolean z) {
        this.H = z;
    }

    public boolean m() {
        return (this.mpx == null || this.mpx.mRoominfo == null || !this.mpx.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.mpM.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
