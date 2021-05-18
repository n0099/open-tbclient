package d.a.k0.a1.i.e;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.a.k0.a1.e.a.e.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.HotTopic;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class b extends d {

    /* renamed from: f  reason: collision with root package name */
    public String f51735f = TbadkCoreApplication.getInst().getString(R.string.recommend_user_hot_topic_title);

    public void B(HotTopic hotTopic) {
        if (hotTopic == null) {
            return;
        }
        this.floorPosition = hotTopic.floor_position.intValue();
        parserProtobuf(hotTopic.topic_list);
    }

    public void parserProtobuf(List<RecomTopicList> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        int min = Math.min(list.size(), 4);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(new d.a.k0.a1.e.a.e.c(list.get(i2)));
        }
        A(arrayList);
    }
}
