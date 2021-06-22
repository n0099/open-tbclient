package d.a.o0.r0.p2;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public h f63197a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f63198b;

    /* renamed from: c  reason: collision with root package name */
    public String f63199c;

    /* renamed from: d  reason: collision with root package name */
    public String f63200d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63201e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f63202f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f63203g = new a();

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            if (i.this.f63197a == null) {
                return;
            }
            i.this.f63197a.o();
            i.this.f63197a.c(str);
            i.this.f63197a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            if (i.this.f63197a == null) {
                return;
            }
            i.this.f63197a.o();
            i.this.f63201e = z;
            i.this.f63197a.d(list, z, false);
        }
    }

    public i(h hVar) {
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f63197a = hVar;
            hVar.p0(this);
            this.f63198b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f63203g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel = this.f63198b;
        if (videoMiddleModel != null) {
            videoMiddleModel.cancelLoadData();
        }
    }

    public int d() {
        VideoMiddleModel videoMiddleModel = this.f63198b;
        if (videoMiddleModel != null) {
            return videoMiddleModel.A();
        }
        return 0;
    }

    public VideoSerializeVideoThreadInfo e() {
        return this.f63202f;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel = this.f63198b;
        if (videoMiddleModel == null || !this.f63201e) {
            return;
        }
        videoMiddleModel.setFrom(this.f63200d);
        this.f63198b.LoadData();
    }

    public void g() {
        VideoMiddleModel videoMiddleModel = this.f63198b;
        if (videoMiddleModel != null) {
            videoMiddleModel.setFrom(this.f63200d);
            this.f63198b.LoadData();
        }
    }

    public void h(String str) {
        this.f63200d = str;
    }

    public void i(String str) {
        this.f63199c = str;
        VideoMiddleModel videoMiddleModel = this.f63198b;
        if (videoMiddleModel != null) {
            videoMiddleModel.B(str);
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel = this.f63198b;
        if (videoMiddleModel != null) {
            videoMiddleModel.C(str);
        }
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel = this.f63198b;
        if (videoMiddleModel != null) {
            videoMiddleModel.D(str);
        }
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.f63202f = videoSerializeVideoThreadInfo;
        VideoMiddleModel videoMiddleModel = this.f63198b;
        if (videoMiddleModel != null) {
            videoMiddleModel.E(videoSerializeVideoThreadInfo);
        }
    }
}
