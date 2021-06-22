package d.a.o0.j0.k.c;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f59835a;

    /* renamed from: b  reason: collision with root package name */
    public String f59836b;

    /* renamed from: c  reason: collision with root package name */
    public String f59837c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59838d;

    /* renamed from: e  reason: collision with root package name */
    public String f59839e;

    public void a(TestInfo testInfo) {
        if (testInfo == null) {
            return;
        }
        this.f59835a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f59836b = str;
        this.f59837c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f59838d = testInfo.answered.intValue() == 1;
        this.f59839e = testInfo.result_img;
    }
}
