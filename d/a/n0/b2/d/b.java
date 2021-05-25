package d.a.n0.b2.d;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public long f52070e;

    /* renamed from: f  reason: collision with root package name */
    public int f52071f;

    /* renamed from: g  reason: collision with root package name */
    public String f52072g;

    /* renamed from: h  reason: collision with root package name */
    public String f52073h;

    /* renamed from: i  reason: collision with root package name */
    public long f52074i;
    public String j;
    public int k;

    public b(@NonNull NewTopicList newTopicList, int i2) {
        this.f52071f = i2 + 1;
        this.f52072g = newTopicList.topic_name;
        this.f52073h = newTopicList.topic_desc;
        this.f52074i = newTopicList.discuss_num.longValue();
        this.j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f52070e = newTopicList.topic_id.longValue();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return a.f52069a;
    }
}
