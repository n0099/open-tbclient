package d.b.j0.l0;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class o {

    /* loaded from: classes4.dex */
    public class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f58416a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f58417b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f58418c;

        public a(o oVar, AtomicInteger atomicInteger, List list, c cVar) {
            this.f58416a = atomicInteger;
            this.f58417b = list;
            this.f58418c = cVar;
        }

        @Override // d.b.j0.l0.o.d
        public void a(ImageUploadResult imageUploadResult) {
            ImageUploadResult.picInfo picinfo;
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            this.f58416a.decrementAndGet();
            if (imageUploadResult != null && (picinfo = imageUploadResult.picInfo) != null && (picDetailedInfo = picinfo.bigPic) != null && !TextUtils.isEmpty(picDetailedInfo.picUrl)) {
                this.f58417b.add(imageUploadResult.picInfo.bigPic.picUrl);
            }
            if (this.f58416a.get() == 0) {
                if (!ListUtils.isEmpty(this.f58417b)) {
                    this.f58418c.e(this.f58417b);
                } else {
                    this.f58418c.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f58419e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f58420f;

        public b(o oVar, ImageFileInfo imageFileInfo, d dVar) {
            this.f58419e = imageFileInfo;
            this.f58420f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String filePath = this.f58419e.getFilePath();
            d.b.i0.b0.f fVar = new d.b.i0.b0.f("from_user_collect");
            if (this.f58419e.isGif()) {
                this.f58420f.a(fVar.k(filePath, true, false));
                return;
            }
            Bitmap b2 = d.b.j0.y1.g.b.b(this.f58419e);
            if (b2 == null) {
                this.f58420f.a(null);
                return;
            }
            String saveFile = FileHelper.saveFile(TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath(), "face_" + Math.abs(filePath.hashCode()), b2, 60);
            b2.recycle();
            if (TextUtils.isEmpty(saveFile)) {
                this.f58420f.a(null);
                return;
            }
            ImageUploadResult k = fVar.k(saveFile, false, false);
            FileHelper.deleteFile(new File(saveFile));
            this.f58420f.a(k);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void b();

        void e(List<String> list);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(ImageUploadResult imageUploadResult);
    }

    public void a(ArrayList<ImageFileInfo> arrayList, c cVar) {
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        Iterator<ImageFileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            b(it.next(), new a(this, atomicInteger, arrayList2, cVar));
        }
    }

    public final void b(ImageFileInfo imageFileInfo, d dVar) {
        d.b.j0.y1.a.b().a(new b(this, imageFileInfo, dVar));
    }
}
