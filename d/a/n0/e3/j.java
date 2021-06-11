package d.a.n0.e3;

import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f57754a;

    /* renamed from: b  reason: collision with root package name */
    public int f57755b;

    public String a() {
        return this.f57754a;
    }

    public boolean b() {
        return this.f57755b == 1;
    }

    public void c(BusinessPromotCommentList businessPromotCommentList) {
        if (businessPromotCommentList == null) {
            return;
        }
        this.f57754a = businessPromotCommentList.title;
        String str = businessPromotCommentList.username;
        businessPromotCommentList.uid.longValue();
        this.f57755b = businessPromotCommentList.is_lz.intValue();
    }
}
