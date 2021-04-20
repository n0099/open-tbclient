package d.b.i0.b0;

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
import d.b.h0.z0.l;
import d.b.i0.b0.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f implements c.a {
    public static f j;

    /* renamed from: a  reason: collision with root package name */
    public c f53264a;

    /* renamed from: b  reason: collision with root package name */
    public c f53265b;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TransmitForumData> f53267d;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f53269f;

    /* renamed from: h  reason: collision with root package name */
    public int f53271h;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TransmitForumData> f53266c = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f53268e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53270g = false;
    public boolean i = false;

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

    @Override // d.b.i0.b0.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.f53269f = arrayList;
            }
            this.f53270g = true;
        } else if (i == 2) {
            if (z) {
                this.f53267d = arrayList;
                this.f53271h = i2;
            }
            this.f53268e = true;
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
        this.i = false;
    }

    public final void e() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), c.class);
        if (runTask != null) {
            this.f53265b = (c) runTask.getData();
        }
        c cVar = this.f53265b;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final void f() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), c.class);
        if (runTask != null) {
            this.f53264a = (c) runTask.getData();
        }
        c cVar = this.f53264a;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final boolean g(long j2) {
        ArrayList<TransmitForumData> arrayList = this.f53266c;
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
        this.i = true;
        c cVar = this.f53264a;
        if (cVar != null) {
            cVar.b();
        }
        c cVar2 = this.f53265b;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public final void i() {
        if (this.f53264a == null || this.f53268e) {
            if (this.f53265b == null || this.f53270g) {
                this.f53268e = false;
                this.f53270g = false;
                this.i = false;
                this.f53266c.clear();
                if (!ListUtils.isEmpty(this.f53267d)) {
                    Iterator<TransmitForumData> it = this.f53267d.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!g(next.forumId)) {
                            this.f53266c.add(next);
                        }
                    }
                }
                if (!ListUtils.isEmpty(this.f53269f)) {
                    Iterator<TransmitForumData> it2 = this.f53269f.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!g(next2.forumId)) {
                            this.f53266c.add(next2);
                        }
                    }
                }
                this.f53267d = null;
                this.f53269f = null;
                j();
            }
        }
    }

    public final void j() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.f53266c));
    }

    public void k(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig == null || shareDialogConfig.shareItem == null || l.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.A = c();
        }
        if (d.b.c.e.p.l.C() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.i && !shareDialogConfig.shareItem.e()) {
            h();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.f53266c);
        shareDialogConfig.setPrivateThread(this.f53271h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
