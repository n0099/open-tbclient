package d.a.n0.z.d0;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import d.a.m0.r.q.a2;
import d.a.n0.k2.e;
import d.a.n0.k2.f;
/* loaded from: classes4.dex */
public class a implements e {

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f63453e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f63454f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f63455g;

    /* renamed from: i  reason: collision with root package name */
    public f f63457i;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63456h = false;
    public f.b j = new C1752a();

    /* renamed from: d.a.n0.z.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1752a implements f.b {
        public C1752a() {
        }

        @Override // d.a.n0.k2.f.b
        public void a() {
            a.this.b();
        }
    }

    public a(AlaVideoContainer alaVideoContainer) {
        this.f63453e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.f63457i = fVar;
            fVar.l(this.f63453e.getVideoView());
            this.f63457i.i(this.j);
        }
    }

    @Override // d.a.n0.k2.e
    public boolean C() {
        return false;
    }

    public final void b() {
        a2 a2Var = this.f63454f;
        if (a2Var == null || a2Var.w1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer = this.f63453e;
        if (alaVideoContainer != null) {
            alaVideoContainer.q();
        }
    }

    public void d(a2 a2Var, String str, String str2, boolean z) {
        if (a2Var == null) {
            return;
        }
        this.f63454f = a2Var;
        if (this.f63453e == null || a2Var.r1() == null) {
            return;
        }
        AlaInfoData r1 = this.f63454f.r1();
        this.f63455g = r1;
        this.f63453e.setVideoThumbnail(r1.cover);
        if (z) {
            this.f63453e.setTitle(this.f63454f.z1());
        } else {
            this.f63453e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f63453e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f63454f.r1().audience_count)));
    }

    @Override // d.a.n0.k2.e
    public int getCurrentPosition() {
        AlaVideoContainer alaVideoContainer = this.f63453e;
        if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
            return 0;
        }
        return this.f63453e.getVideoView().getCurrentPositionSync();
    }

    @Override // d.a.n0.k2.e
    public String getPlayUrl() {
        a2 a2Var = this.f63454f;
        if (a2Var == null || a2Var.w1() == null) {
            return null;
        }
        return this.f63454f.w1().video_url;
    }

    @Override // d.a.n0.k2.e
    public View getVideoContainer() {
        AlaVideoContainer alaVideoContainer = this.f63453e;
        if (alaVideoContainer != null) {
            return alaVideoContainer.getView();
        }
        return null;
    }

    @Override // d.a.n0.k2.e
    public boolean isPlayStarted() {
        return this.f63456h;
    }

    @Override // d.a.n0.k2.e
    public boolean isPlaying() {
        return false;
    }

    @Override // d.a.n0.k2.e
    public void startPlay() {
    }

    @Override // d.a.n0.k2.e
    public void stopPlay() {
        AlaVideoContainer alaVideoContainer = this.f63453e;
        if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
            this.f63453e.getVideoView().stopPlayback();
            this.f63453e.p();
            f fVar = this.f63457i;
            if (fVar != null) {
                fVar.n();
            }
        }
        this.f63456h = false;
    }
}
