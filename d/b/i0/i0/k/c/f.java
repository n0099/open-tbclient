package d.b.i0.i0.k.c;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f55655a;

    /* renamed from: b  reason: collision with root package name */
    public String f55656b;

    /* renamed from: c  reason: collision with root package name */
    public String f55657c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55658d;

    /* renamed from: e  reason: collision with root package name */
    public String f55659e;

    public void a(TestInfo testInfo) {
        if (testInfo == null) {
            return;
        }
        this.f55655a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f55656b = str;
        this.f55657c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f55658d = testInfo.answered.intValue() == 1;
        this.f55659e = testInfo.result_img;
    }
}
