package d.a.m0.a;

import tbclient.GetToken.DataRes;
import tbclient.GetToken.ToastInfo;
/* loaded from: classes3.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public String f48607a;

    /* renamed from: b  reason: collision with root package name */
    public String f48608b;

    /* renamed from: c  reason: collision with root package name */
    public a f48609c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f48610a;
    }

    public String a() {
        return this.f48607a;
    }

    public a b() {
        return this.f48609c;
    }

    public String c() {
        return this.f48608b;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f48607a = dataRes.title;
        String str = dataRes.img;
        String str2 = dataRes.tips;
        this.f48608b = dataRes.url;
        String str3 = dataRes.btn_sure;
        String str4 = dataRes.btn_cancel;
        if (dataRes.activity_done != null) {
            a aVar = new a();
            this.f48609c = aVar;
            ToastInfo toastInfo = dataRes.activity_done;
            String str5 = toastInfo.url;
            aVar.f48610a = toastInfo.btntext;
            String str6 = toastInfo.message;
            String str7 = toastInfo.sharetoken;
        }
    }
}
