package d.b.i0.q3.j.h;

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
import d.b.i0.q3.j.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.b.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f60712a;

    /* renamed from: b  reason: collision with root package name */
    public CoverSeekBar f60713b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f60714c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.q3.j.h.a f60715d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f60716e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.q3.j.c.a f60717f;

    /* renamed from: g  reason: collision with root package name */
    public CoverPendantDragView f60718g;

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.i0.q3.j.c.a.b
        public void a(View view, int i, PendantData pendantData) {
            c.this.f60718g.u(view, pendantData);
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
            int duration = (int) ((c.this.f60715d.z().getDuration() * i) / 1000);
            c.this.f60713b.setProgressImage(i, duration);
            c.this.f60715d.z().seekTo(duration);
        }
    }

    /* renamed from: d.b.i0.q3.j.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1529c extends AnimatorListenerAdapter {
        public C1529c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.f60714c.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f60713b.k(c.this.f60713b.getCurrentPosition());
            c.this.f60715d.I();
        }
    }

    public c(f fVar, d.b.i0.q3.j.h.a aVar) {
        super(fVar);
        this.f60715d = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.f60712a = inflate;
        inflate.getResources();
        o();
    }

    public int getCurrentPosition() {
        return this.f60713b.getCurrentPosition();
    }

    public Bitmap h(Bitmap bitmap) {
        this.f60718g.A();
        String text = this.f60718g.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.f60715d.z().getWidth();
        int height = this.f60715d.z().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.f60718g.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.f60715d.z().getLeft(), this.f60715d.z().getTop(), width, height, matrix, true);
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
        return this.f60712a;
    }

    public String l() {
        return this.f60718g.getText();
    }

    public void m() {
        this.f60718g.A();
    }

    public void n(View view) {
        CoverPendantDragView coverPendantDragView = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.f60718g = coverPendantDragView;
        coverPendantDragView.setParentViewController(this);
        this.f60714c = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (d.b.h0.r.d0.b.j().g("video_cover_first_in", true)) {
            this.f60714c.setVisibility(0);
            this.f60714c.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new C1529c()).start();
            d.b.h0.r.d0.b.j().t("video_cover_first_in", false);
        }
    }

    public final void o() {
        this.f60713b = (CoverSeekBar) this.f60712a.findViewById(R.id.cover_seek_bar);
        this.f60716e = (HListView) this.f60712a.findViewById(R.id.pendant_list_view);
        d.b.i0.q3.j.c.a aVar = new d.b.i0.q3.j.c.a(getPageContext());
        this.f60717f = aVar;
        aVar.d(new a());
        this.f60716e.setAdapter((ListAdapter) this.f60717f);
        this.f60717f.c(i());
        this.f60713b.setOnProgressChanged(new b());
    }

    public void q(f fVar, int i) {
        SkinManager.setBackgroundColor(this.f60712a, R.color.CAM_X0201);
    }

    public void r() {
    }

    public void s() {
        d.b.c.e.m.e.a().postDelayed(new d(), 500L);
    }

    public void u(boolean z) {
        this.f60718g.K(z);
        if (z) {
            CoverSeekBar coverSeekBar = this.f60713b;
            coverSeekBar.k(coverSeekBar.getCurrentPosition());
        }
    }

    public void v() {
        CoverSeekBar coverSeekBar = this.f60713b;
        if (coverSeekBar != null) {
            coverSeekBar.j();
        }
        CoverPendantDragView coverPendantDragView = this.f60718g;
        if (coverPendantDragView != null) {
            coverPendantDragView.I();
        }
    }

    public void w() {
        this.f60718g.setVideoSize(this.f60715d.z().getWidth(), this.f60715d.z().getHeight());
        this.f60718g.setVideoLocation(this.f60715d.z().getLeft(), this.f60715d.z().getTop(), this.f60715d.z().getRight(), this.f60715d.z().getBottom());
    }

    public void x(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f60713b.setData(str);
    }

    public void y(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, i());
        this.f60717f.c(list);
    }
}
