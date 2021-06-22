package d.a.o0.r3.h;

import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f63848a;

    /* renamed from: b  reason: collision with root package name */
    public final d f63849b;

    /* loaded from: classes5.dex */
    public class a implements d.a.o0.r3.h.i.a<CloudMusicData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.r3.h.i.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            b.this.f63849b.displayLoading(false);
            if (cloudMusicData != null) {
                b.this.f63849b.displayNoDataView(false);
                if (cloudMusicData.tag_list.isEmpty()) {
                    b.this.f63849b.displayNoDataView(true);
                    return;
                } else {
                    b.this.f63849b.showCloudMusicWithTagData(cloudMusicData);
                    return;
                }
            }
            b.this.f63849b.displayNoDataView(true);
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        this.f63848a = cloudMusicModel;
        this.f63849b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.a.o0.r3.h.c
    public void a() {
        this.f63849b.displayLoading(true);
        this.f63848a.x(new a());
    }

    @Override // d.a.o0.r3.h.c
    public void cancelLoadData() {
        this.f63848a.cancelLoadData();
    }
}
