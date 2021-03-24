package d.b.h0.a.b0;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import d.b.b.e.p.k;
import d.b.h0.f0.g;
import d.b.h0.r.s.i;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f49518a;

    /* renamed from: b  reason: collision with root package name */
    public i f49519b;

    public void a() {
        i iVar = this.f49519b;
        if (iVar != null) {
            iVar.f();
            this.f49519b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        TbPageContext c2;
        if (k.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (c2 = c(currentActivity)) == null || StringUtils.isNull(str)) {
            return;
        }
        c2.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
    }

    public final TbPageContext c(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void d(a aVar) {
        this.f49518a = aVar;
    }

    public void e() {
        a aVar = this.f49518a;
        if (aVar == null) {
            return;
        }
        int i = aVar.f49512c;
        if (i == a.C) {
            i i2 = i.i(TbadkCoreApplication.getInst().getCurrentActivity(), this.f49518a);
            i2.k();
            this.f49519b = i2;
        } else if (i == a.D) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            d.b.h0.r.o.c cVar = new d.b.h0.r.o.c(currentActivity);
            cVar.d(currentActivity, this.f49518a);
            cVar.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.b.h0.r.o.b b2 = d.b.h0.r.o.b.b();
            d.b.h0.r.o.b b3 = d.b.h0.r.o.b.b();
            b3.i("business_count_hint" + currentAccount + this.f49518a.f49510a, b2.c("business_count_hint" + currentAccount + this.f49518a.f49510a) - 1);
        } else if (i == a.E) {
            int i3 = aVar.f49513d;
            if (i3 == a.H) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f49518a.l) || k.isEmpty(this.f49518a.k)) {
                    return;
                }
                b(this.f49518a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i3 != a.I || k.isEmpty(aVar.k)) {
            } else {
                b(this.f49518a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i != a.F || TextUtils.isEmpty(aVar.f49514e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            a aVar2 = this.f49518a;
            completeTaskToastData.activityId = aVar2.f49510a;
            completeTaskToastData.missionId = aVar2.f49511b;
            completeTaskToastData.duration = aVar2.i;
            completeTaskToastData.message = aVar2.f49514e;
            completeTaskToastData.url = aVar2.k;
            completeTaskToastData.pageId = d.b.h0.a.c.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            g.g(competeTaskEvent);
            a aVar3 = this.f49518a;
            c.c(aVar3.f49510a, aVar3.f49511b);
        }
    }
}
