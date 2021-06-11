package d.a.m0.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static View.OnClickListener f52455a = new a();

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> d2;
            Object tag = view.getTag();
            if (tag instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                if (TextUtils.isEmpty(completeTaskToastData.url) || (d2 = t.d()) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(d2, new String[]{completeTaskToastData.url});
                d.a.m0.a.e0.c.b(completeTaskToastData.activityId, completeTaskToastData.missionId);
            }
        }
    }

    public static void a(MotionEvent motionEvent, int i2, long j) {
        if (motionEvent == null || motionEvent.getAction() != 0) {
            return;
        }
        g(i2, j);
    }

    public static void b(int i2, int i3, long j, String str) {
        MissionEvent missionEvent = new MissionEvent();
        missionEvent.tid = j;
        missionEvent.pageId = i3;
        missionEvent.pageType = i2;
        missionEvent.actionType = str;
        d.a.m0.f0.h.i(missionEvent);
    }

    public static void c(int i2, long j, String str) {
        MissionEvent missionEvent = new MissionEvent();
        missionEvent.tid = j;
        missionEvent.pageId = i2;
        missionEvent.actionType = str;
        d.a.m0.f0.h.i(missionEvent);
    }

    public static TbPageContext d() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof BaseActivity) {
            return ((BaseActivity) currentActivity).getPageContext();
        }
        if (currentActivity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) currentActivity).getPageContext();
        }
        return null;
    }

    public static boolean e() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public static void f(int i2, long j) {
        if (e()) {
            d.y().E();
        } else {
            c(i2, j, MissionEvent.MESSAGE_PAUSE);
        }
    }

    public static void g(int i2, long j) {
        if (e()) {
            d.y().F();
        } else {
            c(i2, j, MissionEvent.MESSAGE_TOUCH);
        }
    }

    public static void h(int i2, long j) {
        if (e()) {
            d.y().K(i2, j);
        } else {
            c(i2, j, MissionEvent.MESSAGE_ACTIVITY);
        }
    }

    public static d.a.m0.r.s.g i(CompleteTaskToastData completeTaskToastData) {
        TbPageContext d2;
        if (completeTaskToastData == null || (d2 = d()) == null || d2.getUniqueId() == null || completeTaskToastData.pageId != d2.getUniqueId().getId()) {
            return null;
        }
        d.a.m0.r.s.g f2 = d.a.m0.r.s.g.f(d2.getPageActivity(), completeTaskToastData.message);
        f2.g(completeTaskToastData.duration);
        f2.h(f52455a);
        f2.i(completeTaskToastData);
        f2.j();
        return f2;
    }

    public static void j(int i2, int i3, long j) {
        if (e()) {
            d.y().P(i2, j);
        } else {
            b(i2, i3, j, MissionEvent.MESSAGE_RESUME);
        }
    }
}
