package d.b.i0.e2.i;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f54549a;

    /* renamed from: b  reason: collision with root package name */
    public int f54550b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f54551c;

    /* renamed from: d  reason: collision with root package name */
    public String f54552d;

    /* renamed from: e  reason: collision with root package name */
    public String f54553e;

    /* renamed from: f  reason: collision with root package name */
    public String f54554f;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack == null) {
            return;
        }
        this.f54549a = tbBookrack.booktown;
        this.f54550b = tbBookrack.num.intValue();
        this.f54552d = tbBookrack.title;
        this.f54553e = tbBookrack.icon;
        this.f54554f = tbBookrack.tip;
        this.f54551c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f54551c.add(bVar);
                }
            }
        }
    }
}
