package d.b.i0.z0.j.a.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f63332a;

    /* renamed from: b  reason: collision with root package name */
    public List<e> f63333b;

    public void a(long j, TimeLine timeLine) {
        Long l;
        if (timeLine == null || ListUtils.isEmpty(timeLine.timeline_info)) {
            return;
        }
        this.f63332a = timeLine.title;
        this.f63333b = new ArrayList();
        int i = 0;
        for (TimeLineInfo timeLineInfo : timeLine.timeline_info) {
            if (timeLineInfo != null && (((l = timeLineInfo.tid) != null && l.longValue() != 0) || !TextUtils.isEmpty(timeLineInfo.title) || !TextUtils.isEmpty(timeLineInfo.bg_color) || !TextUtils.isEmpty(timeLineInfo.show_time) || !TextUtils.isEmpty(timeLineInfo.small_title))) {
                e eVar = new e();
                eVar.f63326a = j;
                eVar.f63331f = i;
                eVar.a(timeLineInfo);
                this.f63333b.add(eVar);
                i++;
            }
        }
    }
}
