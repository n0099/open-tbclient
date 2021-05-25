package d.a.n0.i1.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f55684a;

    /* renamed from: b  reason: collision with root package name */
    public String f55685b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55686c;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo == null) {
            return;
        }
        this.f55684a = responseTagInfo.tag_id.intValue();
        this.f55685b = responseTagInfo.tag_name;
        this.f55686c = responseTagInfo.is_followed.intValue() == 1;
    }
}
