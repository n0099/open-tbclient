package d.b.i0.c2.g.d;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.b.i0.c2.g.d.c;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f52357a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52358b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f52359c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f52360d;

    /* renamed from: e  reason: collision with root package name */
    public View f52361e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52362f;

    /* renamed from: g  reason: collision with root package name */
    public View f52363g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f52364h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f52365e;

        public a(Post post) {
            this.f52365e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post = this.f52365e;
            if (post == null || post.id == null || b.this.f52364h == null) {
                return;
            }
            b.this.f52364h.a(String.valueOf(this.f52365e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        this.f52360d = viewStub;
        this.f52364h = aVar;
    }

    public final void b() {
        if (this.f52361e == null) {
            View inflate = this.f52360d.inflate();
            this.f52361e = inflate;
            this.f52357a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f52358b = (TextView) this.f52361e.findViewById(R.id.chosen_pb_comment_name);
            this.f52359c = (TbRichTextView) this.f52361e.findViewById(R.id.chosen_pb_comment_content);
            this.f52362f = (ImageView) this.f52361e.findViewById(R.id.chosen_pb_comment_reply);
            this.f52363g = this.f52361e.findViewById(R.id.chosen_pb_comment_line);
            this.f52359c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        SkinManager.setViewTextColor(this.f52358b, R.color.CAM_X0106, 1);
        SkinManager.setImageResource(this.f52362f, R.drawable.btn_comment_list);
        SkinManager.setBackgroundColor(this.f52363g, R.color.CAM_X0204);
        TbRichTextView tbRichTextView = this.f52359c;
        if (tbRichTextView != null) {
            tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void d(boolean z) {
        View view = this.f52361e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public boolean e(Context context, Post post, User user) {
        List<PbContent> list;
        if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
            b();
            d(true);
            this.f52358b.setText(user.name_show);
            this.f52362f.setOnClickListener(new a(post));
            this.f52357a.W(user.portrait, 12, false);
            this.f52359c.setVisibility(0);
            this.f52359c.setText(TbRichTextView.S(context, post.content, false));
            return true;
        }
        d(false);
        return false;
    }
}
