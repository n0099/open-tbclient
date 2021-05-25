package d.a.n0.e3;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public int f54137a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f54138b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54139c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f54140d = null;

    public String a() {
        return this.f54140d;
    }

    public int b() {
        return this.f54137a;
    }

    public void c(StarInfo starInfo) {
        if (starInfo == null) {
            return;
        }
        int intValue = starInfo.has_frs_star.intValue();
        this.f54137a = intValue;
        if (intValue == 1) {
            String str = starInfo.top;
            String str2 = starInfo.head;
            Fans fans = starInfo.fans;
            if (fans != null) {
                fans.is_get.intValue();
                fans.num.intValue();
                fans.open.intValue();
                this.f54138b = fans.left_time.intValue();
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
        this.f54139c = z;
        if (z) {
            Integer num = starInfo.trade.time;
            if (num != null) {
                num.intValue();
            }
            String str3 = starInfo.trade.url;
        }
        this.f54140d = starInfo.star_forum_headimg;
    }
}
