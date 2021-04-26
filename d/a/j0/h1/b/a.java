package d.a.j0.h1.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f54789a;

    /* renamed from: b  reason: collision with root package name */
    public String f54790b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54791c;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo == null) {
            return;
        }
        this.f54789a = responseTagInfo.tag_id.intValue();
        this.f54790b = responseTagInfo.tag_name;
        this.f54791c = responseTagInfo.is_followed.intValue() == 1;
    }
}
