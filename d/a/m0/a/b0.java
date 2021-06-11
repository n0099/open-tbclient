package d.a.m0.a;

import tbclient.GetToken.DataRes;
import tbclient.GetToken.ToastInfo;
/* loaded from: classes3.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public String f52283a;

    /* renamed from: b  reason: collision with root package name */
    public String f52284b;

    /* renamed from: c  reason: collision with root package name */
    public a f52285c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f52286a;
    }

    public String a() {
        return this.f52283a;
    }

    public a b() {
        return this.f52285c;
    }

    public String c() {
        return this.f52284b;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f52283a = dataRes.title;
        String str = dataRes.img;
        String str2 = dataRes.tips;
        this.f52284b = dataRes.url;
        String str3 = dataRes.btn_sure;
        String str4 = dataRes.btn_cancel;
        if (dataRes.activity_done != null) {
            a aVar = new a();
            this.f52285c = aVar;
            ToastInfo toastInfo = dataRes.activity_done;
            String str5 = toastInfo.url;
            aVar.f52286a = toastInfo.btntext;
            String str6 = toastInfo.message;
            String str7 = toastInfo.sharetoken;
        }
    }
}
