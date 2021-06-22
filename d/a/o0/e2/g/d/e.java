package d.a.o0.e2.g.d;

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
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f56701a;

    /* renamed from: b  reason: collision with root package name */
    public View f56702b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56703c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f56704d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56705e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56706f;

    /* renamed from: g  reason: collision with root package name */
    public c f56707g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56708h;
    public Animation j;

    /* renamed from: i  reason: collision with root package name */
    public long f56709i = 0;
    public boolean k = false;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.k && ViewHelper.checkUpIsLogin(e.this.f56701a)) {
                e.this.k = true;
                e.this.f56704d.startAnimation(e.this.g());
                if (e.this.f56707g != null) {
                    e.this.f56707g.b(e.this.f56708h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f56711e;

        public b(ExcellentPbThreadInfo excellentPbThreadInfo) {
            this.f56711e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f56707g != null) {
                c cVar = e.this.f56707g;
                long longValue = this.f56711e.forum.forum_id.longValue();
                cVar.a(longValue, this.f56711e.thread_id + "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(long j, String str);

        void b(boolean z);
    }

    public e(Context context) {
        this.f56701a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f56702b = inflate;
        this.f56703c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f56704d = (ImageView) this.f56702b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f56705e = (TextView) this.f56702b.findViewById(R.id.chosen_post_info_praise_num);
        this.f56706f = (TextView) this.f56702b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        if (this.j == null) {
            this.j = AnimationUtils.loadAnimation(this.f56701a, R.anim.praise_animation_scale3);
        }
        return this.j;
    }

    public View h() {
        return this.f56702b;
    }

    public void i(c cVar) {
        this.f56707g = cVar;
    }

    public void j(int i2) {
        TextView textView = this.f56703c;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView = this.f56706f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void l(long j) {
        if (j < 0) {
            return;
        }
        this.f56709i = j;
        TextView textView = this.f56705e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f56705e.setText(this.f56701a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.f56705e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f56705e.setVisibility(0);
    }

    public void m(boolean z) {
        p(z);
        if (z) {
            this.f56709i++;
        } else {
            this.f56709i--;
        }
        l(this.f56709i);
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
        this.f56704d.setOnClickListener(new a());
        k(new b(excellentPbThreadInfo));
    }

    public final void p(boolean z) {
        this.f56708h = z;
        if (z) {
            SkinManager.setImageResource(this.f56704d, R.drawable.btn_zambia_big_s);
        } else {
            SkinManager.setImageResource(this.f56704d, R.drawable.btn_zambia_big_n);
        }
        this.f56704d.setVisibility(0);
    }
}
