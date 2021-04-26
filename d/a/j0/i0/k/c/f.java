package d.a.j0.i0.k.c;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f55130a;

    /* renamed from: b  reason: collision with root package name */
    public String f55131b;

    /* renamed from: c  reason: collision with root package name */
    public String f55132c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55133d;

    /* renamed from: e  reason: collision with root package name */
    public String f55134e;

    public void a(TestInfo testInfo) {
        if (testInfo == null) {
            return;
        }
        this.f55130a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f55131b = str;
        this.f55132c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f55133d = testInfo.answered.intValue() == 1;
        this.f55134e = testInfo.result_img;
    }
}
