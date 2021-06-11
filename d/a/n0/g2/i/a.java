package d.a.n0.g2.i;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f58883a;

    /* renamed from: b  reason: collision with root package name */
    public int f58884b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f58885c;

    /* renamed from: d  reason: collision with root package name */
    public String f58886d;

    /* renamed from: e  reason: collision with root package name */
    public String f58887e;

    /* renamed from: f  reason: collision with root package name */
    public String f58888f;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack == null) {
            return;
        }
        this.f58883a = tbBookrack.booktown;
        this.f58884b = tbBookrack.num.intValue();
        this.f58886d = tbBookrack.title;
        this.f58887e = tbBookrack.icon;
        this.f58888f = tbBookrack.tip;
        this.f58885c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f58885c.add(bVar);
                }
            }
        }
    }
}
