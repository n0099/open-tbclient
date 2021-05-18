package d.a.k0.d3;

import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f53852a;

    /* renamed from: b  reason: collision with root package name */
    public int f53853b;

    public String a() {
        return this.f53852a;
    }

    public boolean b() {
        return this.f53853b == 1;
    }

    public void c(BusinessPromotCommentList businessPromotCommentList) {
        if (businessPromotCommentList == null) {
            return;
        }
        this.f53852a = businessPromotCommentList.title;
        String str = businessPromotCommentList.username;
        businessPromotCommentList.uid.longValue();
        this.f53853b = businessPromotCommentList.is_lz.intValue();
    }
}
