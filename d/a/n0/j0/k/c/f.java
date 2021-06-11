package d.a.n0.j0.k.c;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f59710a;

    /* renamed from: b  reason: collision with root package name */
    public String f59711b;

    /* renamed from: c  reason: collision with root package name */
    public String f59712c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59713d;

    /* renamed from: e  reason: collision with root package name */
    public String f59714e;

    public void a(TestInfo testInfo) {
        if (testInfo == null) {
            return;
        }
        this.f59710a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f59711b = str;
        this.f59712c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f59713d = testInfo.answered.intValue() == 1;
        this.f59714e = testInfo.result_img;
    }
}
