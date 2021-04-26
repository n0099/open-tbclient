package d.a.i0.a;

import tbclient.GetToken.DataRes;
import tbclient.GetToken.ToastInfo;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public String f47939a;

    /* renamed from: b  reason: collision with root package name */
    public String f47940b;

    /* renamed from: c  reason: collision with root package name */
    public a f47941c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f47942a;
    }

    public String a() {
        return this.f47939a;
    }

    public a b() {
        return this.f47941c;
    }

    public String c() {
        return this.f47940b;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f47939a = dataRes.title;
        String str = dataRes.img;
        String str2 = dataRes.tips;
        this.f47940b = dataRes.url;
        String str3 = dataRes.btn_sure;
        String str4 = dataRes.btn_cancel;
        if (dataRes.activity_done != null) {
            a aVar = new a();
            this.f47941c = aVar;
            ToastInfo toastInfo = dataRes.activity_done;
            String str5 = toastInfo.url;
            aVar.f47942a = toastInfo.btntext;
            String str6 = toastInfo.message;
            String str7 = toastInfo.sharetoken;
        }
    }
}
