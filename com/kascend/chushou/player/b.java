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
    public ListItem pjC;
    public ListItem pjD;
    public ListItem pjE;
    public ListItem pjF;
    public ListItem pjG;
    public ListItem pjH;
    public ListItem pjI;
    public ListItem pjJ;
    public TrumpetPocket pjN;
    private PlayUrl pjx;
    public List<ListItem> t;
    private final String A = "PlayerViewHelper";
    private boolean B = false;
    private FullRoomInfo pjy = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;
    private ArrayList<ChatInfo> pjz = null;
    private HashMap<String, com.kascend.chushou.player.ui.h5.c.a> F = null;
    private boolean I = true;
    public IconConfig pjL = new IconConfig();
    public final Map<String, SkinConfig.SkinRes> pjO = new HashMap();
    public boolean z = false;
    public List<tv.chushou.zues.widget.gift.a.a> i = new ArrayList();
    public List<GeneralTabGift> j = new ArrayList();
    a pjA = new a();
    private List<ListItem> G = new ArrayList();
    private List<ListItem> pjB = new ArrayList();
    public List<ListItem> pjK = new ArrayList();
    public List<ListItem> pjM = new ArrayList();
    public List<g.a> w = new ArrayList();

    public b(String str) {
        this.f4119a = str;
    }

    public void a() {
        this.pjO.clear();
        this.z = false;
    }

    public void b() {
        if (this.pjA != null) {
            this.pjA.a();
            this.pjA = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.pjz != null) {
            this.pjz.clear();
            this.pjz = null;
        }
        if (this.pjy != null) {
            this.pjy.release();
            this.pjy = null;
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
            if (this.pjz == null) {
                this.pjz = new ArrayList<>(arrayList2);
                return;
            }
            this.pjz.addAll(new ArrayList(arrayList2));
            int size = this.pjz.size();
            if (size > 100) {
                for (int i2 = 0; i2 < size - 100; i2++) {
                    this.pjz.remove(i2);
                }
            }
        }
    }

    public ArrayList<ChatInfo> c() {
        return this.pjz;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public boolean d() {
        return this.B;
    }

    public void a(FullRoomInfo fullRoomInfo) {
        this.pjy = fullRoomInfo;
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
        return this.pjy;
    }

    public void a(PlayUrl playUrl) {
        this.pjx = playUrl;
    }

    public PlayUrl euK() {
        return this.pjx;
    }

    public List<ListItem> i() {
        return this.G;
    }

    public List<ListItem> j() {
        return this.pjB;
    }

    public b gF(List<ListItem> list) {
        this.G = list;
        this.pjB.clear();
        if (list != null) {
            this.pjB.addAll(list);
        }
        return this;
    }

    @Nullable
    public RoomInfo euL() {
        if (this.pjy != null) {
            return this.pjy.mRoominfo;
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
        return (this.pjy == null || this.pjy.mRoominfo == null || !this.pjy.mRoominfo.mIsSubscribed) ? false : true;
    }

    public String b(String str) {
        SkinConfig.SkinRes skinRes = this.pjO.get(str);
        if (skinRes != null) {
            return skinRes.image;
        }
        return null;
    }
}
