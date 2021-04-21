package d.b.j0.q3.j.h;

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
import d.b.c.a.f;
import d.b.j0.q3.j.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.b.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f61133a;

    /* renamed from: b  reason: collision with root package name */
    public CoverSeekBar f61134b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61135c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.q3.j.h.a f61136d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f61137e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.q3.j.c.a f61138f;

    /* renamed from: g  reason: collision with root package name */
    public CoverPendantDragView f61139g;

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.j0.q3.j.c.a.b
        public void a(View view, int i, PendantData pendantData) {
            c.this.f61139g.u(view, pendantData);
            StatisticItem statisticItem = new StatisticItem("c12305");
            statisticItem.param("obj_locate", i + 1);
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
        public void onProgress(int i) {
            int duration = (int) ((c.this.f61136d.z().getDuration() * i) / 1000);
            c.this.f61134b.setProgressImage(i, duration);
            c.this.f61136d.z().seekTo(duration);
        }
    }

    /* renamed from: d.b.j0.q3.j.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1552c extends AnimatorListenerAdapter {
        public C1552c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.f61135c.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f61134b.k(c.this.f61134b.getCurrentPosition());
            c.this.f61136d.I();
        }
    }

    public c(f fVar, d.b.j0.q3.j.h.a aVar) {
        super(fVar);
        this.f61136d = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.f61133a = inflate;
        inflate.getResources();
        o();
    }

    public int getCurrentPosition() {
        return this.f61134b.getCurrentPosition();
    }

    public Bitmap h(Bitmap bitmap) {
        this.f61139g.A();
        String text = this.f61139g.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.f61136d.z().getWidth();
        int height = this.f61136d.z().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.f61139g.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.f61136d.z().getLeft(), this.f61136d.z().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public final List<PendantData> i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public View k() {
        return this.f61133a;
    }

    public String l() {
        return this.f61139g.getText();
    }

    public void m() {
        this.f61139g.A();
    }

    public void n(View view) {
        CoverPendantDragView coverPendantDragView = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.f61139g = coverPendantDragView;
        coverPendantDragView.setParentViewController(this);
        this.f61135c = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (d.b.i0.r.d0.b.j().g("video_cover_first_in", true)) {
            this.f61135c.setVisibility(0);
            this.f61135c.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new C1552c()).start();
            d.b.i0.r.d0.b.j().t("video_cover_first_in", false);
        }
    }

    public final void o() {
        this.f61134b = (CoverSeekBar) this.f61133a.findViewById(R.id.cover_seek_bar);
        this.f61137e = (HListView) this.f61133a.findViewById(R.id.pendant_list_view);
        d.b.j0.q3.j.c.a aVar = new d.b.j0.q3.j.c.a(getPageContext());
        this.f61138f = aVar;
        aVar.d(new a());
        this.f61137e.setAdapter((ListAdapter) this.f61138f);
        this.f61138f.c(i());
        this.f61134b.setOnProgressChanged(new b());
    }

    public void q(f fVar, int i) {
        SkinManager.setBackgroundColor(this.f61133a, R.color.CAM_X0201);
    }

    public void r() {
    }

    public void s() {
        d.b.c.e.m.e.a().postDelayed(new d(), 500L);
    }

    public void u(boolean z) {
        this.f61139g.K(z);
        if (z) {
            CoverSeekBar coverSeekBar = this.f61134b;
            coverSeekBar.k(coverSeekBar.getCurrentPosition());
        }
    }

    public void v() {
        CoverSeekBar coverSeekBar = this.f61134b;
        if (coverSeekBar != null) {
            coverSeekBar.j();
        }
        CoverPendantDragView coverPendantDragView = this.f61139g;
        if (coverPendantDragView != null) {
            coverPendantDragView.I();
        }
    }

    public void w() {
        this.f61139g.setVideoSize(this.f61136d.z().getWidth(), this.f61136d.z().getHeight());
        this.f61139g.setVideoLocation(this.f61136d.z().getLeft(), this.f61136d.z().getTop(), this.f61136d.z().getRight(), this.f61136d.z().getBottom());
    }

    public void x(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f61134b.setData(str);
    }

    public void y(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, i());
        this.f61138f.c(list);
    }
}
