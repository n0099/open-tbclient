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
    private PlayUrl plb;
    public ListItem plg;
    public ListItem plh;
    public ListItem pli;
    public ListItem plj;
    public ListItem plk;
    public ListItem pll;
    public ListItem plm;
    public ListItem pln;
    public TrumpetPocket plr;
    public List<ListItem> t;
    private final String A = "PlayerViewHelper";
    private boolean B = false;
    private FullRoomInfo plc = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> pld = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> F = null;
    private boolean I = true;
    public IconConfig plp = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> pls = new HashMap();
    public boolean z = false;
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a ple = new a();
    private List<ListItem> G = new ArrayList();
    private List<ListItem> plf = new ArrayList();
    public List<ListItem> plo = new ArrayList();
    public List<ListItem> plq = new ArrayList();
    public List<g.a> w = new ArrayList();

    public b(String str) {
        this.f4119a = str;
    }

    public void a() {
        this.pls.clear();
        this.z = false;
    }

    public void b() {
        if (this.ple != null) {
            this.ple.a();
            this.ple = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.pld != null) {
            this.pld.clear();
            this.pld = null;
        }
        if (this.plc != null) {
            this.plc.release();
            this.plc = null;
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
            if (this.pld == null) {
                this.pld = new ArrayList<>(arrayList2);
                return;
            }
            this.pld.addAll(new ArrayList(arrayList2));
            int size = this.pld.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.pld.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.pld;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean d() {
        return this.B;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.plc = fullRoomInfo;
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

    public FullRoomInfo euJ() {
        return this.plc;
    }

    public void a(PlayUrl playUrl) {
        this.plb = playUrl;
    }

    public PlayUrl euK() {
        return this.plb;
    }

    public List<ListItem> i() {
        return this.G;
    }

    public List<ListItem> j() {
        return this.plf;
    }

    public b gF(List<ListItem> list) {
        this.G = list;
        this.plf.clear();
        if (list != null) {
            this.plf.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo euL() {
        if (this.plc != null) {
            return this.plc.mRoominfo;
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
        return (this.plc == null || this.plc.mRoominfo == null || !this.plc.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.pls.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
