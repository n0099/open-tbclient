package d.b.j0.a2.d;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes3.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public long f53475e;

    /* renamed from: f  reason: collision with root package name */
    public int f53476f;

    /* renamed from: g  reason: collision with root package name */
    public String f53477g;

    /* renamed from: h  reason: collision with root package name */
    public String f53478h;
    public long i;
    public String j;
    public int k;

    public b(@NonNull NewTopicList newTopicList, int i) {
        this.f53476f = i + 1;
        this.f53477g = newTopicList.topic_name;
        this.f53478h = newTopicList.topic_desc;
        this.i = newTopicList.discuss_num.longValue();
        this.j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f53475e = newTopicList.topic_id.longValue();
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return a.f53474a;
    }
}
