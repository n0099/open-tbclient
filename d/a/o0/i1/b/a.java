package d.a.o0.i1.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f59498a;

    /* renamed from: b  reason: collision with root package name */
    public String f59499b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59500c;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo == null) {
            return;
        }
        this.f59498a = responseTagInfo.tag_id.intValue();
        this.f59499b = responseTagInfo.tag_name;
        this.f59500c = responseTagInfo.is_followed.intValue() == 1;
    }
}
