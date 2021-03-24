package d.b.i0.e2.i;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f54548a;

    /* renamed from: b  reason: collision with root package name */
    public int f54549b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f54550c;

    /* renamed from: d  reason: collision with root package name */
    public String f54551d;

    /* renamed from: e  reason: collision with root package name */
    public String f54552e;

    /* renamed from: f  reason: collision with root package name */
    public String f54553f;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack == null) {
            return;
        }
        this.f54548a = tbBookrack.booktown;
        this.f54549b = tbBookrack.num.intValue();
        this.f54551d = tbBookrack.title;
        this.f54552e = tbBookrack.icon;
        this.f54553f = tbBookrack.tip;
        this.f54550c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f54550c.add(bVar);
                }
            }
        }
    }
}
