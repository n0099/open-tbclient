package d.b.i0.z1.d;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public long f63434e;

    /* renamed from: f  reason: collision with root package name */
    public int f63435f;

    /* renamed from: g  reason: collision with root package name */
    public String f63436g;

    /* renamed from: h  reason: collision with root package name */
    public String f63437h;
    public long i;
    public String j;
    public int k;

    public b(@NonNull NewTopicList newTopicList, int i) {
        this.f63435f = i + 1;
        this.f63436g = newTopicList.topic_name;
        this.f63437h = newTopicList.topic_desc;
        this.i = newTopicList.discuss_num.longValue();
        this.j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f63434e = newTopicList.topic_id.longValue();
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return a.f63433a;
    }
}
