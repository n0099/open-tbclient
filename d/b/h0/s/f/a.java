package d.b.h0.s.f;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.LbsInfo;
import tbclient.GetAddressList.friendList;
/* loaded from: classes3.dex */
public class a implements TbCheckBox.c {

    /* renamed from: e  reason: collision with root package name */
    public boolean f51765e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f51766f;

    /* renamed from: g  reason: collision with root package name */
    public long f51767g;

    /* renamed from: h  reason: collision with root package name */
    public int f51768h;
    public String i;
    public String j;
    public String k;
    public b l;
    public String m;

    public String a() {
        return this.k;
    }

    public b b() {
        return this.l;
    }

    public String c() {
        StringBuilder sb = new StringBuilder(64);
        String str = this.f51766f;
        if (str != null) {
            sb.append(str);
        }
        String str2 = this.j;
        if (str2 != null) {
            sb.append(str2);
        }
        return sb.toString();
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.f51767g;
    }

    public String f() {
        return this.f51766f;
    }

    public String g() {
        return this.m;
    }

    public String h() {
        return this.i;
    }

    public int i() {
        return this.f51768h;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public boolean isChecked() {
        return this.f51765e;
    }

    public void j(friendList friendlist) {
        if (friendlist != null) {
            this.f51766f = friendlist.user_name;
            this.f51767g = friendlist.user_id.longValue();
            this.i = friendlist.portrait;
            this.m = friendlist.name_show;
            this.j = friendlist.quanpin;
            LbsInfo lbsInfo = friendlist.location;
            int i = -1;
            long j = 0;
            if (lbsInfo == null) {
                this.l = new b("", 0L, -1);
                return;
            }
            Long l = lbsInfo.time;
            if (l != null && l.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            Integer num = friendlist.location.is_hide;
            if (num != null && num.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.l = new b(friendlist.location.distance, j, i);
        }
    }

    public void k(String str) {
        this.k = str;
    }

    public void l(b bVar) {
        this.l = bVar;
    }

    public void m(String str) {
        this.j = str;
    }

    public void n(long j) {
        this.f51767g = j;
    }

    public void o(String str) {
        this.f51766f = str;
    }

    public void p(String str) {
        this.m = str;
    }

    public void q(String str) {
        this.i = str;
    }

    public void r(int i) {
        this.f51768h = i;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public void setChecked(boolean z) {
        this.f51765e = z;
    }
}
