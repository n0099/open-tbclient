package d.b.h0.a;

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
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static View.OnClickListener f49636a = new a();

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> d2;
            Object tag = view.getTag();
            if (tag instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                if (TextUtils.isEmpty(completeTaskToastData.url) || (d2 = r.d()) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(d2, new String[]{completeTaskToastData.url});
                d.b.h0.a.b0.c.b(completeTaskToastData.activityId, completeTaskToastData.missionId);
            }
        }
    }

    public static void a(MotionEvent motionEvent, int i, long j) {
        if (motionEvent == null || motionEvent.getAction() != 0) {
            return;
        }
        g(i, j);
    }

    public static void b(int i, int i2, long j, String str) {
        MissionEvent missionEvent = new MissionEvent();
        missionEvent.tid = j;
        missionEvent.pageId = i2;
        missionEvent.pageType = i;
        missionEvent.actionType = str;
        d.b.h0.f0.g.g(missionEvent);
    }

    public static void c(int i, long j, String str) {
        MissionEvent missionEvent = new MissionEvent();
        missionEvent.tid = j;
        missionEvent.pageId = i;
        missionEvent.actionType = str;
        d.b.h0.f0.g.g(missionEvent);
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

    public static void f(int i, long j) {
        if (e()) {
            c.y().E();
        } else {
            c(i, j, MissionEvent.MESSAGE_PAUSE);
        }
    }

    public static void g(int i, long j) {
        if (e()) {
            c.y().F();
        } else {
            c(i, j, MissionEvent.MESSAGE_TOUCH);
        }
    }

    public static void h(int i, long j) {
        if (e()) {
            c.y().K(i, j);
        } else {
            c(i, j, MissionEvent.MESSAGE_ACTIVITY);
        }
    }

    public static d.b.h0.r.s.g i(CompleteTaskToastData completeTaskToastData) {
        TbPageContext d2;
        if (completeTaskToastData == null || (d2 = d()) == null || d2.getUniqueId() == null || completeTaskToastData.pageId != d2.getUniqueId().getId()) {
            return null;
        }
        d.b.h0.r.s.g f2 = d.b.h0.r.s.g.f(d2.getPageActivity(), completeTaskToastData.message);
        f2.g(completeTaskToastData.duration);
        f2.h(f49636a);
        f2.i(completeTaskToastData);
        f2.j();
        return f2;
    }

    public static void j(int i, int i2, long j) {
        if (e()) {
            c.y().P(i, j);
        } else {
            b(i, i2, j, MissionEvent.MESSAGE_RESUME);
        }
    }
}
