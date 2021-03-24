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
    public c f51977a;

    /* renamed from: b  reason: collision with root package name */
    public c f51978b;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TransmitForumData> f51980d;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f51982f;

    /* renamed from: h  reason: collision with root package name */
    public int f51984h;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TransmitForumData> f51979c = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f51981e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51983g = false;
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
                this.f51982f = arrayList;
            }
            this.f51983g = true;
        } else if (i == 2) {
            if (z) {
                this.f51980d = arrayList;
                this.f51984h = i2;
            }
            this.f51981e = true;
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
            this.f51978b = (c) runTask.getData();
        }
        c cVar = this.f51978b;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final void f() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), c.class);
        if (runTask != null) {
            this.f51977a = (c) runTask.getData();
        }
        c cVar = this.f51977a;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final boolean g(long j2) {
        ArrayList<TransmitForumData> arrayList = this.f51979c;
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
        c cVar = this.f51977a;
        if (cVar != null) {
            cVar.b();
        }
        c cVar2 = this.f51978b;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public final void i() {
        if (this.f51977a == null || this.f51981e) {
            if (this.f51978b == null || this.f51983g) {
                this.f51981e = false;
                this.f51983g = false;
                this.i = false;
                this.f51979c.clear();
                if (!ListUtils.isEmpty(this.f51980d)) {
                    Iterator<TransmitForumData> it = this.f51980d.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!g(next.forumId)) {
                            this.f51979c.add(next);
                        }
                    }
                }
                if (!ListUtils.isEmpty(this.f51982f)) {
                    Iterator<TransmitForumData> it2 = this.f51982f.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!g(next2.forumId)) {
                            this.f51979c.add(next2);
                        }
                    }
                }
                this.f51980d = null;
                this.f51982f = null;
                j();
            }
        }
    }

    public final void j() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.f51979c));
    }

    public void k(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig == null || shareDialogConfig.shareItem == null || l.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.A = c();
        }
        if (d.b.b.e.p.l.C() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.i && !shareDialogConfig.shareItem.e()) {
            h();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.f51979c);
        shareDialogConfig.setPrivateThread(this.f51984h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
