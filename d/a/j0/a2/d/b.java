package d.a.j0.a2.d;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes3.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public long f51204e;

    /* renamed from: f  reason: collision with root package name */
    public int f51205f;

    /* renamed from: g  reason: collision with root package name */
    public String f51206g;

    /* renamed from: h  reason: collision with root package name */
    public String f51207h;

    /* renamed from: i  reason: collision with root package name */
    public long f51208i;
    public String j;
    public int k;

    public b(@NonNull NewTopicList newTopicList, int i2) {
        this.f51205f = i2 + 1;
        this.f51206g = newTopicList.topic_name;
        this.f51207h = newTopicList.topic_desc;
        this.f51208i = newTopicList.discuss_num.longValue();
        this.j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f51204e = newTopicList.topic_id.longValue();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return a.f51203a;
    }
}
