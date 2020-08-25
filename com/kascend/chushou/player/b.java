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
    private PlayUrl nJf;
    public ListItem nJk;
    public ListItem nJl;
    public ListItem nJm;
    public ListItem nJn;
    public ListItem nJo;
    public ListItem nJp;
    public ListItem nJq;
    public ListItem nJr;
    public TrumpetPocket nJv;
    public List<ListItem> t;
    private final String A = "PlayerViewHelper";
    private boolean B = false;
    private FullRoomInfo nJg = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> nJh = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> F = null;
    private boolean I = true;
    public IconConfig nJt = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> nJw = new HashMap();
    public boolean z = false;
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a nJi = new a();
    private List<ListItem> G = new ArrayList();
    private List<ListItem> nJj = new ArrayList();
    public List<ListItem> nJs = new ArrayList();
    public List<ListItem> nJu = new ArrayList();
    public List<g.a> w = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.nJw.clear();
        this.z = false;
    }

    public void b() {
        if (this.nJi != null) {
            this.nJi.a();
            this.nJi = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.nJh != null) {
            this.nJh.clear();
            this.nJh = null;
        }
        if (this.nJg != null) {
            this.nJg.release();
            this.nJg = null;
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
            if (this.nJh == null) {
                this.nJh = new ArrayList<>(arrayList2);
                return;
            }
            this.nJh.addAll(new ArrayList(arrayList2));
            int size = this.nJh.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.nJh.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.nJh;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean d() {
        return this.B;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.nJg = fullRoomInfo;
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

    public FullRoomInfo dZc() {
        return this.nJg;
    }

    public void a(PlayUrl playUrl) {
        this.nJf = playUrl;
    }

    public PlayUrl dZd() {
        return this.nJf;
    }

    public List<ListItem> i() {
        return this.G;
    }

    public List<ListItem> j() {
        return this.nJj;
    }

    public b fO(List<ListItem> list) {
        this.G = list;
        this.nJj.clear();
        if (list != null) {
            this.nJj.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dZe() {
        if (this.nJg != null) {
            return this.nJg.mRoominfo;
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
        return (this.nJg == null || this.nJg.mRoominfo == null || !this.nJg.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.nJw.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
