package d.a.i0.a.b0;

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
import d.a.i0.f0.h;
import d.a.i0.r.s.i;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f47794a;

    /* renamed from: b  reason: collision with root package name */
    public i f47795b;

    public void a() {
        i iVar = this.f47795b;
        if (iVar != null) {
            iVar.f();
            this.f47795b = null;
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
        this.f47794a = aVar;
    }

    public void e() {
        a aVar = this.f47794a;
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f47787c;
        if (i2 == a.C) {
            i h2 = i.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.f47794a);
            h2.j();
            this.f47795b = h2;
        } else if (i2 == a.D) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            d.a.i0.r.o.c cVar = new d.a.i0.r.o.c(currentActivity);
            cVar.d(currentActivity, this.f47794a);
            cVar.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.i0.r.o.b b2 = d.a.i0.r.o.b.b();
            d.a.i0.r.o.b b3 = d.a.i0.r.o.b.b();
            b3.i("business_count_hint" + currentAccount + this.f47794a.f47785a, b2.c("business_count_hint" + currentAccount + this.f47794a.f47785a) - 1);
        } else if (i2 == a.E) {
            int i3 = aVar.f47788d;
            if (i3 == a.H) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f47794a.l) || k.isEmpty(this.f47794a.k)) {
                    return;
                }
                b(this.f47794a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i3 != a.I || k.isEmpty(aVar.k)) {
            } else {
                b(this.f47794a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i2 != a.F || TextUtils.isEmpty(aVar.f47789e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            a aVar2 = this.f47794a;
            completeTaskToastData.activityId = aVar2.f47785a;
            completeTaskToastData.missionId = aVar2.f47786b;
            completeTaskToastData.duration = aVar2.f47793i;
            completeTaskToastData.message = aVar2.f47789e;
            completeTaskToastData.url = aVar2.k;
            completeTaskToastData.pageId = d.a.i0.a.c.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            h.i(competeTaskEvent);
            a aVar3 = this.f47794a;
            c.c(aVar3.f47785a, aVar3.f47786b);
        }
    }
}
