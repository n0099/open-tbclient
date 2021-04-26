package d.a.j0.a1.j.a.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f51096a;

    /* renamed from: b  reason: collision with root package name */
    public List<e> f51097b;

    public void a(long j, TimeLine timeLine) {
        Long l;
        if (timeLine == null || ListUtils.isEmpty(timeLine.timeline_info)) {
            return;
        }
        this.f51096a = timeLine.title;
        this.f51097b = new ArrayList();
        int i2 = 0;
        for (TimeLineInfo timeLineInfo : timeLine.timeline_info) {
            if (timeLineInfo != null && (((l = timeLineInfo.tid) != null && l.longValue() != 0) || !TextUtils.isEmpty(timeLineInfo.title) || !TextUtils.isEmpty(timeLineInfo.bg_color) || !TextUtils.isEmpty(timeLineInfo.show_time) || !TextUtils.isEmpty(timeLineInfo.small_title))) {
                e eVar = new e();
                eVar.f51090a = j;
                eVar.f51095f = i2;
                eVar.a(timeLineInfo);
                this.f51097b.add(eVar);
                i2++;
            }
        }
    }
}
