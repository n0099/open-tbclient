package d.a.m0.a.e0;

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
    public a f52366a;

    /* renamed from: b  reason: collision with root package name */
    public i f52367b;

    public void a() {
        i iVar = this.f52367b;
        if (iVar != null) {
            iVar.f();
            this.f52367b = null;
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
        this.f52366a = aVar;
    }

    public void e() {
        a aVar = this.f52366a;
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f52359c;
        if (i2 == a.y) {
            i i3 = i.i(TbadkCoreApplication.getInst().getCurrentActivity(), this.f52366a);
            i3.k();
            this.f52367b = i3;
        } else if (i2 == a.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            d.a.m0.r.o.b bVar = new d.a.m0.r.o.b(currentActivity);
            bVar.d(currentActivity, this.f52366a);
            bVar.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.m0.r.o.a b2 = d.a.m0.r.o.a.b();
            d.a.m0.r.o.a b3 = d.a.m0.r.o.a.b();
            b3.i("business_count_hint" + currentAccount + this.f52366a.f52357a, b2.c("business_count_hint" + currentAccount + this.f52366a.f52357a) - 1);
        } else if (i2 == a.A) {
            int i4 = aVar.f52360d;
            if (i4 == a.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f52366a.l) || k.isEmpty(this.f52366a.k)) {
                    return;
                }
                b(this.f52366a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i4 != a.E || k.isEmpty(aVar.k)) {
            } else {
                b(this.f52366a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i2 != a.B || TextUtils.isEmpty(aVar.f52361e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            a aVar2 = this.f52366a;
            completeTaskToastData.activityId = aVar2.f52357a;
            completeTaskToastData.missionId = aVar2.f52358b;
            completeTaskToastData.duration = aVar2.f52365i;
            completeTaskToastData.message = aVar2.f52361e;
            completeTaskToastData.url = aVar2.k;
            completeTaskToastData.pageId = d.a.m0.a.d.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            h.i(competeTaskEvent);
            a aVar3 = this.f52366a;
            c.c(aVar3.f52357a, aVar3.f52358b);
        }
    }
}
