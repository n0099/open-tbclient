package d.a.n0.g2;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f58871a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f58872a;

        /* renamed from: b  reason: collision with root package name */
        public long f58873b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f58874c;

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo == null) {
                return;
            }
            this.f58872a = ucCardInfo.title;
            String str = ucCardInfo.pic;
            String str2 = ucCardInfo.jmp;
            String str3 = ucCardInfo.tip;
            this.f58873b = ucCardInfo.st.intValue();
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
        this.f58871a = new ArrayList();
        List<UcCardInfo> list = ucCard.uc_cards;
        if (list != null) {
            for (UcCardInfo ucCardInfo : list) {
                if (ucCardInfo != null) {
                    a aVar = new a();
                    aVar.a(ucCardInfo);
                    this.f58871a.add(aVar);
                }
            }
        }
    }
}
