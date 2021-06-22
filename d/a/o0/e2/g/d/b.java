package d.a.o0.e2.g.d;

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
import d.a.o0.e2.g.d.c;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f56668a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f56669b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f56670c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f56671d;

    /* renamed from: e  reason: collision with root package name */
    public View f56672e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56673f;

    /* renamed from: g  reason: collision with root package name */
    public View f56674g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f56675h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f56676e;

        public a(Post post) {
            this.f56676e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post = this.f56676e;
            if (post == null || post.id == null || b.this.f56675h == null) {
                return;
            }
            b.this.f56675h.a(String.valueOf(this.f56676e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        this.f56671d = viewStub;
        this.f56675h = aVar;
    }

    public final void b() {
        if (this.f56672e == null) {
            View inflate = this.f56671d.inflate();
            this.f56672e = inflate;
            this.f56668a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f56669b = (TextView) this.f56672e.findViewById(R.id.chosen_pb_comment_name);
            this.f56670c = (TbRichTextView) this.f56672e.findViewById(R.id.chosen_pb_comment_content);
            this.f56673f = (ImageView) this.f56672e.findViewById(R.id.chosen_pb_comment_reply);
            this.f56674g = this.f56672e.findViewById(R.id.chosen_pb_comment_line);
            this.f56670c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        SkinManager.setViewTextColor(this.f56669b, R.color.CAM_X0106, 1);
        SkinManager.setImageResource(this.f56673f, R.drawable.btn_comment_list);
        SkinManager.setBackgroundColor(this.f56674g, R.color.CAM_X0204);
        TbRichTextView tbRichTextView = this.f56670c;
        if (tbRichTextView != null) {
            tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void d(boolean z) {
        View view = this.f56672e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public boolean e(Context context, Post post, User user) {
        List<PbContent> list;
        if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
            b();
            d(true);
            this.f56669b.setText(user.name_show);
            this.f56673f.setOnClickListener(new a(post));
            this.f56668a.U(user.portrait, 12, false);
            this.f56670c.setVisibility(0);
            this.f56670c.setText(TbRichTextView.U(context, post.content, false));
            return true;
        }
        d(false);
        return false;
    }
}
