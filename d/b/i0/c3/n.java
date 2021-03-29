package d.b.i0.c3;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public int f53511a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f53512b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53513c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f53514d = null;

    public String a() {
        return this.f53514d;
    }

    public int b() {
        return this.f53511a;
    }

    public void c(StarInfo starInfo) {
        if (starInfo == null) {
            return;
        }
        int intValue = starInfo.has_frs_star.intValue();
        this.f53511a = intValue;
        if (intValue == 1) {
            String str = starInfo.top;
            String str2 = starInfo.head;
            Fans fans = starInfo.fans;
            if (fans != null) {
                fans.is_get.intValue();
                fans.num.intValue();
                fans.open.intValue();
                this.f53512b = fans.left_time.intValue();
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
        this.f53513c = z;
        if (z) {
            Integer num = starInfo.trade.time;
            if (num != null) {
                num.intValue();
            }
            String str3 = starInfo.trade.url;
        }
        this.f53514d = starInfo.star_forum_headimg;
    }
}
