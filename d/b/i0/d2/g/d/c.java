package d.b.i0.d2.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f53762a;

    /* renamed from: b  reason: collision with root package name */
    public View f53763b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53764c;

    /* renamed from: d  reason: collision with root package name */
    public b f53765d;

    /* renamed from: e  reason: collision with root package name */
    public b f53766e;

    /* renamed from: f  reason: collision with root package name */
    public b f53767f;

    /* renamed from: g  reason: collision with root package name */
    public View f53768g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str);
    }

    public c(Context context, a aVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.f53763b = inflate;
        this.f53764c = (TextView) inflate.findViewById(R.id.chosen_pb_comment_title);
        this.f53768g = this.f53763b.findViewById(R.id.chosen_pb_comment_line);
        this.f53762a = this.f53763b.findViewById(R.id.comment_layout_blank_view);
        this.f53765d = new b((ViewStub) this.f53763b.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.f53766e = new b((ViewStub) this.f53763b.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.f53767f = new b((ViewStub) this.f53763b.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public final User a(Post post, List<User> list) {
        Long l;
        Long l2;
        if (post == null || list == null || list.isEmpty() || (l = post.author_id) == null) {
            return null;
        }
        long longValue = l.longValue();
        for (User user : list) {
            if (user != null && (l2 = user.id) != null && l2.longValue() == longValue) {
                return user;
            }
        }
        return null;
    }

    public View b() {
        return this.f53763b;
    }

    public void c() {
        SkinManager.setBackgroundResource(this.f53763b, R.color.common_color_10187);
        SkinManager.setBackgroundColor(this.f53762a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f53764c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f53768g, R.color.CAM_X0204);
        this.f53765d.c();
        this.f53766e.c();
        this.f53767f.c();
    }

    public void d(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean e2;
        boolean e3;
        if (list != null && !list.isEmpty()) {
            this.f53768g.setVisibility(0);
            int size = list.size();
            if (size != 1) {
                if (size == 2) {
                    boolean e4 = this.f53765d.e(context, list.get(0), a(list.get(0), list2));
                    boolean e5 = this.f53766e.e(context, list.get(1), a(list.get(1), list2));
                    this.f53767f.d(false);
                    e2 = e5;
                    z = e4;
                    e3 = false;
                } else if (size >= 3) {
                    boolean e6 = this.f53765d.e(context, list.get(0), a(list.get(0), list2));
                    e2 = this.f53766e.e(context, list.get(1), a(list.get(1), list2));
                    e3 = this.f53767f.e(context, list.get(2), a(list.get(2), list2));
                    z = e6;
                } else {
                    z = false;
                }
                if (z && !e2 && !e3) {
                    this.f53764c.setVisibility(8);
                    return;
                } else {
                    this.f53764c.setVisibility(0);
                    return;
                }
            }
            z = this.f53765d.e(context, list.get(0), a(list.get(0), list2));
            this.f53766e.d(false);
            this.f53767f.d(false);
            e3 = false;
            e2 = false;
            if (z) {
            }
            this.f53764c.setVisibility(0);
            return;
        }
        this.f53764c.setVisibility(8);
        this.f53765d.d(false);
        this.f53766e.d(false);
        this.f53767f.d(false);
        this.f53768g.setVisibility(8);
    }
}
