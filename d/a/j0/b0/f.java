package d.a.j0.b0;

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
import d.a.i0.z0.l;
import d.a.j0.b0.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f implements c.a {
    public static f j;

    /* renamed from: a  reason: collision with root package name */
    public c f51428a;

    /* renamed from: b  reason: collision with root package name */
    public c f51429b;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TransmitForumData> f51431d;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f51433f;

    /* renamed from: h  reason: collision with root package name */
    public int f51435h;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TransmitForumData> f51430c = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f51432e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51434g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51436i = false;

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

    @Override // d.a.j0.b0.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i2, int i3) {
        if (i2 == 1) {
            if (z) {
                this.f51433f = arrayList;
            }
            this.f51434g = true;
        } else if (i2 == 2) {
            if (z) {
                this.f51431d = arrayList;
                this.f51435h = i3;
            }
            this.f51432e = true;
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
        this.f51436i = false;
    }

    public final void e() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), c.class);
        if (runTask != null) {
            this.f51429b = (c) runTask.getData();
        }
        c cVar = this.f51429b;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final void f() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), c.class);
        if (runTask != null) {
            this.f51428a = (c) runTask.getData();
        }
        c cVar = this.f51428a;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final boolean g(long j2) {
        ArrayList<TransmitForumData> arrayList = this.f51430c;
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
        this.f51436i = true;
        c cVar = this.f51428a;
        if (cVar != null) {
            cVar.b();
        }
        c cVar2 = this.f51429b;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public final void i() {
        if (this.f51428a == null || this.f51432e) {
            if (this.f51429b == null || this.f51434g) {
                this.f51432e = false;
                this.f51434g = false;
                this.f51436i = false;
                this.f51430c.clear();
                if (!ListUtils.isEmpty(this.f51431d)) {
                    Iterator<TransmitForumData> it = this.f51431d.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!g(next.forumId)) {
                            this.f51430c.add(next);
                        }
                    }
                }
                if (!ListUtils.isEmpty(this.f51433f)) {
                    Iterator<TransmitForumData> it2 = this.f51433f.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!g(next2.forumId)) {
                            this.f51430c.add(next2);
                        }
                    }
                }
                this.f51431d = null;
                this.f51433f = null;
                j();
            }
        }
    }

    public final void j() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.f51430c));
    }

    public void k(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig == null || shareDialogConfig.shareItem == null || l.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.B = c();
        }
        if (d.a.c.e.p.l.D() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.f51436i && !shareDialogConfig.shareItem.f()) {
            h();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.f51430c);
        shareDialogConfig.setPrivateThread(this.f51435h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
