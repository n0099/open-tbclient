package d.a.j0.f2;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f54287a;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f54288a;

        /* renamed from: b  reason: collision with root package name */
        public long f54289b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f54290c;

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo == null) {
                return;
            }
            this.f54288a = ucCardInfo.title;
            String str = ucCardInfo.pic;
            String str2 = ucCardInfo.jmp;
            String str3 = ucCardInfo.tip;
            this.f54289b = ucCardInfo.st.intValue();
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
        this.f54287a = new ArrayList();
        List<UcCardInfo> list = ucCard.uc_cards;
        if (list != null) {
            for (UcCardInfo ucCardInfo : list) {
                if (ucCardInfo != null) {
                    a aVar = new a();
                    aVar.a(ucCardInfo);
                    this.f54287a.add(aVar);
                }
            }
        }
    }
}
