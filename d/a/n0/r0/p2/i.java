package d.a.n0.r0.p2;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public h f59381a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f59382b;

    /* renamed from: c  reason: collision with root package name */
    public String f59383c;

    /* renamed from: d  reason: collision with root package name */
    public String f59384d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59385e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f59386f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f59387g = new a();

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            if (i.this.f59381a == null) {
                return;
            }
            i.this.f59381a.n();
            i.this.f59381a.c(str);
            i.this.f59381a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            if (i.this.f59381a == null) {
                return;
            }
            i.this.f59381a.n();
            i.this.f59385e = z;
            i.this.f59381a.d(list, z, false);
        }
    }

    public i(h hVar) {
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f59381a = hVar;
            hVar.m0(this);
            this.f59382b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f59387g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel = this.f59382b;
        if (videoMiddleModel != null) {
            videoMiddleModel.cancelLoadData();
        }
    }

    public int d() {
        VideoMiddleModel videoMiddleModel = this.f59382b;
        if (videoMiddleModel != null) {
            return videoMiddleModel.w();
        }
        return 0;
    }

    public VideoSerializeVideoThreadInfo e() {
        return this.f59386f;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel = this.f59382b;
        if (videoMiddleModel == null || !this.f59385e) {
            return;
        }
        videoMiddleModel.setFrom(this.f59384d);
        this.f59382b.LoadData();
    }

    public void g() {
        VideoMiddleModel videoMiddleModel = this.f59382b;
        if (videoMiddleModel != null) {
            videoMiddleModel.setFrom(this.f59384d);
            this.f59382b.LoadData();
        }
    }

    public void h(String str) {
        this.f59384d = str;
    }

    public void i(String str) {
        this.f59383c = str;
        VideoMiddleModel videoMiddleModel = this.f59382b;
        if (videoMiddleModel != null) {
            videoMiddleModel.x(str);
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel = this.f59382b;
        if (videoMiddleModel != null) {
            videoMiddleModel.y(str);
        }
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel = this.f59382b;
        if (videoMiddleModel != null) {
            videoMiddleModel.z(str);
        }
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.f59386f = videoSerializeVideoThreadInfo;
        VideoMiddleModel videoMiddleModel = this.f59382b;
        if (videoMiddleModel != null) {
            videoMiddleModel.A(videoSerializeVideoThreadInfo);
        }
    }
}
