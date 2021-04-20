package d.b.i0.f2.i;

import tbclient.BookInfo;
/* loaded from: classes3.dex */
public class b {
    public void a(BookInfo bookInfo) {
        if (bookInfo == null) {
            return;
        }
        String str = bookInfo.book_id;
        String str2 = bookInfo.title;
        String str3 = bookInfo.cover;
        bookInfo.update_time.intValue();
        bookInfo.book_type.intValue();
        bookInfo.forum_id.longValue();
        bookInfo.total_chapter.intValue();
    }
}
