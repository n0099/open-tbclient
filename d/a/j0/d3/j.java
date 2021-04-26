package d.a.j0.d3;

import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f53145a;

    /* renamed from: b  reason: collision with root package name */
    public int f53146b;

    public String a() {
        return this.f53145a;
    }

    public boolean b() {
        return this.f53146b == 1;
    }

    public void c(BusinessPromotCommentList businessPromotCommentList) {
        if (businessPromotCommentList == null) {
            return;
        }
        this.f53145a = businessPromotCommentList.title;
        String str = businessPromotCommentList.username;
        businessPromotCommentList.uid.longValue();
        this.f53146b = businessPromotCommentList.is_lz.intValue();
    }
}
