package d.b.i0.g1.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f54922a;

    /* renamed from: b  reason: collision with root package name */
    public String f54923b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54924c;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo == null) {
            return;
        }
        this.f54922a = responseTagInfo.tag_id.intValue();
        this.f54923b = responseTagInfo.tag_name;
        this.f54924c = responseTagInfo.is_followed.intValue() == 1;
    }
}
