package d.a.n0.e2.g.d;

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
import d.a.n0.e2.g.d.c;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f52854a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52855b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f52856c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f52857d;

    /* renamed from: e  reason: collision with root package name */
    public View f52858e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52859f;

    /* renamed from: g  reason: collision with root package name */
    public View f52860g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f52861h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f52862e;

        public a(Post post) {
            this.f52862e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post = this.f52862e;
            if (post == null || post.id == null || b.this.f52861h == null) {
                return;
            }
            b.this.f52861h.a(String.valueOf(this.f52862e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        this.f52857d = viewStub;
        this.f52861h = aVar;
    }

    public final void b() {
        if (this.f52858e == null) {
            View inflate = this.f52857d.inflate();
            this.f52858e = inflate;
            this.f52854a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f52855b = (TextView) this.f52858e.findViewById(R.id.chosen_pb_comment_name);
            this.f52856c = (TbRichTextView) this.f52858e.findViewById(R.id.chosen_pb_comment_content);
            this.f52859f = (ImageView) this.f52858e.findViewById(R.id.chosen_pb_comment_reply);
            this.f52860g = this.f52858e.findViewById(R.id.chosen_pb_comment_line);
            this.f52856c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        SkinManager.setViewTextColor(this.f52855b, R.color.CAM_X0106, 1);
        SkinManager.setImageResource(this.f52859f, R.drawable.btn_comment_list);
        SkinManager.setBackgroundColor(this.f52860g, R.color.CAM_X0204);
        TbRichTextView tbRichTextView = this.f52856c;
        if (tbRichTextView != null) {
            tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void d(boolean z) {
        View view = this.f52858e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public boolean e(Context context, Post post, User user) {
        List<PbContent> list;
        if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
            b();
            d(true);
            this.f52855b.setText(user.name_show);
            this.f52859f.setOnClickListener(new a(post));
            this.f52854a.V(user.portrait, 12, false);
            this.f52856c.setVisibility(0);
            this.f52856c.setText(TbRichTextView.U(context, post.content, false));
            return true;
        }
        d(false);
        return false;
    }
}
