package d.a.o0.r3.i.h;

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
import d.a.o0.r3.i.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.a.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f63970a;

    /* renamed from: b  reason: collision with root package name */
    public CoverSeekBar f63971b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f63972c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.r3.i.h.a f63973d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f63974e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.r3.i.c.a f63975f;

    /* renamed from: g  reason: collision with root package name */
    public CoverPendantDragView f63976g;

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.o0.r3.i.c.a.b
        public void a(View view, int i2, PendantData pendantData) {
            c.this.f63976g.u(view, pendantData);
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
            int duration = (int) ((c.this.f63973d.x().getDuration() * i2) / 1000);
            c.this.f63971b.setProgressImage(i2, duration);
            c.this.f63973d.x().seekTo(duration);
        }
    }

    /* renamed from: d.a.o0.r3.i.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1638c extends AnimatorListenerAdapter {
        public C1638c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.f63972c.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f63971b.k(c.this.f63971b.getCurrentPosition());
            c.this.f63973d.G();
        }
    }

    public c(f fVar, d.a.o0.r3.i.h.a aVar) {
        super(fVar);
        this.f63973d = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.f63970a = inflate;
        inflate.getResources();
        o();
    }

    public int getCurrentPosition() {
        return this.f63971b.getCurrentPosition();
    }

    public Bitmap h(Bitmap bitmap) {
        this.f63976g.A();
        String text = this.f63976g.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.f63973d.x().getWidth();
        int height = this.f63973d.x().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.f63976g.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.f63973d.x().getLeft(), this.f63973d.x().getTop(), width, height, matrix, true);
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
        return this.f63970a;
    }

    public String l() {
        return this.f63976g.getText();
    }

    public void m() {
        this.f63976g.A();
    }

    public void n(View view) {
        CoverPendantDragView coverPendantDragView = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.f63976g = coverPendantDragView;
        coverPendantDragView.setParentViewController(this);
        this.f63972c = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (d.a.n0.r.d0.b.j().g("video_cover_first_in", true)) {
            this.f63972c.setVisibility(0);
            this.f63972c.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new C1638c()).start();
            d.a.n0.r.d0.b.j().t("video_cover_first_in", false);
        }
    }

    public final void o() {
        this.f63971b = (CoverSeekBar) this.f63970a.findViewById(R.id.cover_seek_bar);
        this.f63974e = (HListView) this.f63970a.findViewById(R.id.pendant_list_view);
        d.a.o0.r3.i.c.a aVar = new d.a.o0.r3.i.c.a(getPageContext());
        this.f63975f = aVar;
        aVar.d(new a());
        this.f63974e.setAdapter((ListAdapter) this.f63975f);
        this.f63975f.c(i());
        this.f63971b.setOnProgressChanged(new b());
    }

    public void p(f fVar, int i2) {
        SkinManager.setBackgroundColor(this.f63970a, R.color.CAM_X0201);
    }

    public void q() {
    }

    public void r() {
        d.a.c.e.m.e.a().postDelayed(new d(), 500L);
    }

    public void s(boolean z) {
        this.f63976g.K(z);
        if (z) {
            CoverSeekBar coverSeekBar = this.f63971b;
            coverSeekBar.k(coverSeekBar.getCurrentPosition());
        }
    }

    public void t() {
        CoverSeekBar coverSeekBar = this.f63971b;
        if (coverSeekBar != null) {
            coverSeekBar.j();
        }
        CoverPendantDragView coverPendantDragView = this.f63976g;
        if (coverPendantDragView != null) {
            coverPendantDragView.I();
        }
    }

    public void u() {
        this.f63976g.setVideoSize(this.f63973d.x().getWidth(), this.f63973d.x().getHeight());
        this.f63976g.setVideoLocation(this.f63973d.x().getLeft(), this.f63973d.x().getTop(), this.f63973d.x().getRight(), this.f63973d.x().getBottom());
    }

    public void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f63971b.setData(str);
    }

    public void w(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, i());
        this.f63975f.c(list);
    }
}
