package d.b.h0.a;

import tbclient.GetToken.DataRes;
import tbclient.GetToken.ToastInfo;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public String f50049a;

    /* renamed from: b  reason: collision with root package name */
    public String f50050b;

    /* renamed from: c  reason: collision with root package name */
    public a f50051c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f50052a;
    }

    public String a() {
        return this.f50049a;
    }

    public a b() {
        return this.f50051c;
    }

    public String c() {
        return this.f50050b;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f50049a = dataRes.title;
        String str = dataRes.img;
        String str2 = dataRes.tips;
        this.f50050b = dataRes.url;
        String str3 = dataRes.btn_sure;
        String str4 = dataRes.btn_cancel;
        if (dataRes.activity_done != null) {
            a aVar = new a();
            this.f50051c = aVar;
            ToastInfo toastInfo = dataRes.activity_done;
            String str5 = toastInfo.url;
            aVar.f50052a = toastInfo.btntext;
            String str6 = toastInfo.message;
            String str7 = toastInfo.sharetoken;
        }
    }
}
