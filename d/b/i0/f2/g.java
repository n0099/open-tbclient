package d.b.i0.f2;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f55978a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f55979a;

        /* renamed from: b  reason: collision with root package name */
        public long f55980b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55981c;

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo == null) {
                return;
            }
            this.f55979a = ucCardInfo.title;
            String str = ucCardInfo.pic;
            String str2 = ucCardInfo.jmp;
            String str3 = ucCardInfo.tip;
            this.f55980b = ucCardInfo.st.intValue();
        }
    }

    public void a(UcCard ucCard) {
        if (ucCard == null) {
            return;
        }
        String str = ucCard.name;
        String str2 = ucCard.icon;
        String str3 = ucCard.doc;
        String str4 = ucCard.jmp;
        this.f55978a = new ArrayList();
        List<UcCardInfo> list = ucCard.uc_cards;
        if (list != null) {
            for (UcCardInfo ucCardInfo : list) {
                if (ucCardInfo != null) {
                    a aVar = new a();
                    aVar.a(ucCardInfo);
                    this.f55978a.add(aVar);
                }
            }
        }
    }
}
