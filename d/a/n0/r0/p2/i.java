package d.a.n0.r0.p2;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public h f63072a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f63073b;

    /* renamed from: c  reason: collision with root package name */
    public String f63074c;

    /* renamed from: d  reason: collision with root package name */
    public String f63075d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63076e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f63077f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f63078g = new a();

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            if (i.this.f63072a == null) {
                return;
            }
            i.this.f63072a.o();
            i.this.f63072a.c(str);
            i.this.f63072a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            if (i.this.f63072a == null) {
                return;
            }
            i.this.f63072a.o();
            i.this.f63076e = z;
            i.this.f63072a.d(list, z, false);
        }
    }

    public i(h hVar) {
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f63072a = hVar;
            hVar.p0(this);
            this.f63073b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f63078g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel = this.f63073b;
        if (videoMiddleModel != null) {
            videoMiddleModel.cancelLoadData();
        }
    }

    public int d() {
        VideoMiddleModel videoMiddleModel = this.f63073b;
        if (videoMiddleModel != null) {
            return videoMiddleModel.A();
        }
        return 0;
    }

    public VideoSerializeVideoThreadInfo e() {
        return this.f63077f;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel = this.f63073b;
        if (videoMiddleModel == null || !this.f63076e) {
            return;
        }
        videoMiddleModel.setFrom(this.f63075d);
        this.f63073b.LoadData();
    }

    public void g() {
        VideoMiddleModel videoMiddleModel = this.f63073b;
        if (videoMiddleModel != null) {
            videoMiddleModel.setFrom(this.f63075d);
            this.f63073b.LoadData();
        }
    }

    public void h(String str) {
        this.f63075d = str;
    }

    public void i(String str) {
        this.f63074c = str;
        VideoMiddleModel videoMiddleModel = this.f63073b;
        if (videoMiddleModel != null) {
            videoMiddleModel.B(str);
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel = this.f63073b;
        if (videoMiddleModel != null) {
            videoMiddleModel.C(str);
        }
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel = this.f63073b;
        if (videoMiddleModel != null) {
            videoMiddleModel.D(str);
        }
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.f63077f = videoSerializeVideoThreadInfo;
        VideoMiddleModel videoMiddleModel = this.f63073b;
        if (videoMiddleModel != null) {
            videoMiddleModel.E(videoSerializeVideoThreadInfo);
        }
    }
}
