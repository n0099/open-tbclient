package d.a.j0.d2.g.d;

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
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f51983a;

    /* renamed from: b  reason: collision with root package name */
    public View f51984b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f51985c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f51986d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51987e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51988f;

    /* renamed from: g  reason: collision with root package name */
    public c f51989g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51990h;
    public Animation j;

    /* renamed from: i  reason: collision with root package name */
    public long f51991i = 0;
    public boolean k = false;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.k && ViewHelper.checkUpIsLogin(e.this.f51983a)) {
                e.this.k = true;
                e.this.f51986d.startAnimation(e.this.g());
                if (e.this.f51989g != null) {
                    e.this.f51989g.b(e.this.f51990h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f51993e;

        public b(ExcellentPbThreadInfo excellentPbThreadInfo) {
            this.f51993e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f51989g != null) {
                c cVar = e.this.f51989g;
                long longValue = this.f51993e.forum.forum_id.longValue();
                cVar.a(longValue, this.f51993e.thread_id + "");
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(long j, String str);

        void b(boolean z);
    }

    public e(Context context) {
        this.f51983a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f51984b = inflate;
        this.f51985c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f51986d = (ImageView) this.f51984b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f51987e = (TextView) this.f51984b.findViewById(R.id.chosen_post_info_praise_num);
        this.f51988f = (TextView) this.f51984b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        if (this.j == null) {
            this.j = AnimationUtils.loadAnimation(this.f51983a, R.anim.praise_animation_scale3);
        }
        return this.j;
    }

    public View h() {
        return this.f51984b;
    }

    public void i(c cVar) {
        this.f51989g = cVar;
    }

    public void j(int i2) {
        TextView textView = this.f51985c;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView = this.f51988f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void l(long j) {
        if (j < 0) {
            return;
        }
        this.f51991i = j;
        TextView textView = this.f51987e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f51987e.setText(this.f51983a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.f51987e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f51987e.setVisibility(0);
    }

    public void m(boolean z) {
        p(z);
        if (z) {
            this.f51991i++;
        } else {
            this.f51991i--;
        }
        l(this.f51991i);
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
        this.f51986d.setOnClickListener(new a());
        k(new b(excellentPbThreadInfo));
    }

    public final void p(boolean z) {
        this.f51990h = z;
        if (z) {
            SkinManager.setImageResource(this.f51986d, R.drawable.btn_zambia_big_s);
        } else {
            SkinManager.setImageResource(this.f51986d, R.drawable.btn_zambia_big_n);
        }
        this.f51986d.setVisibility(0);
    }
}
