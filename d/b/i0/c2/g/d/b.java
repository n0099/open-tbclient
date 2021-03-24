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
    public HeadImageView f52356a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52357b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f52358c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f52359d;

    /* renamed from: e  reason: collision with root package name */
    public View f52360e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52361f;

    /* renamed from: g  reason: collision with root package name */
    public View f52362g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f52363h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f52364e;

        public a(Post post) {
            this.f52364e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post = this.f52364e;
            if (post == null || post.id == null || b.this.f52363h == null) {
                return;
            }
            b.this.f52363h.a(String.valueOf(this.f52364e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        this.f52359d = viewStub;
        this.f52363h = aVar;
    }

    public final void b() {
        if (this.f52360e == null) {
            View inflate = this.f52359d.inflate();
            this.f52360e = inflate;
            this.f52356a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f52357b = (TextView) this.f52360e.findViewById(R.id.chosen_pb_comment_name);
            this.f52358c = (TbRichTextView) this.f52360e.findViewById(R.id.chosen_pb_comment_content);
            this.f52361f = (ImageView) this.f52360e.findViewById(R.id.chosen_pb_comment_reply);
            this.f52362g = this.f52360e.findViewById(R.id.chosen_pb_comment_line);
            this.f52358c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        SkinManager.setViewTextColor(this.f52357b, R.color.CAM_X0106, 1);
        SkinManager.setImageResource(this.f52361f, R.drawable.btn_comment_list);
        SkinManager.setBackgroundColor(this.f52362g, R.color.CAM_X0204);
        TbRichTextView tbRichTextView = this.f52358c;
        if (tbRichTextView != null) {
            tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void d(boolean z) {
        View view = this.f52360e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public boolean e(Context context, Post post, User user) {
        List<PbContent> list;
        if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
            b();
            d(true);
            this.f52357b.setText(user.name_show);
            this.f52361f.setOnClickListener(new a(post));
            this.f52356a.W(user.portrait, 12, false);
            this.f52358c.setVisibility(0);
            this.f52358c.setText(TbRichTextView.S(context, post.content, false));
            return true;
        }
        d(false);
        return false;
    }
}
