package d.a.j0.d2.g.d;

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
import d.a.j0.d2.g.d.c;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f51950a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f51951b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f51952c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f51953d;

    /* renamed from: e  reason: collision with root package name */
    public View f51954e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f51955f;

    /* renamed from: g  reason: collision with root package name */
    public View f51956g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f51957h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f51958e;

        public a(Post post) {
            this.f51958e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post = this.f51958e;
            if (post == null || post.id == null || b.this.f51957h == null) {
                return;
            }
            b.this.f51957h.a(String.valueOf(this.f51958e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        this.f51953d = viewStub;
        this.f51957h = aVar;
    }

    public final void b() {
        if (this.f51954e == null) {
            View inflate = this.f51953d.inflate();
            this.f51954e = inflate;
            this.f51950a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f51951b = (TextView) this.f51954e.findViewById(R.id.chosen_pb_comment_name);
            this.f51952c = (TbRichTextView) this.f51954e.findViewById(R.id.chosen_pb_comment_content);
            this.f51955f = (ImageView) this.f51954e.findViewById(R.id.chosen_pb_comment_reply);
            this.f51956g = this.f51954e.findViewById(R.id.chosen_pb_comment_line);
            this.f51952c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        SkinManager.setViewTextColor(this.f51951b, R.color.CAM_X0106, 1);
        SkinManager.setImageResource(this.f51955f, R.drawable.btn_comment_list);
        SkinManager.setBackgroundColor(this.f51956g, R.color.CAM_X0204);
        TbRichTextView tbRichTextView = this.f51952c;
        if (tbRichTextView != null) {
            tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void d(boolean z) {
        View view = this.f51954e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public boolean e(Context context, Post post, User user) {
        List<PbContent> list;
        if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
            b();
            d(true);
            this.f51951b.setText(user.name_show);
            this.f51955f.setOnClickListener(new a(post));
            this.f51950a.V(user.portrait, 12, false);
            this.f51952c.setVisibility(0);
            this.f51952c.setText(TbRichTextView.U(context, post.content, false));
            return true;
        }
        d(false);
        return false;
    }
}
