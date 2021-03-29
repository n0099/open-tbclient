package d.b.i0.p0.o2;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public h f58311a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f58312b;

    /* renamed from: c  reason: collision with root package name */
    public String f58313c;

    /* renamed from: d  reason: collision with root package name */
    public String f58314d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58315e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f58316f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f58317g = new a();

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            if (i.this.f58311a == null) {
                return;
            }
            i.this.f58311a.n();
            i.this.f58311a.c(str);
            i.this.f58311a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            if (i.this.f58311a == null) {
                return;
            }
            i.this.f58311a.n();
            i.this.f58315e = z;
            i.this.f58311a.a(list, z, false);
        }
    }

    public i(h hVar) {
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f58311a = hVar;
            hVar.c0(this);
            this.f58312b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f58317g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel = this.f58312b;
        if (videoMiddleModel != null) {
            videoMiddleModel.cancelLoadData();
        }
    }

    public int d() {
        VideoMiddleModel videoMiddleModel = this.f58312b;
        if (videoMiddleModel != null) {
            return videoMiddleModel.w();
        }
        return 0;
    }

    public VideoSerializeVideoThreadInfo e() {
        return this.f58316f;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel = this.f58312b;
        if (videoMiddleModel == null || !this.f58315e) {
            return;
        }
        videoMiddleModel.setFrom(this.f58314d);
        this.f58312b.LoadData();
    }

    public void g() {
        VideoMiddleModel videoMiddleModel = this.f58312b;
        if (videoMiddleModel != null) {
            videoMiddleModel.setFrom(this.f58314d);
            this.f58312b.LoadData();
        }
    }

    public void h(String str) {
        this.f58314d = str;
    }

    public void i(String str) {
        this.f58313c = str;
        VideoMiddleModel videoMiddleModel = this.f58312b;
        if (videoMiddleModel != null) {
            videoMiddleModel.x(str);
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel = this.f58312b;
        if (videoMiddleModel != null) {
            videoMiddleModel.y(str);
        }
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel = this.f58312b;
        if (videoMiddleModel != null) {
            videoMiddleModel.z(str);
        }
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.f58316f = videoSerializeVideoThreadInfo;
        VideoMiddleModel videoMiddleModel = this.f58312b;
        if (videoMiddleModel != null) {
            videoMiddleModel.A(videoSerializeVideoThreadInfo);
        }
    }
}
