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
    public TrumpetPocket mpG;
    private PlayUrl mpr;
    public ListItem mpv;
    public ListItem mpw;
    public ListItem mpx;
    public ListItem mpy;
    public ListItem mpz;
    public List<ListItem> t;
    private final String z = "PlayerViewHelper";
    private boolean A = false;
    private FullRoomInfo mps = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> D = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> mpu = null;
    private boolean H = true;
    public IconConfig mpD = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> mpH = new HashMap();
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a mpt = new a();
    private List<ListItem> F = new ArrayList();
    private List<ListItem> G = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> mpE = new ArrayList();
    public List<g.a> mpF = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.mpH.clear();
    }

    public void b() {
        if (this.mpt != null) {
            this.mpt.a();
            this.mpt = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.D != null) {
            this.D.clear();
            this.D = null;
        }
        if (this.mps != null) {
            this.mps.release();
            this.mps = null;
        }
        if (this.mpu != null) {
            this.mpu.clear();
            this.mpu = null;
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
        this.mps = fullRoomInfo;
    }

    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mpu == null) {
            this.mpu = new HashMap<>();
        }
        if (aVar != null) {
            this.mpu.put(aVar.p, aVar);
        }
    }

    public HashMap e() {
        return this.mpu;
    }

    public void a(String str) {
        if (this.mpu != null && this.mpu.containsKey(str)) {
            this.mpu.remove(str);
        }
    }

    public void f() {
        if (this.mpu != null) {
            this.mpu.clear();
        }
    }

    public FullRoomInfo dxv() {
        return this.mps;
    }

    public void a(PlayUrl playUrl) {
        this.mpr = playUrl;
    }

    public PlayUrl dxw() {
        return this.mpr;
    }

    public List<ListItem> dxx() {
        return this.F;
    }

    public List<ListItem> dxy() {
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
    public RoomInfo dxz() {
        if (this.mps != null) {
            return this.mps.mRoominfo;
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
        return (this.mps == null || this.mps.mRoominfo == null || !this.mps.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.mpH.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
