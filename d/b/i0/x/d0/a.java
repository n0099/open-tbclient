package d.b.i0.x.d0;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import d.b.h0.r.q.a2;
import d.b.i0.i2.e;
import d.b.i0.i2.f;
/* loaded from: classes4.dex */
public class a implements e {

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f62191e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f62192f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f62193g;
    public f i;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62194h = false;
    public f.b j = new C1652a();

    /* renamed from: d.b.i0.x.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1652a implements f.b {
        public C1652a() {
        }

        @Override // d.b.i0.i2.f.b
        public void a() {
            a.this.b();
        }
    }

    public a(AlaVideoContainer alaVideoContainer) {
        this.f62191e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.i = fVar;
            fVar.l(this.f62191e.getVideoView());
            this.i.i(this.j);
        }
    }

    @Override // d.b.i0.i2.e
    public boolean D() {
        return false;
    }

    public final void b() {
        a2 a2Var = this.f62192f;
        if (a2Var == null || a2Var.u1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer = this.f62191e;
        if (alaVideoContainer != null) {
            alaVideoContainer.q();
        }
    }

    public void d(a2 a2Var, String str, String str2, boolean z) {
        if (a2Var == null) {
            return;
        }
        this.f62192f = a2Var;
        if (this.f62191e == null || a2Var.q1() == null) {
            return;
        }
        AlaInfoData q1 = this.f62192f.q1();
        this.f62193g = q1;
        this.f62191e.setVideoThumbnail(q1.cover);
        if (z) {
            this.f62191e.setTitle(this.f62192f.x1());
        } else {
            this.f62191e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f62191e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f62192f.q1().audience_count)));
    }

    @Override // d.b.i0.i2.e
    public int getCurrentPosition() {
        AlaVideoContainer alaVideoContainer = this.f62191e;
        if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
            return 0;
        }
        return this.f62191e.getVideoView().getCurrentPositionSync();
    }

    @Override // d.b.i0.i2.e
    public String getPlayUrl() {
        a2 a2Var = this.f62192f;
        if (a2Var == null || a2Var.u1() == null) {
            return null;
        }
        return this.f62192f.u1().video_url;
    }

    @Override // d.b.i0.i2.e
    public View getVideoContainer() {
        AlaVideoContainer alaVideoContainer = this.f62191e;
        if (alaVideoContainer != null) {
            return alaVideoContainer.getView();
        }
        return null;
    }

    @Override // d.b.i0.i2.e
    public boolean isPlayStarted() {
        return this.f62194h;
    }

    @Override // d.b.i0.i2.e
    public boolean isPlaying() {
        return false;
    }

    @Override // d.b.i0.i2.e
    public void startPlay() {
    }

    @Override // d.b.i0.i2.e
    public void stopPlay() {
        AlaVideoContainer alaVideoContainer = this.f62191e;
        if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
            this.f62191e.getVideoView().stopPlayback();
            this.f62191e.p();
            f fVar = this.i;
            if (fVar != null) {
                fVar.n();
            }
        }
        this.f62194h = false;
    }
}
