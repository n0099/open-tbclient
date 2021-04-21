package d.b.j0.b0;

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
import d.b.i0.z0.l;
import d.b.j0.b0.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f implements c.a {
    public static f j;

    /* renamed from: a  reason: collision with root package name */
    public c f53685a;

    /* renamed from: b  reason: collision with root package name */
    public c f53686b;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TransmitForumData> f53688d;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f53690f;

    /* renamed from: h  reason: collision with root package name */
    public int f53692h;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TransmitForumData> f53687c = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f53689e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53691g = false;
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

    @Override // d.b.j0.b0.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.f53690f = arrayList;
            }
            this.f53691g = true;
        } else if (i == 2) {
            if (z) {
                this.f53688d = arrayList;
                this.f53692h = i2;
            }
            this.f53689e = true;
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
            this.f53686b = (c) runTask.getData();
        }
        c cVar = this.f53686b;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final void f() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), c.class);
        if (runTask != null) {
            this.f53685a = (c) runTask.getData();
        }
        c cVar = this.f53685a;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final boolean g(long j2) {
        ArrayList<TransmitForumData> arrayList = this.f53687c;
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
        c cVar = this.f53685a;
        if (cVar != null) {
            cVar.b();
        }
        c cVar2 = this.f53686b;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public final void i() {
        if (this.f53685a == null || this.f53689e) {
            if (this.f53686b == null || this.f53691g) {
                this.f53689e = false;
                this.f53691g = false;
                this.i = false;
                this.f53687c.clear();
                if (!ListUtils.isEmpty(this.f53688d)) {
                    Iterator<TransmitForumData> it = this.f53688d.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!g(next.forumId)) {
                            this.f53687c.add(next);
                        }
                    }
                }
                if (!ListUtils.isEmpty(this.f53690f)) {
                    Iterator<TransmitForumData> it2 = this.f53690f.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!g(next2.forumId)) {
                            this.f53687c.add(next2);
                        }
                    }
                }
                this.f53688d = null;
                this.f53690f = null;
                j();
            }
        }
    }

    public final void j() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.f53687c));
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
        shareDialogConfig.setTransmitForumList(this.f53687c);
        shareDialogConfig.setPrivateThread(this.f53692h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
