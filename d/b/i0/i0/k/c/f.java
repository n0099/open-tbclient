package d.b.i0.i0.k.c;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f56778a;

    /* renamed from: b  reason: collision with root package name */
    public String f56779b;

    /* renamed from: c  reason: collision with root package name */
    public String f56780c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56781d;

    /* renamed from: e  reason: collision with root package name */
    public String f56782e;

    public void a(TestInfo testInfo) {
        if (testInfo == null) {
            return;
        }
        this.f56778a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f56779b = str;
        this.f56780c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f56781d = testInfo.answered.intValue() == 1;
        this.f56782e = testInfo.result_img;
    }
}
