package d.a.o0.m0;

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
        public final /* synthetic */ AtomicInteger f61132a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f61133b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f61134c;

        public a(o oVar, AtomicInteger atomicInteger, List list, c cVar) {
            this.f61132a = atomicInteger;
            this.f61133b = list;
            this.f61134c = cVar;
        }

        @Override // d.a.o0.m0.o.d
        public void a(ImageUploadResult imageUploadResult) {
            ImageUploadResult.picInfo picinfo;
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            this.f61132a.decrementAndGet();
            if (imageUploadResult != null && (picinfo = imageUploadResult.picInfo) != null && (picDetailedInfo = picinfo.bigPic) != null && !TextUtils.isEmpty(picDetailedInfo.picUrl)) {
                this.f61133b.add(imageUploadResult.picInfo.bigPic.picUrl);
            }
            if (this.f61132a.get() == 0) {
                if (!ListUtils.isEmpty(this.f61133b)) {
                    this.f61134c.c(this.f61133b);
                } else {
                    this.f61134c.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f61135e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f61136f;

        public b(o oVar, ImageFileInfo imageFileInfo, d dVar) {
            this.f61135e = imageFileInfo;
            this.f61136f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String filePath = this.f61135e.getFilePath();
            d.a.n0.b0.f fVar = new d.a.n0.b0.f("from_user_collect");
            if (this.f61135e.isGif()) {
                this.f61136f.a(fVar.k(filePath, true, false));
                return;
            }
            Bitmap b2 = d.a.o0.z1.g.b.b(this.f61135e);
            if (b2 == null) {
                this.f61136f.a(null);
                return;
            }
            String saveFile = FileHelper.saveFile(TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath(), "face_" + Math.abs(filePath.hashCode()), b2, 60);
            b2.recycle();
            if (TextUtils.isEmpty(saveFile)) {
                this.f61136f.a(null);
                return;
            }
            ImageUploadResult k = fVar.k(saveFile, false, false);
            FileHelper.deleteFile(new File(saveFile));
            this.f61136f.a(k);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void c(List<String> list);

        void d();
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
        d.a.o0.z1.a.b().a(new b(this, imageFileInfo, dVar));
    }
}
