package d.b.i0.f2.i;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f55990a;

    /* renamed from: b  reason: collision with root package name */
    public int f55991b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f55992c;

    /* renamed from: d  reason: collision with root package name */
    public String f55993d;

    /* renamed from: e  reason: collision with root package name */
    public String f55994e;

    /* renamed from: f  reason: collision with root package name */
    public String f55995f;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack == null) {
            return;
        }
        this.f55990a = tbBookrack.booktown;
        this.f55991b = tbBookrack.num.intValue();
        this.f55993d = tbBookrack.title;
        this.f55994e = tbBookrack.icon;
        this.f55995f = tbBookrack.tip;
        this.f55992c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f55992c.add(bVar);
                }
            }
        }
    }
}
