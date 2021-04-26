package d.a.j0.y1.h.f;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener, d.a.j0.l0.y.d.c {

    /* renamed from: e  reason: collision with root package name */
    public View f62867e;

    /* renamed from: f  reason: collision with root package name */
    public View f62868f;

    /* renamed from: g  reason: collision with root package name */
    public View f62869g;

    /* renamed from: h  reason: collision with root package name */
    public View f62870h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f62871i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public Animation m = null;
    public TbPageContext n;
    public int o;
    public d.a.j0.l0.y.d.a p;

    /* renamed from: d.a.j0.y1.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1687a implements Runnable {

        /* renamed from: d.a.j0.y1.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1688a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f62873e;

            public RunnableC1688a(int i2) {
                this.f62873e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f62873e >= 30) {
                    l.M(a.this.n.getPageActivity(), String.format(a.this.n.getString(R.string.emotion_create_tip), 30));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(a.this.n.getPageActivity(), true, 25021)));
                }
            }
        }

        public RunnableC1687a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2 = d.a.j0.y1.c.i().f();
            d.a.c.e.m.e.a().post(new RunnableC1688a(f2 == null ? 0 : f2.size()));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: d.a.j0.y1.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1689a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f62876e;

            public RunnableC1689a(int i2) {
                this.f62876e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f62876e >= 30) {
                    l.M(a.this.n.getPageActivity(), String.format(a.this.n.getString(R.string.emotion_create_tip), 30));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(a.this.n.getPageActivity(), 25021)));
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2 = d.a.j0.y1.c.i().f();
            d.a.c.e.m.e.a().post(new RunnableC1689a(f2 == null ? 0 : f2.size()));
        }
    }

    public a(TbPageContext tbPageContext, int i2) {
        this.n = tbPageContext;
        this.o = i2;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_native_manager_create_layout, (ViewGroup) null);
        this.f62869g = inflate;
        this.f62867e = inflate.findViewById(R.id.emotion_manager_add_layout);
        View findViewById = this.f62869g.findViewById(R.id.emotion_manager_create);
        this.f62868f = findViewById;
        findViewById.setOnClickListener(this);
        this.f62867e.setVisibility(0);
        View findViewById2 = this.f62869g.findViewById(R.id.emotion_manager_upload_status);
        this.f62870h = findViewById2;
        findViewById2.setClickable(false);
        this.f62870h.setOnClickListener(this);
        this.f62870h.setVisibility(8);
        this.f62871i = (ImageView) this.f62869g.findViewById(R.id.uploading_status_img);
        this.j = (ImageView) this.f62869g.findViewById(R.id.icon_add);
        this.k = (TextView) this.f62869g.findViewById(R.id.add_emotion_tv);
        this.l = (TextView) this.f62869g.findViewById(R.id.add_emotion_manager_upload_status);
    }

    @Override // d.a.j0.l0.y.d.c
    public void a() {
        d.a.j0.y1.a.b().a(new b());
    }

    @Override // d.a.j0.l0.y.d.c
    public void b() {
        d.a.j0.y1.a.b().a(new RunnableC1687a());
    }

    public void d() {
        ImageView imageView = this.f62871i;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public final Animation e() {
        if (this.m == null) {
            this.m = AnimationUtils.loadAnimation(this.n.getPageActivity(), R.anim.refresh_rotate);
            this.m.setInterpolator(new LinearInterpolator());
            this.m.setFillAfter(true);
        }
        return this.m;
    }

    public View f() {
        return this.f62869g;
    }

    public void g(int i2) {
        View view = this.f62867e;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i2);
        }
        TextView textView = this.l;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i2);
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i2);
        }
        View view2 = this.f62870h;
        if (view2 != null) {
            SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i2);
        }
        ImageView imageView2 = this.f62871i;
        if (imageView2 != null) {
            SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    public void h() {
        d.a.j0.l0.y.d.a aVar = this.p;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.p.dismiss();
    }

    public void i() {
        d.a.j0.l0.y.d.a aVar = this.p;
        if (aVar != null) {
            aVar.dismiss();
        }
        d();
        this.f62870h.setVisibility(8);
        this.f62867e.setVisibility(0);
    }

    public void j() {
        d.a.j0.l0.y.d.a aVar = this.p;
        if (aVar != null) {
            aVar.dismiss();
        }
        k();
        this.f62870h.setVisibility(0);
        this.f62867e.setVisibility(8);
        SkinManager.setBackgroundColor(this.f62870h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.f62871i, R.drawable.emotion_uploading_bar_refresh);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0302);
        this.l.setText(R.string.emotion_uploading);
        this.f62870h.setClickable(false);
    }

    public void k() {
        ImageView imageView = this.f62871i;
        if (imageView != null) {
            imageView.startAnimation(e());
        }
    }

    public void l() {
        FaceGroupDraft k = d.a.j0.y1.g.e.l().k();
        if (k != null && TextUtils.isEmpty(k.getFailMsg())) {
            l.M(this.n.getPageActivity(), k.getFailMsg());
        }
        m(null);
    }

    public void m(String str) {
        d.a.j0.l0.y.d.a aVar = this.p;
        if (aVar != null) {
            aVar.dismiss();
        }
        d();
        this.f62870h.setVisibility(0);
        this.f62867e.setVisibility(8);
        SkinManager.setBackgroundColor(this.f62870h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.f62871i, R.drawable.emotion_update_fail);
        SkinManager.setViewTextColor(this.l, R.color.common_color_10037);
        if (!TextUtils.isEmpty(str)) {
            this.l.setText(str);
        } else {
            this.l.setText(R.string.emotion_center_upload_failed);
        }
        this.f62870h.setClickable(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f62868f != null && view.getId() == this.f62868f.getId() && this.f62868f.isShown()) {
            if (this.o == 1) {
                if (this.p == null) {
                    d.a.j0.l0.y.d.a aVar = new d.a.j0.l0.y.d.a(this.n.getPageActivity(), this.o);
                    this.p = aVar;
                    aVar.d(this);
                }
                this.p.c(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.n.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.p.showAtLocation(this.f62869g, 81, 0, this.n.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            } else {
                a();
            }
        }
        if (this.f62870h != null && view.getId() == this.f62870h.getId() && this.f62870h.isShown()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.n.getPageActivity(), this.o == 1, 25021)));
        }
    }
}
