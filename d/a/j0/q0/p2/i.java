package d.a.j0.q0.p2;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public h f58498a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f58499b;

    /* renamed from: c  reason: collision with root package name */
    public String f58500c;

    /* renamed from: d  reason: collision with root package name */
    public String f58501d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58502e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f58503f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f58504g = new a();

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            if (i.this.f58498a == null) {
                return;
            }
            i.this.f58498a.n();
            i.this.f58498a.c(str);
            i.this.f58498a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            if (i.this.f58498a == null) {
                return;
            }
            i.this.f58498a.n();
            i.this.f58502e = z;
            i.this.f58498a.d(list, z, false);
        }
    }

    public i(h hVar) {
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f58498a = hVar;
            hVar.m0(this);
            this.f58499b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f58504g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel = this.f58499b;
        if (videoMiddleModel != null) {
            videoMiddleModel.cancelLoadData();
        }
    }

    public int d() {
        VideoMiddleModel videoMiddleModel = this.f58499b;
        if (videoMiddleModel != null) {
            return videoMiddleModel.w();
        }
        return 0;
    }

    public VideoSerializeVideoThreadInfo e() {
        return this.f58503f;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel = this.f58499b;
        if (videoMiddleModel == null || !this.f58502e) {
            return;
        }
        videoMiddleModel.setFrom(this.f58501d);
        this.f58499b.LoadData();
    }

    public void g() {
        VideoMiddleModel videoMiddleModel = this.f58499b;
        if (videoMiddleModel != null) {
            videoMiddleModel.setFrom(this.f58501d);
            this.f58499b.LoadData();
        }
    }

    public void h(String str) {
        this.f58501d = str;
    }

    public void i(String str) {
        this.f58500c = str;
        VideoMiddleModel videoMiddleModel = this.f58499b;
        if (videoMiddleModel != null) {
            videoMiddleModel.x(str);
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel = this.f58499b;
        if (videoMiddleModel != null) {
            videoMiddleModel.y(str);
        }
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel = this.f58499b;
        if (videoMiddleModel != null) {
            videoMiddleModel.z(str);
        }
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.f58503f = videoSerializeVideoThreadInfo;
        VideoMiddleModel videoMiddleModel = this.f58499b;
        if (videoMiddleModel != null) {
            videoMiddleModel.A(videoSerializeVideoThreadInfo);
        }
    }
}
