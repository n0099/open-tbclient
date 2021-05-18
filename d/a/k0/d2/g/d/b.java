package d.a.k0.d2.g.d;

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
import d.a.k0.d2.g.d.c;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f52649a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52650b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f52651c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f52652d;

    /* renamed from: e  reason: collision with root package name */
    public View f52653e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52654f;

    /* renamed from: g  reason: collision with root package name */
    public View f52655g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f52656h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f52657e;

        public a(Post post) {
            this.f52657e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post = this.f52657e;
            if (post == null || post.id == null || b.this.f52656h == null) {
                return;
            }
            b.this.f52656h.a(String.valueOf(this.f52657e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        this.f52652d = viewStub;
        this.f52656h = aVar;
    }

    public final void b() {
        if (this.f52653e == null) {
            View inflate = this.f52652d.inflate();
            this.f52653e = inflate;
            this.f52649a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f52650b = (TextView) this.f52653e.findViewById(R.id.chosen_pb_comment_name);
            this.f52651c = (TbRichTextView) this.f52653e.findViewById(R.id.chosen_pb_comment_content);
            this.f52654f = (ImageView) this.f52653e.findViewById(R.id.chosen_pb_comment_reply);
            this.f52655g = this.f52653e.findViewById(R.id.chosen_pb_comment_line);
            this.f52651c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        SkinManager.setViewTextColor(this.f52650b, R.color.CAM_X0106, 1);
        SkinManager.setImageResource(this.f52654f, R.drawable.btn_comment_list);
        SkinManager.setBackgroundColor(this.f52655g, R.color.CAM_X0204);
        TbRichTextView tbRichTextView = this.f52651c;
        if (tbRichTextView != null) {
            tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void d(boolean z) {
        View view = this.f52653e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public boolean e(Context context, Post post, User user) {
        List<PbContent> list;
        if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
            b();
            d(true);
            this.f52650b.setText(user.name_show);
            this.f52654f.setOnClickListener(new a(post));
            this.f52649a.V(user.portrait, 12, false);
            this.f52651c.setVisibility(0);
            this.f52651c.setText(TbRichTextView.U(context, post.content, false));
            return true;
        }
        d(false);
        return false;
    }
}
