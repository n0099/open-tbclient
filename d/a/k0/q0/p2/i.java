package d.a.k0.q0.p2;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public h f59240a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f59241b;

    /* renamed from: c  reason: collision with root package name */
    public String f59242c;

    /* renamed from: d  reason: collision with root package name */
    public String f59243d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59244e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f59245f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f59246g = new a();

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            if (i.this.f59240a == null) {
                return;
            }
            i.this.f59240a.n();
            i.this.f59240a.c(str);
            i.this.f59240a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            if (i.this.f59240a == null) {
                return;
            }
            i.this.f59240a.n();
            i.this.f59244e = z;
            i.this.f59240a.d(list, z, false);
        }
    }

    public i(h hVar) {
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f59240a = hVar;
            hVar.m0(this);
            this.f59241b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f59246g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel = this.f59241b;
        if (videoMiddleModel != null) {
            videoMiddleModel.cancelLoadData();
        }
    }

    public int d() {
        VideoMiddleModel videoMiddleModel = this.f59241b;
        if (videoMiddleModel != null) {
            return videoMiddleModel.w();
        }
        return 0;
    }

    public VideoSerializeVideoThreadInfo e() {
        return this.f59245f;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel = this.f59241b;
        if (videoMiddleModel == null || !this.f59244e) {
            return;
        }
        videoMiddleModel.setFrom(this.f59243d);
        this.f59241b.LoadData();
    }

    public void g() {
        VideoMiddleModel videoMiddleModel = this.f59241b;
        if (videoMiddleModel != null) {
            videoMiddleModel.setFrom(this.f59243d);
            this.f59241b.LoadData();
        }
    }

    public void h(String str) {
        this.f59243d = str;
    }

    public void i(String str) {
        this.f59242c = str;
        VideoMiddleModel videoMiddleModel = this.f59241b;
        if (videoMiddleModel != null) {
            videoMiddleModel.x(str);
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel = this.f59241b;
        if (videoMiddleModel != null) {
            videoMiddleModel.y(str);
        }
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel = this.f59241b;
        if (videoMiddleModel != null) {
            videoMiddleModel.z(str);
        }
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.f59245f = videoSerializeVideoThreadInfo;
        VideoMiddleModel videoMiddleModel = this.f59241b;
        if (videoMiddleModel != null) {
            videoMiddleModel.A(videoSerializeVideoThreadInfo);
        }
    }
}
