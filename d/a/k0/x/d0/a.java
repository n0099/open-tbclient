package d.a.k0.x.d0;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import d.a.j0.r.q.a2;
import d.a.k0.j2.e;
import d.a.k0.j2.f;
/* loaded from: classes4.dex */
public class a implements e {

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f63173e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f63174f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f63175g;

    /* renamed from: i  reason: collision with root package name */
    public f f63177i;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63176h = false;
    public f.b j = new C1727a();

    /* renamed from: d.a.k0.x.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1727a implements f.b {
        public C1727a() {
        }

        @Override // d.a.k0.j2.f.b
        public void a() {
            a.this.b();
        }
    }

    public a(AlaVideoContainer alaVideoContainer) {
        this.f63173e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.f63177i = fVar;
            fVar.l(this.f63173e.getVideoView());
            this.f63177i.i(this.j);
        }
    }

    @Override // d.a.k0.j2.e
    public boolean C() {
        return false;
    }

    public final void b() {
        a2 a2Var = this.f63174f;
        if (a2Var == null || a2Var.v1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer = this.f63173e;
        if (alaVideoContainer != null) {
            alaVideoContainer.q();
        }
    }

    public void d(a2 a2Var, String str, String str2, boolean z) {
        if (a2Var == null) {
            return;
        }
        this.f63174f = a2Var;
        if (this.f63173e == null || a2Var.q1() == null) {
            return;
        }
        AlaInfoData q1 = this.f63174f.q1();
        this.f63175g = q1;
        this.f63173e.setVideoThumbnail(q1.cover);
        if (z) {
            this.f63173e.setTitle(this.f63174f.y1());
        } else {
            this.f63173e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f63173e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f63174f.q1().audience_count)));
    }

    @Override // d.a.k0.j2.e
    public int getCurrentPosition() {
        AlaVideoContainer alaVideoContainer = this.f63173e;
        if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
            return 0;
        }
        return this.f63173e.getVideoView().getCurrentPositionSync();
    }

    @Override // d.a.k0.j2.e
    public String getPlayUrl() {
        a2 a2Var = this.f63174f;
        if (a2Var == null || a2Var.v1() == null) {
            return null;
        }
        return this.f63174f.v1().video_url;
    }

    @Override // d.a.k0.j2.e
    public View getVideoContainer() {
        AlaVideoContainer alaVideoContainer = this.f63173e;
        if (alaVideoContainer != null) {
            return alaVideoContainer.getView();
        }
        return null;
    }

    @Override // d.a.k0.j2.e
    public boolean isPlayStarted() {
        return this.f63176h;
    }

    @Override // d.a.k0.j2.e
    public boolean isPlaying() {
        return false;
    }

    @Override // d.a.k0.j2.e
    public void startPlay() {
    }

    @Override // d.a.k0.j2.e
    public void stopPlay() {
        AlaVideoContainer alaVideoContainer = this.f63173e;
        if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
            this.f63173e.getVideoView().stopPlayback();
            this.f63173e.p();
            f fVar = this.f63177i;
            if (fVar != null) {
                fVar.n();
            }
        }
        this.f63176h = false;
    }
}
