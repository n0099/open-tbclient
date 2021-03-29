package d.b.i0.c2.g.d;

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
import d.b.b.e.p.l;
import d.b.h0.r.k;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public View f52374a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52375b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f52376c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52377d;

    /* renamed from: e  reason: collision with root package name */
    public e f52378e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f52379f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f52380g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52381h;
    public TextView i;
    public LinearLayout j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f52378e != null) {
                d.this.f52378e.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f52383e;

        public b(UserInfo userInfo) {
            this.f52383e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f52383e.id.longValue(), this.f52383e.name);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f52385e;

        public c(UserInfo userInfo) {
            this.f52385e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f52385e.id.longValue(), this.f52385e.name);
        }
    }

    /* renamed from: d.b.i0.c2.g.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1144d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public String f52387e;

        public View$OnClickListenerC1144d(String str) {
            this.f52387e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f52378e != null) {
                d.this.f52378e.a(this.f52387e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(String str);

        void b(String str, String str2);

        void c();
    }

    public d(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.f52374a = inflate;
        this.f52375b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f52376c = (HeadImageView) this.f52374a.findViewById(R.id.chosen_pb_person_info_head);
        this.f52377d = (TextView) this.f52374a.findViewById(R.id.chosen_pb_person_info_name);
        this.f52379f = (TextView) this.f52374a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f52376c.setRadius(l.e(context, 2.0f));
        this.f52380g = (BarImageView) this.f52374a.findViewById(R.id.chosen_pb_bar_pic);
        this.f52381h = (TextView) this.f52374a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.f52374a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.i = textView;
        textView.setOnClickListener(new a());
        this.j = (LinearLayout) this.f52374a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        return this.f52374a;
    }

    public void d(String str) {
        HeadImageView headImageView;
        if (StringUtils.isNull(str) || (headImageView = this.f52376c) == null) {
            return;
        }
        headImageView.W(str, 12, false);
    }

    public final void e(long j, String str) {
        e eVar = this.f52378e;
        if (eVar != null) {
            eVar.b(String.valueOf(j), str);
        }
    }

    public void f(boolean z) {
        if (z) {
            this.i.setText(R.string.relate_forum_is_followed);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1);
            this.i.setEnabled(false);
            return;
        }
        this.i.setText(R.string.attention);
        this.i.setEnabled(true);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0111, 1);
    }

    public void g(e eVar) {
        this.f52378e = eVar;
    }

    public void h(String str) {
        TextView textView = this.f52377d;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        if (this.f52379f != null) {
            if (StringUtils.isNull(str)) {
                this.f52379f.setVisibility(4);
                return;
            }
            this.f52379f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.f52379f.setOnClickListener(new View$OnClickListenerC1144d(str));
            this.f52379f.setVisibility(0);
        }
    }

    public void j(UserInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f52376c.setOnClickListener(new b(userInfo));
        this.f52377d.setOnClickListener(new c(userInfo));
    }

    public void k(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        if (excellentPbThreadInfo == null || (textView = this.f52375b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f52380g;
            if (barImageView != null) {
                barImageView.W(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f52380g.setOnClickListener(new View$OnClickListenerC1144d(excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f52381h;
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
