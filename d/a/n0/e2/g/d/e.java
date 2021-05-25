package d.a.n0.e2.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f52887a;

    /* renamed from: b  reason: collision with root package name */
    public View f52888b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52889c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f52890d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52891e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f52892f;

    /* renamed from: g  reason: collision with root package name */
    public c f52893g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52894h;
    public Animation j;

    /* renamed from: i  reason: collision with root package name */
    public long f52895i = 0;
    public boolean k = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.k && ViewHelper.checkUpIsLogin(e.this.f52887a)) {
                e.this.k = true;
                e.this.f52890d.startAnimation(e.this.g());
                if (e.this.f52893g != null) {
                    e.this.f52893g.b(e.this.f52894h);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f52897e;

        public b(ExcellentPbThreadInfo excellentPbThreadInfo) {
            this.f52897e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52893g != null) {
                c cVar = e.this.f52893g;
                long longValue = this.f52897e.forum.forum_id.longValue();
                cVar.a(longValue, this.f52897e.thread_id + "");
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(long j, String str);

        void b(boolean z);
    }

    public e(Context context) {
        this.f52887a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f52888b = inflate;
        this.f52889c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f52890d = (ImageView) this.f52888b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f52891e = (TextView) this.f52888b.findViewById(R.id.chosen_post_info_praise_num);
        this.f52892f = (TextView) this.f52888b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        if (this.j == null) {
            this.j = AnimationUtils.loadAnimation(this.f52887a, R.anim.praise_animation_scale3);
        }
        return this.j;
    }

    public View h() {
        return this.f52888b;
    }

    public void i(c cVar) {
        this.f52893g = cVar;
    }

    public void j(int i2) {
        TextView textView = this.f52889c;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView = this.f52892f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void l(long j) {
        if (j < 0) {
            return;
        }
        this.f52895i = j;
        TextView textView = this.f52891e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f52891e.setText(this.f52887a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.f52891e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f52891e.setVisibility(0);
    }

    public void m(boolean z) {
        p(z);
        if (z) {
            this.f52895i++;
        } else {
            this.f52895i--;
        }
        l(this.f52895i);
    }

    public void n() {
        this.k = false;
    }

    public void o(ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo == null) {
            return;
        }
        j(R.string.chosen_pb_copyright);
        l(excellentPbThreadInfo.zan.zansum.longValue());
        p(excellentPbThreadInfo.zan.is_zan.booleanValue());
        this.f52890d.setOnClickListener(new a());
        k(new b(excellentPbThreadInfo));
    }

    public final void p(boolean z) {
        this.f52894h = z;
        if (z) {
            SkinManager.setImageResource(this.f52890d, R.drawable.btn_zambia_big_s);
        } else {
            SkinManager.setImageResource(this.f52890d, R.drawable.btn_zambia_big_n);
        }
        this.f52890d.setVisibility(0);
    }
}
