package d.a.n0.e2.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.r.k;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public View f56560a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f56561b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f56562c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56563d;

    /* renamed from: e  reason: collision with root package name */
    public e f56564e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56565f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f56566g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56567h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f56568i;
    public LinearLayout j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f56564e != null) {
                d.this.f56564e.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f56570e;

        public b(UserInfo userInfo) {
            this.f56570e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f56570e.id.longValue(), this.f56570e.name);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f56572e;

        public c(UserInfo userInfo) {
            this.f56572e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f56572e.id.longValue(), this.f56572e.name);
        }
    }

    /* renamed from: d.a.n0.e2.g.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1309d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public String f56574e;

        public View$OnClickListenerC1309d(String str) {
            this.f56574e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f56564e != null) {
                d.this.f56564e.a(this.f56574e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(String str);

        void b(String str, String str2);

        void c();
    }

    public d(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.f56560a = inflate;
        this.f56561b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f56562c = (HeadImageView) this.f56560a.findViewById(R.id.chosen_pb_person_info_head);
        this.f56563d = (TextView) this.f56560a.findViewById(R.id.chosen_pb_person_info_name);
        this.f56565f = (TextView) this.f56560a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f56562c.setRadius(l.e(context, 2.0f));
        this.f56566g = (BarImageView) this.f56560a.findViewById(R.id.chosen_pb_bar_pic);
        this.f56567h = (TextView) this.f56560a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.f56560a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.f56568i = textView;
        textView.setOnClickListener(new a());
        this.j = (LinearLayout) this.f56560a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        return this.f56560a;
    }

    public void d(String str) {
        HeadImageView headImageView;
        if (StringUtils.isNull(str) || (headImageView = this.f56562c) == null) {
            return;
        }
        headImageView.U(str, 12, false);
    }

    public final void e(long j, String str) {
        e eVar = this.f56564e;
        if (eVar != null) {
            eVar.b(String.valueOf(j), str);
        }
    }

    public void f(boolean z) {
        if (z) {
            this.f56568i.setText(R.string.relate_forum_is_followed);
            SkinManager.setViewTextColor(this.f56568i, R.color.CAM_X0109, 1);
            this.f56568i.setEnabled(false);
            return;
        }
        this.f56568i.setText(R.string.attention);
        this.f56568i.setEnabled(true);
        SkinManager.setViewTextColor(this.f56568i, R.color.CAM_X0111, 1);
    }

    public void g(e eVar) {
        this.f56564e = eVar;
    }

    public void h(String str) {
        TextView textView = this.f56563d;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        if (this.f56565f != null) {
            if (StringUtils.isNull(str)) {
                this.f56565f.setVisibility(4);
                return;
            }
            this.f56565f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.f56565f.setOnClickListener(new View$OnClickListenerC1309d(str));
            this.f56565f.setVisibility(0);
        }
    }

    public void j(UserInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f56562c.setOnClickListener(new b(userInfo));
        this.f56563d.setOnClickListener(new c(userInfo));
    }

    public void k(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        if (excellentPbThreadInfo == null || (textView = this.f56561b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f56566g;
            if (barImageView != null) {
                barImageView.U(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f56566g.setOnClickListener(new View$OnClickListenerC1309d(excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f56567h;
            if (textView2 != null && (num = excellentPbThreadInfo.forum.member_count) != null) {
                textView2.setText(StringHelper.numFormatOver10000(num.intValue()));
            }
            Integer num2 = excellentPbThreadInfo.forum.is_like;
            if (num2 != null && num2.intValue() == 1) {
                f(true);
                return;
            } else {
                f(false);
                return;
            }
        }
        this.j.setVisibility(8);
    }
}
