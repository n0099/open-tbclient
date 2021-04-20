package d.b.i0.a2.d;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes3.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public long f53054e;

    /* renamed from: f  reason: collision with root package name */
    public int f53055f;

    /* renamed from: g  reason: collision with root package name */
    public String f53056g;

    /* renamed from: h  reason: collision with root package name */
    public String f53057h;
    public long i;
    public String j;
    public int k;

    public b(@NonNull NewTopicList newTopicList, int i) {
        this.f53055f = i + 1;
        this.f53056g = newTopicList.topic_name;
        this.f53057h = newTopicList.topic_desc;
        this.i = newTopicList.discuss_num.longValue();
        this.j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f53054e = newTopicList.topic_id.longValue();
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return a.f53053a;
    }
}
