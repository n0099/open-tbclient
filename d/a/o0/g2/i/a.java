package d.a.o0.g2.i;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f59008a;

    /* renamed from: b  reason: collision with root package name */
    public int f59009b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f59010c;

    /* renamed from: d  reason: collision with root package name */
    public String f59011d;

    /* renamed from: e  reason: collision with root package name */
    public String f59012e;

    /* renamed from: f  reason: collision with root package name */
    public String f59013f;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack == null) {
            return;
        }
        this.f59008a = tbBookrack.booktown;
        this.f59009b = tbBookrack.num.intValue();
        this.f59011d = tbBookrack.title;
        this.f59012e = tbBookrack.icon;
        this.f59013f = tbBookrack.tip;
        this.f59010c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f59010c.add(bVar);
                }
            }
        }
    }
}
