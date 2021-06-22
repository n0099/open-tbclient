package d.a.o0.z.d0;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import d.a.n0.r.q.a2;
import d.a.o0.k2.e;
import d.a.o0.k2.f;
/* loaded from: classes4.dex */
public class a implements e {

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f67296e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f67297f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f67298g;

    /* renamed from: i  reason: collision with root package name */
    public f f67300i;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67299h = false;
    public f.b j = new C1814a();

    /* renamed from: d.a.o0.z.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1814a implements f.b {
        public C1814a() {
        }

        @Override // d.a.o0.k2.f.b
        public void a() {
            a.this.b();
        }
    }

    public a(AlaVideoContainer alaVideoContainer) {
        this.f67296e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.f67300i = fVar;
            fVar.l(this.f67296e.getVideoView());
            this.f67300i.i(this.j);
        }
    }

    @Override // d.a.o0.k2.e
    public boolean C() {
        return false;
    }

    public final void b() {
        a2 a2Var = this.f67297f;
        if (a2Var == null || a2Var.x1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer = this.f67296e;
        if (alaVideoContainer != null) {
            alaVideoContainer.q();
        }
    }

    public void d(a2 a2Var, String str, String str2, boolean z) {
        if (a2Var == null) {
            return;
        }
        this.f67297f = a2Var;
        if (this.f67296e == null || a2Var.s1() == null) {
            return;
        }
        AlaInfoData s1 = this.f67297f.s1();
        this.f67298g = s1;
        this.f67296e.setVideoThumbnail(s1.cover);
        if (z) {
            this.f67296e.setTitle(this.f67297f.A1());
        } else {
            this.f67296e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f67296e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f67297f.s1().audience_count)));
    }

    @Override // d.a.o0.k2.e
    public int getCurrentPosition() {
        AlaVideoContainer alaVideoContainer = this.f67296e;
        if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
            return 0;
        }
        return this.f67296e.getVideoView().getCurrentPositionSync();
    }

    @Override // d.a.o0.k2.e
    public String getPlayUrl() {
        a2 a2Var = this.f67297f;
        if (a2Var == null || a2Var.x1() == null) {
            return null;
        }
        return this.f67297f.x1().video_url;
    }

    @Override // d.a.o0.k2.e
    public View getVideoContainer() {
        AlaVideoContainer alaVideoContainer = this.f67296e;
        if (alaVideoContainer != null) {
            return alaVideoContainer.getView();
        }
        return null;
    }

    @Override // d.a.o0.k2.e
    public boolean isPlayStarted() {
        return this.f67299h;
    }

    @Override // d.a.o0.k2.e
    public boolean isPlaying() {
        return false;
    }

    @Override // d.a.o0.k2.e
    public void startPlay() {
    }

    @Override // d.a.o0.k2.e
    public void stopPlay() {
        AlaVideoContainer alaVideoContainer = this.f67296e;
        if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
            this.f67296e.getVideoView().stopPlayback();
            this.f67296e.p();
            f fVar = this.f67300i;
            if (fVar != null) {
                fVar.n();
            }
        }
        this.f67299h = false;
    }
}
