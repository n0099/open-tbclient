package d.b.i0.a.b0;

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
import d.b.c.e.p.k;
import d.b.i0.f0.h;
import d.b.i0.r.s.i;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f50247a;

    /* renamed from: b  reason: collision with root package name */
    public i f50248b;

    public void a() {
        i iVar = this.f50248b;
        if (iVar != null) {
            iVar.f();
            this.f50248b = null;
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
        this.f50247a = aVar;
    }

    public void e() {
        a aVar = this.f50247a;
        if (aVar == null) {
            return;
        }
        int i = aVar.f50241c;
        if (i == a.C) {
            i i2 = i.i(TbadkCoreApplication.getInst().getCurrentActivity(), this.f50247a);
            i2.k();
            this.f50248b = i2;
        } else if (i == a.D) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            d.b.i0.r.o.c cVar = new d.b.i0.r.o.c(currentActivity);
            cVar.d(currentActivity, this.f50247a);
            cVar.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.b.i0.r.o.b b2 = d.b.i0.r.o.b.b();
            d.b.i0.r.o.b b3 = d.b.i0.r.o.b.b();
            b3.i("business_count_hint" + currentAccount + this.f50247a.f50239a, b2.c("business_count_hint" + currentAccount + this.f50247a.f50239a) - 1);
        } else if (i == a.E) {
            int i3 = aVar.f50242d;
            if (i3 == a.H) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f50247a.l) || k.isEmpty(this.f50247a.k)) {
                    return;
                }
                b(this.f50247a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i3 != a.I || k.isEmpty(aVar.k)) {
            } else {
                b(this.f50247a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i != a.F || TextUtils.isEmpty(aVar.f50243e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            a aVar2 = this.f50247a;
            completeTaskToastData.activityId = aVar2.f50239a;
            completeTaskToastData.missionId = aVar2.f50240b;
            completeTaskToastData.duration = aVar2.i;
            completeTaskToastData.message = aVar2.f50243e;
            completeTaskToastData.url = aVar2.k;
            completeTaskToastData.pageId = d.b.i0.a.c.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            h.i(competeTaskEvent);
            a aVar3 = this.f50247a;
            c.c(aVar3.f50239a, aVar3.f50240b);
        }
    }
}
