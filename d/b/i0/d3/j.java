package d.b.i0.d3;

import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f54885a;

    /* renamed from: b  reason: collision with root package name */
    public int f54886b;

    public String a() {
        return this.f54885a;
    }

    public boolean b() {
        return this.f54886b == 1;
    }

    public void c(BusinessPromotCommentList businessPromotCommentList) {
        if (businessPromotCommentList == null) {
            return;
        }
        this.f54885a = businessPromotCommentList.title;
        String str = businessPromotCommentList.username;
        businessPromotCommentList.uid.longValue();
        this.f54886b = businessPromotCommentList.is_lz.intValue();
    }
}
