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
    private PlayUrl mQX;
    public ListItem mRd;
    public ListItem mRe;
    public ListItem mRf;
    public ListItem mRg;
    public ListItem mRh;
    public ListItem mRi;
    public ListItem mRj;
    public ListItem mRk;
    public TrumpetPocket mRo;
    public List<ListItem> t;
    private final String z = "PlayerViewHelper";
    private boolean A = false;
    private FullRoomInfo mQY = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> D = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> mRa = null;
    private boolean H = true;
    public IconConfig mRl = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> mRp = new HashMap();
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a mQZ = new a();
    private List<ListItem> F = new ArrayList();
    private List<ListItem> mRb = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> mRm = new ArrayList();
    public List<g.a> mRn = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.mRp.clear();
    }

    public void b() {
        if (this.mQZ != null) {
            this.mQZ.a();
            this.mQZ = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.D != null) {
            this.D.clear();
            this.D = null;
        }
        if (this.mQY != null) {
            this.mQY.release();
            this.mQY = null;
        }
        if (this.mRa != null) {
            this.mRa.clear();
            this.mRa = null;
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
        this.mQY = fullRoomInfo;
    }

    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mRa == null) {
            this.mRa = new HashMap<>();
        }
        if (aVar != null) {
            this.mRa.put(aVar.p, aVar);
        }
    }

    public HashMap e() {
        return this.mRa;
    }

    public void a(String str) {
        if (this.mRa != null && this.mRa.containsKey(str)) {
            this.mRa.remove(str);
        }
    }

    public void f() {
        if (this.mRa != null) {
            this.mRa.clear();
        }
    }

    public FullRoomInfo dCF() {
        return this.mQY;
    }

    public void a(PlayUrl playUrl) {
        this.mQX = playUrl;
    }

    public PlayUrl dCG() {
        return this.mQX;
    }

    public List<ListItem> i() {
        return this.F;
    }

    public List<ListItem> j() {
        return this.mRb;
    }

    public b fm(List<ListItem> list) {
        this.F = list;
        this.mRb.clear();
        if (list != null) {
            this.mRb.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dCH() {
        if (this.mQY != null) {
            return this.mQY.mRoominfo;
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
        return (this.mQY == null || this.mQY.mRoominfo == null || !this.mQY.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.mRp.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
