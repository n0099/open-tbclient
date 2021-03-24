package d.b.h0.a;

import tbclient.GetToken.DataRes;
import tbclient.GetToken.ToastInfo;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public String f49656a;

    /* renamed from: b  reason: collision with root package name */
    public String f49657b;

    /* renamed from: c  reason: collision with root package name */
    public a f49658c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49659a;
    }

    public String a() {
        return this.f49656a;
    }

    public a b() {
        return this.f49658c;
    }

    public String c() {
        return this.f49657b;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f49656a = dataRes.title;
        String str = dataRes.img;
        String str2 = dataRes.tips;
        this.f49657b = dataRes.url;
        String str3 = dataRes.btn_sure;
        String str4 = dataRes.btn_cancel;
        if (dataRes.activity_done != null) {
            a aVar = new a();
            this.f49658c = aVar;
            ToastInfo toastInfo = dataRes.activity_done;
            String str5 = toastInfo.url;
            aVar.f49659a = toastInfo.btntext;
            String str6 = toastInfo.message;
            String str7 = toastInfo.sharetoken;
        }
    }
}
