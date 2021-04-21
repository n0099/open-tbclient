package d.b.j0.d3;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public int f55376a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f55377b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55378c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f55379d = null;

    public String a() {
        return this.f55379d;
    }

    public int b() {
        return this.f55376a;
    }

    public void c(StarInfo starInfo) {
        if (starInfo == null) {
            return;
        }
        int intValue = starInfo.has_frs_star.intValue();
        this.f55376a = intValue;
        if (intValue == 1) {
            String str = starInfo.top;
            String str2 = starInfo.head;
            Fans fans = starInfo.fans;
            if (fans != null) {
                fans.is_get.intValue();
                fans.num.intValue();
                fans.open.intValue();
                this.f55377b = fans.left_time.intValue();
            }
            Size size = starInfo.top_size;
            if (size != null) {
                size.width.intValue();
                size.height.intValue();
            }
            Size size2 = starInfo.head_size;
            if (size2 != null) {
                size2.width.intValue();
                size2.height.intValue();
            }
        }
        boolean z = starInfo.trade != null;
        this.f55378c = z;
        if (z) {
            Integer num = starInfo.trade.time;
            if (num != null) {
                num.intValue();
            }
            String str3 = starInfo.trade.url;
        }
        this.f55379d = starInfo.star_forum_headimg;
    }
}
