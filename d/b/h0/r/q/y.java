package d.b.h0.r.q;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public String f50934a;

    /* renamed from: b  reason: collision with root package name */
    public int f50935b;

    public String a() {
        return this.f50934a;
    }

    public int b() {
        return this.f50935b;
    }

    public void c(ForumBookInfo forumBookInfo) {
        if (forumBookInfo == null) {
            return;
        }
        this.f50934a = forumBookInfo.book_id;
        this.f50935b = forumBookInfo.book_type.intValue();
        String str = forumBookInfo.book_title;
        String str2 = forumBookInfo.book_cover;
        String str3 = forumBookInfo.author;
        String str4 = forumBookInfo.forum_pic;
        String str5 = forumBookInfo.show_chapter_id;
        String str6 = forumBookInfo.show_chapter_no;
        String str7 = forumBookInfo.show_chapter_title;
        forumBookInfo.history_page_id.longValue();
        forumBookInfo.history_paragraph_id.longValue();
        forumBookInfo.history_word_id.longValue();
        forumBookInfo.history_percent.longValue();
        forumBookInfo.show_page_id.longValue();
        forumBookInfo.show_paragraph_id.longValue();
    }
}
