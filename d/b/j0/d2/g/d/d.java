package d.b.j0.d2.g.d;

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
import d.b.c.e.p.l;
import d.b.i0.r.k;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public View f54190a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54191b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f54192c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54193d;

    /* renamed from: e  reason: collision with root package name */
    public e f54194e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54195f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f54196g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54197h;
    public TextView i;
    public LinearLayout j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f54194e != null) {
                d.this.f54194e.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f54199e;

        public b(UserInfo userInfo) {
            this.f54199e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f54199e.id.longValue(), this.f54199e.name);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f54201e;

        public c(UserInfo userInfo) {
            this.f54201e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e(this.f54201e.id.longValue(), this.f54201e.name);
        }
    }

    /* renamed from: d.b.j0.d2.g.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1224d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public String f54203e;

        public View$OnClickListenerC1224d(String str) {
            this.f54203e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f54194e != null) {
                d.this.f54194e.a(this.f54203e);
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
        this.f54190a = inflate;
        this.f54191b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f54192c = (HeadImageView) this.f54190a.findViewById(R.id.chosen_pb_person_info_head);
        this.f54193d = (TextView) this.f54190a.findViewById(R.id.chosen_pb_person_info_name);
        this.f54195f = (TextView) this.f54190a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f54192c.setRadius(l.e(context, 2.0f));
        this.f54196g = (BarImageView) this.f54190a.findViewById(R.id.chosen_pb_bar_pic);
        this.f54197h = (TextView) this.f54190a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.f54190a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.i = textView;
        textView.setOnClickListener(new a());
        this.j = (LinearLayout) this.f54190a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        return this.f54190a;
    }

    public void d(String str) {
        HeadImageView headImageView;
        if (StringUtils.isNull(str) || (headImageView = this.f54192c) == null) {
            return;
        }
        headImageView.W(str, 12, false);
    }

    public final void e(long j, String str) {
        e eVar = this.f54194e;
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
        this.f54194e = eVar;
    }

    public void h(String str) {
        TextView textView = this.f54193d;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        if (this.f54195f != null) {
            if (StringUtils.isNull(str)) {
                this.f54195f.setVisibility(4);
                return;
            }
            this.f54195f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.f54195f.setOnClickListener(new View$OnClickListenerC1224d(str));
            this.f54195f.setVisibility(0);
        }
    }

    public void j(UserInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f54192c.setOnClickListener(new b(userInfo));
        this.f54193d.setOnClickListener(new c(userInfo));
    }

    public void k(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        if (excellentPbThreadInfo == null || (textView = this.f54191b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f54196g;
            if (barImageView != null) {
                barImageView.W(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f54196g.setOnClickListener(new View$OnClickListenerC1224d(excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f54197h;
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
