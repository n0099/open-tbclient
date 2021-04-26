package d.a.j0.d2.g.d;

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
import d.a.i0.r.k;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public View f51967a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f51968b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f51969c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51970d;

    /* renamed from: e  reason: collision with root package name */
    public e f51971e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51972f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f51973g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51974h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51975i;
    public LinearLayout j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f51971e != null) {
                d.this.f51971e.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f51977e;

        public b(UserInfo userInfo) {
            this.f51977e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f51977e.id.longValue(), this.f51977e.name);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f51979e;

        public c(UserInfo userInfo) {
            this.f51979e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f51979e.id.longValue(), this.f51979e.name);
        }
    }

    /* renamed from: d.a.j0.d2.g.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1163d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public String f51981e;

        public View$OnClickListenerC1163d(String str) {
            this.f51981e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f51971e != null) {
                d.this.f51971e.a(this.f51981e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(String str);

        void b(String str, String str2);

        void c();
    }

    public d(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.f51967a = inflate;
        this.f51968b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f51969c = (HeadImageView) this.f51967a.findViewById(R.id.chosen_pb_person_info_head);
        this.f51970d = (TextView) this.f51967a.findViewById(R.id.chosen_pb_person_info_name);
        this.f51972f = (TextView) this.f51967a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f51969c.setRadius(l.e(context, 2.0f));
        this.f51973g = (BarImageView) this.f51967a.findViewById(R.id.chosen_pb_bar_pic);
        this.f51974h = (TextView) this.f51967a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.f51967a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.f51975i = textView;
        textView.setOnClickListener(new a());
        this.j = (LinearLayout) this.f51967a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        return this.f51967a;
    }

    public void d(String str) {
        HeadImageView headImageView;
        if (StringUtils.isNull(str) || (headImageView = this.f51969c) == null) {
            return;
        }
        headImageView.V(str, 12, false);
    }

    public final void e(long j, String str) {
        e eVar = this.f51971e;
        if (eVar != null) {
            eVar.b(String.valueOf(j), str);
        }
    }

    public void f(boolean z) {
        if (z) {
            this.f51975i.setText(R.string.relate_forum_is_followed);
            SkinManager.setViewTextColor(this.f51975i, R.color.CAM_X0109, 1);
            this.f51975i.setEnabled(false);
            return;
        }
        this.f51975i.setText(R.string.attention);
        this.f51975i.setEnabled(true);
        SkinManager.setViewTextColor(this.f51975i, R.color.CAM_X0111, 1);
    }

    public void g(e eVar) {
        this.f51971e = eVar;
    }

    public void h(String str) {
        TextView textView = this.f51970d;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        if (this.f51972f != null) {
            if (StringUtils.isNull(str)) {
                this.f51972f.setVisibility(4);
                return;
            }
            this.f51972f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.f51972f.setOnClickListener(new View$OnClickListenerC1163d(str));
            this.f51972f.setVisibility(0);
        }
    }

    public void j(UserInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f51969c.setOnClickListener(new b(userInfo));
        this.f51970d.setOnClickListener(new c(userInfo));
    }

    public void k(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        if (excellentPbThreadInfo == null || (textView = this.f51968b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f51973g;
            if (barImageView != null) {
                barImageView.V(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f51973g.setOnClickListener(new View$OnClickListenerC1163d(excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f51974h;
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
