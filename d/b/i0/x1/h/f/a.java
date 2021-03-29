package d.b.i0.x1.h.f;

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
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener, d.b.i0.l0.y.d.c {

    /* renamed from: e  reason: collision with root package name */
    public View f62481e;

    /* renamed from: f  reason: collision with root package name */
    public View f62482f;

    /* renamed from: g  reason: collision with root package name */
    public View f62483g;

    /* renamed from: h  reason: collision with root package name */
    public View f62484h;
    public ImageView i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public Animation m = null;
    public TbPageContext n;
    public int o;
    public d.b.i0.l0.y.d.a p;

    /* renamed from: d.b.i0.x1.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1668a implements Runnable {

        /* renamed from: d.b.i0.x1.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1669a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f62486e;

            public RunnableC1669a(int i) {
                this.f62486e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f62486e >= 30) {
                    l.L(a.this.n.getPageActivity(), String.format(a.this.n.getString(R.string.emotion_create_tip), 30));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(a.this.n.getPageActivity(), true, 25021)));
                }
            }
        }

        public RunnableC1668a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2 = d.b.i0.x1.c.i().f();
            d.b.b.e.m.e.a().post(new RunnableC1669a(f2 == null ? 0 : f2.size()));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: d.b.i0.x1.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1670a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f62489e;

            public RunnableC1670a(int i) {
                this.f62489e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f62489e >= 30) {
                    l.L(a.this.n.getPageActivity(), String.format(a.this.n.getString(R.string.emotion_create_tip), 30));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(a.this.n.getPageActivity(), 25021)));
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2 = d.b.i0.x1.c.i().f();
            d.b.b.e.m.e.a().post(new RunnableC1670a(f2 == null ? 0 : f2.size()));
        }
    }

    public a(TbPageContext tbPageContext, int i) {
        this.n = tbPageContext;
        this.o = i;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_native_manager_create_layout, (ViewGroup) null);
        this.f62483g = inflate;
        this.f62481e = inflate.findViewById(R.id.emotion_manager_add_layout);
        View findViewById = this.f62483g.findViewById(R.id.emotion_manager_create);
        this.f62482f = findViewById;
        findViewById.setOnClickListener(this);
        this.f62481e.setVisibility(0);
        View findViewById2 = this.f62483g.findViewById(R.id.emotion_manager_upload_status);
        this.f62484h = findViewById2;
        findViewById2.setClickable(false);
        this.f62484h.setOnClickListener(this);
        this.f62484h.setVisibility(8);
        this.i = (ImageView) this.f62483g.findViewById(R.id.uploading_status_img);
        this.j = (ImageView) this.f62483g.findViewById(R.id.icon_add);
        this.k = (TextView) this.f62483g.findViewById(R.id.add_emotion_tv);
        this.l = (TextView) this.f62483g.findViewById(R.id.add_emotion_manager_upload_status);
    }

    @Override // d.b.i0.l0.y.d.c
    public void a() {
        d.b.i0.x1.a.b().a(new b());
    }

    @Override // d.b.i0.l0.y.d.c
    public void b() {
        d.b.i0.x1.a.b().a(new RunnableC1668a());
    }

    public void d() {
        ImageView imageView = this.i;
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
        return this.f62483g;
    }

    public void g(int i) {
        View view = this.f62481e;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i);
        }
        TextView textView = this.l;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i);
        }
        View view2 = this.f62484h;
        if (view2 != null) {
            SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i);
        }
        ImageView imageView2 = this.i;
        if (imageView2 != null) {
            SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    public void h() {
        d.b.i0.l0.y.d.a aVar = this.p;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.p.dismiss();
    }

    public void i() {
        d.b.i0.l0.y.d.a aVar = this.p;
        if (aVar != null) {
            aVar.dismiss();
        }
        d();
        this.f62484h.setVisibility(8);
        this.f62481e.setVisibility(0);
    }

    public void j() {
        d.b.i0.l0.y.d.a aVar = this.p;
        if (aVar != null) {
            aVar.dismiss();
        }
        k();
        this.f62484h.setVisibility(0);
        this.f62481e.setVisibility(8);
        SkinManager.setBackgroundColor(this.f62484h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.i, R.drawable.emotion_uploading_bar_refresh);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0302);
        this.l.setText(R.string.emotion_uploading);
        this.f62484h.setClickable(false);
    }

    public void k() {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.startAnimation(e());
        }
    }

    public void l() {
        FaceGroupDraft k = d.b.i0.x1.g.e.l().k();
        if (k != null && TextUtils.isEmpty(k.getFailMsg())) {
            l.L(this.n.getPageActivity(), k.getFailMsg());
        }
        m(null);
    }

    public void m(String str) {
        d.b.i0.l0.y.d.a aVar = this.p;
        if (aVar != null) {
            aVar.dismiss();
        }
        d();
        this.f62484h.setVisibility(0);
        this.f62481e.setVisibility(8);
        SkinManager.setBackgroundColor(this.f62484h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.i, R.drawable.emotion_update_fail);
        SkinManager.setViewTextColor(this.l, R.color.common_color_10037);
        if (!TextUtils.isEmpty(str)) {
            this.l.setText(str);
        } else {
            this.l.setText(R.string.emotion_center_upload_failed);
        }
        this.f62484h.setClickable(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f62482f != null && view.getId() == this.f62482f.getId() && this.f62482f.isShown()) {
            if (this.o == 1) {
                if (this.p == null) {
                    d.b.i0.l0.y.d.a aVar = new d.b.i0.l0.y.d.a(this.n.getPageActivity(), this.o);
                    this.p = aVar;
                    aVar.d(this);
                }
                this.p.c(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.n.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.p.showAtLocation(this.f62483g, 81, 0, this.n.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            } else {
                a();
            }
        }
        if (this.f62484h != null && view.getId() == this.f62484h.getId() && this.f62484h.isShown()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.n.getPageActivity(), this.o == 1, 25021)));
        }
    }
}
