package d.a.j0.q0.i1;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public d f57846a;

    /* renamed from: b  reason: collision with root package name */
    public String f57847b;

    /* renamed from: c  reason: collision with root package name */
    public VideoAggregationModel f57848c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57849d;

    /* renamed from: e  reason: collision with root package name */
    public VideoAggregationModel.c f57850e;

    /* loaded from: classes4.dex */
    public class a implements VideoAggregationModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            if (i.this.f57846a == null) {
                return;
            }
            i.this.f57846a.n();
            i.this.f57846a.c(str);
            i.this.f57846a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<g> list, boolean z, boolean z2) {
            if (i.this.f57846a == null) {
                return;
            }
            i.this.f57846a.n();
            i.this.f57849d = z2;
            i.this.f57846a.d(list, z, z2);
        }
    }

    public i(TbPageContext tbPageContext, d dVar) {
        a aVar = new a();
        this.f57850e = aVar;
        this.f57846a = dVar;
        this.f57848c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void c() {
        VideoAggregationModel videoAggregationModel = this.f57848c;
        if (videoAggregationModel != null) {
            videoAggregationModel.cancelLoadData();
        }
    }

    public void d() {
        VideoAggregationModel videoAggregationModel = this.f57848c;
        if (videoAggregationModel == null || !this.f57849d) {
            return;
        }
        videoAggregationModel.LoadData();
    }

    public void e() {
        VideoAggregationModel videoAggregationModel = this.f57848c;
        if (videoAggregationModel != null) {
            videoAggregationModel.w();
        }
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel = this.f57848c;
        if (videoAggregationModel != null) {
            videoAggregationModel.setFrom(str);
        }
    }

    public void g(String str) {
        this.f57847b = str;
        VideoAggregationModel videoAggregationModel = this.f57848c;
        if (videoAggregationModel != null) {
            videoAggregationModel.x(str);
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel = this.f57848c;
        if (videoAggregationModel != null) {
            videoAggregationModel.y(str);
        }
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel = this.f57848c;
        if (videoAggregationModel != null) {
            videoAggregationModel.z(str);
        }
    }
}
