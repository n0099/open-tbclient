package d.b.j0.d3;

import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f55306a;

    /* renamed from: b  reason: collision with root package name */
    public int f55307b;

    public String a() {
        return this.f55306a;
    }

    public boolean b() {
        return this.f55307b == 1;
    }

    public void c(BusinessPromotCommentList businessPromotCommentList) {
        if (businessPromotCommentList == null) {
            return;
        }
        this.f55306a = businessPromotCommentList.title;
        String str = businessPromotCommentList.username;
        businessPromotCommentList.uid.longValue();
        this.f55307b = businessPromotCommentList.is_lz.intValue();
    }
}
