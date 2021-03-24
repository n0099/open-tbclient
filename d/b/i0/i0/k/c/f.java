package d.b.i0.i0.k.c;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f55654a;

    /* renamed from: b  reason: collision with root package name */
    public String f55655b;

    /* renamed from: c  reason: collision with root package name */
    public String f55656c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55657d;

    /* renamed from: e  reason: collision with root package name */
    public String f55658e;

    public void a(TestInfo testInfo) {
        if (testInfo == null) {
            return;
        }
        this.f55654a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f55655b = str;
        this.f55656c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f55657d = testInfo.answered.intValue() == 1;
        this.f55658e = testInfo.result_img;
    }
}
