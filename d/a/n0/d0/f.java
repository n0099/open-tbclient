package d.a.n0.d0;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import d.a.m0.z0.l;
import d.a.n0.d0.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f implements c.a {
    public static f j;

    /* renamed from: a  reason: collision with root package name */
    public c f52430a;

    /* renamed from: b  reason: collision with root package name */
    public c f52431b;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TransmitForumData> f52433d;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f52435f;

    /* renamed from: h  reason: collision with root package name */
    public int f52437h;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TransmitForumData> f52432c = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f52434e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52436g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52438i = false;

    public f() {
        d();
    }

    public static f b() {
        if (j == null) {
            synchronized (f.class) {
                if (j == null) {
                    j = new f();
                }
            }
        }
        return j;
    }

    @Override // d.a.n0.d0.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i2, int i3) {
        if (i2 == 1) {
            if (z) {
                this.f52435f = arrayList;
            }
            this.f52436g = true;
        } else if (i2 == 2) {
            if (z) {
                this.f52433d = arrayList;
                this.f52437h = i3;
            }
            this.f52434e = true;
        }
        i();
    }

    public final Location c() {
        if (PermissionUtil.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
            LocationManager locationManager = (LocationManager) TbadkCoreApplication.getInst().getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            try {
                return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public final void d() {
        f();
        e();
        this.f52438i = false;
    }

    public final void e() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), c.class);
        if (runTask != null) {
            this.f52431b = (c) runTask.getData();
        }
        c cVar = this.f52431b;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final void f() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), c.class);
        if (runTask != null) {
            this.f52430a = (c) runTask.getData();
        }
        c cVar = this.f52430a;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final boolean g(long j2) {
        ArrayList<TransmitForumData> arrayList = this.f52432c;
        if (arrayList == null) {
            return false;
        }
        Iterator<TransmitForumData> it = arrayList.iterator();
        while (it.hasNext()) {
            TransmitForumData next = it.next();
            if (next != null && next.forumId == j2) {
                return true;
            }
        }
        return false;
    }

    public void h() {
        this.f52438i = true;
        c cVar = this.f52430a;
        if (cVar != null) {
            cVar.b();
        }
        c cVar2 = this.f52431b;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public final void i() {
        if (this.f52430a == null || this.f52434e) {
            if (this.f52431b == null || this.f52436g) {
                this.f52434e = false;
                this.f52436g = false;
                this.f52438i = false;
                this.f52432c.clear();
                if (!ListUtils.isEmpty(this.f52433d)) {
                    Iterator<TransmitForumData> it = this.f52433d.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!g(next.forumId)) {
                            this.f52432c.add(next);
                        }
                    }
                }
                if (!ListUtils.isEmpty(this.f52435f)) {
                    Iterator<TransmitForumData> it2 = this.f52435f.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!g(next2.forumId)) {
                            this.f52432c.add(next2);
                        }
                    }
                }
                this.f52433d = null;
                this.f52435f = null;
                j();
            }
        }
    }

    public final void j() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.f52432c));
    }

    public void k(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig == null || shareDialogConfig.shareItem == null || l.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.B = c();
        }
        if (d.a.c.e.p.l.D() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.f52438i && !shareDialogConfig.shareItem.f()) {
            h();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.f52432c);
        shareDialogConfig.setPrivateThread(this.f52437h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
