package d.b.i0.c2.g.d;

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
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f52367a;

    /* renamed from: b  reason: collision with root package name */
    public View f52368b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52369c;

    /* renamed from: d  reason: collision with root package name */
    public b f52370d;

    /* renamed from: e  reason: collision with root package name */
    public b f52371e;

    /* renamed from: f  reason: collision with root package name */
    public b f52372f;

    /* renamed from: g  reason: collision with root package name */
    public View f52373g;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str);
    }

    public c(Context context, a aVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.f52368b = inflate;
        this.f52369c = (TextView) inflate.findViewById(R.id.chosen_pb_comment_title);
        this.f52373g = this.f52368b.findViewById(R.id.chosen_pb_comment_line);
        this.f52367a = this.f52368b.findViewById(R.id.comment_layout_blank_view);
        this.f52370d = new b((ViewStub) this.f52368b.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.f52371e = new b((ViewStub) this.f52368b.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.f52372f = new b((ViewStub) this.f52368b.findViewById(R.id.chosen_pb_commrnt_third), aVar);
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
        return this.f52368b;
    }

    public void c() {
        SkinManager.setBackgroundResource(this.f52368b, R.color.common_color_10187);
        SkinManager.setBackgroundColor(this.f52367a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f52369c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f52373g, R.color.CAM_X0204);
        this.f52370d.c();
        this.f52371e.c();
        this.f52372f.c();
    }

    public void d(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean e2;
        boolean e3;
        if (list != null && !list.isEmpty()) {
            this.f52373g.setVisibility(0);
            int size = list.size();
            if (size != 1) {
                if (size == 2) {
                    boolean e4 = this.f52370d.e(context, list.get(0), a(list.get(0), list2));
                    boolean e5 = this.f52371e.e(context, list.get(1), a(list.get(1), list2));
                    this.f52372f.d(false);
                    e2 = e5;
                    z = e4;
                    e3 = false;
                } else if (size >= 3) {
                    boolean e6 = this.f52370d.e(context, list.get(0), a(list.get(0), list2));
                    e2 = this.f52371e.e(context, list.get(1), a(list.get(1), list2));
                    e3 = this.f52372f.e(context, list.get(2), a(list.get(2), list2));
                    z = e6;
                } else {
                    z = false;
                }
                if (z && !e2 && !e3) {
                    this.f52369c.setVisibility(8);
                    return;
                } else {
                    this.f52369c.setVisibility(0);
                    return;
                }
            }
            z = this.f52370d.e(context, list.get(0), a(list.get(0), list2));
            this.f52371e.d(false);
            this.f52372f.d(false);
            e3 = false;
            e2 = false;
            if (z) {
            }
            this.f52369c.setVisibility(0);
            return;
        }
        this.f52369c.setVisibility(8);
        this.f52370d.d(false);
        this.f52371e.d(false);
        this.f52372f.d(false);
        this.f52373g.setVisibility(8);
    }
}
