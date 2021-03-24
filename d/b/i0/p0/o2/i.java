package d.b.i0.p0.o2;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public h f58310a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f58311b;

    /* renamed from: c  reason: collision with root package name */
    public String f58312c;

    /* renamed from: d  reason: collision with root package name */
    public String f58313d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58314e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f58315f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f58316g = new a();

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            if (i.this.f58310a == null) {
                return;
            }
            i.this.f58310a.n();
            i.this.f58310a.c(str);
            i.this.f58310a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            if (i.this.f58310a == null) {
                return;
            }
            i.this.f58310a.n();
            i.this.f58314e = z;
            i.this.f58310a.a(list, z, false);
        }
    }

    public i(h hVar) {
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f58310a = hVar;
            hVar.c0(this);
            this.f58311b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f58316g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel = this.f58311b;
        if (videoMiddleModel != null) {
            videoMiddleModel.cancelLoadData();
        }
    }

    public int d() {
        VideoMiddleModel videoMiddleModel = this.f58311b;
        if (videoMiddleModel != null) {
            return videoMiddleModel.w();
        }
        return 0;
    }

    public VideoSerializeVideoThreadInfo e() {
        return this.f58315f;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel = this.f58311b;
        if (videoMiddleModel == null || !this.f58314e) {
            return;
        }
        videoMiddleModel.setFrom(this.f58313d);
        this.f58311b.LoadData();
    }

    public void g() {
        VideoMiddleModel videoMiddleModel = this.f58311b;
        if (videoMiddleModel != null) {
            videoMiddleModel.setFrom(this.f58313d);
            this.f58311b.LoadData();
        }
    }

    public void h(String str) {
        this.f58313d = str;
    }

    public void i(String str) {
        this.f58312c = str;
        VideoMiddleModel videoMiddleModel = this.f58311b;
        if (videoMiddleModel != null) {
            videoMiddleModel.x(str);
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel = this.f58311b;
        if (videoMiddleModel != null) {
            videoMiddleModel.y(str);
        }
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel = this.f58311b;
        if (videoMiddleModel != null) {
            videoMiddleModel.z(str);
        }
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.f58315f = videoSerializeVideoThreadInfo;
        VideoMiddleModel videoMiddleModel = this.f58311b;
        if (videoMiddleModel != null) {
            videoMiddleModel.A(videoSerializeVideoThreadInfo);
        }
    }
}
