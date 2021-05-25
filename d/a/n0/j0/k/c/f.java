package d.a.n0.j0.k.c;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f56021a;

    /* renamed from: b  reason: collision with root package name */
    public String f56022b;

    /* renamed from: c  reason: collision with root package name */
    public String f56023c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56024d;

    /* renamed from: e  reason: collision with root package name */
    public String f56025e;

    public void a(TestInfo testInfo) {
        if (testInfo == null) {
            return;
        }
        this.f56021a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f56022b = str;
        this.f56023c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f56024d = testInfo.answered.intValue() == 1;
        this.f56025e = testInfo.result_img;
    }
}
