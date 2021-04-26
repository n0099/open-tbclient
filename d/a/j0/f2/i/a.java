package d.a.j0.f2.i;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f54299a;

    /* renamed from: b  reason: collision with root package name */
    public int f54300b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f54301c;

    /* renamed from: d  reason: collision with root package name */
    public String f54302d;

    /* renamed from: e  reason: collision with root package name */
    public String f54303e;

    /* renamed from: f  reason: collision with root package name */
    public String f54304f;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack == null) {
            return;
        }
        this.f54299a = tbBookrack.booktown;
        this.f54300b = tbBookrack.num.intValue();
        this.f54302d = tbBookrack.title;
        this.f54303e = tbBookrack.icon;
        this.f54304f = tbBookrack.tip;
        this.f54301c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f54301c.add(bVar);
                }
            }
        }
    }
}
