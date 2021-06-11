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
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f56576a;

    /* renamed from: b  reason: collision with root package name */
    public View f56577b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56578c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f56579d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56580e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56581f;

    /* renamed from: g  reason: collision with root package name */
    public c f56582g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56583h;
    public Animation j;

    /* renamed from: i  reason: collision with root package name */
    public long f56584i = 0;
    public boolean k = false;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.k && ViewHelper.checkUpIsLogin(e.this.f56576a)) {
                e.this.k = true;
                e.this.f56579d.startAnimation(e.this.g());
                if (e.this.f56582g != null) {
                    e.this.f56582g.b(e.this.f56583h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f56586e;

        public b(ExcellentPbThreadInfo excellentPbThreadInfo) {
            this.f56586e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f56582g != null) {
                c cVar = e.this.f56582g;
                long longValue = this.f56586e.forum.forum_id.longValue();
                cVar.a(longValue, this.f56586e.thread_id + "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(long j, String str);

        void b(boolean z);
    }

    public e(Context context) {
        this.f56576a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f56577b = inflate;
        this.f56578c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f56579d = (ImageView) this.f56577b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f56580e = (TextView) this.f56577b.findViewById(R.id.chosen_post_info_praise_num);
        this.f56581f = (TextView) this.f56577b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        if (this.j == null) {
            this.j = AnimationUtils.loadAnimation(this.f56576a, R.anim.praise_animation_scale3);
        }
        return this.j;
    }

    public View h() {
        return this.f56577b;
    }

    public void i(c cVar) {
        this.f56582g = cVar;
    }

    public void j(int i2) {
        TextView textView = this.f56578c;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView = this.f56581f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void l(long j) {
        if (j < 0) {
            return;
        }
        this.f56584i = j;
        TextView textView = this.f56580e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f56580e.setText(this.f56576a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.f56580e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f56580e.setVisibility(0);
    }

    public void m(boolean z) {
        p(z);
        if (z) {
            this.f56584i++;
        } else {
            this.f56584i--;
        }
        l(this.f56584i);
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
        this.f56579d.setOnClickListener(new a());
        k(new b(excellentPbThreadInfo));
    }

    public final void p(boolean z) {
        this.f56583h = z;
        if (z) {
            SkinManager.setImageResource(this.f56579d, R.drawable.btn_zambia_big_s);
        } else {
            SkinManager.setImageResource(this.f56579d, R.drawable.btn_zambia_big_n);
        }
        this.f56579d.setVisibility(0);
    }
}
