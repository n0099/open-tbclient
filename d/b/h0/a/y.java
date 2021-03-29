package d.b.h0.a;

import tbclient.GetToken.DataRes;
import tbclient.GetToken.ToastInfo;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public String f49657a;

    /* renamed from: b  reason: collision with root package name */
    public String f49658b;

    /* renamed from: c  reason: collision with root package name */
    public a f49659c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49660a;
    }

    public String a() {
        return this.f49657a;
    }

    public a b() {
        return this.f49659c;
    }

    public String c() {
        return this.f49658b;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f49657a = dataRes.title;
        String str = dataRes.img;
        String str2 = dataRes.tips;
        this.f49658b = dataRes.url;
        String str3 = dataRes.btn_sure;
        String str4 = dataRes.btn_cancel;
        if (dataRes.activity_done != null) {
            a aVar = new a();
            this.f49659c = aVar;
            ToastInfo toastInfo = dataRes.activity_done;
            String str5 = toastInfo.url;
            aVar.f49660a = toastInfo.btntext;
            String str6 = toastInfo.message;
            String str7 = toastInfo.sharetoken;
        }
    }
}
