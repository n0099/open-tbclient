package d.a.k0.h1.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f55496a;

    /* renamed from: b  reason: collision with root package name */
    public String f55497b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55498c;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo == null) {
            return;
        }
        this.f55496a = responseTagInfo.tag_id.intValue();
        this.f55497b = responseTagInfo.tag_name;
        this.f55498c = responseTagInfo.is_followed.intValue() == 1;
    }
}
