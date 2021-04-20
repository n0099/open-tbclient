package d.b.i0.h1.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f56458a;

    /* renamed from: b  reason: collision with root package name */
    public String f56459b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56460c;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo == null) {
            return;
        }
        this.f56458a = responseTagInfo.tag_id.intValue();
        this.f56459b = responseTagInfo.tag_name;
        this.f56460c = responseTagInfo.is_followed.intValue() == 1;
    }
}
