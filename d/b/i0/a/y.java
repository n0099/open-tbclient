package d.b.i0.a;

import tbclient.GetToken.DataRes;
import tbclient.GetToken.ToastInfo;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public String f50385a;

    /* renamed from: b  reason: collision with root package name */
    public String f50386b;

    /* renamed from: c  reason: collision with root package name */
    public a f50387c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f50388a;
    }

    public String a() {
        return this.f50385a;
    }

    public a b() {
        return this.f50387c;
    }

    public String c() {
        return this.f50386b;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f50385a = dataRes.title;
        String str = dataRes.img;
        String str2 = dataRes.tips;
        this.f50386b = dataRes.url;
        String str3 = dataRes.btn_sure;
        String str4 = dataRes.btn_cancel;
        if (dataRes.activity_done != null) {
            a aVar = new a();
            this.f50387c = aVar;
            ToastInfo toastInfo = dataRes.activity_done;
            String str5 = toastInfo.url;
            aVar.f50388a = toastInfo.btntext;
            String str6 = toastInfo.message;
            String str7 = toastInfo.sharetoken;
        }
    }
}
