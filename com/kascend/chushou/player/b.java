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
/* loaded from: classes4.dex */
public class b {
    public String a;
    public ArrayList<PlayUrl> f;
    public String h;
    private PlayUrl mQc;
    public ListItem mQh;
    public ListItem mQi;
    public ListItem mQj;
    public ListItem mQk;
    public ListItem mQl;
    public ListItem mQm;
    public ListItem mQn;
    public ListItem mQo;
    public TrumpetPocket mQs;
    public List<ListItem> t;
    private final String z = "PlayerViewHelper";
    private boolean A = false;
    private FullRoomInfo mQd = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> D = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> mQf = null;
    private boolean H = true;
    public IconConfig mQp = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> mQt = new HashMap();
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a mQe = new a();
    private List<ListItem> F = new ArrayList();
    private List<ListItem> mQg = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> mQq = new ArrayList();
    public List<g.a> mQr = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.mQt.clear();
    }

    public void b() {
        if (this.mQe != null) {
            this.mQe.a();
            this.mQe = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.D != null) {
            this.D.clear();
            this.D = null;
        }
        if (this.mQd != null) {
            this.mQd.release();
            this.mQd = null;
        }
        if (this.mQf != null) {
            this.mQf.clear();
            this.mQf = null;
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
        this.mQd = fullRoomInfo;
    }

    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mQf == null) {
            this.mQf = new HashMap<>();
        }
        if (aVar != null) {
            this.mQf.put(aVar.p, aVar);
        }
    }

    public HashMap e() {
        return this.mQf;
    }

    public void a(String str) {
        if (this.mQf != null && this.mQf.containsKey(str)) {
            this.mQf.remove(str);
        }
    }

    public void f() {
        if (this.mQf != null) {
            this.mQf.clear();
        }
    }

    public FullRoomInfo dBu() {
        return this.mQd;
    }

    public void a(PlayUrl playUrl) {
        this.mQc = playUrl;
    }

    public PlayUrl dBv() {
        return this.mQc;
    }

    public List<ListItem> i() {
        return this.F;
    }

    public List<ListItem> j() {
        return this.mQg;
    }

    public b fr(List<ListItem> list) {
        this.F = list;
        this.mQg.clear();
        if (list != null) {
            this.mQg.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dBw() {
        if (this.mQd != null) {
            return this.mQd.mRoominfo;
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
        return (this.mQd == null || this.mQd.mRoominfo == null || !this.mQd.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.mQt.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
