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
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f56543a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f56544b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f56545c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f56546d;

    /* renamed from: e  reason: collision with root package name */
    public View f56547e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56548f;

    /* renamed from: g  reason: collision with root package name */
    public View f56549g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f56550h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f56551e;

        public a(Post post) {
            this.f56551e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post = this.f56551e;
            if (post == null || post.id == null || b.this.f56550h == null) {
                return;
            }
            b.this.f56550h.a(String.valueOf(this.f56551e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        this.f56546d = viewStub;
        this.f56550h = aVar;
    }

    public final void b() {
        if (this.f56547e == null) {
            View inflate = this.f56546d.inflate();
            this.f56547e = inflate;
            this.f56543a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f56544b = (TextView) this.f56547e.findViewById(R.id.chosen_pb_comment_name);
            this.f56545c = (TbRichTextView) this.f56547e.findViewById(R.id.chosen_pb_comment_content);
            this.f56548f = (ImageView) this.f56547e.findViewById(R.id.chosen_pb_comment_reply);
            this.f56549g = this.f56547e.findViewById(R.id.chosen_pb_comment_line);
            this.f56545c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        SkinManager.setViewTextColor(this.f56544b, R.color.CAM_X0106, 1);
        SkinManager.setImageResource(this.f56548f, R.drawable.btn_comment_list);
        SkinManager.setBackgroundColor(this.f56549g, R.color.CAM_X0204);
        TbRichTextView tbRichTextView = this.f56545c;
        if (tbRichTextView != null) {
            tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void d(boolean z) {
        View view = this.f56547e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public boolean e(Context context, Post post, User user) {
        List<PbContent> list;
        if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
            b();
            d(true);
            this.f56544b.setText(user.name_show);
            this.f56548f.setOnClickListener(new a(post));
            this.f56543a.U(user.portrait, 12, false);
            this.f56545c.setVisibility(0);
            this.f56545c.setText(TbRichTextView.U(context, post.content, false));
            return true;
        }
        d(false);
        return false;
    }
}
