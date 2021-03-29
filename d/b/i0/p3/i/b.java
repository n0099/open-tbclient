package d.b.i0.p3.i;

import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f58928a;

    /* renamed from: b  reason: collision with root package name */
    public final d f58929b;

    /* loaded from: classes5.dex */
    public class a implements d.b.i0.p3.i.i.a<CloudMusicData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.p3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            b.this.f58929b.displayLoading(false);
            if (cloudMusicData != null) {
                b.this.f58929b.displayNoDataView(false);
                if (cloudMusicData.tag_list.isEmpty()) {
                    b.this.f58929b.displayNoDataView(true);
                    return;
                } else {
                    b.this.f58929b.showCloudMusicWithTagData(cloudMusicData);
                    return;
                }
            }
            b.this.f58929b.displayNoDataView(true);
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        this.f58928a = cloudMusicModel;
        this.f58929b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.b.i0.p3.i.c
    public void a() {
        this.f58928a.cancelLoadData();
    }

    @Override // d.b.i0.p3.i.c
    public void b() {
        this.f58929b.displayLoading(true);
        this.f58928a.t(new a());
    }
}
