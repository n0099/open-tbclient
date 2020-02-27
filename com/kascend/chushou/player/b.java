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
    private PlayUrl mQK;
    public ListItem mQP;
    public ListItem mQQ;
    public ListItem mQR;
    public ListItem mQS;
    public ListItem mQT;
    public ListItem mQU;
    public ListItem mQV;
    public ListItem mQW;
    public TrumpetPocket mRa;
    public List<ListItem> t;
    private final String z = "PlayerViewHelper";
    private boolean A = false;
    private FullRoomInfo mQL = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> D = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> mQN = null;
    private boolean H = true;
    public IconConfig mQX = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> mRb = new HashMap();
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a mQM = new a();
    private List<ListItem> F = new ArrayList();
    private List<ListItem> mQO = new ArrayList();
    public List<ListItem> s = new ArrayList();
    public List<ListItem> mQY = new ArrayList();
    public List<g.a> mQZ = new ArrayList();

    public b(String str) {
        this.a = str;
    }

    public void a() {
        this.mRb.clear();
    }

    public void b() {
        if (this.mQM != null) {
            this.mQM.a();
            this.mQM = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.D != null) {
            this.D.clear();
            this.D = null;
        }
        if (this.mQL != null) {
            this.mQL.release();
            this.mQL = null;
        }
        if (this.mQN != null) {
            this.mQN.clear();
            this.mQN = null;
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
        this.mQL = fullRoomInfo;
    }

    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mQN == null) {
            this.mQN = new HashMap<>();
        }
        if (aVar != null) {
            this.mQN.put(aVar.p, aVar);
        }
    }

    public HashMap e() {
        return this.mQN;
    }

    public void a(String str) {
        if (this.mQN != null && this.mQN.containsKey(str)) {
            this.mQN.remove(str);
        }
    }

    public void f() {
        if (this.mQN != null) {
            this.mQN.clear();
        }
    }

    public FullRoomInfo dCC() {
        return this.mQL;
    }

    public void a(PlayUrl playUrl) {
        this.mQK = playUrl;
    }

    public PlayUrl dCD() {
        return this.mQK;
    }

    public List<ListItem> i() {
        return this.F;
    }

    public List<ListItem> j() {
        return this.mQO;
    }

    public b fm(List<ListItem> list) {
        this.F = list;
        this.mQO.clear();
        if (list != null) {
            this.mQO.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo dCE() {
        if (this.mQL != null) {
            return this.mQL.mRoominfo;
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
        return (this.mQL == null || this.mQL.mRoominfo == null || !this.mQL.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.mRb.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
