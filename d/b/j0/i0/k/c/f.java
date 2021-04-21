package d.b.j0.i0.k.c;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f57199a;

    /* renamed from: b  reason: collision with root package name */
    public String f57200b;

    /* renamed from: c  reason: collision with root package name */
    public String f57201c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57202d;

    /* renamed from: e  reason: collision with root package name */
    public String f57203e;

    public void a(TestInfo testInfo) {
        if (testInfo == null) {
            return;
        }
        this.f57199a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f57200b = str;
        this.f57201c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f57202d = testInfo.answered.intValue() == 1;
        this.f57203e = testInfo.result_img;
    }
}
