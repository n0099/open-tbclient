package d.a.k0.d2.g.d;

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
import d.a.j0.r.k;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public View f52666a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52667b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f52668c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52669d;

    /* renamed from: e  reason: collision with root package name */
    public e f52670e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f52671f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f52672g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52673h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52674i;
    public LinearLayout j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f52670e != null) {
                d.this.f52670e.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f52676e;

        public b(UserInfo userInfo) {
            this.f52676e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f52676e.id.longValue(), this.f52676e.name);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f52678e;

        public c(UserInfo userInfo) {
            this.f52678e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f52678e.id.longValue(), this.f52678e.name);
        }
    }

    /* renamed from: d.a.k0.d2.g.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1235d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public String f52680e;

        public View$OnClickListenerC1235d(String str) {
            this.f52680e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f52670e != null) {
                d.this.f52670e.a(this.f52680e);
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
        this.f52666a = inflate;
        this.f52667b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f52668c = (HeadImageView) this.f52666a.findViewById(R.id.chosen_pb_person_info_head);
        this.f52669d = (TextView) this.f52666a.findViewById(R.id.chosen_pb_person_info_name);
        this.f52671f = (TextView) this.f52666a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f52668c.setRadius(l.e(context, 2.0f));
        this.f52672g = (BarImageView) this.f52666a.findViewById(R.id.chosen_pb_bar_pic);
        this.f52673h = (TextView) this.f52666a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.f52666a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.f52674i = textView;
        textView.setOnClickListener(new a());
        this.j = (LinearLayout) this.f52666a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        return this.f52666a;
    }

    public void d(String str) {
        HeadImageView headImageView;
        if (StringUtils.isNull(str) || (headImageView = this.f52668c) == null) {
            return;
        }
        headImageView.V(str, 12, false);
    }

    public final void e(long j, String str) {
        e eVar = this.f52670e;
        if (eVar != null) {
            eVar.b(String.valueOf(j), str);
        }
    }

    public void f(boolean z) {
        if (z) {
            this.f52674i.setText(R.string.relate_forum_is_followed);
            SkinManager.setViewTextColor(this.f52674i, R.color.CAM_X0109, 1);
            this.f52674i.setEnabled(false);
            return;
        }
        this.f52674i.setText(R.string.attention);
        this.f52674i.setEnabled(true);
        SkinManager.setViewTextColor(this.f52674i, R.color.CAM_X0111, 1);
    }

    public void g(e eVar) {
        this.f52670e = eVar;
    }

    public void h(String str) {
        TextView textView = this.f52669d;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        if (this.f52671f != null) {
            if (StringUtils.isNull(str)) {
                this.f52671f.setVisibility(4);
                return;
            }
            this.f52671f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.f52671f.setOnClickListener(new View$OnClickListenerC1235d(str));
            this.f52671f.setVisibility(0);
        }
    }

    public void j(UserInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f52668c.setOnClickListener(new b(userInfo));
        this.f52669d.setOnClickListener(new c(userInfo));
    }

    public void k(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        if (excellentPbThreadInfo == null || (textView = this.f52667b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f52672g;
            if (barImageView != null) {
                barImageView.V(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f52672g.setOnClickListener(new View$OnClickListenerC1235d(excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f52673h;
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
