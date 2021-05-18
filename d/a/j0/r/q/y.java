package d.a.j0.r.q;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public String f50132a;

    /* renamed from: b  reason: collision with root package name */
    public int f50133b;

    public String a() {
        return this.f50132a;
    }

    public int b() {
        return this.f50133b;
    }

    public void c(ForumBookInfo forumBookInfo) {
        if (forumBookInfo == null) {
            return;
        }
        this.f50132a = forumBookInfo.book_id;
        this.f50133b = forumBookInfo.book_type.intValue();
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
