package d.a.j0.x.d0;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import d.a.i0.r.q.a2;
import d.a.j0.j2.e;
import d.a.j0.j2.f;
/* loaded from: classes4.dex */
public class a implements e {

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f62449e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f62450f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f62451g;

    /* renamed from: i  reason: collision with root package name */
    public f f62453i;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62452h = false;
    public f.b j = new C1662a();

    /* renamed from: d.a.j0.x.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1662a implements f.b {
        public C1662a() {
        }

        @Override // d.a.j0.j2.f.b
        public void a() {
            a.this.b();
        }
    }

    public a(AlaVideoContainer alaVideoContainer) {
        this.f62449e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.f62453i = fVar;
            fVar.l(this.f62449e.getVideoView());
            this.f62453i.i(this.j);
        }
    }

    @Override // d.a.j0.j2.e
    public boolean C() {
        return false;
    }

    public final void b() {
        a2 a2Var = this.f62450f;
        if (a2Var == null || a2Var.u1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer = this.f62449e;
        if (alaVideoContainer != null) {
            alaVideoContainer.q();
        }
    }

    public void d(a2 a2Var, String str, String str2, boolean z) {
        if (a2Var == null) {
            return;
        }
        this.f62450f = a2Var;
        if (this.f62449e == null || a2Var.q1() == null) {
            return;
        }
        AlaInfoData q1 = this.f62450f.q1();
        this.f62451g = q1;
        this.f62449e.setVideoThumbnail(q1.cover);
        if (z) {
            this.f62449e.setTitle(this.f62450f.x1());
        } else {
            this.f62449e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f62449e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f62450f.q1().audience_count)));
    }

    @Override // d.a.j0.j2.e
    public int getCurrentPosition() {
        AlaVideoContainer alaVideoContainer = this.f62449e;
        if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
            return 0;
        }
        return this.f62449e.getVideoView().getCurrentPositionSync();
    }

    @Override // d.a.j0.j2.e
    public String getPlayUrl() {
        a2 a2Var = this.f62450f;
        if (a2Var == null || a2Var.u1() == null) {
            return null;
        }
        return this.f62450f.u1().video_url;
    }

    @Override // d.a.j0.j2.e
    public View getVideoContainer() {
        AlaVideoContainer alaVideoContainer = this.f62449e;
        if (alaVideoContainer != null) {
            return alaVideoContainer.getView();
        }
        return null;
    }

    @Override // d.a.j0.j2.e
    public boolean isPlayStarted() {
        return this.f62452h;
    }

    @Override // d.a.j0.j2.e
    public boolean isPlaying() {
        return false;
    }

    @Override // d.a.j0.j2.e
    public void startPlay() {
    }

    @Override // d.a.j0.j2.e
    public void stopPlay() {
        AlaVideoContainer alaVideoContainer = this.f62449e;
        if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
            this.f62449e.getVideoView().stopPlayback();
            this.f62449e.p();
            f fVar = this.f62453i;
            if (fVar != null) {
                fVar.n();
            }
        }
        this.f62452h = false;
    }
}
