package d.b.j0.q0.p2;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public h f60405a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f60406b;

    /* renamed from: c  reason: collision with root package name */
    public String f60407c;

    /* renamed from: d  reason: collision with root package name */
    public String f60408d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60409e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f60410f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f60411g = new a();

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            if (i.this.f60405a == null) {
                return;
            }
            i.this.f60405a.n();
            i.this.f60405a.c(str);
            i.this.f60405a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            if (i.this.f60405a == null) {
                return;
            }
            i.this.f60405a.n();
            i.this.f60409e = z;
            i.this.f60405a.a(list, z, false);
        }
    }

    public i(h hVar) {
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f60405a = hVar;
            hVar.c0(this);
            this.f60406b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f60411g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel = this.f60406b;
        if (videoMiddleModel != null) {
            videoMiddleModel.cancelLoadData();
        }
    }

    public int d() {
        VideoMiddleModel videoMiddleModel = this.f60406b;
        if (videoMiddleModel != null) {
            return videoMiddleModel.w();
        }
        return 0;
    }

    public VideoSerializeVideoThreadInfo e() {
        return this.f60410f;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel = this.f60406b;
        if (videoMiddleModel == null || !this.f60409e) {
            return;
        }
        videoMiddleModel.setFrom(this.f60408d);
        this.f60406b.LoadData();
    }

    public void g() {
        VideoMiddleModel videoMiddleModel = this.f60406b;
        if (videoMiddleModel != null) {
            videoMiddleModel.setFrom(this.f60408d);
            this.f60406b.LoadData();
        }
    }

    public void h(String str) {
        this.f60408d = str;
    }

    public void i(String str) {
        this.f60407c = str;
        VideoMiddleModel videoMiddleModel = this.f60406b;
        if (videoMiddleModel != null) {
            videoMiddleModel.x(str);
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel = this.f60406b;
        if (videoMiddleModel != null) {
            videoMiddleModel.y(str);
        }
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel = this.f60406b;
        if (videoMiddleModel != null) {
            videoMiddleModel.z(str);
        }
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.f60410f = videoSerializeVideoThreadInfo;
        VideoMiddleModel videoMiddleModel = this.f60406b;
        if (videoMiddleModel != null) {
            videoMiddleModel.A(videoSerializeVideoThreadInfo);
        }
    }
}
