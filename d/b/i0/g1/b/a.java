package d.b.i0.g1.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f54921a;

    /* renamed from: b  reason: collision with root package name */
    public String f54922b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54923c;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo == null) {
            return;
        }
        this.f54921a = responseTagInfo.tag_id.intValue();
        this.f54922b = responseTagInfo.tag_name;
        this.f54923c = responseTagInfo.is_followed.intValue() == 1;
    }
}
