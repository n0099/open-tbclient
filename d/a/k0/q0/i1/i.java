package d.a.k0.q0.i1;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public d f58588a;

    /* renamed from: b  reason: collision with root package name */
    public String f58589b;

    /* renamed from: c  reason: collision with root package name */
    public VideoAggregationModel f58590c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58591d;

    /* renamed from: e  reason: collision with root package name */
    public VideoAggregationModel.c f58592e;

    /* loaded from: classes4.dex */
    public class a implements VideoAggregationModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            if (i.this.f58588a == null) {
                return;
            }
            i.this.f58588a.n();
            i.this.f58588a.c(str);
            i.this.f58588a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<g> list, boolean z, boolean z2) {
            if (i.this.f58588a == null) {
                return;
            }
            i.this.f58588a.n();
            i.this.f58591d = z2;
            i.this.f58588a.d(list, z, z2);
        }
    }

    public i(TbPageContext tbPageContext, d dVar) {
        a aVar = new a();
        this.f58592e = aVar;
        this.f58588a = dVar;
        this.f58590c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void c() {
        VideoAggregationModel videoAggregationModel = this.f58590c;
        if (videoAggregationModel != null) {
            videoAggregationModel.cancelLoadData();
        }
    }

    public void d() {
        VideoAggregationModel videoAggregationModel = this.f58590c;
        if (videoAggregationModel == null || !this.f58591d) {
            return;
        }
        videoAggregationModel.LoadData();
    }

    public void e() {
        VideoAggregationModel videoAggregationModel = this.f58590c;
        if (videoAggregationModel != null) {
            videoAggregationModel.w();
        }
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel = this.f58590c;
        if (videoAggregationModel != null) {
            videoAggregationModel.setFrom(str);
        }
    }

    public void g(String str) {
        this.f58589b = str;
        VideoAggregationModel videoAggregationModel = this.f58590c;
        if (videoAggregationModel != null) {
            videoAggregationModel.x(str);
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel = this.f58590c;
        if (videoAggregationModel != null) {
            videoAggregationModel.y(str);
        }
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel = this.f58590c;
        if (videoAggregationModel != null) {
            videoAggregationModel.z(str);
        }
    }
}
