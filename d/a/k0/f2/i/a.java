package d.a.k0.f2.i;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f55006a;

    /* renamed from: b  reason: collision with root package name */
    public int f55007b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f55008c;

    /* renamed from: d  reason: collision with root package name */
    public String f55009d;

    /* renamed from: e  reason: collision with root package name */
    public String f55010e;

    /* renamed from: f  reason: collision with root package name */
    public String f55011f;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack == null) {
            return;
        }
        this.f55006a = tbBookrack.booktown;
        this.f55007b = tbBookrack.num.intValue();
        this.f55009d = tbBookrack.title;
        this.f55010e = tbBookrack.icon;
        this.f55011f = tbBookrack.tip;
        this.f55008c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f55008c.add(bVar);
                }
            }
        }
    }
}
