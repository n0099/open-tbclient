package d.b.j0.h1.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f56879a;

    /* renamed from: b  reason: collision with root package name */
    public String f56880b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56881c;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo == null) {
            return;
        }
        this.f56879a = responseTagInfo.tag_id.intValue();
        this.f56880b = responseTagInfo.tag_name;
        this.f56881c = responseTagInfo.is_followed.intValue() == 1;
    }
}
