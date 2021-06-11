package d.a.n0.i1.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f59373a;

    /* renamed from: b  reason: collision with root package name */
    public String f59374b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59375c;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo == null) {
            return;
        }
        this.f59373a = responseTagInfo.tag_id.intValue();
        this.f59374b = responseTagInfo.tag_name;
        this.f59375c = responseTagInfo.is_followed.intValue() == 1;
    }
}
