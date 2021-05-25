package d.a.n0.g2.i;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f55194a;

    /* renamed from: b  reason: collision with root package name */
    public int f55195b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f55196c;

    /* renamed from: d  reason: collision with root package name */
    public String f55197d;

    /* renamed from: e  reason: collision with root package name */
    public String f55198e;

    /* renamed from: f  reason: collision with root package name */
    public String f55199f;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack == null) {
            return;
        }
        this.f55194a = tbBookrack.booktown;
        this.f55195b = tbBookrack.num.intValue();
        this.f55197d = tbBookrack.title;
        this.f55198e = tbBookrack.icon;
        this.f55199f = tbBookrack.tip;
        this.f55196c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f55196c.add(bVar);
                }
            }
        }
    }
}
