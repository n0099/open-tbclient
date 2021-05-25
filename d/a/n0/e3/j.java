package d.a.n0.e3;

import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f54065a;

    /* renamed from: b  reason: collision with root package name */
    public int f54066b;

    public String a() {
        return this.f54065a;
    }

    public boolean b() {
        return this.f54066b == 1;
    }

    public void c(BusinessPromotCommentList businessPromotCommentList) {
        if (businessPromotCommentList == null) {
            return;
        }
        this.f54065a = businessPromotCommentList.title;
        String str = businessPromotCommentList.username;
        businessPromotCommentList.uid.longValue();
        this.f54066b = businessPromotCommentList.is_lz.intValue();
    }
}
