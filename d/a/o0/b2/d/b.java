package d.a.o0.b2.d;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes5.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public long f55884e;

    /* renamed from: f  reason: collision with root package name */
    public int f55885f;

    /* renamed from: g  reason: collision with root package name */
    public String f55886g;

    /* renamed from: h  reason: collision with root package name */
    public String f55887h;

    /* renamed from: i  reason: collision with root package name */
    public long f55888i;
    public String j;
    public int k;

    public b(@NonNull NewTopicList newTopicList, int i2) {
        this.f55885f = i2 + 1;
        this.f55886g = newTopicList.topic_name;
        this.f55887h = newTopicList.topic_desc;
        this.f55888i = newTopicList.discuss_num.longValue();
        this.j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f55884e = newTopicList.topic_id.longValue();
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return a.f55883a;
    }
}
