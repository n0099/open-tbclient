package d.a.k0.a2.d;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public long f51903e;

    /* renamed from: f  reason: collision with root package name */
    public int f51904f;

    /* renamed from: g  reason: collision with root package name */
    public String f51905g;

    /* renamed from: h  reason: collision with root package name */
    public String f51906h;

    /* renamed from: i  reason: collision with root package name */
    public long f51907i;
    public String j;
    public int k;

    public b(@NonNull NewTopicList newTopicList, int i2) {
        this.f51904f = i2 + 1;
        this.f51905g = newTopicList.topic_name;
        this.f51906h = newTopicList.topic_desc;
        this.f51907i = newTopicList.discuss_num.longValue();
        this.j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f51903e = newTopicList.topic_id.longValue();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return a.f51902a;
    }
}
