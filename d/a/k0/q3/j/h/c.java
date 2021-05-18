package d.a.k0.q3.j.h;

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
import d.a.k0.q3.j.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.a.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f60015a;

    /* renamed from: b  reason: collision with root package name */
    public CoverSeekBar f60016b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f60017c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.q3.j.h.a f60018d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f60019e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.q3.j.c.a f60020f;

    /* renamed from: g  reason: collision with root package name */
    public CoverPendantDragView f60021g;

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.k0.q3.j.c.a.b
        public void a(View view, int i2, PendantData pendantData) {
            c.this.f60021g.u(view, pendantData);
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
            int duration = (int) ((c.this.f60018d.x().getDuration() * i2) / 1000);
            c.this.f60016b.setProgressImage(i2, duration);
            c.this.f60018d.x().seekTo(duration);
        }
    }

    /* renamed from: d.a.k0.q3.j.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1565c extends AnimatorListenerAdapter {
        public C1565c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.f60017c.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f60016b.k(c.this.f60016b.getCurrentPosition());
            c.this.f60018d.G();
        }
    }

    public c(f fVar, d.a.k0.q3.j.h.a aVar) {
        super(fVar);
        this.f60018d = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.f60015a = inflate;
        inflate.getResources();
        o();
    }

    public int getCurrentPosition() {
        return this.f60016b.getCurrentPosition();
    }

    public Bitmap h(Bitmap bitmap) {
        this.f60021g.A();
        String text = this.f60021g.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.f60018d.x().getWidth();
        int height = this.f60018d.x().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.f60021g.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.f60018d.x().getLeft(), this.f60018d.x().getTop(), width, height, matrix, true);
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
        return this.f60015a;
    }

    public String l() {
        return this.f60021g.getText();
    }

    public void m() {
        this.f60021g.A();
    }

    public void n(View view) {
        CoverPendantDragView coverPendantDragView = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.f60021g = coverPendantDragView;
        coverPendantDragView.setParentViewController(this);
        this.f60017c = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (d.a.j0.r.d0.b.j().g("video_cover_first_in", true)) {
            this.f60017c.setVisibility(0);
            this.f60017c.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new C1565c()).start();
            d.a.j0.r.d0.b.j().t("video_cover_first_in", false);
        }
    }

    public final void o() {
        this.f60016b = (CoverSeekBar) this.f60015a.findViewById(R.id.cover_seek_bar);
        this.f60019e = (HListView) this.f60015a.findViewById(R.id.pendant_list_view);
        d.a.k0.q3.j.c.a aVar = new d.a.k0.q3.j.c.a(getPageContext());
        this.f60020f = aVar;
        aVar.d(new a());
        this.f60019e.setAdapter((ListAdapter) this.f60020f);
        this.f60020f.c(j());
        this.f60016b.setOnProgressChanged(new b());
    }

    public void p(f fVar, int i2) {
        SkinManager.setBackgroundColor(this.f60015a, R.color.CAM_X0201);
    }

    public void q() {
    }

    public void r() {
        d.a.c.e.m.e.a().postDelayed(new d(), 500L);
    }

    public void s(boolean z) {
        this.f60021g.K(z);
        if (z) {
            CoverSeekBar coverSeekBar = this.f60016b;
            coverSeekBar.k(coverSeekBar.getCurrentPosition());
        }
    }

    public void t() {
        CoverSeekBar coverSeekBar = this.f60016b;
        if (coverSeekBar != null) {
            coverSeekBar.j();
        }
        CoverPendantDragView coverPendantDragView = this.f60021g;
        if (coverPendantDragView != null) {
            coverPendantDragView.I();
        }
    }

    public void u() {
        this.f60021g.setVideoSize(this.f60018d.x().getWidth(), this.f60018d.x().getHeight());
        this.f60021g.setVideoLocation(this.f60018d.x().getLeft(), this.f60018d.x().getTop(), this.f60018d.x().getRight(), this.f60018d.x().getBottom());
    }

    public void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f60016b.setData(str);
    }

    public void w(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, j());
        this.f60020f.c(list);
    }
}
