package d.b.i0.d2.g.d;

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
    public Context f53784a;

    /* renamed from: b  reason: collision with root package name */
    public View f53785b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53786c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f53787d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53788e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53789f;

    /* renamed from: g  reason: collision with root package name */
    public c f53790g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53791h;
    public Animation j;
    public long i = 0;
    public boolean k = false;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.k && ViewHelper.checkUpIsLogin(e.this.f53784a)) {
                e.this.k = true;
                e.this.f53787d.startAnimation(e.this.g());
                if (e.this.f53790g != null) {
                    e.this.f53790g.b(e.this.f53791h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f53793e;

        public b(ExcellentPbThreadInfo excellentPbThreadInfo) {
            this.f53793e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f53790g != null) {
                c cVar = e.this.f53790g;
                long longValue = this.f53793e.forum.forum_id.longValue();
                cVar.a(longValue, this.f53793e.thread_id + "");
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(long j, String str);

        void b(boolean z);
    }

    public e(Context context) {
        this.f53784a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f53785b = inflate;
        this.f53786c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f53787d = (ImageView) this.f53785b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f53788e = (TextView) this.f53785b.findViewById(R.id.chosen_post_info_praise_num);
        this.f53789f = (TextView) this.f53785b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        if (this.j == null) {
            this.j = AnimationUtils.loadAnimation(this.f53784a, R.anim.praise_animation_scale3);
        }
        return this.j;
    }

    public View h() {
        return this.f53785b;
    }

    public void i(c cVar) {
        this.f53790g = cVar;
    }

    public void j(int i) {
        TextView textView = this.f53786c;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView = this.f53789f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void l(long j) {
        if (j < 0) {
            return;
        }
        this.i = j;
        TextView textView = this.f53788e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f53788e.setText(this.f53784a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.f53788e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f53788e.setVisibility(0);
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
        this.f53787d.setOnClickListener(new a());
        k(new b(excellentPbThreadInfo));
    }

    public final void p(boolean z) {
        this.f53791h = z;
        if (z) {
            SkinManager.setImageResource(this.f53787d, R.drawable.btn_zambia_big_s);
        } else {
            SkinManager.setImageResource(this.f53787d, R.drawable.btn_zambia_big_n);
        }
        this.f53787d.setVisibility(0);
    }
}
