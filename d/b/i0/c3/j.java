package d.b.i0.c3;

import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f53441a;

    /* renamed from: b  reason: collision with root package name */
    public int f53442b;

    public String a() {
        return this.f53441a;
    }

    public boolean b() {
        return this.f53442b == 1;
    }

    public void c(BusinessPromotCommentList businessPromotCommentList) {
        if (businessPromotCommentList == null) {
            return;
        }
        this.f53441a = businessPromotCommentList.title;
        String str = businessPromotCommentList.username;
        businessPromotCommentList.uid.longValue();
        this.f53442b = businessPromotCommentList.is_lz.intValue();
    }
}
