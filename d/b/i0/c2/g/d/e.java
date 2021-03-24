package d.b.i0.c2.g.d;

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
    public Context f52388a;

    /* renamed from: b  reason: collision with root package name */
    public View f52389b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52390c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f52391d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52392e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f52393f;

    /* renamed from: g  reason: collision with root package name */
    public c f52394g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52395h;
    public Animation j;
    public long i = 0;
    public boolean k = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.k && ViewHelper.checkUpIsLogin(e.this.f52388a)) {
                e.this.k = true;
                e.this.f52391d.startAnimation(e.this.g());
                if (e.this.f52394g != null) {
                    e.this.f52394g.b(e.this.f52395h);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f52397e;

        public b(ExcellentPbThreadInfo excellentPbThreadInfo) {
            this.f52397e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52394g != null) {
                c cVar = e.this.f52394g;
                long longValue = this.f52397e.forum.forum_id.longValue();
                cVar.a(longValue, this.f52397e.thread_id + "");
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(long j, String str);

        void b(boolean z);
    }

    public e(Context context) {
        this.f52388a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f52389b = inflate;
        this.f52390c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f52391d = (ImageView) this.f52389b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f52392e = (TextView) this.f52389b.findViewById(R.id.chosen_post_info_praise_num);
        this.f52393f = (TextView) this.f52389b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        if (this.j == null) {
            this.j = AnimationUtils.loadAnimation(this.f52388a, R.anim.praise_animation_scale3);
        }
        return this.j;
    }

    public View h() {
        return this.f52389b;
    }

    public void i(c cVar) {
        this.f52394g = cVar;
    }

    public void j(int i) {
        TextView textView = this.f52390c;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView = this.f52393f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void l(long j) {
        if (j < 0) {
            return;
        }
        this.i = j;
        TextView textView = this.f52392e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f52392e.setText(this.f52388a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.f52392e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f52392e.setVisibility(0);
    }

    public void m(boolean z) {
        p(z);
        if (z) {
            this.i++;
        } else {
            this.i--;
        }
        l(this.i);
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
        this.f52391d.setOnClickListener(new a());
        k(new b(excellentPbThreadInfo));
    }

    public final void p(boolean z) {
        this.f52395h = z;
        if (z) {
            SkinManager.setImageResource(this.f52391d, R.drawable.btn_zambia_big_s);
        } else {
            SkinManager.setImageResource(this.f52391d, R.drawable.btn_zambia_big_n);
        }
        this.f52391d.setVisibility(0);
    }
}
