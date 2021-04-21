package d.b.j0.d2.g.d;

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
import d.b.j0.d2.g.d.c;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f54173a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54174b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f54175c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f54176d;

    /* renamed from: e  reason: collision with root package name */
    public View f54177e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f54178f;

    /* renamed from: g  reason: collision with root package name */
    public View f54179g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f54180h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f54181e;

        public a(Post post) {
            this.f54181e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post = this.f54181e;
            if (post == null || post.id == null || b.this.f54180h == null) {
                return;
            }
            b.this.f54180h.a(String.valueOf(this.f54181e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        this.f54176d = viewStub;
        this.f54180h = aVar;
    }

    public final void b() {
        if (this.f54177e == null) {
            View inflate = this.f54176d.inflate();
            this.f54177e = inflate;
            this.f54173a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f54174b = (TextView) this.f54177e.findViewById(R.id.chosen_pb_comment_name);
            this.f54175c = (TbRichTextView) this.f54177e.findViewById(R.id.chosen_pb_comment_content);
            this.f54178f = (ImageView) this.f54177e.findViewById(R.id.chosen_pb_comment_reply);
            this.f54179g = this.f54177e.findViewById(R.id.chosen_pb_comment_line);
            this.f54175c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        SkinManager.setViewTextColor(this.f54174b, R.color.CAM_X0106, 1);
        SkinManager.setImageResource(this.f54178f, R.drawable.btn_comment_list);
        SkinManager.setBackgroundColor(this.f54179g, R.color.CAM_X0204);
        TbRichTextView tbRichTextView = this.f54175c;
        if (tbRichTextView != null) {
            tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void d(boolean z) {
        View view = this.f54177e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public boolean e(Context context, Post post, User user) {
        List<PbContent> list;
        if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
            b();
            d(true);
            this.f54174b.setText(user.name_show);
            this.f54178f.setOnClickListener(new a(post));
            this.f54173a.W(user.portrait, 12, false);
            this.f54175c.setVisibility(0);
            this.f54175c.setText(TbRichTextView.U(context, post.content, false));
            return true;
        }
        d(false);
        return false;
    }
}
