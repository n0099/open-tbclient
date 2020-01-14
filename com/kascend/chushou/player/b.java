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
    private PlayUrl mQh;
    public ListItem mQm;
    public ListItem mQn;
    public ListItem mQo;
    public ListItem mQp;
    public ListItem mQq;
    public ListItem mQr;
    public ListItem mQs;
    public ListItem mQt;
    public TrumpetPocket mQx;
    public List<ListItem> t;
    private final String z = "PlayerViewHelper";
    private boolean A = false;
    private FullRoomInfo mQi = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> D = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> mQk = null;
    private boolean H = true;
    public IconConfig mQu = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> mQy = new HashMap();
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a mQj = new a();
    private List<ListItem> F = new ArrayList();
    private List<ListItem> mQl = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> mQv = new ArrayList();
    public List<g.a> mQw = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.mQy.clear();
    }

    public void b() {
        if (this.mQj != null) {
            this.mQj.a();
            this.mQj = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.D != null) {
            this.D.clear();
            this.D = null;
        }
        if (this.mQi != null) {
            this.mQi.release();
            this.mQi = null;
        }
        if (this.mQk != null) {
            this.mQk.clear();
            this.mQk = null;
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
        this.mQi = fullRoomInfo;
    }

    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mQk == null) {
            this.mQk = new HashMap<>();
        }
        if (aVar != null) {
            this.mQk.put(aVar.p, aVar);
        }
    }

    public HashMap e() {
        return this.mQk;
    }

    public void a(String str) {
        if (this.mQk != null && this.mQk.containsKey(str)) {
            this.mQk.remove(str);
        }
    }

    public void f() {
        if (this.mQk != null) {
            this.mQk.clear();
        }
    }

    public FullRoomInfo dBw() {
        return this.mQi;
    }

    public void a(PlayUrl playUrl) {
        this.mQh = playUrl;
    }

    public PlayUrl dBx() {
        return this.mQh;
    }

    public List<ListItem> i() {
        return this.F;
    }

    public List<ListItem> j() {
        return this.mQl;
    }

    public b fr(List<ListItem> list) {
        this.F = list;
        this.mQl.clear();
        if (list != null) {
            this.mQl.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dBy() {
        if (this.mQi != null) {
            return this.mQi.mRoominfo;
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
        return (this.mQi == null || this.mQi.mRoominfo == null || !this.mQi.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.mQy.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
