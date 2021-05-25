package d.a.m0.a.d0;

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
import d.a.c.e.p.k;
import d.a.m0.f0.h;
import d.a.m0.r.s.i;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f48690a;

    /* renamed from: b  reason: collision with root package name */
    public i f48691b;

    public void a() {
        i iVar = this.f48691b;
        if (iVar != null) {
            iVar.f();
            this.f48691b = null;
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
        this.f48690a = aVar;
    }

    public void e() {
        a aVar = this.f48690a;
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f48683c;
        if (i2 == a.y) {
            i h2 = i.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.f48690a);
            h2.j();
            this.f48691b = h2;
        } else if (i2 == a.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            d.a.m0.r.o.b bVar = new d.a.m0.r.o.b(currentActivity);
            bVar.d(currentActivity, this.f48690a);
            bVar.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.m0.r.o.a b2 = d.a.m0.r.o.a.b();
            d.a.m0.r.o.a b3 = d.a.m0.r.o.a.b();
            b3.i("business_count_hint" + currentAccount + this.f48690a.f48681a, b2.c("business_count_hint" + currentAccount + this.f48690a.f48681a) - 1);
        } else if (i2 == a.A) {
            int i3 = aVar.f48684d;
            if (i3 == a.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f48690a.l) || k.isEmpty(this.f48690a.k)) {
                    return;
                }
                b(this.f48690a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i3 != a.E || k.isEmpty(aVar.k)) {
            } else {
                b(this.f48690a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i2 != a.B || TextUtils.isEmpty(aVar.f48685e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            a aVar2 = this.f48690a;
            completeTaskToastData.activityId = aVar2.f48681a;
            completeTaskToastData.missionId = aVar2.f48682b;
            completeTaskToastData.duration = aVar2.f48689i;
            completeTaskToastData.message = aVar2.f48685e;
            completeTaskToastData.url = aVar2.k;
            completeTaskToastData.pageId = d.a.m0.a.c.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            h.i(competeTaskEvent);
            a aVar3 = this.f48690a;
            c.c(aVar3.f48681a, aVar3.f48682b);
        }
    }
}
