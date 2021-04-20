package d.b.i0.d2.g.d;

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
import d.b.i0.d2.g.d.c;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f53752a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f53753b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f53754c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f53755d;

    /* renamed from: e  reason: collision with root package name */
    public View f53756e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f53757f;

    /* renamed from: g  reason: collision with root package name */
    public View f53758g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f53759h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f53760e;

        public a(Post post) {
            this.f53760e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post = this.f53760e;
            if (post == null || post.id == null || b.this.f53759h == null) {
                return;
            }
            b.this.f53759h.a(String.valueOf(this.f53760e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        this.f53755d = viewStub;
        this.f53759h = aVar;
    }

    public final void b() {
        if (this.f53756e == null) {
            View inflate = this.f53755d.inflate();
            this.f53756e = inflate;
            this.f53752a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f53753b = (TextView) this.f53756e.findViewById(R.id.chosen_pb_comment_name);
            this.f53754c = (TbRichTextView) this.f53756e.findViewById(R.id.chosen_pb_comment_content);
            this.f53757f = (ImageView) this.f53756e.findViewById(R.id.chosen_pb_comment_reply);
            this.f53758g = this.f53756e.findViewById(R.id.chosen_pb_comment_line);
            this.f53754c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        SkinManager.setViewTextColor(this.f53753b, R.color.CAM_X0106, 1);
        SkinManager.setImageResource(this.f53757f, R.drawable.btn_comment_list);
        SkinManager.setBackgroundColor(this.f53758g, R.color.CAM_X0204);
        TbRichTextView tbRichTextView = this.f53754c;
        if (tbRichTextView != null) {
            tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void d(boolean z) {
        View view = this.f53756e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public boolean e(Context context, Post post, User user) {
        List<PbContent> list;
        if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
            b();
            d(true);
            this.f53753b.setText(user.name_show);
            this.f53757f.setOnClickListener(new a(post));
            this.f53752a.W(user.portrait, 12, false);
            this.f53754c.setVisibility(0);
            this.f53754c.setText(TbRichTextView.U(context, post.content, false));
            return true;
        }
        d(false);
        return false;
    }
}
