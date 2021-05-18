package d.a.k0.i0.k.c;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f55837a;

    /* renamed from: b  reason: collision with root package name */
    public String f55838b;

    /* renamed from: c  reason: collision with root package name */
    public String f55839c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55840d;

    /* renamed from: e  reason: collision with root package name */
    public String f55841e;

    public void a(TestInfo testInfo) {
        if (testInfo == null) {
            return;
        }
        this.f55837a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f55838b = str;
        this.f55839c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f55840d = testInfo.answered.intValue() == 1;
        this.f55841e = testInfo.result_img;
    }
}
