package d.a.j0.q3.j.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverPendantDragView;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import d.a.c.a.f;
import d.a.j0.q3.j.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.a.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f59270a;

    /* renamed from: b  reason: collision with root package name */
    public CoverSeekBar f59271b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f59272c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.q3.j.h.a f59273d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f59274e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.q3.j.c.a f59275f;

    /* renamed from: g  reason: collision with root package name */
    public CoverPendantDragView f59276g;

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.j0.q3.j.c.a.b
        public void a(View view, int i2, PendantData pendantData) {
            c.this.f59276g.u(view, pendantData);
            StatisticItem statisticItem = new StatisticItem("c12305");
            statisticItem.param("obj_locate", i2 + 1);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CoverSeekBar.d {
        public b() {
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void a() {
            TiebaStatic.log("c12304");
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void b() {
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void onProgress(int i2) {
            int duration = (int) ((c.this.f59273d.x().getDuration() * i2) / 1000);
            c.this.f59271b.setProgressImage(i2, duration);
            c.this.f59273d.x().seekTo(duration);
        }
    }

    /* renamed from: d.a.j0.q3.j.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1491c extends AnimatorListenerAdapter {
        public C1491c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.f59272c.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f59271b.k(c.this.f59271b.getCurrentPosition());
            c.this.f59273d.G();
        }
    }

    public c(f fVar, d.a.j0.q3.j.h.a aVar) {
        super(fVar);
        this.f59273d = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.f59270a = inflate;
        inflate.getResources();
        o();
    }

    public int getCurrentPosition() {
        return this.f59271b.getCurrentPosition();
    }

    public Bitmap h(Bitmap bitmap) {
        this.f59276g.A();
        String text = this.f59276g.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.f59273d.x().getWidth();
        int height = this.f59273d.x().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.f59276g.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.f59273d.x().getLeft(), this.f59273d.x().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public final List<PendantData> j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public View k() {
        return this.f59270a;
    }

    public String l() {
        return this.f59276g.getText();
    }

    public void m() {
        this.f59276g.A();
    }

    public void n(View view) {
        CoverPendantDragView coverPendantDragView = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.f59276g = coverPendantDragView;
        coverPendantDragView.setParentViewController(this);
        this.f59272c = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (d.a.i0.r.d0.b.j().g("video_cover_first_in", true)) {
            this.f59272c.setVisibility(0);
            this.f59272c.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new C1491c()).start();
            d.a.i0.r.d0.b.j().t("video_cover_first_in", false);
        }
    }

    public final void o() {
        this.f59271b = (CoverSeekBar) this.f59270a.findViewById(R.id.cover_seek_bar);
        this.f59274e = (HListView) this.f59270a.findViewById(R.id.pendant_list_view);
        d.a.j0.q3.j.c.a aVar = new d.a.j0.q3.j.c.a(getPageContext());
        this.f59275f = aVar;
        aVar.d(new a());
        this.f59274e.setAdapter((ListAdapter) this.f59275f);
        this.f59275f.c(j());
        this.f59271b.setOnProgressChanged(new b());
    }

    public void p(f fVar, int i2) {
        SkinManager.setBackgroundColor(this.f59270a, R.color.CAM_X0201);
    }

    public void q() {
    }

    public void r() {
        d.a.c.e.m.e.a().postDelayed(new d(), 500L);
    }

    public void s(boolean z) {
        this.f59276g.K(z);
        if (z) {
            CoverSeekBar coverSeekBar = this.f59271b;
            coverSeekBar.k(coverSeekBar.getCurrentPosition());
        }
    }

    public void t() {
        CoverSeekBar coverSeekBar = this.f59271b;
        if (coverSeekBar != null) {
            coverSeekBar.j();
        }
        CoverPendantDragView coverPendantDragView = this.f59276g;
        if (coverPendantDragView != null) {
            coverPendantDragView.I();
        }
    }

    public void u() {
        this.f59276g.setVideoSize(this.f59273d.x().getWidth(), this.f59273d.x().getHeight());
        this.f59276g.setVideoLocation(this.f59273d.x().getLeft(), this.f59273d.x().getTop(), this.f59273d.x().getRight(), this.f59273d.x().getBottom());
    }

    public void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f59271b.setData(str);
    }

    public void w(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, j());
        this.f59275f.c(list);
    }
}
