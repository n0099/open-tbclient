package d.b.j0.f2.i;

import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56411a;

    /* renamed from: b  reason: collision with root package name */
    public int f56412b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f56413c;

    /* renamed from: d  reason: collision with root package name */
    public String f56414d;

    /* renamed from: e  reason: collision with root package name */
    public String f56415e;

    /* renamed from: f  reason: collision with root package name */
    public String f56416f;

    public void a(TbBookrack tbBookrack) {
        if (tbBookrack == null) {
            return;
        }
        this.f56411a = tbBookrack.booktown;
        this.f56412b = tbBookrack.num.intValue();
        this.f56414d = tbBookrack.title;
        this.f56415e = tbBookrack.icon;
        this.f56416f = tbBookrack.tip;
        this.f56413c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f56413c.add(bVar);
                }
            }
        }
    }
}
